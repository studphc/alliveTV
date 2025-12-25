package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import p000.AbstractC1607o2;
import p000.aw1;

/* loaded from: classes2.dex */
public final class ObservableFlatMapMaybe<T, R> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Function f19429a;

    /* renamed from: b */
    public final boolean f19430b;

    public ObservableFlatMapMaybe(ObservableSource<T> observableSource, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        super(observableSource);
        this.f19429a = function;
        this.f19430b = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe(new aw1(observer, this.f19429a, this.f19430b));
    }
}
