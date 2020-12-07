package com.newchar.devnews.http.params;

import com.newchar.devnews.http.entry.osc.OSCLoginCodeTokenResult;
import com.newchar.devnews.util.constant.ConstantField;
import com.newchar.devnews.util.constant.OSCField;
import com.newchar.supportlibrary.db.DBHelper;
import com.newchar.supportlibrary.db.entry.LoginRecord;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenliqiang
 * date 2020/6/14
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class OSCParamsBuilder {

    public static Map<String, Object> buildOSCBlogListParams(int page, String catalog/*, String accessToken*/) {
        Map<String, Object> params = new HashMap<>();
        params.put(OSCField.Params.CATALOG, catalog);
        params.put(OSCField.Params.PAGE_INDEX, page);
        params.put(OSCField.Params.DATA_TYPE, OSCField.DataType.JSON);
        params.put(OSCField.Params.PAGE_SIZE, OSCField.Params.PAGE_SIZE_DEFAULT);
        params.put(OSCField.Params.ACCESS_TOKEN, OSCLoginCodeTokenResult.getInstance().getAccess_token());
        return params;
    }

    public static Map<String, Object> buildOSCBlogDetailParams(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put(OSCField.Params.ID, id);
        params.put(OSCField.Params.DATA_TYPE, OSCField.DataType.JSON);
        params.put(OSCField.Params.ACCESS_TOKEN, OSCLoginCodeTokenResult.getInstance().getAccess_token());
        return params;
    }

    public static Map<String, Object> buildOSCTweetListParams(int page) {
        Map<String, Object> params = new HashMap<>();
        params.put(OSCField.Params.ACCESS_TOKEN, OSCLoginCodeTokenResult.getInstance().getAccess_token());
        params.put(OSCField.Params.USER, "0");
        params.put(OSCField.Params.PAGE_SIZE, OSCField.Params.PAGE_SIZE_DEFAULT);
        params.put(OSCField.Params.PAGE_INDEX, page);
        params.put(OSCField.Params.DATA_TYPE, OSCField.DataType.JSON);
        return params;
    }

    public static Map<String, Object> buildOSCNewsListParams(int page) {
        Map<String, Object> params = new HashMap<>();
        params.put(OSCField.Params.DATA_TYPE, OSCField.DataType.JSON);
        params.put(OSCField.Params.ACCESS_TOKEN, OSCLoginCodeTokenResult.getInstance().getAccess_token());
        params.put(OSCField.Params.CATALOG, "1");
        params.put(OSCField.Params.PAGE_SIZE, String.valueOf(page));
        params.put(OSCField.Params.PAGE_INDEX, OSCField.Params.PAGE_SIZE_DEFAULT);
        return params;
    }

    public static Map<String, Object> buildOSCPostDetailParams(String postId) {
        Map<String, Object> params = new HashMap<>();
        params.put(OSCField.Params.DATA_TYPE, OSCField.DataType.JSON);
        params.put(OSCField.Params.ACCESS_TOKEN, OSCLoginCodeTokenResult.getInstance().getAccess_token());
        params.put(OSCField.Params.ID, postId);
        return params;
    }

    /**
     * 获取刷新Token接口的参数
     *
     * @param oldRefreshToken 上次接口请求的 refreshToken
     * @return Map
     */
    public static Map<String, Object> buildOSCRefreshTokenParams(String oldRefreshToken) {
        Map<String, Object> params = new HashMap<>();
        params.put(OSCField.Params.REFRESH_TOKEN, oldRefreshToken);
        params.put(OSCField.Params.CLIENT_ID, OSCField.Server.CLIENT_ID);
        params.put(OSCField.Params.REDIRECT_URI, OSCField.Params.OS_CHINA);
        params.put(OSCField.Params.GRANT_TYPE, OSCField.Params.REFRESH_TOKEN);
        params.put(OSCField.Params.CLIENT_SECRET, OSCField.Server.CLIENT_SECRET);
        params.put(OSCField.Params.DATA_TYPE, OSCField.DataType.JSON);
        return params;
    }


}
