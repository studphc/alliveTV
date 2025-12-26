package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.schedulers.SchedulerMultiWorkerSupport;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import p000.a32;
import p000.b32;
import p000.z22;

/* loaded from: classes2.dex */
public final class ParallelRunOn<T> extends ParallelFlowable<T> {

    /* renamed from: a */
    public final ParallelFlowable f19702a;

    /* renamed from: b */
    public final Scheduler f19703b;

    /* renamed from: c */
    public final int f19704c;

    public ParallelRunOn(ParallelFlowable<? extends T> parallelFlowable, Scheduler scheduler, int i) {
        this.f19702a = parallelFlowable;
        this.f19703b = scheduler;
        this.f19704c = i;
    }

    /* renamed from: a */
    public final void m5296a(int i, Subscriber[] subscriberArr, Subscriber[] subscriberArr2, Scheduler.Worker worker) {
        Subscriber subscriber = subscriberArr[i];
        int i2 = this.f19704c;
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(i2);
        if (subscriber instanceof ConditionalSubscriber) {
            subscriberArr2[i] = new a32((ConditionalSubscriber) subscriber, i2, spscArrayQueue, worker);
        } else {
            subscriberArr2[i] = new b32(subscriber, i2, spscArrayQueue, worker);
        }
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.f19702a.parallelism();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        Subscriber<?>[] onSubscribe = RxJavaPlugins.onSubscribe(this, subscriberArr);
        if (!validate(onSubscribe)) {
            return;
        }
        int length = onSubscribe.length;
        Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
        Scheduler scheduler = this.f19703b;
        if (scheduler instanceof SchedulerMultiWorkerSupport) {
            ((SchedulerMultiWorkerSupport) scheduler).createWorkers(length, new z22(this, onSubscribe, subscriberArr2));
        } else {
            for (int i = 0; i < length; i++) {
                m5296a(i, onSubscribe, subscriberArr2, scheduler.createWorker());
            }
        }
        this.f19702a.subscribe(subscriberArr2);
    }
}
