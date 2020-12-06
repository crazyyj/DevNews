package com.newchar.devnews.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;

/**
 * @author newChar
 * date 2020/12/6
 * @since 用于获取后台的Handler
 * @since 迭代版本，（以及描述）
 */
public final class HandlerFactory {

    private static final HandlerThread looperThread;
    private static final String THREAD_NAME = "ACTION_THREAD";

    static {
        looperThread = new HandlerThread(THREAD_NAME, Process.THREAD_PRIORITY_BACKGROUND);
        looperThread.start();
    }

    /**
     * 获取后台Handler
     *
     * @return 一个handMessage 运行在工作线程的Handler
     */
    public static Handler getBackgroundHandler() {
        return new Handler(getLooper());
    }

    /**
     * 获取后台Handler,并且可以设置Callback
     *
     * @param callback Handler中的消息回调
     * @return handleMessage(Message msg) 运行在工作线程的Handler
     */
    public static Handler getBackgroundHandler(Handler.Callback callback) {
        return new Handler(getLooper(), callback);
    }

    /**
     * 获取工作线程中的looper对象，会改成public 供外部使用。
     *
     * @return 工作线程的 Looper 对象
     */
    private static Looper getLooper() {
        return looperThread.getLooper();
    }

}
