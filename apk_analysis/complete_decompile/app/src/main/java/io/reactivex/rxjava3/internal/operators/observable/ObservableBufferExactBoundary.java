package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.Collection;
import p000.AbstractC1607o2;
import p000.ut1;

/* loaded from: classes2.dex */
public final class ObservableBufferExactBoundary<T, U extends Collection<? super T>, B> extends AbstractC1607o2 {

    /* renamed from: a */
    public final ObservableSource f19340a;

    /* renamed from: b */
    public final Supplier f19341b;

    public ObservableBufferExactBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Supplier<U> supplier) {
        super(observableSource);
        this.f19340a = observableSource2;
        this.f19341b = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super U> observer) {
        this.source.subscribe(new ut1(new SerializedObserver(observer), this.f19341b, this.f19340a));
    }
}
