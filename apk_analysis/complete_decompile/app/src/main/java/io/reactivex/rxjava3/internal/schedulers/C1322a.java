package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.internal.schedulers.SchedulerMultiWorkerSupport;
import java.util.concurrent.ThreadFactory;
import p000.C1330iu;
import p000.C1367ju;

/* renamed from: io.reactivex.rxjava3.internal.schedulers.a */
/* loaded from: classes2.dex */
public final class C1322a implements SchedulerMultiWorkerSupport {

    /* renamed from: a */
    public final int f19878a;

    /* renamed from: b */
    public final C1367ju[] f19879b;

    /* renamed from: c */
    public long f19880c;

    /* JADX WARN: Multi-variable type inference failed */
    public C1322a(ThreadFactory threadFactory, int i) {
        this.f19878a = i;
        this.f19879b = new C1367ju[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.f19879b[i2] = new NewThreadWorker(threadFactory);
        }
    }

    /* renamed from: a */
    public final C1367ju m5298a() {
        int i = this.f19878a;
        if (i == 0) {
            return ComputationScheduler.f19832h;
        }
        long j = this.f19880c;
        this.f19880c = 1 + j;
        return this.f19879b[(int) (j % i)];
    }

    /* renamed from: b */
    public final void m5299b() {
        for (C1367ju c1367ju : this.f19879b) {
            c1367ju.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.internal.schedulers.SchedulerMultiWorkerSupport
    public final void createWorkers(int i, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
        int i2 = this.f19878a;
        if (i2 == 0) {
            for (int i3 = 0; i3 < i; i3++) {
                workerCallback.onWorker(i3, ComputationScheduler.f19832h);
            }
            return;
        }
        int i4 = ((int) this.f19880c) % i2;
        for (int i5 = 0; i5 < i; i5++) {
            workerCallback.onWorker(i5, new C1330iu(this.f19879b[i4]));
            i4++;
            if (i4 == i2) {
                i4 = 0;
            }
        }
        this.f19880c = i4;
    }
}
