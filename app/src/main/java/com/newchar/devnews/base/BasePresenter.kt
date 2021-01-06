package com.newchar.devnews.base

import java.lang.ref.WeakReference

/**
 *  @author wenliqiang
 *  date 2020/8/1
 *  @since 当前版本，（以及描述）
 *  @since 迭代版本，（以及描述）
 */
open class BasePresenter(iBaseView: IBaseContract.IBaseView) : IBaseContract.IBasePresenter<IBaseContract.IBaseView> {

    /**
     * IView引用
     */
    val viewRef: WeakReference<IBaseContract.IBaseView>

    init {
        viewRef = WeakReference(iBaseView)
    }

    override fun getView(): IBaseContract.IBaseView? {
        return viewRef.get()
    }

    override fun attachView(view: IBaseContract.IBaseView?) {

    }

}