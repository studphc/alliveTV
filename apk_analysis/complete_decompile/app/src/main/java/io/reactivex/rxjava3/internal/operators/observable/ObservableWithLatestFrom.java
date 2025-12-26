package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.observers.SerializedObserver;
import p000.AbstractC1607o2;
import p000.C1698ps;
import p000.l02;

/* loaded from: classes2.dex */
public final class ObservableWithLatestFrom<T, U, R> extends AbstractC1607o2 {

    /* renamed from: a */
    public final BiFunction f19626a;

    /* renamed from: b */
    public final ObservableSource f19627b;

    public ObservableWithLatestFrom(ObservableSource<T> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.f19626a = biFunction;
        this.f19627b = observableSource2;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        l02 l02Var = new l02(serializedObserver, this.f19626a);
        serializedObserver.onSubscribe(l02Var);
        this.f19627b.subscribe(new C1698ps(3, l02Var));
        this.source.subscribe(l02Var);
    }
}
