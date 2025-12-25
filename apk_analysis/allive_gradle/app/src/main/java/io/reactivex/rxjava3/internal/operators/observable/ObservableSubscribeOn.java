package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import p000.AbstractC1607o2;
import p000.wy1;
import p000.xy1;

/* loaded from: classes2.dex */
public final class ObservableSubscribeOn<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Scheduler f19568a;

    public ObservableSubscribeOn(ObservableSource<T> observableSource, Scheduler scheduler) {
        super(observableSource);
        this.f19568a = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        wy1 wy1Var = new wy1(observer);
        observer.onSubscribe(wy1Var);
        DisposableHelper.setOnce(wy1Var, this.f19568a.scheduleDirect(new xy1(0, this, wy1Var)));
    }
}
