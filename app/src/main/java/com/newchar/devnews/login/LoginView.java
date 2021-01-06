package com.newchar.devnews.login;

import com.newchar.devnews.base.IBaseContract.IBaseView;
import com.newchar.oscrepository.entry.OSCLoginCodeTokenResult;
import com.newchar.oscrepository.entry.OSCUserInfoResult;

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

    /**
     * 获取开源中国用户信息成功
     *
     * @param userInfo OSC用户信息
     */
    void onRequestOSCUserSuccess(OSCUserInfoResult userInfo);

}
