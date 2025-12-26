package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import p000.AbstractC1607o2;
import p000.mu1;

/* loaded from: classes2.dex */
public final class ObservableConcatMapEager<T, R> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Function f19373a;

    /* renamed from: b */
    public final ErrorMode f19374b;

    /* renamed from: c */
    public final int f19375c;

    /* renamed from: d */
    public final int f19376d;

    public ObservableConcatMapEager(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, ErrorMode errorMode, int i, int i2) {
        super(observableSource);
        this.f19373a = function;
        this.f19374b = errorMode;
        this.f19375c = i;
        this.f19376d = i2;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe(new mu1(observer, this.f19373a, this.f19375c, this.f19376d, this.f19374b));
    }
}
