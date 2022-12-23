package com.yuanjiaoc.aop.methodinterceptor;

import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月23日
 */

@Configuration
public class InterceptorConfig {

    public static final String traceExecution = "execution(* com.yuanjiaoc.aop.methodinterceptor..*.*(..))";

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor() {
        MyMethodInterceptor methodInterceptor = new MyMethodInterceptor();
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
//        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
//        pointcut.setExpression(traceExecution);

        //case 2
        JdkRegexpMethodPointcut pointcut2 = new JdkRegexpMethodPointcut();
        pointcut2.setPattern("com.wang.chao.micro.*");

        advisor.setPointcut(pointcut2);
        advisor.setAdvice(methodInterceptor);
        return advisor;
    }
}
