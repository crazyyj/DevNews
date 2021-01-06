package com.newchar.devnews.util.drawable

import android.graphics.drawable.Drawable

/**
 *  @author         wenliqiang@100tal.com
 *  date            2019-09-17
 *  @version
 *  @since          当前版本描述，
 *  @since          迭代版本描述
 */
interface ISelectorBuilder {


    companion object {

        val STATE_DEFAULT = intArrayOf()

        val STATE_PRESS = intArrayOf(android.R.attr.state_pressed)
//        val STATE_PRESS_NO = intArrayOf(-android.R.attr.state_pressed)

        val STATE_ACTIVE = intArrayOf(android.R.attr.state_active)
//        val STATE_ACTIVE_NO = intArrayOf(-android.R.attr.state_active)

        val STATE_ENABLED = intArrayOf(android.R.attr.state_enabled)
//        val STATE_ENABLED_NO = intArrayOf(-android.R.attr.state_enabled)

        val STATE_CHECKED = intArrayOf(android.R.attr.state_checked)
//        val STATE_CHECKED_NO  = intArrayOf(-android.R.attr.state_checked)

        val STATE_FOCUSED = intArrayOf(android.R.attr.state_focused)
//        val STATE_FOCUSED_NO  = intArrayOf(-android.R.attr.state_window_focused)

        val STATE_SELECTED = intArrayOf(android.R.attr.state_selected)
//        val STATE_SELECTED_NO = intArrayOf(-android.R.attr.state_selected)

        val STATE_CHECKABLE = intArrayOf(android.R.attr.state_checkable)
//        val STATE_CHECKABLE_NO = intArrayOf(-android.R.attr.state_checkable)

        val STATE_LONG_PRESSABLE = intArrayOf(android.R.attr.state_long_pressable)
//        val STATE_LONG_PRESSABLE_NO = intArrayOf(-android.R.attr.state_long_pressable)

        val STATE_WINDOW_FOCUSED = intArrayOf(android.R.attr.state_window_focused)
//        val STATE_WINDOW_FOCUSED_NO = intArrayOf(-android.R.attr.state_window_focused)

    }

    fun default(default: Drawable): ISelectorBuilder

    /**
     * 按下
     */
    fun press(press: Drawable): ISelectorBuilder

    fun active(active: Drawable): ISelectorBuilder

    fun enabled(enabled: Drawable): ISelectorBuilder

    fun focused(focused: Drawable): ISelectorBuilder

    fun checked(checked: Drawable): ISelectorBuilder

    fun selected(selected: Drawable): ISelectorBuilder

    fun checkable(checkable: Drawable): ISelectorBuilder

    fun longPressable(longPressable: Drawable): ISelectorBuilder

    fun windowFocused(windowFocused: Drawable): ISelectorBuilder

    fun addState(states: IntArray, drawable: Drawable): ISelectorBuilder

    fun build(): Any

}
