package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.concurrent.TimeUnit;
import p000.qj1;

/* loaded from: classes2.dex */
public final class MaybeTimeInterval<T> extends Maybe<Timed<T>> {

    /* renamed from: a */
    public final MaybeSource f19205a;

    /* renamed from: b */
    public final TimeUnit f19206b;

    /* renamed from: c */
    public final Scheduler f19207c;

    /* renamed from: d */
    public final boolean f19208d;

    public MaybeTimeInterval(MaybeSource<T> maybeSource, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.f19205a = maybeSource;
        this.f19206b = timeUnit;
        this.f19207c = scheduler;
        this.f19208d = z;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(@NonNull MaybeObserver<? super Timed<T>> maybeObserver) {
        this.f19205a.subscribe(new qj1(maybeObserver, this.f19206b, this.f19207c, this.f19208d));
    }
}
