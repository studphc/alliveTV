package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import p000.AbstractC1607o2;
import p000.ox1;

/* loaded from: classes2.dex */
public final class ObservableRepeatUntil<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final BooleanSupplier f19526a;

    public ObservableRepeatUntil(Observable<T> observable, BooleanSupplier booleanSupplier) {
        super(observable);
        this.f19526a = booleanSupplier;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        ox1 ox1Var = new ox1(observer, this.f19526a, sequentialDisposable, this.source);
        if (ox1Var.getAndIncrement() == 0) {
            int i = 1;
            do {
                ox1Var.f24946c.subscribe(ox1Var);
                i = ox1Var.addAndGet(-i);
            } while (i != 0);
        }
    }
}
