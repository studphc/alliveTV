package com.google.android.gms.measurement.internal;

import p000.hc3;
import p000.w93;

/* renamed from: com.google.android.gms.measurement.internal.m0 */
/* loaded from: classes.dex */
public final class C0812m0 extends w93 {

    /* renamed from: e */
    public final /* synthetic */ int f14060e;

    /* renamed from: f */
    public final /* synthetic */ Object f14061f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0812m0(int i, Object obj, hc3 hc3Var) {
        super(hc3Var);
        this.f14060e = i;
        this.f14061f = obj;
    }

    @Override // p000.w93
    /* renamed from: b */
    public final void mo3493b() {
        switch (this.f14060e) {
            case 0:
                C0814n0 c0814n0 = (C0814n0) this.f14061f;
                zzop zzopVar = c0814n0.f14067d;
                zzopVar.zzg();
                zzio zzioVar = zzopVar.zzu;
                c0814n0.m3497a(zzioVar.zzaU().elapsedRealtime(), false, false);
                zzopVar.zzu.zzd().zzf(zzioVar.zzaU().elapsedRealtime());
                return;
            default:
                zzoy zzoyVar = (zzoy) this.f14061f;
                zzoyVar.zza();
                zzoyVar.zzu.zzaW().zzj().zza("Starting upload from DelayedRunnable");
                zzoyVar.zzg.m3629P();
                return;
        }
    }
}
