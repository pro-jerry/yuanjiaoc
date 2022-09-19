package com.yuanjiaoc.cglib;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年09月19日
 */
public class CglibTest {

    public static void main(String[] args) {
        DaoProxy daoProxy = new DaoProxy();
        DaoAnotherProxy daoAnotherProxy = new DaoAnotherProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class); //setSuperclass表示设置要代理的类
        enhancer.setCallbacks(
                new Callback[]{daoProxy, daoAnotherProxy, NoOp.INSTANCE}); //setCallback表示设置回调即MethodInterceptor的实现类

        /**
         * CallbackFilter的accept方法返回的数值表示的是顺序，
         * 顺序和setCallbacks里面Proxy的顺序是一致的。
         * 再解释清楚一点，Callback数组中有三个callback，那么：
         * <p>方法名为"select"的方法返回的顺序为0，即使用Callback数组中的0位callback，即DaoProxy</p>
         * <p>方法名不为"select"的方法返回的顺序为1，即使用Callback数组中的1位callback，即DaoAnotherProxy</p>
         */
        enhancer.setCallbackFilter(new DaoFilter());

        Dao dao = (Dao) enhancer.create(); //使用create()方法生成一个代理对象
        dao.update();
        dao.select();
    }
}
