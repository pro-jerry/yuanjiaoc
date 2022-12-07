package com.yuanjiaoc.sourcecoderead.dymanicproxy.staticproxy;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月29日
 */
public class RealModule implements HttpApi {

    @Override
    public String get(String url) {
        return "result";
    }
}
