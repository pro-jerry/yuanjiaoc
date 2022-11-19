package com.yuanjiaoc.sourcecoderead.converter;

import org.junit.Test;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月11日
 */
public class ConverterTest {

    @Test
    public void test01() {
        Converter<String, Boolean> converter = new StringToBooleanConverter();
        System.out.println(converter.convert("true"));
        System.out.println(converter.convert("1"));
    }

    @Test
    public void test02() {
        ConverterFactory<String, Number> converterFactory = new StringToNumberConverterFactory();
        System.out.println(converterFactory.getConverter(Integer.class).convert("1").getClass());
        System.out.println(converterFactory.getConverter(Double.class).convert("1.1").getClass());
    }
}
