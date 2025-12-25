package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.DoNotInline;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* renamed from: androidx.core.view.accessibility.c */
/* loaded from: classes.dex */
public abstract class AbstractC0202c {
    @DoNotInline
    /* renamed from: a */
    public static AccessibilityNodeInfoCompat.CollectionItemInfoCompat m926a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        return new AccessibilityNodeInfoCompat.CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
    }
}
