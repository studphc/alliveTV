package com.google.android.gms.measurement.internal;

import p000.he3;

/* renamed from: com.google.android.gms.measurement.internal.l0 */
/* loaded from: classes.dex */
public final class RunnableC0810l0 implements Runnable {

    /* renamed from: a */
    public final long f14057a;

    /* renamed from: b */
    public final long f14058b;

    /* renamed from: c */
    public final /* synthetic */ he3 f14059c;

    public RunnableC0810l0(he3 he3Var, long j, long j2) {
        this.f14059c = he3Var;
        this.f14057a = j;
        this.f14058b = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f14059c.f18044b.zzu.zzaX().zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzoj
            @Override // java.lang.Runnable
            public final void run() {
                long zzk;
                RunnableC0810l0 runnableC0810l0 = RunnableC0810l0.this;
                zzop zzopVar = runnableC0810l0.f14059c.f18044b;
                zzopVar.zzg();
                zzio zzioVar = zzopVar.zzu;
                zzioVar.zzaW().zzd().zza("Application going to the background");
                zzioVar.zzm().f27210s.zza(true);
                zzopVar.zzg();
                zzopVar.f14348c = true;
                if (!zzioVar.zzf().zzz()) {
                    C0814n0 c0814n0 = zzopVar.zzb;
                    c0814n0.m3497a(runnableC0810l0.f14058b, false, false);
                    c0814n0.f14066c.m8015a();
                }
                zzioVar.zzaW().zzi().zzb("Application backgrounded at: timestamp_millis", Long.valueOf(runnableC0810l0.f14057a));
                zzio zzioVar2 = zzopVar.zzu;
                zzlw zzq = zzioVar2.zzq();
                zzq.zzg();
                zzio zzioVar3 = zzq.zzu;
                zzq.zza();
                zzny zzu = zzioVar3.zzu();
                zzu.zzg();
                zzu.zza();
                if (!zzu.m3586d() || zzu.zzu.zzw().zzm() >= 242600) {
                    zzioVar3.zzu().zzz();
                }
                if (zzioVar.zzf().zzx(null, zzgi.zzaS)) {
                    if (zzioVar.zzw().m3712B(zzioVar.zzaT().getPackageName(), zzioVar.zzf().zzs())) {
                        zzk = 1000;
                    } else {
                        zzk = zzioVar.zzf().zzk(zzioVar.zzaT().getPackageName(), zzgi.zzD);
                    }
                    zzioVar.zzaW().zzj().zzb("[sgtm] Scheduling batch upload with minimum latency in millis", Long.valueOf(zzk));
                    zzioVar2.zzs().zzj(zzk);
                }
            }
        });
    }
}
