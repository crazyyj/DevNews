package com.newchar.devnews.util;

import android.os.Handler;
import android.os.Looper;

/**
 * @author newChar
 * date 2020/12/22
 * @since 操作UI的工具类
 * @since 迭代版本，（以及描述）
 */
public class UIUtils {

    private static final Handler mH = new Handler(Looper.getMainLooper());

    public static void runOnUiThread(Runnable r) {
        if (Looper.getMainLooper().getThread().getId() == Looper.myLooper().getThread().getId()) {
            r.run();
        } else {
            mH.post(r);
        }
    }

}
