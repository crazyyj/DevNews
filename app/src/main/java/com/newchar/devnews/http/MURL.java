package com.newchar.devnews.http;

import com.newchar.devnews.util.constant.OSCField;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenliqiang
 * date 2019-06-04
 * @since 根URL
 * @since 迭代版本，（以及描述）
 */
public class MURL {

    private static Map<String, String> OSCAUthUrl = new HashMap<>();

    static {
        OSCAUthUrl.put("client_id", "cXe8oxW5SJSuT02qdmjh");
        OSCAUthUrl.put("response_type", OSCField.Params.CODE);
        OSCAUthUrl.put("redirect_uri", OSCField.Params.REDIRECT_URI);
//        OSCAUthUrl.put("state", "");
    }

    public static String getOSCLoginAUthUrl() {
        return OSCField.URL.BASE_OSC_URL + OSCField.Address.OAUTH2_AUTHORIZE_OSC + buildGetParamText(OSCAUthUrl);
    }

    private static String buildGetParamText(Map<String, String> params) {
        StringBuilder getUrl = new StringBuilder("?");
        if (params != null) {
            for (String key : params.keySet()) {
                if (key == null || "".equals(key)) {
                    continue;
                }
                getUrl.append(key).append("=").append(params.get(key)).append("&");
            }
            //  删除最后一个 &
            getUrl.deleteCharAt(getUrl.length() - 1);
        }
        return getUrl.toString();
    }

    /**
     * @param url 链接
     * @return 链接拆分出来的参数
     */
    public static Map<String, String> obtainGetUrlParams(String url) {
        Map<String, String> paramsMap = new HashMap<>();
        if (url == null) {
            return paramsMap;
        }
        if (getNonEdgeString(url, "?")) {
            String[] addressAndParams = url.split("\\?", 2);
            String[] getParams = addressAndParams[1].split("&");
            for (int i = 0; i < getParams.length; i++) {
                String[] key_value = getParams[i].split("=", 2);
                if (key_value.length > 1) {
                    paramsMap.put(key_value[0], key_value[1]);
                } else {
                    paramsMap.put(key_value[0], null);
                }
            }
        }
        return paramsMap;
    }

    /**
     * tag 是否在 fullText 的边缘
     *
     * @param fullText 全量字符串
     * @param tag      需要被匹配的自负
     * @return true 是在边缘
     */
    public static boolean getNonEdgeString(String fullText, String tag) {
        if (fullText == null || tag == null) {
            return false;
        }
        int index = fullText.indexOf(tag);
        return index > 0 && fullText.length() - 1 > index;
    }


}
