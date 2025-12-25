package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Consumer;
import p000.AbstractC0003a2;
import p000.bi1;

/* loaded from: classes2.dex */
public final class MaybeDoAfterSuccess<T> extends AbstractC0003a2 {

    /* renamed from: a */
    public final Consumer f19141a;

    public MaybeDoAfterSuccess(MaybeSource<T> maybeSource, Consumer<? super T> consumer) {
        super(maybeSource);
        this.f19141a = consumer;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new bi1(1, maybeObserver, this.f19141a));
    }
}
