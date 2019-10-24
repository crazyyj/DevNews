package com.newchar.devnews.login;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.newchar.devnews.base.IBasePresenter;
import com.newchar.devnews.base.IBaseView;
import com.newchar.devnews.http.HttpRequest;
import com.newchar.devnews.http.JsonCompat;
import com.newchar.devnews.http.entry.OSCHttpError;
import com.newchar.devnews.http.entry.OSCLoginCodeTokenResult;
import com.newchar.devnews.http.entry.OSCUserInfoResult;
import com.newchar.devnews.util.constant.OSCField;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-22
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public class Presenter implements IBasePresenter<LoginView> {

    private LoginView mView;

    Presenter() {

    }

    void attachView(LoginView view) {
        mView = view;
    }

    public void refreshOSChinaToken(String client_id, String client_secret, String grant_type, String oscLoginCode) {
        Map<String, String> par = new HashMap<>();
        par.put("code", oscLoginCode);
        par.put("client_id", client_id);
        par.put("grant_type", grant_type);
        par.put("redirect_uri", "about:blank");
        par.put("callback", "about:blank");
        par.put("client_secret", client_secret);
        par.put(OSCField.Params.DATA_TYPE, OSCField.DataType.JSON);
        HttpRequest.requestLoginCode(par, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.body() == null) {
                    return;
                }
                if ( response.isSuccessful()) {
                    final OSCLoginCodeTokenResult parse = JsonCompat.parse(OSCLoginCodeTokenResult.class, response.body().string());
                    getView().onOSCLoginSuccess(parse);
                } else {
                    final OSCHttpError parse = JsonCompat.parse(OSCHttpError.class, response.body().string());
                    Activity context = (Activity) getView().obtainContext();
                    context.runOnUiThread(() -> Toast.makeText(context, parse.error_description, Toast.LENGTH_SHORT).show());
                }
            }
        });
    }

    @Override
    public LoginView getView() {
        return mView;
    }

    public void requestOSCUserInfo(String access_token) {
        final Map<String, String> params = new HashMap<>();
        params.put(OSCField.Params.ACCESS_TOKEN, access_token);
        params.put(OSCField.Params.DATA_TYPE, OSCField.DataType.JSON);
        HttpRequest.requestOSCUser(params, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response != null && response.isSuccessful() && response.body() != null) {
                    OSCUserInfoResult userInfo = JsonCompat.parse(OSCUserInfoResult.class, response.body().string());
                    getView().onRequestOSCUserSuccess(userInfo);
                } else {
                    Activity context = (Activity) getView().obtainContext();
                    context.runOnUiThread(() -> Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show());
                }
            }
        });
    }
}
