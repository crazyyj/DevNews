package com.newchar.devnews.util.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenliqiang
 * date 2019-07-16
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class OSCChinaHttpBuild {


    public static Build build(String address) {
        return new Build(address);
    }

    public static class Build {

        Map<String, String> params = new HashMap<>();
        {
            params.put(OSCField.Params.ACCESS_TOKEN, "");
            params.put(OSCField.Params.DATA_TYPE, OSCField.DataType.JSON);
        }

        public Build(String address) {

        }

        Build withString(String key, String value) {
            params.put(key, value);
            return this;
        }

    }

}
