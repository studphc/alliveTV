package com.google.android.gms.common.wrappers;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

@KeepForSdk
/* loaded from: classes.dex */
public class InstantApps {

    /* renamed from: a */
    public static Context f13674a;

    /* renamed from: b */
    public static Boolean f13675b;

    @KeepForSdk
    public static synchronized boolean isInstantApp(@NonNull Context context) {
        boolean isInstantApp;
        Boolean bool;
        synchronized (InstantApps.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = f13674a;
            if (context2 != null && (bool = f13675b) != null && context2 == applicationContext) {
                return bool.booleanValue();
            }
            f13675b = null;
            if (PlatformVersion.isAtLeastO()) {
                isInstantApp = applicationContext.getPackageManager().isInstantApp();
                f13675b = Boolean.valueOf(isInstantApp);
            } else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    f13675b = Boolean.TRUE;
                } catch (ClassNotFoundException unused) {
                    f13675b = Boolean.FALSE;
                }
            }
            f13674a = applicationContext;
            return f13675b.booleanValue();
        }
    }
}
