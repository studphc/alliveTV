package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.observers.SerializedObserver;
import p000.AbstractC1607o2;
import p000.ky1;
import p000.my1;

/* loaded from: classes2.dex */
public final class ObservableSampleWithObservable<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final ObservableSource f19541a;

    /* renamed from: b */
    public final boolean f19542b;

    public ObservableSampleWithObservable(ObservableSource<T> observableSource, ObservableSource<?> observableSource2, boolean z) {
        super(observableSource);
        this.f19541a = observableSource2;
        this.f19542b = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        boolean z = this.f19542b;
        ObservableSource observableSource = this.f19541a;
        if (z) {
            this.source.subscribe(new ky1(serializedObserver, observableSource));
        } else {
            this.source.subscribe(new my1(serializedObserver, observableSource));
        }
    }
}
