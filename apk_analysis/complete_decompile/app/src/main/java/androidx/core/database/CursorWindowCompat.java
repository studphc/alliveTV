package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p000.AbstractC0536ax;

/* loaded from: classes.dex */
public final class CursorWindowCompat {
    @NonNull
    public static CursorWindow create(@Nullable String str, long j) {
        if (Build.VERSION.SDK_INT >= 28) {
            return AbstractC0536ax.m1974a(str, j);
        }
        return new CursorWindow(str);
    }
}
