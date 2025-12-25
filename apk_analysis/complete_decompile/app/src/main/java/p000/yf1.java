package p000;

import java.util.Map;

/* loaded from: classes.dex */
public final class yf1 extends AbstractC2041z1 {

    /* renamed from: a */
    public final Object f28936a;

    /* renamed from: b */
    public Object f28937b;

    /* renamed from: c */
    public final /* synthetic */ zf1 f28938c;

    public yf1(zf1 zf1Var, Object obj, Object obj2) {
        this.f28938c = zf1Var;
        this.f28936a = obj;
        this.f28937b = obj2;
    }

    @Override // p000.AbstractC2041z1, java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!this.f28936a.equals(entry.getKey()) || !this.f28937b.equals(entry.getValue())) {
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f28936a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f28937b;
    }

    @Override // p000.AbstractC2041z1, java.util.Map.Entry
    public final int hashCode() {
        return this.f28936a.hashCode() ^ this.f28937b.hashCode();
    }

    @Override // p000.AbstractC2041z1, java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object put = this.f28938c.put(this.f28936a, obj);
        this.f28937b = obj;
        return put;
    }
}
