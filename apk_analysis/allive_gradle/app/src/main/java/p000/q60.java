package p000;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import java.util.List;

/* loaded from: classes.dex */
public final class q60 extends AccessibilityDelegateCompat {

    /* renamed from: d */
    public final /* synthetic */ DrawerLayout f25459d;

    public q60(DrawerLayout drawerLayout) {
        this.f25459d = drawerLayout;
        new Rect();
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        CharSequence drawerTitle;
        if (accessibilityEvent.getEventType() == 32) {
            List<CharSequence> text = accessibilityEvent.getText();
            DrawerLayout drawerLayout = this.f25459d;
            View m1053e = drawerLayout.m1053e();
            if (m1053e != null && (drawerTitle = drawerLayout.getDrawerTitle(drawerLayout.m1054f(m1053e))) != null) {
                text.add(drawerTitle);
                return true;
            }
            return true;
        }
        return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(DrawerLayout.class.getName());
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        int[] iArr = DrawerLayout.f4136D;
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(DrawerLayout.class.getName());
        accessibilityNodeInfoCompat.setFocusable(false);
        accessibilityNodeInfoCompat.setFocused(false);
        accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
        accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        int[] iArr = DrawerLayout.f4136D;
        return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }
}
