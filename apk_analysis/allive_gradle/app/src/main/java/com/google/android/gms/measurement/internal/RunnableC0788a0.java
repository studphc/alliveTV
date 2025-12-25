package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* renamed from: com.google.android.gms.measurement.internal.a0 */
/* loaded from: classes.dex */
public final class RunnableC0788a0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f13977a;

    /* renamed from: b */
    public final /* synthetic */ Object f13978b;

    public /* synthetic */ RunnableC0788a0(int i, Object obj) {
        this.f13977a = i;
        this.f13978b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13977a) {
            case 0:
                zzmo zzmoVar = (zzmo) this.f13978b;
                zzmoVar.zza = zzmoVar.f14331h;
                return;
            default:
                zzny zznyVar = ((zznx) this.f13978b).f14336c;
                zzio zzioVar = zznyVar.zzu;
                Context zzaT = zzioVar.zzaT();
                zzioVar.zzaV();
                zzny.m3582j(zznyVar, new ComponentName(zzaT, "com.google.android.gms.measurement.AppMeasurementService"));
                return;
        }
    }
}
