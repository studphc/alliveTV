package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class SnapHelper extends RecyclerView.OnFlingListener {

    /* renamed from: a */
    public RecyclerView f7251a;

    /* renamed from: b */
    public Scroller f7252b;

    /* renamed from: c */
    public final C0467d1 f7253c = new C0467d1(this);

    /* renamed from: a */
    public final void m1770a() {
        RecyclerView.LayoutManager layoutManager;
        View findSnapView;
        RecyclerView recyclerView = this.f7251a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (findSnapView = findSnapView(layoutManager)) == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, findSnapView);
        int i = calculateDistanceToFinalSnap[0];
        if (i != 0 || calculateDistanceToFinalSnap[1] != 0) {
            this.f7251a.smoothScrollBy(i, calculateDistanceToFinalSnap[1]);
        }
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f7251a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        C0467d1 c0467d1 = this.f7253c;
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(c0467d1);
            this.f7251a.setOnFlingListener(null);
        }
        this.f7251a = recyclerView;
        if (recyclerView != null) {
            if (recyclerView.getOnFlingListener() == null) {
                this.f7251a.addOnScrollListener(c0467d1);
                this.f7251a.setOnFlingListener(this);
                this.f7252b = new Scroller(this.f7251a.getContext(), new DecelerateInterpolator());
                m1770a();
                return;
            }
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
    }

    @Nullable
    public abstract int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view);

    @SuppressLint({"UnknownNullness"})
    public int[] calculateScrollDistance(int i, int i2) {
        this.f7252b.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.f7252b.getFinalX(), this.f7252b.getFinalY()};
    }

    @Nullable
    public RecyclerView.SmoothScroller createScroller(@NonNull RecyclerView.LayoutManager layoutManager) {
        return createSnapScroller(layoutManager);
    }

    @Nullable
    @Deprecated
    public LinearSmoothScroller createSnapScroller(@NonNull RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return null;
        }
        return new C0470e1(this, this.f7251a.getContext());
    }

    @Nullable
    @SuppressLint({"UnknownNullness"})
    public abstract View findSnapView(RecyclerView.LayoutManager layoutManager);

    @SuppressLint({"UnknownNullness"})
    public abstract int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2);

    @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public boolean onFling(int i, int i2) {
        RecyclerView.SmoothScroller createScroller;
        int findTargetSnapPosition;
        RecyclerView.LayoutManager layoutManager = this.f7251a.getLayoutManager();
        if (layoutManager == null || this.f7251a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f7251a.getMinFlingVelocity();
        if ((Math.abs(i2) <= minFlingVelocity && Math.abs(i) <= minFlingVelocity) || !(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (createScroller = createScroller(layoutManager)) == null || (findTargetSnapPosition = findTargetSnapPosition(layoutManager, i, i2)) == -1) {
            return false;
        }
        createScroller.setTargetPosition(findTargetSnapPosition);
        layoutManager.startSmoothScroll(createScroller);
        return true;
    }
}
