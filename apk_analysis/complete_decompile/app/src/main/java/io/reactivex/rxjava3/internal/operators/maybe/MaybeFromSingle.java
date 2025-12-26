package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamSingleSource;
import p000.bj1;

/* loaded from: classes2.dex */
public final class MaybeFromSingle<T> extends Maybe<T> implements HasUpstreamSingleSource<T> {

    /* renamed from: a */
    public final SingleSource f19177a;

    public MaybeFromSingle(SingleSource<T> singleSource) {
        this.f19177a = singleSource;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamSingleSource
    public SingleSource<T> source() {
        return this.f19177a;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f19177a.subscribe(new bj1(maybeObserver));
    }
}
