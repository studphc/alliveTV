package p000;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final /* synthetic */ class u10 implements a20 {

    /* renamed from: a */
    public final /* synthetic */ int f27064a;

    /* renamed from: b */
    public final /* synthetic */ z10 f27065b;

    /* renamed from: c */
    public final /* synthetic */ long f27066c;

    /* renamed from: d */
    public final /* synthetic */ TimeUnit f27067d;

    /* renamed from: e */
    public final /* synthetic */ Object f27068e;

    public /* synthetic */ u10(z10 z10Var, Object obj, long j, TimeUnit timeUnit, int i) {
        this.f27064a = i;
        this.f27065b = z10Var;
        this.f27068e = obj;
        this.f27066c = j;
        this.f27067d = timeUnit;
    }

    @Override // p000.a20
    /* renamed from: a */
    public final ScheduledFuture mo2a(b01 b01Var) {
        switch (this.f27064a) {
            case 0:
                z10 z10Var = this.f27065b;
                z10Var.getClass();
                return z10Var.f29216b.schedule(new x10(z10Var, (Runnable) this.f27068e, b01Var, 1), this.f27066c, this.f27067d);
            default:
                z10 z10Var2 = this.f27065b;
                z10Var2.getClass();
                return z10Var2.f29216b.schedule(new y10(z10Var2, (Callable) this.f27068e, b01Var, 0), this.f27066c, this.f27067d);
        }
    }
}
