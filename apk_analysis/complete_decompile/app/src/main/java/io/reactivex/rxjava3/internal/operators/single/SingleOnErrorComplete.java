package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeOnErrorComplete;

/* loaded from: classes2.dex */
public final class SingleOnErrorComplete<T> extends Maybe<T> {

    /* renamed from: a */
    public final Single f19792a;

    /* renamed from: b */
    public final Predicate f19793b;

    public SingleOnErrorComplete(Single<T> single, Predicate<? super Throwable> predicate) {
        this.f19792a = single;
        this.f19793b = predicate;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f19792a.subscribe(new MaybeOnErrorComplete.OnErrorCompleteMultiObserver(maybeObserver, this.f19793b));
    }
}
