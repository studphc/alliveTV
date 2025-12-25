package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class LinearSmoothScroller extends RecyclerView.SmoothScroller {
    public static final int SNAP_TO_ANY = 0;
    public static final int SNAP_TO_END = 1;
    public static final int SNAP_TO_START = -1;

    /* renamed from: i */
    public final DisplayMetrics f7055i;

    /* renamed from: k */
    public float f7057k;

    @SuppressLint({"UnknownNullness"})
    protected PointF mTargetVector;
    protected final LinearInterpolator mLinearInterpolator = new LinearInterpolator();
    protected final DecelerateInterpolator mDecelerateInterpolator = new DecelerateInterpolator();

    /* renamed from: j */
    public boolean f7056j = false;
    protected int mInterimTargetDx = 0;
    protected int mInterimTargetDy = 0;

    @SuppressLint({"UnknownNullness"})
    public LinearSmoothScroller(Context context) {
        this.f7055i = context.getResources().getDisplayMetrics();
    }

    public int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
        if (i5 != -1) {
            if (i5 != 0) {
                if (i5 == 1) {
                    return i4 - i2;
                }
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
            }
            int i6 = i3 - i;
            if (i6 > 0) {
                return i6;
            }
            int i7 = i4 - i2;
            if (i7 < 0) {
                return i7;
            }
            return 0;
        }
        return i3 - i;
    }

    @SuppressLint({"UnknownNullness"})
    public int calculateDxToMakeVisible(View view, int i) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return calculateDtToFit(layoutManager.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, layoutManager.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), i);
        }
        return 0;
    }

    @SuppressLint({"UnknownNullness"})
    public int calculateDyToMakeVisible(View view, int i) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return calculateDtToFit(layoutManager.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutManager.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutManager.getPaddingTop(), layoutManager.getHeight() - layoutManager.getPaddingBottom(), i);
        }
        return 0;
    }

    @SuppressLint({"UnknownNullness"})
    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int calculateTimeForDeceleration(int i) {
        return (int) Math.ceil(calculateTimeForScrolling(i) / 0.3356d);
    }

    public int calculateTimeForScrolling(int i) {
        float abs = Math.abs(i);
        if (!this.f7056j) {
            this.f7057k = calculateSpeedPerPixel(this.f7055i);
            this.f7056j = true;
        }
        return (int) Math.ceil(abs * this.f7057k);
    }

    public int getHorizontalSnapPreference() {
        PointF pointF = this.mTargetVector;
        if (pointF != null) {
            float f = pointF.x;
            if (f != RecyclerView.f7068F0) {
                if (f > RecyclerView.f7068F0) {
                    return 1;
                }
                return -1;
            }
        }
        return 0;
    }

    public int getVerticalSnapPreference() {
        PointF pointF = this.mTargetVector;
        if (pointF != null) {
            float f = pointF.y;
            if (f != RecyclerView.f7068F0) {
                if (f > RecyclerView.f7068F0) {
                    return 1;
                }
                return -1;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    @SuppressLint({"UnknownNullness"})
    public void onSeekTargetStep(int i, int i2, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        if (getChildCount() == 0) {
            stop();
            return;
        }
        int i3 = this.mInterimTargetDx;
        int i4 = i3 - i;
        int i5 = 0;
        if (i3 * i4 <= 0) {
            i4 = 0;
        }
        this.mInterimTargetDx = i4;
        int i6 = this.mInterimTargetDy;
        int i7 = i6 - i2;
        if (i6 * i7 > 0) {
            i5 = i7;
        }
        this.mInterimTargetDy = i5;
        if (i4 == 0 && i5 == 0) {
            updateActionForInterimTarget(action);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onStart() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onStop() {
        this.mInterimTargetDy = 0;
        this.mInterimTargetDx = 0;
        this.mTargetVector = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    @SuppressLint({"UnknownNullness"})
    public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        int calculateDxToMakeVisible = calculateDxToMakeVisible(view, getHorizontalSnapPreference());
        int calculateDyToMakeVisible = calculateDyToMakeVisible(view, getVerticalSnapPreference());
        int calculateTimeForDeceleration = calculateTimeForDeceleration((int) Math.sqrt((calculateDyToMakeVisible * calculateDyToMakeVisible) + (calculateDxToMakeVisible * calculateDxToMakeVisible)));
        if (calculateTimeForDeceleration > 0) {
            action.update(-calculateDxToMakeVisible, -calculateDyToMakeVisible, calculateTimeForDeceleration, this.mDecelerateInterpolator);
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void updateActionForInterimTarget(RecyclerView.SmoothScroller.Action action) {
        PointF computeScrollVectorForPosition = computeScrollVectorForPosition(getTargetPosition());
        if (computeScrollVectorForPosition != null && (computeScrollVectorForPosition.x != RecyclerView.f7068F0 || computeScrollVectorForPosition.y != RecyclerView.f7068F0)) {
            normalize(computeScrollVectorForPosition);
            this.mTargetVector = computeScrollVectorForPosition;
            this.mInterimTargetDx = (int) (computeScrollVectorForPosition.x * 10000.0f);
            this.mInterimTargetDy = (int) (computeScrollVectorForPosition.y * 10000.0f);
            action.update((int) (this.mInterimTargetDx * 1.2f), (int) (this.mInterimTargetDy * 1.2f), (int) (calculateTimeForScrolling(10000) * 1.2f), this.mLinearInterpolator);
            return;
        }
        action.jumpTo(getTargetPosition());
        stop();
    }
}
