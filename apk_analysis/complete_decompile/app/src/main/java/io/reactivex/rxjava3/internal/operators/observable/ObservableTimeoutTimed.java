package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.TimeUnit;
import p000.AbstractC1607o2;
import p000.pq0;
import p000.sz1;
import p000.tz1;

/* loaded from: classes2.dex */
public final class ObservableTimeoutTimed<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final long f19596a;

    /* renamed from: b */
    public final TimeUnit f19597b;

    /* renamed from: c */
    public final Scheduler f19598c;

    /* renamed from: d */
    public final ObservableSource f19599d;

    public ObservableTimeoutTimed(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler, ObservableSource<? extends T> observableSource) {
        super(observable);
        this.f19596a = j;
        this.f19597b = timeUnit;
        this.f19598c = scheduler;
        this.f19599d = observableSource;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        ObservableSource observableSource = this.f19599d;
        Scheduler scheduler = this.f19598c;
        if (observableSource == null) {
            tz1 tz1Var = new tz1(observer, this.f19596a, this.f19597b, scheduler.createWorker());
            observer.onSubscribe(tz1Var);
            tz1Var.f27042e.replace(tz1Var.f27041d.schedule(new pq0(0L, tz1Var), tz1Var.f27039b, tz1Var.f27040c));
            this.source.subscribe(tz1Var);
            return;
        }
        sz1 sz1Var = new sz1(observer, this.f19596a, this.f19597b, scheduler.createWorker(), this.f19599d);
        observer.onSubscribe(sz1Var);
        sz1Var.f26636e.replace(sz1Var.f26635d.schedule(new pq0(0L, sz1Var), sz1Var.f26633b, sz1Var.f26634c));
        this.source.subscribe(sz1Var);
    }
}
