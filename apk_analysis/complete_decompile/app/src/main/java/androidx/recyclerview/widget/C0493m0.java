package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.m0 */
/* loaded from: classes.dex */
public final class C0493m0 extends OrientationHelper {
    @Override // androidx.recyclerview.widget.OrientationHelper
    public final int getDecoratedEnd(View view) {
        return this.mLayoutManager.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public final int getDecoratedMeasurement(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return this.mLayoutManager.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public final int getDecoratedMeasurementInOther(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return this.mLayoutManager.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public final int getDecoratedStart(View view) {
        return this.mLayoutManager.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public final int getEnd() {
        return this.mLayoutManager.getHeight();
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public final int getEndAfterPadding() {
        return this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingBottom();
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public final int getEndPadding() {
        return this.mLayoutManager.getPaddingBottom();
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public final int getMode() {
        return this.mLayoutManager.getHeightMode();
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public final int getModeInOther() {
        return this.mLayoutManager.getWidthMode();
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public final int getStartAfterPadding() {
        return this.mLayoutManager.getPaddingTop();
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public final int getTotalSpace() {
        return (this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingTop()) - this.mLayoutManager.getPaddingBottom();
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public final int getTransformedEndWithDecoration(View view) {
        RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
        Rect rect = this.f7062b;
        layoutManager.getTransformedBoundingBox(view, true, rect);
        return rect.bottom;
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public final int getTransformedStartWithDecoration(View view) {
        RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
        Rect rect = this.f7062b;
        layoutManager.getTransformedBoundingBox(view, true, rect);
        return rect.top;
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public final void offsetChild(View view, int i) {
        view.offsetTopAndBottom(i);
    }

    @Override // androidx.recyclerview.widget.OrientationHelper
    public final void offsetChildren(int i) {
        this.mLayoutManager.offsetChildrenVertical(i);
    }
}
