package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public abstract class zze extends zzb implements zzf {
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.internal.ads_identifier.zza, com.google.android.gms.internal.ads_identifier.zzf] */
    public static zzf zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        if (queryLocalInterface instanceof zzf) {
            return (zzf) queryLocalInterface;
        }
        return new zza(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }
}
