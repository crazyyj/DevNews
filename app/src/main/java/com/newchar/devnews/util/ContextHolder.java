package com.newchar.devnews.util;

import android.content.Context;

/**
 * @author newChar
 * date 2020/11/25
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public final class ContextHolder {

    public static volatile Context appContext;

    public static void initialize(Context context) {
        appContext = context;
    }

    public static Context get() {
        return appContext;
    }

}