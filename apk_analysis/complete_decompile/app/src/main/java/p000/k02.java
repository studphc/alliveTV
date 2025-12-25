package p000;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class k02 extends g02 implements Runnable {

    /* renamed from: p */
    public static final Object f20706p = new Object();

    /* renamed from: q */
    public static final Object f20707q = new Object();
    private static final long serialVersionUID = -7852870764194095894L;

    /* renamed from: m */
    public final long f20708m;

    /* renamed from: n */
    public final Scheduler.Worker f20709n;

    /* renamed from: o */
    public final LinkedList f20710o;

    public k02(Observer observer, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker, int i) {
        super(observer, j, timeUnit, i);
        this.f20708m = j2;
        this.f20709n = worker;
        this.f20710o = new LinkedList();
    }

    @Override // p000.g02
    /* renamed from: a */
    public final void mo4896a() {
        this.f20709n.dispose();
    }

    @Override // p000.g02
    /* renamed from: b */
    public final void mo4897b() {
        if (!this.f17511j.get()) {
            this.f17507f = 1L;
            this.f17513l.getAndIncrement();
            UnicastSubject create = UnicastSubject.create(this.f17506e, this);
            LinkedList linkedList = this.f20710o;
            linkedList.add(create);
            ux1 ux1Var = new ux1(create);
            this.f17502a.onNext(ux1Var);
            this.f20709n.schedule(new RunnableC1889uy(this, 2, false), this.f17504c, this.f17505d);
            RunnableC1889uy runnableC1889uy = new RunnableC1889uy(this, 2, true);
            TimeUnit timeUnit = this.f17505d;
            Scheduler.Worker worker = this.f20709n;
            long j = this.f20708m;
            worker.schedulePeriodically(runnableC1889uy, j, j, timeUnit);
            if (ux1Var.m7788d()) {
                create.onComplete();
                linkedList.remove(create);
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
        LinkedList linkedList = this.f20710o;
        int i = 1;
        while (true) {
            if (this.f17512k) {
                mpscLinkedQueue.clear();
                linkedList.clear();
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
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            ((UnicastSubject) it.next()).onError(th);
                        }
                        observer.onError(th);
                    } else {
                        Iterator it2 = linkedList.iterator();
                        while (it2.hasNext()) {
                            ((UnicastSubject) it2.next()).onComplete();
                        }
                        observer.onComplete();
                    }
                    mo4896a();
                    this.f17512k = true;
                } else if (!z) {
                    if (poll == f20706p) {
                        if (!this.f17511j.get()) {
                            this.f17507f++;
                            this.f17513l.getAndIncrement();
                            UnicastSubject create = UnicastSubject.create(this.f17506e, this);
                            linkedList.add(create);
                            ux1 ux1Var = new ux1(create);
                            observer.onNext(ux1Var);
                            this.f20709n.schedule(new RunnableC1889uy(this, 2, false), this.f17504c, this.f17505d);
                            if (ux1Var.m7788d()) {
                                create.onComplete();
                            }
                        }
                    } else if (poll == f20707q) {
                        if (!linkedList.isEmpty()) {
                            ((UnicastSubject) linkedList.remove(0)).onComplete();
                        }
                    } else {
                        Iterator it3 = linkedList.iterator();
                        while (it3.hasNext()) {
                            ((UnicastSubject) it3.next()).onNext(poll);
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
}
