package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Scheduler;
import p000.AbstractC0003a2;
import p000.gj1;

/* loaded from: classes2.dex */
public final class MaybeObserveOn<T> extends AbstractC0003a2 {

    /* renamed from: a */
    public final Scheduler f19186a;

    public MaybeObserveOn(MaybeSource<T> maybeSource, Scheduler scheduler) {
        super(maybeSource);
        this.f19186a = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new gj1(maybeObserver, this.f19186a));
    }
}
