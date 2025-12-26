package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;
import p000.AbstractC1607o2;
import p000.ev1;

/* loaded from: classes2.dex */
public final class ObservableDebounceTimed<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final long f19387a;

    /* renamed from: b */
    public final TimeUnit f19388b;

    /* renamed from: c */
    public final Scheduler f19389c;

    public ObservableDebounceTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.f19387a = j;
        this.f19388b = timeUnit;
        this.f19389c = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ev1(new SerializedObserver(observer), this.f19387a, this.f19388b, this.f19389c.createWorker()));
    }
}
