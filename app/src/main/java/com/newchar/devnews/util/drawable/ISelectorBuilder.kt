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

    /**
     * 按下
     */
    fun press(drawable: Drawable)

    fun active(drawable: Drawable)

}