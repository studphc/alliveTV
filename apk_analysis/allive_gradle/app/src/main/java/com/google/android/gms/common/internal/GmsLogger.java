package com.google.android.gms.common.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public final class GmsLogger {

    /* renamed from: a */
    public final String f13446a;

    /* renamed from: b */
    public final String f13447b;

    @KeepForSdk
    public GmsLogger(@NonNull String str) {
        this(str, null);
    }

    /* renamed from: a */
    public final String m3141a(String str) {
        String str2 = this.f13447b;
        if (str2 == null) {
            return str;
        }
        return str2.concat(str);
    }

    @KeepForSdk
    public boolean canLog(int i) {
        return Log.isLoggable(this.f13446a, i);
    }

    @KeepForSdk
    public boolean canLogPii() {
        return false;
    }

    @KeepForSdk
    /* renamed from: d */
    public void m3142d(@NonNull String str, @NonNull String str2) {
        if (canLog(3)) {
            Log.d(str, m3141a(str2));
        }
    }

    @KeepForSdk
    /* renamed from: e */
    public void m3144e(@NonNull String str, @NonNull String str2) {
        if (canLog(6)) {
            Log.e(str, m3141a(str2));
        }
    }

    @KeepForSdk
    public void efmt(@NonNull String str, @NonNull String str2, @NonNull Object... objArr) {
        if (canLog(6)) {
            String format = String.format(str2, objArr);
            String str3 = this.f13447b;
            if (str3 != null) {
                format = str3.concat(format);
            }
            Log.e(str, format);
        }
    }

    @KeepForSdk
    /* renamed from: i */
    public void m3146i(@NonNull String str, @NonNull String str2) {
        if (canLog(4)) {
            Log.i(str, m3141a(str2));
        }
    }

    @KeepForSdk
    public void pii(@NonNull String str, @NonNull String str2) {
    }

    @KeepForSdk
    /* renamed from: v */
    public void m3148v(@NonNull String str, @NonNull String str2) {
        if (canLog(2)) {
            Log.v(str, m3141a(str2));
        }
    }

    @KeepForSdk
    /* renamed from: w */
    public void m3150w(@NonNull String str, @NonNull String str2) {
        if (canLog(5)) {
            Log.w(str, m3141a(str2));
        }
    }

    @KeepForSdk
    public void wfmt(@NonNull String str, @NonNull String str2, @NonNull Object... objArr) {
        if (canLog(5)) {
            String format = String.format(str2, objArr);
            String str3 = this.f13447b;
            if (str3 != null) {
                format = str3.concat(format);
            }
            Log.w(this.f13446a, format);
        }
    }

    @KeepForSdk
    public void wtf(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (canLog(7)) {
            Log.e(str, m3141a(str2), th);
            Log.wtf(str, m3141a(str2), th);
        }
    }

    @KeepForSdk
    public GmsLogger(@NonNull String str, @Nullable String str2) {
        Preconditions.checkNotNull(str, "log tag cannot be null");
        Preconditions.checkArgument(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f13446a = str;
        this.f13447b = (str2 == null || str2.length() <= 0) ? null : str2;
    }

    @KeepForSdk
    public void pii(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
    }

    @KeepForSdk
    /* renamed from: d */
    public void m3143d(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (canLog(3)) {
            Log.d(str, m3141a(str2), th);
        }
    }

    @KeepForSdk
    /* renamed from: e */
    public void m3145e(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (canLog(6)) {
            Log.e(str, m3141a(str2), th);
        }
    }

    @KeepForSdk
    /* renamed from: i */
    public void m3147i(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (canLog(4)) {
            Log.i(str, m3141a(str2), th);
        }
    }

    @KeepForSdk
    /* renamed from: v */
    public void m3149v(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (canLog(2)) {
            Log.v(str, m3141a(str2), th);
        }
    }

    @KeepForSdk
    /* renamed from: w */
    public void m3151w(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        if (canLog(5)) {
            Log.w(str, m3141a(str2), th);
        }
    }
}
