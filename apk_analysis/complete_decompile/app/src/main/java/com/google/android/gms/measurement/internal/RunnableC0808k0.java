package com.google.android.gms.measurement.internal;

import com.google.android.exoplayer2.ExoPlayer;
import p000.he3;

/* renamed from: com.google.android.gms.measurement.internal.k0 */
/* loaded from: classes.dex */
public final class RunnableC0808k0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f14051a;

    /* renamed from: b */
    public final /* synthetic */ long f14052b;

    /* renamed from: c */
    public final /* synthetic */ zzop f14053c;

    public /* synthetic */ RunnableC0808k0(zzop zzopVar, long j, int i) {
        this.f14051a = i;
        this.f14052b = j;
        this.f14053c = zzopVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f14051a) {
            case 0:
                zzop zzopVar = this.f14053c;
                zzopVar.zzg();
                zzopVar.m3594a();
                zzio zzioVar = zzopVar.zzu;
                zzhc zzj = zzioVar.zzaW().zzj();
                long j = this.f14052b;
                zzj.zzb("Activity resumed, time", Long.valueOf(j));
                if (zzioVar.zzf().zzx(null, zzgi.zzba)) {
                    if (zzioVar.zzf().zzz() || zzopVar.f14348c) {
                        C0814n0 c0814n0 = zzopVar.zzb;
                        c0814n0.f14067d.zzg();
                        c0814n0.f14066c.m8015a();
                        c0814n0.f14064a = j;
                        c0814n0.f14065b = j;
                    }
                } else if (zzioVar.zzf().zzz() || zzioVar.zzm().f27210s.zzb()) {
                    C0814n0 c0814n02 = zzopVar.zzb;
                    c0814n02.f14067d.zzg();
                    c0814n02.f14066c.m8015a();
                    c0814n02.f14064a = j;
                    c0814n02.f14065b = j;
                }
                he3 he3Var = zzopVar.zzc;
                zzop zzopVar2 = he3Var.f18044b;
                zzopVar2.zzg();
                RunnableC0810l0 runnableC0810l0 = he3Var.f18043a;
                if (runnableC0810l0 != null) {
                    zzopVar2.f14347b.removeCallbacks(runnableC0810l0);
                }
                zzio zzioVar2 = zzopVar2.zzu;
                zzioVar2.zzm().f27210s.zza(false);
                zzopVar2.zzg();
                zzopVar2.f14348c = false;
                if (zzioVar2.zzf().zzx(null, zzgi.zzaZ)) {
                    zzio zzioVar3 = zzopVar2.zzu;
                    if (zzioVar3.zzq().f14310l) {
                        zzioVar2.zzaW().zzj().zza("Retrying trigger URI registration in foreground");
                        zzioVar3.zzq().zzU();
                    }
                }
                C0816o0 c0816o0 = zzopVar.zza;
                zzop zzopVar3 = c0816o0.f14069a;
                zzopVar3.zzg();
                if (zzopVar3.zzu.zzJ()) {
                    c0816o0.m3499b(zzopVar3.zzu.zzaU().currentTimeMillis(), false);
                    return;
                }
                return;
            default:
                zzop zzopVar4 = this.f14053c;
                zzopVar4.zzg();
                zzopVar4.m3594a();
                zzio zzioVar4 = zzopVar4.zzu;
                zzhc zzj2 = zzioVar4.zzaW().zzj();
                long j2 = this.f14052b;
                zzj2.zzb("Activity paused, time", Long.valueOf(j2));
                he3 he3Var2 = zzopVar4.zzc;
                zzop zzopVar5 = he3Var2.f18044b;
                RunnableC0810l0 runnableC0810l02 = new RunnableC0810l0(he3Var2, zzopVar5.zzu.zzaU().currentTimeMillis(), j2);
                he3Var2.f18043a = runnableC0810l02;
                zzopVar5.f14347b.postDelayed(runnableC0810l02, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                if (zzioVar4.zzf().zzz()) {
                    zzopVar4.zzb.f14066c.m8015a();
                    return;
                }
                return;
        }
    }
}
