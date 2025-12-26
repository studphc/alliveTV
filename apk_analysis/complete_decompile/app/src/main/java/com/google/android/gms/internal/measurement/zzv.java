package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes.dex */
public final class zzv extends zzai {

    /* renamed from: a */
    public final zzz f13958a;

    public zzv(zzz zzzVar) {
        super("internal.registerCallback");
        this.f13958a = zzzVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzap zza(zzg zzgVar, List list) {
        int i;
        zzh.zzh(this.zzd, 3, list);
        String zzi = zzgVar.zzb((zzap) list.get(0)).zzi();
        zzap zzb = zzgVar.zzb((zzap) list.get(1));
        if (zzb instanceof zzao) {
            zzap zzb2 = zzgVar.zzb((zzap) list.get(2));
            if (zzb2 instanceof zzam) {
                zzam zzamVar = (zzam) zzb2;
                if (zzamVar.zzt("type")) {
                    String zzi2 = zzamVar.zzf("type").zzi();
                    if (zzamVar.zzt("priority")) {
                        i = zzh.zzb(zzamVar.zzf("priority").zzh().doubleValue());
                    } else {
                        i = 1000;
                    }
                    this.f13958a.zza(zzi, i, (zzao) zzb, zzi2);
                    return zzap.zzf;
                }
                throw new IllegalArgumentException("Undefined rule type");
            }
            throw new IllegalArgumentException("Invalid callback params");
        }
        throw new IllegalArgumentException("Invalid callback type");
    }
}
