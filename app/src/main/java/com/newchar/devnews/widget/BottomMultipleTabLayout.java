package com.newchar.devnews.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;

import com.google.android.flexbox.FlexboxLayout;

/**
 * @author wenliqiang
 * date 2020/6/23
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class BottomMultipleTabLayout extends FlexboxLayout {

    public BottomMultipleTabLayout(Context context) {
        super(context);
    }

    public BottomMultipleTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomMultipleTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setBottomTab() {

    }

    public BottomTab newTab() {
        return new BottomTab();
    }

    static class BottomTab {

        /**
         * 默认标题
         */
        private String title;

        /**
         * 描述
         */
        private String desc;

        /**
         * 图标
         */
        private Bitmap mIcon;

        /**
         * 是否是存进去的View
         */
        private boolean isCustom;

        /**
         * 自定义View 展示，或者当前默认的View
         */
        private View mTabView;

    }

}
