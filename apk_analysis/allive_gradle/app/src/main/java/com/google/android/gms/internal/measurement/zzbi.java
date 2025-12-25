package com.google.android.gms.internal.measurement;

import java.util.List;
import p000.ye0;

/* loaded from: classes.dex */
public final class zzbi extends zzaw {
    public zzbi() {
        this.f13786a.add(zzbl.ADD);
        this.f13786a.add(zzbl.DIVIDE);
        this.f13786a.add(zzbl.MODULUS);
        this.f13786a.add(zzbl.MULTIPLY);
        this.f13786a.add(zzbl.NEGATE);
        this.f13786a.add(zzbl.POST_DECREMENT);
        this.f13786a.add(zzbl.POST_INCREMENT);
        this.f13786a.add(zzbl.PRE_DECREMENT);
        this.f13786a.add(zzbl.PRE_INCREMENT);
        this.f13786a.add(zzbl.SUBTRACT);
    }

    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, List list) {
        zzbl zzblVar = zzbl.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 0) {
            if (ordinal != 21) {
                if (ordinal != 59) {
                    if (ordinal != 52 && ordinal != 53) {
                        if (ordinal != 55 && ordinal != 56) {
                            switch (ordinal) {
                                case 44:
                                    return new zzah(Double.valueOf(zzgVar.zzb((zzap) ye0.m8288h(zzbl.MODULUS, 2, list, 0)).zzh().doubleValue() % zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()));
                                case 45:
                                    return new zzah(Double.valueOf(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue() * zzgVar.zzb((zzap) ye0.m8288h(zzbl.MULTIPLY, 2, list, 0)).zzh().doubleValue()));
                                case 46:
                                    return new zzah(Double.valueOf(-zzgVar.zzb((zzap) ye0.m8288h(zzbl.NEGATE, 1, list, 0)).zzh().doubleValue()));
                                default:
                                    m3283a(str);
                                    throw null;
                            }
                        }
                        zzh.zzh(str, 1, list);
                        return zzgVar.zzb((zzap) list.get(0));
                    }
                    zzh.zzh(str, 2, list);
                    zzap zzb = zzgVar.zzb((zzap) list.get(0));
                    zzgVar.zzb((zzap) list.get(1));
                    return zzb;
                }
                zzap zzb2 = zzgVar.zzb((zzap) ye0.m8288h(zzbl.SUBTRACT, 2, list, 0));
                zzah zzahVar = new zzah(Double.valueOf(-zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()));
                return new zzah(Double.valueOf(zzahVar.zzh().doubleValue() + zzb2.zzh().doubleValue()));
            }
            return new zzah(Double.valueOf(zzgVar.zzb((zzap) ye0.m8288h(zzbl.DIVIDE, 2, list, 0)).zzh().doubleValue() / zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()));
        }
        zzap zzb3 = zzgVar.zzb((zzap) ye0.m8288h(zzbl.ADD, 2, list, 0));
        zzap zzb4 = zzgVar.zzb((zzap) list.get(1));
        if (!(zzb3 instanceof zzal) && !(zzb3 instanceof zzat) && !(zzb4 instanceof zzal) && !(zzb4 instanceof zzat)) {
            return new zzah(Double.valueOf(zzb4.zzh().doubleValue() + zzb3.zzh().doubleValue()));
        }
        return new zzat(String.valueOf(zzb3.zzi()).concat(String.valueOf(zzb4.zzi())));
    }
}
