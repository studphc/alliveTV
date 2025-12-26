package p000;

import io.reactivex.rxjava3.subscribers.DisposableSubscriber;

/* loaded from: classes2.dex */
public final class zi0 extends DisposableSubscriber {

    /* renamed from: b */
    public final aj0 f29385b;

    public zi0(aj0 aj0Var) {
        this.f29385b = aj0Var;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        this.f29385b.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        this.f29385b.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f29385b.m103Y();
    }
}
