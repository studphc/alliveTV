package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
@Deprecated
/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements LifecycleEventObserver {

    /* renamed from: a */
    public final Object f6529a;

    /* renamed from: b */
    public final C0415a f6530b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f6529a = obj;
        C0417c c0417c = C0417c.f6583c;
        Class<?> cls = obj.getClass();
        C0415a c0415a = (C0415a) c0417c.f6584a.get(cls);
        this.f6530b = c0415a == null ? c0417c.m1542a(cls, null) : c0415a;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        HashMap hashMap = this.f6530b.f6579a;
        List list = (List) hashMap.get(event);
        Object obj = this.f6529a;
        C0415a.m1540a(list, lifecycleOwner, event, obj);
        C0415a.m1540a((List) hashMap.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, obj);
    }
}
