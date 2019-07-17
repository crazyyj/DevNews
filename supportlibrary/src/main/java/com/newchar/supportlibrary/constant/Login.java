package com.newchar.supportlibrary.constant;

import androidx.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-17
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public interface Login {

    interface Channle{

        int OSC = 1;

        int JUEJIN = 2;
    }

    @IntDef({Login.Channle.OSC, Login.Channle.JUEJIN})
    @Retention(RetentionPolicy.SOURCE)
    @Target(value = ElementType.FIELD)
    @interface LoginChannle {
    }

}
