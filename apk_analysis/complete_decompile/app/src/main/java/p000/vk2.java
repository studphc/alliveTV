package p000;

/* loaded from: classes2.dex */
public final class vk2 extends xk2 {

    /* renamed from: g */
    public final double f27832g;

    public vk2(s82 s82Var) {
        super(s82Var);
        this.f27832g = 1.0d;
    }

    @Override // p000.xk2
    /* renamed from: f */
    public final double mo7915f() {
        return this.f28606e;
    }

    @Override // p000.xk2
    /* renamed from: g */
    public final void mo7916g(double d, double d2) {
        double d3 = this.f28605d;
        double d4 = this.f27832g * d;
        this.f28605d = d4;
        if (d3 == Double.POSITIVE_INFINITY) {
            this.f28604c = d4;
            return;
        }
        double d5 = 0.0d;
        if (d3 != 0.0d) {
            d5 = (this.f28604c * d4) / d3;
        }
        this.f28604c = d5;
    }

    @Override // p000.xk2
    /* renamed from: i */
    public final long mo7917i(double d, double d2) {
        return 0L;
    }
}
