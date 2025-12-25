package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import p000.g21;
import p000.g50;

/* loaded from: classes2.dex */
public final class ImmediateThinScheduler extends Scheduler {
    public static final Scheduler INSTANCE = new Scheduler();

    /* renamed from: c */
    public static final g21 f19845c = new Scheduler.Worker();

    /* renamed from: d */
    public static final Disposable f19846d;

    /* JADX WARN: Type inference failed for: r0v1, types: [io.reactivex.rxjava3.core.Scheduler$Worker, g21] */
    static {
        Disposable m4920b = g50.m4920b();
        f19846d = m4920b;
        m4920b.dispose();
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return f19845c;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable) {
        runnable.run();
        return f19846d;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }
}
