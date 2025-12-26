package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteCursor;
import android.os.Build;
import androidx.annotation.NonNull;
import p000.qd2;

/* loaded from: classes.dex */
public final class SQLiteCursorCompat {
    public static void setFillWindowForwardOnly(@NonNull SQLiteCursor sQLiteCursor, boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            qd2.m7031a(sQLiteCursor, z);
        }
    }
}
