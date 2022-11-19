package com.yuanjiaoc.sourcecoderead.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月11日
 */
public class StringToBooleanConverter implements Converter {

    @Override
    public Object convert(Object source) {
        return source;
    }
}
