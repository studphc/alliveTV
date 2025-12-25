package p000;

/* loaded from: classes2.dex */
public final class pp0 extends ep0 {
    private static final long serialVersionUID = -5898283885385201806L;

    /* renamed from: e */
    public final int f25246e;

    public pp0(int i, boolean z) {
        super(z);
        this.f25246e = i;
    }

    @Override // p000.ep0
    /* renamed from: h */
    public final void mo4747h() {
        if (this.f16940c > this.f25246e) {
            ip0 ip0Var = (ip0) ((ip0) get()).get();
            if (ip0Var != null) {
                this.f16940c--;
                m4746g(ip0Var);
                return;
            }
            throw new IllegalStateException("Empty list!");
        }
    }
}
