package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.wrappers.Wrappers;

/* loaded from: classes.dex */
public final class zzah {

    /* renamed from: a */
    public static final Object f13513a = new Object();

    /* renamed from: b */
    public static boolean f13514b;

    /* renamed from: c */
    public static String f13515c;

    /* renamed from: d */
    public static int f13516d;

    /* renamed from: a */
    public static void m3166a(Context context) {
        Bundle bundle;
        synchronized (f13513a) {
            try {
                if (f13514b) {
                    return;
                }
                f13514b = true;
                try {
                    bundle = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e);
                }
                if (bundle == null) {
                    return;
                }
                f13515c = bundle.getString("com.google.app.id");
                f13516d = bundle.getInt("com.google.android.gms.version");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int zza(Context context) {
        m3166a(context);
        return f13516d;
    }

    @Nullable
    public static String zzb(Context context) {
        m3166a(context);
        return f13515c;
    }
}
