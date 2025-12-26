package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class zzgn extends com.google.android.gms.internal.measurement.zzbn implements zzgo {
    public zzgn() {
        super("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbn
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 2) {
            ArrayList createTypedArrayList = parcel.createTypedArrayList(zzov.CREATOR);
            com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
            zze(createTypedArrayList);
            return true;
        }
        return false;
    }
}
