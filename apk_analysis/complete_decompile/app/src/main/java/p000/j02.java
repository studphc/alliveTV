package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class j02 extends g02 implements Runnable {

    /* renamed from: q */
    public static final Object f20329q = new Object();
    private static final long serialVersionUID = 1155822639622580836L;

    /* renamed from: m */
    public final Scheduler f20330m;

    /* renamed from: n */
    public UnicastSubject f20331n;

    /* renamed from: o */
    public final SequentialDisposable f20332o;

    /* renamed from: p */
    public final sn1 f20333p;

    public j02(Observer observer, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        super(observer, j, timeUnit, i);
        this.f20330m = scheduler;
        this.f20332o = new SequentialDisposable();
        this.f20333p = new sn1(3, this);
    }

    @Override // p000.g02
    /* renamed from: a */
    public final void mo4896a() {
        this.f20332o.dispose();
    }

    @Override // p000.g02
    /* renamed from: b */
    public final void mo4897b() {
        if (!this.f17511j.get()) {
            this.f17513l.getAndIncrement();
            UnicastSubject create = UnicastSubject.create(this.f17506e, this.f20333p);
            this.f20331n = create;
            this.f17507f = 1L;
            ux1 ux1Var = new ux1(create);
            this.f17502a.onNext(ux1Var);
            TimeUnit timeUnit = this.f17505d;
            Scheduler scheduler = this.f20330m;
            long j = this.f17504c;
            this.f20332o.replace(scheduler.schedulePeriodicallyDirect(this, j, j, timeUnit));
            if (ux1Var.m7788d()) {
                this.f20331n.onComplete();
            }
        }
    }

    @Override // p000.g02
    /* renamed from: c */
    public final void mo4898c() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        MpscLinkedQueue mpscLinkedQueue = this.f17503b;
        Observer observer = this.f17502a;
        UnicastSubject unicastSubject = this.f20331n;
        int i = 1;
        while (true) {
            if (this.f17512k) {
                mpscLinkedQueue.clear();
                this.f20331n = null;
                unicastSubject = null;
            } else {
                boolean z2 = this.f17508g;
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
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
                    if (poll == f20329q) {
                        if (unicastSubject != null) {
                            unicastSubject.onComplete();
                            this.f20331n = null;
                            unicastSubject = null;
                        }
                        if (this.f17511j.get()) {
                            this.f20332o.dispose();
                        } else {
                            this.f17507f++;
                            this.f17513l.getAndIncrement();
                            unicastSubject = UnicastSubject.create(this.f17506e, this.f20333p);
                            this.f20331n = unicastSubject;
                            ux1 ux1Var = new ux1(unicastSubject);
                            observer.onNext(ux1Var);
                            if (ux1Var.m7788d()) {
                                unicastSubject.onComplete();
                            }
                        }
                    } else if (unicastSubject != null) {
                        unicastSubject.onNext(poll);
                    }
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
    }

    @Override // p000.g02, java.lang.Runnable
    public final void run() {
        this.f17503b.offer(f20329q);
        mo4898c();
    }
}
