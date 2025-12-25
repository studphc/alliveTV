package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import java.util.Optional;
import p000.vw1;

/* loaded from: classes2.dex */
public final class ObservableMapOptional<T, R> extends Observable<R> {

    /* renamed from: a */
    public final Observable f18566a;

    /* renamed from: b */
    public final Function f18567b;

    public ObservableMapOptional(Observable<T> observable, Function<? super T, Optional<? extends R>> function) {
        this.f18566a = observable;
        this.f18567b = function;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        this.f18566a.subscribe(new vw1(observer, this.f18567b, 1));
    }
}
