package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.lifecycle.a */
/* loaded from: classes.dex */
public final class C0415a {

    /* renamed from: a */
    public final HashMap f6579a = new HashMap();

    /* renamed from: b */
    public final HashMap f6580b;

    public C0415a(HashMap hashMap) {
        this.f6580b = hashMap;
        for (Map.Entry entry : hashMap.entrySet()) {
            Lifecycle.Event event = (Lifecycle.Event) entry.getValue();
            List list = (List) this.f6579a.get(event);
            if (list == null) {
                list = new ArrayList();
                this.f6579a.put(event, list);
            }
            list.add((C0416b) entry.getKey());
        }
    }

    /* renamed from: a */
    public static void m1540a(List list, LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                C0416b c0416b = (C0416b) list.get(size);
                c0416b.getClass();
                try {
                    int i = c0416b.f6581a;
                    Method method = c0416b.f6582b;
                    if (i != 0) {
                        if (i != 1) {
                            if (i == 2) {
                                method.invoke(obj, lifecycleOwner, event);
                            }
                        } else {
                            method.invoke(obj, lifecycleOwner);
                        }
                    } else {
                        method.invoke(obj, null);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException("Failed to call observer method", e2.getCause());
                }
            }
        }
    }
}
