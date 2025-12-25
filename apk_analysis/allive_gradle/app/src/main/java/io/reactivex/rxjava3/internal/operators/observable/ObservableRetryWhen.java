package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;
import java.util.Objects;
import p000.AbstractC1607o2;
import p000.gy1;

/* loaded from: classes2.dex */
public final class ObservableRetryWhen<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Function f19536a;

    public ObservableRetryWhen(ObservableSource<T> observableSource, Function<? super Observable<Throwable>, ? extends ObservableSource<?>> function) {
        super(observableSource);
        this.f19536a = function;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Subject<T> serialized = PublishSubject.create().toSerialized();
        try {
            Object apply = this.f19536a.apply(serialized);
            Objects.requireNonNull(apply, "The handler returned a null ObservableSource");
            ObservableSource observableSource = (ObservableSource) apply;
            gy1 gy1Var = new gy1(observer, serialized, this.source);
            observer.onSubscribe(gy1Var);
            observableSource.subscribe(gy1Var.f17881e);
            gy1Var.m5026a();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }
}
