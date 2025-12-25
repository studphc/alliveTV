package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import p000.AbstractC0003a2;
import p000.ji1;

/* loaded from: classes2.dex */
public final class MaybeDoOnLifecycle<T> extends AbstractC0003a2 {

    /* renamed from: a */
    public final Consumer f19144a;

    /* renamed from: b */
    public final Action f19145b;

    public MaybeDoOnLifecycle(Maybe<T> maybe, Consumer<? super Disposable> consumer, Action action) {
        super(maybe);
        this.f19144a = consumer;
        this.f19145b = action;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new ji1(maybeObserver, this.f19144a, this.f19145b));
    }
}
