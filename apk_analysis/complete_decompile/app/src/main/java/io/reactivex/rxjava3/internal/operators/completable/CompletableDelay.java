package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.TimeUnit;
import p000.RunnableC1485ks;

/* loaded from: classes2.dex */
public final class CompletableDelay extends Completable {

    /* renamed from: a */
    public final CompletableSource f18655a;

    /* renamed from: b */
    public final long f18656b;

    /* renamed from: c */
    public final TimeUnit f18657c;

    /* renamed from: d */
    public final Scheduler f18658d;

    /* renamed from: e */
    public final boolean f18659e;

    public CompletableDelay(CompletableSource completableSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.f18655a = completableSource;
        this.f18656b = j;
        this.f18657c = timeUnit;
        this.f18658d = scheduler;
        this.f18659e = z;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f18655a.subscribe(new RunnableC1485ks(completableObserver, this.f18656b, this.f18657c, this.f18658d, this.f18659e));
    }
}
