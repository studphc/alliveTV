package io.reactivex.rxjava3.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Executor;
import p000.fp0;

/* loaded from: classes2.dex */
public final class Schedulers {

    /* renamed from: a */
    public static final Scheduler f20085a = RxJavaPlugins.initSingleScheduler(new fp0(5));

    /* renamed from: b */
    public static final Scheduler f20086b = RxJavaPlugins.initComputationScheduler(new fp0(2));

    /* renamed from: c */
    public static final Scheduler f20087c = RxJavaPlugins.initIoScheduler(new fp0(3));

    /* renamed from: d */
    public static final TrampolineScheduler f20088d = TrampolineScheduler.instance();

    /* renamed from: e */
    public static final Scheduler f20089e = RxJavaPlugins.initNewThreadScheduler(new fp0(4));

    @NonNull
    public static Scheduler computation() {
        return RxJavaPlugins.onComputationScheduler(f20086b);
    }

    @NonNull
    public static Scheduler from(@NonNull Executor executor) {
        return from(executor, false, false);
    }

    @NonNull
    /* renamed from: io */
    public static Scheduler m5318io() {
        return RxJavaPlugins.onIoScheduler(f20087c);
    }

    @NonNull
    public static Scheduler newThread() {
        return RxJavaPlugins.onNewThreadScheduler(f20089e);
    }

    public static void shutdown() {
        computation().shutdown();
        m5318io().shutdown();
        newThread().shutdown();
        single().shutdown();
        trampoline().shutdown();
    }

    @NonNull
    public static Scheduler single() {
        return RxJavaPlugins.onSingleScheduler(f20085a);
    }

    public static void start() {
        computation().start();
        m5318io().start();
        newThread().start();
        single().start();
        trampoline().start();
    }

    @NonNull
    public static Scheduler trampoline() {
        return f20088d;
    }

    @NonNull
    public static Scheduler from(@NonNull Executor executor, boolean z) {
        return from(executor, z, false);
    }

    @NonNull
    public static Scheduler from(@NonNull Executor executor, boolean z, boolean z2) {
        return RxJavaPlugins.createExecutorScheduler(executor, z, z2);
    }
}
