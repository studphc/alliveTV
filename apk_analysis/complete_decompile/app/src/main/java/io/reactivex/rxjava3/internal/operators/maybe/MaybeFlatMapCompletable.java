package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import p000.pi1;

/* loaded from: classes2.dex */
public final class MaybeFlatMapCompletable<T> extends Completable {

    /* renamed from: a */
    public final MaybeSource f19158a;

    /* renamed from: b */
    public final Function f19159b;

    public MaybeFlatMapCompletable(MaybeSource<T> maybeSource, Function<? super T, ? extends CompletableSource> function) {
        this.f19158a = maybeSource;
        this.f19159b = function;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        pi1 pi1Var = new pi1(completableObserver, this.f19159b);
        completableObserver.onSubscribe(pi1Var);
        this.f19158a.subscribe(pi1Var);
    }
}
