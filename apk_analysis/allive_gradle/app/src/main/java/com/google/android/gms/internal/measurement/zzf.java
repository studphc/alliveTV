package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzf {

    /* renamed from: a */
    public final zzax f13809a;

    /* renamed from: b */
    public final zzg f13810b;

    /* renamed from: c */
    public final zzg f13811c;

    /* renamed from: d */
    public final zzj f13812d;

    public zzf() {
        zzax zzaxVar = new zzax();
        this.f13809a = zzaxVar;
        zzg zzgVar = new zzg(null, zzaxVar);
        this.f13811c = zzgVar;
        this.f13810b = zzgVar.zza();
        zzj zzjVar = new zzj();
        this.f13812d = zzjVar;
        zzgVar.zzg("require", new zzw(zzjVar));
        zzjVar.zza("internal.platform", new Callable() { // from class: com.google.android.gms.internal.measurement.zze
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzy();
            }
        });
        zzgVar.zzg("runtime.counter", new zzah(Double.valueOf(0.0d)));
    }

    public final zzap zza(zzg zzgVar, zziz... zzizVarArr) {
        zzap zzapVar = zzap.zzf;
        for (zziz zzizVar : zzizVarArr) {
            zzapVar = zzi.zza(zzizVar);
            zzh.zzc(this.f13811c);
            if ((zzapVar instanceof zzaq) || (zzapVar instanceof zzao)) {
                zzapVar = this.f13809a.zza(zzgVar, zzapVar);
            }
        }
        return zzapVar;
    }
}
