package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class cn0 implements Function {

    /* renamed from: a */
    public final /* synthetic */ int f8423a;

    /* renamed from: b */
    public final Object f8424b;

    /* renamed from: c */
    public final Object f8425c;

    public /* synthetic */ cn0(int i, Object obj, Object obj2) {
        this.f8423a = i;
        this.f8424b = obj;
        this.f8425c = obj2;
    }

    @Override // io.reactivex.rxjava3.functions.Function
    public final Object apply(Object obj) {
        switch (this.f8423a) {
            case 0:
                return ((BiFunction) this.f8424b).apply(this.f8425c, obj);
            case 1:
                return ((BiFunction) this.f8424b).apply(this.f8425c, obj);
            default:
                Scheduler scheduler = (Scheduler) this.f8425c;
                TimeUnit timeUnit = (TimeUnit) this.f8424b;
                return new Timed(obj, scheduler.now(timeUnit), timeUnit);
        }
    }
}
