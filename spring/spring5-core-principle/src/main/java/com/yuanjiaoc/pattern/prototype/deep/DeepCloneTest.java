package com.yuanjiaoc.pattern.prototype.deep;

import java.util.ArrayList;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public class DeepCloneTest {

  public static void main(String[] args) {

    QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
    try {
      QiTianDaSheng clone = (QiTianDaSheng) qiTianDaSheng.clone();
      System.out.println("深克隆：" + (qiTianDaSheng.jinGuBang == clone.jinGuBang));
    } catch (Exception e) {
      e.printStackTrace();
    }

    QiTianDaSheng q = new QiTianDaSheng();
    QiTianDaSheng n = q.shallowClone(q);
    System.out.println("浅克隆：" + (q.jinGuBang == n.jinGuBang));
    System.out.println("浅克隆：" + q.hashCode() + "==" + n.hashCode());

    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("hello");
    ArrayList<String> cloneArrayList = (ArrayList<String>) arrayList.clone();
    System.out.println(arrayList.hashCode());
    System.out.println(cloneArrayList.hashCode());
    System.out.println(cloneArrayList);
  }
}
