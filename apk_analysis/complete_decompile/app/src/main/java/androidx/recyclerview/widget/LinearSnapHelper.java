package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class LinearSnapHelper extends SnapHelper {

    /* renamed from: d */
    public OrientationHelper f7058d;

    /* renamed from: e */
    public OrientationHelper f7059e;

    /* renamed from: c */
    public static View m1663c(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
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

    /* renamed from: b */
    public final int m1664b(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper, int i, int i2) {
        int i3;
        int[] calculateScrollDistance = calculateScrollDistance(i, i2);
        int childCount = layoutManager.getChildCount();
        float f = 1.0f;
        if (childCount != 0) {
            View view = null;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            View view2 = null;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = layoutManager.getChildAt(i6);
                int position = layoutManager.getPosition(childAt);
                if (position != -1) {
                    if (position < i5) {
                        view = childAt;
                        i5 = position;
                    }
                    if (position > i4) {
                        view2 = childAt;
                        i4 = position;
                    }
                }
            }
            if (view != null && view2 != null) {
                int max = Math.max(orientationHelper.getDecoratedEnd(view), orientationHelper.getDecoratedEnd(view2)) - Math.min(orientationHelper.getDecoratedStart(view), orientationHelper.getDecoratedStart(view2));
                if (max != 0) {
                    f = (max * 1.0f) / ((i4 - i5) + 1);
                }
            }
        }
        if (f <= RecyclerView.f7068F0) {
            return 0;
        }
        if (Math.abs(calculateScrollDistance[0]) > Math.abs(calculateScrollDistance[1])) {
            i3 = calculateScrollDistance[0];
        } else {
            i3 = calculateScrollDistance[1];
        }
        return Math.round(i3 / f);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            OrientationHelper m1665d = m1665d(layoutManager);
            iArr[0] = ((m1665d.getDecoratedMeasurement(view) / 2) + m1665d.getDecoratedStart(view)) - ((m1665d.getTotalSpace() / 2) + m1665d.getStartAfterPadding());
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            OrientationHelper m1666e = m1666e(layoutManager);
            iArr[1] = ((m1666e.getDecoratedMeasurement(view) / 2) + m1666e.getDecoratedStart(view)) - ((m1666e.getTotalSpace() / 2) + m1666e.getStartAfterPadding());
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    /* renamed from: d */
    public final OrientationHelper m1665d(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f7059e;
        if (orientationHelper == null || orientationHelper.mLayoutManager != layoutManager) {
            this.f7059e = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.f7059e;
    }

    /* renamed from: e */
    public final OrientationHelper m1666e(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f7058d;
        if (orientationHelper == null || orientationHelper.mLayoutManager != layoutManager) {
            this.f7058d = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.f7058d;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return m1663c(layoutManager, m1666e(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return m1663c(layoutManager, m1665d(layoutManager));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        int itemCount;
        View findSnapView;
        int position;
        int i3;
        PointF computeScrollVectorForPosition;
        int i4;
        int i5;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (itemCount = layoutManager.getItemCount()) == 0 || (findSnapView = findSnapView(layoutManager)) == null || (position = layoutManager.getPosition(findSnapView)) == -1 || (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return -1;
        }
        int i6 = 0;
        if (layoutManager.canScrollHorizontally()) {
            i4 = m1664b(layoutManager, m1665d(layoutManager), i, 0);
            if (computeScrollVectorForPosition.x < RecyclerView.f7068F0) {
                i4 = -i4;
            }
        } else {
            i4 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            i5 = m1664b(layoutManager, m1666e(layoutManager), 0, i2);
            if (computeScrollVectorForPosition.y < RecyclerView.f7068F0) {
                i5 = -i5;
            }
        } else {
            i5 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            i4 = i5;
        }
        if (i4 == 0) {
            return -1;
        }
        int i7 = position + i4;
        if (i7 >= 0) {
            i6 = i7;
        }
        if (i6 < itemCount) {
            return i6;
        }
        return i3;
    }
}
