package com.newchar.devnews.http;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenliqiang
 * date 2019-06-04
 * @since 根URL
 * @since 迭代版本，（以及描述）
 */
public class MURL {

    public static final String OSC_URL = "https://www.oschina.net";
    private static Map<String, String> OSCAUthUrl = new HashMap<>();

    static {
        OSCAUthUrl.put("client_id", "cXe8oxW5SJSuT02qdmjh");
        OSCAUthUrl.put("response_type", "code");
        OSCAUthUrl.put("redirect_uri", "about:blank");
        OSCAUthUrl.put("state", "");
    }

    public static String getOSCLoginAUthUrl() {
        return OSC_URL + "/action/oauth2/authorize" + buildGetUrl(OSCAUthUrl);
    }

    private static String buildGetUrl(Map<String, String> params) {
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

}
