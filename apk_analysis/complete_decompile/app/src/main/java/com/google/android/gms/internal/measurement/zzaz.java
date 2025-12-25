package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;
import p000.AbstractC1726qj;
import p000.ye0;

/* loaded from: classes.dex */
public final class zzaz extends zzaw {
    public zzaz() {
        this.f13786a.add(zzbl.APPLY);
        this.f13786a.add(zzbl.BLOCK);
        this.f13786a.add(zzbl.BREAK);
        this.f13786a.add(zzbl.CASE);
        this.f13786a.add(zzbl.DEFAULT);
        this.f13786a.add(zzbl.CONTINUE);
        this.f13786a.add(zzbl.DEFINE_FUNCTION);
        this.f13786a.add(zzbl.FN);
        this.f13786a.add(zzbl.IF);
        this.f13786a.add(zzbl.QUOTE);
        this.f13786a.add(zzbl.RETURN);
        this.f13786a.add(zzbl.SWITCH);
        this.f13786a.add(zzbl.TERNARY);
    }

    /* renamed from: b */
    public static zzao m3288b(zzg zzgVar, List list) {
        zzh.zzi(zzbl.FN.name(), 2, list);
        zzap zzb = zzgVar.zzb((zzap) list.get(0));
        zzap zzb2 = zzgVar.zzb((zzap) list.get(1));
        if (zzb2 instanceof zzae) {
            List zzm = ((zzae) zzb2).zzm();
            List arrayList = new ArrayList();
            if (list.size() > 2) {
                arrayList = list.subList(2, list.size());
            }
            return new zzao(zzb.zzi(), zzm, arrayList, zzgVar);
        }
        throw new IllegalArgumentException(AbstractC1726qj.m7038C("FN requires an ArrayValue of parameter names found ", zzb2.getClass().getCanonicalName()));
    }

    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, List list) {
        zzap zzapVar;
        zzbl zzblVar = zzbl.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 2) {
            if (ordinal != 15) {
                if (ordinal != 25) {
                    zzap zzapVar2 = null;
                    if (ordinal != 41) {
                        if (ordinal != 54) {
                            if (ordinal != 57) {
                                if (ordinal != 19) {
                                    if (ordinal != 20) {
                                        if (ordinal != 60) {
                                            if (ordinal != 61) {
                                                switch (ordinal) {
                                                    case 11:
                                                        return zzgVar.zza().zzc(new zzae(list));
                                                    case 12:
                                                        zzh.zzh(zzbl.BREAK.name(), 0, list);
                                                        return zzap.zzi;
                                                    case 13:
                                                        break;
                                                    default:
                                                        m3283a(str);
                                                        throw null;
                                                }
                                            } else {
                                                if (zzgVar.zzb((zzap) ye0.m8288h(zzbl.TERNARY, 3, list, 0)).zzg().booleanValue()) {
                                                    return zzgVar.zzb((zzap) list.get(1));
                                                }
                                                return zzgVar.zzb((zzap) list.get(2));
                                            }
                                        } else {
                                            zzap zzb = zzgVar.zzb((zzap) ye0.m8288h(zzbl.SWITCH, 3, list, 0));
                                            zzap zzb2 = zzgVar.zzb((zzap) list.get(1));
                                            zzap zzb3 = zzgVar.zzb((zzap) list.get(2));
                                            if (zzb2 instanceof zzae) {
                                                if (zzb3 instanceof zzae) {
                                                    zzae zzaeVar = (zzae) zzb2;
                                                    zzae zzaeVar2 = (zzae) zzb3;
                                                    int i = 0;
                                                    boolean z = false;
                                                    while (true) {
                                                        if (i < zzaeVar.zzc()) {
                                                            if (!z && !zzb.equals(zzgVar.zzb(zzaeVar.zze(i)))) {
                                                                z = false;
                                                            } else {
                                                                zzap zzb4 = zzgVar.zzb(zzaeVar2.zze(i));
                                                                if (zzb4 instanceof zzag) {
                                                                    if (!((zzag) zzb4).zzc().equals("break")) {
                                                                        return zzb4;
                                                                    }
                                                                } else {
                                                                    z = true;
                                                                }
                                                            }
                                                            i++;
                                                        } else if (zzaeVar.zzc() + 1 == zzaeVar2.zzc()) {
                                                            zzap zzb5 = zzgVar.zzb(zzaeVar2.zze(zzaeVar.zzc()));
                                                            if (zzb5 instanceof zzag) {
                                                                String zzc = ((zzag) zzb5).zzc();
                                                                if (zzc.equals("return") || zzc.equals("continue")) {
                                                                    return zzb5;
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    throw new IllegalArgumentException("Malformed SWITCH statement, case statements are not a list");
                                                }
                                            } else {
                                                throw new IllegalArgumentException("Malformed SWITCH statement, cases are not a list");
                                            }
                                        }
                                    } else {
                                        zzh.zzi(zzbl.DEFINE_FUNCTION.name(), 2, list);
                                        zzao m3288b = m3288b(zzgVar, list);
                                        if (m3288b.zzc() == null) {
                                            zzgVar.zzg("", m3288b);
                                            return m3288b;
                                        }
                                        zzgVar.zzg(m3288b.zzc(), m3288b);
                                        return m3288b;
                                    }
                                }
                                if (list.isEmpty()) {
                                    return zzap.zzf;
                                }
                                zzap zzb6 = zzgVar.zzb((zzap) list.get(0));
                                if (zzb6 instanceof zzae) {
                                    return zzgVar.zzc((zzae) zzb6);
                                }
                                return zzap.zzf;
                            }
                            if (list.isEmpty()) {
                                return zzap.zzj;
                            }
                            return new zzag("return", zzgVar.zzb((zzap) ye0.m8288h(zzbl.RETURN, 1, list, 0)));
                        }
                        return new zzae(list);
                    }
                    zzh.zzi(zzbl.IF.name(), 2, list);
                    zzap zzb7 = zzgVar.zzb((zzap) list.get(0));
                    zzap zzb8 = zzgVar.zzb((zzap) list.get(1));
                    if (list.size() > 2) {
                        zzapVar2 = zzgVar.zzb((zzap) list.get(2));
                    }
                    zzap zzapVar3 = zzap.zzf;
                    if (zzb7.zzg().booleanValue()) {
                        zzapVar = zzgVar.zzc((zzae) zzb8);
                    } else if (zzapVar2 != null) {
                        zzapVar = zzgVar.zzc((zzae) zzapVar2);
                    } else {
                        zzapVar = zzapVar3;
                    }
                    if (zzapVar instanceof zzag) {
                        return zzapVar;
                    }
                    return zzap.zzf;
                }
                return m3288b(zzgVar, list);
            }
            zzh.zzh(zzbl.BREAK.name(), 0, list);
            return zzap.zzh;
        }
        zzap zzb9 = zzgVar.zzb((zzap) ye0.m8288h(zzbl.APPLY, 3, list, 0));
        String zzi = zzgVar.zzb((zzap) list.get(1)).zzi();
        zzap zzb10 = zzgVar.zzb((zzap) list.get(2));
        if (zzb10 instanceof zzae) {
            if (!zzi.isEmpty()) {
                return zzb9.zzcz(zzi, zzgVar, ((zzae) zzb10).zzm());
            }
            throw new IllegalArgumentException("Function name for apply is undefined");
        }
        throw new IllegalArgumentException(AbstractC1726qj.m7038C("Function arguments for Apply are not a list found ", zzb10.getClass().getCanonicalName()));
    }
}
