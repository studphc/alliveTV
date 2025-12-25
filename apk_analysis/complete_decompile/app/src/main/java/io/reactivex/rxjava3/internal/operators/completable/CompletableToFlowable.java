package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromCompletable;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class CompletableToFlowable<T> extends Flowable<T> {

    /* renamed from: b */
    public final CompletableSource f18715b;

    public CompletableToFlowable(CompletableSource completableSource) {
        this.f18715b = completableSource;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f18715b.subscribe(new FlowableFromCompletable.FromCompletableObserver(subscriber));
    }
}
