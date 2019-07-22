package com.newchar.devnews.custom.statelayout;

import android.view.View;

import androidx.annotation.LayoutRes;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-22
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public interface IMultiState {

    /**
     * 获取状态类型
     *
     * @return 状态类型
     */
    int getStateType();

    /**
     * 获取状态布局
     *
     * @param id layoutId
     * @return 状态View 对象
     */
    View getStateView(@LayoutRes int id);

}
