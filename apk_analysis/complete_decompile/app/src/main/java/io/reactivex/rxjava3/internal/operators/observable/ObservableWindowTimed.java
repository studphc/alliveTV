package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.TimeUnit;
import p000.AbstractC1607o2;
import p000.i02;
import p000.j02;
import p000.k02;

/* loaded from: classes2.dex */
public final class ObservableWindowTimed<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final long f19619a;

    /* renamed from: b */
    public final long f19620b;

    /* renamed from: c */
    public final TimeUnit f19621c;

    /* renamed from: d */
    public final Scheduler f19622d;

    /* renamed from: e */
    public final long f19623e;

    /* renamed from: f */
    public final int f19624f;

    /* renamed from: g */
    public final boolean f19625g;

    public ObservableWindowTimed(Observable<T> observable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, long j3, int i, boolean z) {
        super(observable);
        this.f19619a = j;
        this.f19620b = j2;
        this.f19621c = timeUnit;
        this.f19622d = scheduler;
        this.f19623e = j3;
        this.f19624f = i;
        this.f19625g = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        if (this.f19619a == this.f19620b) {
            if (this.f19623e == Long.MAX_VALUE) {
                this.source.subscribe(new j02(observer, this.f19619a, this.f19621c, this.f19622d, this.f19624f));
                return;
            }
            ObservableSource<Object> observableSource = this.source;
            Scheduler scheduler = this.f19622d;
            observableSource.subscribe(new i02(this.f19624f, this.f19619a, this.f19623e, observer, scheduler, this.f19621c, this.f19625g));
            return;
        }
        ObservableSource<Object> observableSource2 = this.source;
        Scheduler.Worker createWorker = this.f19622d.createWorker();
        observableSource2.subscribe(new k02(observer, this.f19619a, this.f19620b, this.f19621c, createWorker, this.f19624f));
    }
}
