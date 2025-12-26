package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import com.google.common.base.Optional;

/* loaded from: classes.dex */
public final class zzjw {

    /* renamed from: a */
    public static volatile Optional f13848a = Optional.absent();

    /* renamed from: b */
    public static final Object f13849b = new Object();

    /* JADX WARN: Can't wrap try/catch for region: R(11:18|(8:20|(1:22)(1:31)|23|(1:25)|27|28|29|30)|32|33|34|35|(1:37)|27|28|29|30) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0077, code lost:
    
        if ("com.google.android.gms".equals(r0.packageName) != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean zza(Context context, Uri uri) {
        int i;
        String authority = uri.getAuthority();
        boolean z = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            Log.e("PhenotypeClientHelper", String.valueOf(authority).concat(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported."));
            return false;
        }
        if (f13848a.isPresent()) {
            return ((Boolean) f13848a.get()).booleanValue();
        }
        synchronized (f13849b) {
            try {
                if (f13848a.isPresent()) {
                    return ((Boolean) f13848a.get()).booleanValue();
                }
                if (!"com.google.android.gms".equals(context.getPackageName())) {
                    PackageManager packageManager = context.getPackageManager();
                    if (Build.VERSION.SDK_INT < 29) {
                        i = 0;
                    } else {
                        i = 268435456;
                    }
                    ProviderInfo resolveContentProvider = packageManager.resolveContentProvider("com.google.android.gms.phenotype", i);
                    if (resolveContentProvider != null) {
                    }
                    f13848a = Optional.m3770of(Boolean.valueOf(z));
                    return ((Boolean) f13848a.get()).booleanValue();
                }
                if ((context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & TsExtractor.TS_STREAM_TYPE_AC3) != 0) {
                    z = true;
                }
                f13848a = Optional.m3770of(Boolean.valueOf(z));
                return ((Boolean) f13848a.get()).booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
