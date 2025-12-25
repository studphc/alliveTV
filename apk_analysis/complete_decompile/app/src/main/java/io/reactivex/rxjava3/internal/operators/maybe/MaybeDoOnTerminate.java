package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Action;
import p000.ei1;

/* loaded from: classes2.dex */
public final class MaybeDoOnTerminate<T> extends Maybe<T> {

    /* renamed from: a */
    public final MaybeSource f19146a;

    /* renamed from: b */
    public final Action f19147b;

    public MaybeDoOnTerminate(MaybeSource<T> maybeSource, Action action) {
        this.f19146a = maybeSource;
        this.f19147b = action;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f19146a.subscribe(new ei1(1, maybeObserver, this));
    }
}
