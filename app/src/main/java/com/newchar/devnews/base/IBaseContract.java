package com.newchar.devnews.base;

import android.content.Context;

/**
 * @author wenliqiang@100tal.com
 * date            2020/6/26
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public interface IBaseContract {

    interface IBasePresenter<V extends IBaseView> {

        V getView();

        public void attachView(V view);

    }


    interface IBaseView {

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

}
