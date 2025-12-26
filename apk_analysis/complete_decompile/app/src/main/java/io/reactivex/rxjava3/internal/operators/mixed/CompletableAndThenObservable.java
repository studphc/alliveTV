package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import p000.C0568bs;

/* loaded from: classes2.dex */
public final class CompletableAndThenObservable<R> extends Observable<R> {

    /* renamed from: a */
    public final CompletableSource f19230a;

    /* renamed from: b */
    public final ObservableSource f19231b;

    public CompletableAndThenObservable(CompletableSource completableSource, ObservableSource<? extends R> observableSource) {
        this.f19230a = completableSource;
        this.f19231b = observableSource;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        C0568bs c0568bs = new C0568bs(this.f19231b, observer);
        observer.onSubscribe(c0568bs);
        this.f19230a.subscribe(c0568bs);
    }
}
