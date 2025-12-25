package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzc;
import p000.jz2;

/* renamed from: com.google.android.gms.measurement.internal.f */
/* loaded from: classes.dex */
public final class C0797f extends LruCache {

    /* renamed from: j */
    public final /* synthetic */ zzif f14019j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0797f(zzif zzifVar) {
        super(20);
        this.f14019j = zzifVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.collection.LruCache
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        String str = (String) obj;
        Preconditions.checkNotEmpty(str);
        zzif zzifVar = this.f14019j;
        boolean zzx = zzifVar.zzu.zzf().zzx(null, zzgi.zzbn);
        C0797f c0797f = zzifVar.f14232h;
        if (zzx) {
            zzifVar.zzav();
            Preconditions.checkNotEmpty(str);
            jz2 m7844T = zzifVar.zzg.zzj().m7844T(str);
            if (m7844T == null) {
                return null;
            }
            zzifVar.zzu.zzaW().zzj().zzb("Populate EES config from database on cache miss. appId", str);
            zzifVar.m3543f(str, zzifVar.m3540c(str, (byte[]) m7844T.f20698b));
            return (zzc) c0797f.snapshot().get(str);
        }
        zzifVar.zzav();
        Preconditions.checkNotEmpty(str);
        if (!zzifVar.zzs(str)) {
            return null;
        }
        ArrayMap arrayMap = zzifVar.f14230f;
        if (arrayMap.containsKey(str) && arrayMap.get(str) != 0) {
            zzifVar.m3543f(str, (com.google.android.gms.internal.measurement.zzgo) arrayMap.get(str));
        } else {
            zzifVar.m3542e(str);
        }
        return (zzc) c0797f.snapshot().get(str);
    }
}
