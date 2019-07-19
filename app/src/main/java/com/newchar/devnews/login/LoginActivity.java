package com.newchar.devnews.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseActivity;
import com.newchar.devnews.http.HttpRequest;
import com.newchar.devnews.http.JsonCompat;
import com.newchar.devnews.http.MURL;
import com.newchar.devnews.http.entry.OSCLoginCodeToken;
import com.newchar.devnews.util.constant.OSCField;
import com.newchar.devnews.web.WebViewActivity;
import com.newchar.supportlibrary.router.ARouterPath;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-16
 * @since 登录页面。
 * @since 迭代版本描述
 */
@Route(path = ARouterPath.ACTIVITY_LOGIN)
public class LoginActivity extends BaseActivity {

    @BindView(R.id.llLoginTypeContainer)
    LinearLayoutCompat llLoginTypeContainer;
    @BindView(R.id.tvOSCLoginAction)
    AppCompatTextView tvOSCLoginAction;

    private BottomSheetBehavior<LinearLayoutCompat> bottomSheetBehavior;

    @Override
    protected void initWidgets() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.tvLoginActionLogin, R.id.ivLoginTypeToggle, R.id.tvOSCLoginAction})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvLoginActionLogin:

                break;
            case R.id.ivLoginTypeToggle:
                toggleBottomLoginTypeLayout();
                break;
            case R.id.tvOSCLoginAction:
                action_LoginOSC();
                break;
            default:
                break;
        }
    }

    private void action_LoginOSC(){
        WebViewActivity.actionLaunch(this, MURL.getOSCLoginAUthUrl());
    }

    /**
     * 变换登录类型的布局
     */
    private void toggleBottomLoginTypeLayout() {
        if (bottomSheetBehavior == null) {
            bottomSheetBehavior = BottomSheetBehavior.from(llLoginTypeContainer);
        }
        int sheetState = bottomSheetBehavior.getState();
        if (sheetState == BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else if (sheetState == BottomSheetBehavior.STATE_COLLAPSED) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (null == data) {
            return;
        }
        if (requestCode == WebViewActivity.REQUEST_CODE && resultCode == WebViewActivity.RESULT_CODE_FOR_OSC_LOGIN) {
            String oscLoginCode = data.getStringExtra("code");
            if (TextUtils.isEmpty(oscLoginCode)) {
                return;
            }
            final Map<String, String> par = new HashMap<>();
            par.put("client_id", "cXe8oxW5SJSuT02qdmjh");
            par.put("client_secret", "63FxZHuqYzJZhMgMxVb0tuCkEyrOzjfE");
            par.put("grant_type", "authorization_code");
            par.put("redirect_uri", "about:blank");
            par.put("code", oscLoginCode);
            par.put("dataType", OSCField.DataType.JSON);
            HttpRequest.requestLoginCode(par, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (response.body() != null) {
                        final OSCLoginCodeToken parse = JsonCompat.parse(OSCLoginCodeToken.class, response.body().string());

                    }
                }
            });
        }
    }

}
