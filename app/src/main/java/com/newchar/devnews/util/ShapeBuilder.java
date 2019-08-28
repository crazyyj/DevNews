package com.newchar.devnews.util;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/**
 * @author wenliqiang
 * date 2019-08-26
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class ShapeBuilder {

    private final GradientDrawable drawable = new GradientDrawable();
    /**
     * 形状：
     */
    private int shape;

    /**
     * 四边圆角半径
     */
    private float mCornerRadius;

    private float mLeftTopCornerRadius;
    private float mRightTopCornerRadius;
    private float mLeftBottomCornerRadius;
    private float mRightBottomCornerRadius;
    private int width = -1;
    private int height = -1;

    /**
     * 实心颜色
     */
    private int solidColor;

    private float dashGap;
    private int dashColor;
    private float dashLineWidth;
    private int dashWidth;

    private float paddingTop;
    private float paddingLeft;
    private float paddingRight;
    private float paddingBottom;

    /**
     * GradientDrawable.SWEEP_GRADIENT
     */
    private int gType;
    private float gAngle;
    private float gCenterX;
    private float gCenterY;
    private float gStartColor;
    private float gCenterColor;
    private float gEndColor;
    private float gGradientRadius;

    private ShapeBuilder(int shape) {
        this.shape = shape;
    }

    public static ShapeBuilder rectangle() {
        return new ShapeBuilder(GradientDrawable.RECTANGLE);
    }

    public static ShapeBuilder ring() {
        return new ShapeBuilder(GradientDrawable.RING);
    }

    public static ShapeBuilder line() {

        return new ShapeBuilder(GradientDrawable.LINE);
    }

    public static ShapeBuilder oval() {
        return new ShapeBuilder(GradientDrawable.OVAL).width(1).height(1);
    }

    public ShapeBuilder cornerRadius(float corner) {
        mCornerRadius = corner;
        return this;
    }

    public ShapeBuilder gradientAngle(float angle) {
        gAngle = angle;
        return this;
    }

    public ShapeBuilder centerColor(float color) {
        gCenterColor = color;
        return this;
    }


    public ShapeBuilder gStartColor(float color) {
        gStartColor = color;
        return this;
    }

    public ShapeBuilder gEndColor(float color) {
        gEndColor = color;
        return this;
    }

    public ShapeBuilder gType(int type) {
        gType = type;
        return this;
    }

    public ShapeBuilder gGradientRadius(float radius) {
        gGradientRadius = radius;
        return this;
    }

    public ShapeBuilder gCenterY(float centerY) {
        gCenterY = centerY;
        return this;
    }

    public ShapeBuilder gCenterX(float centerX) {
        gCenterX = centerX;
        return this;
    }

    public ShapeBuilder leftBottomCornerRadius(float corner) {
        mLeftBottomCornerRadius = corner;
        return this;
    }

    public ShapeBuilder leftTopCornerRadius(float corner) {
        mLeftTopCornerRadius = corner;
        return this;
    }

    public ShapeBuilder rightTopCornerRadius(float corner) {
        mRightTopCornerRadius = corner;
        return this;
    }

    public ShapeBuilder rightBottomCornerRadius(float corner) {
        mRightBottomCornerRadius = corner;
        return this;
    }

    public ShapeBuilder dashGap(float gap) {
        dashGap = gap;
        return this;
    }

    public ShapeBuilder paddingTop(float padding) {
        paddingTop = padding;
        return this;
    }

    public ShapeBuilder paddingBottom(float padding) {
        paddingBottom = padding;
        return this;
    }

    public ShapeBuilder paddingLeft(float padding) {
        paddingLeft = padding;
        return this;
    }

    public ShapeBuilder paddingRight(float padding) {
        paddingRight = padding;
        return this;
    }

    public ShapeBuilder solidColor(int color) {
        solidColor = color;
        return this;
    }

    public ShapeBuilder dashColor(int color) {
        dashColor = color;
        return this;
    }

    public ShapeBuilder dashWidth(int width) {
        dashWidth = width;
        return this;
    }

    public ShapeBuilder dashLineWidth(int width) {
        dashLineWidth = width;
        return this;
    }

    public ShapeBuilder dashColor(String color) {
        dashColor = Color.parseColor(color);
        return this;
    }

    public ShapeBuilder width(int px) {
        this.width = px;
        return this;
    }

    public ShapeBuilder height(int px) {
        this.height = px;
        return this;
    }

    public Drawable build() {
        drawable.setShape(shape);
        drawable.setSize(width, height);
//        drawable.setGradientRadius(gGradientRadius);
//        drawable.setStroke(dashGapWidth, dashColor, dashLineWidth,dashGap);

        drawable.setCornerRadii(new float[]{
                getAvailableCorner(mLeftTopCornerRadius), getAvailableCorner(mLeftTopCornerRadius),
                getAvailableCorner(mRightTopCornerRadius), getAvailableCorner(mRightTopCornerRadius),
                getAvailableCorner(mLeftBottomCornerRadius), getAvailableCorner(mLeftBottomCornerRadius),
                getAvailableCorner(mRightBottomCornerRadius), getAvailableCorner(mRightBottomCornerRadius)
        });
        drawable.setColor(solidColor);

        if (dashWidth > 0) {
            drawable.setStroke(dashWidth, dashColor, dashLineWidth, dashGap);
        }
        return drawable.mutate();
    }

    private float getAvailableCorner(float corner) {
        return corner == 0.0f ? mCornerRadius : corner;
    }

}
