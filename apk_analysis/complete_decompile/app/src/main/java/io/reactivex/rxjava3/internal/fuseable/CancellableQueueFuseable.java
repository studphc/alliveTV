package io.reactivex.rxjava3.internal.fuseable;

/* loaded from: classes2.dex */
public final class CancellableQueueFuseable<T> extends AbstractEmptyQueueFuseable<T> {

    /* renamed from: a */
    public volatile boolean f18524a;

    @Override // io.reactivex.rxjava3.internal.fuseable.AbstractEmptyQueueFuseable, org.reactivestreams.Subscription
    public void cancel() {
        this.f18524a = true;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.AbstractEmptyQueueFuseable, io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        this.f18524a = true;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.AbstractEmptyQueueFuseable, io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return this.f18524a;
    }
}
