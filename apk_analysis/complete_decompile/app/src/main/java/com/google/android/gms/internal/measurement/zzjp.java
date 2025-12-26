package com.google.android.gms.internal.measurement;

import android.os.Binder;

/* loaded from: classes.dex */
public final /* synthetic */ class zzjp {
    public static Object zza(zzjq zzjqVar) {
        try {
            return zzjqVar.zza();
        } catch (SecurityException unused) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzjqVar.zza();
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }
}
