package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import androidx.annotation.NonNull;
import com.google.android.apps.common.proguard.SideEffectFree;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public final class DeviceProperties {

    /* renamed from: a */
    public static Boolean f13636a;

    /* renamed from: b */
    public static Boolean f13637b;

    /* renamed from: c */
    public static Boolean f13638c;

    /* renamed from: d */
    public static Boolean f13639d;

    /* renamed from: e */
    public static Boolean f13640e;

    /* renamed from: f */
    public static Boolean f13641f;

    /* renamed from: g */
    public static Boolean f13642g;

    /* renamed from: h */
    public static Boolean f13643h;

    /* renamed from: i */
    public static Boolean f13644i;

    /* renamed from: j */
    public static Boolean f13645j;

    /* renamed from: k */
    public static Boolean f13646k;

    /* renamed from: l */
    public static Boolean f13647l;

    /* renamed from: m */
    public static Boolean f13648m;

    /* renamed from: n */
    public static Boolean f13649n;

    @KeepForSdk
    public static boolean isAuto(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f13645j == null) {
            boolean z = false;
            if (PlatformVersion.isAtLeastO() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z = true;
            }
            f13645j = Boolean.valueOf(z);
        }
        return f13645j.booleanValue();
    }

    @KeepForSdk
    public static boolean isBstar(@NonNull Context context) {
        if (f13648m == null) {
            boolean z = false;
            if (PlatformVersion.isAtLeastR() && context.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE")) {
                z = true;
            }
            f13648m = Boolean.valueOf(z);
        }
        return f13648m.booleanValue();
    }

    @KeepForSdk
    public static boolean isFoldable(@NonNull Context context) {
        if (f13638c == null) {
            boolean z = false;
            if (PlatformVersion.isAtLeastR() && context.getPackageManager().hasSystemFeature("android.hardware.sensor.hinge_angle")) {
                z = true;
            }
            f13638c = Boolean.valueOf(z);
        }
        return f13638c.booleanValue();
    }

    @KeepForSdk
    public static boolean isLatchsky(@NonNull Context context) {
        if (f13642g == null) {
            PackageManager packageManager = context.getPackageManager();
            boolean z = false;
            if (packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services")) {
                z = true;
            }
            f13642g = Boolean.valueOf(z);
        }
        return f13642g.booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006c, code lost:
    
        if (isXr(r4) == false) goto L32;
     */
    @KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isPhone(@NonNull Context context) {
        if (f13636a == null) {
            boolean z = true;
            if (!isFoldable(context)) {
                if (!isTablet(context) && !isWearable(context) && !zzb(context)) {
                    if (f13644i == null) {
                        f13644i = Boolean.valueOf(context.getPackageManager().hasSystemFeature("org.chromium.arc"));
                    }
                    if (!f13644i.booleanValue() && !isAuto(context) && !isTv(context)) {
                        if (f13647l == null) {
                            f13647l = Boolean.valueOf(context.getPackageManager().hasSystemFeature("com.google.android.feature.AMATI_EXPERIENCE"));
                        }
                        if (!f13647l.booleanValue()) {
                            if (!isBstar(context)) {
                            }
                        }
                    }
                }
                z = false;
            }
            f13636a = Boolean.valueOf(z);
        }
        return f13636a.booleanValue();
    }

    @KeepForSdk
    public static boolean isSevenInchTablet(@NonNull Context context) {
        return zzc(context.getResources());
    }

    @KeepForSdk
    @TargetApi(21)
    public static boolean isSidewinder(@NonNull Context context) {
        return zza(context);
    }

    @KeepForSdk
    public static boolean isTablet(@NonNull Context context) {
        return isTablet(context.getResources());
    }

    @KeepForSdk
    public static boolean isTv(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f13646k == null) {
            boolean z = true;
            if (!packageManager.hasSystemFeature("com.google.android.tv") && !packageManager.hasSystemFeature("android.hardware.type.television") && !packageManager.hasSystemFeature("android.software.leanback") && !packageManager.hasSystemFeature("com.google.android.feature.AMATI_EXPERIENCE")) {
                z = false;
            }
            f13646k = Boolean.valueOf(z);
        }
        return f13646k.booleanValue();
    }

    @KeepForSdk
    public static boolean isUserBuild() {
        int i = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        return "user".equals(Build.TYPE);
    }

    @SideEffectFree
    @KeepForSdk
    @TargetApi(20)
    public static boolean isWearable(@NonNull Context context) {
        return zzd(context.getPackageManager());
    }

    @KeepForSdk
    @TargetApi(26)
    public static boolean isWearableWithoutPlayStore(@NonNull Context context) {
        if (!isWearable(context) || PlatformVersion.isAtLeastN()) {
            if (zza(context)) {
                if (!PlatformVersion.isAtLeastO() || PlatformVersion.isAtLeastR()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    @KeepForSdk
    public static boolean isXr(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f13649n == null) {
            f13649n = Boolean.valueOf(packageManager.hasSystemFeature("android.software.xr.immersive"));
        }
        return f13649n.booleanValue();
    }

    @TargetApi(21)
    public static boolean zza(@NonNull Context context) {
        if (f13641f == null) {
            f13641f = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f13641f.booleanValue();
    }

    public static boolean zzb(@NonNull Context context) {
        if (f13643h == null) {
            boolean z = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z = false;
            }
            f13643h = Boolean.valueOf(z);
        }
        return f13643h.booleanValue();
    }

    public static boolean zzc(@NonNull Resources resources) {
        boolean z = false;
        if (resources == null) {
            return false;
        }
        if (f13639d == null) {
            Configuration configuration = resources.getConfiguration();
            if ((configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600) {
                z = true;
            }
            f13639d = Boolean.valueOf(z);
        }
        return f13639d.booleanValue();
    }

    @SideEffectFree
    @TargetApi(20)
    public static boolean zzd(@NonNull PackageManager packageManager) {
        if (f13640e == null) {
            f13640e = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return f13640e.booleanValue();
    }

    @KeepForSdk
    public static boolean isTablet(@NonNull Resources resources) {
        if (resources == null) {
            return false;
        }
        if (f13637b == null) {
            f13637b = Boolean.valueOf((resources.getConfiguration().screenLayout & 15) > 3 || zzc(resources));
        }
        return f13637b.booleanValue();
    }
}
