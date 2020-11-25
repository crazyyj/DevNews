package com.newchar.devnews.main.girl

import com.newchar.devnews.base.IBasePresenter
import com.newchar.devnews.base.IBaseView

/**
 *  @author wenliqiang
 *  date 2020/8/1
 *  @since 当前版本，（以及描述）
 *  @since 迭代版本，（以及描述）
 */
interface Contract {

    interface IView : IBaseView

    interface IPresenter : IBasePresenter<IView>

}