package androidx.leanback.widget;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.leanback.widget.GuidedActionsStylist;

/* renamed from: androidx.leanback.widget.d1 */
/* loaded from: classes.dex */
public final class C0326d1 extends View.AccessibilityDelegate {

    /* renamed from: a */
    public final /* synthetic */ GuidedActionsStylist.ViewHolder f6279a;

    public C0326d1(GuidedActionsStylist.ViewHolder viewHolder) {
        this.f6279a = viewHolder;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        boolean z;
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        GuidedAction guidedAction = this.f6279a.f5819t;
        if (guidedAction != null && guidedAction.isChecked()) {
            z = true;
        } else {
            z = false;
        }
        accessibilityEvent.setChecked(z);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        boolean z;
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        GuidedActionsStylist.ViewHolder viewHolder = this.f6279a;
        GuidedAction guidedAction = viewHolder.f5819t;
        boolean z2 = false;
        if (guidedAction != null && guidedAction.getCheckSetId() != 0) {
            z = true;
        } else {
            z = false;
        }
        accessibilityNodeInfo.setCheckable(z);
        GuidedAction guidedAction2 = viewHolder.f5819t;
        if (guidedAction2 != null && guidedAction2.isChecked()) {
            z2 = true;
        }
        accessibilityNodeInfo.setChecked(z2);
    }
}
