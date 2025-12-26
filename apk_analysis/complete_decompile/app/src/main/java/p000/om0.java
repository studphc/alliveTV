package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class om0 implements Observer, Subscription {

    /* renamed from: a */
    public final Subscriber f24816a;

    /* renamed from: b */
    public Disposable f24817b;

    public om0(Subscriber subscriber) {
        this.f24816a = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        this.f24817b.dispose();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f24816a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f24816a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        this.f24816a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable disposable) {
        this.f24817b = disposable;
        this.f24816a.onSubscribe(this);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
    }
}
