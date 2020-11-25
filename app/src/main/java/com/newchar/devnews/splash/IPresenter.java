package com.newchar.devnews.splash;

import com.newchar.devnews.base.IBasePresenter;
import com.newchar.devnews.base.IBaseView;

/**
 * @author newChar
 * date 2020/11/12
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
interface IPresenter extends IBasePresenter<IBaseView> {

    /**
     * 获取登陆状态
     */
    void getLoginState();

}
