package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class zzz {

    /* renamed from: a */
    public final TreeMap f13961a = new TreeMap();

    /* renamed from: b */
    public final TreeMap f13962b = new TreeMap();

    public final void zza(String str, int i, zzao zzaoVar, String str2) {
        TreeMap treeMap;
        if ("create".equals(str2)) {
            treeMap = this.f13962b;
        } else if ("edit".equals(str2)) {
            treeMap = this.f13961a;
        } else {
            throw new IllegalStateException("Unknown callback type: ".concat(String.valueOf(str2)));
        }
        if (treeMap.containsKey(Integer.valueOf(i))) {
            i = ((Integer) treeMap.lastKey()).intValue() + 1;
        }
        treeMap.put(Integer.valueOf(i), zzaoVar);
    }

    public final void zzb(zzg zzgVar, zzab zzabVar) {
        int i;
        zzl zzlVar = new zzl(zzabVar);
        TreeMap treeMap = this.f13961a;
        for (Integer num : treeMap.keySet()) {
            zzaa clone = zzabVar.zzb().clone();
            zzap zza = ((zzao) treeMap.get(num)).zza(zzgVar, Collections.singletonList(zzlVar));
            if (zza instanceof zzah) {
                i = zzh.zzb(zza.zzh().doubleValue());
            } else {
                i = -1;
            }
            if (i == 2 || i == -1) {
                zzabVar.zzf(clone);
            }
        }
        TreeMap treeMap2 = this.f13962b;
        Iterator it = treeMap2.keySet().iterator();
        while (it.hasNext()) {
            zzap zza2 = ((zzao) treeMap2.get((Integer) it.next())).zza(zzgVar, Collections.singletonList(zzlVar));
            if (zza2 instanceof zzah) {
                zzh.zzb(zza2.zzh().doubleValue());
            }
        }
    }
}
