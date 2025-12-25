package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzbp extends zzbm implements zzbr {
    @Override // com.google.android.gms.internal.measurement.zzbr
    public final Bundle zze(Bundle bundle) {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        Parcel zzb = zzb(1, zza);
        Bundle bundle2 = (Bundle) zzbo.zza(zzb, Bundle.CREATOR);
        zzb.recycle();
        return bundle2;
    }
}
