package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class je2 extends me2 {

    /* renamed from: a */
    public final Runnable f20483a;

    /* renamed from: b */
    public final long f20484b;

    /* renamed from: c */
    public final TimeUnit f20485c;

    public je2(Runnable runnable, long j, TimeUnit timeUnit) {
        this.f20483a = runnable;
        this.f20484b = j;
        this.f20485c = timeUnit;
    }

    @Override // p000.me2
    /* renamed from: a */
    public final Disposable mo5441a(Scheduler.Worker worker, CompletableObserver completableObserver) {
        return worker.schedule(new xy1(13, this.f20483a, completableObserver), this.f20484b, this.f20485c);
    }
}
