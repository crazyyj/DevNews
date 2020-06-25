package com.newchar.devnews.base;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-16
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public interface IBasePresenter<V extends IBaseView> {



    V getView();

    void attachView(IBaseView view);

}
