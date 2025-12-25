package p000;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class jn0 implements Supplier {

    /* renamed from: a */
    public final /* synthetic */ int f20554a;

    /* renamed from: b */
    public final long f20555b;

    /* renamed from: c */
    public final TimeUnit f20556c;

    /* renamed from: d */
    public final Scheduler f20557d;

    /* renamed from: e */
    public final boolean f20558e;

    /* renamed from: f */
    public final Object f20559f;

    public /* synthetic */ jn0(Object obj, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i) {
        this.f20554a = i;
        this.f20559f = obj;
        this.f20555b = j;
        this.f20556c = timeUnit;
        this.f20557d = scheduler;
        this.f20558e = z;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public final Object get() {
        switch (this.f20554a) {
            case 0:
                return ((Flowable) this.f20559f).replay(this.f20555b, this.f20556c, this.f20557d, this.f20558e);
            default:
                return ((Observable) this.f20559f).replay(this.f20555b, this.f20556c, this.f20557d, this.f20558e);
        }
    }
}
