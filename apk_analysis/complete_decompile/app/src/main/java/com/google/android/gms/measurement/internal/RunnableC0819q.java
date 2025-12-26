package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.q */
/* loaded from: classes.dex */
public final class RunnableC0819q implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ boolean f14072a;

    /* renamed from: b */
    public final /* synthetic */ zzlw f14073b;

    public RunnableC0819q(zzlw zzlwVar, boolean z) {
        this.f14072a = z;
        this.f14073b = zzlwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlw zzlwVar = this.f14073b;
        zzio zzioVar = zzlwVar.zzu;
        boolean zzJ = zzioVar.zzJ();
        boolean zzI = zzioVar.zzI();
        boolean z = this.f14072a;
        zzioVar.f14248B = Boolean.valueOf(z);
        if (zzI == z) {
            zzioVar.zzaW().zzj().zzb("Default data collection state already set to", Boolean.valueOf(z));
        }
        if (zzioVar.zzJ() == zzJ || zzioVar.zzJ() != zzioVar.zzI()) {
            zzioVar.zzaW().zzl().zzc("Default data collection is different than actual status", Boolean.valueOf(z), Boolean.valueOf(zzJ));
        }
        zzlwVar.m3574j();
    }
}
