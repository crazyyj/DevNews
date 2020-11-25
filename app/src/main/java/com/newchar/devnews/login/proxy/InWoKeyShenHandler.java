package com.newchar.devnews.login.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author newChar
 * date 2020/11/3
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class InWoKeyShenHandler implements InvocationHandler {

    private Object mProxy;
    private Object mProxy1;

    public InWoKeyShenHandler(Class<?>[] interfaces) {
        mProxy = Proxy.newProxyInstance(interfaces[0].getClassLoader(), interfaces, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("ff " + method.getName());
        method.invoke(mProxy1, args);
        return "";
    }

    public Object getProxy() {
        return mProxy;
    }


    public void setProxy(Object mProxy1) {
        this.mProxy1 = mProxy1;
    }

    public class AAA{
        public AAA() {
        }
    }
}
