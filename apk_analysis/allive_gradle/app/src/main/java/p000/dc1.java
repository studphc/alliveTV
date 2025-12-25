package p000;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class dc1 extends WeakReference implements zb1 {

    /* renamed from: a */
    public final j92 f16343a;

    public dc1(ReferenceQueue referenceQueue, Object obj, j92 j92Var) {
        super(obj, referenceQueue);
        this.f16343a = j92Var;
    }

    @Override // p000.zb1
    /* renamed from: a */
    public final j92 mo2069a() {
        return this.f16343a;
    }

    @Override // p000.zb1
    /* renamed from: c */
    public int mo2071c() {
        return 1;
    }

    @Override // p000.zb1
    /* renamed from: d */
    public final Object mo2072d() {
        return get();
    }

    @Override // p000.zb1
    /* renamed from: e */
    public zb1 mo2073e(ReferenceQueue referenceQueue, Object obj, j92 j92Var) {
        return new dc1(referenceQueue, obj, j92Var);
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
