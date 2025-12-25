package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import p000.C1244gt;
import p000.RunnableC1199fl;

/* loaded from: classes2.dex */
public final class CompletableTimeout extends Completable {

    /* renamed from: a */
    public final CompletableSource f18707a;

    /* renamed from: b */
    public final long f18708b;

    /* renamed from: c */
    public final TimeUnit f18709c;

    /* renamed from: d */
    public final Scheduler f18710d;

    /* renamed from: e */
    public final CompletableSource f18711e;

    public CompletableTimeout(CompletableSource completableSource, long j, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource2) {
        this.f18707a = completableSource;
        this.f18708b = j;
        this.f18709c = timeUnit;
        this.f18710d = scheduler;
        this.f18711e = completableSource2;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        compositeDisposable.add(this.f18710d.scheduleDirect(new RunnableC1199fl(1, this, atomicBoolean, compositeDisposable, completableObserver), this.f18708b, this.f18709c));
        this.f18707a.subscribe(new C1244gt(completableObserver, compositeDisposable, atomicBoolean));
    }
}
