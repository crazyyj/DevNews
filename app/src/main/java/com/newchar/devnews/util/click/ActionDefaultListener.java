package com.newchar.devnews.util.click;

import android.os.Handler;
import android.view.View;

/**
 * @author wenliqiang wenliqiang@100tal.com
 * date            2019-06-21
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public class ActionDefaultListener implements ActionListener {

    private final static int clickIntervalDefault = 800;
    private int clickInterval = clickIntervalDefault;

    private static final int MSG_CLICK_ING = 1;
    private Handler clickEventHandler = new Handler();

    public void setClickInterval(int clickInterval) {
        this.clickInterval = clickInterval;
    }

    public void onViewClick(View view) {
        if (!clickEventHandler.hasMessages(MSG_CLICK_ING) && !onActionBefore(view)) {
            onAction(view);
            clickEventHandler.sendMessageDelayed(clickEventHandler.obtainMessage(MSG_CLICK_ING, view.hashCode()), clickInterval);
        }
    }

    @Override
    public boolean onActionBefore(View view) {

        return false;
    }

    @Override
    public boolean onAction(View view) {
        return false;
    }

}
