package com.google.android.gms.measurement.internal;

import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.google.android.gms.measurement.internal.i0 */
/* loaded from: classes.dex */
public final class RunnableC0804i0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f14039a;

    /* renamed from: b */
    public final /* synthetic */ zzgl f14040b;

    /* renamed from: c */
    public final /* synthetic */ zznx f14041c;

    public /* synthetic */ RunnableC0804i0(zznx zznxVar, zzgl zzglVar, int i) {
        this.f14039a = i;
        this.f14040b = zzglVar;
        this.f14041c = zznxVar;
    }

    /* renamed from: a */
    private final void m3494a() {
        zznx zznxVar = this.f14041c;
        synchronized (zznxVar) {
            try {
                zznxVar.f14334a = false;
                zzny zznyVar = zznxVar.f14336c;
                if (!zznyVar.zzaa()) {
                    zznyVar.zzu.zzaW().zzj().zza("Connected to service");
                    zznyVar.zzW(this.f14040b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScheduledExecutorService scheduledExecutorService;
        switch (this.f14039a) {
            case 0:
                m3494a();
                return;
            default:
                zznx zznxVar = this.f14041c;
                synchronized (zznxVar) {
                    try {
                        zznxVar.f14334a = false;
                        zzny zznyVar = zznxVar.f14336c;
                        if (!zznyVar.zzaa()) {
                            zznyVar.zzu.zzaW().zzd().zza("Connected to remote service");
                            zznyVar.zzW(this.f14040b);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                zzny zznyVar2 = this.f14041c.f14336c;
                if (zznyVar2.zzu.zzf().zzx(null, zzgi.zzbo) && (scheduledExecutorService = zznyVar2.f14341f) != null) {
                    scheduledExecutorService.shutdownNow();
                    zznyVar2.f14341f = null;
                    return;
                }
                return;
        }
    }
}
