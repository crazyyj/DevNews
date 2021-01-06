package com.newchar.devnews.custom.statelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;

import java.util.ArrayList;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-22
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public class StateLayout extends FrameLayout {

    /**
     * key ： layoutId
     * <p>
     * Value ：StateView
     */
    private SparseArrayCompat<View> stateViews = new SparseArrayCompat<>();

    private ArrayList<IMultiState> multiStates = new ArrayList<IMultiState>();

    public StateLayout(@NonNull Context context) {
        this(context, null);
    }

    public StateLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StateLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    private void initialize(Context context) {

    }

    public void switchStateLayout(int state) {

    }


}
