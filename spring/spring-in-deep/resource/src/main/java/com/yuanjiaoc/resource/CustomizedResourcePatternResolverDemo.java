package com.yuanjiaoc.resource;

import com.yuanjiaoc.resource.util.ResourceUtils;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.PathMatcher;

/**
 * @author 何二白
 * @version 1.0
 * @see ResourcePatternResolver
 * @see PathMatchingResourcePatternResolver
 * @see PathMatcher
 * @since 2022年09月24日
 */
public class CustomizedResourcePatternResolverDemo {

    public static void main(String[] args) throws IOException {
        // 读取当前 package 对应的所有的 .java 文件
        // *.java
        String currentPackagePath = "/" + System.getProperty("user.dir")
                + "/spring/spring-in-deep/resource/src/main/java/com/yuanjiaoc/resource/";
        String locationPattern = currentPackagePath + "*.java";
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver(
                new FileSystemResourceLoader());

        resourcePatternResolver.setPathMatcher(new JavaFilePathMatcher());

        Resource[] resources = resourcePatternResolver.getResources(locationPattern);

        Stream.of(resources).map(ResourceUtils::getContent).forEach(System.out::println);
    }

    static class JavaFilePathMatcher implements PathMatcher {

        @Override
        public boolean isPattern(String path) {
            return path.endsWith(".java");
        }

        @Override
        public boolean match(String pattern, String path) {
            return path.endsWith(".java");
        }

        @Override
        public boolean matchStart(String pattern, String path) {
            return false;
        }

        @Override
        public String extractPathWithinPattern(String pattern, String path) {
            return null;
        }

        @Override
        public Map<String, String> extractUriTemplateVariables(String pattern, String path) {
            return null;
        }

        @Override
        public Comparator<String> getPatternComparator(String path) {
            return null;
        }

        @Override
        public String combine(String pattern1, String pattern2) {
            return null;
        }
    }
}
