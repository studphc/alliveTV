package com.google.common.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* loaded from: classes2.dex */
public abstract class AbstractInvocationHandler implements InvocationHandler {

    /* renamed from: a */
    public static final Object[] f15219a = new Object[0];

    public boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @CheckForNull
    public abstract Object handleInvocation(Object obj, Method method, Object[] objArr);

    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.lang.reflect.InvocationHandler
    @CheckForNull
    public final Object invoke(Object obj, Method method, @CheckForNull Object[] objArr) {
        if (objArr == null) {
            objArr = f15219a;
        }
        if (objArr.length == 0 && method.getName().equals("hashCode")) {
            return Integer.valueOf(hashCode());
        }
        boolean z = true;
        if (objArr.length == 1 && method.getName().equals("equals") && method.getParameterTypes()[0] == Object.class) {
            Object obj2 = objArr[0];
            if (obj2 == null) {
                return Boolean.FALSE;
            }
            if (obj == obj2) {
                return Boolean.TRUE;
            }
            Class<?> cls = obj.getClass();
            if ((!cls.isInstance(obj2) && (!Proxy.isProxyClass(obj2.getClass()) || !Arrays.equals(obj2.getClass().getInterfaces(), cls.getInterfaces()))) || !equals(Proxy.getInvocationHandler(obj2))) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        if (objArr.length == 0 && method.getName().equals("toString")) {
            return toString();
        }
        return handleInvocation(obj, method, objArr);
    }

    public String toString() {
        return super.toString();
    }
}
