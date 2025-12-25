package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class i02 extends g02 implements Runnable {
    private static final long serialVersionUID = -6130475889925953722L;

    /* renamed from: m */
    public final Scheduler f18237m;

    /* renamed from: n */
    public final boolean f18238n;

    /* renamed from: o */
    public final long f18239o;

    /* renamed from: p */
    public final Scheduler.Worker f18240p;

    /* renamed from: q */
    public long f18241q;

    /* renamed from: r */
    public UnicastSubject f18242r;

    /* renamed from: s */
    public final SequentialDisposable f18243s;

    public i02(int i, long j, long j2, Observer observer, Scheduler scheduler, TimeUnit timeUnit, boolean z) {
        super(observer, j, timeUnit, i);
        this.f18237m = scheduler;
        this.f18239o = j2;
        this.f18238n = z;
        if (z) {
            this.f18240p = scheduler.createWorker();
        } else {
            this.f18240p = null;
        }
        this.f18243s = new SequentialDisposable();
    }

    @Override // p000.g02
    /* renamed from: a */
    public final void mo4896a() {
        this.f18243s.dispose();
        Scheduler.Worker worker = this.f18240p;
        if (worker != null) {
            worker.dispose();
        }
    }

    @Override // p000.g02
    /* renamed from: b */
    public final void mo4897b() {
        if (!this.f17511j.get()) {
            this.f17507f = 1L;
            this.f17513l.getAndIncrement();
            UnicastSubject create = UnicastSubject.create(this.f17506e, this);
            this.f18242r = create;
            ux1 ux1Var = new ux1(create);
            this.f17502a.onNext(ux1Var);
            h02 h02Var = new h02(this, 1L);
            boolean z = this.f18238n;
            SequentialDisposable sequentialDisposable = this.f18243s;
            if (z) {
                TimeUnit timeUnit = this.f17505d;
                Scheduler.Worker worker = this.f18240p;
                long j = this.f17504c;
                sequentialDisposable.replace(worker.schedulePeriodically(h02Var, j, j, timeUnit));
            } else {
                TimeUnit timeUnit2 = this.f17505d;
                Scheduler scheduler = this.f18237m;
                long j2 = this.f17504c;
                sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect(h02Var, j2, j2, timeUnit2));
            }
            if (ux1Var.m7788d()) {
                this.f18242r.onComplete();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p000.g02
    /* renamed from: c */
    public final void mo4898c() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        MpscLinkedQueue mpscLinkedQueue = this.f17503b;
        Observer observer = this.f17502a;
        UnicastSubject unicastSubject = this.f18242r;
        int i = 1;
        while (true) {
            if (this.f17512k) {
                mpscLinkedQueue.clear();
                unicastSubject = null;
                this.f18242r = null;
            } else {
                boolean z2 = this.f17508g;
                T poll = mpscLinkedQueue.poll();
                if (poll == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2 && z) {
                    Throwable th = this.f17509h;
                    if (th != null) {
                        if (unicastSubject != null) {
                            unicastSubject.onError(th);
                        }
                        observer.onError(th);
                    } else {
                        if (unicastSubject != null) {
                            unicastSubject.onComplete();
                        }
                        observer.onComplete();
                    }
                    mo4896a();
                    this.f17512k = true;
                } else if (!z) {
                    if (poll instanceof h02) {
                        if (((h02) poll).f17907b == this.f17507f || !this.f18238n) {
                            this.f18241q = 0L;
                            unicastSubject = m5145e(unicastSubject);
                        }
                    } else if (unicastSubject != null) {
                        unicastSubject.onNext(poll);
                        long j = this.f18241q + 1;
                        if (j == this.f18239o) {
                            this.f18241q = 0L;
                            unicastSubject = m5145e(unicastSubject);
                        } else {
                            this.f18241q = j;
                        }
                    }
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
    }

    /* renamed from: e */
    public final UnicastSubject m5145e(UnicastSubject unicastSubject) {
        if (unicastSubject != null) {
            unicastSubject.onComplete();
            unicastSubject = null;
        }
        if (this.f17511j.get()) {
            mo4896a();
        } else {
            long j = this.f17507f + 1;
            this.f17507f = j;
            this.f17513l.getAndIncrement();
            unicastSubject = UnicastSubject.create(this.f17506e, this);
            this.f18242r = unicastSubject;
            ux1 ux1Var = new ux1(unicastSubject);
            this.f17502a.onNext(ux1Var);
            if (this.f18238n) {
                h02 h02Var = new h02(this, j);
                TimeUnit timeUnit = this.f17505d;
                Scheduler.Worker worker = this.f18240p;
                long j2 = this.f17504c;
                this.f18243s.update(worker.schedulePeriodically(h02Var, j2, j2, timeUnit));
            }
            if (ux1Var.m7788d()) {
                unicastSubject.onComplete();
            }
        }
        return unicastSubject;
    }
}
