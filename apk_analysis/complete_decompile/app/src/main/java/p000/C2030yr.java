package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: yr */
/* loaded from: classes2.dex */
public final class C2030yr implements CompletableObserver {

    /* renamed from: a */
    public final /* synthetic */ int f29105a = 1;

    /* renamed from: b */
    public final CompletableObserver f29106b;

    /* renamed from: c */
    public final CompositeDisposable f29107c;

    /* renamed from: d */
    public final Serializable f29108d;

    /* renamed from: e */
    public Object f29109e;

    public C2030yr(CompletableObserver completableObserver, CompositeDisposable compositeDisposable, AtomicThrowable atomicThrowable, AtomicInteger atomicInteger) {
        this.f29106b = completableObserver;
        this.f29107c = compositeDisposable;
        this.f29108d = atomicThrowable;
        this.f29109e = atomicInteger;
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        switch (this.f29105a) {
            case 0:
                if (((AtomicBoolean) this.f29108d).compareAndSet(false, true)) {
                    Disposable disposable = (Disposable) this.f29109e;
                    CompositeDisposable compositeDisposable = this.f29107c;
                    compositeDisposable.delete(disposable);
                    compositeDisposable.dispose();
                    this.f29106b.onComplete();
                    return;
                }
                return;
            default:
                if (((AtomicInteger) this.f29109e).decrementAndGet() == 0) {
                    ((AtomicThrowable) this.f29108d).tryTerminateConsumer(this.f29106b);
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        switch (this.f29105a) {
            case 0:
                if (((AtomicBoolean) this.f29108d).compareAndSet(false, true)) {
                    Disposable disposable = (Disposable) this.f29109e;
                    CompositeDisposable compositeDisposable = this.f29107c;
                    compositeDisposable.delete(disposable);
                    compositeDisposable.dispose();
                    this.f29106b.onError(th);
                    return;
                }
                RxJavaPlugins.onError(th);
                return;
            default:
                AtomicThrowable atomicThrowable = (AtomicThrowable) this.f29108d;
                if (atomicThrowable.tryAddThrowableOrReport(th) && ((AtomicInteger) this.f29109e).decrementAndGet() == 0) {
                    atomicThrowable.tryTerminateConsumer(this.f29106b);
                    return;
                }
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        switch (this.f29105a) {
            case 0:
                this.f29109e = disposable;
                this.f29107c.add(disposable);
                return;
            default:
                this.f29107c.add(disposable);
                return;
        }
    }

    public C2030yr(CompletableObserver completableObserver, CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean) {
        this.f29108d = atomicBoolean;
        this.f29107c = compositeDisposable;
        this.f29106b = completableObserver;
    }
}
