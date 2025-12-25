package com.google.android.gms.common.logging;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

@KeepForSdk
/* loaded from: classes.dex */
public class Logger {

    /* renamed from: a */
    public final String f13539a;

    /* renamed from: b */
    public final String f13540b;

    /* renamed from: c */
    public final int f13541c;

    @KeepForSdk
    public Logger(@NonNull String str, @NonNull String... strArr) {
        String sb;
        if (strArr.length == 0) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (String str2 : strArr) {
                if (sb2.length() > 1) {
                    sb2.append(",");
                }
                sb2.append(str2);
            }
            sb2.append("] ");
            sb = sb2.toString();
        }
        this.f13540b = sb;
        this.f13539a = str;
        new GmsLogger(str);
        int i = 2;
        while (i <= 7 && !Log.isLoggable(this.f13539a, i)) {
            i++;
        }
        this.f13541c = i;
    }

    @KeepForSdk
    /* renamed from: d */
    public void m3168d(@NonNull String str, @NonNull Object... objArr) {
        if (isLoggable(3)) {
            Log.d(this.f13539a, format(str, objArr));
        }
    }

    @KeepForSdk
    /* renamed from: e */
    public void m3169e(@NonNull String str, @NonNull Throwable th, @NonNull Object... objArr) {
        Log.e(this.f13539a, format(str, objArr), th);
    }

    @NonNull
    @KeepForSdk
    public String format(@NonNull String str, @NonNull Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f13540b.concat(str);
    }

    @NonNull
    @KeepForSdk
    public String getTag() {
        return this.f13539a;
    }

    @KeepForSdk
    /* renamed from: i */
    public void m3171i(@NonNull String str, @NonNull Object... objArr) {
        Log.i(this.f13539a, format(str, objArr));
    }

    @KeepForSdk
    public boolean isLoggable(int i) {
        return this.f13541c <= i;
    }

    @KeepForSdk
    /* renamed from: v */
    public void m3172v(@NonNull String str, @NonNull Throwable th, @NonNull Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.f13539a, format(str, objArr), th);
        }
    }

    @KeepForSdk
    /* renamed from: w */
    public void m3174w(@NonNull String str, @NonNull Object... objArr) {
        Log.w(this.f13539a, format(str, objArr));
    }

    @KeepForSdk
    public void wtf(@NonNull String str, @NonNull Throwable th, @NonNull Object... objArr) {
        Log.wtf(this.f13539a, format(str, objArr), th);
    }

    @KeepForSdk
    /* renamed from: e */
    public void m3170e(@NonNull String str, @NonNull Object... objArr) {
        Log.e(this.f13539a, format(str, objArr));
    }

    @KeepForSdk
    public void wtf(@NonNull Throwable th) {
        Log.wtf(this.f13539a, th);
    }

    @KeepForSdk
    /* renamed from: v */
    public void m3173v(@NonNull String str, @NonNull Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.f13539a, format(str, objArr));
        }
    }
}
