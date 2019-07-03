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

    public static <T> T parse(Class<T> clazz, String json) {
        return gson.fromJson(json, clazz);
    }

}
