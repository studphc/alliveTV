package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.BiPredicate;
import p000.oy1;
import p000.py1;

/* loaded from: classes2.dex */
public final class ObservableSequenceEqual<T> extends Observable<Boolean> {

    /* renamed from: a */
    public final ObservableSource f19548a;

    /* renamed from: b */
    public final ObservableSource f19549b;

    /* renamed from: c */
    public final BiPredicate f19550c;

    /* renamed from: d */
    public final int f19551d;

    public ObservableSequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        this.f19548a = observableSource;
        this.f19549b = observableSource2;
        this.f19550c = biPredicate;
        this.f19551d = i;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Boolean> observer) {
        oy1 oy1Var = new oy1(observer, this.f19551d, this.f19548a, this.f19549b, this.f19550c);
        observer.onSubscribe(oy1Var);
        py1[] py1VarArr = oy1Var.f24957f;
        oy1Var.f24955d.subscribe(py1VarArr[0]);
        oy1Var.f24956e.subscribe(py1VarArr[1]);
    }
}
