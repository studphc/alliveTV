package p000;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.annotation.DoNotInline;

/* renamed from: x3 */
/* loaded from: classes.dex */
public abstract class AbstractC1969x3 {
    @DoNotInline
    /* renamed from: a */
    public static AccessibilityNodeInfo m8092a(AccessibilityWindowInfo accessibilityWindowInfo) {
        return accessibilityWindowInfo.getAnchor();
    }

    @DoNotInline
    /* renamed from: b */
    public static CharSequence m8093b(AccessibilityWindowInfo accessibilityWindowInfo) {
        return accessibilityWindowInfo.getTitle();
    }
}
