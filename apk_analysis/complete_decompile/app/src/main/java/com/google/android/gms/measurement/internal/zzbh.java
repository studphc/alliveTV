package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "EventParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzbh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbh> CREATOR = new zzbi();

    @SafeParcelable.Field(m3159id = 2)
    public final String zza;

    @SafeParcelable.Field(m3159id = 3)
    public final zzbf zzb;

    @SafeParcelable.Field(m3159id = 4)
    public final String zzc;

    @SafeParcelable.Field(m3159id = 5)
    public final long zzd;

    public zzbh(zzbh zzbhVar, long j) {
        Preconditions.checkNotNull(zzbhVar);
        this.zza = zzbhVar.zza;
        this.zzb = zzbhVar.zzb;
        this.zzc = zzbhVar.zzc;
        this.zzd = j;
    }

    public final String toString() {
        return "origin=" + this.zzc + ",name=" + this.zza + ",params=" + String.valueOf(this.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzbi.m3520a(this, parcel, i);
    }

    @SafeParcelable.Constructor
    public zzbh(@SafeParcelable.Param(m3160id = 2) String str, @SafeParcelable.Param(m3160id = 3) zzbf zzbfVar, @SafeParcelable.Param(m3160id = 4) String str2, @SafeParcelable.Param(m3160id = 5) long j) {
        this.zza = str;
        this.zzb = zzbfVar;
        this.zzc = str2;
        this.zzd = j;
    }
}
