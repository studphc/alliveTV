package p000;

import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;

/* renamed from: j3 */
/* loaded from: classes.dex */
public abstract class AbstractC1340j3 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m5384a(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.isAccessibilityDataSensitive();
    }

    @DoNotInline
    /* renamed from: b */
    public static void m5385b(AccessibilityEvent accessibilityEvent, boolean z) {
        accessibilityEvent.setAccessibilityDataSensitive(z);
    }
}
