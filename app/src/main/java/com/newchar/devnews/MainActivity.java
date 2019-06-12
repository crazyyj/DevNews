package com.newchar.devnews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.newchar.devnews.http.MURL;
import com.newchar.devnews.web.WebViewActivity;

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

        WebViewActivity.actionLaunch(this, MURL.getOSCLoginAUthUrl());
//        OkHttpClient appHttpClient = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url(MURL.getOSCLoginAUthUrl()).build();
//
//        appHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(@NonNull Call call, @NonNull IOException e) {
//            }
//            @Override
//            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
//                if (response.isSuccessful()) {
//                    final ResponseBody responseBody = response.body();
//                    if (responseBody != null) {
//                        final String httpResult = responseBody.string();
//                        System.out.println(httpResult);
//                        System.out.println("nfkdflkjdklfjlkds");
//
//                    } else {
//                        onFailure(call, new IOException("laji"));
//                    }
//                } else {
//                    System.out.println("失败了" + response.code() + "\n"+ response.body().string());
//                }
//            }
//        });

    }


}
