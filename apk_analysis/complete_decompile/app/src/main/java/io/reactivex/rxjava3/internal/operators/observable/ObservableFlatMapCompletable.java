package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;
import p000.AbstractC1607o2;
import p000.wv1;

/* loaded from: classes2.dex */
public final class ObservableFlatMapCompletable<T> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Function f19424a;

    /* renamed from: b */
    public final boolean f19425b;

    public ObservableFlatMapCompletable(ObservableSource<T> observableSource, Function<? super T, ? extends CompletableSource> function, boolean z) {
        super(observableSource);
        this.f19424a = function;
        this.f19425b = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new wv1(observer, this.f19424a, this.f19425b));
    }
}
