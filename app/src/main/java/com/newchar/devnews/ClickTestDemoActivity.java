package com.newchar.devnews;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.newchar.devnews.util.click.ActionListener;
import com.newchar.devnews.util.click.ViewEvent;

/**
 * @author wenliqiang
 * date 2019-06-23
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class ClickTestDemoActivity extends AppCompatActivity {


    private ViewEvent event;
    private boolean is;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_demo);
        event = new ViewEvent();
        event.setActionListener(new ActionListener() {
            @Override
            public boolean onActionBefore(View view) {
                Log.e("onActionBefore", "点击，是不是拦截了呢" + is);
                is = !is;
                return is;
            }

            @Override
            public boolean onAction(View view) {
                Toast.makeText(ClickTestDemoActivity.this, "点击类 ", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        findViewById(R.id.btnClickTest).setOnClickListener(onClickListener);
    }

    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            event.clickCompat(v);
        }
    };

    @Override
    protected void onDestroy() {
        event.destroy();
        super.onDestroy();

    }
}
