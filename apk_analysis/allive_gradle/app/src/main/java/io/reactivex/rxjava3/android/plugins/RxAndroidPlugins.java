package io.reactivex.rxjava3.android.plugins;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class RxAndroidPlugins {

    /* renamed from: a */
    public static volatile Function f18481a;

    /* renamed from: b */
    public static volatile Function f18482b;

    public static Function<Callable<Scheduler>, Scheduler> getInitMainThreadSchedulerHandler() {
        return f18481a;
    }

    public static Function<Scheduler, Scheduler> getOnMainThreadSchedulerHandler() {
        return f18482b;
    }

    public static Scheduler initMainThreadScheduler(Callable<Scheduler> callable) {
        RuntimeException propagate;
        if (callable != null) {
            Function function = f18481a;
            if (function == null) {
                try {
                    Scheduler call = callable.call();
                    if (call != null) {
                        return call;
                    }
                    throw new NullPointerException("Scheduler Callable returned null");
                } finally {
                }
            }
            try {
                Scheduler scheduler = (Scheduler) function.apply(callable);
                if (scheduler != null) {
                    return scheduler;
                }
                throw new NullPointerException("Scheduler Callable returned null");
            } finally {
            }
        }
        throw new NullPointerException("scheduler == null");
    }

    public static Scheduler onMainThreadScheduler(Scheduler scheduler) {
        if (scheduler != null) {
            Function function = f18482b;
            if (function == null) {
                return scheduler;
            }
            try {
                return (Scheduler) function.apply(scheduler);
            } catch (Throwable th) {
                throw Exceptions.propagate(th);
            }
        }
        throw new NullPointerException("scheduler == null");
    }

    public static void reset() {
        setInitMainThreadSchedulerHandler(null);
        setMainThreadSchedulerHandler(null);
    }

    public static void setInitMainThreadSchedulerHandler(Function<Callable<Scheduler>, Scheduler> function) {
        f18481a = function;
    }

    public static void setMainThreadSchedulerHandler(Function<Scheduler, Scheduler> function) {
        f18482b = function;
    }
}
