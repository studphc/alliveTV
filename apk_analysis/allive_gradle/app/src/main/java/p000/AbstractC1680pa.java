package p000;

import android.app.AppOpsManager;
import android.content.Context;
import androidx.annotation.DoNotInline;

/* renamed from: pa */
/* loaded from: classes.dex */
public abstract class AbstractC1680pa {
    @DoNotInline
    /* renamed from: a */
    public static <T> T m6894a(Context context, Class<T> cls) {
        return (T) context.getSystemService(cls);
    }

    @DoNotInline
    /* renamed from: b */
    public static int m6895b(AppOpsManager appOpsManager, String str, String str2) {
        return appOpsManager.noteProxyOp(str, str2);
    }

    @DoNotInline
    /* renamed from: c */
    public static int m6896c(AppOpsManager appOpsManager, String str, String str2) {
        return appOpsManager.noteProxyOpNoThrow(str, str2);
    }

    @DoNotInline
    /* renamed from: d */
    public static String m6897d(String str) {
        return AppOpsManager.permissionToOp(str);
    }
}
