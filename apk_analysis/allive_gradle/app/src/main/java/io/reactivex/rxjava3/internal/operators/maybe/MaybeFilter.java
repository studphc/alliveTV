package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Predicate;
import p000.AbstractC0003a2;
import p000.bi1;

/* loaded from: classes2.dex */
public final class MaybeFilter<T> extends AbstractC0003a2 {

    /* renamed from: a */
    public final Predicate f19153a;

    public MaybeFilter(MaybeSource<T> maybeSource, Predicate<? super T> predicate) {
        super(maybeSource);
        this.f19153a = predicate;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new bi1(3, maybeObserver, this.f19153a));
    }
}
