package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.observers.DisposableLambdaObserver;
import p000.AbstractC1607o2;

/* loaded from: classes2.dex */
public final class ObservableDoOnLifecycle<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Consumer f19408a;

    /* renamed from: b */
    public final Action f19409b;

    public ObservableDoOnLifecycle(Observable<T> observable, Consumer<? super Disposable> consumer, Action action) {
        super(observable);
        this.f19408a = consumer;
        this.f19409b = action;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DisposableLambdaObserver(observer, this.f19408a, this.f19409b));
    }
}
