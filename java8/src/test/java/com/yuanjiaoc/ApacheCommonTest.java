package com.yuanjiaoc;

import java.util.ArrayList;
import org.apache.commons.collections4.CollectionUtils;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年08月05日
 */
public class ApacheCommonTest {

  public static void main(String[] args) {

    ArrayList<String> listA =
        new ArrayList<String>() {
          {
            add("a");
            add("b");
            add("c");
          }
        };
    ArrayList<String> listB =
        new ArrayList<String>() {
          {
            add("b");
            add("c");
            add("a");
          }
        };

    System.out.println(CollectionUtils.isEqualCollection(listA, listB));
  }
}
