package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzdd extends zzbn implements zzde {
    public zzdd() {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzbn
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            int zze = zze();
            parcel2.writeNoException();
            parcel2.writeInt(zze);
        } else {
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Bundle bundle = (Bundle) zzbo.zza(parcel, Bundle.CREATOR);
            long readLong = parcel.readLong();
            zzbo.zzc(parcel);
            zzf(readString, readString2, bundle, readLong);
            parcel2.writeNoException();
        }
        return true;
    }
}
