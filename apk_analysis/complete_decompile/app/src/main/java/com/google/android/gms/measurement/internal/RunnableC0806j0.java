package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.measurement.internal.j0 */
/* loaded from: classes.dex */
public final class RunnableC0806j0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ ConnectionResult f14046a;

    /* renamed from: b */
    public final /* synthetic */ zznx f14047b;

    public RunnableC0806j0(zznx zznxVar, ConnectionResult connectionResult) {
        this.f14046a = connectionResult;
        this.f14047b = zznxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzny zznyVar = this.f14047b.f14336c;
        zznyVar.f14338c = null;
        if (zznyVar.zzu.zzf().zzx(null, zzgi.zzbo) && this.f14046a.getErrorCode() == 7777) {
            if (zznyVar.f14341f == null) {
                zznyVar.f14341f = Executors.newScheduledThreadPool(1);
            }
            zznyVar.f14341f.schedule(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznv
                @Override // java.lang.Runnable
                public final void run() {
                    final zzny zznyVar2 = RunnableC0806j0.this.f14047b.f14336c;
                    zznyVar2.zzu.zzaX().zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznu
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzny.this.m3583a();
                        }
                    });
                }
            }, ((Long) zzgi.zzY.zza(null)).longValue(), TimeUnit.MILLISECONDS);
            return;
        }
        zznyVar.m3588f();
    }
}
