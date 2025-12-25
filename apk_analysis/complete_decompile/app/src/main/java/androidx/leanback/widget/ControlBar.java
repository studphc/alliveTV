package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ControlBar extends LinearLayout {

    /* renamed from: a */
    public int f5602a;

    /* renamed from: b */
    public C0360m f5603b;

    /* renamed from: c */
    public int f5604c;

    /* renamed from: d */
    public boolean f5605d;

    /* loaded from: classes.dex */
    public interface OnChildFocusedListener {
        void onChildFocusedListener(View view, View view2);
    }

    public ControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5604c = -1;
        this.f5605d = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i2) {
        int i3;
        if (i != 33 && i != 130) {
            super.addFocusables(arrayList, i, i2);
            return;
        }
        int i4 = this.f5604c;
        if (i4 >= 0 && i4 < getChildCount()) {
            arrayList.add(getChildAt(this.f5604c));
        } else if (getChildCount() > 0) {
            if (this.f5605d) {
                i3 = getChildCount() / 2;
            } else {
                i3 = 0;
            }
            arrayList.add(getChildAt(i3));
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f5602a <= 0) {
            return;
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < getChildCount() - 1) {
            View childAt = getChildAt(i3);
            i3++;
            View childAt2 = getChildAt(i3);
            int measuredWidth = this.f5602a - ((childAt2.getMeasuredWidth() + childAt.getMeasuredWidth()) / 2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt2.getLayoutParams();
            int marginStart = measuredWidth - layoutParams.getMarginStart();
            layoutParams.setMarginStart(measuredWidth);
            childAt2.setLayoutParams(layoutParams);
            i4 += marginStart;
        }
        setMeasuredDimension(getMeasuredWidth() + i4, getMeasuredHeight());
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        if (getChildCount() > 0) {
            int i3 = this.f5604c;
            if (i3 >= 0 && i3 < getChildCount()) {
                i2 = this.f5604c;
            } else if (this.f5605d) {
                i2 = getChildCount() / 2;
            } else {
                i2 = 0;
            }
            if (getChildAt(i2).requestFocus(i, rect)) {
                return true;
            }
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        this.f5604c = indexOfChild(view);
        C0360m c0360m = this.f5603b;
        if (c0360m != null) {
            c0360m.onChildFocusedListener(view, view2);
        }
    }
}
