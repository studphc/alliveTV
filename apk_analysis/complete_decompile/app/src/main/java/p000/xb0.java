package p000;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.customview.widget.ExploreByTouchHelper;

/* loaded from: classes.dex */
public final class xb0 extends AccessibilityNodeProviderCompat {

    /* renamed from: b */
    public final /* synthetic */ ExploreByTouchHelper f28494b;

    public xb0(ExploreByTouchHelper exploreByTouchHelper) {
        this.f28494b = exploreByTouchHelper;
    }

    @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
    public final AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
        return AccessibilityNodeInfoCompat.obtain(this.f28494b.m1033d(i));
    }

    @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
    public final AccessibilityNodeInfoCompat findFocus(int i) {
        int i2;
        ExploreByTouchHelper exploreByTouchHelper = this.f28494b;
        if (i == 2) {
            i2 = exploreByTouchHelper.f4109k;
        } else {
            i2 = exploreByTouchHelper.f4110l;
        }
        if (i2 == Integer.MIN_VALUE) {
            return null;
        }
        return createAccessibilityNodeInfo(i2);
    }

    @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
    public final boolean performAction(int i, int i2, Bundle bundle) {
        int i3;
        ExploreByTouchHelper exploreByTouchHelper = this.f28494b;
        View view = exploreByTouchHelper.f4107i;
        if (i != -1) {
            boolean z = true;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 64) {
                        if (i2 != 128) {
                            return exploreByTouchHelper.onPerformActionForVirtualView(i, i2, bundle);
                        }
                        if (exploreByTouchHelper.f4109k == i) {
                            exploreByTouchHelper.f4109k = Integer.MIN_VALUE;
                            view.invalidate();
                            exploreByTouchHelper.sendEventForVirtualView(i, 65536);
                        }
                        z = false;
                    } else {
                        AccessibilityManager accessibilityManager = exploreByTouchHelper.f4106h;
                        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled() && (i3 = exploreByTouchHelper.f4109k) != i) {
                            if (i3 != Integer.MIN_VALUE) {
                                exploreByTouchHelper.f4109k = Integer.MIN_VALUE;
                                exploreByTouchHelper.f4107i.invalidate();
                                exploreByTouchHelper.sendEventForVirtualView(i3, 65536);
                            }
                            exploreByTouchHelper.f4109k = i;
                            view.invalidate();
                            exploreByTouchHelper.sendEventForVirtualView(i, 32768);
                        }
                        z = false;
                    }
                    return z;
                }
                return exploreByTouchHelper.clearKeyboardFocusForVirtualView(i);
            }
            return exploreByTouchHelper.requestKeyboardFocusForVirtualView(i);
        }
        return ViewCompat.performAccessibilityAction(view, i2, bundle);
    }
}
