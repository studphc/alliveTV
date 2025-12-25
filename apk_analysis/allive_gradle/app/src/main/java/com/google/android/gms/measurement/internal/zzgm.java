package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import java.util.List;

/* loaded from: classes.dex */
public final class zzgm extends com.google.android.gms.internal.measurement.zzbm implements zzgo {
    @Override // com.google.android.gms.measurement.internal.zzgo
    public final void zze(List list) {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzd(2, zza);
    }
}
