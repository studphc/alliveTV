package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.common.zzi;
import com.google.android.gms.internal.common.zzj;
import com.google.android.gms.internal.common.zzl;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class ProviderInstaller {

    @NonNull
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";

    /* renamed from: a */
    public static final GoogleApiAvailabilityLight f14414a = GoogleApiAvailabilityLight.getInstance();

    /* renamed from: b */
    public static final Object f14415b = new Object();

    /* renamed from: c */
    public static Method f14416c = null;

    /* renamed from: d */
    public static boolean f14417d = false;

    /* loaded from: classes.dex */
    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, @Nullable Intent intent);

        void onProviderInstalled();
    }

    /* renamed from: a */
    public static void m3747a(Context context, String str) {
        String th;
        try {
            if (f14416c == null) {
                f14416c = context.getClassLoader().loadClass(str).getMethod("insertProvider", Context.class);
            }
            f14416c.invoke(null, context);
        } catch (Exception e) {
            Throwable cause = e.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                if (cause == null) {
                    th = e.toString();
                } else {
                    th = cause.toString();
                }
                Log.e("ProviderInstaller", "Failed to install provider: ".concat(String.valueOf(th)));
            }
            throw new GooglePlayServicesNotAvailableException(8);
        }
    }

    public static void installIfNeeded(@NonNull Context context) {
        Context context2;
        Preconditions.checkNotNull(context, "Context must not be null");
        f14414a.verifyGooglePlayServicesIsAvailable(context, 11925000);
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (f14415b) {
            Context context3 = null;
            if (!f14417d) {
                try {
                    context2 = DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.providerinstaller.dynamite").getModuleContext();
                } catch (DynamiteModule.LoadingException e) {
                    Log.w("ProviderInstaller", "Failed to load providerinstaller module: ".concat(String.valueOf(e.getMessage())));
                    context2 = null;
                }
                if (context2 != null) {
                    m3747a(context2, "com.google.android.gms.providerinstaller.ProviderInstallerImpl");
                    return;
                }
            }
            boolean z = f14417d;
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext != null) {
                f14417d = true;
                if (!z) {
                    try {
                        zzl.zzb("com.google.android.gms.common.security.ProviderInstallerImpl", "reportRequestStats2", remoteContext.getClassLoader(), zzj.zzb(Context.class, context), zzi.zza(uptimeMillis), zzi.zza(SystemClock.uptimeMillis()));
                    } catch (Exception e2) {
                        Log.w("ProviderInstaller", "Failed to report request stats: ".concat(e2.toString()));
                    }
                }
                context3 = remoteContext;
            }
            if (context3 != null) {
                m3747a(context3, "com.google.android.gms.common.security.ProviderInstallerImpl");
            } else {
                Log.e("ProviderInstaller", "Failed to get remote context");
                throw new GooglePlayServicesNotAvailableException(8);
            }
        }
    }

    public static void installIfNeededAsync(@NonNull Context context, @NonNull ProviderInstallListener providerInstallListener) {
        Preconditions.checkNotNull(context, "Context must not be null");
        Preconditions.checkNotNull(providerInstallListener, "Listener must not be null");
        Preconditions.checkMainThread("Must be called on the UI thread");
        new AsyncTaskC0831a(context, providerInstallListener).execute(new Void[0]);
    }
}
