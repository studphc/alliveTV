package p000;

import java.util.Map;

/* loaded from: classes2.dex */
public final class e91 implements Map.Entry {

    /* renamed from: a */
    public e91 f16717a;

    /* renamed from: b */
    public e91 f16718b;

    /* renamed from: c */
    public e91 f16719c;

    /* renamed from: d */
    public e91 f16720d;

    /* renamed from: e */
    public e91 f16721e;

    /* renamed from: f */
    public final Object f16722f;

    /* renamed from: g */
    public final boolean f16723g;

    /* renamed from: h */
    public Object f16724h;

    /* renamed from: i */
    public int f16725i;

    public e91(boolean z) {
        this.f16722f = null;
        this.f16723g = z;
        this.f16721e = this;
        this.f16720d = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f16722f;
        if (obj2 == null) {
            if (entry.getKey() != null) {
                return false;
            }
        } else if (!obj2.equals(entry.getKey())) {
            return false;
        }
        Object obj3 = this.f16724h;
        if (obj3 == null) {
            if (entry.getValue() != null) {
                return false;
            }
        } else if (!obj3.equals(entry.getValue())) {
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f16722f;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f16724h;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int hashCode;
        int i = 0;
        Object obj = this.f16722f;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        Object obj2 = this.f16724h;
        if (obj2 != null) {
            i = obj2.hashCode();
        }
        return i ^ hashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj == null && !this.f16723g) {
            throw new NullPointerException("value == null");
        }
        Object obj2 = this.f16724h;
        this.f16724h = obj;
        return obj2;
    }

    public final String toString() {
        return this.f16722f + "=" + this.f16724h;
    }

    public e91(boolean z, e91 e91Var, Object obj, e91 e91Var2, e91 e91Var3) {
        this.f16717a = e91Var;
        this.f16722f = obj;
        this.f16723g = z;
        this.f16725i = 1;
        this.f16720d = e91Var2;
        this.f16721e = e91Var3;
        e91Var3.f16720d = this;
        e91Var2.f16721e = this;
    }
}
