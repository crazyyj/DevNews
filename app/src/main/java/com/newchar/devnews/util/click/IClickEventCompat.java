package com.newchar.devnews.util.click;

import android.view.View;

/**
 * @author wenliqiang wenliqiang@100tal.com
 * date            2019-06-16
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public interface IClickEventCompat {

    /**
     * 是否拦截点击事件
     *
     * @param clickView 点击View
     * @return true 拦截，false 不拦截
     */
    boolean onInterceptClickEvent(View clickView);

    /**
     * 点击事件兼容方法
     *
     * @param clickView 点击的View
     * @return true 不执行 ,false 不执行
     * @see #onClickEnd(View)
     */
    boolean onClickCompat(View clickView);

    /**
     * 结尾方法，可用于释放资源等
     * @param clickView 点击的View
     */
    void onClickEnd(View clickView);

}
