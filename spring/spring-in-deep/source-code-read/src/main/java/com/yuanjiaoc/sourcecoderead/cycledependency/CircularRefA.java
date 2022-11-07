package com.yuanjiaoc.sourcecoderead.cycledependency;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年10月22日
 */
//@Component
@Data
public class CircularRefA {

    //这里会触发CircularRefB类型的getBean操作
    @Autowired
    private CircularRefB circularRefB;

    public CircularRefA() {
        System.out.println("============CircularRefA()===========");
    }


}
