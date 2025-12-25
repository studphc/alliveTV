package p000;

import android.util.DisplayMetrics;
import android.view.View;
import androidx.leanback.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class yx0 extends LinearSmoothScroller {

    /* renamed from: l */
    public boolean f29159l;

    /* renamed from: m */
    public final /* synthetic */ GridLayoutManager f29160m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yx0(GridLayoutManager gridLayoutManager) {
        super(gridLayoutManager.f5714s.getContext());
        this.f29160m = gridLayoutManager;
    }

    /* renamed from: b */
    public void mo8330b() {
        View findViewByPosition = findViewByPosition(getTargetPosition());
        GridLayoutManager gridLayoutManager = this.f29160m;
        if (findViewByPosition == null) {
            if (getTargetPosition() >= 0) {
                gridLayoutManager.m1412Q(getTargetPosition(), 0, 0, false);
                return;
            }
            return;
        }
        if (gridLayoutManager.f5682I != getTargetPosition()) {
            gridLayoutManager.f5682I = getTargetPosition();
        }
        if (gridLayoutManager.hasFocus()) {
            gridLayoutManager.f5677D |= 32;
            findViewByPosition.requestFocus();
            gridLayoutManager.f5677D &= -33;
        }
        gridLayoutManager.m1424n();
        gridLayoutManager.m1425o();
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return super.calculateSpeedPerPixel(displayMetrics) * this.f29160m.f5712q;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final int calculateTimeForScrolling(int i) {
        int calculateTimeForScrolling = super.calculateTimeForScrolling(i);
        int i2 = ((m53) this.f29160m.f5703d0.f23109d).f22814i;
        if (i2 > 0) {
            float f = (30.0f / i2) * i;
            if (calculateTimeForScrolling < f) {
                return (int) f;
            }
            return calculateTimeForScrolling;
        }
        return calculateTimeForScrolling;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public final void onStop() {
        super.onStop();
        if (!this.f29159l) {
            mo8330b();
        }
        GridLayoutManager gridLayoutManager = this.f29160m;
        if (gridLayoutManager.f5684K == this) {
            gridLayoutManager.f5684K = null;
        }
        if (gridLayoutManager.f5685L == this) {
            gridLayoutManager.f5685L = null;
        }
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public final void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        int i;
        int i2;
        int[] iArr = GridLayoutManager.f5673n0;
        GridLayoutManager gridLayoutManager = this.f29160m;
        if (gridLayoutManager.m1431v(view, null, iArr)) {
            if (gridLayoutManager.f5715t == 0) {
                i = iArr[0];
                i2 = iArr[1];
            } else {
                i = iArr[1];
                i2 = iArr[0];
            }
            action.update(i, i2, calculateTimeForDeceleration((int) Math.sqrt((i2 * i2) + (i * i))), this.mDecelerateInterpolator);
        }
    }
}
