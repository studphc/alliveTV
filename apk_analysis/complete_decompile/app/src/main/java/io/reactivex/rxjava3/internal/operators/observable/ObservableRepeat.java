package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import p000.AbstractC1607o2;
import p000.nx1;

/* loaded from: classes2.dex */
public final class ObservableRepeat<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final long f19525a;

    public ObservableRepeat(Observable<T> observable, long j) {
        super(observable);
        this.f19525a = j;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        long j = this.f19525a;
        long j2 = Long.MAX_VALUE;
        if (j != Long.MAX_VALUE) {
            j2 = j - 1;
        }
        new nx1(observer, j2, sequentialDisposable, this.source).m6399a();
    }
}
