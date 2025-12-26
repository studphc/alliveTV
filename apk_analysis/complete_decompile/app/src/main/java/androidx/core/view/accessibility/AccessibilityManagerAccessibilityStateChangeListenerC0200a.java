package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityManager;
import androidx.core.view.accessibility.AccessibilityManagerCompat;

/* renamed from: androidx.core.view.accessibility.a */
/* loaded from: classes.dex */
public final class AccessibilityManagerAccessibilityStateChangeListenerC0200a implements AccessibilityManager.AccessibilityStateChangeListener {

    /* renamed from: a */
    public final AccessibilityManagerCompat.AccessibilityStateChangeListener f3969a;

    public AccessibilityManagerAccessibilityStateChangeListenerC0200a(AccessibilityManagerCompat.AccessibilityStateChangeListener accessibilityStateChangeListener) {
        this.f3969a = accessibilityStateChangeListener;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityManagerAccessibilityStateChangeListenerC0200a)) {
            return false;
        }
        return this.f3969a.equals(((AccessibilityManagerAccessibilityStateChangeListenerC0200a) obj).f3969a);
    }

    public final int hashCode() {
        return this.f3969a.hashCode();
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean z) {
        this.f3969a.onAccessibilityStateChanged(z);
    }
}
