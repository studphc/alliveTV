package androidx.lifecycle;

import java.lang.reflect.Method;

/* renamed from: androidx.lifecycle.b */
/* loaded from: classes.dex */
public final class C0416b {

    /* renamed from: a */
    public final int f6581a;

    /* renamed from: b */
    public final Method f6582b;

    public C0416b(int i, Method method) {
        this.f6581a = i;
        this.f6582b = method;
        method.setAccessible(true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0416b)) {
            return false;
        }
        C0416b c0416b = (C0416b) obj;
        if (this.f6581a == c0416b.f6581a && this.f6582b.getName().equals(c0416b.f6582b.getName())) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f6582b.getName().hashCode() + (this.f6581a * 31);
    }
}
