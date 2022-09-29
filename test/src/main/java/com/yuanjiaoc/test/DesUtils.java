package com.yuanjiaoc.test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 用户鉴权的加密解密Utils.
 */
public class DesUtils {

    /**
     * 加密
     *
     * @param srcStr
     * @param sKey
     * @return
     */
    public static String encrypt(String srcStr, String sKey) {
        return encrypt(srcStr, StandardCharsets.UTF_8, sKey);
    }

    /**
     * 加密
     *
     * @param srcStr
     * @param charset
     * @param sKey
     * @return
     */
    public static String encrypt(String srcStr, Charset charset, String sKey) {
        byte[] src = srcStr.getBytes(charset);
        byte[] buf = Des.encrypt(src, sKey);
        return Des.parseByte2HexStr(buf);
    }

    /**
     * 解密
     *
     * @param hexStr
     * @param sKey
     * @return
     * @throws Exception
     */
    public static String decrypt(String hexStr, String sKey) throws Exception {
        return decrypt(hexStr, StandardCharsets.UTF_8, sKey);
    }

    /**
     * 解密
     *
     * @param hexStr
     * @param sKey
     * @return
     * @throws Exception
     */
    public static String decrypt(String hexStr, Charset charset, String sKey) throws Exception {
        byte[] src = Des.parseHexStr2Byte(hexStr);
        byte[] buf = Des.decrypt(src, sKey);
        return new String(buf, charset);
    }


}
