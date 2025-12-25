package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p000.AbstractC1680pa;
import p000.AbstractC1717qa;

/* loaded from: classes.dex */
public final class AppOpsManagerCompat {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;

    public static int checkOrNoteProxyOp(@NonNull Context context, int i, @NonNull String str, @NonNull String str2) {
        if (Build.VERSION.SDK_INT >= 29) {
            AppOpsManager m7010c = AbstractC1717qa.m7010c(context);
            int m7008a = AbstractC1717qa.m7008a(m7010c, str, Binder.getCallingUid(), str2);
            if (m7008a != 0) {
                return m7008a;
            }
            return AbstractC1717qa.m7008a(m7010c, str, i, AbstractC1717qa.m7009b(context));
        }
        return noteProxyOpNoThrow(context, str, str2);
    }

    public static int noteOp(@NonNull Context context, @NonNull String str, int i, @NonNull String str2) {
        return ((AppOpsManager) context.getSystemService("appops")).noteOp(str, i, str2);
    }

    public static int noteOpNoThrow(@NonNull Context context, @NonNull String str, int i, @NonNull String str2) {
        return ((AppOpsManager) context.getSystemService("appops")).noteOpNoThrow(str, i, str2);
    }

    public static int noteProxyOp(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        return AbstractC1680pa.m6895b((AppOpsManager) AbstractC1680pa.m6894a(context, AppOpsManager.class), str, str2);
    }

    public static int noteProxyOpNoThrow(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        return AbstractC1680pa.m6896c((AppOpsManager) AbstractC1680pa.m6894a(context, AppOpsManager.class), str, str2);
    }

    @Nullable
    public static String permissionToOp(@NonNull String str) {
        return AbstractC1680pa.m6897d(str);
    }
}
