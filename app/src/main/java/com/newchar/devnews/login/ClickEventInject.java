package com.newchar.devnews.login;

import android.app.Activity;
import android.view.View;

import com.newchar.devnews.main.contract.Contract;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

/**
 * @author newChar
 * date 2020/11/3
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class ClickEventInject {

    public static void inject(Activity activity) {
        final Class<? extends Activity> cls = activity.getClass();
        //获取全部公开方法
        final Method[] methods = cls.getMethods();
        final int methodNumber = methods.length;
        for (int i = 0; i < methodNumber; i++) {
            final Method method = methods[i];
            if (method.isAnnotationPresent(ClickEvent.class)) {
                System.out.println(" " + " 找到注解方法");
                final Class<?>[] parameterTypes = method.getParameterTypes();
                for (int j = 0; j < parameterTypes.length; j++) {
                    System.out.println(" 参数是？" + parameterTypes[j].getName());
                }
                //方法上发现注解
                final ClickEvent clickAnnotation = method.getAnnotation(ClickEvent.class);
                final int[] value = clickAnnotation.value();
                for (int num = 0; num < value.length; num++) {
                    final View clickView = activity.findViewById(value[num]);
                    clickView.setOnClickListener(new ClickEventAction(method, activity));
                }
            }
        }
    }

    private static class ClickEventAction implements View.OnClickListener {

        private final SoftReference<Method> mMethod;
        private final WeakReference<Activity> mActivity;

        public ClickEventAction(Method method, Activity activity) {
            mMethod = new SoftReference<>(method);
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void onClick(View v) {
            try {
                final Method method = mMethod.get();
                if (method != null && mActivity.get() != null ) {
                    method.invoke(mActivity.get(), v);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

}
