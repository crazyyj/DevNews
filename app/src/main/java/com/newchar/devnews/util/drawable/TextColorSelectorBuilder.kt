package com.newchar.devnews.util.drawable

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable

/**
 *  @author         wenliqiang@100tal.com
 *  date            2019-09-18
 *  @version
 *  @since          当前版本描述，
 *  @since          迭代版本描述
 */
class TextColorSelectorBuilder : ISelectorBuilder {

    private val mSelector: ColorStateList = ColorStateList.valueOf(Color.parseColor("#000000"))

    override fun press(press: Drawable): TextColorSelectorBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun active(active: Drawable): TextColorSelectorBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun enabled(enabled: Drawable): TextColorSelectorBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun focused(focused: Drawable): TextColorSelectorBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun checked(checked: Drawable): TextColorSelectorBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun selected(selected: Drawable): TextColorSelectorBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun checkable(checkable: Drawable): TextColorSelectorBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun longPressable(longPressable: Drawable): TextColorSelectorBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun windowFocused(windowFocused: Drawable): TextColorSelectorBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addState(states: IntArray, drawable: Drawable): TextColorSelectorBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun build(): ColorStateList {
        return mSelector
    }

    override fun default(default: Drawable): TextColorSelectorBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}