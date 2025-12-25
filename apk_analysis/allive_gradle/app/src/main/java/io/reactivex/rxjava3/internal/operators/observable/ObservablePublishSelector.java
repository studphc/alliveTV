package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.Objects;
import p000.AbstractC1607o2;
import p000.hx1;
import p000.ix1;

/* loaded from: classes2.dex */
public final class ObservablePublishSelector<T, R> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Function f19506a;

    public ObservablePublishSelector(ObservableSource<T> observableSource, Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        super(observableSource);
        this.f19506a = function;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        PublishSubject create = PublishSubject.create();
        try {
            Object apply = this.f19506a.apply(create);
            Objects.requireNonNull(apply, "The selector returned a null ObservableSource");
            ObservableSource observableSource = (ObservableSource) apply;
            ix1 ix1Var = new ix1(observer);
            observableSource.subscribe(ix1Var);
            this.source.subscribe(new hx1(create, ix1Var, 0));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }
}
