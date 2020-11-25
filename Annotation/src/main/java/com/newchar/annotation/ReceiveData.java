package com.newchar.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author newChar
 * date 2020/10/21
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReceiveData {

    String value() default "";

}
