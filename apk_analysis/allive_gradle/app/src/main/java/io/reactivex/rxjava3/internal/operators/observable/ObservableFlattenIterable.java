package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import p000.AbstractC1607o2;
import p000.ew1;

/* loaded from: classes2.dex */
public final class ObservableFlattenIterable<T, R> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Function f19433a;

    public ObservableFlattenIterable(ObservableSource<T> observableSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        super(observableSource);
        this.f19433a = function;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe(new ew1(observer, this.f19433a, 0));
    }
}
