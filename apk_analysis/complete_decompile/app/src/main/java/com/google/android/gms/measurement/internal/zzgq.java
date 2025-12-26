package com.google.android.gms.measurement.internal;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzgq extends com.google.android.gms.internal.measurement.zzbn implements zzgr {
    public zzgq() {
        super("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbn
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 2) {
            zzpe zzpeVar = (zzpe) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzpe.CREATOR);
            com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
            zze(zzpeVar);
            return true;
        }
        return false;
    }
}
