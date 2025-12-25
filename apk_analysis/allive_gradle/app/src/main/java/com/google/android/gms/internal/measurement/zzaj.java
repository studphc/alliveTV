package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p000.AbstractC1726qj;
import p000.q93;

/* loaded from: classes.dex */
public final /* synthetic */ class zzaj {
    public static zzap zza(zzal zzalVar, zzap zzapVar, zzg zzgVar, List list) {
        if (zzalVar.zzt(zzapVar.zzi())) {
            zzap zzf = zzalVar.zzf(zzapVar.zzi());
            if (zzf instanceof zzai) {
                return ((zzai) zzf).zza(zzgVar, list);
            }
            throw new IllegalArgumentException(AbstractC1726qj.m7057m(zzapVar.zzi(), " is not a function"));
        }
        if ("hasOwnProperty".equals(zzapVar.zzi())) {
            zzh.zzh("hasOwnProperty", 1, list);
            if (zzalVar.zzt(zzgVar.zzb((zzap) list.get(0)).zzi())) {
                return zzap.zzk;
            }
            return zzap.zzl;
        }
        throw new IllegalArgumentException(AbstractC1726qj.m7038C("Object has no function ", zzapVar.zzi()));
    }

    public static Iterator zzb(Map map) {
        return new q93(map.keySet().iterator());
    }
}
