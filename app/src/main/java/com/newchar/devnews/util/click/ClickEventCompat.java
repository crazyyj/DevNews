package com.newchar.devnews.util.click;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import android.util.SparseLongArray;
import android.view.View;

import java.util.HashMap;

/**
 * @author wenliqiang wenliqiang@100tal.com
 * date            2019-06-16
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public class ClickEventCompat implements IClickEventCompat {

    private final static int clickIntervalDefault = 800;
    private int clickInterval = clickIntervalDefault;

    private static final int MSG_CLICK_ING = 1;
    private Handler clickEventHandler = new Handler();

    void click(View view) {
        interceptClickEvent(view);
    }

    public void setClickInterval(int clickInterval) {
        this.clickInterval = clickInterval;
    }

    private void interceptClickEvent(View view) {
        if (!clickEventHandler.hasMessages(MSG_CLICK_ING) && !onInterceptClickEvent(view)) {
            clickCompat(view);

            clickEventHandler.sendMessageDelayed(clickEventHandler.obtainMessage(MSG_CLICK_ING, view.hashCode()), clickInterval);
        }
    }

    private void clickCompat(View view) {
        if (!onClickCompat(view)) {
            onClickEnd(view);
        }
    }


    @Override
    public boolean onInterceptClickEvent(View clickView) {
        return false;
    }

    @Override
    public boolean onClickCompat(View clickView) {
        return false;
    }

    @Override
    public void onClickEnd(View clickView) {

    }

    public void destroy() {

    }

}
