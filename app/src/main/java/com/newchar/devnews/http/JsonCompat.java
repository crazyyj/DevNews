package com.newchar.devnews.http;

import com.google.gson.Gson;

/**
 * @author wenliqiang
 * date 2019-07-03
 * @since 1.0   json解析辅助类
 * @since 迭代版本，（以及描述）
 */
public class JsonCompat {

    private static final Gson gson = new Gson();

    

    /**
     * @param clazz 字节码类型
     * @param json  json数据
     * @param <T>   对象泛型
     * @return 解析的实体对象
     */
    public static <T> T parse(Class<T> clazz, String json) {
        return gson.fromJson(json, clazz);
    }

    /**
     * @param t   要解析的对象
     * @param <T> 同t
     * @return json String 数据
     */
    public static <T> String toJson(T t) {
        return gson.toJson(t);
    }

}
