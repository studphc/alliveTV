package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class is0 extends es0 implements Runnable {

    /* renamed from: q */
    public static final Object f20245q = new Object();

    /* renamed from: r */
    public static final Object f20246r = new Object();
    private static final long serialVersionUID = -7852870764194095894L;

    /* renamed from: n */
    public final long f20247n;

    /* renamed from: o */
    public final Scheduler.Worker f20248o;

    /* renamed from: p */
    public final LinkedList f20249p;

    public is0(Subscriber subscriber, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker, int i) {
        super(subscriber, j, timeUnit, i);
        this.f20247n = j2;
        this.f20248o = worker;
        this.f20249p = new LinkedList();
    }

    @Override // p000.es0
    /* renamed from: a */
    public final void mo4750a() {
        this.f20248o.dispose();
    }

    @Override // p000.es0
    /* renamed from: b */
    public final void mo4751b() {
        if (!this.f16969k.get()) {
            if (this.f16964f.get() != 0) {
                this.f16965g = 1L;
                this.f16971m.getAndIncrement();
                UnicastProcessor create = UnicastProcessor.create(this.f16963e, this);
                this.f20249p.add(create);
                hp0 hp0Var = new hp0(create);
                this.f16959a.onNext(hp0Var);
                this.f20248o.schedule(new RunnableC1889uy(this, 1, false), this.f16961c, this.f16962d);
                Scheduler.Worker worker = this.f20248o;
                RunnableC1889uy runnableC1889uy = new RunnableC1889uy(this, 1, true);
                long j = this.f20247n;
                worker.schedulePeriodically(runnableC1889uy, j, j, this.f16962d);
                if (hp0Var.m5121e()) {
                    create.onComplete();
                    this.f20249p.remove(create);
                }
                this.f16968j.request(Long.MAX_VALUE);
                return;
            }
            this.f16968j.cancel();
            this.f16959a.onError(new MissingBackpressureException(FlowableWindowTimed.m5280e(this.f16965g)));
            mo4750a();
            this.f16970l = true;
        }
    }

    @Override // p000.es0
    /* renamed from: c */
    public final void mo4752c() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        MpscLinkedQueue mpscLinkedQueue = this.f16960b;
        Subscriber subscriber = this.f16959a;
        LinkedList linkedList = this.f20249p;
        int i = 1;
        while (true) {
            if (this.f16970l) {
                mpscLinkedQueue.clear();
                linkedList.clear();
            } else {
                boolean z2 = this.f16966h;
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2 && z) {
                    Throwable th = this.f16967i;
                    if (th != null) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            ((UnicastProcessor) it.next()).onError(th);
                        }
                        subscriber.onError(th);
                    } else {
                        Iterator it2 = linkedList.iterator();
                        while (it2.hasNext()) {
                            ((UnicastProcessor) it2.next()).onComplete();
                        }
                        subscriber.onComplete();
                    }
                    mo4750a();
                    this.f16970l = true;
                } else if (!z) {
                    if (poll == f20245q) {
                        if (!this.f16969k.get()) {
                            long j = this.f16965g;
                            if (this.f16964f.get() != j) {
                                this.f16965g = j + 1;
                                this.f16971m.getAndIncrement();
                                UnicastProcessor create = UnicastProcessor.create(this.f16963e, this);
                                linkedList.add(create);
                                hp0 hp0Var = new hp0(create);
                                subscriber.onNext(hp0Var);
                                this.f20248o.schedule(new RunnableC1889uy(this, 1, false), this.f16961c, this.f16962d);
                                if (hp0Var.m5121e()) {
                                    create.onComplete();
                                }
                            } else {
                                this.f16968j.cancel();
                                MissingBackpressureException missingBackpressureException = new MissingBackpressureException(FlowableWindowTimed.m5280e(j));
                                Iterator it3 = linkedList.iterator();
                                while (it3.hasNext()) {
                                    ((UnicastProcessor) it3.next()).onError(missingBackpressureException);
                                }
                                subscriber.onError(missingBackpressureException);
                                mo4750a();
                                this.f16970l = true;
                            }
                        }
                    } else if (poll == f20246r) {
                        if (!linkedList.isEmpty()) {
                            ((UnicastProcessor) linkedList.remove(0)).onComplete();
                        }
                    } else {
                        Iterator it4 = linkedList.iterator();
                        while (it4.hasNext()) {
                            ((UnicastProcessor) it4.next()).onNext(poll);
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
