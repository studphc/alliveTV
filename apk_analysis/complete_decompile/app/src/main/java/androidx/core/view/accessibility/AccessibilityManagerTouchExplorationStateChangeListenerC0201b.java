package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityManager;
import androidx.core.view.accessibility.AccessibilityManagerCompat;

/* renamed from: androidx.core.view.accessibility.b */
/* loaded from: classes.dex */
public final class AccessibilityManagerTouchExplorationStateChangeListenerC0201b implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a */
    public final AccessibilityManagerCompat.TouchExplorationStateChangeListener f3970a;

    public AccessibilityManagerTouchExplorationStateChangeListenerC0201b(AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        this.f3970a = touchExplorationStateChangeListener;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityManagerTouchExplorationStateChangeListenerC0201b)) {
            return false;
        }
        return this.f3970a.equals(((AccessibilityManagerTouchExplorationStateChangeListenerC0201b) obj).f3970a);
    }

    public final int hashCode() {
        return this.f3970a.hashCode();
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        this.f3970a.onTouchExplorationStateChanged(z);
    }
}
