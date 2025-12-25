package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.util.SparseArray;
import com.google.common.util.concurrent.FutureCallback;
import p000.pc3;
import p000.ub3;

/* renamed from: com.google.android.gms.measurement.internal.p */
/* loaded from: classes.dex */
public final class C0817p implements FutureCallback {

    /* renamed from: a */
    public final /* synthetic */ zzov f14070a;

    /* renamed from: b */
    public final /* synthetic */ zzlw f14071b;

    public C0817p(zzlw zzlwVar, zzov zzovVar) {
        this.f14070a = zzovVar;
        this.f14071b = zzlwVar;
    }

    /* renamed from: a */
    public final void m3501a() {
        zzio zzioVar = this.f14071b.zzu;
        SparseArray m7693c = zzioVar.zzm().m7693c();
        zzov zzovVar = this.f14070a;
        m7693c.put(zzovVar.zzc, Long.valueOf(zzovVar.zzb));
        ub3 zzm = zzioVar.zzm();
        int[] iArr = new int[m7693c.size()];
        long[] jArr = new long[m7693c.size()];
        for (int i = 0; i < m7693c.size(); i++) {
            iArr[i] = m7693c.keyAt(i);
            jArr[i] = ((Long) m7693c.valueAt(i)).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        zzm.f27205n.zzb(bundle);
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) {
        zzlw zzlwVar = this.f14071b;
        zzlwVar.zzg();
        zzlwVar.f14305g = false;
        zzio zzioVar = zzlwVar.zzu;
        int i = 2;
        if (zzioVar.zzf().zzx(null, zzgi.zzaZ)) {
            String message = th.getMessage();
            zzlwVar.f14310l = false;
            if (message != null) {
                if (!(th instanceof IllegalStateException) && !message.contains("garbage collected") && !th.getClass().getSimpleName().equals("ServiceUnavailableException")) {
                    if ((th instanceof SecurityException) && !message.endsWith("READ_DEVICE_CONFIG")) {
                        i = 3;
                    }
                } else {
                    if (message.contains("Background")) {
                        zzlwVar.f14310l = true;
                    }
                    i = 1;
                }
            }
        }
        int i2 = i - 1;
        zzov zzovVar = this.f14070a;
        if (i2 != 0) {
            if (i2 != 1) {
                zzioVar.zzaW().zze().zzc("registerTriggerAsync failed. Dropping URI. App ID, Throwable", zzhe.zzn(zzlwVar.zzu.zzh().m3527c()), th);
                m3501a();
                zzlwVar.f14306h = 1;
                zzlwVar.zzU();
                return;
            }
            zzlwVar.m3575k().add(zzovVar);
            if (zzlwVar.f14306h > ((Integer) zzgi.zzav.zza(null)).intValue()) {
                zzlwVar.f14306h = 1;
                zzioVar.zzaW().zzk().zzc("registerTriggerAsync failed. May try later. App ID, throwable", zzhe.zzn(zzlwVar.zzu.zzh().m3527c()), zzhe.zzn(th.toString()));
                return;
            }
            zzioVar.zzaW().zzk().zzd("registerTriggerAsync failed. App ID, delay in seconds, throwable", zzhe.zzn(zzlwVar.zzu.zzh().m3527c()), zzhe.zzn(String.valueOf(zzlwVar.f14306h)), zzhe.zzn(th.toString()));
            int i3 = zzlwVar.f14306h;
            if (zzlwVar.f14307i == null) {
                zzlwVar.f14307i = new pc3(zzlwVar, zzlwVar.zzu, 0);
            }
            zzlwVar.f14307i.m8016c(i3 * 1000);
            int i4 = zzlwVar.f14306h;
            zzlwVar.f14306h = i4 + i4;
            return;
        }
        zzioVar.zzaW().zzk().zzc("registerTriggerAsync failed with retriable error. Will try later. App ID, throwable", zzhe.zzn(zzlwVar.zzu.zzh().m3527c()), zzhe.zzn(th.toString()));
        zzlwVar.f14306h = 1;
        zzlwVar.m3575k().add(zzovVar);
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onSuccess(Object obj) {
        zzlw zzlwVar = this.f14071b;
        zzlwVar.zzg();
        m3501a();
        zzlwVar.f14305g = false;
        zzlwVar.f14306h = 1;
        zzlwVar.zzu.zzaW().zzd().zzb("Successfully registered trigger URI", this.f14070a.zza);
        zzlwVar.zzU();
    }
}
