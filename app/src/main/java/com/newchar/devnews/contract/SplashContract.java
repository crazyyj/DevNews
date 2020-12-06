package com.newchar.devnews.contract;

import com.newchar.devnews.base.IBasePresenter;
import com.newchar.devnews.base.IBaseView;
import com.newchar.devnews.http.entry.osc.OSCUserInfoResult;

/**
 * @author newChar
 * date 2020/12/6
 * @since Splash页面的连接类
 * @since 迭代版本，（以及描述）
 */
public interface SplashContract {

    interface IView extends IBaseView {

        /**
         * 数据库中没有登陆记录信息
         */
        void onDBNotHasLoginRecord();

        /**
         * 数据库中存在登陆信息
         */
        void onDBHasLoginRecord();

        /**
         * 登陆token 过期
         */
        void onDBLoginRecordIsExpire();

        /**
         * 通过刷新 token 的方式登陆成功
         *
         * @param userInfo osc 用户信息
         */
        void onRefreshLoginSuccess(OSCUserInfoResult userInfo);
    }

    interface IPresenter extends IBasePresenter<IView> {
        /**
         * 获取登陆状态
         */
        void getLoginState();
    }

}
