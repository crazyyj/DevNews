package com.newchar.devnews.util;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.newchar.devnews.util.constant.ConstantField;

/**
 * @author wenliqiang
 * date 2019-06-23
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class CommonUtils {

    public static boolean isNull(Object object) {
        return object == ConstantField.NULL;
    }


    public static String getText(TextView tv){
        return tv.getText().toString().trim();
    }

    public static Spanned getHTMLText(String html) {
        final Spanned htmlResult;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //flag：html每个标签，使用2个换行符
            htmlResult = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            htmlResult = Html.fromHtml(html);
        }
        return htmlResult;
    }

    /**
     * 弹出软键盘
     * @param editText
     *            输入框
     * @param context
     *            上下文
     */
    public static void openKeybord(EditText editText, Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.RESULT_SHOWN);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    /**
     * 关闭软键盘
     * @param v
     *            当前Activity 的焦点View ，通常为正在编辑的EditText
     * @param context
     *            上下文
     * @category
     * 			使用方法 CommonUtils.closeKeybord(this.getCurrentFocus(),this);
     */
    public static void closeKeybord(View v, Context context) {
        InputMethodManager imm = (InputMethodManager)
                context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (v != null)
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
