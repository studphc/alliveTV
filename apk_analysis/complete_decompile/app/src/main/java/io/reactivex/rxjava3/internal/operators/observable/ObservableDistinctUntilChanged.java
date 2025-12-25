package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.Function;
import p000.AbstractC1607o2;
import p000.mv1;

/* loaded from: classes2.dex */
public final class ObservableDistinctUntilChanged<T, K> extends AbstractC1607o2 {

    /* renamed from: a */
    public final Function f19400a;

    /* renamed from: b */
    public final BiPredicate f19401b;

    public ObservableDistinctUntilChanged(ObservableSource<T> observableSource, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(observableSource);
        this.f19400a = function;
        this.f19401b = biPredicate;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new mv1(observer, this.f19400a, this.f19401b));
    }
}
