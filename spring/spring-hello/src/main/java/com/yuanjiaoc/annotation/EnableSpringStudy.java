package com.yuanjiaoc.annotation;

import com.yuanjiaoc.bean.SpringStudySelector;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月23日
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@Import(SpringStudySelector.class)
public @interface EnableSpringStudy {}
