package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Consumer;
import p000.AbstractC1607o2;
import p000.nv1;

/* loaded from: classes2.dex */
public final class ObservableDoAfterNext<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Consumer f19402a;

    public ObservableDoAfterNext(ObservableSource<T> observableSource, Consumer<? super T> consumer) {
        super(observableSource);
        this.f19402a = consumer;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new nv1(observer, this.f19402a, 0));
    }
}
