package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.n0 */
/* loaded from: classes.dex */
public final class C0495n0 extends LinearSmoothScroller {

    /* renamed from: l */
    public final /* synthetic */ PagerSnapHelper f7448l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0495n0(PagerSnapHelper pagerSnapHelper, Context context) {
        super(context);
        this.f7448l = pagerSnapHelper;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final int calculateTimeForScrolling(int i) {
        return Math.min(100, super.calculateTimeForScrolling(i));
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public final void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        PagerSnapHelper pagerSnapHelper = this.f7448l;
        int[] calculateDistanceToFinalSnap = pagerSnapHelper.calculateDistanceToFinalSnap(pagerSnapHelper.f7251a.getLayoutManager(), view);
        int i = calculateDistanceToFinalSnap[0];
        int i2 = calculateDistanceToFinalSnap[1];
        int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
        if (calculateTimeForDeceleration > 0) {
            action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
        }
    }
}
