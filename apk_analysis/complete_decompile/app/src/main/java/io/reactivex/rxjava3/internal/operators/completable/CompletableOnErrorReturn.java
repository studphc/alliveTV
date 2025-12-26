package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.functions.Function;
import p000.C2068zs;

/* loaded from: classes2.dex */
public final class CompletableOnErrorReturn<T> extends Maybe<T> {

    /* renamed from: a */
    public final CompletableSource f18692a;

    /* renamed from: b */
    public final Function f18693b;

    public CompletableOnErrorReturn(CompletableSource completableSource, Function<? super Throwable, ? extends T> function) {
        this.f18692a = completableSource;
        this.f18693b = function;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f18692a.subscribe(new C2068zs(maybeObserver, this.f18693b));
    }
}
