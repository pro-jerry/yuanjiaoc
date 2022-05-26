package com.yuanjiaoc.chapter03;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年05月22日
 */
public class FinalReferenceExample {

    final int[] intArray; // final是引用类型
    static FinalReferenceExample obj;

    public FinalReferenceExample (){
        intArray = new int[1];
        intArray[0] = 1;
    }

    public static void writerOne (){
        obj = new FinalReferenceExample ();
    }

    public static void writerTwo (){
        obj.intArray[0] = 2;
    }

    public static void reader (){
        if (obj != null){
            int temp1 = obj.intArray[0];
        }
    }
}
