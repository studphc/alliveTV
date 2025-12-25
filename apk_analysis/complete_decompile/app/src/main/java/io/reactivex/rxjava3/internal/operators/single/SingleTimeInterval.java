package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.concurrent.TimeUnit;
import p000.yj2;

/* loaded from: classes2.dex */
public final class SingleTimeInterval<T> extends Single<Timed<T>> {

    /* renamed from: a */
    public final SingleSource f19803a;

    /* renamed from: b */
    public final TimeUnit f19804b;

    /* renamed from: c */
    public final Scheduler f19805c;

    /* renamed from: d */
    public final boolean f19806d;

    public SingleTimeInterval(SingleSource<T> singleSource, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.f19803a = singleSource;
        this.f19804b = timeUnit;
        this.f19805c = scheduler;
        this.f19806d = z;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(@NonNull SingleObserver<? super Timed<T>> singleObserver) {
        this.f19803a.subscribe(new yj2(singleObserver, this.f19804b, this.f19805c, this.f19806d));
    }
}
