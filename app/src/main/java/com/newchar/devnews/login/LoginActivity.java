package com.newchar.devnews.login;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseActivity;
import com.newchar.devnews.http.MURL;
import com.newchar.devnews.http.entry.osc.OSCLoginCodeTokenResult;
import com.newchar.devnews.http.entry.osc.OSCUserInfoResult;
import com.newchar.devnews.util.constant.OSCField;
import com.newchar.devnews.web.WebViewActivity;
import com.newchar.supportlibrary.constant.Login;
import com.newchar.supportlibrary.db.DBHelper;
import com.newchar.supportlibrary.db.entry.LoginRecord;
import com.newchar.supportlibrary.router.ARouterPath;
import com.newchar.supportlibrary.router.RouterExecute;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-16
 * @since 登录页面。
 * @since 迭代版本描述
 */
@Route(path = ARouterPath.ACTIVITY_LOGIN)
public class LoginActivity extends BaseActivity implements LoginView {

    @BindView(R.id.llLoginTypeContainer)
    LinearLayoutCompat llLoginTypeContainer;
    @BindView(R.id.tvOSCLoginAction)
    AppCompatTextView tvOSCLoginAction;
    @BindView(R.id.tvLoginActionLogin)
    AppCompatTextView tvLoginActionLogin;

    private BottomSheetBehavior<LinearLayoutCompat> bottomSheetBehavior;
    private Presenter presenter;

    @Override
    protected void initWidgets() {

    }

    @Override
    protected void initData() {
        presenter = new Presenter();
        presenter.attachView(this);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.tvLoginActionLogin, R.id.ivLoginTypeToggle, R.id.tvOSCLoginAction})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvLoginActionLogin:
                RouterExecute.goBrowserActivity(this, MURL.getOSCLoginAUthUrl());
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

    private void action_LoginOSC() {
        LoginRecord lastLoginRecord = DBHelper.getInstance(getApplicationContext()).getLastLoginRecord();
        if (lastLoginRecord == null) {
            RouterExecute.goBrowserActivity(this, MURL.getOSCLoginAUthUrl());
            return;
        }
        presenter.refreshOSChinaToken("cXe8oxW5SJSuT02qdmjh", "63FxZHuqYzJZhMgMxVb0tuCkEyrOzjfE", "refresh_token", lastLoginRecord.getDesc());
    }

    /**
     * 变换登录类型的布局
     */
    private void toggleBottomLoginTypeLayout() {
        if (bottomSheetBehavior == null) {
            bottomSheetBehavior = BottomSheetBehavior.from(llLoginTypeContainer);
        }
        int sheetState = bottomSheetBehavior.getState();
        if (sheetState == BottomSheetBehavior.STATE_EXPANDED) {         //展开变折叠
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else if (sheetState == BottomSheetBehavior.STATE_COLLAPSED) { //折叠变展开
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
            String oscLoginCode = data.getStringExtra("oscLoginCode");
            if (TextUtils.isEmpty(oscLoginCode)) {
                return;
            }
            presenter.refreshOSChinaToken("cXe8oxW5SJSuT02qdmjh", "63FxZHuqYzJZhMgMxVb0tuCkEyrOzjfE", OSCField.Params.AUTHORIZATION_CODE, oscLoginCode);
        }
    }

    @Override
    public void onOSCLoginSuccess(OSCLoginCodeTokenResult osc) {
        DBHelper.getInstance(getApplicationContext()).saveLoginRecord(new LoginRecord(System.currentTimeMillis(), System.currentTimeMillis(), Login.Channel.OSC, osc.getAccess_token()));

        presenter.requestOSCUserInfo(osc.getAccess_token());

    }

    @Override
    public void onRequestOSCUserSuccess(OSCUserInfoResult userInfo) {
        RouterExecute.goMainActivity();
    }

}
