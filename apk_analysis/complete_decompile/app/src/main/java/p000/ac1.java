package p000;

import java.lang.ref.ReferenceQueue;

/* loaded from: classes.dex */
public final class ac1 extends cc1 {

    /* renamed from: d */
    public final /* synthetic */ int f119d;

    /* renamed from: e */
    public volatile long f120e;

    /* renamed from: f */
    public j92 f121f;

    /* renamed from: g */
    public j92 f122g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ac1(ReferenceQueue referenceQueue, Object obj, int i, j92 j92Var, int i2) {
        super(i, j92Var, obj, referenceQueue);
        this.f119d = i2;
    }

    @Override // p000.cc1, p000.j92
    /* renamed from: d */
    public j92 mo50d() {
        switch (this.f119d) {
            case 0:
                return this.f122g;
            default:
                return super.mo50d();
        }
    }

    @Override // p000.cc1, p000.j92
    /* renamed from: f */
    public long mo51f() {
        switch (this.f119d) {
            case 1:
                return this.f120e;
            default:
                return super.mo51f();
        }
    }

    @Override // p000.cc1, p000.j92
    /* renamed from: g */
    public void mo52g(j92 j92Var) {
        switch (this.f119d) {
            case 1:
                this.f122g = j92Var;
                return;
            default:
                super.mo52g(j92Var);
                return;
        }
    }

    @Override // p000.cc1, p000.j92
    /* renamed from: h */
    public void mo53h(j92 j92Var) {
        switch (this.f119d) {
            case 1:
                this.f121f = j92Var;
                return;
            default:
                super.mo53h(j92Var);
                return;
        }
    }

    @Override // p000.cc1, p000.j92
    /* renamed from: i */
    public void mo54i(long j) {
        switch (this.f119d) {
            case 0:
                this.f120e = j;
                return;
            default:
                super.mo54i(j);
                return;
        }
    }

    @Override // p000.cc1, p000.j92
    /* renamed from: j */
    public void mo55j(j92 j92Var) {
        switch (this.f119d) {
            case 0:
                this.f122g = j92Var;
                return;
            default:
                super.mo55j(j92Var);
                return;
        }
    }

    @Override // p000.cc1, p000.j92
    /* renamed from: k */
    public j92 mo56k() {
        switch (this.f119d) {
            case 1:
                return this.f121f;
            default:
                return super.mo56k();
        }
    }

    @Override // p000.cc1, p000.j92
    /* renamed from: l */
    public long mo57l() {
        switch (this.f119d) {
            case 0:
                return this.f120e;
            default:
                return super.mo57l();
        }
    }

    @Override // p000.cc1, p000.j92
    /* renamed from: m */
    public void mo58m(long j) {
        switch (this.f119d) {
            case 1:
                this.f120e = j;
                return;
            default:
                super.mo58m(j);
                return;
        }
    }

    @Override // p000.cc1, p000.j92
    /* renamed from: n */
    public j92 mo59n() {
        switch (this.f119d) {
            case 0:
                return this.f121f;
            default:
                return super.mo59n();
        }
    }

    @Override // p000.cc1, p000.j92
    /* renamed from: o */
    public void mo60o(j92 j92Var) {
        switch (this.f119d) {
            case 0:
                this.f121f = j92Var;
                return;
            default:
                super.mo60o(j92Var);
                return;
        }
    }

    @Override // p000.cc1, p000.j92
    /* renamed from: p */
    public j92 mo61p() {
        switch (this.f119d) {
            case 1:
                return this.f122g;
            default:
                return super.mo61p();
        }
    }
}
