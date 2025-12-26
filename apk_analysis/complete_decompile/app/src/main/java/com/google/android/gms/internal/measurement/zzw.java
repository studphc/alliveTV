package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzw extends zzai {

    /* renamed from: a */
    public final zzj f13959a;

    /* renamed from: b */
    public final HashMap f13960b;

    public zzw(zzj zzjVar) {
        super("require");
        this.f13960b = new HashMap();
        this.f13959a = zzjVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzap zza(zzg zzgVar, List list) {
        zzap zzapVar;
        zzh.zzh("require", 1, list);
        String zzi = zzgVar.zzb((zzap) list.get(0)).zzi();
        HashMap hashMap = this.f13960b;
        if (hashMap.containsKey(zzi)) {
            return (zzap) hashMap.get(zzi);
        }
        HashMap hashMap2 = this.f13959a.f13826a;
        if (hashMap2.containsKey(zzi)) {
            try {
                zzapVar = (zzap) ((Callable) hashMap2.get(zzi)).call();
            } catch (Exception unused) {
                throw new IllegalStateException("Failed to create API implementation: ".concat(String.valueOf(zzi)));
            }
        } else {
            zzapVar = zzap.zzf;
        }
        if (zzapVar instanceof zzai) {
            hashMap.put(zzi, (zzai) zzapVar);
        }
        return zzapVar;
    }
}
