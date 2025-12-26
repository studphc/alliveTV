package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.RemoteException;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;
import p000.AbstractC1726qj;
import p000.fc3;
import p000.hc3;
import p000.ub3;

/* renamed from: com.google.android.gms.measurement.internal.k */
/* loaded from: classes.dex */
public final class RunnableC0807k implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f14048a;

    /* renamed from: b */
    public final /* synthetic */ Object f14049b;

    /* renamed from: c */
    public final /* synthetic */ hc3 f14050c;

    public /* synthetic */ RunnableC0807k(int i, Object obj, hc3 hc3Var) {
        this.f14048a = i;
        this.f14049b = obj;
        this.f14050c = hc3Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0166 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.gms.measurement.internal.zzbb, fc3] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        long j;
        Long valueOf;
        switch (this.f14048a) {
            case 0:
                zzio zzioVar = (zzio) this.f14050c;
                zzil zzilVar = zzioVar.f14263j;
                zzio.m3555c(zzilVar);
                zzilVar.zzg();
                zzam zzamVar = zzioVar.f14260g;
                zzamVar.zzu.zzaV();
                ?? fc3Var = new fc3(zzioVar);
                fc3Var.zzw();
                zzioVar.f14275v = fc3Var;
                zzke zzkeVar = (zzke) this.f14049b;
                com.google.android.gms.internal.measurement.zzdh zzdhVar = zzkeVar.f14296g;
                if (zzdhVar == null) {
                    j = 0;
                } else {
                    j = zzdhVar.zza;
                }
                zzgs zzgsVar = new zzgs(zzioVar, zzkeVar.f14295f, j);
                zzgsVar.zzb();
                zzioVar.f14276w = zzgsVar;
                zzgv zzgvVar = new zzgv(zzioVar);
                zzgvVar.zzb();
                zzioVar.f14273t = zzgvVar;
                zzny zznyVar = new zzny(zzioVar);
                zznyVar.zzb();
                zzioVar.f14274u = zznyVar;
                zzqf zzqfVar = zzioVar.f14265l;
                zzqfVar.zzx();
                zzioVar.f14261h.zzx();
                zzioVar.f14276w.zzc();
                zzmd zzmdVar = new zzmd(zzioVar);
                zzmdVar.zzb();
                zzioVar.f14277x = zzmdVar;
                zzmdVar.zzc();
                zzhe zzheVar = zzioVar.f14262i;
                zzio.m3555c(zzheVar);
                zzhc zzi = zzheVar.zzi();
                zzamVar.zzj();
                zzi.zzb("App measurement initialized, version", 119002L);
                zzio.m3555c(zzheVar);
                zzheVar.zzi().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
                String m3527c = zzgsVar.m3527c();
                if (TextUtils.isEmpty(zzioVar.f14255b)) {
                    if (zzqfVar.m3712B(m3527c, zzamVar.zzs())) {
                        zzio.m3555c(zzheVar);
                        zzheVar.zzi().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
                    } else {
                        zzio.m3555c(zzheVar);
                        zzheVar.zzi().zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(m3527c)));
                    }
                }
                zzio.m3555c(zzheVar);
                zzheVar.zzd().zza("Debug-level message logging enabled");
                int i = zzioVar.f14250D;
                AtomicInteger atomicInteger = zzioVar.f14252F;
                if (i != atomicInteger.get()) {
                    zzio.m3555c(zzheVar);
                    zzheVar.zze().zzc("Not all components initialized", Integer.valueOf(zzioVar.f14250D), Integer.valueOf(atomicInteger.get()));
                }
                zzioVar.f14278y = true;
                zzioVar.zzH(zzkeVar.f14296g);
                return;
            case 1:
                zzlw zzlwVar = (zzlw) this.f14050c;
                zzio zzioVar2 = zzlwVar.zzu.zzv().zzu;
                if (!zzioVar2.zzm().m7694d().zzr(zzjw.ANALYTICS_STORAGE)) {
                    zzioVar2.zzaW().zzl().zza("Analytics storage consent denied; will not get session id");
                } else if (!zzioVar2.zzm().m7696f(zzioVar2.zzaU().currentTimeMillis()) && zzioVar2.zzm().f27208q.zza() != 0) {
                    valueOf = Long.valueOf(zzioVar2.zzm().f27208q.zza());
                    com.google.android.gms.internal.measurement.zzcy zzcyVar = (com.google.android.gms.internal.measurement.zzcy) this.f14049b;
                    if (valueOf == null) {
                        zzlwVar.zzu.zzw().zzY(zzcyVar, valueOf.longValue());
                        return;
                    }
                    try {
                        zzcyVar.zze(null);
                        return;
                    } catch (RemoteException e) {
                        zzlwVar.zzu.zzaW().zze().zzb("getSessionId failed with exception", e);
                        return;
                    }
                }
                valueOf = null;
                com.google.android.gms.internal.measurement.zzcy zzcyVar2 = (com.google.android.gms.internal.measurement.zzcy) this.f14049b;
                if (valueOf == null) {
                }
                break;
            case 2:
                zzlw zzlwVar2 = (zzlw) this.f14050c;
                zzio zzioVar3 = zzlwVar2.zzu;
                ub3 zzm = zzioVar3.zzm();
                zzio zzioVar4 = zzm.zzu;
                zzm.zzg();
                zzm.zzg();
                zzba zze = zzba.zze(zzm.m7692b().getString("dma_consent_settings", null));
                zzba zzbaVar = (zzba) this.f14049b;
                if (zzjx.zzs(zzbaVar.zza(), zze.zza())) {
                    SharedPreferences.Editor edit = zzm.m7692b().edit();
                    edit.putString("dma_consent_settings", zzbaVar.zzj());
                    edit.apply();
                    zzioVar3.zzaW().zzj().zzb("Setting DMA consent(FE)", zzbaVar);
                    zzio zzioVar5 = zzlwVar2.zzu;
                    zzny zzu = zzioVar5.zzu();
                    zzu.zzg();
                    zzu.zza();
                    if (zzu.m3586d() && zzu.zzu.zzw().zzm() < 241200) {
                        zzioVar5.zzu().zzR(false);
                        return;
                    } else {
                        zzioVar5.zzu().zzU();
                        return;
                    }
                }
                zzioVar3.zzaW().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzbaVar.zza()));
                return;
            default:
                zzny zznyVar2 = (zzny) this.f14050c;
                zzgl zzglVar = zznyVar2.f14338c;
                if (zzglVar == null) {
                    AbstractC1726qj.m7039D(zznyVar2.zzu, "Failed to send current screen to service");
                    return;
                }
                try {
                    zzmh zzmhVar = (zzmh) this.f14049b;
                    if (zzmhVar == null) {
                        zzglVar.zzw(0L, null, null, zznyVar2.zzu.zzaT().getPackageName());
                    } else {
                        zzglVar.zzw(zzmhVar.zzc, zzmhVar.zza, zzmhVar.zzb, zznyVar2.zzu.zzaT().getPackageName());
                    }
                    zznyVar2.m3589g();
                    return;
                } catch (RemoteException e2) {
                    zznyVar2.zzu.zzaW().zze().zzb("Failed to send current screen to the service", e2);
                    return;
                }
        }
    }
}
