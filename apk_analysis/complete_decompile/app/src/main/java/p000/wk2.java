package p000;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class wk2 extends xk2 {

    /* renamed from: g */
    public final long f28216g;

    /* renamed from: h */
    public double f28217h;

    /* renamed from: i */
    public double f28218i;

    /* renamed from: j */
    public final double f28219j;

    public wk2(s82 s82Var, long j, TimeUnit timeUnit) {
        super(s82Var);
        this.f28216g = timeUnit.toMicros(j);
        this.f28219j = 3.0d;
    }

    @Override // p000.xk2
    /* renamed from: f */
    public final double mo7915f() {
        return this.f28216g / this.f28605d;
    }

    @Override // p000.xk2
    /* renamed from: g */
    public final void mo7916g(double d, double d2) {
        double d3 = this.f28605d;
        double d4 = this.f28219j * d2;
        long j = this.f28216g;
        double d5 = (j * 0.5d) / d2;
        this.f28218i = d5;
        double d6 = ((j * 2.0d) / (d2 + d4)) + d5;
        this.f28605d = d6;
        this.f28217h = (d4 - d2) / (d6 - d5);
        if (d3 == Double.POSITIVE_INFINITY) {
            this.f28604c = 0.0d;
            return;
        }
        if (d3 != 0.0d) {
            d6 = (this.f28604c * d6) / d3;
        }
        this.f28604c = d6;
    }

    @Override // p000.xk2
    /* renamed from: i */
    public final long mo7917i(double d, double d2) {
        long j;
        double d3 = d - this.f28218i;
        if (d3 > 0.0d) {
            double min = Math.min(d3, d2);
            double d4 = this.f28606e;
            double d5 = this.f28217h;
            j = (long) ((((((d3 - min) * d5) + d4) + ((d3 * d5) + d4)) * min) / 2.0d);
            d2 -= min;
        } else {
            j = 0;
        }
        return j + ((long) (this.f28606e * d2));
    }
}
