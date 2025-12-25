package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import p000.ak2;

/* loaded from: classes2.dex */
public final class SingleTimeout<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource f19807a;

    /* renamed from: b */
    public final long f19808b;

    /* renamed from: c */
    public final TimeUnit f19809c;

    /* renamed from: d */
    public final Scheduler f19810d;

    /* renamed from: e */
    public final SingleSource f19811e;

    public SingleTimeout(SingleSource<T> singleSource, long j, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource2) {
        this.f19807a = singleSource;
        this.f19808b = j;
        this.f19809c = timeUnit;
        this.f19810d = scheduler;
        this.f19811e = singleSource2;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        ak2 ak2Var = new ak2(singleObserver, this.f19811e, this.f19808b, this.f19809c);
        singleObserver.onSubscribe(ak2Var);
        DisposableHelper.replace(ak2Var.f246b, this.f19810d.scheduleDirect(ak2Var, this.f19808b, this.f19809c));
        this.f19807a.subscribe(ak2Var);
    }
}
