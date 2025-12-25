package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import p000.xj1;

/* loaded from: classes2.dex */
public final class MaybeTimer extends Maybe<Long> {

    /* renamed from: a */
    public final long f19213a;

    /* renamed from: b */
    public final TimeUnit f19214b;

    /* renamed from: c */
    public final Scheduler f19215c;

    public MaybeTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f19213a = j;
        this.f19214b = timeUnit;
        this.f19215c = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super Long> maybeObserver) {
        xj1 xj1Var = new xj1(maybeObserver);
        maybeObserver.onSubscribe(xj1Var);
        DisposableHelper.replace(xj1Var, this.f19215c.scheduleDirect(xj1Var, this.f19213a, this.f19214b));
    }
}
