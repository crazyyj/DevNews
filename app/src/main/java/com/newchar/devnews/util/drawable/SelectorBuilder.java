package com.newchar.devnews.util.drawable;

import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.StateListDrawable;

import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;

/**
 * @author wenliqiang
 * date 2019-09-16
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class SelectorBuilder {

    private static DrawableContainer mSelector = new StateListDrawable();

//    private AnimatedStateListDrawable

    private int[] STATE_PRESS = new int[]{ android.R.attr.state_pressed };
    private int[] STATE_PRESS_NO = new int[]{ -android.R.attr.state_pressed };

    private int[] STATE_ACTIVE= new int[]{ android.R.attr.state_active };
    private int[] STATE_ACTIVE_NO = new int[]{ -android.R.attr.state_active};

    private int[] STATE_ENABLED = new int[]{ android.R.attr.state_enabled };
    private int[] STATE_ENABLED_NO = new int[]{ -android.R.attr.state_enabled };

    private int[] STATE_CHECKED = new int[]{ android.R.attr.state_checked };
    private int[] STATE_CHECKED_NO = new int[]{ -android.R.attr.state_checked };

    private int[] STATE_FOCUSED = new int[]{ android.R.attr.state_focused };
    private int[] STATE_FOCUSED_NO = new int[]{ -android.R.attr.state_window_focused };

    private int[] STATE_SELECTED = new int[]{ android.R.attr.state_selected };
    private int[] STATE_SELECTED_NO = new int[]{ -android.R.attr.state_selected };

    private int[] STATE_CHECKABLE = new int[]{ android.R.attr.state_checkable };
    private int[] STATE_CHECKABLE_NO = new int[]{ -android.R.attr.state_checkable };

    private int[] STATE_LONG_PRESSABLE = new int[]{ android.R.attr.state_long_pressable };
    private int[] STATE_LONG_PRESSABLE_NO = new int[]{ -android.R.attr.state_long_pressable };

    private int[] STATE_WINDOW_FOCUSED = new int[]{ android.R.attr.state_window_focused };
    private int[] STATE_WINDOW_FOCUSED_NO = new int[]{ -android.R.attr.state_window_focused };

    private SelectorBuilder(int style) {
        switch (style) {
            case 1:
                mSelector = new StateListDrawable();
                break;
            case 2:
                mSelector = new AnimatedStateListDrawableCompat();
                break;

        }
    }

    public static SelectorBuilder getSelector(int style) {
        return new SelectorBuilder(style);
    }

    public SelectorBuilder checked(Drawable checked) {
        return addState(STATE_CHECKED, checked);
    }

    public SelectorBuilder press(Drawable pressDrawable) {
        return addState(STATE_PRESS, pressDrawable);
    }

    public SelectorBuilder checkable(Drawable checkable) {
        return addState(STATE_CHECKABLE, checkable);
    }

    public SelectorBuilder active(Drawable activeDrawable) {
        return addState(STATE_ACTIVE, activeDrawable);
    }

    public SelectorBuilder enabled(Drawable enableDrawable) {
        return addState(STATE_ENABLED, enableDrawable);
    }

    public SelectorBuilder focused(Drawable focusedDrawable) {
        return addState(STATE_FOCUSED, focusedDrawable);
    }

    public SelectorBuilder selected(Drawable selectedDrawable) {
        return addState(STATE_SELECTED, selectedDrawable);
    }

    public SelectorBuilder longPressable(Drawable longPressable) {
        return addState(STATE_LONG_PRESSABLE, longPressable);
    }

    public SelectorBuilder windowFocused(Drawable windowFocused) {
        return addState(STATE_WINDOW_FOCUSED, windowFocused);
    }

    public SelectorBuilder addState(int[] states, Drawable stateDrawable) {
        mSelector.addState(states, stateDrawable);
        return this;
    }




    public Drawable build() {
        return mSelector.mutate();
    }

}
