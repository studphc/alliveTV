package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.observables.GroupedObservable;

/* renamed from: io.reactivex.rxjava3.internal.operators.observable.a */
/* loaded from: classes2.dex */
public final class C1319a extends GroupedObservable {

    /* renamed from: b */
    public final C1320b f19641b;

    public C1319a(Object obj, C1320b c1320b) {
        super(obj);
        this.f19641b = c1320b;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public final void subscribeActual(Observer observer) {
        this.f19641b.subscribe(observer);
    }
}
