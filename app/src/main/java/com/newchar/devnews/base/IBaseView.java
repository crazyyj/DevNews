package com.newchar.devnews.base;

import android.content.Context;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-16
 * @since MVP架构基础View（所有页面需要的包装功能）
 * @since 迭代版本描述
 */
public interface IBaseView {

    /**
     * 拿到页面的 Context 对象
     *
     * @return Context
     */
    Context obtainContext();

    /**
     * Toast提示
     *
     * @param prompt 提示
     */
    void showPagePrompt(String prompt);

}
