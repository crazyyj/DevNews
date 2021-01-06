package com.newchar.devnews.splash;


import android.app.Activity;
import android.text.TextUtils;
import android.widget.Toast;

import com.newchar.devnews.dao.LoginRecordDAO;
import com.newchar.devnews.http.HttpRequest;
import com.newchar.devnews.http.JsonCompat;
import com.newchar.devnews.http.params.OSCParamsBuilder;
import com.newchar.devnews.util.NewLog;
import com.newchar.oscrepository.OSCField;
import com.newchar.oscrepository.entry.OSCLoginCodeTokenResult;
import com.newchar.oscrepository.entry.OSCUserInfoResult;
import com.newchar.supportlibrary.db.entry.LoginRecord;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

import static com.newchar.devnews.contract.SplashContract.IPresenter;
import static com.newchar.devnews.contract.SplashContract.IView;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-16
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public class SplashPresenter implements IPresenter {

    private IView mView;

    public SplashPresenter() {
    }

    @Override
    public IView getView() {
        return mView;
    }

    @Override
    public void attachView(IView view) {
        mView = view;
    }

    @Override
    public void getLoginState() {
        final IView splashView = getView();
        if (splashView == null) {
            return;
        }
        final LoginRecord loginRecord = LoginRecordDAO.getLastOSCLoginRecord();
        if (loginRecord == null) {
            splashView.onDBNotHasLoginRecord();
            NewLog.e(" 从没登陆过  ");
        } else {
            final long l = loginRecord.getExpires_in() * 1000;
            final long loginTime = loginRecord.getLoginTime();
            final long l1 = System.currentTimeMillis();
            NewLog.e(" getExpires_in = " + l + " loginTime = " + loginTime + " currentTimeMillis = " + l1);
            if (!TextUtils.isEmpty(loginRecord.getAccess_token()) && loginRecord.isExpire()) {
                //还没过期，去登陆，然后去首页
                OSCLoginCodeTokenResult.getInstance().setAccess_token(loginRecord.getAccess_token());
                OSCLoginCodeTokenResult.getInstance().setExpires_in(loginRecord.getExpires_in());
                splashView.onDBHasLoginRecord();
                NewLog.e(" 登陆信息未过期 ");
            } else {
                //过期了，刷新token，进入首页
                NewLog.e(" 过期了  ");
                dbLoginRecordIsExpire(loginRecord.getLoginChannel(), loginRecord.getRefresh_token());
            }
        }
    }

    /**
     * 登陆过期
     */
    private void dbLoginRecordIsExpire(String channel, String oldRefreshToken) {
        Map<String, Object> params = OSCParamsBuilder.buildOSCRefreshTokenParams(oldRefreshToken);
        HttpRequest.requestRefreshOSCLoginCode(params, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                NewLog.e(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response != null) {
                    if (response.isSuccessful()) {
                        final ResponseBody body = response.body();
                        if (body != null) {
                            final String responseText = body.string();
                            final OSCLoginCodeTokenResult result = JsonCompat.parse(OSCLoginCodeTokenResult.class, responseText);

                            final LoginRecord loginRecord = new LoginRecord();
                            loginRecord.setId(result.getUid());
                            loginRecord.setExpires_in(result.getExpires_in());
                            loginRecord.setToken_type(result.getToken_type());
                            loginRecord.setLoginChannel(LoginRecord.Channel.OSC);
                            loginRecord.setAccess_token(result.getAccess_token());
                            loginRecord.setRefresh_token(result.getRefresh_token());
                            loginRecord.setLoginTime(System.currentTimeMillis());

                            LoginRecordDAO.saveLoginRecord(loginRecord);

                            // 全局User信息 同步
                            OSCLoginCodeTokenResult.getInstance().setAccess_token(loginRecord.getAccess_token());
                            OSCLoginCodeTokenResult.getInstance().setExpires_in(loginRecord.getExpires_in());
                            requestOSCUserInfo(result.getAccess_token());

                        }

                    } else {
                        // 请求出错
                    }
                }
            }
        });
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

                    refreshTokenSuccess(userInfo);
                } else {
                    Activity context = (Activity) getView().obtainContext();
                    context.runOnUiThread(() -> Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show());
                }
            }


        });
    }

    private void refreshTokenSuccess(OSCUserInfoResult userInfo) {
        final IView view = getView();
        if (view != null) {
            view.onRefreshLoginSuccess(userInfo);
        }
    }

}
