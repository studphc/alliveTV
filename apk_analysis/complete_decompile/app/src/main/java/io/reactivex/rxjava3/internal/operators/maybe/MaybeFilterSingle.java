package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Predicate;
import p000.mi1;

/* loaded from: classes2.dex */
public final class MaybeFilterSingle<T> extends Maybe<T> {

    /* renamed from: a */
    public final SingleSource f19154a;

    /* renamed from: b */
    public final Predicate f19155b;

    public MaybeFilterSingle(SingleSource<T> singleSource, Predicate<? super T> predicate) {
        this.f19154a = singleSource;
        this.f19155b = predicate;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f19154a.subscribe(new mi1(0, maybeObserver, this.f19155b));
    }
}
