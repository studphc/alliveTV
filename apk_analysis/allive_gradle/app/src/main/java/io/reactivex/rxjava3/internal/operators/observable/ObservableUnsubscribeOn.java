package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import p000.AbstractC1607o2;
import p000.wz1;

/* loaded from: classes2.dex */
public final class ObservableUnsubscribeOn<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Scheduler f19606a;

    public ObservableUnsubscribeOn(ObservableSource<T> observableSource, Scheduler scheduler) {
        super(observableSource);
        this.f19606a = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new wz1(observer, this.f19606a));
    }
}
