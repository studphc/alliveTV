package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzb;

/* loaded from: classes.dex */
public abstract class zzaf extends zzb implements zzag {
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.internal.common.zza, com.google.android.gms.common.internal.zzag] */
    public static zzag zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        if (queryLocalInterface instanceof zzag) {
            return (zzag) queryLocalInterface;
        }
        return new zza(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }
}
