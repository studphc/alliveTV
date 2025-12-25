package p000;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.DoNotInline;
import java.time.Duration;

/* renamed from: t3 */
/* loaded from: classes.dex */
public abstract class AbstractC1821t3 {
    @DoNotInline
    /* renamed from: a */
    public static AccessibilityNodeInfo.AccessibilityAction m7437a() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
    }

    @DoNotInline
    /* renamed from: b */
    public static void m7438b(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
        accessibilityNodeInfo.getBoundsInWindow(rect);
    }

    @DoNotInline
    /* renamed from: c */
    public static CharSequence m7439c(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getContainerTitle();
    }

    @DoNotInline
    /* renamed from: d */
    public static long m7440d(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getMinDurationBetweenContentChanges().toMillis();
    }

    @DoNotInline
    /* renamed from: e */
    public static boolean m7441e(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
    }

    @DoNotInline
    /* renamed from: f */
    public static boolean m7442f(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isAccessibilityDataSensitive();
    }

    @DoNotInline
    /* renamed from: g */
    public static void m7443g(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        accessibilityNodeInfo.setAccessibilityDataSensitive(z);
    }

    @DoNotInline
    /* renamed from: h */
    public static void m7444h(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
        accessibilityNodeInfo.setBoundsInWindow(rect);
    }

    @DoNotInline
    /* renamed from: i */
    public static void m7445i(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
        accessibilityNodeInfo.setContainerTitle(charSequence);
    }

    @DoNotInline
    /* renamed from: j */
    public static void m7446j(AccessibilityNodeInfo accessibilityNodeInfo, long j) {
        accessibilityNodeInfo.setMinDurationBetweenContentChanges(Duration.ofMillis(j));
    }

    @DoNotInline
    /* renamed from: k */
    public static void m7447k(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z) {
        accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z);
    }

    @DoNotInline
    /* renamed from: l */
    public static void m7448l(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z);
    }
}
