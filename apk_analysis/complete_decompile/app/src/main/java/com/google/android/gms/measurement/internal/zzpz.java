package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzpz {

    /* renamed from: a */
    public final long f14396a;

    /* renamed from: b */
    public final com.google.android.gms.internal.measurement.zzhv f14397b;

    /* renamed from: c */
    public final String f14398c;

    /* renamed from: d */
    public final HashMap f14399d;

    /* renamed from: e */
    public final zzmf f14400e;

    /* renamed from: f */
    public final long f14401f;

    /* renamed from: g */
    public final long f14402g;

    /* renamed from: h */
    public final int f14403h;

    public /* synthetic */ zzpz(long j, com.google.android.gms.internal.measurement.zzhv zzhvVar, String str, HashMap hashMap, zzmf zzmfVar, long j2, long j3, int i) {
        this.f14396a = j;
        this.f14397b = zzhvVar;
        this.f14398c = str;
        this.f14399d = hashMap;
        this.f14400e = zzmfVar;
        this.f14401f = j2;
        this.f14402g = j3;
        this.f14403h = i;
    }

    public final int zza() {
        return this.f14403h;
    }

    public final long zzb() {
        return this.f14402g;
    }

    public final long zzc() {
        return this.f14396a;
    }

    public final zzmf zzd() {
        return this.f14400e;
    }

    public final zzpa zze() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.f14399d.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        byte[] zzcd = this.f14397b.zzcd();
        int zza = this.f14400e.zza();
        return new zzpa(this.f14396a, zzcd, this.f14398c, bundle, zza, this.f14401f, "");
    }

    public final zzph zzf() {
        return new zzph(this.f14398c, this.f14399d, this.f14400e, null);
    }

    @Nullable
    public final com.google.android.gms.internal.measurement.zzhv zzg() {
        return this.f14397b;
    }

    public final String zzh() {
        return this.f14398c;
    }
}
