package p000;

import android.app.ActivityOptions;
import android.graphics.Rect;
import androidx.annotation.DoNotInline;

/* renamed from: n5 */
/* loaded from: classes.dex */
public abstract class AbstractC1573n5 {
    @DoNotInline
    /* renamed from: a */
    public static Rect m6304a(ActivityOptions activityOptions) {
        return activityOptions.getLaunchBounds();
    }

    @DoNotInline
    /* renamed from: b */
    public static ActivityOptions m6305b(ActivityOptions activityOptions, Rect rect) {
        return activityOptions.setLaunchBounds(rect);
    }
}
