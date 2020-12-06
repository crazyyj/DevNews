package com.newchar.devnews.util;

import android.util.Log;

/**
 * @author newChar
 * date 2020/12/6
 * @since Log 打印类
 * @since 迭代版本，（以及描述）
 */
public class NewLog {

    /**
     * 是否需要打印log
     */
    public static volatile boolean isNeedPrintLog = true;

    /**
     * 每次打印，调用调用栈的上一级name。获取实际运行类的类名，打印TAG
     *
     * @param logMsg 需要输出的log信息
     */
    public static void e(String logMsg) {
        if (isNeedPrintLog) {
            Log.e("NewLog", logMsg);
        }
    }

    public void methodDes() {
        final StackTraceElement[] stackElements = new Throwable().getStackTrace();
        if (stackElements != null) {
            System.out.println("-----------------------------------");
            for (int i = 0; i < stackElements.length; i++) {
                System.out.print(stackElements[i].getClassName()+"\t");
                System.out.print(stackElements[i].getFileName()+"\t");
                System.out.print(stackElements[i].getLineNumber()+"\t");
                System.out.println(stackElements[i].getMethodName());
            }
        }
    }

}
