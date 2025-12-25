package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.AbstractQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.google.android.gms.measurement.internal.j */
/* loaded from: classes.dex */
public final class C0805j extends Thread {

    /* renamed from: a */
    public final Object f14042a;

    /* renamed from: b */
    public final AbstractQueue f14043b;

    /* renamed from: c */
    public boolean f14044c = false;

    /* renamed from: d */
    public final /* synthetic */ zzil f14045d;

    /* JADX WARN: Multi-variable type inference failed */
    public C0805j(zzil zzilVar, String str, BlockingQueue blockingQueue) {
        this.f14045d = zzilVar;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.f14042a = new Object();
        this.f14043b = (AbstractQueue) blockingQueue;
        setName(str);
    }

    /* renamed from: a */
    public final void m3495a() {
        Object obj = this.f14042a;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    /* renamed from: b */
    public final void m3496b() {
        zzil zzilVar = this.f14045d;
        synchronized (zzilVar.f14244h) {
            try {
                if (!this.f14044c) {
                    zzilVar.f14245i.release();
                    zzilVar.f14244h.notifyAll();
                    if (this == zzilVar.f14238b) {
                        zzilVar.f14238b = null;
                    } else if (this == zzilVar.f14239c) {
                        zzilVar.f14239c = null;
                    } else {
                        zzilVar.zzu.zzaW().zze().zza("Current scheduler thread is neither worker nor network");
                    }
                    this.f14044c = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        int i;
        boolean z = false;
        while (!z) {
            try {
                this.f14045d.f14245i.acquire();
                z = true;
            } catch (InterruptedException e) {
                this.f14045d.zzu.zzaW().zzk().zzb(String.valueOf(getName()).concat(" was interrupted"), e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                AbstractQueue abstractQueue = this.f14043b;
                C0803i c0803i = (C0803i) abstractQueue.poll();
                if (c0803i != null) {
                    if (true != c0803i.f14036b) {
                        i = 10;
                    } else {
                        i = threadPriority;
                    }
                    Process.setThreadPriority(i);
                    c0803i.run();
                } else {
                    Object obj = this.f14042a;
                    synchronized (obj) {
                        if (abstractQueue.peek() == null) {
                            zzil zzilVar = this.f14045d;
                            AtomicLong atomicLong = zzil.f14237j;
                            zzilVar.getClass();
                            try {
                                obj.wait(30000L);
                            } catch (InterruptedException e2) {
                                this.f14045d.zzu.zzaW().zzk().zzb(String.valueOf(getName()).concat(" was interrupted"), e2);
                            }
                        }
                    }
                    synchronized (this.f14045d.f14244h) {
                        if (this.f14043b.peek() == null) {
                            m3496b();
                            m3496b();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            m3496b();
            throw th;
        }
    }
}
