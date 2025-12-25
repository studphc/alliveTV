package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import p000.AbstractC1607o2;
import p000.ey1;

/* loaded from: classes2.dex */
public final class ObservableRetryPredicate<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Predicate f19534a;

    /* renamed from: b */
    public final long f19535b;

    public ObservableRetryPredicate(Observable<T> observable, long j, Predicate<? super Throwable> predicate) {
        super(observable);
        this.f19534a = predicate;
        this.f19535b = j;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new ey1(observer, this.f19535b, this.f19534a, sequentialDisposable, this.source).m4761a();
    }
}
