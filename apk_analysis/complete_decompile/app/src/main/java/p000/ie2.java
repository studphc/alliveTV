package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Function;

/* loaded from: classes2.dex */
public final class ie2 implements Function {

    /* renamed from: a */
    public final Scheduler.Worker f18385a;

    public ie2(Scheduler.Worker worker) {
        this.f18385a = worker;
    }

    @Override // io.reactivex.rxjava3.functions.Function
    public final Object apply(Object obj) {
        return new he2(this, (me2) obj);
    }
}
