package com.yuanjiaoc.resolvabletype;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import org.springframework.core.ResolvableType;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月22日
 */
public class GenericClazz {

    private HashMap<String, List<Integer>> param;

    public static void main(String[] args) throws NoSuchFieldException {
//        printParamByJdk();
        printParmaBySpring();
    }

    public static void printParamByJdk() throws NoSuchFieldException {
        Field param = GenericClazz.class.getDeclaredField("param");
        Type genericType = param.getGenericType();
        ParameterizedType type = (ParameterizedType) genericType;
        Type[] typeArguments = type.getActualTypeArguments();
        System.out.println("从 HashMap<String, List<Integer>> 中获取 String:" + typeArguments[0]);
        System.out.println("从 HashMap<String, List<Integer>> 中获取 List<Integer> :" + typeArguments[1]);
        System.out.println(
                "从 HashMap<String, List<Integer>> 中获取 List :" + ((ParameterizedType) typeArguments[1]).getRawType());
        System.out.println("从 HashMap<String, List<Integer>> 中获取 Integer:" + ((ParameterizedType) typeArguments[1])
                .getActualTypeArguments()[0]);
        System.out.println("从 HashMap<String, List<Integer>> 中获取父类型:" + param.getType().getGenericSuperclass());
    }

    private static void printParmaBySpring() throws NoSuchFieldException {
        ResolvableType param = ResolvableType.forField(GenericClazz.class.getDeclaredField("param"));
        System.out.println("从 HashMap<String, List<Integer>> 中获取 String:" + param.getGeneric(0).resolve());
        System.out.println("从 HashMap<String, List<Integer>> 中获取 List<Integer> :" + param.getGeneric(1));
        System.out.println(
                "从 HashMap<String, List<Integer>> 中获取 List :" + param.getGeneric(1).resolve());
        System.out.println("从 HashMap<String, List<Integer>> 中获取 Integer:" + param.getGeneric(1, 0));
        System.out.println("从 HashMap<String, List<Integer>> 中获取父类型:" + param.getSuperType());
    }
}
