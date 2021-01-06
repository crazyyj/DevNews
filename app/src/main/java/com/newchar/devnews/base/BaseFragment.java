package com.newchar.devnews.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author wenliqiang
 * date 2019-07-18
 * @since 懒加载用于适配 ViewPage2
 * @since 迭代版本，（以及描述）
 */
public abstract class BaseFragment extends Fragment {

    protected View mView;
    protected Context mContext;
    protected Activity fragActivity;
    protected LazyListener mLazyListener;
    protected String TAG = getClass().getSimpleName();

    private volatile boolean isViewInited;
    private volatile boolean isMenuVisibility;
    private Unbinder bind;

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        this.mContext = activity;
        fragActivity = ((FragmentActivity) activity);
        isViewInited = false;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWidgetsBefore();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int layoutId = getContentViewId();
        if (0 < layoutId) {
            if (mView == null) {
                mView = inflater.inflate(layoutId, container, false);
            } else {
                return mView;
            }
        } else {
            mView = super.onCreateView(inflater, container, savedInstanceState);
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
    public void setMenuVisibility(boolean menuVisibility) {
        //ViewPage2 会到第2个显示到时候，第一个会返回false，到达第三个到时候 同样会回调第一个false 所以需要控制一下不能和上次到相同
        if (isMenuVisibility != menuVisibility) {
            if (mLazyListener != null) {
                if (menuVisibility) {
                    mLazyListener.onPageVisible();
                } else {
                    mLazyListener.onPageInvisible();
                }
            }
        }
        isMenuVisibility = menuVisibility;
        super.setMenuVisibility(menuVisibility);
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

    protected void setLazyListener(LazyListener listener) {
        mLazyListener = listener;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (fragActivity.isFinishing()) {
            onReleaseRes();
        }
    }

    public void showPagePrompt(String prompt) {
        Toast.makeText(mContext, prompt, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        bind.unbind();
        super.onDestroyView();
    }

    /**
     * 释放关键资源，非关键资源可以 ↓
     *
     * @see #onStop()
     */
    protected void onReleaseRes() {

    }

    /**
     * 加载页面可见,显示
     * 参数 没有savedInstanceState 所以请求网络在此， 不处理其他信息
     * 当Frag 可见时调用
     */
    protected void onVisibility() {
        if (mLazyListener != null) {
            mLazyListener.onPageVisible();
        }
    }

    /**
     * 页面不可见, 隐藏后
     * 回收可在屏幕不可见时, 回收资源操作
     * 当Frag 不可见时调用
     */
    protected void onInVisibility() {
        if (mLazyListener != null) {
            mLazyListener.onPageInvisible();
        }
    }

    public void initWidgetsBefore() {
    }

    protected abstract void initWidgets(View frgView);

    /**
     * 操作本地数据 例如 恢复状态 恢复数据
     *
     * @param savedInstanceState 恢复数据
     */
    protected abstract void initData(Bundle savedInstanceState);

    protected abstract void initListener();

    protected abstract int getContentViewId();

    protected abstract BaseFragment getInstance(Bundle bundle);

}
