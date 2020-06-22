package com.newchar.devnews.http.params;

import com.newchar.devnews.http.entry.osc.OSCLoginCodeTokenResult;
import com.newchar.devnews.util.constant.OSCField;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenliqiang
 * date 2020/6/14
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class OSCParamsBuilder {

    public static Map<String, Object> buildOSCBlogListParams(int pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put(OSCField.Params.DATA_TYPE, OSCField.DataType.JSON);
        params.put(OSCField.Params.ACCESS_TOKEN, OSCLoginCodeTokenResult.getInstance().getAccess_token());
        params.put(OSCField.Params.CATALOG, "3");
        params.put(OSCField.Params.PAGE_SIZE, OSCField.Params.PAGE_SIZE_DEFAULT);
        params.put(OSCField.Params.PAGE_INDEX, pageSize);
//        params.put(OSCField.Params.TAG, "3");
        return params;
    }

    public static Map<String, Object> buildOSCPostDetailParams(String postId) {
        Map<String, Object> params = new HashMap<>();
        params.put(OSCField.Params.DATA_TYPE, OSCField.DataType.JSON);
        params.put(OSCField.Params.ACCESS_TOKEN, OSCLoginCodeTokenResult.getInstance().getAccess_token());
        params.put(OSCField.Params.ID, postId);
        return params;
    }


}
