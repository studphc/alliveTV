package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import p000.AbstractC1607o2;
import p000.dy1;

/* loaded from: classes2.dex */
public final class ObservableRetryBiPredicate<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final BiPredicate f19533a;

    public ObservableRetryBiPredicate(Observable<T> observable, BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        super(observable);
        this.f19533a = biPredicate;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new dy1(observer, this.f19533a, sequentialDisposable, this.source).m4645a();
    }
}
