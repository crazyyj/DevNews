package com.newchar.devnews.splash;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatTextView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseActivity;
import com.newchar.devnews.login.LoginActivity;
import com.newchar.devnews.util.ShapeBuilder;
import com.newchar.supportlibrary.router.RouterExecute;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-16
 * @since 闪屏页面，负责首屏
 * @since 迭代版本描述
 */
public class SplashActivity extends BaseActivity {

//    @BindView(R.id.lottieAnimator)
//    LottieAnimationView lottieAnimator;
    @BindView(R.id.btnClickGoMain)
    AppCompatTextView btnClickGoMain;

    @Override
    protected void initWidgets() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
//        lottieAnimator.setComposition(getResouce());
//        lottieAnimator.playAnimation();
//        lottieAnimator.setRepeatCount(ValueAnimator.INFINITE);
        final Drawable background = ShapeBuilder.rectangle()
                .leftBottomCornerRadius(100)
                .cornerRadius(200)
                .dashColor(Color.parseColor("#FFFFFF"))
                .dashGap(100)
                .dashLineWidth(10)
                .dashWidth(5)
                .solidColor(Color.parseColor("#FF0034"))
                .build();
        btnClickGoMain.setBackgroundDrawable(background);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_splash;
    }

    @OnClick(R.id.btnClickGoMain)
    public void onViewClicked() {
        RouterExecute.goLoginActivity();
//        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//        startActivity(intent);

    }

//    public LottieComposition getResouce() {
//        final InputStream inputStream = getResources().openRawResource(R.raw.math);
//        ZipInputStream inZip = new ZipInputStream(inputStream);
//        return LottieCompositionFactory.fromZipStreamSync(inZip, "ZipInputStream").getValue();
//    }

}