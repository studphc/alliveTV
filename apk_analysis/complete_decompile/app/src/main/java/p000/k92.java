package p000;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public final class k92 extends m92 {

    /* renamed from: b */
    public final /* synthetic */ Method f20796b;

    public k92(Method method) {
        this.f20796b = method;
    }

    @Override // p000.m92
    /* renamed from: a */
    public final boolean mo5514a(AccessibleObject accessibleObject, Object obj) {
        try {
            return ((Boolean) this.f20796b.invoke(accessibleObject, obj)).booleanValue();
        } catch (Exception e) {
            throw new RuntimeException("Failed invoking canAccess", e);
        }
    }
}
