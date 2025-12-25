package com.google.android.gms.common.config;

import android.os.Binder;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import p000.d93;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class GservicesValue<T> {

    /* renamed from: b */
    public static final Object f13312b = new Object();

    /* renamed from: a */
    public Object f13313a = null;

    @NonNull
    protected final String zza;

    @NonNull
    protected final Object zzb;

    public GservicesValue(@NonNull String str, @NonNull Object obj) {
        this.zza = str;
        this.zzb = obj;
    }

    @KeepForSdk
    public static boolean isInitialized() {
        synchronized (f13312b) {
        }
        return false;
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Float> value(@NonNull String str, @NonNull Float f) {
        return new d93(f, 3, str);
    }

    @NonNull
    @KeepForSdk
    public final T get() {
        T t;
        T t2 = (T) this.f13313a;
        if (t2 != null) {
            return t2;
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        Object obj = f13312b;
        synchronized (obj) {
        }
        synchronized (obj) {
            try {
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        try {
            t = (T) zza(this.zza);
        } catch (SecurityException unused) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                t = (T) zza(this.zza);
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return t;
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public final T getBinderSafe() {
        return get();
    }

    @KeepForSdk
    @VisibleForTesting
    public void override(@NonNull T t) {
        Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
        this.f13313a = t;
        Object obj = f13312b;
        synchronized (obj) {
            synchronized (obj) {
            }
        }
    }

    @KeepForSdk
    @VisibleForTesting
    public void resetOverride() {
        this.f13313a = null;
    }

    @NonNull
    public abstract Object zza(@NonNull String str);

    @NonNull
    @KeepForSdk
    public static GservicesValue<Integer> value(@NonNull String str, @NonNull Integer num) {
        return new d93(num, 2, str);
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Long> value(@NonNull String str, @NonNull Long l) {
        return new d93(l, 1, str);
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<String> value(@NonNull String str, @NonNull String str2) {
        return new d93(str2, 4, str);
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Boolean> value(@NonNull String str, boolean z) {
        return new d93(Boolean.valueOf(z), 0, str);
    }
}
