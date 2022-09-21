package com.yuanjiaoc.test;

import java.util.Date;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年09月21日
 */
public class DateFormatUtilsTest {

    public static void main(String[] args) {
        System.out.println(DateFormatUtils.format(new Date(), "yyyyMMddHHmmss"));
    }
}
