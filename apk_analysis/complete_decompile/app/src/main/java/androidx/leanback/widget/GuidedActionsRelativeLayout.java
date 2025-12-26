package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import p000.b01;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class GuidedActionsRelativeLayout extends RelativeLayout {

    /* renamed from: a */
    public final float f5788a;

    /* renamed from: b */
    public boolean f5789b;

    /* renamed from: c */
    public b01 f5790c;

    public GuidedActionsRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        GuidedActionsStylist guidedActionsStylist;
        GuidedAction guidedAction;
        b01 b01Var = this.f5790c;
        if (b01Var != null) {
            b01Var.getClass();
            if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && (guidedAction = (guidedActionsStylist = (GuidedActionsStylist) b01Var.f7833b).f5810s) != null && ((guidedAction.hasSubActions() && guidedActionsStylist.isBackKeyToCollapseSubActions()) || (guidedActionsStylist.f5810s.hasEditableActivatorView() && guidedActionsStylist.isBackKeyToCollapseActivatorView()))) {
                guidedActionsStylist.collapseAction(true);
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f5789b = false;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        View findViewById;
        int size = View.MeasureSpec.getSize(i2);
        if (size > 0 && (findViewById = findViewById(androidx.leanback.R.id.guidedactions_sub_list)) != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
            if (marginLayoutParams.topMargin < 0 && !this.f5789b) {
                this.f5789b = true;
            }
            if (this.f5789b) {
                marginLayoutParams.topMargin = (int) ((this.f5788a * size) / 100.0f);
            }
        }
        super.onMeasure(i, i2);
    }

    public GuidedActionsRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5789b = false;
        this.f5788a = GuidanceStylingRelativeLayout.m1435a(context);
    }
}
