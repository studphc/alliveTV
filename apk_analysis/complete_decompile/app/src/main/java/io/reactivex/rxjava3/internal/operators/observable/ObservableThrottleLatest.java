package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.TimeUnit;
import p000.AbstractC1607o2;
import p000.mz1;

/* loaded from: classes2.dex */
public final class ObservableThrottleLatest<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final long f19587a;

    /* renamed from: b */
    public final TimeUnit f19588b;

    /* renamed from: c */
    public final Scheduler f19589c;

    /* renamed from: d */
    public final boolean f19590d;

    public ObservableThrottleLatest(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(observable);
        this.f19587a = j;
        this.f19588b = timeUnit;
        this.f19589c = scheduler;
        this.f19590d = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new mz1(observer, this.f19587a, this.f19588b, this.f19589c.createWorker(), this.f19590d));
    }
}
