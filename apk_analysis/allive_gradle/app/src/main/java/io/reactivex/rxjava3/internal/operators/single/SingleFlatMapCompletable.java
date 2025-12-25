package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import p000.ej2;

/* loaded from: classes2.dex */
public final class SingleFlatMapCompletable<T> extends Completable {

    /* renamed from: a */
    public final SingleSource f19766a;

    /* renamed from: b */
    public final Function f19767b;

    public SingleFlatMapCompletable(SingleSource<T> singleSource, Function<? super T, ? extends CompletableSource> function) {
        this.f19766a = singleSource;
        this.f19767b = function;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        ej2 ej2Var = new ej2(completableObserver, this.f19767b);
        completableObserver.onSubscribe(ej2Var);
        this.f19766a.subscribe(ej2Var);
    }
}
