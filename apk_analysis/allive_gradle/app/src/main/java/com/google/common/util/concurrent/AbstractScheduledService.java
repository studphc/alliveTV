package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import p000.AbstractC1726qj;
import p000.C2042z2;
import p000.InterfaceC2005y2;
import p000.RunnableC1104d;
import p000.ThreadFactoryC1968x2;
import p000.to1;

@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class AbstractScheduledService implements Service {

    /* renamed from: b */
    public static final Logger f15260b = Logger.getLogger(AbstractScheduledService.class.getName());

    /* renamed from: a */
    public final C2042z2 f15261a = new C2042z2(this);

    /* loaded from: classes2.dex */
    public static abstract class CustomScheduler extends Scheduler {

        /* loaded from: classes2.dex */
        public static final class Schedule {

            /* renamed from: a */
            public final long f15262a;

            /* renamed from: b */
            public final TimeUnit f15263b;

            public Schedule(long j, TimeUnit timeUnit) {
                this.f15262a = j;
                this.f15263b = (TimeUnit) Preconditions.checkNotNull(timeUnit);
            }
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
        /* renamed from: a */
        public final InterfaceC2005y2 mo4314a(C2042z2 c2042z2, to1 to1Var, RunnableC1104d runnableC1104d) {
            return new CallableC0982c(this, c2042z2, to1Var, runnableC1104d).m4347a();
        }

        public abstract Schedule getNextSchedule();
    }

    /* loaded from: classes2.dex */
    public static abstract class Scheduler {
        public static Scheduler newFixedDelaySchedule(long j, long j2, TimeUnit timeUnit) {
            boolean z;
            Preconditions.checkNotNull(timeUnit);
            if (j2 > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "delay must be > 0, found %s", j2);
            return new C0988e(j, j2, timeUnit);
        }

        public static Scheduler newFixedRateSchedule(long j, long j2, TimeUnit timeUnit) {
            boolean z;
            Preconditions.checkNotNull(timeUnit);
            if (j2 > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "period must be > 0, found %s", j2);
            return new C0991f(j, j2, timeUnit);
        }

        /* renamed from: a */
        public abstract InterfaceC2005y2 mo4314a(C2042z2 c2042z2, to1 to1Var, RunnableC1104d runnableC1104d);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener listener, Executor executor) {
        this.f15261a.addListener(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.f15261a.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.f15261a.awaitTerminated();
    }

    public ScheduledExecutorService executor() {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactoryC1968x2(this));
        addListener(new C0979b(newSingleThreadScheduledExecutor), MoreExecutors.directExecutor());
        return newSingleThreadScheduledExecutor;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.f15261a.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.f15261a.isRunning();
    }

    public abstract void runOneIteration();

    public abstract Scheduler scheduler();

    public String serviceName() {
        return getClass().getSimpleName();
    }

    public void shutDown() {
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        this.f15261a.startAsync();
        return this;
    }

    public void startUp() {
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.f15261a.state();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        this.f15261a.stopAsync();
        return this;
    }

    public String toString() {
        String serviceName = serviceName();
        String valueOf = String.valueOf(state());
        return AbstractC1726qj.m7055k(valueOf.length() + AbstractC1726qj.m7052h(3, serviceName), serviceName, " [", valueOf, "]");
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j, TimeUnit timeUnit) {
        this.f15261a.awaitRunning(j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j, TimeUnit timeUnit) {
        this.f15261a.awaitTerminated(j, timeUnit);
    }
}
