package com.newchar.devnews.base

import java.lang.ref.WeakReference

/**
 *  @author wenliqiang
 *  date 2020/8/1
 *  @since 当前版本，（以及描述）
 *  @since 迭代版本，（以及描述）
 */
open class BasePresenter : IBasePresenter<IBaseView> {

    /**
     * IView引用
     */
    lateinit var viewRef: WeakReference<IBaseView>

    override fun getView(): IBaseView? {
        return viewRef.get()
    }

    override fun attachView(view: IBaseView) {
        viewRef = WeakReference(view)
    }

}