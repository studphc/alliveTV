package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import p000.AbstractC1607o2;
import p000.uv1;

/* loaded from: classes2.dex */
public final class ObservableFlatMap<T, U> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Function f19420a;

    /* renamed from: b */
    public final boolean f19421b;

    /* renamed from: c */
    public final int f19422c;

    /* renamed from: d */
    public final int f19423d;

    public ObservableFlatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z, int i, int i2) {
        super(observableSource);
        this.f19420a = function;
        this.f19421b = z;
        this.f19422c = i;
        this.f19423d = i2;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super U> observer) {
        if (ObservableScalarXMap.tryScalarXMapSubscribe(this.source, observer, this.f19420a)) {
            return;
        }
        this.source.subscribe(new uv1(this.f19422c, this.f19423d, observer, this.f19420a, this.f19421b));
    }
}
