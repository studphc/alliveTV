package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import p000.AbstractC1726qj;
import p000.C1105d0;
import p000.ExecutorC1141e0;

@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class AbstractExecutionThreadService implements Service {

    /* renamed from: b */
    public static final Logger f15249b = Logger.getLogger(AbstractExecutionThreadService.class.getName());

    /* renamed from: a */
    public final C1105d0 f15250a = new C1105d0(this, 0);

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener listener, Executor executor) {
        this.f15250a.addListener(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.f15250a.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.f15250a.awaitTerminated();
    }

    public Executor executor() {
        return new ExecutorC1141e0(this, 0);
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.f15250a.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.f15250a.isRunning();
    }

    public abstract void run();

    public String serviceName() {
        return getClass().getSimpleName();
    }

    public void shutDown() {
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        this.f15250a.startAsync();
        return this;
    }

    public void startUp() {
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.f15250a.state();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        this.f15250a.stopAsync();
        return this;
    }

    public String toString() {
        String serviceName = serviceName();
        String valueOf = String.valueOf(state());
        return AbstractC1726qj.m7055k(valueOf.length() + AbstractC1726qj.m7052h(3, serviceName), serviceName, " [", valueOf, "]");
    }

    @Beta
    public void triggerShutdown() {
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j, TimeUnit timeUnit) {
        this.f15250a.awaitRunning(j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j, TimeUnit timeUnit) {
        this.f15250a.awaitTerminated(j, timeUnit);
    }
}
