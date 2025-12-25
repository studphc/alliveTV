package p000;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/* loaded from: classes.dex */
public class qb1 extends SoftReference implements zb1 {

    /* renamed from: a */
    public final j92 f25506a;

    public qb1(ReferenceQueue referenceQueue, Object obj, j92 j92Var) {
        super(obj, referenceQueue);
        this.f25506a = j92Var;
    }

    @Override // p000.zb1
    /* renamed from: a */
    public final j92 mo2069a() {
        return this.f25506a;
    }

    /* renamed from: c */
    public int mo2071c() {
        return 1;
    }

    @Override // p000.zb1
    /* renamed from: d */
    public final Object mo2072d() {
        return get();
    }

    /* renamed from: e */
    public zb1 mo2073e(ReferenceQueue referenceQueue, Object obj, j92 j92Var) {
        return new qb1(referenceQueue, obj, j92Var);
    }

    @Override // p000.zb1
    public final boolean isActive() {
        return true;
    }

    @Override // p000.zb1
    public final boolean isLoading() {
        return false;
    }

    @Override // p000.zb1
    /* renamed from: b */
    public final void mo2070b(Object obj) {
    }
}
