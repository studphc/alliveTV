package p000;

import java.util.Map;

/* loaded from: classes.dex */
public final class zd3 implements Map.Entry, Comparable {

    /* renamed from: a */
    public final Comparable f29326a;

    /* renamed from: b */
    public Object f29327b;

    /* renamed from: c */
    public final /* synthetic */ yd3 f29328c;

    public zd3(yd3 yd3Var, Comparable comparable, Object obj) {
        this.f29328c = yd3Var;
        this.f29326a = comparable;
        this.f29327b = obj;
    }

    /* renamed from: a */
    public final Comparable m8412a() {
        return this.f29326a;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f29326a.compareTo(((zd3) obj).f29326a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        boolean equals;
        boolean equals2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Comparable comparable = this.f29326a;
        if (comparable == null) {
            if (key != null) {
                equals = false;
            } else {
                equals = true;
            }
        } else {
            equals = comparable.equals(key);
        }
        if (equals) {
            Object obj2 = this.f29327b;
            Object value = entry.getValue();
            if (obj2 == null) {
                if (value != null) {
                    equals2 = false;
                } else {
                    equals2 = true;
                }
            } else {
                equals2 = obj2.equals(value);
            }
            if (equals2) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f29326a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f29327b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int hashCode;
        int i = 0;
        Comparable comparable = this.f29326a;
        if (comparable == null) {
            hashCode = 0;
        } else {
            hashCode = comparable.hashCode();
        }
        Object obj = this.f29327b;
        if (obj != null) {
            i = obj.hashCode();
        }
        return i ^ hashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f29328c.m8274j();
        Object obj2 = this.f29327b;
        this.f29327b = obj;
        return obj2;
    }

    public final String toString() {
        return AbstractC1726qj.m7058n(String.valueOf(this.f29326a), "=", String.valueOf(this.f29327b));
    }
}
