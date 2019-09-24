package com.newchar.devnews.util.drawable

import android.graphics.drawable.Drawable

/**
 *  @author         wenliqiang@100tal.com
 *  date            2019-09-18
 *  @version
 *  @since          当前版本描述，
 *  @since          迭代版本描述
 */
class SelectorCreator(private val selectorBuilder: ISelectorBuilder) : ISelectorBuilder {

    override fun press(press: Drawable): ISelectorBuilder {
        return selectorBuilder.press(press)
    }

    override fun active(active: Drawable): ISelectorBuilder {
        return selectorBuilder.active(active)
    }

    override fun enabled(enabled: Drawable): ISelectorBuilder {
        return selectorBuilder.enabled(enabled)
    }

    override fun focused(focused: Drawable): ISelectorBuilder {
        return selectorBuilder.focused(focused)
    }

    override fun checked(checked: Drawable): ISelectorBuilder {
        return selectorBuilder.checked(checked)
    }

    override fun default(default: Drawable): ISelectorBuilder {
        return selectorBuilder.default(default)
    }

    override fun selected(selected: Drawable): ISelectorBuilder {
        return selectorBuilder.selected(selected)
    }

    override fun checkable(checkable: Drawable): ISelectorBuilder {
        return selectorBuilder.checkable(checkable)
    }

    override fun longPressable(longPressable: Drawable): ISelectorBuilder {
        return selectorBuilder.longPressable(longPressable)
    }

    override fun windowFocused(windowFocused: Drawable): ISelectorBuilder {
        return selectorBuilder.windowFocused(windowFocused)
    }

    override fun addState(states: IntArray, drawable: Drawable): ISelectorBuilder {
        return selectorBuilder.addState(states, drawable)
    }

    override fun build(): Drawable {
        return selectorBuilder.build() as Drawable
    }

}