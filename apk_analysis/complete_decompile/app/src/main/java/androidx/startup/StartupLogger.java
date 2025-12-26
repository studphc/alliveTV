package androidx.startup;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class StartupLogger {
    /* renamed from: e */
    public static void m1908e(@NonNull String str, @Nullable Throwable th) {
        Log.e("StartupLogger", str, th);
    }

    /* renamed from: i */
    public static void m1909i(@NonNull String str) {
        Log.i("StartupLogger", str);
    }

    /* renamed from: w */
    public static void m1910w(@NonNull String str) {
        Log.w("StartupLogger", str);
    }
}
