package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.concurrent.atomic.AtomicReference;
import p000.AbstractC1726qj;

/* renamed from: com.google.android.gms.measurement.internal.c0 */
/* loaded from: classes.dex */
public final class RunnableC0792c0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f13997a;

    /* renamed from: b */
    public final /* synthetic */ zzr f13998b;

    /* renamed from: c */
    public final /* synthetic */ boolean f13999c;

    /* renamed from: d */
    public final /* synthetic */ zzny f14000d;

    /* renamed from: e */
    public final /* synthetic */ Object f14001e;

    public /* synthetic */ RunnableC0792c0(zzny zznyVar, zzr zzrVar, boolean z, AbstractSafeParcelable abstractSafeParcelable, int i) {
        this.f13997a = i;
        this.f13998b = zzrVar;
        this.f13999c = z;
        this.f14001e = abstractSafeParcelable;
        this.f14000d = zznyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zzny zznyVar;
        zzgl zzglVar;
        zzqb zzqbVar;
        zzbh zzbhVar;
        zzai zzaiVar;
        switch (this.f13997a) {
            case 0:
                AtomicReference atomicReference2 = (AtomicReference) this.f14001e;
                synchronized (atomicReference2) {
                    try {
                        try {
                            zznyVar = this.f14000d;
                            zzglVar = zznyVar.f14338c;
                        } catch (RemoteException e) {
                            this.f14000d.zzu.zzaW().zze().zzb("Failed to get all user properties; remote exception", e);
                            atomicReference = (AtomicReference) this.f14001e;
                        }
                        if (zzglVar == null) {
                            zznyVar.zzu.zzaW().zze().zza("Failed to get all user properties; not connected to service");
                            atomicReference2.notify();
                            return;
                        }
                        zzr zzrVar = this.f13998b;
                        Preconditions.checkNotNull(zzrVar);
                        atomicReference2.set(zzglVar.zzh(zzrVar, this.f13999c));
                        zznyVar.m3589g();
                        atomicReference = (AtomicReference) this.f14001e;
                        atomicReference.notify();
                        return;
                    } catch (Throwable th) {
                        ((AtomicReference) this.f14001e).notify();
                        throw th;
                    }
                }
            case 1:
                zzny zznyVar2 = this.f14000d;
                zzgl zzglVar2 = zznyVar2.f14338c;
                if (zzglVar2 == null) {
                    AbstractC1726qj.m7039D(zznyVar2.zzu, "Discarding data. Failed to set user property");
                    return;
                }
                zzr zzrVar2 = this.f13998b;
                Preconditions.checkNotNull(zzrVar2);
                if (this.f13999c) {
                    zzqbVar = null;
                } else {
                    zzqbVar = (zzqb) this.f14001e;
                }
                zznyVar2.m3584b(zzglVar2, zzqbVar, zzrVar2);
                zznyVar2.m3589g();
                return;
            case 2:
                zzny zznyVar3 = this.f14000d;
                zzgl zzglVar3 = zznyVar3.f14338c;
                if (zzglVar3 == null) {
                    AbstractC1726qj.m7039D(zznyVar3.zzu, "Discarding data. Failed to send event to service");
                    return;
                }
                zzr zzrVar3 = this.f13998b;
                Preconditions.checkNotNull(zzrVar3);
                if (this.f13999c) {
                    zzbhVar = null;
                } else {
                    zzbhVar = (zzbh) this.f14001e;
                }
                zznyVar3.m3584b(zzglVar3, zzbhVar, zzrVar3);
                zznyVar3.m3589g();
                return;
            default:
                zzny zznyVar4 = this.f14000d;
                zzgl zzglVar4 = zznyVar4.f14338c;
                if (zzglVar4 == null) {
                    AbstractC1726qj.m7039D(zznyVar4.zzu, "Discarding data. Failed to send conditional user property to service");
                    return;
                }
                zzr zzrVar4 = this.f13998b;
                Preconditions.checkNotNull(zzrVar4);
                if (this.f13999c) {
                    zzaiVar = null;
                } else {
                    zzaiVar = (zzai) this.f14001e;
                }
                zznyVar4.m3584b(zzglVar4, zzaiVar, zzrVar4);
                zznyVar4.m3589g();
                return;
        }
    }

    public RunnableC0792c0(zzny zznyVar, AtomicReference atomicReference, zzr zzrVar, boolean z) {
        this.f13997a = 0;
        this.f14001e = atomicReference;
        this.f13998b = zzrVar;
        this.f13999c = z;
        this.f14000d = zznyVar;
    }
}
