package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzhf {

    @NonNull
    public final String zza;

    @NonNull
    public final String zzb;
    public final long zzc;

    @NonNull
    public final Bundle zzd;

    public zzhf(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle, long j) {
        this.zza = str;
        this.zzb = str2;
        this.zzd = bundle;
        this.zzc = j;
    }

    public static zzhf zzb(zzbh zzbhVar) {
        return new zzhf(zzbhVar.zza, zzbhVar.zzc, zzbhVar.zzb.zzc(), zzbhVar.zzd);
    }

    public final String toString() {
        return "origin=" + this.zzb + ",name=" + this.zza + ",params=" + this.zzd.toString();
    }

    public final zzbh zza() {
        return new zzbh(this.zza, new zzbf(new Bundle(this.zzd)), this.zzb, this.zzc);
    }
}
