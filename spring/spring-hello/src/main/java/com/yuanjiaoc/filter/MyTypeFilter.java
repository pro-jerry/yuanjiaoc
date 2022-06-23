package com.yuanjiaoc.filter;

import java.io.IOException;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
 * 自定义Bean过滤规则.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月22日
 */
public class MyTypeFilter implements TypeFilter {

  /**
   * @param metadataReader 读取到当前正在扫描的类的信息
   * @param metadataReaderFactory 可以获取到其他类的信息
   * @return
   * @throws IOException
   */
  @Override
  public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
      throws IOException {
    // 获取当前类的注解信息
    AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
    // 获取当前正在扫描的类的信息
    ClassMetadata classMetadata = metadataReader.getClassMetadata();
    // 获取当前类的资源信息,例如:类的路径等信息
    Resource resource = metadataReader.getResource();
    // 获取当前正在扫描的类名
    String className = classMetadata.getClassName();
    // 打印当前正在扫描的类名
    System.out.println("----->" + className);
    return className.contains("Person");
  }
}
