package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import p000.AbstractC1607o2;
import p000.wu1;

/* loaded from: classes2.dex */
public final class ObservableConcatWithMaybe<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final MaybeSource f19382a;

    public ObservableConcatWithMaybe(Observable<T> observable, MaybeSource<? extends T> maybeSource) {
        super(observable);
        this.f19382a = maybeSource;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new wu1(observer, this.f19382a));
    }
}
