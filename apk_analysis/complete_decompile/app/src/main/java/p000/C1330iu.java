package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.ListCompositeDisposable;
import java.util.concurrent.TimeUnit;

/* renamed from: iu */
/* loaded from: classes2.dex */
public final class C1330iu extends Scheduler.Worker {

    /* renamed from: a */
    public final ListCompositeDisposable f20261a;

    /* renamed from: b */
    public final CompositeDisposable f20262b;

    /* renamed from: c */
    public final ListCompositeDisposable f20263c;

    /* renamed from: d */
    public final C1367ju f20264d;

    /* renamed from: e */
    public volatile boolean f20265e;

    public C1330iu(C1367ju c1367ju) {
        this.f20264d = c1367ju;
        ListCompositeDisposable listCompositeDisposable = new ListCompositeDisposable();
        this.f20261a = listCompositeDisposable;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.f20262b = compositeDisposable;
        ListCompositeDisposable listCompositeDisposable2 = new ListCompositeDisposable();
        this.f20263c = listCompositeDisposable2;
        listCompositeDisposable2.add(listCompositeDisposable);
        listCompositeDisposable2.add(compositeDisposable);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (!this.f20265e) {
            this.f20265e = true;
            this.f20263c.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.f20265e;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler.Worker
    public final Disposable schedule(Runnable runnable) {
        if (this.f20265e) {
            return EmptyDisposable.INSTANCE;
        }
        return this.f20264d.scheduleActual(runnable, 0L, TimeUnit.MILLISECONDS, this.f20261a);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler.Worker
    public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.f20265e) {
            return EmptyDisposable.INSTANCE;
        }
        return this.f20264d.scheduleActual(runnable, j, timeUnit, this.f20262b);
    }
}
