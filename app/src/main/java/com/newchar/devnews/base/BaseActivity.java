package com.newchar.devnews.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.newchar.devnews.util.CommonUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-16
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mButterKnife;
    private boolean resReleased;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getContentViewId();
        setContentView(layoutId);
        initWidgets();
        handlerIntent(getIntent(), savedInstanceState);
        initProjectFromAsync(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        mButterKnife = ButterKnife.bind(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handlerIntent(intent, null);
        setIntent(intent);
    }

    /**
     * 初始化界面控件View
     */
    protected abstract void initWidgets();

    /**
     * 初始化当前页数据
     *
     * @param savedInstanceState 保存状态数据的Bundle对象
     */
    protected abstract void initData(Bundle savedInstanceState);

    /**
     * 处理被打开的Intent
     * 处理Intent 附带过来的数据
     */
    protected void handlerIntent(Intent otherIntent, @Nullable Bundle savedInstanceState){

    }

    /**
     * 设置当前Activity布局文件
     * 执行在setContentView();之前
     * @return 布局的资源Xml文件ID
     */
    protected abstract int getContentViewId();

    /**
     * 填充数据时机优化, 显示第一帧 填充数据
     */
    private void initProjectFromAsync(final Bundle savedInstanceState) {
        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {
                initData(savedInstanceState);
            }
        });
    }

    public void finish(int animIn, int animOut) {
        super.finish();
        this.overridePendingTransition(animIn, animOut);
    }


    /**
     * @return 当前Activity 的根View
     */
    protected View getRootView() {
        View rootView = ((ViewGroup) (getWindow().getDecorView()
                .findViewById(android.R.id.content)))
                .getChildAt(0);
        return rootView;
    }

    /**
     * 控制点击EditText以外的部分 收回软键盘
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                CommonUtils.closeKeybord(getWindow().getCurrentFocus(), this);
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    private boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            // 获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            }
        }
        return true;
    }


    @Override
    protected void onStop() {
        super.onStop();
        if (isFinishing()) {
            onReleaseRes();
        }
    }

    /**
     * 释放资源
     */
    public void onReleaseRes(){
        resReleased = true;
    }


    @Override
    protected void onDestroy() {
        if (!resReleased) {
            onReleaseRes();
        }
        if (mButterKnife != null) {
            mButterKnife.unbind();
        }
        super.onDestroy();
    }

}
