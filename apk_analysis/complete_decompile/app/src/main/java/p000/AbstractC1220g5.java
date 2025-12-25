package p000;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;

/* renamed from: g5 */
/* loaded from: classes.dex */
public abstract class AbstractC1220g5 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m4917a(@NonNull Activity activity) {
        return activity.isLaunchedFromBubble();
    }

    @DoNotInline
    @SuppressLint({"BanUncheckedReflection"})
    /* renamed from: b */
    public static boolean m4918b(Activity activity, String str) {
        try {
            return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }
}
