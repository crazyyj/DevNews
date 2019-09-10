package com.newchar.devnews.splash;

import androidx.appcompat.widget.AppCompatTextView;

import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseActivity;
import com.newchar.devnews.util.ShapeUtils;
import com.newchar.supportlibrary.router.RouterExecute;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-16
 * @since 闪屏页面，负责首屏
 * @since 迭代版本描述
 */
public class SplashActivity extends BaseActivity {

    @BindView(R.id.btnClickGoMain)
    AppCompatTextView btnClickGoMain;

    @Override
    protected void initWidgets() {
        btnClickGoMain.setBackgroundDrawable(ShapeUtils.getWitBg());
    }

    @Override
    protected void initData() {
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_splash;
    }

    @OnClick(R.id.btnClickGoMain)
    public void onViewClicked() {
        RouterExecute.goLoginActivity();
    }

}