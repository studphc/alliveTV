package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import p000.bk2;

/* loaded from: classes2.dex */
public final class SingleTimer extends Single<Long> {

    /* renamed from: a */
    public final long f19812a;

    /* renamed from: b */
    public final TimeUnit f19813b;

    /* renamed from: c */
    public final Scheduler f19814c;

    public SingleTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f19812a = j;
        this.f19813b = timeUnit;
        this.f19814c = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super Long> singleObserver) {
        bk2 bk2Var = new bk2(singleObserver);
        singleObserver.onSubscribe(bk2Var);
        DisposableHelper.replace(bk2Var, this.f19814c.scheduleDirect(bk2Var, this.f19812a, this.f19813b));
    }
}
