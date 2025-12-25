package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableOperator;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import p000.AbstractC1607o2;

/* loaded from: classes2.dex */
public final class ObservableLift<R, T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final ObservableOperator f19487a;

    public ObservableLift(ObservableSource<T> observableSource, ObservableOperator<? extends R, ? super T> observableOperator) {
        super(observableSource);
        this.f19487a = observableOperator;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        ObservableOperator observableOperator = this.f19487a;
        try {
            Observer<? super Object> apply = observableOperator.apply(observer);
            Objects.requireNonNull(apply, "Operator " + observableOperator + " returned a null Observer");
            this.source.subscribe(apply);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
