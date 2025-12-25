package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import p000.C1689pj;
import p000.j93;
import p000.ye0;

/* loaded from: classes.dex */
public final class zzae implements Iterable, zzap, zzal {

    /* renamed from: a */
    public final TreeMap f13776a;

    /* renamed from: b */
    public final TreeMap f13777b;

    public zzae() {
        this.f13776a = new TreeMap();
        this.f13777b = new TreeMap();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzae)) {
            return false;
        }
        zzae zzaeVar = (zzae) obj;
        if (zzc() != zzaeVar.zzc()) {
            return false;
        }
        TreeMap treeMap = this.f13776a;
        if (treeMap.isEmpty()) {
            return zzaeVar.f13776a.isEmpty();
        }
        for (int intValue = ((Integer) treeMap.firstKey()).intValue(); intValue <= ((Integer) treeMap.lastKey()).intValue(); intValue++) {
            if (!zze(intValue).equals(zzaeVar.zze(intValue))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.f13776a.hashCode() * 31;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new C1689pj(this);
    }

    public final String toString() {
        return zzj(",");
    }

    public final int zzb() {
        return this.f13776a.size();
    }

    public final int zzc() {
        TreeMap treeMap = this.f13776a;
        if (treeMap.isEmpty()) {
            return 0;
        }
        return ((Integer) treeMap.lastKey()).intValue() + 1;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzcz(String str, zzg zzgVar, List list) {
        if (!"concat".equals(str) && !"every".equals(str) && !"filter".equals(str) && !"forEach".equals(str) && !"indexOf".equals(str) && !"join".equals(str) && !"lastIndexOf".equals(str) && !"map".equals(str) && !"pop".equals(str) && !"push".equals(str) && !"reduce".equals(str) && !"reduceRight".equals(str) && !"reverse".equals(str) && !"shift".equals(str) && !"slice".equals(str) && !"some".equals(str) && !"sort".equals(str) && !"splice".equals(str) && !"toString".equals(str) && !"unshift".equals(str)) {
            return zzaj.zza(this, new zzat(str), zzgVar, list);
        }
        return zzbb.zza(str, this, zzgVar, list);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        zzae zzaeVar = new zzae();
        for (Map.Entry entry : this.f13776a.entrySet()) {
            boolean z = entry.getValue() instanceof zzal;
            TreeMap treeMap = zzaeVar.f13776a;
            if (z) {
                treeMap.put((Integer) entry.getKey(), (zzap) entry.getValue());
            } else {
                treeMap.put((Integer) entry.getKey(), ((zzap) entry.getValue()).zzd());
            }
        }
        return zzaeVar;
    }

    public final zzap zze(int i) {
        zzap zzapVar;
        if (i < zzc()) {
            if (zzs(i) && (zzapVar = (zzap) this.f13776a.get(Integer.valueOf(i))) != null) {
                return zzapVar;
            }
            return zzap.zzf;
        }
        throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
    }

    @Override // com.google.android.gms.internal.measurement.zzal
    public final zzap zzf(String str) {
        zzap zzapVar;
        if ("length".equals(str)) {
            return new zzah(Double.valueOf(zzc()));
        }
        if (zzt(str) && (zzapVar = (zzap) this.f13777b.get(str)) != null) {
            return zzapVar;
        }
        return zzap.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zzg() {
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzh() {
        TreeMap treeMap = this.f13776a;
        if (treeMap.size() == 1) {
            return zze(0).zzh();
        }
        if (treeMap.size() <= 0) {
            return Double.valueOf(0.0d);
        }
        return Double.valueOf(Double.NaN);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzi() {
        return zzj(",");
    }

    public final String zzj(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        if (!this.f13776a.isEmpty()) {
            int i = 0;
            while (true) {
                if (str == null) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                if (i >= zzc()) {
                    break;
                }
                zzap zze = zze(i);
                sb.append(str2);
                if (!(zze instanceof zzau) && !(zze instanceof zzan)) {
                    sb.append(zze.zzi());
                }
                i++;
            }
            sb.delete(0, str2.length());
        }
        return sb.toString();
    }

    public final Iterator zzk() {
        return this.f13776a.keySet().iterator();
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator zzl() {
        return new j93(this.f13776a.keySet().iterator(), this.f13777b.keySet().iterator());
    }

    public final List zzm() {
        ArrayList arrayList = new ArrayList(zzc());
        for (int i = 0; i < zzc(); i++) {
            arrayList.add(zze(i));
        }
        return arrayList;
    }

    public final void zzn() {
        this.f13776a.clear();
    }

    public final void zzo(int i, zzap zzapVar) {
        if (i >= 0) {
            if (i >= zzc()) {
                zzq(i, zzapVar);
                return;
            }
            TreeMap treeMap = this.f13776a;
            for (int intValue = ((Integer) treeMap.lastKey()).intValue(); intValue >= i; intValue--) {
                Integer valueOf = Integer.valueOf(intValue);
                zzap zzapVar2 = (zzap) treeMap.get(valueOf);
                if (zzapVar2 != null) {
                    zzq(intValue + 1, zzapVar2);
                    treeMap.remove(valueOf);
                }
            }
            zzq(i, zzapVar);
            return;
        }
        throw new IllegalArgumentException(ye0.m8291k(i, "Invalid value index: "));
    }

    public final void zzp(int i) {
        TreeMap treeMap = this.f13776a;
        int intValue = ((Integer) treeMap.lastKey()).intValue();
        if (i <= intValue && i >= 0) {
            treeMap.remove(Integer.valueOf(i));
            if (i == intValue) {
                int i2 = i - 1;
                Integer valueOf = Integer.valueOf(i2);
                if (!treeMap.containsKey(valueOf) && i2 >= 0) {
                    treeMap.put(valueOf, zzap.zzf);
                    return;
                }
                return;
            }
            while (true) {
                i++;
                if (i <= ((Integer) treeMap.lastKey()).intValue()) {
                    Integer valueOf2 = Integer.valueOf(i);
                    zzap zzapVar = (zzap) treeMap.get(valueOf2);
                    if (zzapVar != null) {
                        treeMap.put(Integer.valueOf(i - 1), zzapVar);
                        treeMap.remove(valueOf2);
                    }
                } else {
                    return;
                }
            }
        }
    }

    @RequiresNonNull({"elements"})
    public final void zzq(int i, zzap zzapVar) {
        if (i <= 32468) {
            if (i >= 0) {
                TreeMap treeMap = this.f13776a;
                if (zzapVar == null) {
                    treeMap.remove(Integer.valueOf(i));
                    return;
                } else {
                    treeMap.put(Integer.valueOf(i), zzapVar);
                    return;
                }
            }
            throw new IndexOutOfBoundsException(ye0.m8291k(i, "Out of bounds index: "));
        }
        throw new IllegalStateException("Array too large");
    }

    @Override // com.google.android.gms.internal.measurement.zzal
    public final void zzr(String str, zzap zzapVar) {
        TreeMap treeMap = this.f13777b;
        if (zzapVar == null) {
            treeMap.remove(str);
        } else {
            treeMap.put(str, zzapVar);
        }
    }

    public final boolean zzs(int i) {
        if (i >= 0) {
            TreeMap treeMap = this.f13776a;
            if (i <= ((Integer) treeMap.lastKey()).intValue()) {
                return treeMap.containsKey(Integer.valueOf(i));
            }
        }
        throw new IndexOutOfBoundsException(ye0.m8291k(i, "Out of bounds index: "));
    }

    @Override // com.google.android.gms.internal.measurement.zzal
    public final boolean zzt(String str) {
        if (!"length".equals(str) && !this.f13777b.containsKey(str)) {
            return false;
        }
        return true;
    }

    public zzae(List list) {
        this();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                zzq(i, (zzap) list.get(i));
            }
        }
    }
}
