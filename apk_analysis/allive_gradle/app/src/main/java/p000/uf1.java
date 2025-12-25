package p000;

import java.lang.ref.ReferenceQueue;

/* loaded from: classes.dex */
public final class uf1 extends ef1 {

    /* renamed from: h */
    public final ReferenceQueue f27247h;

    /* renamed from: i */
    public final ReferenceQueue f27248i;

    public uf1(zf1 zf1Var, int i) {
        super(zf1Var, i);
        this.f27247h = new ReferenceQueue();
        this.f27248i = new ReferenceQueue();
    }

    @Override // p000.ef1
    /* renamed from: e */
    public final void mo4704e() {
        do {
        } while (this.f27247h.poll() != null);
    }

    @Override // p000.ef1
    /* renamed from: f */
    public final void mo4705f() {
        m4700a(this.f27247h);
        m4701b(this.f27248i);
    }

    @Override // p000.ef1
    /* renamed from: k */
    public final ef1 mo4710k() {
        return this;
    }
}
