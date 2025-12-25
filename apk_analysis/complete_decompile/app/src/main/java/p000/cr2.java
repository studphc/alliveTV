package p000;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class cr2 extends lr2 {
    private static final long serialVersionUID = 0;

    /* renamed from: f */
    public transient dr2 f16090f;

    /* renamed from: g */
    public transient er2 f16091g;

    @Override // p000.lr2, java.util.Map
    public final boolean containsValue(Object obj) {
        return ((gr2) values()).contains(obj);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [pr2, dr2] */
    @Override // p000.lr2, java.util.Map
    public final Set entrySet() {
        dr2 dr2Var;
        synchronized (this.f25273b) {
            try {
                if (this.f16090f == null) {
                    this.f16090f = new pr2(((Map) this.f25272a).entrySet(), this.f25273b);
                }
                dr2Var = this.f16090f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dr2Var;
    }

    @Override // p000.lr2, java.util.Map
    public final Object get(Object obj) {
        gr2 m8356d;
        synchronized (this.f25273b) {
            Collection collection = (Collection) super.get(obj);
            if (collection == null) {
                m8356d = null;
            } else {
                m8356d = yy2.m8356d(collection, this.f25273b);
            }
        }
        return m8356d;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [pr2, er2] */
    @Override // p000.lr2, java.util.Map
    public final Collection values() {
        er2 er2Var;
        synchronized (this.f25273b) {
            try {
                if (this.f16091g == null) {
                    this.f16091g = new pr2(((Map) this.f25272a).values(), this.f25273b);
                }
                er2Var = this.f16091g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return er2Var;
    }
}
