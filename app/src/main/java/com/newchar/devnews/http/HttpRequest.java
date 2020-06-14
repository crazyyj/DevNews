package com.newchar.devnews.http;

import com.newchar.devnews.util.constant.OSCField;

import java.util.Map;

import okhttp3.Callback;

/**
 * @author wenliqiang
 * date 2019-07-03
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class HttpRequest {


    public static void requestLoginCode(Map<String, Object> params, Callback callback) {
        OKHttpClient.post(OSCField.URL.BASE_OSC_URL + "/action/openapi/token", params, callback);
    }

    public static void requestOSCUser(Map<String, Object> params, Callback callback) {
        OKHttpClient.post(OSCField.URL.BASE_OSC_URL + "/action/openapi/user", params, callback);
    }

    /**
     *
     */
    public static void requestOSCNews(Map<String, Object> params, Callback callback) {
        OKHttpClient.post(OSCField.URL.BASE_OSC_URL + OSCField.Address.NEWS_OSC, params, callback);
    }

    public static void requestOSTweetList(Map<String, Object> params, Callback callback) {
        OKHttpClient.post(OSCField.URL.BASE_OSC_URL + OSCField.Address.TWEET_LIST_OSC, params, callback);
    }

    /**
     * 帖子列表
     */
    public static void requestOSCPostList(Map<String, Object> params, Callback callback) {
        OKHttpClient.post(OSCField.URL.BASE_OSC_URL + OSCField.Address.POST_LIST_OSC, params, callback);
    }

}
