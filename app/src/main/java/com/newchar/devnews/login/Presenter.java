package com.newchar.devnews.login;

import android.text.TextUtils;

import com.newchar.devnews.base.IBasePresenter;
import com.newchar.devnews.base.IBaseView;
import com.newchar.devnews.http.HttpRequest;
import com.newchar.devnews.http.JsonCompat;
import com.newchar.devnews.http.entry.OSCLoginCodeToken;
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
public class Presenter<V extends IBaseView> implements IBasePresenter {

    private LoginView mView;

    public Presenter() {

    }

    public void attchView(V view) {
        mView = (LoginView) view;
    }

    public void refushOSChinaToken(String client_id, String client_secret, String grant_type, String oscLoginCode) {
        final Map<String, String> par = new HashMap<>();
        if (TextUtils.equals("authorization_code", grant_type) && !TextUtils.isEmpty(oscLoginCode)) {
            par.put("code", oscLoginCode);
        } else {
            par.put("refresh_token", oscLoginCode);
        }
        par.put("client_id", client_id);
        par.put("grant_type", grant_type);
        par.put("redirect_uri", "about:blank");
        par.put("client_secret", client_secret);
        par.put("dataType", OSCField.DataType.JSON);
        HttpRequest.requestLoginCode(par, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.body() != null) {
                    final OSCLoginCodeToken parse = JsonCompat.parse(OSCLoginCodeToken.class, response.body().string());
                    getView().onOSCLoginSuccess(parse);
                }
            }
        });
    }

    @Override
    public LoginView getView() {
        return mView;
    }

}
