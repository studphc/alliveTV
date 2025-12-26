package com.google.android.gms.common.util;

import android.os.StrictMode;
import p000.x93;

/* loaded from: classes.dex */
public final class zzc {
    public static StrictMode.VmPolicy zza() {
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (PlatformVersion.isAtLeastS()) {
            StrictMode.setVmPolicy(x93.m8153a(new StrictMode.VmPolicy.Builder(vmPolicy)).build());
        }
        return vmPolicy;
    }
}
