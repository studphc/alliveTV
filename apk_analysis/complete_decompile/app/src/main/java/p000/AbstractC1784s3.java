package p000;

import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.DoNotInline;

/* renamed from: s3 */
/* loaded from: classes.dex */
public abstract class AbstractC1784s3 {
    @DoNotInline
    /* renamed from: a */
    public static Object m7319a(int i, float f, float f2, float f3) {
        return new AccessibilityNodeInfo.RangeInfo(i, f, f2, f3);
    }

    @DoNotInline
    /* renamed from: b */
    public static CharSequence m7320b(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getStateDescription();
    }

    @DoNotInline
    /* renamed from: c */
    public static void m7321c(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
        accessibilityNodeInfo.setStateDescription(charSequence);
    }
}
