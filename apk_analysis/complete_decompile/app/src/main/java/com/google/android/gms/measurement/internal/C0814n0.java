package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import kotlinx.coroutines.DebugKt;

/* renamed from: com.google.android.gms.measurement.internal.n0 */
/* loaded from: classes.dex */
public final class C0814n0 {

    /* renamed from: a */
    public long f14064a;

    /* renamed from: b */
    public long f14065b;

    /* renamed from: c */
    public final C0812m0 f14066c;

    /* renamed from: d */
    public final /* synthetic */ zzop f14067d;

    public C0814n0(zzop zzopVar) {
        this.f14067d = zzopVar;
        this.f14066c = new C0812m0(0, this, zzopVar.zzu);
        long elapsedRealtime = zzopVar.zzu.zzaU().elapsedRealtime();
        this.f14064a = elapsedRealtime;
        this.f14065b = elapsedRealtime;
    }

    /* renamed from: a */
    public final boolean m3497a(long j, boolean z, boolean z2) {
        zzop zzopVar = this.f14067d;
        zzopVar.zzg();
        zzopVar.zza();
        if (zzopVar.zzu.zzJ()) {
            zzio zzioVar = zzopVar.zzu;
            zzioVar.zzm().f27207p.zzb(zzioVar.zzaU().currentTimeMillis());
        }
        long j2 = j - this.f14064a;
        if (!z && j2 < 1000) {
            zzopVar.zzu.zzaW().zzj().zzb("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
            return false;
        }
        if (!z2) {
            j2 = j - this.f14065b;
            this.f14065b = j;
        }
        zzio zzioVar2 = zzopVar.zzu;
        zzioVar2.zzaW().zzj().zzb("Recording user engagement, ms", Long.valueOf(j2));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j2);
        boolean z3 = !zzioVar2.zzf().zzz();
        zzio zzioVar3 = zzopVar.zzu;
        zzqf.zzN(zzioVar3.zzt().zzj(z3), bundle, true);
        if (!z2) {
            zzioVar3.zzq().m3567c(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_e", bundle);
        }
        this.f14064a = j;
        C0812m0 c0812m0 = this.f14066c;
        c0812m0.m8015a();
        c0812m0.m8016c(((Long) zzgi.zzap.zza(null)).longValue());
        return true;
    }
}
