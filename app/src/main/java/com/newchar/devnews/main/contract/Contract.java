package com.newchar.devnews.main.contract;

import com.newchar.devnews.base.IBasePresenter;
import com.newchar.devnews.base.IBaseView;

/**
 * @author wenliqiang@100tal.com
 * date            2020/6/26
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public interface Contract {

    interface Presenter extends IBasePresenter<View> {

    }

    interface View extends IBaseView {

    }

}
