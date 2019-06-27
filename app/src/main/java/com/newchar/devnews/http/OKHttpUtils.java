package com.newchar.devnews.http;

import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author wenliqiang
 * date 2019-06-27
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class OKHttpUtils {

    private static OkHttpClient.Builder builder;
    private static OkHttpClient okClient;

    static {
        builder = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS);
        okClient = builder.build();

    }
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    public static void post(String url, Map<String, String> parmar) {
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : parmar.keySet()) {
            builder.add(key, parmar.get(key));
        }
        okClient.newCall(new Request.Builder().url(url).post(builder.build()).build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }



}
