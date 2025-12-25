package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Scheduler;
import p000.AbstractC0003a2;
import p000.jj1;
import p000.xy1;

/* loaded from: classes2.dex */
public final class MaybeSubscribeOn<T> extends AbstractC0003a2 {

    /* renamed from: a */
    public final Scheduler f19199a;

    public MaybeSubscribeOn(MaybeSource<T> maybeSource, Scheduler scheduler) {
        super(maybeSource);
        this.f19199a = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        jj1 jj1Var = new jj1(maybeObserver);
        maybeObserver.onSubscribe(jj1Var);
        jj1Var.f20522a.replace(this.f19199a.scheduleDirect(new xy1(9, jj1Var, this.source, false)));
    }
}
