package p000;

import com.google.common.math.LongMath;
import com.google.common.util.concurrent.RateLimiter;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class xk2 extends RateLimiter {

    /* renamed from: c */
    public double f28604c;

    /* renamed from: d */
    public double f28605d;

    /* renamed from: e */
    public double f28606e;

    /* renamed from: f */
    public long f28607f;

    public xk2(s82 s82Var) {
        super(s82Var);
        this.f28607f = 0L;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    /* renamed from: a */
    public final double mo4338a() {
        return TimeUnit.SECONDS.toMicros(1L) / this.f28606e;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    /* renamed from: b */
    public final void mo4339b(long j, double d) {
        m8172h(j);
        double micros = TimeUnit.SECONDS.toMicros(1L) / d;
        this.f28606e = micros;
        mo7916g(d, micros);
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    /* renamed from: d */
    public final long mo4341d() {
        return this.f28607f;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    /* renamed from: e */
    public final long mo4342e(int i, long j) {
        m8172h(j);
        long j2 = this.f28607f;
        double d = i;
        double min = Math.min(d, this.f28604c);
        this.f28607f = LongMath.saturatedAdd(this.f28607f, mo7917i(this.f28604c, min) + ((long) ((d - min) * this.f28606e)));
        this.f28604c -= min;
        return j2;
    }

    /* renamed from: f */
    public abstract double mo7915f();

    /* renamed from: g */
    public abstract void mo7916g(double d, double d2);

    /* renamed from: h */
    public final void m8172h(long j) {
        if (j > this.f28607f) {
            this.f28604c = Math.min(this.f28605d, this.f28604c + ((j - r0) / mo7915f()));
            this.f28607f = j;
        }
    }

    /* renamed from: i */
    public abstract long mo7917i(double d, double d2);
}
