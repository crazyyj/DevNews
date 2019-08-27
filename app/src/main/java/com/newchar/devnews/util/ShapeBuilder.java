package com.newchar.devnews.util;

import android.graphics.Color;
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
    private int width;
    private int height;

    /**
     * 实心颜色
     */
    private int solidColor;

    private float dashGap;
    private float dashColor;
    private float dashGapWidth;
    private float dashLineWidth;

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
        dashLineWidth = width;
        return this;
    }

    public ShapeBuilder dashGapWidth(int width) {
        dashGapWidth = width;
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

    public GradientDrawable build() {
        return (GradientDrawable) drawable.mutate();
    }



}
