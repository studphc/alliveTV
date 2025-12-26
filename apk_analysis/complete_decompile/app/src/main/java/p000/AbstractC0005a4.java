package p000;

import android.graphics.Region;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.annotation.DoNotInline;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* renamed from: a4 */
/* loaded from: classes.dex */
public abstract class AbstractC0005a4 {
    @DoNotInline
    /* renamed from: a */
    public static int m10a(AccessibilityWindowInfo accessibilityWindowInfo) {
        return accessibilityWindowInfo.getDisplayId();
    }

    @DoNotInline
    /* renamed from: b */
    public static void m11b(AccessibilityWindowInfo accessibilityWindowInfo, Region region) {
        accessibilityWindowInfo.getRegionInScreen(region);
    }

    @DoNotInline
    /* renamed from: c */
    public static AccessibilityNodeInfoCompat m12c(Object obj, int i) {
        return AccessibilityNodeInfoCompat.m922e(((AccessibilityWindowInfo) obj).getRoot(i));
    }
}
