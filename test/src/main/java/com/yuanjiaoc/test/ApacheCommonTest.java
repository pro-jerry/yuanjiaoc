package com.yuanjiaoc.test;

import java.util.Date;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年09月26日
 */
public class ApacheCommonTest {

    public static void main(String[] args) {
        String timeStamp = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
        System.out.println(timeStamp);
        String sourceDeviceCode = "cmbsHomePlatformTest";
        String sharedSecret = "5dpe5khn";
        String authenticatorSource = DigestUtils.sha256Hex(sourceDeviceCode + sharedSecret + timeStamp);
        System.out.println(authenticatorSource);
    }
}
