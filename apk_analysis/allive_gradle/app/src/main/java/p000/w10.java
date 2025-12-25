package p000;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final /* synthetic */ class w10 implements a20 {

    /* renamed from: a */
    public final /* synthetic */ int f28033a;

    /* renamed from: b */
    public final /* synthetic */ z10 f28034b;

    /* renamed from: c */
    public final /* synthetic */ Runnable f28035c;

    /* renamed from: d */
    public final /* synthetic */ long f28036d;

    /* renamed from: e */
    public final /* synthetic */ long f28037e;

    /* renamed from: f */
    public final /* synthetic */ TimeUnit f28038f;

    public /* synthetic */ w10(z10 z10Var, Runnable runnable, long j, long j2, TimeUnit timeUnit, int i) {
        this.f28033a = i;
        this.f28034b = z10Var;
        this.f28035c = runnable;
        this.f28036d = j;
        this.f28037e = j2;
        this.f28038f = timeUnit;
    }

    @Override // p000.a20
    /* renamed from: a */
    public final ScheduledFuture mo2a(b01 b01Var) {
        switch (this.f28033a) {
            case 0:
                z10 z10Var = this.f28034b;
                z10Var.getClass();
                return z10Var.f29216b.scheduleAtFixedRate(new x10(z10Var, this.f28035c, b01Var, 0), this.f28036d, this.f28037e, this.f28038f);
            default:
                z10 z10Var2 = this.f28034b;
                z10Var2.getClass();
                return z10Var2.f29216b.scheduleWithFixedDelay(new x10(z10Var2, this.f28035c, b01Var, 2), this.f28036d, this.f28037e, this.f28038f);
        }
    }
}
