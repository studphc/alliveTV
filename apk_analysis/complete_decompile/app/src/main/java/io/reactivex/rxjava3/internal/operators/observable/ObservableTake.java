package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import p000.AbstractC1607o2;
import p000.gz1;

/* loaded from: classes2.dex */
public final class ObservableTake<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final long f19573a;

    public ObservableTake(ObservableSource<T> observableSource, long j) {
        super(observableSource);
        this.f19573a = j;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new gz1(observer, this.f19573a));
    }
}
