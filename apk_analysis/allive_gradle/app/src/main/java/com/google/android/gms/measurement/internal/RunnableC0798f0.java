package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.f0 */
/* loaded from: classes.dex */
public final class RunnableC0798f0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f14020a = 1;

    /* renamed from: b */
    public final /* synthetic */ zzr f14021b;

    /* renamed from: c */
    public final /* synthetic */ zzny f14022c;

    /* renamed from: d */
    public final /* synthetic */ Object f14023d;

    public RunnableC0798f0(zzny zznyVar, zzr zzrVar, com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        this.f14021b = zzrVar;
        this.f14023d = zzcyVar;
        this.f14022c = zznyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zzny zznyVar;
        zzio zzioVar;
        zzqf zzw;
        zzio zzioVar2;
        switch (this.f14020a) {
            case 0:
                AtomicReference atomicReference2 = (AtomicReference) this.f14023d;
                synchronized (atomicReference2) {
                    try {
                        try {
                            zznyVar = this.f14022c;
                            zzioVar = zznyVar.zzu;
                        } catch (RemoteException e) {
                            this.f14022c.zzu.zzaW().zze().zzb("Failed to get app instance id", e);
                            atomicReference = (AtomicReference) this.f14023d;
                        }
                        if (!zzioVar.zzm().m7694d().zzr(zzjw.ANALYTICS_STORAGE)) {
                            zzioVar.zzaW().zzl().zza("Analytics storage consent denied; will not get app instance id");
                            zznyVar.zzu.zzq().f14303e.set(null);
                            zzioVar.zzm().f27198g.zzb(null);
                            atomicReference2.set(null);
                            atomicReference2.notify();
                        } else {
                            zzgl zzglVar = zznyVar.f14338c;
                            if (zzglVar == null) {
                                zzioVar.zzaW().zze().zza("Failed to get app instance id");
                                atomicReference2.notify();
                            } else {
                                zzr zzrVar = this.f14021b;
                                Preconditions.checkNotNull(zzrVar);
                                atomicReference2.set(zzglVar.zzf(zzrVar));
                                String str = (String) atomicReference2.get();
                                if (str != null) {
                                    zznyVar.zzu.zzq().f14303e.set(str);
                                    zzioVar.zzm().f27198g.zzb(str);
                                }
                                zznyVar.m3589g();
                                atomicReference = (AtomicReference) this.f14023d;
                                atomicReference.notify();
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        ((AtomicReference) this.f14023d).notify();
                        throw th;
                    }
                }
            default:
                com.google.android.gms.internal.measurement.zzcy zzcyVar = (com.google.android.gms.internal.measurement.zzcy) this.f14023d;
                zzny zznyVar2 = this.f14022c;
                String str2 = null;
                try {
                    try {
                        zzioVar2 = zznyVar2.zzu;
                    } catch (Throwable th2) {
                        zznyVar2.zzu.zzw().zzZ(zzcyVar, null);
                        throw th2;
                    }
                } catch (RemoteException e2) {
                    zznyVar2.zzu.zzaW().zze().zzb("Failed to get app instance id", e2);
                }
                if (!zzioVar2.zzm().m7694d().zzr(zzjw.ANALYTICS_STORAGE)) {
                    zzioVar2.zzaW().zzl().zza("Analytics storage consent denied; will not get app instance id");
                    zznyVar2.zzu.zzq().f14303e.set(null);
                    zzioVar2.zzm().f27198g.zzb(null);
                } else {
                    zzgl zzglVar2 = zznyVar2.f14338c;
                    if (zzglVar2 == null) {
                        zzioVar2.zzaW().zze().zza("Failed to get app instance id");
                    } else {
                        zzr zzrVar2 = this.f14021b;
                        Preconditions.checkNotNull(zzrVar2);
                        str2 = zzglVar2.zzf(zzrVar2);
                        if (str2 != null) {
                            zznyVar2.zzu.zzq().f14303e.set(str2);
                            zzioVar2.zzm().f27198g.zzb(str2);
                        }
                        zznyVar2.m3589g();
                        zzw = zznyVar2.zzu.zzw();
                        zzw.zzZ(zzcyVar, str2);
                        return;
                    }
                }
                zzw = zzioVar2.zzw();
                zzw.zzZ(zzcyVar, str2);
                return;
        }
    }

    public RunnableC0798f0(zzny zznyVar, AtomicReference atomicReference, zzr zzrVar) {
        this.f14023d = atomicReference;
        this.f14021b = zzrVar;
        this.f14022c = zznyVar;
    }
}
