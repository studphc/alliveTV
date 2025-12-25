package com.google.android.gms.internal.measurement;

import java.util.List;
import p000.ye0;

/* loaded from: classes.dex */
public final class zzbc extends zzaw {
    public zzbc() {
        this.f13786a.add(zzbl.AND);
        this.f13786a.add(zzbl.NOT);
        this.f13786a.add(zzbl.OR);
    }

    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, List list) {
        zzbl zzblVar = zzbl.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 1) {
            if (ordinal != 47) {
                if (ordinal == 50) {
                    zzap zzb = zzgVar.zzb((zzap) ye0.m8288h(zzbl.OR, 2, list, 0));
                    if (zzb.zzg().booleanValue()) {
                        return zzb;
                    }
                    return zzgVar.zzb((zzap) list.get(1));
                }
                m3283a(str);
                throw null;
            }
            return new zzaf(Boolean.valueOf(!zzgVar.zzb((zzap) ye0.m8288h(zzbl.NOT, 1, list, 0)).zzg().booleanValue()));
        }
        zzap zzb2 = zzgVar.zzb((zzap) ye0.m8288h(zzbl.AND, 2, list, 0));
        if (!zzb2.zzg().booleanValue()) {
            return zzb2;
        }
        return zzgVar.zzb((zzap) list.get(1));
    }
}
