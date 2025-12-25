package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: androidx.lifecycle.c */
/* loaded from: classes.dex */
public final class C0417c {

    /* renamed from: c */
    public static final C0417c f6583c = new C0417c();

    /* renamed from: a */
    public final HashMap f6584a = new HashMap();

    /* renamed from: b */
    public final HashMap f6585b = new HashMap();

    /* renamed from: b */
    public static void m1541b(HashMap hashMap, C0416b c0416b, Lifecycle.Event event, Class cls) {
        Lifecycle.Event event2 = (Lifecycle.Event) hashMap.get(c0416b);
        if (event2 != null && event != event2) {
            throw new IllegalArgumentException("Method " + c0416b.f6582b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
        }
        if (event2 == null) {
            hashMap.put(c0416b, event);
        }
    }

    /* renamed from: a */
    public final C0415a m1542a(Class cls, Method[] methodArr) {
        int i;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = this.f6584a;
        if (superclass != null) {
            C0415a c0415a = (C0415a) hashMap2.get(superclass);
            if (c0415a == null) {
                c0415a = m1542a(superclass, null);
            }
            hashMap.putAll(c0415a.f6580b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            C0415a c0415a2 = (C0415a) hashMap2.get(cls2);
            if (c0415a2 == null) {
                c0415a2 = m1542a(cls2, null);
            }
            for (Map.Entry entry : c0415a2.f6580b.entrySet()) {
                m1541b(hashMap, (C0416b) entry.getKey(), (Lifecycle.Event) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length > 0) {
                    if (LifecycleOwner.class.isAssignableFrom(parameterTypes[0])) {
                        i = 1;
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                } else {
                    i = 0;
                }
                Lifecycle.Event value = onLifecycleEvent.value();
                if (parameterTypes.length > 1) {
                    if (Lifecycle.Event.class.isAssignableFrom(parameterTypes[1])) {
                        if (value == Lifecycle.Event.ON_ANY) {
                            i = 2;
                        } else {
                            throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                        }
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                }
                if (parameterTypes.length <= 2) {
                    m1541b(hashMap, new C0416b(i, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0415a c0415a3 = new C0415a(hashMap);
        hashMap2.put(cls, c0415a3);
        this.f6585b.put(cls, Boolean.valueOf(z));
        return c0415a3;
    }
}
