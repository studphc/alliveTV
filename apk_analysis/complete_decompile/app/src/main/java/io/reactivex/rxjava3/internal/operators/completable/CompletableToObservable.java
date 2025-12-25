package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFromCompletable;

/* loaded from: classes2.dex */
public final class CompletableToObservable<T> extends Observable<T> {

    /* renamed from: a */
    public final CompletableSource f18716a;

    public CompletableToObservable(CompletableSource completableSource) {
        this.f18716a = completableSource;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f18716a.subscribe(new ObservableFromCompletable.FromCompletableObserver(observer));
    }
}
