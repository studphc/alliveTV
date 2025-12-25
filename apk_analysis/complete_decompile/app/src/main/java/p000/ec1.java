package p000;

import java.lang.ref.ReferenceQueue;

/* loaded from: classes.dex */
public final class ec1 extends qb1 {

    /* renamed from: b */
    public final int f16758b;

    public ec1(int i, j92 j92Var, Object obj, ReferenceQueue referenceQueue) {
        super(referenceQueue, obj, j92Var);
        this.f16758b = i;
    }

    @Override // p000.qb1, p000.zb1
    /* renamed from: c */
    public final int mo2071c() {
        return this.f16758b;
    }

    @Override // p000.qb1, p000.zb1
    /* renamed from: e */
    public final zb1 mo2073e(ReferenceQueue referenceQueue, Object obj, j92 j92Var) {
        return new ec1(this.f16758b, j92Var, obj, referenceQueue);
    }
}
