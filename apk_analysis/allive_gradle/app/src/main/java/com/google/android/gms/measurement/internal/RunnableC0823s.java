package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.s */
/* loaded from: classes.dex */
public final class RunnableC0823s implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f14089a;

    /* renamed from: b */
    public final /* synthetic */ AtomicReference f14090b;

    /* renamed from: c */
    public final /* synthetic */ zzlw f14091c;

    public /* synthetic */ RunnableC0823s(zzlw zzlwVar, AtomicReference atomicReference, int i) {
        this.f14089a = i;
        this.f14090b = atomicReference;
        this.f14091c = zzlwVar;
    }

    /* renamed from: a */
    private final void m3505a() {
        AtomicReference atomicReference = this.f14090b;
        synchronized (atomicReference) {
            try {
                try {
                    zzlw zzlwVar = this.f14091c;
                    atomicReference.set(Boolean.valueOf(zzlwVar.zzu.zzf().zzx(zzlwVar.zzu.zzh().m3527c(), zzgi.zzZ)));
                } finally {
                    this.f14090b.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: b */
    private final void m3506b() {
        AtomicReference atomicReference = this.f14090b;
        synchronized (atomicReference) {
            try {
                try {
                    zzlw zzlwVar = this.f14091c;
                    atomicReference.set(zzlwVar.zzu.zzf().zzr(zzlwVar.zzu.zzh().m3527c(), zzgi.zzaa));
                } finally {
                    this.f14090b.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: c */
    private final void m3507c() {
        AtomicReference atomicReference = this.f14090b;
        synchronized (atomicReference) {
            try {
                try {
                    zzlw zzlwVar = this.f14091c;
                    atomicReference.set(Long.valueOf(zzlwVar.zzu.zzf().zzk(zzlwVar.zzu.zzh().m3527c(), zzgi.zzab)));
                } finally {
                    this.f14090b.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: d */
    private final void m3508d() {
        AtomicReference atomicReference = this.f14090b;
        synchronized (atomicReference) {
            try {
                try {
                    zzlw zzlwVar = this.f14091c;
                    atomicReference.set(Integer.valueOf(zzlwVar.zzu.zzf().zzh(zzlwVar.zzu.zzh().m3527c(), zzgi.zzac)));
                } finally {
                    this.f14090b.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f14089a) {
            case 0:
                m3505a();
                return;
            case 1:
                m3506b();
                return;
            case 2:
                m3507c();
                return;
            case 3:
                m3508d();
                return;
            default:
                AtomicReference atomicReference = this.f14090b;
                synchronized (atomicReference) {
                    try {
                        try {
                            zzlw zzlwVar = this.f14091c;
                            atomicReference.set(Double.valueOf(zzlwVar.zzu.zzf().zza(zzlwVar.zzu.zzh().m3527c(), zzgi.zzad)));
                        } finally {
                            this.f14090b.notify();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }
}
