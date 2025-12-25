package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.concurrent.TimeUnit;
import p000.AbstractC1607o2;
import p000.nz1;

/* loaded from: classes2.dex */
public final class ObservableTimeInterval<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Scheduler f19591a;

    /* renamed from: b */
    public final TimeUnit f19592b;

    public ObservableTimeInterval(ObservableSource<T> observableSource, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.f19591a = scheduler;
        this.f19592b = timeUnit;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Timed<T>> observer) {
        this.source.subscribe(new nz1(observer, this.f19592b, this.f19591a));
    }
}
