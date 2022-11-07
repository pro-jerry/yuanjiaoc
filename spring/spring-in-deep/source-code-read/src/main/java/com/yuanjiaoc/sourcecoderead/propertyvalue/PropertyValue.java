package com.yuanjiaoc.sourcecoderead.propertyvalue;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

/**
 * <p>基本数值 @Value("feiyue") </p>
 * <p>SpEL表达式 @Value("#{30 - 5}")</p>
 * <p>使用 ${}获取属性文件中的值,配置文件中的值默认都加载到运行时env环境中</p>
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年10月12日
 */
@Data
@ToString
public class PropertyValue {

    @Value("feiyue")
    private String name;

    @Value("#{30 - 5}")
    private int age;

    @Value("${prop.city}")
    private String city;

    
}
