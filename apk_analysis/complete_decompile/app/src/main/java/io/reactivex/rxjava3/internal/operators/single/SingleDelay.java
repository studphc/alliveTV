package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;
import p000.pi2;

/* loaded from: classes2.dex */
public final class SingleDelay<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19721a;

    /* renamed from: b */
    public final long f19722b;

    /* renamed from: c */
    public final TimeUnit f19723c;

    /* renamed from: d */
    public final Scheduler f19724d;

    /* renamed from: e */
    public final boolean f19725e;

    public SingleDelay(SingleSource<? extends T> singleSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.f19721a = singleSource;
        this.f19722b = j;
        this.f19723c = timeUnit;
        this.f19724d = scheduler;
        this.f19725e = z;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        singleObserver.onSubscribe(sequentialDisposable);
        this.f19721a.subscribe(new pi2(this, sequentialDisposable, singleObserver));
    }
}
