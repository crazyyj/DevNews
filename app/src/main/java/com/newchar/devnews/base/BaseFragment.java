package com.newchar.devnews.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author wenliqiang
 * date 2019-07-18
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public abstract class BaseFragment extends Fragment {

    protected View mView;
    protected Context mContext;
    protected Activity fragActivity;
    protected LazyListener mLazyListener;

    private volatile boolean isViewInited;
    private Unbinder bind;

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        this.mContext = activity;
        fragActivity = ((AppCompatActivity) activity);
        isViewInited = false;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWidgetsBefore();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = super.onCreateView(inflater, container, savedInstanceState);
        int layoutId = getContentViewId();
        if (0 >= layoutId) {
            TextView errorText = new TextView(mContext);
            errorText.setText(this.getClass().getSimpleName() + "的Fragment_LayoutId出现错误");
            errorText.setGravity(Gravity.CENTER);
            errorText.setTextSize(30);
            errorText.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            ViewGroup.LayoutParams errorTextLayoutParams = errorText.getLayoutParams();
            errorTextLayoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
            errorTextLayoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            errorText.setLayoutParams(errorTextLayoutParams);
            mView = errorText;
        } else {
            mView = inflater.inflate(layoutId, container,false);
        }
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.bind = ButterKnife.bind(this, view);
        initWidgets(view);
        isViewInited = true;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData(savedInstanceState);
        initListener();
    }

    //	事务切换Fragment，需要重写方法
    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        View fragView = getView();
        if(fragView != null)
            fragView.setVisibility(menuVisible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (isViewInited) {
            if (hidden) {
                onInVisibility();
            } else {
                onVisibility();
            }
        } else {
            //View未初始化时, Fragment第一次进入, 可以初始创建一些目录或者文件
        }
    }

    public void setLazyListener(LazyListener listener) {
        mLazyListener = listener;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (fragActivity.isFinishing()) {
            onReleaseRes();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }

    /**
     * 释放关键资源，非关键资源可以 ↓
     * @see #onStop()
     */
    protected void onReleaseRes(){

    }
    /**
     * 加载页面可见,显示
     * 参数 没有savedInstanceState 所以请求网络在此， 不处理其他信息
     * 当Frag 可见时调用
     */
    protected void onVisibility(){
        if (mLazyListener != null) {
            mLazyListener.onPageVisible();
        }
    }

    /**
     * 页面不可见, 隐藏后
     * 回收可在屏幕不可见时, 回收资源操作
     * 当Frag 不可见时调用
     */
    protected void onInVisibility(){
        if (mLazyListener != null) {
            mLazyListener.onPageInvisible();
        }
    }

    public void initWidgetsBefore() {
    }

    protected abstract void initWidgets(View frgView);

    /**
     * 操作本地数据 例如 恢复状态 恢复数据
     * @param savedInstanceState 恢复数据
     */
    protected abstract void initData(Bundle savedInstanceState);

    protected abstract void initListener();

    protected abstract int getContentViewId();

    protected abstract BaseFragment getInstance(Bundle bundle);

}
