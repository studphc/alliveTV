package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public abstract class zzbq extends zzbn implements zzbr {
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.internal.measurement.zzbr, com.google.android.gms.internal.measurement.zzbm] */
    public static zzbr zzb(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
        if (queryLocalInterface instanceof zzbr) {
            return (zzbr) queryLocalInterface;
        }
        return new zzbm(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }
}
