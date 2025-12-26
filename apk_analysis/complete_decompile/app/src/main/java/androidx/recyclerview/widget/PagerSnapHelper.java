package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class PagerSnapHelper extends SnapHelper {

    /* renamed from: d */
    public OrientationHelper f7063d;

    /* renamed from: e */
    public OrientationHelper f7064e;

    /* renamed from: b */
    public static int m1667b(View view, OrientationHelper orientationHelper) {
        return ((orientationHelper.getDecoratedMeasurement(view) / 2) + orientationHelper.getDecoratedStart(view)) - ((orientationHelper.getTotalSpace() / 2) + orientationHelper.getStartAfterPadding());
    }

    /* renamed from: c */
    public static View m1668c(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int totalSpace = (orientationHelper.getTotalSpace() / 2) + orientationHelper.getStartAfterPadding();
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = layoutManager.getChildAt(i2);
            int abs = Math.abs(((orientationHelper.getDecoratedMeasurement(childAt) / 2) + orientationHelper.getDecoratedStart(childAt)) - totalSpace);
            if (abs < i) {
                view = childAt;
                i = abs;
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = m1667b(view, m1669d(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = m1667b(view, m1670e(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public RecyclerView.SmoothScroller createScroller(@NonNull RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return null;
        }
        return new C0495n0(this, this.f7251a.getContext());
    }

    /* renamed from: d */
    public final OrientationHelper m1669d(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f7064e;
        if (orientationHelper == null || orientationHelper.mLayoutManager != layoutManager) {
            this.f7064e = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.f7064e;
    }

    /* renamed from: e */
    public final OrientationHelper m1670e(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f7063d;
        if (orientationHelper == null || orientationHelper.mLayoutManager != layoutManager) {
            this.f7063d = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.f7063d;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    @SuppressLint({"UnknownNullness"})
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return m1668c(layoutManager, m1670e(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return m1668c(layoutManager, m1669d(layoutManager));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.SnapHelper
    @SuppressLint({"UnknownNullness"})
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        OrientationHelper orientationHelper;
        boolean z;
        PointF computeScrollVectorForPosition;
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        View view = null;
        if (layoutManager.canScrollVertically()) {
            orientationHelper = m1670e(layoutManager);
        } else if (layoutManager.canScrollHorizontally()) {
            orientationHelper = m1669d(layoutManager);
        } else {
            orientationHelper = null;
        }
        if (orientationHelper == null) {
            return -1;
        }
        int childCount = layoutManager.getChildCount();
        boolean z2 = false;
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        View view2 = null;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = layoutManager.getChildAt(i5);
            if (childAt != null) {
                int m1667b = m1667b(childAt, orientationHelper);
                if (m1667b <= 0 && m1667b > i4) {
                    view2 = childAt;
                    i4 = m1667b;
                }
                if (m1667b >= 0 && m1667b < i3) {
                    view = childAt;
                    i3 = m1667b;
                }
            }
        }
        int i6 = 1;
        if (!layoutManager.canScrollHorizontally() ? i2 > 0 : i > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && view != null) {
            return layoutManager.getPosition(view);
        }
        if (!z && view2 != null) {
            return layoutManager.getPosition(view2);
        }
        if (z) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int position = layoutManager.getPosition(view);
        int itemCount2 = layoutManager.getItemCount();
        if ((layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) && (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount2 - 1)) != null && (computeScrollVectorForPosition.x < RecyclerView.f7068F0 || computeScrollVectorForPosition.y < RecyclerView.f7068F0)) {
            z2 = true;
        }
        if (z2 == z) {
            i6 = -1;
        }
        int i7 = position + i6;
        if (i7 < 0 || i7 >= itemCount) {
            return -1;
        }
        return i7;
    }
}
