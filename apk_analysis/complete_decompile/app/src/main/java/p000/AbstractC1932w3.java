package p000;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.annotation.DoNotInline;

/* renamed from: w3 */
/* loaded from: classes.dex */
public abstract class AbstractC1932w3 {
    @DoNotInline
    /* renamed from: a */
    public static void m7993a(AccessibilityWindowInfo accessibilityWindowInfo, Rect rect) {
        accessibilityWindowInfo.getBoundsInScreen(rect);
    }

    @DoNotInline
    /* renamed from: b */
    public static AccessibilityWindowInfo m7994b(AccessibilityWindowInfo accessibilityWindowInfo, int i) {
        return accessibilityWindowInfo.getChild(i);
    }

    @DoNotInline
    /* renamed from: c */
    public static int m7995c(AccessibilityWindowInfo accessibilityWindowInfo) {
        return accessibilityWindowInfo.getChildCount();
    }

    @DoNotInline
    /* renamed from: d */
    public static int m7996d(AccessibilityWindowInfo accessibilityWindowInfo) {
        return accessibilityWindowInfo.getId();
    }

    @DoNotInline
    /* renamed from: e */
    public static int m7997e(AccessibilityWindowInfo accessibilityWindowInfo) {
        return accessibilityWindowInfo.getLayer();
    }

    @DoNotInline
    /* renamed from: f */
    public static AccessibilityWindowInfo m7998f(AccessibilityWindowInfo accessibilityWindowInfo) {
        return accessibilityWindowInfo.getParent();
    }

    @DoNotInline
    /* renamed from: g */
    public static AccessibilityNodeInfo m7999g(AccessibilityWindowInfo accessibilityWindowInfo) {
        return accessibilityWindowInfo.getRoot();
    }

    @DoNotInline
    /* renamed from: h */
    public static int m8000h(AccessibilityWindowInfo accessibilityWindowInfo) {
        return accessibilityWindowInfo.getType();
    }

    @DoNotInline
    /* renamed from: i */
    public static boolean m8001i(AccessibilityWindowInfo accessibilityWindowInfo) {
        return accessibilityWindowInfo.isAccessibilityFocused();
    }

    @DoNotInline
    /* renamed from: j */
    public static boolean m8002j(AccessibilityWindowInfo accessibilityWindowInfo) {
        return accessibilityWindowInfo.isActive();
    }

    @DoNotInline
    /* renamed from: k */
    public static boolean m8003k(AccessibilityWindowInfo accessibilityWindowInfo) {
        return accessibilityWindowInfo.isFocused();
    }

    @DoNotInline
    /* renamed from: l */
    public static AccessibilityWindowInfo m8004l() {
        return AccessibilityWindowInfo.obtain();
    }

    @DoNotInline
    /* renamed from: m */
    public static AccessibilityWindowInfo m8005m(AccessibilityWindowInfo accessibilityWindowInfo) {
        return AccessibilityWindowInfo.obtain(accessibilityWindowInfo);
    }
}
