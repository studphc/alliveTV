package p000;

import java.lang.ref.ReferenceQueue;

/* loaded from: classes.dex */
public final class sf1 extends ef1 {

    /* renamed from: h */
    public final ReferenceQueue f26407h;

    public sf1(zf1 zf1Var, int i) {
        super(zf1Var, i);
        this.f26407h = new ReferenceQueue();
    }

    @Override // p000.ef1
    /* renamed from: e */
    public final void mo4704e() {
        do {
        } while (this.f26407h.poll() != null);
    }

    @Override // p000.ef1
    /* renamed from: f */
    public final void mo4705f() {
        m4700a(this.f26407h);
    }

    @Override // p000.ef1
    /* renamed from: k */
    public final ef1 mo4710k() {
        return this;
    }
}
