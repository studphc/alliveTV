package p000;

import android.app.Activity;
import android.app.SharedElementCallback;
import androidx.annotation.DoNotInline;

/* renamed from: b5 */
/* loaded from: classes.dex */
public abstract class AbstractC0545b5 {
    @DoNotInline
    /* renamed from: a */
    public static void m2019a(Activity activity) {
        activity.finishAfterTransition();
    }

    @DoNotInline
    /* renamed from: b */
    public static void m2020b(Activity activity) {
        activity.postponeEnterTransition();
    }

    @DoNotInline
    /* renamed from: c */
    public static void m2021c(Activity activity, SharedElementCallback sharedElementCallback) {
        activity.setEnterSharedElementCallback(sharedElementCallback);
    }

    @DoNotInline
    /* renamed from: d */
    public static void m2022d(Activity activity, SharedElementCallback sharedElementCallback) {
        activity.setExitSharedElementCallback(sharedElementCallback);
    }

    @DoNotInline
    /* renamed from: e */
    public static void m2023e(Activity activity) {
        activity.startPostponedEnterTransition();
    }
}
