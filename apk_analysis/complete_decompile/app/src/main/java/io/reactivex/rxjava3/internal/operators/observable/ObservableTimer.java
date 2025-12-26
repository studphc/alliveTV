package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import p000.vz1;

/* loaded from: classes2.dex */
public final class ObservableTimer extends Observable<Long> {

    /* renamed from: a */
    public final Scheduler f19600a;

    /* renamed from: b */
    public final long f19601b;

    /* renamed from: c */
    public final TimeUnit f19602c;

    public ObservableTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f19601b = j;
        this.f19602c = timeUnit;
        this.f19600a = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Long> observer) {
        vz1 vz1Var = new vz1(observer);
        observer.onSubscribe(vz1Var);
        DisposableHelper.trySet(vz1Var, this.f19600a.scheduleDirect(vz1Var, this.f19601b, this.f19602c));
    }
}
