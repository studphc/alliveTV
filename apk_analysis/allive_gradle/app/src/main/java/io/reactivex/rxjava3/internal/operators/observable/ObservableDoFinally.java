package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Action;
import p000.AbstractC1607o2;
import p000.ov1;

/* loaded from: classes2.dex */
public final class ObservableDoFinally<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Action f19403a;

    public ObservableDoFinally(ObservableSource<T> observableSource, Action action) {
        super(observableSource);
        this.f19403a = action;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ov1(observer, this.f19403a));
    }
}
