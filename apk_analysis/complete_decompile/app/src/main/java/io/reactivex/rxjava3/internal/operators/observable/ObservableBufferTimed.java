package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import p000.AbstractC1607o2;
import p000.vt1;
import p000.wt1;
import p000.zt1;

/* loaded from: classes2.dex */
public final class ObservableBufferTimed<T, U extends Collection<? super T>> extends AbstractC1607o2 {

    /* renamed from: a */
    public final long f19342a;

    /* renamed from: b */
    public final long f19343b;

    /* renamed from: c */
    public final TimeUnit f19344c;

    /* renamed from: d */
    public final Scheduler f19345d;

    /* renamed from: e */
    public final Supplier f19346e;

    /* renamed from: f */
    public final int f19347f;

    /* renamed from: g */
    public final boolean f19348g;

    public ObservableBufferTimed(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, Supplier<U> supplier, int i, boolean z) {
        super(observableSource);
        this.f19342a = j;
        this.f19343b = j2;
        this.f19344c = timeUnit;
        this.f19345d = scheduler;
        this.f19346e = supplier;
        this.f19347f = i;
        this.f19348g = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super U> observer) {
        long j = this.f19342a;
        long j2 = this.f19343b;
        if (j == j2 && this.f19347f == Integer.MAX_VALUE) {
            this.source.subscribe(new wt1(new SerializedObserver(observer), this.f19346e, this.f19342a, this.f19344c, this.f19345d));
            return;
        }
        Scheduler.Worker createWorker = this.f19345d.createWorker();
        if (j == j2) {
            this.source.subscribe(new vt1(new SerializedObserver(observer), this.f19346e, this.f19342a, this.f19344c, this.f19347f, this.f19348g, createWorker));
            return;
        }
        this.source.subscribe(new zt1(new SerializedObserver(observer), this.f19346e, this.f19342a, this.f19343b, this.f19344c, createWorker));
    }
}
