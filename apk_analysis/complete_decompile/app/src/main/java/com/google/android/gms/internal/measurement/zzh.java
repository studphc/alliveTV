package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public final class zzh {
    public static double zza(double d) {
        int i;
        if (Double.isNaN(d)) {
            return 0.0d;
        }
        if (!Double.isInfinite(d) && d != 0.0d && d != 0.0d) {
            if (d > 0.0d) {
                i = 1;
            } else {
                i = -1;
            }
            return i * Math.floor(Math.abs(d));
        }
        return d;
    }

    public static int zzb(double d) {
        int i;
        if (!Double.isNaN(d) && !Double.isInfinite(d) && d != 0.0d) {
            if (d > 0.0d) {
                i = 1;
            } else {
                i = -1;
            }
            return (int) ((i * Math.floor(Math.abs(d))) % 4.294967296E9d);
        }
        return 0;
    }

    public static int zzc(zzg zzgVar) {
        int zzb = zzb(zzgVar.zzd("runtime.counter").zzh().doubleValue() + 1.0d);
        if (zzb <= 1000000) {
            zzgVar.zzg("runtime.counter", new zzah(Double.valueOf(zzb)));
            return zzb;
        }
        throw new IllegalStateException("Instructions allowed exceeded");
    }

    public static long zzd(double d) {
        return zzb(d) & 4294967295L;
    }

    public static zzbl zze(String str) {
        zzbl zzblVar = null;
        if (str != null && !str.isEmpty()) {
            zzblVar = zzbl.zza(Integer.parseInt(str));
        }
        if (zzblVar != null) {
            return zzblVar;
        }
        throw new IllegalArgumentException(AbstractC1726qj.m7038C("Unsupported commandId ", str));
    }

    public static Object zzf(zzap zzapVar) {
        if (zzap.zzg.equals(zzapVar)) {
            return null;
        }
        if (zzap.zzf.equals(zzapVar)) {
            return "";
        }
        if (zzapVar instanceof zzam) {
            return zzg((zzam) zzapVar);
        }
        if (zzapVar instanceof zzae) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((zzae) zzapVar).iterator();
            while (it.hasNext()) {
                Object zzf = zzf((zzap) it.next());
                if (zzf != null) {
                    arrayList.add(zzf);
                }
            }
            return arrayList;
        }
        if (!zzapVar.zzh().isNaN()) {
            return zzapVar.zzh();
        }
        return zzapVar.zzi();
    }

    public static Map zzg(zzam zzamVar) {
        HashMap hashMap = new HashMap();
        for (String str : zzamVar.zzb()) {
            Object zzf = zzf(zzamVar.zzf(str));
            if (zzf != null) {
                hashMap.put(str, zzf);
            }
        }
        return hashMap;
    }

    public static void zzh(String str, int i, List list) {
        if (list.size() == i) {
            return;
        }
        throw new IllegalArgumentException(str + " operation requires " + i + " parameters found " + list.size());
    }

    public static void zzi(String str, int i, List list) {
        if (list.size() >= i) {
            return;
        }
        throw new IllegalArgumentException(str + " operation requires at least " + i + " parameters found " + list.size());
    }

    public static void zzj(String str, int i, List list) {
        if (list.size() <= i) {
            return;
        }
        throw new IllegalArgumentException(str + " operation requires at most " + i + " parameters found " + list.size());
    }

    public static boolean zzk(zzap zzapVar) {
        if (zzapVar == null) {
            return false;
        }
        Double zzh = zzapVar.zzh();
        if (zzh.isNaN() || zzh.doubleValue() < 0.0d || !zzh.equals(Double.valueOf(Math.floor(zzh.doubleValue())))) {
            return false;
        }
        return true;
    }

    public static boolean zzl(zzap zzapVar, zzap zzapVar2) {
        if (!zzapVar.getClass().equals(zzapVar2.getClass())) {
            return false;
        }
        if ((zzapVar instanceof zzau) || (zzapVar instanceof zzan)) {
            return true;
        }
        if (zzapVar instanceof zzah) {
            if (Double.isNaN(zzapVar.zzh().doubleValue()) || Double.isNaN(zzapVar2.zzh().doubleValue())) {
                return false;
            }
            return zzapVar.zzh().equals(zzapVar2.zzh());
        }
        if (zzapVar instanceof zzat) {
            return zzapVar.zzi().equals(zzapVar2.zzi());
        }
        if (zzapVar instanceof zzaf) {
            return zzapVar.zzg().equals(zzapVar2.zzg());
        }
        if (zzapVar != zzapVar2) {
            return false;
        }
        return true;
    }
}
