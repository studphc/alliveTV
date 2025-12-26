package androidx.leanback.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public final class HorizontalHoverCardSwitcher extends PresenterSwitcher {

    /* renamed from: e */
    public int f5850e;

    /* renamed from: f */
    public int f5851f;

    /* renamed from: g */
    public final int[] f5852g = new int[2];

    /* renamed from: h */
    public final Rect f5853h = new Rect();

    @Override // androidx.leanback.widget.PresenterSwitcher
    public void insertView(View view) {
        getParentViewGroup().addView(view);
    }

    @Override // androidx.leanback.widget.PresenterSwitcher
    public void onViewSelected(View view) {
        int width = getParentViewGroup().getWidth() - getParentViewGroup().getPaddingRight();
        int paddingLeft = getParentViewGroup().getPaddingLeft();
        boolean z = false;
        view.measure(0, 0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (ViewCompat.getLayoutDirection(view) == 1) {
            z = true;
        }
        if (!z) {
            if (view.getMeasuredWidth() + this.f5850e > width) {
                marginLayoutParams.leftMargin = width - view.getMeasuredWidth();
                view.requestLayout();
            }
        }
        if (z && this.f5850e < paddingLeft) {
            marginLayoutParams.leftMargin = paddingLeft;
        } else if (z) {
            marginLayoutParams.leftMargin = this.f5851f - view.getMeasuredWidth();
        } else {
            marginLayoutParams.leftMargin = this.f5850e;
        }
        view.requestLayout();
    }

    public void select(HorizontalGridView horizontalGridView, View view, Object obj) {
        ViewGroup parentViewGroup = getParentViewGroup();
        int[] iArr = this.f5852g;
        horizontalGridView.getViewSelectedOffsets(view, iArr);
        int width = view.getWidth();
        int height = view.getHeight();
        Rect rect = this.f5853h;
        rect.set(0, 0, width, height);
        parentViewGroup.offsetDescendantRectToMyCoords(view, rect);
        int i = rect.left;
        int i2 = iArr[0];
        this.f5850e = i - i2;
        this.f5851f = rect.right - i2;
        select(obj);
    }
}
