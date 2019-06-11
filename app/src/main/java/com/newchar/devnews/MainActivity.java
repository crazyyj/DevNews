package com.newchar.devnews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.newchar.devnews.http.MURL;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Okio;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OkHttpClient appHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(MURL.OSC_URL + "/action/openapi/token" + "/" +"?" +
                        "client_id=cXe8oxW5SJSuT02qdmjh&" +
                        "client_secret=63FxZHuqYzJZhMgMxVb0tuCkEyrOzjfE&" +
                        "grant_type=refresh_token&" +
                        "redirect_uri=about:blank&" +
                        "code=\"\"&" +
                        "refresh_token=\"\"&" +
                        "dataType=json&"
                ).build();

        appHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    final ResponseBody responseBody = response.body();
                    if (responseBody != null) {
                        final String httpResult = responseBody.string();
                        System.out.println(httpResult);
                        System.out.println("nfkdflkjdklfjlkds");

                    } else {
                        onFailure(call, new IOException("laji"));
                    }
                } else {
                    System.out.println("失败了" + response.code() + "\n"+ response.body().string());
                }
            }
        });

    }


}
