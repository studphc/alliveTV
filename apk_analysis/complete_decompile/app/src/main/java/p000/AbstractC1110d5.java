package p000;

import android.app.Activity;
import android.app.SharedElementCallback;
import androidx.annotation.DoNotInline;

/* renamed from: d5 */
/* loaded from: classes.dex */
public abstract class AbstractC1110d5 {
    @DoNotInline
    /* renamed from: a */
    public static void m4522a(Object obj) {
        ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
    }

    @DoNotInline
    /* renamed from: b */
    public static void m4523b(Activity activity, String[] strArr, int i) {
        activity.requestPermissions(strArr, i);
    }

    @DoNotInline
    /* renamed from: c */
    public static boolean m4524c(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
