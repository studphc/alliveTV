package p000;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.operators.parallel.ParallelRunOn;
import io.reactivex.rxjava3.internal.schedulers.SchedulerMultiWorkerSupport;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class z22 implements SchedulerMultiWorkerSupport.WorkerCallback {

    /* renamed from: a */
    public final Subscriber[] f29228a;

    /* renamed from: b */
    public final Subscriber[] f29229b;

    /* renamed from: c */
    public final /* synthetic */ ParallelRunOn f29230c;

    public z22(ParallelRunOn parallelRunOn, Subscriber[] subscriberArr, Subscriber[] subscriberArr2) {
        this.f29230c = parallelRunOn;
        this.f29228a = subscriberArr;
        this.f29229b = subscriberArr2;
    }

    @Override // io.reactivex.rxjava3.internal.schedulers.SchedulerMultiWorkerSupport.WorkerCallback
    public final void onWorker(int i, Scheduler.Worker worker) {
        this.f29230c.m5296a(i, this.f29228a, this.f29229b, worker);
    }
}
