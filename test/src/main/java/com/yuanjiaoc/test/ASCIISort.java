package com.yuanjiaoc.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年10月19日
 */
public class ASCIISort {

    public static void main(String[] args) {
        //参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("version", "2.0");
        map.put("charset", "UTF-8");
        map.put("sign_type", "RSA_1_256");
        map.put("status", "0");
        map.put("message", "");

        // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
        List<Entry<String, String>> infoIds = new ArrayList<Entry<String, String>>(map.entrySet());
        Collections.sort(infoIds, new Comparator<Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return (o1.getKey()).toString().compareTo(o2.getKey());
            }
        });

        // 构造签名键值对的格式
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> item : infoIds) {
            if (item.getKey() != null || item.getKey() != "") {
                String key = item.getKey();
                String val = item.getValue();
                if (!(val == "" || val == null)) {
                    sb.append(key + "=" + val + "&");
                }
            }
        }
        //charset=UTF-8&sign_type=RSA_1_256&status=0&version=2.0&
        System.out.println(sb.toString());
    }
}
