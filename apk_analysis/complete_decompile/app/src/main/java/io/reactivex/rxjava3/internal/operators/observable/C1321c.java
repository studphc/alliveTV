package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableScalarXMap;
import java.util.Objects;

/* renamed from: io.reactivex.rxjava3.internal.operators.observable.c */
/* loaded from: classes2.dex */
public final class C1321c extends Observable {

    /* renamed from: a */
    public final Object f19651a;

    /* renamed from: b */
    public final Function f19652b;

    public C1321c(Object obj, Function function) {
        this.f19651a = obj;
        this.f19652b = function;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public final void subscribeActual(Observer observer) {
        try {
            Object apply = this.f19652b.apply(this.f19651a);
            Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
            ObservableSource observableSource = (ObservableSource) apply;
            if (observableSource instanceof Supplier) {
                try {
                    Object obj = ((Supplier) observableSource).get();
                    if (obj == null) {
                        EmptyDisposable.complete((Observer<?>) observer);
                        return;
                    }
                    ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(observer, obj);
                    observer.onSubscribe(scalarDisposable);
                    scalarDisposable.run();
                    return;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptyDisposable.error(th, (Observer<?>) observer);
                    return;
                }
            }
            observableSource.subscribe(observer);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
