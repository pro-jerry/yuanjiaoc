package com.yuanjiaoc.sourcecoderead.dymanicproxy.staticproxy;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月29日
 */
public class Proxy implements HttpApi {

    private HttpApi target;

    public Proxy(HttpApi httpApi) {
        this.target = httpApi;
    }

    @Override
    public String get(String url) {
        return target.get(url);
    }
}
