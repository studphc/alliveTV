package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class np0 implements Supplier {

    /* renamed from: a */
    public final int f23444a;

    /* renamed from: b */
    public final long f23445b;

    /* renamed from: c */
    public final TimeUnit f23446c;

    /* renamed from: d */
    public final Scheduler f23447d;

    /* renamed from: e */
    public final boolean f23448e;

    public np0(int i, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.f23444a = i;
        this.f23445b = j;
        this.f23446c = timeUnit;
        this.f23447d = scheduler;
        this.f23448e = z;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public final Object get() {
        return new op0(this.f23444a, this.f23445b, this.f23446c, this.f23447d, this.f23448e);
    }
}
