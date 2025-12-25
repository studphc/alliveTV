package p000;

import java.lang.ref.ReferenceQueue;

/* loaded from: classes.dex */
public final class of1 extends ef1 {

    /* renamed from: h */
    public final ReferenceQueue f23797h;

    public of1(zf1 zf1Var, int i) {
        super(zf1Var, i);
        this.f23797h = new ReferenceQueue();
    }

    @Override // p000.ef1
    /* renamed from: e */
    public final void mo4704e() {
        do {
        } while (this.f23797h.poll() != null);
    }

    @Override // p000.ef1
    /* renamed from: f */
    public final void mo4705f() {
        m4701b(this.f23797h);
    }

    @Override // p000.ef1
    /* renamed from: k */
    public final ef1 mo4710k() {
        return this;
    }
}
