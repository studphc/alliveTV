package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class zzam implements zzap, zzal {

    /* renamed from: a */
    public final HashMap f13782a = new HashMap();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzam)) {
            return false;
        }
        return this.f13782a.equals(((zzam) obj).f13782a);
    }

    public final int hashCode() {
        return this.f13782a.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        HashMap hashMap = this.f13782a;
        if (!hashMap.isEmpty()) {
            for (String str : hashMap.keySet()) {
                sb.append(String.format("%s: %s,", str, hashMap.get(str)));
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        sb.append("}");
        return sb.toString();
    }

    public final List zzb() {
        return new ArrayList(this.f13782a.keySet());
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public zzap zzcz(String str, zzg zzgVar, List list) {
        if ("toString".equals(str)) {
            return new zzat(toString());
        }
        return zzaj.zza(this, new zzat(str), zzgVar, list);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        zzam zzamVar = new zzam();
        for (Map.Entry entry : this.f13782a.entrySet()) {
            boolean z = entry.getValue() instanceof zzal;
            HashMap hashMap = zzamVar.f13782a;
            if (z) {
                hashMap.put((String) entry.getKey(), (zzap) entry.getValue());
            } else {
                hashMap.put((String) entry.getKey(), ((zzap) entry.getValue()).zzd());
            }
        }
        return zzamVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzal
    public final zzap zzf(String str) {
        HashMap hashMap = this.f13782a;
        if (hashMap.containsKey(str)) {
            return (zzap) hashMap.get(str);
        }
        return zzap.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zzg() {
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzh() {
        return Double.valueOf(Double.NaN);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzi() {
        return "[object Object]";
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator zzl() {
        return zzaj.zzb(this.f13782a);
    }

    @Override // com.google.android.gms.internal.measurement.zzal
    public final void zzr(String str, zzap zzapVar) {
        HashMap hashMap = this.f13782a;
        if (zzapVar == null) {
            hashMap.remove(str);
        } else {
            hashMap.put(str, zzapVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzal
    public final boolean zzt(String str) {
        return this.f13782a.containsKey(str);
    }
}
