package com.newchar.devnews.util.click;

import android.view.View;

/**
 * @author wenliqiang wenliqiang@100tal.com
 * date            2019-06-20
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public class ViewEventIntercept implements Intercept{

    private Intercept mIntercept;

    public ViewEventIntercept() {
        super();
    }

    @Override
    public boolean onDefaultIntercept(View view) {
        return mIntercept.onDefaultIntercept(view);
    }

    @Override
    public void setDefaultInterceptEnable(View tag, int enable) {
        mIntercept.setDefaultInterceptEnable(tag, enable);
    }

    @Override
    public void onUserIntercept(View view) {
        mIntercept.onUserIntercept(view);
    }


}
