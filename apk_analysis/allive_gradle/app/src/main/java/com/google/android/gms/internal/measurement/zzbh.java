package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import p000.ea3;
import p000.ye0;

/* loaded from: classes.dex */
public final class zzbh extends zzaw {
    public zzbh() {
        this.f13786a.add(zzbl.FOR_IN);
        this.f13786a.add(zzbl.FOR_IN_CONST);
        this.f13786a.add(zzbl.FOR_IN_LET);
        this.f13786a.add(zzbl.FOR_LET);
        this.f13786a.add(zzbl.FOR_OF);
        this.f13786a.add(zzbl.FOR_OF_CONST);
        this.f13786a.add(zzbl.FOR_OF_LET);
        this.f13786a.add(zzbl.WHILE);
    }

    /* renamed from: b */
    public static zzap m3291b(ea3 ea3Var, zzap zzapVar, zzap zzapVar2) {
        zzg zza;
        if (zzapVar instanceof Iterable) {
            Iterator it = ((Iterable) zzapVar).iterator();
            if (it != null) {
                while (it.hasNext()) {
                    zzap zzapVar3 = (zzap) it.next();
                    switch (ea3Var.f16742a) {
                        case 0:
                            zza = ea3Var.f16743b.zza();
                            zza.zzf(ea3Var.f16744c, zzapVar3);
                            break;
                        case 1:
                            zza = ea3Var.f16743b.zza();
                            zza.zze(ea3Var.f16744c, zzapVar3);
                            break;
                        default:
                            String str = ea3Var.f16744c;
                            zza = ea3Var.f16743b;
                            zza.zze(str, zzapVar3);
                            break;
                    }
                    zzap zzc = zza.zzc((zzae) zzapVar2);
                    if (zzc instanceof zzag) {
                        zzag zzagVar = (zzag) zzc;
                        if ("break".equals(zzagVar.zzc())) {
                            return zzap.zzf;
                        }
                        if ("return".equals(zzagVar.zzc())) {
                            return zzagVar;
                        }
                    }
                }
            }
            return zzap.zzf;
        }
        throw new IllegalArgumentException("Non-iterable type in for...of loop.");
    }

    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, List list) {
        zzbl zzblVar = zzbl.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 65) {
            switch (ordinal) {
                case 26:
                    if (ye0.m8288h(zzbl.FOR_IN, 3, list, 0) instanceof zzat) {
                        String zzi = ((zzap) list.get(0)).zzi();
                        zzap zzb = zzgVar.zzb((zzap) list.get(1));
                        zzap zzb2 = zzgVar.zzb((zzap) list.get(2));
                        Iterator zzl = zzb.zzl();
                        if (zzl != null) {
                            while (zzl.hasNext()) {
                                zzgVar.zze(zzi, (zzap) zzl.next());
                                zzap zzc = zzgVar.zzc((zzae) zzb2);
                                if (zzc instanceof zzag) {
                                    zzag zzagVar = (zzag) zzc;
                                    if ("break".equals(zzagVar.zzc())) {
                                        return zzap.zzf;
                                    }
                                    if ("return".equals(zzagVar.zzc())) {
                                        return zzagVar;
                                    }
                                }
                            }
                        }
                        return zzap.zzf;
                    }
                    throw new IllegalArgumentException("Variable name in FOR_IN must be a string");
                case 27:
                    if (ye0.m8288h(zzbl.FOR_IN_CONST, 3, list, 0) instanceof zzat) {
                        String zzi2 = ((zzap) list.get(0)).zzi();
                        zzap zzb3 = zzgVar.zzb((zzap) list.get(1));
                        zzap zzb4 = zzgVar.zzb((zzap) list.get(2));
                        Iterator zzl2 = zzb3.zzl();
                        if (zzl2 != null) {
                            while (zzl2.hasNext()) {
                                zzap zzapVar = (zzap) zzl2.next();
                                zzg zza = zzgVar.zza();
                                zza.zzf(zzi2, zzapVar);
                                zzap zzc2 = zza.zzc((zzae) zzb4);
                                if (zzc2 instanceof zzag) {
                                    zzag zzagVar2 = (zzag) zzc2;
                                    if ("break".equals(zzagVar2.zzc())) {
                                        return zzap.zzf;
                                    }
                                    if ("return".equals(zzagVar2.zzc())) {
                                        return zzagVar2;
                                    }
                                }
                            }
                        }
                        return zzap.zzf;
                    }
                    throw new IllegalArgumentException("Variable name in FOR_IN_CONST must be a string");
                case 28:
                    if (ye0.m8288h(zzbl.FOR_IN_LET, 3, list, 0) instanceof zzat) {
                        String zzi3 = ((zzap) list.get(0)).zzi();
                        zzap zzb5 = zzgVar.zzb((zzap) list.get(1));
                        zzap zzb6 = zzgVar.zzb((zzap) list.get(2));
                        Iterator zzl3 = zzb5.zzl();
                        if (zzl3 != null) {
                            while (zzl3.hasNext()) {
                                zzap zzapVar2 = (zzap) zzl3.next();
                                zzg zza2 = zzgVar.zza();
                                zza2.zze(zzi3, zzapVar2);
                                zzap zzc3 = zza2.zzc((zzae) zzb6);
                                if (zzc3 instanceof zzag) {
                                    zzag zzagVar3 = (zzag) zzc3;
                                    if ("break".equals(zzagVar3.zzc())) {
                                        return zzap.zzf;
                                    }
                                    if ("return".equals(zzagVar3.zzc())) {
                                        return zzagVar3;
                                    }
                                }
                            }
                        }
                        return zzap.zzf;
                    }
                    throw new IllegalArgumentException("Variable name in FOR_IN_LET must be a string");
                case 29:
                    zzap zzb7 = zzgVar.zzb((zzap) ye0.m8288h(zzbl.FOR_LET, 4, list, 0));
                    if (zzb7 instanceof zzae) {
                        zzae zzaeVar = (zzae) zzb7;
                        zzap zzapVar3 = (zzap) list.get(1);
                        zzap zzapVar4 = (zzap) list.get(2);
                        zzap zzb8 = zzgVar.zzb((zzap) list.get(3));
                        zzg zza3 = zzgVar.zza();
                        for (int i = 0; i < zzaeVar.zzc(); i++) {
                            String zzi4 = zzaeVar.zze(i).zzi();
                            zza3.zzg(zzi4, zzgVar.zzd(zzi4));
                        }
                        while (zzgVar.zzb(zzapVar3).zzg().booleanValue()) {
                            zzap zzc4 = zzgVar.zzc((zzae) zzb8);
                            if (zzc4 instanceof zzag) {
                                zzag zzagVar4 = (zzag) zzc4;
                                if ("break".equals(zzagVar4.zzc())) {
                                    return zzap.zzf;
                                }
                                if ("return".equals(zzagVar4.zzc())) {
                                    return zzagVar4;
                                }
                            }
                            zzg zza4 = zzgVar.zza();
                            for (int i2 = 0; i2 < zzaeVar.zzc(); i2++) {
                                String zzi5 = zzaeVar.zze(i2).zzi();
                                zza4.zzg(zzi5, zza3.zzd(zzi5));
                            }
                            zza4.zzb(zzapVar4);
                            zza3 = zza4;
                        }
                        return zzap.zzf;
                    }
                    throw new IllegalArgumentException("Initializer variables in FOR_LET must be an ArrayList");
                case 30:
                    if (ye0.m8288h(zzbl.FOR_OF, 3, list, 0) instanceof zzat) {
                        return m3291b(new ea3(zzgVar, ((zzap) list.get(0)).zzi(), 2), zzgVar.zzb((zzap) list.get(1)), zzgVar.zzb((zzap) list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_OF must be a string");
                case 31:
                    if (ye0.m8288h(zzbl.FOR_OF_CONST, 3, list, 0) instanceof zzat) {
                        return m3291b(new ea3(zzgVar, ((zzap) list.get(0)).zzi(), 0), zzgVar.zzb((zzap) list.get(1)), zzgVar.zzb((zzap) list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_OF_CONST must be a string");
                case 32:
                    if (ye0.m8288h(zzbl.FOR_OF_LET, 3, list, 0) instanceof zzat) {
                        return m3291b(new ea3(zzgVar, ((zzap) list.get(0)).zzi(), 1), zzgVar.zzb((zzap) list.get(1)), zzgVar.zzb((zzap) list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_OF_LET must be a string");
                default:
                    m3283a(str);
                    throw null;
            }
        }
        zzap zzapVar5 = (zzap) ye0.m8288h(zzbl.WHILE, 4, list, 0);
        zzap zzapVar6 = (zzap) list.get(1);
        zzap zzapVar7 = (zzap) list.get(2);
        zzap zzb9 = zzgVar.zzb((zzap) list.get(3));
        if (zzgVar.zzb(zzapVar7).zzg().booleanValue()) {
            zzap zzc5 = zzgVar.zzc((zzae) zzb9);
            if (zzc5 instanceof zzag) {
                zzag zzagVar5 = (zzag) zzc5;
                if ("break".equals(zzagVar5.zzc())) {
                    return zzap.zzf;
                }
                if ("return".equals(zzagVar5.zzc())) {
                    return zzagVar5;
                }
            }
        }
        while (zzgVar.zzb(zzapVar5).zzg().booleanValue()) {
            zzap zzc6 = zzgVar.zzc((zzae) zzb9);
            if (zzc6 instanceof zzag) {
                zzag zzagVar6 = (zzag) zzc6;
                if ("break".equals(zzagVar6.zzc())) {
                    return zzap.zzf;
                }
                if ("return".equals(zzagVar6.zzc())) {
                    return zzagVar6;
                }
            }
            zzgVar.zzb(zzapVar6);
        }
        return zzap.zzf;
    }
}
