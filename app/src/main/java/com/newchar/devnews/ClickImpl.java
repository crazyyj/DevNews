package com.newchar.devnews;

import android.os.Handler;
import android.view.View;

import com.newchar.devnews.util.click.Way;


/**
 * @author wenliqiang
 * date 2019-06-23
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class ClickImpl implements Way {

    /**
     * 点击间隔的标记
     */
    private static final int MSG_CLICK_INTERVAL = 1;

    /**
     * 点击的时长
     */
    private int INTERVAL_CLICK_COMMON ;

    public ClickImpl(int interval) {
        super();
        INTERVAL_CLICK_COMMON = interval;
    }

    public ClickImpl() {
        this(1200);
    }

    private final Handler mClickIntervalHandler = new Handler();

    @Override
    public boolean isShouldExecute(View view) {
        return mClickIntervalHandler.hasMessages(MSG_CLICK_INTERVAL);
    }

    @Override
    public boolean onExecute(View view) {
        return false;
    }

}
