package p000;

import java.util.Map;

/* loaded from: classes.dex */
public final class wd2 implements Map.Entry {

    /* renamed from: a */
    public final Object f28147a;

    /* renamed from: b */
    public final Object f28148b;

    /* renamed from: c */
    public wd2 f28149c;

    /* renamed from: d */
    public wd2 f28150d;

    public wd2(Object obj, Object obj2) {
        this.f28147a = obj;
        this.f28148b = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof wd2)) {
            return false;
        }
        wd2 wd2Var = (wd2) obj;
        if (this.f28147a.equals(wd2Var.f28147a) && this.f28148b.equals(wd2Var.f28148b)) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f28147a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f28148b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f28147a.hashCode() ^ this.f28148b.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f28147a + "=" + this.f28148b;
    }
}
