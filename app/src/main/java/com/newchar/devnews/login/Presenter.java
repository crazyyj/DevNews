package com.newchar.devnews.login;

import android.app.Activity;
import android.widget.Toast;

import com.newchar.devnews.base.IBasePresenter;
import com.newchar.devnews.http.HttpRequest;
import com.newchar.devnews.http.JsonCompat;
import com.newchar.devnews.http.entry.osc.OSCHttpError;
import com.newchar.devnews.http.entry.osc.OSCLoginCodeTokenResult;
import com.newchar.devnews.http.entry.osc.OSCUserInfoResult;
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
        Map<String, Object> par = new HashMap<>();
        par.put("code", oscLoginCode);
        par.put("client_id", client_id);
        par.put("grant_type", grant_type);
        par.put("redirect_uri", OSCField.Params.REDIRECT_URI);
        par.put("client_secret", client_secret);
        par.put(OSCField.Params.DATA_TYPE, OSCField.DataType.JSON);
        HttpRequest.requestLoginCode(par, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.body() == null) {
                    return;
                }
                if (response.isSuccessful()) {
                    final OSCLoginCodeTokenResult parse = JsonCompat.parse(OSCLoginCodeTokenResult.class, response.body().string());
                    OSCLoginCodeTokenResult.getInstance().setAccess_token(parse.getAccess_token());
                    OSCLoginCodeTokenResult.getInstance().setExpires_in(parse.getExpires_in());
                    OSCLoginCodeTokenResult.getInstance().setRefresh_token(parse.getRefresh_token());
                    OSCLoginCodeTokenResult.getInstance().setToken_type(parse.getToken_type());
                    OSCLoginCodeTokenResult.getInstance().setUid(parse.getUid());
                    getView().onOSCLoginSuccess(parse);

                } else {
                    final OSCHttpError parse = JsonCompat.parse(OSCHttpError.class, response.body().string());
                    Activity context = (Activity) getView().obtainContext();
                    context.runOnUiThread(() -> Toast.makeText(context, parse.getError_description(), Toast.LENGTH_SHORT).show());
                }
            }
        });
    }

    @Override
    public LoginView getView() {
        return mView;
    }

    public void requestOSCUserInfo(String access_token) {
        final Map<String, Object> params = new HashMap<>();
        params.put(OSCField.Params.ACCESS_TOKEN, access_token);
        params.put(OSCField.Params.DATA_TYPE, OSCField.DataType.JSON);
        HttpRequest.requestOSCUser(params, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Activity context = (Activity) getView().obtainContext();
                context.runOnUiThread(() -> Toast.makeText(context, " onFailure \n" + e.getMessage(), Toast.LENGTH_SHORT).show());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response != null && response.isSuccessful() && response.body() != null) {
                    OSCUserInfoResult userInfo = JsonCompat.parse(OSCUserInfoResult.class, response.body().string());
                    OSCUserInfoResult.getInstance().setAvatar(userInfo.avatar);
                    OSCUserInfoResult.getInstance().setEmail(userInfo.email);
                    OSCUserInfoResult.getInstance().setGender(userInfo.gender);
                    OSCUserInfoResult.getInstance().setId(userInfo.id);
                    OSCUserInfoResult.getInstance().setLocation(userInfo.location);
                    OSCUserInfoResult.getInstance().setName(userInfo.name);
                    OSCUserInfoResult.getInstance().setUrl(userInfo.url);
                    getView().onRequestOSCUserSuccess(userInfo);
                } else {
                    Activity context = (Activity) getView().obtainContext();
                    context.runOnUiThread(() -> Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show());
                }
            }
        });
    }

}
