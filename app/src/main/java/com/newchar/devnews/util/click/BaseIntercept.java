package com.newchar.devnews.util.click;

import android.os.Handler;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wenliqiang wenliqiang@100tal.com
 * date            2019-06-21
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public abstract class BaseIntercept implements Intercept {

    private int Default_Intercept_TIME = 800;
    private Map<Integer, Integer> enableMap = new LinkedHashMap<>();

    private Handler clickEventHandler = new Handler();

    private static final int MSG_CLICK_ING = 1;
    @Override
    public boolean onDefaultIntercept(@NonNull View target) {
        Integer interceptTag = enableMap.get(target.hashCode());
        if (interceptTag != null && interceptTag > Intercept.DefaultInterceptDISEnable) {
            if (!clickEventHandler.hasMessages(MSG_CLICK_ING)) {
                clickEventHandler.sendEmptyMessageDelayed(MSG_CLICK_ING, interceptTag);
            }
        }
        return false;
    }

    @Override
    public final void setDefaultInterceptEnable(View tag, int enable) {
        enableMap.put(tag.hashCode(), enable);
    }


}
