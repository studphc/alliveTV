package com.google.android.exoplayer2.util;

import java.lang.Exception;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public abstract class RunnableFutureTask<R, E extends Exception> implements RunnableFuture<R> {

    /* renamed from: a */
    public final ConditionVariable f12750a = new ConditionVariable();

    /* renamed from: b */
    public final ConditionVariable f12751b = new ConditionVariable();

    /* renamed from: c */
    public final Object f12752c = new Object();

    /* renamed from: d */
    public Exception f12753d;

    /* renamed from: e */
    public Object f12754e;

    /* renamed from: f */
    public Thread f12755f;

    /* renamed from: g */
    public boolean f12756g;

    public final void blockUntilFinished() {
        this.f12751b.blockUninterruptible();
    }

    public final void blockUntilStarted() {
        this.f12750a.blockUninterruptible();
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        synchronized (this.f12752c) {
            try {
                if (!this.f12756g && !this.f12751b.isOpen()) {
                    this.f12756g = true;
                    cancelWork();
                    Thread thread = this.f12755f;
                    if (thread != null) {
                        if (z) {
                            thread.interrupt();
                        }
                    } else {
                        this.f12750a.open();
                        this.f12751b.open();
                    }
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    public void cancelWork() {
    }

    @UnknownNull
    public abstract R doWork();

    @Override // java.util.concurrent.Future
    @UnknownNull
    public final R get() {
        this.f12751b.block();
        if (!this.f12756g) {
            if (this.f12753d == null) {
                return (R) this.f12754e;
            }
            throw new ExecutionException(this.f12753d);
        }
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f12756g;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f12751b.isOpen();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        synchronized (this.f12752c) {
            try {
                if (this.f12756g) {
                    return;
                }
                this.f12755f = Thread.currentThread();
                this.f12750a.open();
                try {
                    try {
                        this.f12754e = doWork();
                        synchronized (this.f12752c) {
                            this.f12751b.open();
                            this.f12755f = null;
                            Thread.interrupted();
                        }
                    } catch (Throwable th) {
                        synchronized (this.f12752c) {
                            this.f12751b.open();
                            this.f12755f = null;
                            Thread.interrupted();
                            throw th;
                        }
                    }
                } catch (Exception e) {
                    this.f12753d = e;
                    synchronized (this.f12752c) {
                        this.f12751b.open();
                        this.f12755f = null;
                        Thread.interrupted();
                    }
                }
            } finally {
            }
        }
    }

    @Override // java.util.concurrent.Future
    @UnknownNull
    public final R get(long j, TimeUnit timeUnit) {
        if (this.f12751b.block(TimeUnit.MILLISECONDS.convert(j, timeUnit))) {
            if (!this.f12756g) {
                if (this.f12753d == null) {
                    return (R) this.f12754e;
                }
                throw new ExecutionException(this.f12753d);
            }
            throw new CancellationException();
        }
        throw new TimeoutException();
    }
}
