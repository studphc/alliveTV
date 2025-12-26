package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import p000.AbstractC1726qj;

/* renamed from: com.google.android.gms.measurement.internal.e0 */
/* loaded from: classes.dex */
public final class RunnableC0796e0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f14016a;

    /* renamed from: b */
    public final /* synthetic */ zzr f14017b;

    /* renamed from: c */
    public final /* synthetic */ zzny f14018c;

    public /* synthetic */ RunnableC0796e0(zzny zznyVar, zzr zzrVar, int i) {
        this.f14016a = i;
        this.f14017b = zzrVar;
        this.f14018c = zznyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f14016a) {
            case 0:
                zzny zznyVar = this.f14018c;
                zzgl zzglVar = zznyVar.f14338c;
                if (zzglVar == null) {
                    AbstractC1726qj.m7039D(zznyVar.zzu, "Failed to reset data on the service: not connected to service");
                    return;
                }
                try {
                    zzr zzrVar = this.f14017b;
                    Preconditions.checkNotNull(zzrVar);
                    zzglVar.zzs(zzrVar);
                } catch (RemoteException e) {
                    zznyVar.zzu.zzaW().zze().zzb("Failed to reset data on the service: remote exception", e);
                }
                zznyVar.m3589g();
                return;
            case 1:
                zzny zznyVar2 = this.f14018c;
                zzgl zzglVar2 = zznyVar2.f14338c;
                if (zzglVar2 == null) {
                    AbstractC1726qj.m7039D(zznyVar2.zzu, "Discarding data. Failed to send app launch");
                    return;
                }
                try {
                    zzr zzrVar2 = this.f14017b;
                    Preconditions.checkNotNull(zzrVar2);
                    zzio zzioVar = zznyVar2.zzu;
                    zzam zzf = zzioVar.zzf();
                    zzgg zzggVar = zzgi.zzbl;
                    if (zzf.zzx(null, zzggVar)) {
                        zznyVar2.m3584b(zzglVar2, null, zzrVar2);
                    }
                    zzglVar2.zzn(zzrVar2);
                    zznyVar2.zzu.zzi().zzm();
                    zzioVar.zzf().zzx(null, zzggVar);
                    zznyVar2.m3584b(zzglVar2, null, zzrVar2);
                    zznyVar2.m3589g();
                    return;
                } catch (RemoteException e2) {
                    zznyVar2.zzu.zzaW().zze().zzb("Failed to send app launch to the service", e2);
                    return;
                }
            case 2:
                zzny zznyVar3 = this.f14018c;
                zzgl zzglVar3 = zznyVar3.f14338c;
                if (zzglVar3 == null) {
                    AbstractC1726qj.m7037B(zznyVar3.zzu, "Failed to send app backgrounded");
                    return;
                }
                try {
                    zzr zzrVar3 = this.f14017b;
                    Preconditions.checkNotNull(zzrVar3);
                    zzglVar3.zzm(zzrVar3);
                    zznyVar3.m3589g();
                    return;
                } catch (RemoteException e3) {
                    zznyVar3.zzu.zzaW().zze().zzb("Failed to send app backgrounded to the service", e3);
                    return;
                }
            case 3:
                zzny zznyVar4 = this.f14018c;
                zzgl zzglVar4 = zznyVar4.f14338c;
                if (zzglVar4 == null) {
                    AbstractC1726qj.m7039D(zznyVar4.zzu, "Failed to send measurementEnabled to service");
                    return;
                }
                try {
                    zzr zzrVar4 = this.f14017b;
                    Preconditions.checkNotNull(zzrVar4);
                    zzglVar4.zzz(zzrVar4);
                    zznyVar4.m3589g();
                    return;
                } catch (RemoteException e4) {
                    zznyVar4.zzu.zzaW().zze().zzb("Failed to send measurementEnabled to the service", e4);
                    return;
                }
            default:
                zzny zznyVar5 = this.f14018c;
                zzgl zzglVar5 = zznyVar5.f14338c;
                if (zzglVar5 == null) {
                    AbstractC1726qj.m7039D(zznyVar5.zzu, "Failed to send consent settings to service");
                    return;
                }
                try {
                    zzr zzrVar5 = this.f14017b;
                    Preconditions.checkNotNull(zzrVar5);
                    zzglVar5.zzv(zzrVar5);
                    zznyVar5.m3589g();
                    return;
                } catch (RemoteException e5) {
                    zznyVar5.zzu.zzaW().zze().zzb("Failed to send consent settings to the service", e5);
                    return;
                }
        }
    }
}
