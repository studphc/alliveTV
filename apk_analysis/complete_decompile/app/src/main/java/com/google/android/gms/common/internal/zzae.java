package com.google.android.gms.common.internal;

import android.os.Parcel;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;

/* loaded from: classes.dex */
public final class zzae extends zza implements zzag {
    @Override // com.google.android.gms.common.internal.zzag
    public final zzq zze(com.google.android.gms.common.zzo zzoVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zzc(zza, zzoVar);
        Parcel zzB = zzB(6, zza);
        zzq zzqVar = (zzq) com.google.android.gms.internal.common.zzc.zza(zzB, zzq.CREATOR);
        zzB.recycle();
        return zzqVar;
    }

    @Override // com.google.android.gms.common.internal.zzag
    public final zzq zzf(com.google.android.gms.common.zzo zzoVar) {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zzc(zza, zzoVar);
        Parcel zzB = zzB(8, zza);
        zzq zzqVar = (zzq) com.google.android.gms.internal.common.zzc.zza(zzB, zzq.CREATOR);
        zzB.recycle();
        return zzqVar;
    }

    @Override // com.google.android.gms.common.internal.zzag
    public final boolean zzg() {
        Parcel zzB = zzB(9, zza());
        boolean zzf = com.google.android.gms.internal.common.zzc.zzf(zzB);
        zzB.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.common.internal.zzag
    public final boolean zzh(zzs zzsVar, IObjectWrapper iObjectWrapper) {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zzc(zza, zzsVar);
        com.google.android.gms.internal.common.zzc.zze(zza, iObjectWrapper);
        Parcel zzB = zzB(5, zza);
        boolean zzf = com.google.android.gms.internal.common.zzc.zzf(zzB);
        zzB.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.common.internal.zzag
    public final boolean zzi() {
        Parcel zzB = zzB(7, zza());
        boolean zzf = com.google.android.gms.internal.common.zzc.zzf(zzB);
        zzB.recycle();
        return zzf;
    }
}
