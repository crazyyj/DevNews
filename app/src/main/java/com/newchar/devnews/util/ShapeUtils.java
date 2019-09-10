package com.newchar.devnews.util;

import android.graphics.Color;
import android.graphics.drawable.Drawable;

/**
 * @author wenliqiang
 * date 2019-09-07
 * @since Shape建造者，工具类
 * @since 迭代版本，（以及描述）
 */
public class ShapeUtils {

    public static Drawable getWitBg() {
        return ShapeBuilder.rectangle()
                .leftBottomCornerRadius(100)
                .cornerRadius(200)
                .dashColor(Color.parseColor("#FFFFFF"))
                .dashGapWidth(100)
                .dashLineWidth(10)
                .dashWidth(5)
                .solidColor(Color.parseColor("#FF0034"))
                .build();
    }

}
