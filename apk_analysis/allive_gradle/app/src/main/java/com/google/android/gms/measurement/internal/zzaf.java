package com.google.android.gms.measurement.internal;

import android.os.Looper;

/* loaded from: classes.dex */
public final class zzaf {
    public static final boolean zza() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }
}
