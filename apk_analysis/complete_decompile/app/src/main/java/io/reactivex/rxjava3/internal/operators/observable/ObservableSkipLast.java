package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import p000.AbstractC1607o2;
import p000.ry1;

/* loaded from: classes2.dex */
public final class ObservableSkipLast<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final int f19560a;

    public ObservableSkipLast(ObservableSource<T> observableSource, int i) {
        super(observableSource);
        this.f19560a = i;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ry1(observer, this.f19560a));
    }
}
