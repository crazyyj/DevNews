package com.newchar.devnews.main.mine;

import com.newchar.devnews.base.IBaseContract;

/**
 * @author newChar
 * date 2020/12/28
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
interface Contract {

    interface IView extends IBaseContract.IBaseView {

    }

    interface Presenter extends IBaseContract.IBasePresenter<IBaseContract.IBaseView> {

        /**
         * 刷新头部信息
         */
        void updateHeaderData();

    }

}
