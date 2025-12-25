package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public final class NewThreadScheduler extends Scheduler {

    /* renamed from: d */
    public static final RxThreadFactory f19856d = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx3.newthread-priority", 5).intValue())));

    /* renamed from: c */
    public final ThreadFactory f19857c;

    public NewThreadScheduler() {
        this(f19856d);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return new NewThreadWorker(this.f19857c);
    }

    public NewThreadScheduler(ThreadFactory threadFactory) {
        this.f19857c = threadFactory;
    }
}
