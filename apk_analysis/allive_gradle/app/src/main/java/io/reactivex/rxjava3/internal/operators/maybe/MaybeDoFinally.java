package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Action;
import p000.AbstractC0003a2;
import p000.ii1;

/* loaded from: classes2.dex */
public final class MaybeDoFinally<T> extends AbstractC0003a2 {

    /* renamed from: a */
    public final Action f19142a;

    public MaybeDoFinally(MaybeSource<T> maybeSource, Action action) {
        super(maybeSource);
        this.f19142a = action;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new ii1(maybeObserver, this.f19142a));
    }
}
