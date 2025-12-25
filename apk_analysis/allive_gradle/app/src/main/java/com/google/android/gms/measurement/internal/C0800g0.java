package com.google.android.gms.measurement.internal;

import p000.AbstractC1726qj;
import p000.w93;

/* renamed from: com.google.android.gms.measurement.internal.g0 */
/* loaded from: classes.dex */
public final class C0800g0 extends w93 {

    /* renamed from: e */
    public final /* synthetic */ int f14025e;

    /* renamed from: f */
    public final /* synthetic */ zzny f14026f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0800g0(zzny zznyVar, zzio zzioVar, int i) {
        super(zzioVar);
        this.f14025e = i;
        this.f14026f = zznyVar;
    }

    @Override // p000.w93
    /* renamed from: b */
    public final void mo3493b() {
        switch (this.f14025e) {
            case 0:
                zzny zznyVar = this.f14026f;
                zznyVar.zzg();
                if (zznyVar.zzaa()) {
                    zznyVar.zzu.zzaW().zzj().zza("Inactivity, disconnecting from the service");
                    zznyVar.zzC();
                    return;
                }
                return;
            default:
                AbstractC1726qj.m7037B(this.f14026f.zzu, "Tasks have been queued for a long time");
                return;
        }
    }
}
