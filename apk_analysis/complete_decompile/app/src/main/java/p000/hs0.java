package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class hs0 extends es0 implements Runnable {

    /* renamed from: r */
    public static final Object f18157r = new Object();
    private static final long serialVersionUID = 1155822639622580836L;

    /* renamed from: n */
    public final Scheduler f18158n;

    /* renamed from: o */
    public UnicastProcessor f18159o;

    /* renamed from: p */
    public final SequentialDisposable f18160p;

    /* renamed from: q */
    public final RunnableC1104d f18161q;

    public hs0(Subscriber subscriber, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        super(subscriber, j, timeUnit, i);
        this.f18158n = scheduler;
        this.f18160p = new SequentialDisposable();
        this.f18161q = new RunnableC1104d(18, this);
    }

    @Override // p000.es0
    /* renamed from: a */
    public final void mo4750a() {
        this.f18160p.dispose();
    }

    @Override // p000.es0
    /* renamed from: b */
    public final void mo4751b() {
        if (!this.f16969k.get()) {
            if (this.f16964f.get() != 0) {
                this.f16971m.getAndIncrement();
                this.f18159o = UnicastProcessor.create(this.f16963e, this.f18161q);
                this.f16965g = 1L;
                hp0 hp0Var = new hp0(this.f18159o);
                this.f16959a.onNext(hp0Var);
                SequentialDisposable sequentialDisposable = this.f18160p;
                Scheduler scheduler = this.f18158n;
                long j = this.f16961c;
                sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect(this, j, j, this.f16962d));
                if (hp0Var.m5121e()) {
                    this.f18159o.onComplete();
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
        UnicastProcessor unicastProcessor = this.f18159o;
        int i = 1;
        while (true) {
            if (this.f16970l) {
                mpscLinkedQueue.clear();
                this.f18159o = null;
                unicastProcessor = null;
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
                        if (unicastProcessor != null) {
                            unicastProcessor.onError(th);
                        }
                        subscriber.onError(th);
                    } else {
                        if (unicastProcessor != null) {
                            unicastProcessor.onComplete();
                        }
                        subscriber.onComplete();
                    }
                    mo4750a();
                    this.f16970l = true;
                } else if (!z) {
                    if (poll == f18157r) {
                        if (unicastProcessor != null) {
                            unicastProcessor.onComplete();
                            this.f18159o = null;
                            unicastProcessor = null;
                        }
                        if (this.f16969k.get()) {
                            this.f18160p.dispose();
                        } else {
                            long j = this.f16964f.get();
                            long j2 = this.f16965g;
                            if (j == j2) {
                                this.f16968j.cancel();
                                mo4750a();
                                this.f16970l = true;
                                subscriber.onError(new MissingBackpressureException(FlowableWindowTimed.m5280e(this.f16965g)));
                            } else {
                                this.f16965g = j2 + 1;
                                this.f16971m.getAndIncrement();
                                unicastProcessor = UnicastProcessor.create(this.f16963e, this.f18161q);
                                this.f18159o = unicastProcessor;
                                hp0 hp0Var = new hp0(unicastProcessor);
                                subscriber.onNext(hp0Var);
                                if (hp0Var.m5121e()) {
                                    unicastProcessor.onComplete();
                                }
                            }
                        }
                    } else if (unicastProcessor != null) {
                        unicastProcessor.onNext(poll);
                    }
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
    }

    @Override // p000.es0, java.lang.Runnable
    public final void run() {
        this.f16960b.offer(f18157r);
        mo4752c();
    }
}
