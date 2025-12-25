package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p000.cs2;

/* loaded from: classes.dex */
public final class zzbb {
    /* renamed from: a */
    public static zzae m3289a(zzae zzaeVar, zzg zzgVar, zzao zzaoVar, Boolean bool, Boolean bool2) {
        zzae zzaeVar2 = new zzae();
        Iterator zzk = zzaeVar.zzk();
        while (zzk.hasNext()) {
            int intValue = ((Integer) zzk.next()).intValue();
            if (zzaeVar.zzs(intValue)) {
                zzap zza = zzaoVar.zza(zzgVar, Arrays.asList(zzaeVar.zze(intValue), new zzah(Double.valueOf(intValue)), zzaeVar));
                if (zza.zzg().equals(bool)) {
                    break;
                }
                if (bool2 == null || zza.zzg().equals(bool2)) {
                    zzaeVar2.zzq(intValue, zza);
                }
            }
        }
        return zzaeVar2;
    }

    /* renamed from: b */
    public static zzap m3290b(zzae zzaeVar, zzg zzgVar, List list, boolean z) {
        zzap zzapVar;
        int i;
        int i2;
        int i3 = -1;
        zzh.zzi("reduce", 1, list);
        zzh.zzj("reduce", 2, list);
        zzap zzb = zzgVar.zzb((zzap) list.get(0));
        if (zzb instanceof zzai) {
            if (list.size() == 2) {
                zzapVar = zzgVar.zzb((zzap) list.get(1));
                if (zzapVar instanceof zzag) {
                    throw new IllegalArgumentException("Failed to parse initial value");
                }
            } else if (zzaeVar.zzc() != 0) {
                zzapVar = null;
            } else {
                throw new IllegalStateException("Empty array with no initial value error");
            }
            zzai zzaiVar = (zzai) zzb;
            int zzc = zzaeVar.zzc();
            if (z) {
                i = 0;
            } else {
                i = zzc - 1;
            }
            if (z) {
                i2 = zzc - 1;
            } else {
                i2 = 0;
            }
            if (true == z) {
                i3 = 1;
            }
            if (zzapVar == null) {
                zzapVar = zzaeVar.zze(i);
                i += i3;
            }
            while ((i2 - i) * i3 >= 0) {
                if (!zzaeVar.zzs(i)) {
                    i += i3;
                } else {
                    zzapVar = zzaiVar.zza(zzgVar, Arrays.asList(zzapVar, zzaeVar.zze(i), new zzah(Double.valueOf(i)), zzaeVar));
                    if (!(zzapVar instanceof zzag)) {
                        i += i3;
                    } else {
                        throw new IllegalStateException("Reduce operation failed");
                    }
                }
            }
            return zzapVar;
        }
        throw new IllegalArgumentException("Callback should be a method");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x010a. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39, types: [com.google.android.gms.internal.measurement.zzap] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.gms.internal.measurement.zzae] */
    /* JADX WARN: Type inference failed for: r23v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.google.android.gms.internal.measurement.zzae] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v31, types: [com.google.android.gms.internal.measurement.zzah] */
    public static zzap zza(String str, zzae zzaeVar, zzg zzgVar, List list) {
        String str2;
        char c;
        zzap zzapVar;
        zzap zzaeVar2;
        double d;
        double d2;
        double d3;
        zzae zzaeVar3;
        double min;
        switch (str.hashCode()) {
            case -1776922004:
                str2 = "toString";
                if (str.equals(str2)) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case -1354795244:
                if (str.equals("concat")) {
                    str2 = "toString";
                    c = 0;
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -1274492040:
                if (str.equals("filter")) {
                    str2 = "toString";
                    c = 2;
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -934873754:
                if (str.equals("reduce")) {
                    c = '\n';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -895859076:
                if (str.equals("splice")) {
                    c = 17;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -678635926:
                if (str.equals("forEach")) {
                    str2 = "toString";
                    c = 3;
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    c = 6;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -277637751:
                if (str.equals("unshift")) {
                    c = 19;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 107868:
                if (str.equals("map")) {
                    c = 7;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 111185:
                if (str.equals("pop")) {
                    c = '\b';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 3267882:
                if (str.equals("join")) {
                    c = 5;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 3452698:
                if (str.equals("push")) {
                    c = '\t';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 3536116:
                if (str.equals("some")) {
                    c = 15;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 3536286:
                if (str.equals("sort")) {
                    c = 16;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 96891675:
                if (str.equals("every")) {
                    str2 = "toString";
                    c = 1;
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 109407362:
                if (str.equals("shift")) {
                    c = '\r';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 109526418:
                if (str.equals("slice")) {
                    c = 14;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 965561430:
                if (str.equals("reduceRight")) {
                    c = 11;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 1099846370:
                if (str.equals("reverse")) {
                    c = '\f';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    c = 4;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            default:
                str2 = "toString";
                c = 65535;
                break;
        }
        String str3 = ",";
        zzai zzaiVar = null;
        switch (c) {
            case 0:
                zzapVar = (zzae) zzaeVar.zzd();
                if (!list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        zzap zzb = zzgVar.zzb((zzap) it.next());
                        if (!(zzb instanceof zzag)) {
                            int zzc = zzapVar.zzc();
                            if (zzb instanceof zzae) {
                                zzae zzaeVar4 = (zzae) zzb;
                                Iterator zzk = zzaeVar4.zzk();
                                while (zzk.hasNext()) {
                                    Integer num = (Integer) zzk.next();
                                    zzapVar.zzq(num.intValue() + zzc, zzaeVar4.zze(num.intValue()));
                                }
                            } else {
                                zzapVar.zzq(zzc, zzb);
                            }
                        } else {
                            throw new IllegalStateException("Failed evaluation of arguments");
                        }
                    }
                }
                return zzapVar;
            case 1:
                zzh.zzh("every", 1, list);
                zzap zzb2 = zzgVar.zzb((zzap) list.get(0));
                if (zzb2 instanceof zzao) {
                    if (zzaeVar.zzc() == 0) {
                        return zzap.zzk;
                    }
                    if (m3289a(zzaeVar, zzgVar, (zzao) zzb2, Boolean.FALSE, Boolean.TRUE).zzc() != zzaeVar.zzc()) {
                        return zzap.zzl;
                    }
                    return zzap.zzk;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 2:
                zzh.zzh("filter", 1, list);
                zzap zzb3 = zzgVar.zzb((zzap) list.get(0));
                if (zzb3 instanceof zzao) {
                    if (zzaeVar.zzb() == 0) {
                        return new zzae();
                    }
                    zzae zzaeVar5 = (zzae) zzaeVar.zzd();
                    zzae m3289a = m3289a(zzaeVar, zzgVar, (zzao) zzb3, null, Boolean.TRUE);
                    zzaeVar2 = new zzae();
                    Iterator zzk2 = m3289a.zzk();
                    while (zzk2.hasNext()) {
                        zzaeVar2.zzq(zzaeVar2.zzc(), zzaeVar5.zze(((Integer) zzk2.next()).intValue()));
                    }
                    return zzaeVar2;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 3:
                zzh.zzh("forEach", 1, list);
                zzap zzb4 = zzgVar.zzb((zzap) list.get(0));
                if (zzb4 instanceof zzao) {
                    if (zzaeVar.zzb() == 0) {
                        return zzap.zzf;
                    }
                    m3289a(zzaeVar, zzgVar, (zzao) zzb4, null, null);
                    return zzap.zzf;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 4:
                zzh.zzj("indexOf", 2, list);
                zzap zzapVar2 = zzap.zzf;
                if (!list.isEmpty()) {
                    zzapVar2 = zzgVar.zzb((zzap) list.get(0));
                }
                if (list.size() > 1) {
                    d = zzh.zza(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue());
                    if (d >= zzaeVar.zzc()) {
                        return new zzah(Double.valueOf(-1.0d));
                    }
                    if (d < 0.0d) {
                        d += zzaeVar.zzc();
                    }
                } else {
                    d = 0.0d;
                }
                Iterator zzk3 = zzaeVar.zzk();
                while (zzk3.hasNext()) {
                    int intValue = ((Integer) zzk3.next()).intValue();
                    double d4 = intValue;
                    if (d4 >= d && zzh.zzl(zzaeVar.zze(intValue), zzapVar2)) {
                        return new zzah(Double.valueOf(d4));
                    }
                }
                return new zzah(Double.valueOf(-1.0d));
            case 5:
                zzh.zzj("join", 1, list);
                if (zzaeVar.zzc() == 0) {
                    return zzap.zzm;
                }
                if (!list.isEmpty()) {
                    zzap zzb5 = zzgVar.zzb((zzap) list.get(0));
                    if (!(zzb5 instanceof zzan) && !(zzb5 instanceof zzau)) {
                        str3 = zzb5.zzi();
                    } else {
                        str3 = "";
                    }
                }
                return new zzat(zzaeVar.zzj(str3));
            case 6:
                zzh.zzj("lastIndexOf", 2, list);
                zzap zzapVar3 = zzap.zzf;
                if (!list.isEmpty()) {
                    zzapVar3 = zzgVar.zzb((zzap) list.get(0));
                }
                int zzc2 = zzaeVar.zzc() - 1;
                if (list.size() > 1) {
                    zzap zzb6 = zzgVar.zzb((zzap) list.get(1));
                    d3 = Double.isNaN(zzb6.zzh().doubleValue()) ? zzaeVar.zzc() - 1 : zzh.zza(zzb6.zzh().doubleValue());
                    d2 = 0.0d;
                    if (d3 < 0.0d) {
                        d3 += zzaeVar.zzc();
                    }
                } else {
                    d2 = 0.0d;
                    d3 = zzc2;
                }
                if (d3 < d2) {
                    return new zzah(Double.valueOf(-1.0d));
                }
                for (int min2 = (int) Math.min(zzaeVar.zzc(), d3); min2 >= 0; min2--) {
                    if (zzaeVar.zzs(min2) && zzh.zzl(zzaeVar.zze(min2), zzapVar3)) {
                        zzaeVar2 = new zzah(Double.valueOf(min2));
                        return zzaeVar2;
                    }
                }
                return new zzah(Double.valueOf(-1.0d));
            case 7:
                zzh.zzh("map", 1, list);
                zzap zzb7 = zzgVar.zzb((zzap) list.get(0));
                if (zzb7 instanceof zzao) {
                    if (zzaeVar.zzc() == 0) {
                        return new zzae();
                    }
                    return m3289a(zzaeVar, zzgVar, (zzao) zzb7, null, null);
                }
                throw new IllegalArgumentException("Callback should be a method");
            case '\b':
                zzh.zzh("pop", 0, list);
                int zzc3 = zzaeVar.zzc();
                if (zzc3 == 0) {
                    return zzap.zzf;
                }
                int i = zzc3 - 1;
                zzapVar = zzaeVar.zze(i);
                zzaeVar.zzp(i);
                return zzapVar;
            case '\t':
                if (!list.isEmpty()) {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        zzaeVar.zzq(zzaeVar.zzc(), zzgVar.zzb((zzap) it2.next()));
                    }
                }
                return new zzah(Double.valueOf(zzaeVar.zzc()));
            case '\n':
                return m3290b(zzaeVar, zzgVar, list, true);
            case 11:
                return m3290b(zzaeVar, zzgVar, list, false);
            case '\f':
                zzaeVar3 = zzaeVar;
                zzh.zzh("reverse", 0, list);
                int zzc4 = zzaeVar.zzc();
                if (zzc4 != 0) {
                    for (int i2 = 0; i2 < zzc4 / 2; i2++) {
                        if (zzaeVar3.zzs(i2)) {
                            zzap zze = zzaeVar3.zze(i2);
                            zzaeVar3.zzq(i2, null);
                            int i3 = (zzc4 - 1) - i2;
                            if (zzaeVar3.zzs(i3)) {
                                zzaeVar3.zzq(i2, zzaeVar3.zze(i3));
                            }
                            zzaeVar3.zzq(i3, zze);
                        }
                    }
                }
                return zzaeVar3;
            case '\r':
                zzh.zzh("shift", 0, list);
                if (zzaeVar.zzc() == 0) {
                    return zzap.zzf;
                }
                zzap zze2 = zzaeVar.zze(0);
                zzaeVar.zzp(0);
                return zze2;
            case 14:
                zzh.zzj("slice", 2, list);
                if (list.isEmpty()) {
                    return zzaeVar.zzd();
                }
                double zzc5 = zzaeVar.zzc();
                double zza = zzh.zza(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
                if (zza < 0.0d) {
                    min = Math.max(zza + zzc5, 0.0d);
                } else {
                    min = Math.min(zza, zzc5);
                }
                if (list.size() == 2) {
                    double zza2 = zzh.zza(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue());
                    if (zza2 < 0.0d) {
                        zzc5 = Math.max(zzc5 + zza2, 0.0d);
                    } else {
                        zzc5 = Math.min(zzc5, zza2);
                    }
                }
                zzae zzaeVar6 = new zzae();
                for (int i4 = (int) min; i4 < zzc5; i4++) {
                    zzaeVar6.zzq(zzaeVar6.zzc(), zzaeVar.zze(i4));
                }
                return zzaeVar6;
            case 15:
                zzh.zzh("some", 1, list);
                zzap zzb8 = zzgVar.zzb((zzap) list.get(0));
                if (zzb8 instanceof zzai) {
                    if (zzaeVar.zzc() == 0) {
                        return zzap.zzl;
                    }
                    zzai zzaiVar2 = (zzai) zzb8;
                    Iterator zzk4 = zzaeVar.zzk();
                    while (zzk4.hasNext()) {
                        int intValue2 = ((Integer) zzk4.next()).intValue();
                        if (zzaeVar.zzs(intValue2) && zzaiVar2.zza(zzgVar, Arrays.asList(zzaeVar.zze(intValue2), new zzah(Double.valueOf(intValue2)), zzaeVar)).zzg().booleanValue()) {
                            return zzap.zzk;
                        }
                    }
                    return zzap.zzl;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 16:
                zzaeVar3 = zzaeVar;
                zzh.zzj("sort", 1, list);
                if (zzaeVar.zzc() >= 2) {
                    List zzm = zzaeVar.zzm();
                    if (!list.isEmpty()) {
                        zzap zzb9 = zzgVar.zzb((zzap) list.get(0));
                        if (zzb9 instanceof zzai) {
                            zzaiVar = (zzai) zzb9;
                        } else {
                            throw new IllegalArgumentException("Comparator should be a method");
                        }
                    }
                    Collections.sort(zzm, new cs2(zzaiVar, zzgVar));
                    zzaeVar.zzn();
                    Iterator it3 = zzm.iterator();
                    int i5 = 0;
                    while (it3.hasNext()) {
                        zzaeVar3.zzq(i5, (zzap) it3.next());
                        i5++;
                    }
                }
                return zzaeVar3;
            case 17:
                if (list.isEmpty()) {
                    return new zzae();
                }
                int zza3 = (int) zzh.zza(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
                if (zza3 < 0) {
                    zza3 = Math.max(0, zzaeVar.zzc() + zza3);
                } else if (zza3 > zzaeVar.zzc()) {
                    zza3 = zzaeVar.zzc();
                }
                int zzc6 = zzaeVar.zzc();
                zzae zzaeVar7 = new zzae();
                if (list.size() > 1) {
                    int max = Math.max(0, (int) zzh.zza(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()));
                    if (max > 0) {
                        for (int i6 = zza3; i6 < Math.min(zzc6, zza3 + max); i6++) {
                            zzaeVar7.zzq(zzaeVar7.zzc(), zzaeVar.zze(zza3));
                            zzaeVar.zzp(zza3);
                        }
                    }
                    if (list.size() > 2) {
                        for (int i7 = 2; i7 < list.size(); i7++) {
                            zzap zzb10 = zzgVar.zzb((zzap) list.get(i7));
                            if (!(zzb10 instanceof zzag)) {
                                zzaeVar.zzo((zza3 + i7) - 2, zzb10);
                            } else {
                                throw new IllegalArgumentException("Failed to parse elements to add");
                            }
                        }
                    }
                } else {
                    while (zza3 < zzc6) {
                        zzaeVar7.zzq(zzaeVar7.zzc(), zzaeVar.zze(zza3));
                        zzaeVar.zzq(zza3, null);
                        zza3++;
                    }
                }
                return zzaeVar7;
            case 18:
                zzh.zzh(str2, 0, list);
                return new zzat(zzaeVar.zzj(","));
            case 19:
                if (!list.isEmpty()) {
                    zzae zzaeVar8 = new zzae();
                    Iterator it4 = list.iterator();
                    while (it4.hasNext()) {
                        zzap zzb11 = zzgVar.zzb((zzap) it4.next());
                        if (!(zzb11 instanceof zzag)) {
                            zzaeVar8.zzq(zzaeVar8.zzc(), zzb11);
                        } else {
                            throw new IllegalStateException("Argument evaluation failed");
                        }
                    }
                    int zzc7 = zzaeVar8.zzc();
                    Iterator zzk5 = zzaeVar.zzk();
                    while (zzk5.hasNext()) {
                        Integer num2 = (Integer) zzk5.next();
                        zzaeVar8.zzq(num2.intValue() + zzc7, zzaeVar.zze(num2.intValue()));
                    }
                    zzaeVar.zzn();
                    Iterator zzk6 = zzaeVar8.zzk();
                    while (zzk6.hasNext()) {
                        Integer num3 = (Integer) zzk6.next();
                        zzaeVar.zzq(num3.intValue(), zzaeVar8.zze(num3.intValue()));
                    }
                }
                return new zzah(Double.valueOf(zzaeVar.zzc()));
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }
}
