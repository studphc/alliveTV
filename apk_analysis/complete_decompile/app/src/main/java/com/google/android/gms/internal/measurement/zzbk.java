package com.google.android.gms.internal.measurement;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Iterator;
import java.util.List;
import p000.AbstractC1726qj;
import p000.ye0;

/* loaded from: classes.dex */
public final class zzbk extends zzaw {
    public zzbk() {
        this.f13786a.add(zzbl.ASSIGN);
        this.f13786a.add(zzbl.CONST);
        this.f13786a.add(zzbl.CREATE_ARRAY);
        this.f13786a.add(zzbl.CREATE_OBJECT);
        this.f13786a.add(zzbl.EXPRESSION_LIST);
        this.f13786a.add(zzbl.GET);
        this.f13786a.add(zzbl.GET_INDEX);
        this.f13786a.add(zzbl.GET_PROPERTY);
        this.f13786a.add(zzbl.NULL);
        this.f13786a.add(zzbl.SET_PROPERTY);
        this.f13786a.add(zzbl.TYPEOF);
        this.f13786a.add(zzbl.UNDEFINED);
        this.f13786a.add(zzbl.VAR);
    }

    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, List list) {
        zzap zzb;
        String str2;
        int i = 0;
        zzbl zzblVar = zzbl.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 3) {
            if (ordinal != 14) {
                if (ordinal != 24) {
                    if (ordinal != 33) {
                        if (ordinal != 49) {
                            if (ordinal != 58) {
                                if (ordinal != 17) {
                                    if (ordinal != 18) {
                                        if (ordinal != 35 && ordinal != 36) {
                                            switch (ordinal) {
                                                case 62:
                                                    zzap zzb2 = zzgVar.zzb((zzap) ye0.m8288h(zzbl.TYPEOF, 1, list, 0));
                                                    if (zzb2 instanceof zzau) {
                                                        str2 = "undefined";
                                                    } else if (zzb2 instanceof zzaf) {
                                                        str2 = TypedValues.Custom.S_BOOLEAN;
                                                    } else if (zzb2 instanceof zzah) {
                                                        str2 = "number";
                                                    } else if (zzb2 instanceof zzat) {
                                                        str2 = TypedValues.Custom.S_STRING;
                                                    } else if (zzb2 instanceof zzao) {
                                                        str2 = "function";
                                                    } else if (!(zzb2 instanceof zzaq) && !(zzb2 instanceof zzag)) {
                                                        str2 = "object";
                                                    } else {
                                                        throw new IllegalArgumentException(String.format("Unsupported value type %s in typeof", zzb2));
                                                    }
                                                    return new zzat(str2);
                                                case 63:
                                                    zzh.zzh(zzbl.UNDEFINED.name(), 0, list);
                                                    return zzap.zzf;
                                                case 64:
                                                    zzh.zzi(zzbl.VAR.name(), 1, list);
                                                    Iterator it = list.iterator();
                                                    while (it.hasNext()) {
                                                        zzap zzb3 = zzgVar.zzb((zzap) it.next());
                                                        if (zzb3 instanceof zzat) {
                                                            zzgVar.zze(zzb3.zzi(), zzap.zzf);
                                                        } else {
                                                            throw new IllegalArgumentException(AbstractC1726qj.m7038C("Expected string for var name. got ", zzb3.getClass().getCanonicalName()));
                                                        }
                                                    }
                                                    return zzap.zzf;
                                                default:
                                                    m3283a(str);
                                                    throw null;
                                            }
                                        }
                                        zzap zzb4 = zzgVar.zzb((zzap) ye0.m8288h(zzbl.GET_PROPERTY, 2, list, 0));
                                        zzap zzb5 = zzgVar.zzb((zzap) list.get(1));
                                        if ((zzb4 instanceof zzae) && zzh.zzk(zzb5)) {
                                            return ((zzae) zzb4).zze(zzb5.zzh().intValue());
                                        }
                                        if (zzb4 instanceof zzal) {
                                            return ((zzal) zzb4).zzf(zzb5.zzi());
                                        }
                                        if (zzb4 instanceof zzat) {
                                            if ("length".equals(zzb5.zzi())) {
                                                zzb = new zzah(Double.valueOf(zzb4.zzi().length()));
                                            } else if (zzh.zzk(zzb5) && zzb5.zzh().doubleValue() < zzb4.zzi().length()) {
                                                return new zzat(String.valueOf(zzb4.zzi().charAt(zzb5.zzh().intValue())));
                                            }
                                        }
                                        return zzap.zzf;
                                    }
                                    if (list.isEmpty()) {
                                        return new zzam();
                                    }
                                    if (list.size() % 2 == 0) {
                                        zzam zzamVar = new zzam();
                                        while (i < list.size() - 1) {
                                            zzap zzb6 = zzgVar.zzb((zzap) list.get(i));
                                            zzap zzb7 = zzgVar.zzb((zzap) list.get(i + 1));
                                            if (!(zzb6 instanceof zzag) && !(zzb7 instanceof zzag)) {
                                                zzamVar.zzr(zzb6.zzi(), zzb7);
                                                i += 2;
                                            } else {
                                                throw new IllegalStateException("Failed to evaluate map entry");
                                            }
                                        }
                                        return zzamVar;
                                    }
                                    throw new IllegalArgumentException(ye0.m8291k(list.size(), "CREATE_OBJECT requires an even number of arguments, found "));
                                }
                                if (list.isEmpty()) {
                                    return new zzae();
                                }
                                zzae zzaeVar = new zzae();
                                Iterator it2 = list.iterator();
                                while (it2.hasNext()) {
                                    zzap zzb8 = zzgVar.zzb((zzap) it2.next());
                                    if (!(zzb8 instanceof zzag)) {
                                        zzaeVar.zzq(i, zzb8);
                                        i++;
                                    } else {
                                        throw new IllegalStateException("Failed to evaluate array element");
                                    }
                                }
                                return zzaeVar;
                            }
                            zzap zzb9 = zzgVar.zzb((zzap) ye0.m8288h(zzbl.SET_PROPERTY, 3, list, 0));
                            zzap zzb10 = zzgVar.zzb((zzap) list.get(1));
                            zzb = zzgVar.zzb((zzap) list.get(2));
                            if (zzb9 != zzap.zzf && zzb9 != zzap.zzg) {
                                if ((zzb9 instanceof zzae) && (zzb10 instanceof zzah)) {
                                    ((zzae) zzb9).zzq(zzb10.zzh().intValue(), zzb);
                                } else if (zzb9 instanceof zzal) {
                                    ((zzal) zzb9).zzr(zzb10.zzi(), zzb);
                                    return zzb;
                                }
                            } else {
                                throw new IllegalStateException("Can't set property " + zzb10.zzi() + " of " + zzb9.zzi());
                            }
                            return zzb;
                        }
                        zzh.zzh(zzbl.NULL.name(), 0, list);
                        return zzap.zzg;
                    }
                    zzap zzb11 = zzgVar.zzb((zzap) ye0.m8288h(zzbl.GET, 1, list, 0));
                    if (zzb11 instanceof zzat) {
                        return zzgVar.zzd(zzb11.zzi());
                    }
                    throw new IllegalArgumentException(AbstractC1726qj.m7038C("Expected string for get var. got ", zzb11.getClass().getCanonicalName()));
                }
                zzh.zzi(zzbl.EXPRESSION_LIST.name(), 1, list);
                zzap zzapVar = zzap.zzf;
                while (i < list.size()) {
                    zzapVar = zzgVar.zzb((zzap) list.get(i));
                    if (!(zzapVar instanceof zzag)) {
                        i++;
                    } else {
                        throw new IllegalStateException("ControlValue cannot be in an expression list");
                    }
                }
                return zzapVar;
            }
            zzh.zzi(zzbl.CONST.name(), 2, list);
            if (list.size() % 2 == 0) {
                while (i < list.size() - 1) {
                    zzap zzb12 = zzgVar.zzb((zzap) list.get(i));
                    if (zzb12 instanceof zzat) {
                        zzgVar.zzf(zzb12.zzi(), zzgVar.zzb((zzap) list.get(i + 1)));
                        i += 2;
                    } else {
                        throw new IllegalArgumentException(AbstractC1726qj.m7038C("Expected string for const name. got ", zzb12.getClass().getCanonicalName()));
                    }
                }
                return zzap.zzf;
            }
            throw new IllegalArgumentException(ye0.m8291k(list.size(), "CONST requires an even number of arguments, found "));
        }
        zzap zzb13 = zzgVar.zzb((zzap) ye0.m8288h(zzbl.ASSIGN, 2, list, 0));
        if (zzb13 instanceof zzat) {
            if (zzgVar.zzh(zzb13.zzi())) {
                zzap zzb14 = zzgVar.zzb((zzap) list.get(1));
                zzgVar.zzg(zzb13.zzi(), zzb14);
                return zzb14;
            }
            throw new IllegalArgumentException(AbstractC1726qj.m7038C("Attempting to assign undefined value ", zzb13.zzi()));
        }
        throw new IllegalArgumentException(AbstractC1726qj.m7038C("Expected string for assign var. got ", zzb13.getClass().getCanonicalName()));
    }
}
