package p000;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.view.View;
import androidx.annotation.DoNotInline;

/* renamed from: m5 */
/* loaded from: classes.dex */
public abstract class AbstractC1536m5 {
    @DoNotInline
    /* renamed from: a */
    public static ActivityOptions m6052a() {
        return ActivityOptions.makeBasic();
    }

    @DoNotInline
    /* renamed from: b */
    public static ActivityOptions m6053b(View view, int i, int i2, int i3, int i4) {
        return ActivityOptions.makeClipRevealAnimation(view, i, i2, i3, i4);
    }

    @DoNotInline
    /* renamed from: c */
    public static void m6054c(ActivityOptions activityOptions, PendingIntent pendingIntent) {
        activityOptions.requestUsageTimeReport(pendingIntent);
    }
}
