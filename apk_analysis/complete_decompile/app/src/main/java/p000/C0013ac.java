package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subjects.AsyncSubject;

/* renamed from: ac */
/* loaded from: classes2.dex */
public final class C0013ac extends DeferredScalarDisposable {
    private static final long serialVersionUID = 5629876084736248016L;

    /* renamed from: a */
    public final AsyncSubject f117a;

    public C0013ac(Observer observer, AsyncSubject asyncSubject) {
        super(observer);
        this.f117a = asyncSubject;
    }

    @Override // io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable, io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (tryDispose()) {
            this.f117a.m5320d(this);
        }
    }

    @Override // io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable
    public final void onComplete() {
        if (!isDisposed()) {
            this.downstream.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable
    public final void onError(Throwable th) {
        if (isDisposed()) {
            RxJavaPlugins.onError(th);
        } else {
            this.downstream.onError(th);
        }
    }
}
