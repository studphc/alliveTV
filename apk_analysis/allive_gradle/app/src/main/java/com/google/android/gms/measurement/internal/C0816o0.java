package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import kotlinx.coroutines.DebugKt;

/* renamed from: com.google.android.gms.measurement.internal.o0 */
/* loaded from: classes.dex */
public final class C0816o0 {

    /* renamed from: a */
    public final /* synthetic */ zzop f14069a;

    public C0816o0(zzop zzopVar) {
        this.f14069a = zzopVar;
    }

    /* renamed from: a */
    public final void m3498a() {
        zzop zzopVar = this.f14069a;
        zzopVar.zzg();
        zzio zzioVar = zzopVar.zzu;
        if (zzioVar.zzm().m7696f(zzioVar.zzaU().currentTimeMillis())) {
            zzioVar.zzm().f27203l.zza(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                zzioVar.zzaW().zzj().zza("Detected application was in foreground");
                m3500c(zzioVar.zzaU().currentTimeMillis());
            }
        }
    }

    /* renamed from: b */
    public final void m3499b(long j, boolean z) {
        zzop zzopVar = this.f14069a;
        zzopVar.zzg();
        zzopVar.m3594a();
        zzio zzioVar = zzopVar.zzu;
        if (zzioVar.zzm().m7696f(j)) {
            zzioVar.zzm().f27203l.zza(true);
            zzopVar.zzu.zzh().m3528d();
        }
        zzioVar.zzm().f27207p.zzb(j);
        if (zzioVar.zzm().f27203l.zzb()) {
            m3500c(j);
        }
    }

    /* renamed from: c */
    public final void m3500c(long j) {
        zzop zzopVar = this.f14069a;
        zzopVar.zzg();
        if (zzopVar.zzu.zzJ()) {
            zzio zzioVar = zzopVar.zzu;
            zzioVar.zzm().f27207p.zzb(j);
            zzioVar.zzaW().zzj().zzb("Session started, time", Long.valueOf(zzioVar.zzaU().elapsedRealtime()));
            long j2 = j / 1000;
            zzio zzioVar2 = zzopVar.zzu;
            zzioVar2.zzq().m3572h(j, Long.valueOf(j2), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sid");
            zzioVar.zzm().f27208q.zzb(j2);
            zzioVar.zzm().f27203l.zza(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j2);
            zzioVar2.zzq().m3568d(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_s", bundle, j);
            String zza = zzioVar.zzm().f27213v.zza();
            if (!TextUtils.isEmpty(zza)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", zza);
                zzioVar2.zzq().m3568d(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ssr", bundle2, j);
            }
        }
    }
}
