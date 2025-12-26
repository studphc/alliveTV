package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.List;
import p000.hd3;
import p000.le3;
import p000.md3;
import p000.ud3;
import p000.wc3;
import p000.xd3;
import p000.ye0;

/* renamed from: com.google.android.gms.internal.measurement.f */
/* loaded from: classes.dex */
public abstract class AbstractC0786f {

    /* renamed from: a */
    public static final C0782b f13768a;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.measurement.b, java.lang.Object] */
    static {
        ud3 ud3Var = ud3.f27230c;
        f13768a = new Object();
    }

    /* renamed from: A */
    public static void m3254A(int i, List list, le3 le3Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            wc3 wc3Var = (wc3) le3Var;
            wc3Var.getClass();
            boolean z2 = list instanceof md3;
            zzlk zzlkVar = wc3Var.f28137a;
            int i2 = 0;
            if (z2) {
                md3 md3Var = (md3) list;
                if (z) {
                    zzlkVar.zzr(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < md3Var.f22904c; i4++) {
                        i3 += zzlk.zzA(md3Var.zza(i4));
                    }
                    zzlkVar.zzt(i3);
                    while (i2 < md3Var.f22904c) {
                        zzlkVar.zzv(md3Var.zza(i2));
                        i2++;
                    }
                    return;
                }
                while (i2 < md3Var.f22904c) {
                    zzlkVar.zzu(i, md3Var.zza(i2));
                    i2++;
                }
                return;
            }
            if (z) {
                zzlkVar.zzr(i, 2);
                int i5 = 0;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    i5 += zzlk.zzA(((Long) list.get(i6)).longValue());
                }
                zzlkVar.zzt(i5);
                while (i2 < list.size()) {
                    zzlkVar.zzv(((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                zzlkVar.zzu(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    /* renamed from: B */
    public static void m3255B(int i, List list, le3 le3Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            wc3 wc3Var = (wc3) le3Var;
            wc3Var.getClass();
            boolean z2 = list instanceof hd3;
            zzlk zzlkVar = wc3Var.f28137a;
            int i2 = 0;
            if (z2) {
                hd3 hd3Var = (hd3) list;
                if (z) {
                    zzlkVar.zzr(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < hd3Var.f18035c; i4++) {
                        hd3Var.m5052b(i4);
                        i3 += 4;
                    }
                    zzlkVar.zzt(i3);
                    while (i2 < hd3Var.f18035c) {
                        zzlkVar.zzg(hd3Var.m5052b(i2));
                        i2++;
                    }
                    return;
                }
                while (i2 < hd3Var.f18035c) {
                    zzlkVar.zzf(i, hd3Var.m5052b(i2));
                    i2++;
                }
                return;
            }
            if (z) {
                zzlkVar.zzr(i, 2);
                int i5 = 0;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    ((Integer) list.get(i6)).getClass();
                    i5 += 4;
                }
                zzlkVar.zzt(i5);
                while (i2 < list.size()) {
                    zzlkVar.zzg(((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                zzlkVar.zzf(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    /* renamed from: C */
    public static void m3256C(int i, List list, le3 le3Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            wc3 wc3Var = (wc3) le3Var;
            wc3Var.getClass();
            boolean z2 = list instanceof md3;
            zzlk zzlkVar = wc3Var.f28137a;
            int i2 = 0;
            if (z2) {
                md3 md3Var = (md3) list;
                if (z) {
                    zzlkVar.zzr(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < md3Var.f22904c; i4++) {
                        md3Var.zza(i4);
                        i3 += 8;
                    }
                    zzlkVar.zzt(i3);
                    while (i2 < md3Var.f22904c) {
                        zzlkVar.zzi(md3Var.zza(i2));
                        i2++;
                    }
                    return;
                }
                while (i2 < md3Var.f22904c) {
                    zzlkVar.zzh(i, md3Var.zza(i2));
                    i2++;
                }
                return;
            }
            if (z) {
                zzlkVar.zzr(i, 2);
                int i5 = 0;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    ((Long) list.get(i6)).getClass();
                    i5 += 8;
                }
                zzlkVar.zzt(i5);
                while (i2 < list.size()) {
                    zzlkVar.zzi(((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                zzlkVar.zzh(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    /* renamed from: a */
    public static void m3257a(int i, List list, le3 le3Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            wc3 wc3Var = (wc3) le3Var;
            wc3Var.getClass();
            boolean z2 = list instanceof hd3;
            zzlk zzlkVar = wc3Var.f28137a;
            int i2 = 0;
            if (z2) {
                hd3 hd3Var = (hd3) list;
                if (z) {
                    zzlkVar.zzr(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < hd3Var.f18035c; i4++) {
                        int m5052b = hd3Var.m5052b(i4);
                        i3 += zzlk.zzz((m5052b >> 31) ^ (m5052b + m5052b));
                    }
                    zzlkVar.zzt(i3);
                    while (i2 < hd3Var.f18035c) {
                        int m5052b2 = hd3Var.m5052b(i2);
                        zzlkVar.zzt((m5052b2 >> 31) ^ (m5052b2 + m5052b2));
                        i2++;
                    }
                    return;
                }
                while (i2 < hd3Var.f18035c) {
                    int m5052b3 = hd3Var.m5052b(i2);
                    zzlkVar.zzs(i, (m5052b3 >> 31) ^ (m5052b3 + m5052b3));
                    i2++;
                }
                return;
            }
            if (z) {
                zzlkVar.zzr(i, 2);
                int i5 = 0;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    int intValue = ((Integer) list.get(i6)).intValue();
                    i5 += zzlk.zzz((intValue >> 31) ^ (intValue + intValue));
                }
                zzlkVar.zzt(i5);
                while (i2 < list.size()) {
                    int intValue2 = ((Integer) list.get(i2)).intValue();
                    zzlkVar.zzt((intValue2 >> 31) ^ (intValue2 + intValue2));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                int intValue3 = ((Integer) list.get(i2)).intValue();
                zzlkVar.zzs(i, (intValue3 >> 31) ^ (intValue3 + intValue3));
                i2++;
            }
        }
    }

    /* renamed from: b */
    public static void m3258b(int i, List list, le3 le3Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            wc3 wc3Var = (wc3) le3Var;
            wc3Var.getClass();
            boolean z2 = list instanceof md3;
            zzlk zzlkVar = wc3Var.f28137a;
            int i2 = 0;
            if (z2) {
                md3 md3Var = (md3) list;
                if (z) {
                    zzlkVar.zzr(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < md3Var.f22904c; i4++) {
                        long zza = md3Var.zza(i4);
                        i3 += zzlk.zzA((zza >> 63) ^ (zza + zza));
                    }
                    zzlkVar.zzt(i3);
                    while (i2 < md3Var.f22904c) {
                        long zza2 = md3Var.zza(i2);
                        zzlkVar.zzv((zza2 >> 63) ^ (zza2 + zza2));
                        i2++;
                    }
                    return;
                }
                while (i2 < md3Var.f22904c) {
                    long zza3 = md3Var.zza(i2);
                    zzlkVar.zzu(i, (zza3 >> 63) ^ (zza3 + zza3));
                    i2++;
                }
                return;
            }
            if (z) {
                zzlkVar.zzr(i, 2);
                int i5 = 0;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    long longValue = ((Long) list.get(i6)).longValue();
                    i5 += zzlk.zzA((longValue >> 63) ^ (longValue + longValue));
                }
                zzlkVar.zzt(i5);
                while (i2 < list.size()) {
                    long longValue2 = ((Long) list.get(i2)).longValue();
                    zzlkVar.zzv((longValue2 >> 63) ^ (longValue2 + longValue2));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                long longValue3 = ((Long) list.get(i2)).longValue();
                zzlkVar.zzu(i, (longValue3 >> 63) ^ (longValue3 + longValue3));
                i2++;
            }
        }
    }

    /* renamed from: c */
    public static void m3259c(int i, List list, le3 le3Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            wc3 wc3Var = (wc3) le3Var;
            wc3Var.getClass();
            boolean z2 = list instanceof hd3;
            zzlk zzlkVar = wc3Var.f28137a;
            int i2 = 0;
            if (z2) {
                hd3 hd3Var = (hd3) list;
                if (z) {
                    zzlkVar.zzr(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < hd3Var.f18035c; i4++) {
                        i3 += zzlk.zzz(hd3Var.m5052b(i4));
                    }
                    zzlkVar.zzt(i3);
                    while (i2 < hd3Var.f18035c) {
                        zzlkVar.zzt(hd3Var.m5052b(i2));
                        i2++;
                    }
                    return;
                }
                while (i2 < hd3Var.f18035c) {
                    zzlkVar.zzs(i, hd3Var.m5052b(i2));
                    i2++;
                }
                return;
            }
            if (z) {
                zzlkVar.zzr(i, 2);
                int i5 = 0;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    i5 += zzlk.zzz(((Integer) list.get(i6)).intValue());
                }
                zzlkVar.zzt(i5);
                while (i2 < list.size()) {
                    zzlkVar.zzt(((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                zzlkVar.zzs(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    /* renamed from: d */
    public static void m3260d(int i, List list, le3 le3Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            wc3 wc3Var = (wc3) le3Var;
            wc3Var.getClass();
            boolean z2 = list instanceof md3;
            zzlk zzlkVar = wc3Var.f28137a;
            int i2 = 0;
            if (z2) {
                md3 md3Var = (md3) list;
                if (z) {
                    zzlkVar.zzr(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < md3Var.f22904c; i4++) {
                        i3 += zzlk.zzA(md3Var.zza(i4));
                    }
                    zzlkVar.zzt(i3);
                    while (i2 < md3Var.f22904c) {
                        zzlkVar.zzv(md3Var.zza(i2));
                        i2++;
                    }
                    return;
                }
                while (i2 < md3Var.f22904c) {
                    zzlkVar.zzu(i, md3Var.zza(i2));
                    i2++;
                }
                return;
            }
            if (z) {
                zzlkVar.zzr(i, 2);
                int i5 = 0;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    i5 += zzlk.zzA(((Long) list.get(i6)).longValue());
                }
                zzlkVar.zzt(i5);
                while (i2 < list.size()) {
                    zzlkVar.zzv(((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                zzlkVar.zzu(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    /* renamed from: e */
    public static boolean m3261e(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public static int m3262f(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof hd3) {
            hd3 hd3Var = (hd3) list;
            i = 0;
            while (i2 < size) {
                i += zzlk.zzA(hd3Var.m5052b(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzlk.zzA(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: g */
    public static int m3263g(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzlk.zzz(i << 3) + 4) * size;
    }

    /* renamed from: h */
    public static int m3264h(List list) {
        return list.size() * 4;
    }

    /* renamed from: i */
    public static int m3265i(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzlk.zzz(i << 3) + 8) * size;
    }

    /* renamed from: j */
    public static int m3266j(List list) {
        return list.size() * 8;
    }

    /* renamed from: k */
    public static int m3267k(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof hd3) {
            hd3 hd3Var = (hd3) list;
            i = 0;
            while (i2 < size) {
                i += zzlk.zzA(hd3Var.m5052b(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzlk.zzA(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: l */
    public static int m3268l(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof md3) {
            md3 md3Var = (md3) list;
            i = 0;
            while (i2 < size) {
                i += zzlk.zzA(md3Var.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzlk.zzA(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: m */
    public static int m3269m(int i, Object obj, xd3 xd3Var) {
        int i2 = i << 3;
        if (obj instanceof zzms) {
            int zzz = zzlk.zzz(i2);
            int zza = ((zzms) obj).zza();
            return ye0.m8285e(zza, zza, zzz);
        }
        return zzlk.m3466c((zznh) obj, xd3Var) + zzlk.zzz(i2);
    }

    /* renamed from: n */
    public static int m3270n(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof hd3) {
            hd3 hd3Var = (hd3) list;
            i = 0;
            while (i2 < size) {
                int m5052b = hd3Var.m5052b(i2);
                i += zzlk.zzz((m5052b >> 31) ^ (m5052b + m5052b));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i += zzlk.zzz((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    /* renamed from: o */
    public static int m3271o(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof md3) {
            md3 md3Var = (md3) list;
            i = 0;
            while (i2 < size) {
                long zza = md3Var.zza(i2);
                i += zzlk.zzA((zza >> 63) ^ (zza + zza));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i += zzlk.zzA((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    /* renamed from: p */
    public static int m3272p(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof hd3) {
            hd3 hd3Var = (hd3) list;
            i = 0;
            while (i2 < size) {
                i += zzlk.zzz(hd3Var.m5052b(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzlk.zzz(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: q */
    public static int m3273q(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof md3) {
            md3 md3Var = (md3) list;
            i = 0;
            while (i2 < size) {
                i += zzlk.zzA(md3Var.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzlk.zzA(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r4 = r4;
     */
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object m3274r(int i, Object obj, int i2, Object obj2) {
        Object obj3;
        if (obj2 == null) {
            zzmd zzmdVar = (zzmd) obj;
            zzof zzofVar = zzmdVar.zzc;
            obj3 = zzofVar;
            if (zzofVar == zzof.zzc()) {
                zzof m3477a = zzof.m3477a();
                zzmdVar.zzc = m3477a;
                obj3 = m3477a;
            }
        }
        ((zzof) obj3).m3478b(i << 3, Long.valueOf(i2));
        return obj3;
    }

    /* renamed from: s */
    public static void m3275s(Object obj, Object obj2) {
        zzmd zzmdVar = (zzmd) obj;
        zzof zzofVar = zzmdVar.zzc;
        zzof zzofVar2 = ((zzmd) obj2).zzc;
        if (!zzof.zzc().equals(zzofVar2)) {
            if (zzof.zzc().equals(zzofVar)) {
                int i = zzofVar.f13894a + zzofVar2.f13894a;
                int[] copyOf = Arrays.copyOf(zzofVar.f13895b, i);
                System.arraycopy(zzofVar2.f13895b, 0, copyOf, zzofVar.f13894a, zzofVar2.f13894a);
                Object[] copyOf2 = Arrays.copyOf(zzofVar.f13896c, i);
                System.arraycopy(zzofVar2.f13896c, 0, copyOf2, zzofVar.f13894a, zzofVar2.f13894a);
                zzofVar = new zzof(i, copyOf, copyOf2, true);
            } else {
                zzofVar.getClass();
                if (!zzofVar2.equals(zzof.f13893f)) {
                    if (zzofVar.f13898e) {
                        int i2 = zzofVar.f13894a + zzofVar2.f13894a;
                        zzofVar.m3479c(i2);
                        System.arraycopy(zzofVar2.f13895b, 0, zzofVar.f13895b, zzofVar.f13894a, zzofVar2.f13894a);
                        System.arraycopy(zzofVar2.f13896c, 0, zzofVar.f13896c, zzofVar.f13894a, zzofVar2.f13894a);
                        zzofVar.f13894a = i2;
                    } else {
                        throw new UnsupportedOperationException();
                    }
                }
            }
        }
        zzmdVar.zzc = zzofVar;
    }

    /* renamed from: t */
    public static void m3276t(int i, List list, le3 le3Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzlk zzlkVar = ((wc3) le3Var).f28137a;
            int i2 = 0;
            if (z) {
                zzlkVar.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    ((Boolean) list.get(i4)).getClass();
                    i3++;
                }
                zzlkVar.zzt(i3);
                while (i2 < list.size()) {
                    zzlkVar.zzb(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                zzlkVar.zzd(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
        }
    }

    /* renamed from: u */
    public static void m3277u(int i, List list, le3 le3Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzlk zzlkVar = ((wc3) le3Var).f28137a;
            int i2 = 0;
            if (z) {
                zzlkVar.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    ((Double) list.get(i4)).getClass();
                    i3 += 8;
                }
                zzlkVar.zzt(i3);
                while (i2 < list.size()) {
                    zzlkVar.zzi(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                zzlkVar.zzh(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
        }
    }

    /* renamed from: v */
    public static void m3278v(int i, List list, le3 le3Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            wc3 wc3Var = (wc3) le3Var;
            wc3Var.getClass();
            boolean z2 = list instanceof hd3;
            zzlk zzlkVar = wc3Var.f28137a;
            int i2 = 0;
            if (z2) {
                hd3 hd3Var = (hd3) list;
                if (z) {
                    zzlkVar.zzr(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < hd3Var.f18035c; i4++) {
                        i3 += zzlk.zzA(hd3Var.m5052b(i4));
                    }
                    zzlkVar.zzt(i3);
                    while (i2 < hd3Var.f18035c) {
                        zzlkVar.zzk(hd3Var.m5052b(i2));
                        i2++;
                    }
                    return;
                }
                while (i2 < hd3Var.f18035c) {
                    zzlkVar.zzj(i, hd3Var.m5052b(i2));
                    i2++;
                }
                return;
            }
            if (z) {
                zzlkVar.zzr(i, 2);
                int i5 = 0;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    i5 += zzlk.zzA(((Integer) list.get(i6)).intValue());
                }
                zzlkVar.zzt(i5);
                while (i2 < list.size()) {
                    zzlkVar.zzk(((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                zzlkVar.zzj(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    /* renamed from: w */
    public static void m3279w(int i, List list, le3 le3Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            wc3 wc3Var = (wc3) le3Var;
            wc3Var.getClass();
            boolean z2 = list instanceof hd3;
            zzlk zzlkVar = wc3Var.f28137a;
            int i2 = 0;
            if (z2) {
                hd3 hd3Var = (hd3) list;
                if (z) {
                    zzlkVar.zzr(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < hd3Var.f18035c; i4++) {
                        hd3Var.m5052b(i4);
                        i3 += 4;
                    }
                    zzlkVar.zzt(i3);
                    while (i2 < hd3Var.f18035c) {
                        zzlkVar.zzg(hd3Var.m5052b(i2));
                        i2++;
                    }
                    return;
                }
                while (i2 < hd3Var.f18035c) {
                    zzlkVar.zzf(i, hd3Var.m5052b(i2));
                    i2++;
                }
                return;
            }
            if (z) {
                zzlkVar.zzr(i, 2);
                int i5 = 0;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    ((Integer) list.get(i6)).getClass();
                    i5 += 4;
                }
                zzlkVar.zzt(i5);
                while (i2 < list.size()) {
                    zzlkVar.zzg(((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                zzlkVar.zzf(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    /* renamed from: x */
    public static void m3280x(int i, List list, le3 le3Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            wc3 wc3Var = (wc3) le3Var;
            wc3Var.getClass();
            boolean z2 = list instanceof md3;
            zzlk zzlkVar = wc3Var.f28137a;
            int i2 = 0;
            if (z2) {
                md3 md3Var = (md3) list;
                if (z) {
                    zzlkVar.zzr(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < md3Var.f22904c; i4++) {
                        md3Var.zza(i4);
                        i3 += 8;
                    }
                    zzlkVar.zzt(i3);
                    while (i2 < md3Var.f22904c) {
                        zzlkVar.zzi(md3Var.zza(i2));
                        i2++;
                    }
                    return;
                }
                while (i2 < md3Var.f22904c) {
                    zzlkVar.zzh(i, md3Var.zza(i2));
                    i2++;
                }
                return;
            }
            if (z) {
                zzlkVar.zzr(i, 2);
                int i5 = 0;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    ((Long) list.get(i6)).getClass();
                    i5 += 8;
                }
                zzlkVar.zzt(i5);
                while (i2 < list.size()) {
                    zzlkVar.zzi(((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                zzlkVar.zzh(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    /* renamed from: y */
    public static void m3281y(int i, List list, le3 le3Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzlk zzlkVar = ((wc3) le3Var).f28137a;
            int i2 = 0;
            if (z) {
                zzlkVar.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    ((Float) list.get(i4)).getClass();
                    i3 += 4;
                }
                zzlkVar.zzt(i3);
                while (i2 < list.size()) {
                    zzlkVar.zzg(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                zzlkVar.zzf(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
        }
    }

    /* renamed from: z */
    public static void m3282z(int i, List list, le3 le3Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            wc3 wc3Var = (wc3) le3Var;
            wc3Var.getClass();
            boolean z2 = list instanceof hd3;
            zzlk zzlkVar = wc3Var.f28137a;
            int i2 = 0;
            if (z2) {
                hd3 hd3Var = (hd3) list;
                if (z) {
                    zzlkVar.zzr(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < hd3Var.f18035c; i4++) {
                        i3 += zzlk.zzA(hd3Var.m5052b(i4));
                    }
                    zzlkVar.zzt(i3);
                    while (i2 < hd3Var.f18035c) {
                        zzlkVar.zzk(hd3Var.m5052b(i2));
                        i2++;
                    }
                    return;
                }
                while (i2 < hd3Var.f18035c) {
                    zzlkVar.zzj(i, hd3Var.m5052b(i2));
                    i2++;
                }
                return;
            }
            if (z) {
                zzlkVar.zzr(i, 2);
                int i5 = 0;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    i5 += zzlk.zzA(((Integer) list.get(i6)).intValue());
                }
                zzlkVar.zzt(i5);
                while (i2 < list.size()) {
                    zzlkVar.zzk(((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                zzlkVar.zzj(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }
}
