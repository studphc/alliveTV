package p000;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableDelaySubscriptionOther;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class iv1 implements Observer {

    /* renamed from: a */
    public final /* synthetic */ int f20275a;

    /* renamed from: b */
    public final Observer f20276b;

    /* renamed from: c */
    public final SequentialDisposable f20277c;

    /* renamed from: d */
    public boolean f20278d;

    /* renamed from: e */
    public final ObservableSource f20279e;

    public iv1(ObservableSource observableSource, Observer observer) {
        this.f20275a = 1;
        this.f20276b = observer;
        this.f20279e = observableSource;
        this.f20278d = true;
        this.f20277c = new SequentialDisposable();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        switch (this.f20275a) {
            case 0:
                if (!this.f20278d) {
                    this.f20278d = true;
                    ((ObservableDelaySubscriptionOther) this.f20279e).f19395a.subscribe(new C1698ps(1, this));
                    return;
                }
                return;
            default:
                if (this.f20278d) {
                    this.f20278d = false;
                    this.f20279e.subscribe(this);
                    return;
                } else {
                    this.f20276b.onComplete();
                    return;
                }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        switch (this.f20275a) {
            case 0:
                if (this.f20278d) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.f20278d = true;
                    this.f20276b.onError(th);
                    return;
                }
            default:
                this.f20276b.onError(th);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        switch (this.f20275a) {
            case 0:
                onComplete();
                return;
            default:
                if (this.f20278d) {
                    this.f20278d = false;
                }
                this.f20276b.onNext(obj);
                return;
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        switch (this.f20275a) {
            case 0:
                this.f20277c.update(disposable);
                return;
            default:
                this.f20277c.update(disposable);
                return;
        }
    }

    public iv1(ObservableDelaySubscriptionOther observableDelaySubscriptionOther, SequentialDisposable sequentialDisposable, Observer observer) {
        this.f20275a = 0;
        this.f20279e = observableDelaySubscriptionOther;
        this.f20277c = sequentialDisposable;
        this.f20276b = observer;
    }
}
