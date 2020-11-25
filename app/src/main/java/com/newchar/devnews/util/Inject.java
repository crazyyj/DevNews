package com.newchar.devnews.util;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import androidx.annotation.NonNull;

import com.newchar.annotation.NewClick;
import com.newchar.annotation.ReceiveData;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author wenliqiang
 * date 2020/10/21
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class Inject {

    public static void inject(@NonNull Activity activity) {
        final Class<? extends Activity> actClass = activity.getClass();
        final Field[] annotationField = actClass.getDeclaredFields();
        for (Field field : annotationField) {
            final boolean isInjectAnnotation = field.isAnnotationPresent(NewClick.class);
            if (isInjectAnnotation) {
                try {
                    final NewClick annotation = field.getAnnotation(NewClick.class);
                    final View view = activity.findViewById(annotation.viewId());
                    field.setAccessible(true);
                    field.set(activity, view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void injectData(Activity activity) {
        final Class<? extends Activity> activityClass = activity.getClass();
        //获取所有字段
        final Field[] declaredFields = activityClass.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(ReceiveData.class)) {
                try {
                    final ReceiveData annotation = field.getAnnotation(ReceiveData.class);
                    final String value = annotation.value();
                    final Bundle extras = activity.getIntent().getExtras();
                    Object o = extras.get(value);
                    if (field.getType().isArray() && Parcelable.class.isAssignableFrom(field.getType().getComponentType())) {
                        Object[] a = (Object[]) o;
//                        Object[] obs = Arrays.copyOf(a, a.length, Class<?>field.getType());
//                        o = obs;
                    }
                    field.setAccessible(true);
                    field.set(activity, o);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }


}
