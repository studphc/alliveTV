package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.BiConsumer;
import p000.AbstractC0003a2;
import p000.bi1;

/* loaded from: classes2.dex */
public final class MaybeDoOnEvent<T> extends AbstractC0003a2 {

    /* renamed from: a */
    public final BiConsumer f19143a;

    public MaybeDoOnEvent(MaybeSource<T> maybeSource, BiConsumer<? super T, ? super Throwable> biConsumer) {
        super(maybeSource);
        this.f19143a = biConsumer;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new bi1(2, maybeObserver, this.f19143a));
    }
}
