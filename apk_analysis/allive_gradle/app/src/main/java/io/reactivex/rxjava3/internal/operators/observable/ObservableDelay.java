package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;
import p000.AbstractC1607o2;
import p000.hv1;

/* loaded from: classes2.dex */
public final class ObservableDelay<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final long f19391a;

    /* renamed from: b */
    public final TimeUnit f19392b;

    /* renamed from: c */
    public final Scheduler f19393c;

    /* renamed from: d */
    public final boolean f19394d;

    public ObservableDelay(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(observableSource);
        this.f19391a = j;
        this.f19392b = timeUnit;
        this.f19393c = scheduler;
        this.f19394d = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Observer<? super T> serializedObserver;
        if (this.f19394d) {
            serializedObserver = observer;
        } else {
            serializedObserver = new SerializedObserver(observer);
        }
        Scheduler.Worker createWorker = this.f19393c.createWorker();
        this.source.subscribe(new hv1(serializedObserver, this.f19391a, this.f19392b, createWorker, this.f19394d));
    }
}
