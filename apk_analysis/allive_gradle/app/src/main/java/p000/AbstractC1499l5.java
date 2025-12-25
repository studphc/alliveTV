package p000;

import android.app.Activity;
import android.app.ActivityOptions;
import android.util.Pair;
import android.view.View;
import androidx.annotation.DoNotInline;

/* renamed from: l5 */
/* loaded from: classes.dex */
public abstract class AbstractC1499l5 {
    @DoNotInline
    /* renamed from: a */
    public static ActivityOptions m5852a(Activity activity, View view, String str) {
        return ActivityOptions.makeSceneTransitionAnimation(activity, view, str);
    }

    @SafeVarargs
    @DoNotInline
    /* renamed from: b */
    public static ActivityOptions m5853b(Activity activity, Pair<View, String>... pairArr) {
        return ActivityOptions.makeSceneTransitionAnimation(activity, pairArr);
    }

    @DoNotInline
    /* renamed from: c */
    public static ActivityOptions m5854c() {
        return ActivityOptions.makeTaskLaunchBehind();
    }
}
