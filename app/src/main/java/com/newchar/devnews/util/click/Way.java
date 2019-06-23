package com.newchar.devnews.util.click;

import android.view.View;

/**
 * @author wenliqiang wenliqiang@100tal.com
 * date            2019-06-21
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public interface Way {

    /**
     * 是否可以执行作为拦截判断
     *
     * @param view 事件View
     * @return 是否可以继续执行
     */
    boolean isShouldExecute(View view);



    /**
     * 执行事件
     *
     * @param view 事件View
     * @return 是否需要结尾函数
     */
    boolean onExecute(View view);



}
