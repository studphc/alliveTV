package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import p000.AbstractC1607o2;
import p000.dx1;

/* loaded from: classes2.dex */
public final class ObservableObserveOn<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Scheduler f19495a;

    /* renamed from: b */
    public final boolean f19496b;

    /* renamed from: c */
    public final int f19497c;

    public ObservableObserveOn(ObservableSource<T> observableSource, Scheduler scheduler, boolean z, int i) {
        super(observableSource);
        this.f19495a = scheduler;
        this.f19496b = z;
        this.f19497c = i;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Scheduler scheduler = this.f19495a;
        if (scheduler instanceof TrampolineScheduler) {
            this.source.subscribe(observer);
        } else {
            this.source.subscribe(new dx1(observer, scheduler.createWorker(), this.f19496b, this.f19497c));
        }
    }
}
