package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import p000.ui2;

/* loaded from: classes2.dex */
public final class SingleDematerialize<T, R> extends Maybe<R> {

    /* renamed from: a */
    public final Single f19734a;

    /* renamed from: b */
    public final Function f19735b;

    public SingleDematerialize(Single<T> single, Function<? super T, Notification<R>> function) {
        this.f19734a = single;
        this.f19735b = function;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f19734a.subscribe(new ui2(0, maybeObserver, this.f19735b));
    }
}
