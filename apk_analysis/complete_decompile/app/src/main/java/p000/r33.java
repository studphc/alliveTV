package p000;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes.dex */
public final class r33 extends AccessibilityDelegateCompat {

    /* renamed from: d */
    public final /* synthetic */ ViewPager f25857d;

    public r33(ViewPager viewPager) {
        this.f25857d = viewPager;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0017, code lost:
    
        if (r0.getCount() > 1) goto L8;
     */
    @Override // androidx.core.view.AccessibilityDelegateCompat
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        boolean z;
        PagerAdapter pagerAdapter;
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(ViewPager.class.getName());
        ViewPager viewPager = this.f25857d;
        PagerAdapter pagerAdapter2 = viewPager.f7651e;
        if (pagerAdapter2 != null) {
            z = true;
        }
        z = false;
        accessibilityEvent.setScrollable(z);
        if (accessibilityEvent.getEventType() == 4096 && (pagerAdapter = viewPager.f7651e) != null) {
            accessibilityEvent.setItemCount(pagerAdapter.getCount());
            accessibilityEvent.setFromIndex(viewPager.f7653f);
            accessibilityEvent.setToIndex(viewPager.f7653f);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        boolean z;
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
        ViewPager viewPager = this.f25857d;
        PagerAdapter pagerAdapter = viewPager.f7651e;
        if (pagerAdapter != null && pagerAdapter.getCount() > 1) {
            z = true;
        } else {
            z = false;
        }
        accessibilityNodeInfoCompat.setScrollable(z);
        if (viewPager.canScrollHorizontally(1)) {
            accessibilityNodeInfoCompat.addAction(4096);
        }
        if (viewPager.canScrollHorizontally(-1)) {
            accessibilityNodeInfoCompat.addAction(8192);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        ViewPager viewPager = this.f25857d;
        if (i != 4096) {
            if (i != 8192 || !viewPager.canScrollHorizontally(-1)) {
                return false;
            }
            viewPager.setCurrentItem(viewPager.f7653f - 1);
            return true;
        }
        if (!viewPager.canScrollHorizontally(1)) {
            return false;
        }
        viewPager.setCurrentItem(viewPager.f7653f + 1);
        return true;
    }
}
