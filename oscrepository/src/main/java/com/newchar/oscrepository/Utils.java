package com.newchar.oscrepository;

import org.json.JSONArray;

/**
 * @author newChar
 * date 2021/1/6
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class Utils {

    public static boolean isEmpty(JSONArray jsonArray) {
        return jsonArray == null || jsonArray.length() < 1;
    }

}
