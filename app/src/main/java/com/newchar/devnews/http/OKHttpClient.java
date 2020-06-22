package com.newchar.devnews.http;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @author wenliqiang
 * date 2019-06-27
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class OKHttpClient {

    private static OkHttpClient okClient;

    static {
        okClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    public static void post(String url, Map<String, Object> params, Callback callback) {
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : params.keySet()) {
            if (key == null || params.get(key) == null) {
                continue;
            }
            builder.add(key, String.valueOf(params.get(key)));
        }
        okClient.newCall(new Request.Builder().url(url).post(builder.build()).build()).enqueue(callback);
    }


}
