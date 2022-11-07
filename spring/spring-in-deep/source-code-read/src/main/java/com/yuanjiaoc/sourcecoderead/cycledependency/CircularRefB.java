package com.yuanjiaoc.sourcecoderead.cycledependency;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年10月22日
 */
//@Component
public class CircularRefB {

    public CircularRefB() {
        System.out.println("============CircularRefB()===========");
    }

    //又会触发A的getBean操作
    @Autowired
    private CircularRefA circularRefA;
}
