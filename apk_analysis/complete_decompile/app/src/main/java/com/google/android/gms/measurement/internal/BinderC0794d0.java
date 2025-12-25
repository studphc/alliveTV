package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.d0 */
/* loaded from: classes.dex */
public final class BinderC0794d0 extends zzgq {

    /* renamed from: a */
    public final /* synthetic */ AtomicReference f14008a;

    /* renamed from: b */
    public final /* synthetic */ zzny f14009b;

    public BinderC0794d0(zzny zznyVar, AtomicReference atomicReference) {
        this.f14008a = atomicReference;
        this.f14009b = zznyVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final void zze(zzpe zzpeVar) {
        AtomicReference atomicReference = this.f14008a;
        synchronized (atomicReference) {
            this.f14009b.zzu.zzaW().zzj().zzb("[sgtm] Got upload batches from service. count", Integer.valueOf(zzpeVar.zza.size()));
            atomicReference.set(zzpeVar);
            atomicReference.notifyAll();
        }
    }
}
