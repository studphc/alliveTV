package p000;

import java.io.Serializable;

/* loaded from: classes.dex */
public class k21 extends AbstractC2041z1 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Object f20725a;

    /* renamed from: b */
    public final Object f20726b;

    public k21(Object obj, Object obj2) {
        this.f20725a = obj;
        this.f20726b = obj2;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f20725a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f20726b;
    }

    @Override // p000.AbstractC2041z1, java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
