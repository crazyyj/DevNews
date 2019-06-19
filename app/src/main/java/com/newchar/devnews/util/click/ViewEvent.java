package com.newchar.devnews.util.click;

import android.view.View;

/**
 * @author wenliqiang
 * date 2019-06-17
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class ViewEvent extends ClickEventCompat implements IEvent {


    @Override
    public void execute(View view) {
        click(view);
    }

}
