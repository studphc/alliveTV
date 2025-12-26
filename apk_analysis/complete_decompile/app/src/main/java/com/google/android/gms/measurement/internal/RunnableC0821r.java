package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;
import p000.mb3;
import p000.ub3;

/* renamed from: com.google.android.gms.measurement.internal.r */
/* loaded from: classes.dex */
public final class RunnableC0821r implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f14082a;

    /* renamed from: b */
    public final /* synthetic */ long f14083b;

    /* renamed from: c */
    public final /* synthetic */ mb3 f14084c;

    public /* synthetic */ RunnableC0821r(mb3 mb3Var, long j, int i) {
        this.f14082a = i;
        this.f14083b = j;
        this.f14084c = mb3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j;
        switch (this.f14082a) {
            case 0:
                zzio zzioVar = ((zzlw) this.f14084c).zzu;
                zzhp zzhpVar = zzioVar.zzm().f27202k;
                long j2 = this.f14083b;
                zzhpVar.zzb(j2);
                zzioVar.zzaW().zzd().zzb("Session timeout duration set", Long.valueOf(j2));
                return;
            case 1:
                zzlw zzlwVar = (zzlw) this.f14084c;
                zzlwVar.zzg();
                zzlwVar.zza();
                zzio zzioVar2 = zzlwVar.zzu;
                zzioVar2.zzaW().zzd().zza("Resetting analytics data (FE)");
                zzio zzioVar3 = zzlwVar.zzu;
                zzop zzv = zzioVar3.zzv();
                zzv.zzg();
                C0814n0 c0814n0 = zzv.zzb;
                c0814n0.f14066c.m8015a();
                zzio zzioVar4 = c0814n0.f14067d.zzu;
                if (zzioVar4.zzf().zzx(null, zzgi.zzbb)) {
                    j = zzioVar4.zzaU().elapsedRealtime();
                    c0814n0.f14064a = j;
                } else {
                    c0814n0.f14064a = 0L;
                    j = 0;
                }
                c0814n0.f14065b = j;
                zzioVar3.zzh().m3528d();
                boolean z = !zzlwVar.zzu.zzJ();
                ub3 zzm = zzioVar2.zzm();
                zzm.f27197f.zzb(this.f14083b);
                zzio zzioVar5 = zzm.zzu;
                if (!TextUtils.isEmpty(zzioVar5.zzm().f27213v.zza())) {
                    zzm.f27213v.zzb(null);
                }
                zzm.f27207p.zzb(0L);
                zzm.f27208q.zzb(0L);
                if (!zzioVar5.zzf().zzA()) {
                    zzm.m7695e(z);
                }
                zzm.f27214w.zzb(null);
                zzm.f27215x.zzb(0L);
                zzm.f27216y.zzb(null);
                zzioVar3.zzu().zzO();
                zzioVar3.zzv().zza.m3498a();
                zzlwVar.zzc = z;
                zzioVar3.zzu().zzE(new AtomicReference());
                return;
            default:
                zzmo zzmoVar = (zzmo) this.f14084c;
                zzmoVar.zzu.zzd().zzf(this.f14083b);
                zzmoVar.zza = null;
                return;
        }
    }
}
