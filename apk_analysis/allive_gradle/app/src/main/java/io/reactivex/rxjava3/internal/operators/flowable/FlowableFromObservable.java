package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.ObservableSource;
import org.reactivestreams.Subscriber;
import p000.om0;

/* loaded from: classes2.dex */
public final class FlowableFromObservable<T> extends Flowable<T> {

    /* renamed from: b */
    public final ObservableSource f18876b;

    public FlowableFromObservable(ObservableSource<T> observableSource) {
        this.f18876b = observableSource;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f18876b.subscribe(new om0(subscriber));
    }
}
