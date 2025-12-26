package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;
import p000.AbstractC1607o2;
import p000.bu1;

/* loaded from: classes2.dex */
public final class ObservableCollect<T, U> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Supplier f19360a;

    /* renamed from: b */
    public final BiConsumer f19361b;

    public ObservableCollect(ObservableSource<T> observableSource, Supplier<? extends U> supplier, BiConsumer<? super U, ? super T> biConsumer) {
        super(observableSource);
        this.f19360a = supplier;
        this.f19361b = biConsumer;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super U> observer) {
        try {
            Object obj = this.f19360a.get();
            Objects.requireNonNull(obj, "The initialSupplier returned a null value");
            this.source.subscribe(new bu1(observer, obj, this.f19361b, 0));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }
}
