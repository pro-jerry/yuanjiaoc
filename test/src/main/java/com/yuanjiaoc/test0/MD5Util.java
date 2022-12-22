package com.yuanjiaoc.test0;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;

/**
 * MD5加密工具类.
 *
 * @author
 */
public class MD5Util {

    /**
     * 密码加密.
     *
     * @param rawPass 需要加密的明文
     * @return 密文
     */
    public static String encode(String rawPass) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            byte[] digest = messageDigest.digest(rawPass.getBytes(StandardCharsets.UTF_8));
            return new String(Hex.encodeHex(digest));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 判断明文密码rawPass是否与已加密密码encPass相同.
     *
     * @param rawPass 明文
     * @param encPass 密文
     * @return true 对比成功，false对比失败
     */
    public static boolean isValid(String rawPass, String encPass) {
        if (encPass == null) {
            return false;
        }
        return encPass.equals(encode(rawPass));
    }

    /**
     * 生成文件MD5加密字符串.
     *
     * @param file 需要加密的文件
     * @return fileMD5Str 文件MD5密文（32位）
     */
    public static String encodeFileMd5(File file) throws NoSuchAlgorithmException, IOException {

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer, 0, 1024)) != -1) {
                messageDigest.update(buffer, 0, length);
            }
        }
        return new String(Hex.encodeHex(messageDigest.digest()));
    }

    private MD5Util() {
    }

    public static void main(String[] args) {

        //02955dd7a02846dc970c41485cb9a5fd
        //5834dc6702adf336360a5b8cbfd396a2 Hezuo@2021
        System.out.println(encode("Hezuo@2021"));

        boolean isEqual = MD5Util.isValid("Hezuo@2021", "5834dc6702adf336360a5b8cbfd396a2");
        System.out.println(isEqual);
    }


}
