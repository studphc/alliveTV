package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.e1 */
/* loaded from: classes.dex */
public final class C0470e1 extends LinearSmoothScroller {

    /* renamed from: l */
    public final /* synthetic */ SnapHelper f7362l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0470e1(SnapHelper snapHelper, Context context) {
        super(context);
        this.f7362l = snapHelper;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public final void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        SnapHelper snapHelper = this.f7362l;
        RecyclerView recyclerView = snapHelper.f7251a;
        if (recyclerView == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = snapHelper.calculateDistanceToFinalSnap(recyclerView.getLayoutManager(), view);
        int i = calculateDistanceToFinalSnap[0];
        int i2 = calculateDistanceToFinalSnap[1];
        int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
        if (calculateTimeForDeceleration > 0) {
            action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
        }
    }
}
