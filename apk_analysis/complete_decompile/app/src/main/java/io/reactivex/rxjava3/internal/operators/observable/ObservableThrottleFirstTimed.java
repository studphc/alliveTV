package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;
import p000.AbstractC1607o2;
import p000.lz1;

/* loaded from: classes2.dex */
public final class ObservableThrottleFirstTimed<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final long f19584a;

    /* renamed from: b */
    public final TimeUnit f19585b;

    /* renamed from: c */
    public final Scheduler f19586c;

    public ObservableThrottleFirstTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.f19584a = j;
        this.f19585b = timeUnit;
        this.f19586c = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new lz1(new SerializedObserver(observer), this.f19584a, this.f19585b, this.f19586c.createWorker()));
    }
}
