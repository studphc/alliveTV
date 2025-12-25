package p000;

import android.app.AppOpsManager;
import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: qa */
/* loaded from: classes.dex */
public abstract class AbstractC1717qa {
    @DoNotInline
    /* renamed from: a */
    public static int m7008a(@Nullable AppOpsManager appOpsManager, @NonNull String str, int i, @NonNull String str2) {
        if (appOpsManager == null) {
            return 1;
        }
        return appOpsManager.checkOpNoThrow(str, i, str2);
    }

    @NonNull
    @DoNotInline
    /* renamed from: b */
    public static String m7009b(@NonNull Context context) {
        return context.getOpPackageName();
    }

    @Nullable
    @DoNotInline
    /* renamed from: c */
    public static AppOpsManager m7010c(@NonNull Context context) {
        return (AppOpsManager) context.getSystemService(AppOpsManager.class);
    }
}
