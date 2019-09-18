package com.newchar.devnews.util.drawable

import android.graphics.drawable.Drawable
import android.graphics.drawable.StateListDrawable

/**
 * @author wenliqiang
 * date 2019-09-16
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
class BgSelectorBuilder : ISelectorBuilder {

    private var mSelector: StateListDrawable = StateListDrawable()

    override fun press(press: Drawable): BgSelectorBuilder {
        return addState(ISelectorBuilder.STATE_PRESS, press)
    }

    override fun active(active: Drawable): BgSelectorBuilder {
        return addState(ISelectorBuilder.STATE_ACTIVE, active)
    }

    override fun checked(checked: Drawable): BgSelectorBuilder {
        return addState(ISelectorBuilder.STATE_CHECKED, checked)
    }

    override fun default(default: Drawable): BgSelectorBuilder {
        return addState(ISelectorBuilder.STATE_DEFAULT, default)
    }

    override fun enabled(enabled: Drawable): BgSelectorBuilder {
        return addState(ISelectorBuilder.STATE_ENABLED, enabled)
    }

    override fun focused(focused: Drawable): BgSelectorBuilder {
        return addState(ISelectorBuilder.STATE_FOCUSED, focused)
    }

    override fun selected(selected: Drawable): BgSelectorBuilder {
        return addState(ISelectorBuilder.STATE_SELECTED, selected)
    }

    override fun checkable(checkable: Drawable): BgSelectorBuilder {
        return addState(ISelectorBuilder.STATE_CHECKABLE, checkable)
    }

    override fun longPressable(longPressable: Drawable): BgSelectorBuilder {
        return addState(ISelectorBuilder.STATE_LONG_PRESSABLE, longPressable)
    }

    override fun windowFocused(windowFocused: Drawable): BgSelectorBuilder {
        return addState(ISelectorBuilder.STATE_WINDOW_FOCUSED, windowFocused)
    }

    override fun addState(states: IntArray, drawable: Drawable): BgSelectorBuilder {
        mSelector.addState(states, drawable)
        return this
    }

    override fun build(): Drawable {
        return mSelector.mutate()
    }

}
