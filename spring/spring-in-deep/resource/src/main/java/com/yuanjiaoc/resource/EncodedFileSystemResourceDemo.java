package com.yuanjiaoc.resource;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;

/**
 * 带有字符编码的{@link FileSystemResource}的实例
 *
 * @author 何二白
 * @version 1.0
 * @see FileSystemResource
 * @see EncodedResource
 * @since 2022年09月24日
 */
public class EncodedFileSystemResourceDemo {

    public static void main(String[] args) throws IOException {
        String currentJavaFilePath = System.getProperty("user.dir")
                + "/spring/spring-in-deep/resource/src/main/java/com/yuanjiaoc/resource/EncodedFileSystemResourceDemo.java";
        File currentJavaFile = new File(currentJavaFilePath);
        // FileSystemResource => WritableResource => Resource
        FileSystemResource fileSystemResource = new FileSystemResource(currentJavaFilePath);
        EncodedResource encodedResource = new EncodedResource(fileSystemResource, "UTF-8");
        // 字符输入流
        try (Reader reader = encodedResource.getReader()) {
            System.out.println(IOUtils.toString(reader));
        }
    }
}
