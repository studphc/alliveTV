package p000;

import com.google.common.cache.ConcurrentMapC0840e;

/* loaded from: classes.dex */
public class xb1 extends db1 {

    /* renamed from: a */
    public final Object f28495a;

    /* renamed from: b */
    public final int f28496b;

    /* renamed from: c */
    public final j92 f28497c;

    /* renamed from: d */
    public volatile zb1 f28498d = ConcurrentMapC0840e.f14585x;

    public xb1(Object obj, int i, j92 j92Var) {
        this.f28495a = obj;
        this.f28496b = i;
        this.f28497c = j92Var;
    }

    @Override // p000.db1, p000.j92
    /* renamed from: a */
    public final j92 mo2220a() {
        return this.f28497c;
    }

    @Override // p000.db1, p000.j92
    /* renamed from: b */
    public final zb1 mo2221b() {
        return this.f28498d;
    }

    @Override // p000.db1, p000.j92
    /* renamed from: c */
    public final int mo2222c() {
        return this.f28496b;
    }

    @Override // p000.db1, p000.j92
    /* renamed from: e */
    public final void mo2223e(zb1 zb1Var) {
        this.f28498d = zb1Var;
    }

    @Override // p000.db1, p000.j92
    public final Object getKey() {
        return this.f28495a;
    }
}
