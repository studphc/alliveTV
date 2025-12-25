package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzgj extends com.google.android.gms.internal.measurement.zzbm implements zzgl {
    public zzgj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final void zzA(zzr zzrVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzrVar);
        zzc(25, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final void zzB(zzqb zzqbVar, zzr zzrVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzqbVar);
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzrVar);
        zzc(2, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final void zzC(zzr zzrVar, zzag zzagVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzrVar);
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzagVar);
        zzc(30, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final byte[] zzD(zzbh zzbhVar, String str) {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzbhVar);
        zza.writeString(str);
        Parcel zzb = zzb(9, zza);
        byte[] createByteArray = zzb.createByteArray();
        zzb.recycle();
        return createByteArray;
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final zzap zze(zzr zzrVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzrVar);
        Parcel zzb = zzb(21, zza);
        zzap zzapVar = (zzap) com.google.android.gms.internal.measurement.zzbo.zza(zzb, zzap.CREATOR);
        zzb.recycle();
        return zzapVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final String zzf(zzr zzrVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzrVar);
        Parcel zzb = zzb(11, zza);
        String readString = zzb.readString();
        zzb.recycle();
        return readString;
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final List zzg(zzr zzrVar, Bundle bundle) {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final List zzh(zzr zzrVar, boolean z) {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzrVar);
        zza.writeInt(z ? 1 : 0);
        Parcel zzb = zzb(7, zza);
        ArrayList createTypedArrayList = zzb.createTypedArrayList(zzqb.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final List zzi(String str, String str2, zzr zzrVar) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzrVar);
        Parcel zzb = zzb(16, zza);
        ArrayList createTypedArrayList = zzb.createTypedArrayList(zzai.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final List zzj(String str, String str2, String str3) {
        Parcel zza = zza();
        zza.writeString(null);
        zza.writeString(str2);
        zza.writeString(str3);
        Parcel zzb = zzb(17, zza);
        ArrayList createTypedArrayList = zzb.createTypedArrayList(zzai.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final List zzk(String str, String str2, boolean z, zzr zzrVar) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        ClassLoader classLoader = com.google.android.gms.internal.measurement.zzbo.f13794a;
        zza.writeInt(z ? 1 : 0);
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzrVar);
        Parcel zzb = zzb(14, zza);
        ArrayList createTypedArrayList = zzb.createTypedArrayList(zzqb.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final List zzl(String str, String str2, String str3, boolean z) {
        Parcel zza = zza();
        zza.writeString(null);
        zza.writeString(str2);
        zza.writeString(str3);
        ClassLoader classLoader = com.google.android.gms.internal.measurement.zzbo.f13794a;
        zza.writeInt(z ? 1 : 0);
        Parcel zzb = zzb(15, zza);
        ArrayList createTypedArrayList = zzb.createTypedArrayList(zzqb.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final void zzm(zzr zzrVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzrVar);
        zzc(27, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final void zzn(zzr zzrVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzrVar);
        zzc(4, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final void zzo(zzr zzrVar, zzpc zzpcVar, zzgr zzgrVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzrVar);
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzpcVar);
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzgrVar);
        zzc(29, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final void zzp(zzbh zzbhVar, zzr zzrVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzbhVar);
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzrVar);
        zzc(1, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final void zzq(zzbh zzbhVar, String str, String str2) {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final void zzr(zzr zzrVar, Bundle bundle, zzgo zzgoVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzrVar);
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, bundle);
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzgoVar);
        zzc(31, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final void zzs(zzr zzrVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzrVar);
        zzc(18, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final void zzt(zzai zzaiVar, zzr zzrVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzaiVar);
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzrVar);
        zzc(12, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final void zzu(zzai zzaiVar) {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final void zzv(zzr zzrVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzrVar);
        zzc(20, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final void zzw(long j, String str, String str2, String str3) {
        Parcel zza = zza();
        zza.writeLong(j);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        zzc(10, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final void zzx(Bundle bundle, zzr zzrVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, bundle);
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzrVar);
        zzc(19, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final void zzy(zzr zzrVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzrVar);
        zzc(26, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final void zzz(zzr zzrVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, zzrVar);
        zzc(6, zza);
    }
}
