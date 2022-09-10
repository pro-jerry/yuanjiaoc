package com.yuanjiaoc.test;

import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

/**
 * 集合测试.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年08月30日
 */
public class CollectionUtilsTest {


    @Test
    public void collectionsOfmin() {
        Integer productType = Collections.min(null);
        System.out.println(productType);
    }

    @Test

    public void collection() {
        ArrayList<String> listA = new ArrayList<String>() {
            {
                add("a");
                add("b");
                add("c");
            }
        };
        ArrayList<String> listB = new ArrayList<String>() {
            {
                add("b");
                add("c");
                add("a");
            }
        };
        System.out.println(listA.equals(listB)); // false,缺点：需要先对集合进行排序

        System.out.println(
                listA.containsAll(listB)
                        && listB.containsAll(listA)); // true,交叉包含判断，缺点：无法判断集合包含相同元素的情况[a,b,c]和[a,a,b,c]
        System.out.println(
                CollectionUtils.isEqualCollection(listA, listB)); // true，推荐，使用简单入参非空即可，算法复杂度低，不用排序

        //    Collections.sort(listA);
        //    Collections.sort(listB);
        //    System.out.println(listA.equals(listB)); // true，用于佐证集合排序后可以使用该API判断相等
    }
}
