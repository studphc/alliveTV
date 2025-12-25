package com.google.android.gms.measurement.internal;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzph {

    /* renamed from: a */
    public final String f14354a;

    /* renamed from: b */
    public final Map f14355b;

    /* renamed from: c */
    public final zzmf f14356c;

    /* renamed from: d */
    public final com.google.android.gms.internal.measurement.zzim f14357d;

    public zzph(String str, Map map, zzmf zzmfVar, com.google.android.gms.internal.measurement.zzim zzimVar) {
        this.f14354a = str;
        this.f14355b = map;
        this.f14356c = zzmfVar;
        this.f14357d = zzimVar;
    }

    public final zzmf zza() {
        return this.f14356c;
    }

    public final com.google.android.gms.internal.measurement.zzim zzb() {
        return this.f14357d;
    }

    public final String zzc() {
        return this.f14354a;
    }

    public final Map zzd() {
        Map map = this.f14355b;
        if (map == null) {
            return Collections.emptyMap();
        }
        return map;
    }
}
