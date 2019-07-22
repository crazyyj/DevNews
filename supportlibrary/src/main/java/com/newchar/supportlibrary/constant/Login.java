package com.newchar.supportlibrary.constant;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-17
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public interface Login {

    interface Channel {

        String OSC = "osChina";

        String JUEJIN = "jueJin";

    }

    @StringDef({Channel.OSC, Channel.JUEJIN})
    @Retention(RetentionPolicy.SOURCE)
    @interface LoginChannel {
    }

}
