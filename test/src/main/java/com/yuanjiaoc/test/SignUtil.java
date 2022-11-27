package com.yuanjiaoc.test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.util.DigestUtils;

public final class SignUtil {

    private SignUtil() {
    }

    /**
     * 生成签名
     *
     * @param paramBean 参数bean
     * @param key       密钥
     * @return 签名
     */
    public static String signPlainBean(Object paramBean, String key) {
        Map<String, Object> params = beanToMap(paramBean);

        return makeSign(params, key);
    }

    /**
     * 生成签名
     *
     * @param params params
     * @param key    key
     * @return sign
     */
    public static String makeSign(Map<String, Object> params, String key) {
        List<String> keyValues = new ArrayList<>();
        params.forEach(
                (k, v) -> {
                    if (null != v && StringUtils.isNotEmpty(String.valueOf(v))) {
                        keyValues.add(k + "=" + v);
                    }
                });
        keyValues.sort(Comparator.naturalOrder());
        String tmp = String.join("&", keyValues).concat(key);
        System.out.println("------tmp------");
        System.out.println(tmp);
        return DigestUtils.md5DigestAsHex(tmp.getBytes());
    }

    /**
     * 生成签名
     *
     * @param params params
     * @return sign
     */
    public static String makeSign(Map<String, Object> params) {
        List<String> keyValues = new ArrayList<>();
        params.forEach(
                (k, v) -> {
                    if (null != v && StringUtils.isNotEmpty(String.valueOf(v))) {
                        keyValues.add(k + "=" + v);
                    }
                });
        keyValues.sort(Comparator.naturalOrder());
        String tmp = String.join("&", keyValues);
        return DigestUtils.md5DigestAsHex(tmp.getBytes());
    }

    /**
     * 生成签名.
     *
     * @param params 参数.
     * @param isSort 是否排序
     * @return sign.
     */
    public static String makeSign(Map<String, Object> params, boolean isSort) {
        List<String> keyValues = new ArrayList<>();
        params.forEach(
                (k, v) -> {
                    if (null != v && StringUtils.isNotEmpty(String.valueOf(v))) {
                        keyValues.add(k + "=" + v);
                    }
                });
        if (isSort) {
            keyValues.sort(Comparator.naturalOrder());
        }
        String tmp = String.join("&", keyValues);

        return DigestUtils.md5DigestAsHex(tmp.getBytes());
    }


    public static String makeApacheCommonSign(Map<String, Object> params, boolean isSort) {
        List<String> keyValues = new ArrayList<>();
        params.forEach(
                (k, v) -> {
                    if (null != v && StringUtils.isNotEmpty(String.valueOf(v))) {
                        keyValues.add(k + "=" + v);
                    }
                });
        if (isSort) {
            keyValues.sort(Comparator.naturalOrder());
        }
        String tmp = String.join("&", keyValues);
        System.out.println(tmp);
        return org.apache.commons.codec.digest.DigestUtils.md5Hex(tmp.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * bean 对象转 map
     *
     * @param bean bean
     * @return map
     */
    public static Map<String, Object> beanToMap(Object bean) {
        if (null == bean) {
            return null;
        }
        if (bean instanceof Collection || bean.getClass().isArray()) {
            throw new IllegalArgumentException("bean type can not be array or collection");
        }
        if (bean instanceof Map) {
            return (Map<String, Object>) bean;
        }

        Map<String, Object> map = new HashMap<>(16);
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            Set<Entry> set = beanMap.entrySet();
            for (Entry entry : set) {
                if (null != entry.getValue()) {
                    map.put(String.valueOf(entry.getKey()), entry.getValue());
                }
            }
        }
        return map;
    }

    /**
     * 按key升序排序.
     *
     * @param map input map.
     * @return new map.
     */
    public static Map<String, Object> sortMapByKey(Map<String, Object> map) {

        Map<String, Object> sortedMap = map.entrySet().stream()
                .sorted(Entry.comparingByKey())
                .collect(
                        Collectors.toMap(
                                Entry::getKey,
                                Entry::getValue,
                                (oldVal, newVal) -> oldVal,
                                LinkedHashMap::new
                        )
                );

        return sortedMap;
    }

}
