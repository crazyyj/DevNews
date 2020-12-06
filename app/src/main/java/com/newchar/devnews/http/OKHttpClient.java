package com.newchar.devnews.http;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author wenliqiang
 * date 2019-06-27
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class OKHttpClient {

    private static final OkHttpClient okClient;

    static {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        // 包含header、body数据
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okClient = new OkHttpClient.Builder()
                //http数据log，日志中打印出HTTP请求&响应数据
                .addInterceptor(loggingInterceptor)
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
        final Request requestBuilder = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        okClient.newCall(requestBuilder).enqueue(callback);
    }

    public static void get(String url, Callback callback) {
        okClient.newCall(new Request.Builder().url(url).get().build()).enqueue(callback);
    }


}
