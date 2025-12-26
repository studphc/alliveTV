package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import p000.AbstractC1726qj;
import p000.C1105d0;
import p000.ExecutorC1141e0;

@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class AbstractIdleService implements Service {

    /* renamed from: a */
    public final C0976a f15258a = new C0976a(this);

    /* renamed from: b */
    public final C1105d0 f15259b = new C1105d0(this, 1);

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener listener, Executor executor) {
        this.f15259b.addListener(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.f15259b.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.f15259b.awaitTerminated();
    }

    public Executor executor() {
        return new ExecutorC1141e0(this, 1);
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.f15259b.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.f15259b.isRunning();
    }

    public String serviceName() {
        return getClass().getSimpleName();
    }

    public abstract void shutDown();

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        this.f15259b.startAsync();
        return this;
    }

    public abstract void startUp();

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.f15259b.state();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        this.f15259b.stopAsync();
        return this;
    }

    public String toString() {
        String serviceName = serviceName();
        String valueOf = String.valueOf(state());
        return AbstractC1726qj.m7055k(valueOf.length() + AbstractC1726qj.m7052h(3, serviceName), serviceName, " [", valueOf, "]");
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j, TimeUnit timeUnit) {
        this.f15259b.awaitRunning(j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j, TimeUnit timeUnit) {
        this.f15259b.awaitTerminated(j, timeUnit);
    }
}
