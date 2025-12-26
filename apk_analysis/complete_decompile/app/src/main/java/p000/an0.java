package p000;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class an0 implements Supplier {

    /* renamed from: a */
    public final /* synthetic */ int f264a;

    /* renamed from: b */
    public final int f265b;

    /* renamed from: c */
    public final long f266c;

    /* renamed from: d */
    public final TimeUnit f267d;

    /* renamed from: e */
    public final Scheduler f268e;

    /* renamed from: f */
    public final boolean f269f;

    /* renamed from: g */
    public final Object f270g;

    public /* synthetic */ an0(Object obj, int i, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i2) {
        this.f264a = i2;
        this.f270g = obj;
        this.f265b = i;
        this.f266c = j;
        this.f267d = timeUnit;
        this.f268e = scheduler;
        this.f269f = z;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public final Object get() {
        switch (this.f264a) {
            case 0:
                return ((Flowable) this.f270g).replay(this.f265b, this.f266c, this.f267d, this.f268e, this.f269f);
            default:
                return ((Observable) this.f270g).replay(this.f265b, this.f266c, this.f267d, this.f268e, this.f269f);
        }
    }
}
