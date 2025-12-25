package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.observers.SerializedObserver;
import p000.AbstractC1607o2;
import p000.hu1;
import p000.ju1;

/* loaded from: classes2.dex */
public final class ObservableConcatMap<T, U> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Function f19370a;

    /* renamed from: b */
    public final int f19371b;

    /* renamed from: c */
    public final ErrorMode f19372c;

    public ObservableConcatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, int i, ErrorMode errorMode) {
        super(observableSource);
        this.f19370a = function;
        this.f19372c = errorMode;
        this.f19371b = Math.max(8, i);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super U> observer) {
        boolean z;
        ObservableSource<Object> observableSource = this.source;
        Function function = this.f19370a;
        if (ObservableScalarXMap.tryScalarXMapSubscribe(observableSource, observer, function)) {
            return;
        }
        ErrorMode errorMode = ErrorMode.IMMEDIATE;
        int i = this.f19371b;
        ErrorMode errorMode2 = this.f19372c;
        if (errorMode2 == errorMode) {
            this.source.subscribe(new ju1(new SerializedObserver(observer), function, i));
            return;
        }
        ObservableSource<Object> observableSource2 = this.source;
        if (errorMode2 == ErrorMode.END) {
            z = true;
        } else {
            z = false;
        }
        observableSource2.subscribe(new hu1(observer, function, i, z));
    }
}
