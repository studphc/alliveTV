package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ObservableAutoConnect<T> extends Observable<T> {

    /* renamed from: a */
    public final ConnectableObservable f19330a;

    /* renamed from: b */
    public final int f19331b;

    /* renamed from: c */
    public final Consumer f19332c;

    /* renamed from: d */
    public final AtomicInteger f19333d = new AtomicInteger();

    public ObservableAutoConnect(ConnectableObservable<? extends T> connectableObservable, int i, Consumer<? super Disposable> consumer) {
        this.f19330a = connectableObservable;
        this.f19331b = i;
        this.f19332c = consumer;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        ConnectableObservable connectableObservable = this.f19330a;
        connectableObservable.subscribe(observer);
        if (this.f19333d.incrementAndGet() == this.f19331b) {
            connectableObservable.connect(this.f19332c);
        }
    }
}
