package com.newchar.devnews.login;

import com.newchar.devnews.base.IBaseView;
import com.newchar.devnews.http.entry.OSCLoginCodeTokenResult;
import com.newchar.devnews.http.entry.OSCUserInfoResult;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-22
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public interface LoginView extends IBaseView {

    /**
     * 开源中国登录成功
     *
     * @param osc 开源中国登录成功数据
     */
    void onOSCLoginSuccess(OSCLoginCodeTokenResult osc);

    void onRequestOSCUserSuccess(OSCUserInfoResult userInfo);

}
