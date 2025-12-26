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
public final class gs0 extends es0 implements Runnable {
    private static final long serialVersionUID = -6130475889925953722L;

    /* renamed from: n */
    public final Scheduler f17818n;

    /* renamed from: o */
    public final boolean f17819o;

    /* renamed from: p */
    public final long f17820p;

    /* renamed from: q */
    public final Scheduler.Worker f17821q;

    /* renamed from: r */
    public long f17822r;

    /* renamed from: s */
    public UnicastProcessor f17823s;

    /* renamed from: t */
    public final SequentialDisposable f17824t;

    public gs0(int i, long j, long j2, Scheduler scheduler, TimeUnit timeUnit, Subscriber subscriber, boolean z) {
        super(subscriber, j, timeUnit, i);
        this.f17818n = scheduler;
        this.f17820p = j2;
        this.f17819o = z;
        if (z) {
            this.f17821q = scheduler.createWorker();
        } else {
            this.f17821q = null;
        }
        this.f17824t = new SequentialDisposable();
    }

    @Override // p000.es0
    /* renamed from: a */
    public final void mo4750a() {
        this.f17824t.dispose();
        Scheduler.Worker worker = this.f17821q;
        if (worker != null) {
            worker.dispose();
        }
    }

    @Override // p000.es0
    /* renamed from: b */
    public final void mo4751b() {
        if (!this.f16969k.get()) {
            if (this.f16964f.get() != 0) {
                this.f16965g = 1L;
                this.f16971m.getAndIncrement();
                this.f17823s = UnicastProcessor.create(this.f16963e, this);
                hp0 hp0Var = new hp0(this.f17823s);
                this.f16959a.onNext(hp0Var);
                fs0 fs0Var = new fs0(this, 1L);
                if (this.f17819o) {
                    SequentialDisposable sequentialDisposable = this.f17824t;
                    Scheduler.Worker worker = this.f17821q;
                    long j = this.f16961c;
                    sequentialDisposable.replace(worker.schedulePeriodically(fs0Var, j, j, this.f16962d));
                } else {
                    SequentialDisposable sequentialDisposable2 = this.f17824t;
                    Scheduler scheduler = this.f17818n;
                    long j2 = this.f16961c;
                    sequentialDisposable2.replace(scheduler.schedulePeriodicallyDirect(fs0Var, j2, j2, this.f16962d));
                }
                if (hp0Var.m5121e()) {
                    this.f17823s.onComplete();
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p000.es0
    /* renamed from: c */
    public final void mo4752c() {
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        MpscLinkedQueue mpscLinkedQueue = this.f16960b;
        Subscriber subscriber = this.f16959a;
        UnicastProcessor unicastProcessor = this.f17823s;
        int i = 1;
        while (true) {
            if (this.f16970l) {
                mpscLinkedQueue.clear();
                unicastProcessor = null;
                this.f17823s = null;
            } else {
                boolean z2 = this.f16966h;
                T poll = mpscLinkedQueue.poll();
                if (poll == 0) {
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
                    if (poll instanceof fs0) {
                        if (((fs0) poll).f17393b == this.f16965g || !this.f17819o) {
                            this.f17822r = 0L;
                            unicastProcessor = m4985e(unicastProcessor);
                        }
                    } else if (unicastProcessor != null) {
                        unicastProcessor.onNext(poll);
                        long j = this.f17822r + 1;
                        if (j == this.f17820p) {
                            this.f17822r = 0L;
                            unicastProcessor = m4985e(unicastProcessor);
                        } else {
                            this.f17822r = j;
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
    public final UnicastProcessor m4985e(UnicastProcessor unicastProcessor) {
        if (unicastProcessor != null) {
            unicastProcessor.onComplete();
            unicastProcessor = null;
        }
        if (this.f16969k.get()) {
            mo4750a();
        } else {
            long j = this.f16965g;
            if (this.f16964f.get() == j) {
                this.f16968j.cancel();
                mo4750a();
                this.f16970l = true;
                this.f16959a.onError(new MissingBackpressureException(FlowableWindowTimed.m5280e(j)));
            } else {
                long j2 = j + 1;
                this.f16965g = j2;
                this.f16971m.getAndIncrement();
                unicastProcessor = UnicastProcessor.create(this.f16963e, this);
                this.f17823s = unicastProcessor;
                hp0 hp0Var = new hp0(unicastProcessor);
                this.f16959a.onNext(hp0Var);
                if (this.f17819o) {
                    SequentialDisposable sequentialDisposable = this.f17824t;
                    Scheduler.Worker worker = this.f17821q;
                    fs0 fs0Var = new fs0(this, j2);
                    long j3 = this.f16961c;
                    sequentialDisposable.update(worker.schedulePeriodically(fs0Var, j3, j3, this.f16962d));
                }
                if (hp0Var.m5121e()) {
                    unicastProcessor.onComplete();
                }
            }
        }
        return unicastProcessor;
    }
}
