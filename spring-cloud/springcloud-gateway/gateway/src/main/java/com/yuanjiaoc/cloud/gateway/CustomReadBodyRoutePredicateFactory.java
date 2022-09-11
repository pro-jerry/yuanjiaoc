package com.yuanjiaoc.cloud.gateway;

import java.util.List;
import java.util.function.Predicate;
import javax.annotation.PostConstruct;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.handler.AsyncPredicate;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.codec.HttpMessageReader;
import org.springframework.util.unit.DataSize;
import org.springframework.web.reactive.function.server.HandlerStrategies;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年09月11日
 */
public class CustomReadBodyRoutePredicateFactory extends AbstractRoutePredicateFactory<Config> {

    protected static final Log log = LogFactory.getLog(CustomReadBodyRoutePredicateFactory.class);
    private List<HttpMessageReader<?>> messageReaders;

    @Value("${spring.codec.max-in-memory-size}")
    private DataSize maxInMemory;

    public CustomReadBodyRoutePredicateFactory() {
        super(Config.class);
        this.messageReaders = HandlerStrategies.withDefaults().messageReaders();
    }

    public CustomReadBodyRoutePredicateFactory(List<HttpMessageReader<?>> messageReaders) {
        super(Config.class);
        this.messageReaders = messageReaders;
    }

    @PostConstruct
    private void overrideMsgReaders() {
        this.messageReaders = HandlerStrategies.builder()
                .codecs((c) -> c.defaultCodecs().maxInMemorySize((int) maxInMemory.toBytes())).build().messageReaders();
    }

    @Override
    public AsyncPredicate<ServerWebExchange> applyAsync(Config config) {

        return new AsyncPredicate<ServerWebExchange>() {
            @Override
            public Publisher<Boolean> apply(ServerWebExchange exchange) {
                Class inClass = config.getInClass();
                Object cachedBody = exchange.getAttribute("cachedRequestBodyObject");
                if (cachedBody != null) {
                    try {
                        boolean test = config.getPredicate().test(cachedBody);
                        exchange.getAttributes().put("read_body_predicate_test_attribute", test);
                        return Mono.just(test);
                    } catch (ClassCastException var6) {
                        if (CustomReadBodyRoutePredicateFactory.log.isDebugEnabled()) {
                            CustomReadBodyRoutePredicateFactory.log.debug(
                                    "Predicate test failed because class in predicate does not match the cached body object",
                                    var6);
                        }
                        return Mono.just(false);
                    }
                } else {
                    return ServerWebExchangeUtils.cacheRequestBodyAndRequest(exchange, (serverHttpRequest) -> {
                        return ServerRequest.create(exchange.mutate().request(serverHttpRequest).build(),
                                        CustomReadBodyRoutePredicateFactory.this.messageReaders).bodyToMono(inClass)
                                .doOnNext((objectValue) -> {
                                    exchange.getAttributes().put("cachedRequestBodyObject", objectValue);
                                }).map((objectValue) -> {
                                    return config.getPredicate().test(objectValue);
                                }).thenReturn(true);
                    });
                }
            }

            @Override
            public String toString() {
                return String.format("ReadBody: %s", config.getInClass());
            }
        };
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        throw new UnsupportedOperationException("ReadBodyPredicateFactory is only async.");
    }

}
