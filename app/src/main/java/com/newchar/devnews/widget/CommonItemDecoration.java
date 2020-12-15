package com.newchar.devnews.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.newchar.devnews.util.NewLog;

/**
 * @author newChar
 * date 2020/12/7
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class CommonItemDecoration extends RecyclerView.ItemDecoration {

    public CommonItemDecoration() {
        super();
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.top = 20;
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        final int childCount = parent.getChildCount();
        c.save();
        for (int i = 0; i < childCount; i++) {
//            final RecyclerView.ViewHolder childViewHolder = parent.getChildViewHolder(parent.getChildAt(i));
            final View child = parent.getChildAt(i);
            final int top = child.getTop();
            final Paint paint = new Paint();
            paint.setColor(Color.RED);
            paint.setStrokeWidth(50F);
            c.drawRect(0, 50F, child.getWidth(), 60, paint);
        }
        c.restore();
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        // 最后绘制，绘制在整体的上层。
    }
}
