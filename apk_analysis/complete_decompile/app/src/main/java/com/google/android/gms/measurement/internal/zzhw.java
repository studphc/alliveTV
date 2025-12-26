package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

/* loaded from: classes.dex */
public final class zzhw {

    /* renamed from: a */
    public final zzio f14224a;

    public zzhw(zzpv zzpvVar) {
        this.f14224a = zzpvVar.f14380l;
    }

    /* renamed from: a */
    public final boolean m3535a() {
        zzio zzioVar = this.f14224a;
        try {
            PackageManagerWrapper packageManager = Wrappers.packageManager(zzioVar.zzaT());
            if (packageManager == null) {
                zzioVar.zzaW().zzj().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                return false;
            }
            if (packageManager.getPackageInfo("com.android.vending", 128).versionCode < 80837300) {
                return false;
            }
            return true;
        } catch (Exception e) {
            zzioVar.zzaW().zzj().zzb("Failed to retrieve Play Store version for Install Referrer", e);
            return false;
        }
    }
}
