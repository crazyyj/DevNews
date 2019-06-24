package com.newchar.devnews.util;


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

    public static void main(String[] a) {
        User user = new User();
        boolean aNull = isNull(user);

        System.out.println(aNull);
    }

    static class User{

        public User() {
        }
    }

}
