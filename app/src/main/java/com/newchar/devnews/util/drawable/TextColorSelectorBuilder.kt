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
class TextColorSelectorBuilder :ISelectorBuilder{

    private val mSelector: ColorStateList = ColorStateList.valueOf(Color.parseColor("#000000"))

    override fun press(press: Drawable): ISelectorBuilder {
//return mSelector.withAlpha()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun active(active: Drawable): ISelectorBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun enabled(enabled: Drawable): ISelectorBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun focused(focused: Drawable): ISelectorBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun checked(checked: Drawable): ISelectorBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun selected(selected: Drawable): ISelectorBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun checkable(checkable: Drawable): ISelectorBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun longPressable(longPressable: Drawable): ISelectorBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun windowFocused(windowFocused: Drawable): ISelectorBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addState(states: IntArray, drawable: Drawable): ISelectorBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun build(): Drawable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun default(default: Drawable): ISelectorBuilder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}