package p000;

import java.lang.ref.ReferenceQueue;

/* loaded from: classes.dex */
public final class gc1 extends dc1 {

    /* renamed from: b */
    public final int f17644b;

    public gc1(int i, j92 j92Var, Object obj, ReferenceQueue referenceQueue) {
        super(referenceQueue, obj, j92Var);
        this.f17644b = i;
    }

    @Override // p000.dc1, p000.zb1
    /* renamed from: c */
    public final int mo2071c() {
        return this.f17644b;
    }

    @Override // p000.dc1, p000.zb1
    /* renamed from: e */
    public final zb1 mo2073e(ReferenceQueue referenceQueue, Object obj, j92 j92Var) {
        return new gc1(this.f17644b, j92Var, obj, referenceQueue);
    }
}
