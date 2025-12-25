package p000;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

/* renamed from: ft */
/* loaded from: classes2.dex */
public final class C1207ft implements CompletableObserver {

    /* renamed from: a */
    public final /* synthetic */ RunnableC1199fl f17394a;

    public C1207ft(RunnableC1199fl runnableC1199fl) {
        this.f17394a = runnableC1199fl;
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onComplete() {
        RunnableC1199fl runnableC1199fl = this.f17394a;
        ((CompositeDisposable) runnableC1199fl.f17309c).dispose();
        ((CompletableObserver) runnableC1199fl.f17310d).onComplete();
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onError(Throwable th) {
        RunnableC1199fl runnableC1199fl = this.f17394a;
        ((CompositeDisposable) runnableC1199fl.f17309c).dispose();
        ((CompletableObserver) runnableC1199fl.f17310d).onError(th);
    }

    @Override // io.reactivex.rxjava3.core.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        ((CompositeDisposable) this.f17394a.f17309c).add(disposable);
    }
}
