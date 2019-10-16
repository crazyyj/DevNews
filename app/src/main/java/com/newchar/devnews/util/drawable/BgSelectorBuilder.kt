package com.newchar.devnews.util.drawable

import android.graphics.drawable.Drawable
import android.graphics.drawable.StateListDrawable

/**
 * @author wenliqiang
 * date 2019-09-16
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
class BgSelectorBuilder {

    private var mSelector: StateListDrawable = StateListDrawable()

    fun press(press: Drawable): BgSelectorBuilder {
        return addState(ISelectorBuilder.STATE_PRESS, press)
    }

    fun active(active: Drawable): BgSelectorBuilder {
        return addState(ISelectorBuilder.STATE_ACTIVE, active)
    }

    fun checked(checked: Drawable): BgSelectorBuilder {
        return addState(ISelectorBuilder.STATE_CHECKED, checked)
    }

    fun _default(default: Drawable): BgSelectorBuilder {
        return addState(ISelectorBuilder.STATE_DEFAULT, default)
    }

    fun enabled(enabled: Drawable): BgSelectorBuilder {
        return addState(ISelectorBuilder.STATE_ENABLED, enabled)
    }

    fun focused(focused: Drawable): BgSelectorBuilder {
        return addState(ISelectorBuilder.STATE_FOCUSED, focused)
    }

    fun selected(selected: Drawable): BgSelectorBuilder {
        return addState(ISelectorBuilder.STATE_SELECTED, selected)
    }

    fun checkable(checkable: Drawable): BgSelectorBuilder {
        return addState(ISelectorBuilder.STATE_CHECKABLE, checkable)
    }

    fun longPressable(longPressable: Drawable): BgSelectorBuilder {
        return addState(ISelectorBuilder.STATE_LONG_PRESSABLE, longPressable)
    }

    fun windowFocused(windowFocused: Drawable): BgSelectorBuilder {
        return addState(ISelectorBuilder.STATE_WINDOW_FOCUSED, windowFocused)
    }

    fun addState(states: IntArray, drawable: Drawable): BgSelectorBuilder {
        mSelector.addState(states, drawable)
        return this
    }

    fun build(): Drawable {
        return mSelector.mutate()
    }

}
