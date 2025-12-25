package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p000.AbstractC1726qj;
import p000.fc3;

/* loaded from: classes.dex */
public final class zzil extends fc3 {

    /* renamed from: j */
    public static final AtomicLong f14237j = new AtomicLong(Long.MIN_VALUE);

    /* renamed from: b */
    public C0805j f14238b;

    /* renamed from: c */
    public C0805j f14239c;

    /* renamed from: d */
    public final PriorityBlockingQueue f14240d;

    /* renamed from: e */
    public final LinkedBlockingQueue f14241e;

    /* renamed from: f */
    public final C0801h f14242f;

    /* renamed from: g */
    public final C0801h f14243g;

    /* renamed from: h */
    public final Object f14244h;

    /* renamed from: i */
    public final Semaphore f14245i;

    public zzil(zzio zzioVar) {
        super(zzioVar);
        this.f14244h = new Object();
        this.f14245i = new Semaphore(2);
        this.f14240d = new PriorityBlockingQueue();
        this.f14241e = new LinkedBlockingQueue();
        this.f14242f = new C0801h(this, "Thread death: Uncaught exception on worker thread");
        this.f14243g = new C0801h(this, "Thread death: Uncaught exception on network thread");
    }

    /* renamed from: a */
    public final Object m3551a(AtomicReference atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            this.zzu.zzaX().zzq(runnable);
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                this.zzu.zzaW().zzk().zza("Interrupted waiting for ".concat(str));
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            this.zzu.zzaW().zzk().zza("Timed out waiting for ".concat(str));
        }
        return obj;
    }

    /* renamed from: b */
    public final void m3552b(C0803i c0803i) {
        synchronized (this.f14244h) {
            try {
                PriorityBlockingQueue priorityBlockingQueue = this.f14240d;
                priorityBlockingQueue.add(c0803i);
                C0805j c0805j = this.f14238b;
                if (c0805j == null) {
                    C0805j c0805j2 = new C0805j(this, "Measurement Worker", priorityBlockingQueue);
                    this.f14238b = c0805j2;
                    c0805j2.setUncaughtExceptionHandler(this.f14242f);
                    this.f14238b.start();
                } else {
                    c0805j.m3495a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.AbstractC0811m
    public final void zzaY() {
        if (Thread.currentThread() == this.f14239c) {
        } else {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // p000.fc3
    public final boolean zzc() {
        return false;
    }

    public final Future zzf(Callable callable) {
        zzv();
        Preconditions.checkNotNull(callable);
        C0803i c0803i = new C0803i(this, callable, false);
        if (Thread.currentThread() == this.f14238b) {
            if (!this.f14240d.isEmpty()) {
                AbstractC1726qj.m7037B(this.zzu, "Callable skipped the worker queue.");
            }
            c0803i.run();
        } else {
            m3552b(c0803i);
        }
        return c0803i;
    }

    @Override // com.google.android.gms.measurement.internal.AbstractC0811m
    public final void zzg() {
        if (Thread.currentThread() == this.f14238b) {
        } else {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final Future zzh(Callable callable) {
        zzv();
        Preconditions.checkNotNull(callable);
        C0803i c0803i = new C0803i(this, callable, true);
        if (Thread.currentThread() == this.f14238b) {
            c0803i.run();
        } else {
            m3552b(c0803i);
        }
        return c0803i;
    }

    public final void zzn() {
        if (Thread.currentThread() != this.f14238b) {
        } else {
            throw new IllegalStateException("Call not expected from worker thread");
        }
    }

    public final void zzp(Runnable runnable) {
        zzv();
        Preconditions.checkNotNull(runnable);
        C0803i c0803i = new C0803i(this, runnable, false, "Task exception on network thread");
        synchronized (this.f14244h) {
            try {
                LinkedBlockingQueue linkedBlockingQueue = this.f14241e;
                linkedBlockingQueue.add(c0803i);
                C0805j c0805j = this.f14239c;
                if (c0805j == null) {
                    C0805j c0805j2 = new C0805j(this, "Measurement Network", linkedBlockingQueue);
                    this.f14239c = c0805j2;
                    c0805j2.setUncaughtExceptionHandler(this.f14243g);
                    this.f14239c.start();
                } else {
                    c0805j.m3495a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzq(Runnable runnable) {
        zzv();
        Preconditions.checkNotNull(runnable);
        m3552b(new C0803i(this, runnable, false, "Task exception on worker thread"));
    }

    public final void zzr(Runnable runnable) {
        zzv();
        Preconditions.checkNotNull(runnable);
        m3552b(new C0803i(this, runnable, true, "Task exception on worker thread"));
    }

    public final boolean zzt() {
        if (Thread.currentThread() == this.f14239c) {
            return true;
        }
        return false;
    }

    public final boolean zzu() {
        if (Thread.currentThread() == this.f14238b) {
            return true;
        }
        return false;
    }
}
