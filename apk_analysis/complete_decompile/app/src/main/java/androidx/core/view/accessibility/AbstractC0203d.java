package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.DoNotInline;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* renamed from: androidx.core.view.accessibility.d */
/* loaded from: classes.dex */
public abstract class AbstractC0203d {
    @DoNotInline
    /* renamed from: a */
    public static AccessibilityNodeInfoCompat.CollectionItemInfoCompat m927a(boolean z, int i, int i2, int i3, int i4, boolean z2, String str, String str2) {
        return new AccessibilityNodeInfoCompat.CollectionItemInfoCompat(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z).setColumnIndex(i).setRowIndex(i2).setColumnSpan(i3).setRowSpan(i4).setSelected(z2).setRowTitle(str).setColumnTitle(str2).build());
    }

    @DoNotInline
    /* renamed from: b */
    public static AccessibilityNodeInfoCompat m928b(AccessibilityNodeInfo accessibilityNodeInfo, int i, int i2) {
        return AccessibilityNodeInfoCompat.m922e(accessibilityNodeInfo.getChild(i, i2));
    }

    @DoNotInline
    /* renamed from: c */
    public static String m929c(Object obj) {
        return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnTitle();
    }

    @DoNotInline
    /* renamed from: d */
    public static String m930d(Object obj) {
        return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowTitle();
    }

    @DoNotInline
    /* renamed from: e */
    public static AccessibilityNodeInfo.ExtraRenderingInfo m931e(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getExtraRenderingInfo();
    }

    @DoNotInline
    /* renamed from: f */
    public static AccessibilityNodeInfoCompat m932f(AccessibilityNodeInfo accessibilityNodeInfo, int i) {
        return AccessibilityNodeInfoCompat.m922e(accessibilityNodeInfo.getParent(i));
    }

    @DoNotInline
    /* renamed from: g */
    public static String m933g(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getUniqueId();
    }

    @DoNotInline
    /* renamed from: h */
    public static boolean m934h(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isTextSelectable();
    }

    @DoNotInline
    /* renamed from: i */
    public static void m935i(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        accessibilityNodeInfo.setTextSelectable(z);
    }

    @DoNotInline
    /* renamed from: j */
    public static void m936j(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        accessibilityNodeInfo.setUniqueId(str);
    }
}
