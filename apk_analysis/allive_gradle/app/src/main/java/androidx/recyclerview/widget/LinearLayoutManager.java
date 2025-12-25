package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import p000.ye0;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    public static final int VERTICAL = 1;

    /* renamed from: A */
    public boolean f7036A;

    /* renamed from: B */
    public SavedState f7037B;

    /* renamed from: C */
    public final C0472f0 f7038C;

    /* renamed from: D */
    public final LayoutChunkResult f7039D;

    /* renamed from: E */
    public int f7040E;

    /* renamed from: F */
    public final int[] f7041F;

    /* renamed from: q */
    public int f7042q;

    /* renamed from: r */
    public C0475g0 f7043r;

    /* renamed from: s */
    public OrientationHelper f7044s;

    /* renamed from: t */
    public boolean f7045t;

    /* renamed from: u */
    public boolean f7046u;

    /* renamed from: v */
    public boolean f7047v;

    /* renamed from: w */
    public boolean f7048w;

    /* renamed from: x */
    public boolean f7049x;

    /* renamed from: y */
    public int f7050y;

    /* renamed from: z */
    public int f7051z;

    /* loaded from: classes.dex */
    public static class LayoutChunkResult {
        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;
    }

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: a */
        public int f7052a;

        /* renamed from: b */
        public int f7053b;

        /* renamed from: c */
        public boolean f7054c;

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f7052a);
            parcel.writeInt(this.f7053b);
            parcel.writeInt(this.f7054c ? 1 : 0);
        }

        @SuppressLint({"UnknownNullness"})
        public SavedState(SavedState savedState) {
            this.f7052a = savedState.f7052a;
            this.f7053b = savedState.f7053b;
            this.f7054c = savedState.f7054c;
        }
    }

    public LinearLayoutManager(@SuppressLint({"UnknownNullness"}) Context context) {
        this(context, 1, false);
    }

    /* renamed from: A */
    public final View m1641A() {
        int childCount;
        if (this.f7047v) {
            childCount = 0;
        } else {
            childCount = getChildCount() - 1;
        }
        return getChildAt(childCount);
    }

    /* renamed from: B */
    public final View m1642B() {
        int i;
        if (this.f7047v) {
            i = getChildCount() - 1;
        } else {
            i = 0;
        }
        return getChildAt(i);
    }

    /* renamed from: C */
    public void mo1613C(RecyclerView.Recycler recycler, RecyclerView.State state, C0475g0 c0475g0, LayoutChunkResult layoutChunkResult) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int decoratedMeasurementInOther;
        boolean z2;
        View m1844b = c0475g0.m1844b(recycler);
        if (m1844b == null) {
            layoutChunkResult.mFinished = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) m1844b.getLayoutParams();
        if (c0475g0.f7390k == null) {
            boolean z3 = this.f7047v;
            if (c0475g0.f7385f == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z3 == z2) {
                addView(m1844b);
            } else {
                addView(m1844b, 0);
            }
        } else {
            boolean z4 = this.f7047v;
            if (c0475g0.f7385f == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z4 == z) {
                addDisappearingView(m1844b);
            } else {
                addDisappearingView(m1844b, 0);
            }
        }
        measureChildWithMargins(m1844b, 0, 0);
        layoutChunkResult.mConsumed = this.f7044s.getDecoratedMeasurement(m1844b);
        if (this.f7042q == 1) {
            if (isLayoutRTL()) {
                decoratedMeasurementInOther = getWidth() - getPaddingRight();
                i4 = decoratedMeasurementInOther - this.f7044s.getDecoratedMeasurementInOther(m1844b);
            } else {
                i4 = getPaddingLeft();
                decoratedMeasurementInOther = this.f7044s.getDecoratedMeasurementInOther(m1844b) + i4;
            }
            if (c0475g0.f7385f == -1) {
                int i5 = c0475g0.f7381b;
                i3 = i5;
                i2 = decoratedMeasurementInOther;
                i = i5 - layoutChunkResult.mConsumed;
            } else {
                int i6 = c0475g0.f7381b;
                i = i6;
                i2 = decoratedMeasurementInOther;
                i3 = layoutChunkResult.mConsumed + i6;
            }
        } else {
            int paddingTop = getPaddingTop();
            int decoratedMeasurementInOther2 = this.f7044s.getDecoratedMeasurementInOther(m1844b) + paddingTop;
            if (c0475g0.f7385f == -1) {
                int i7 = c0475g0.f7381b;
                i2 = i7;
                i = paddingTop;
                i3 = decoratedMeasurementInOther2;
                i4 = i7 - layoutChunkResult.mConsumed;
            } else {
                int i8 = c0475g0.f7381b;
                i = paddingTop;
                i2 = layoutChunkResult.mConsumed + i8;
                i3 = decoratedMeasurementInOther2;
                i4 = i8;
            }
        }
        layoutDecoratedWithMargins(m1844b, i4, i, i2, i3);
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            layoutChunkResult.mIgnoreConsumed = true;
        }
        layoutChunkResult.mFocusable = m1844b.hasFocusable();
    }

    /* renamed from: D */
    public void mo1614D(RecyclerView.Recycler recycler, RecyclerView.State state, C0472f0 c0472f0, int i) {
    }

    /* renamed from: E */
    public final void m1643E(RecyclerView.Recycler recycler, C0475g0 c0475g0) {
        if (c0475g0.f7380a && !c0475g0.f7391l) {
            int i = c0475g0.f7386g;
            int i2 = c0475g0.f7388i;
            if (c0475g0.f7385f == -1) {
                int childCount = getChildCount();
                if (i >= 0) {
                    int end = (this.f7044s.getEnd() - i) + i2;
                    if (this.f7047v) {
                        for (int i3 = 0; i3 < childCount; i3++) {
                            View childAt = getChildAt(i3);
                            if (this.f7044s.getDecoratedStart(childAt) < end || this.f7044s.getTransformedStartWithDecoration(childAt) < end) {
                                m1644F(recycler, 0, i3);
                                return;
                            }
                        }
                        return;
                    }
                    int i4 = childCount - 1;
                    for (int i5 = i4; i5 >= 0; i5--) {
                        View childAt2 = getChildAt(i5);
                        if (this.f7044s.getDecoratedStart(childAt2) < end || this.f7044s.getTransformedStartWithDecoration(childAt2) < end) {
                            m1644F(recycler, i4, i5);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (i >= 0) {
                int i6 = i - i2;
                int childCount2 = getChildCount();
                if (this.f7047v) {
                    int i7 = childCount2 - 1;
                    for (int i8 = i7; i8 >= 0; i8--) {
                        View childAt3 = getChildAt(i8);
                        if (this.f7044s.getDecoratedEnd(childAt3) > i6 || this.f7044s.getTransformedEndWithDecoration(childAt3) > i6) {
                            m1644F(recycler, i7, i8);
                            return;
                        }
                    }
                    return;
                }
                for (int i9 = 0; i9 < childCount2; i9++) {
                    View childAt4 = getChildAt(i9);
                    if (this.f7044s.getDecoratedEnd(childAt4) > i6 || this.f7044s.getTransformedEndWithDecoration(childAt4) > i6) {
                        m1644F(recycler, 0, i9);
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: F */
    public final void m1644F(RecyclerView.Recycler recycler, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 > i) {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                removeAndRecycleViewAt(i3, recycler);
            }
            return;
        }
        while (i > i2) {
            removeAndRecycleViewAt(i, recycler);
            i--;
        }
    }

    /* renamed from: G */
    public final void m1645G() {
        if (this.f7042q != 1 && isLayoutRTL()) {
            this.f7047v = !this.f7046u;
        } else {
            this.f7047v = this.f7046u;
        }
    }

    /* renamed from: H */
    public final int m1646H(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        m1655r();
        this.f7043r.f7380a = true;
        if (i > 0) {
            i2 = 1;
        } else {
            i2 = -1;
        }
        int abs = Math.abs(i);
        m1647I(i2, abs, true, state);
        C0475g0 c0475g0 = this.f7043r;
        int m1656s = m1656s(recycler, c0475g0, state, false) + c0475g0.f7386g;
        if (m1656s < 0) {
            return 0;
        }
        if (abs > m1656s) {
            i = i2 * m1656s;
        }
        this.f7044s.offsetChildren(-i);
        this.f7043r.f7389j = i;
        return i;
    }

    /* renamed from: I */
    public final void m1647I(int i, int i2, boolean z, RecyclerView.State state) {
        boolean z2;
        int i3;
        int startAfterPadding;
        C0475g0 c0475g0 = this.f7043r;
        boolean z3 = false;
        int i4 = 1;
        if (this.f7044s.getMode() == 0 && this.f7044s.getEnd() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        c0475g0.f7391l = z2;
        this.f7043r.f7385f = i;
        int[] iArr = this.f7041F;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(state, iArr);
        int max = Math.max(0, iArr[0]);
        int max2 = Math.max(0, iArr[1]);
        if (i == 1) {
            z3 = true;
        }
        C0475g0 c0475g02 = this.f7043r;
        if (z3) {
            i3 = max2;
        } else {
            i3 = max;
        }
        c0475g02.f7387h = i3;
        if (!z3) {
            max = max2;
        }
        c0475g02.f7388i = max;
        if (z3) {
            c0475g02.f7387h = this.f7044s.getEndPadding() + i3;
            View m1641A = m1641A();
            C0475g0 c0475g03 = this.f7043r;
            if (this.f7047v) {
                i4 = -1;
            }
            c0475g03.f7384e = i4;
            int position = getPosition(m1641A);
            C0475g0 c0475g04 = this.f7043r;
            c0475g03.f7383d = position + c0475g04.f7384e;
            c0475g04.f7381b = this.f7044s.getDecoratedEnd(m1641A);
            startAfterPadding = this.f7044s.getDecoratedEnd(m1641A) - this.f7044s.getEndAfterPadding();
        } else {
            View m1642B = m1642B();
            C0475g0 c0475g05 = this.f7043r;
            c0475g05.f7387h = this.f7044s.getStartAfterPadding() + c0475g05.f7387h;
            C0475g0 c0475g06 = this.f7043r;
            if (!this.f7047v) {
                i4 = -1;
            }
            c0475g06.f7384e = i4;
            int position2 = getPosition(m1642B);
            C0475g0 c0475g07 = this.f7043r;
            c0475g06.f7383d = position2 + c0475g07.f7384e;
            c0475g07.f7381b = this.f7044s.getDecoratedStart(m1642B);
            startAfterPadding = (-this.f7044s.getDecoratedStart(m1642B)) + this.f7044s.getStartAfterPadding();
        }
        C0475g0 c0475g08 = this.f7043r;
        c0475g08.f7382c = i2;
        if (z) {
            c0475g08.f7382c = i2 - startAfterPadding;
        }
        c0475g08.f7386g = startAfterPadding;
    }

    /* renamed from: J */
    public final void m1648J(int i, int i2) {
        int i3;
        this.f7043r.f7382c = this.f7044s.getEndAfterPadding() - i2;
        C0475g0 c0475g0 = this.f7043r;
        if (this.f7047v) {
            i3 = -1;
        } else {
            i3 = 1;
        }
        c0475g0.f7384e = i3;
        c0475g0.f7383d = i;
        c0475g0.f7385f = 1;
        c0475g0.f7381b = i2;
        c0475g0.f7386g = Integer.MIN_VALUE;
    }

    /* renamed from: K */
    public final void m1649K(int i, int i2) {
        int i3;
        this.f7043r.f7382c = i2 - this.f7044s.getStartAfterPadding();
        C0475g0 c0475g0 = this.f7043r;
        c0475g0.f7383d = i;
        if (this.f7047v) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        c0475g0.f7384e = i3;
        c0475g0.f7385f = -1;
        c0475g0.f7381b = i2;
        c0475g0.f7386g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void assertNotInLayoutOrScroll(String str) {
        if (this.f7037B == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
        int i;
        int extraLayoutSpace = getExtraLayoutSpace(state);
        if (this.f7043r.f7385f == -1) {
            i = 0;
        } else {
            i = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.f7042q == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.f7042q == 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i3;
        if (this.f7042q != 0) {
            i = i2;
        }
        if (getChildCount() != 0 && i != 0) {
            m1655r();
            if (i > 0) {
                i3 = 1;
            } else {
                i3 = -1;
            }
            m1647I(i3, Math.abs(i), true, state);
            mo1625m(state, this.f7043r, layoutPrefetchRegistry);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void collectInitialPrefetchPositions(int i, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        boolean z;
        int i2;
        SavedState savedState = this.f7037B;
        int i3 = -1;
        if (savedState != null && (i2 = savedState.f7052a) >= 0) {
            z = savedState.f7054c;
        } else {
            m1645G();
            z = this.f7047v;
            i2 = this.f7050y;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        }
        if (!z) {
            i3 = 1;
        }
        for (int i4 = 0; i4 < this.f7040E && i2 >= 0 && i2 < i; i4++) {
            layoutPrefetchRegistry.addPosition(i2, 0);
            i2 += i3;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return m1651n(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return m1652o(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return m1653p(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    @SuppressLint({"UnknownNullness"})
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        boolean z = false;
        int i2 = 1;
        if (i < getPosition(getChildAt(0))) {
            z = true;
        }
        if (z != this.f7047v) {
            i2 = -1;
        }
        if (this.f7042q == 0) {
            return new PointF(i2, RecyclerView.f7068F0);
        }
        return new PointF(RecyclerView.f7068F0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return m1651n(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return m1652o(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return m1653p(state);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View m1660w = m1660w(0, getChildCount(), true, false);
        if (m1660w == null) {
            return -1;
        }
        return getPosition(m1660w);
    }

    public int findFirstVisibleItemPosition() {
        View m1660w = m1660w(0, getChildCount(), false, true);
        if (m1660w == null) {
            return -1;
        }
        return getPosition(m1660w);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View m1660w = m1660w(getChildCount() - 1, -1, true, false);
        if (m1660w == null) {
            return -1;
        }
        return getPosition(m1660w);
    }

    public int findLastVisibleItemPosition() {
        View m1660w = m1660w(getChildCount() - 1, -1, false, true);
        if (m1660w == null) {
            return -1;
        }
        return getPosition(m1660w);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.State state) {
        if (state.hasTargetScrollPosition()) {
            return this.f7044s.getTotalSpace();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.f7040E;
    }

    public int getOrientation() {
        return this.f7042q;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.f7036A;
    }

    public boolean getReverseLayout() {
        return this.f7046u;
    }

    public boolean getStackFromEnd() {
        return this.f7048w;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.f7049x;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /* renamed from: k */
    public final boolean mo1650k() {
        if (getHeightMode() == 1073741824 || getWidthMode() == 1073741824) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
            if (layoutParams.width < 0 && layoutParams.height < 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: m */
    public void mo1625m(RecyclerView.State state, C0475g0 c0475g0, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i = c0475g0.f7383d;
        if (i >= 0 && i < state.getItemCount()) {
            layoutPrefetchRegistry.addPosition(i, Math.max(0, c0475g0.f7386g));
        }
    }

    /* renamed from: n */
    public final int m1651n(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        m1655r();
        return AbstractC0464c1.m1823a(state, this.f7044s, m1658u(!this.f7049x), m1657t(!this.f7049x), this, this.f7049x);
    }

    /* renamed from: o */
    public final int m1652o(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        m1655r();
        return AbstractC0464c1.m1824b(state, this.f7044s, m1658u(!this.f7049x), m1657t(!this.f7049x), this, this.f7049x, this.f7047v);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.f7036A) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int m1654q;
        View m1659v;
        View m1641A;
        m1645G();
        if (getChildCount() == 0 || (m1654q = m1654q(i)) == Integer.MIN_VALUE) {
            return null;
        }
        m1655r();
        m1647I(m1654q, (int) (this.f7044s.getTotalSpace() * 0.33333334f), false, state);
        C0475g0 c0475g0 = this.f7043r;
        c0475g0.f7386g = Integer.MIN_VALUE;
        c0475g0.f7380a = false;
        m1656s(recycler, c0475g0, state, true);
        if (m1654q == -1) {
            if (this.f7047v) {
                m1659v = m1659v(getChildCount() - 1, -1);
            } else {
                m1659v = m1659v(0, getChildCount());
            }
        } else if (this.f7047v) {
            m1659v = m1659v(0, getChildCount());
        } else {
            m1659v = m1659v(getChildCount() - 1, -1);
        }
        if (m1654q == -1) {
            m1641A = m1642B();
        } else {
            m1641A = m1641A();
        }
        if (m1641A.hasFocusable()) {
            if (m1659v == null) {
                return null;
            }
            return m1641A;
        }
        return m1659v;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        View mo1626x;
        boolean z;
        boolean z2;
        int i2;
        boolean z3;
        boolean z4;
        int decoratedStart;
        int i3;
        boolean z5;
        int i4;
        int i5;
        boolean z6;
        int i6;
        int i7;
        int m1661y;
        int i8;
        View findViewByPosition;
        int decoratedStart2;
        int i9;
        int i10;
        int i11 = -1;
        if ((this.f7037B != null || this.f7050y != -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        SavedState savedState = this.f7037B;
        if (savedState != null && (i10 = savedState.f7052a) >= 0) {
            this.f7050y = i10;
        }
        m1655r();
        this.f7043r.f7380a = false;
        m1645G();
        View focusedChild = getFocusedChild();
        C0472f0 c0472f0 = this.f7038C;
        boolean z7 = true;
        if (c0472f0.f7374e && this.f7050y == -1 && this.f7037B == null) {
            if (focusedChild != null && (this.f7044s.getDecoratedStart(focusedChild) >= this.f7044s.getEndAfterPadding() || this.f7044s.getDecoratedEnd(focusedChild) <= this.f7044s.getStartAfterPadding())) {
                c0472f0.m1829c(getPosition(focusedChild), focusedChild);
            }
        } else {
            c0472f0.m1830d();
            c0472f0.f7373d = this.f7047v ^ this.f7048w;
            if (!state.isPreLayout() && (i2 = this.f7050y) != -1) {
                if (i2 >= 0 && i2 < state.getItemCount()) {
                    int i12 = this.f7050y;
                    c0472f0.f7371b = i12;
                    SavedState savedState2 = this.f7037B;
                    if (savedState2 != null && savedState2.f7052a >= 0) {
                        boolean z8 = savedState2.f7054c;
                        c0472f0.f7373d = z8;
                        if (z8) {
                            c0472f0.f7372c = this.f7044s.getEndAfterPadding() - this.f7037B.f7053b;
                        } else {
                            c0472f0.f7372c = this.f7044s.getStartAfterPadding() + this.f7037B.f7053b;
                        }
                    } else if (this.f7051z == Integer.MIN_VALUE) {
                        View findViewByPosition2 = findViewByPosition(i12);
                        if (findViewByPosition2 != null) {
                            if (this.f7044s.getDecoratedMeasurement(findViewByPosition2) > this.f7044s.getTotalSpace()) {
                                c0472f0.m1827a();
                            } else if (this.f7044s.getDecoratedStart(findViewByPosition2) - this.f7044s.getStartAfterPadding() < 0) {
                                c0472f0.f7372c = this.f7044s.getStartAfterPadding();
                                c0472f0.f7373d = false;
                            } else if (this.f7044s.getEndAfterPadding() - this.f7044s.getDecoratedEnd(findViewByPosition2) < 0) {
                                c0472f0.f7372c = this.f7044s.getEndAfterPadding();
                                c0472f0.f7373d = true;
                            } else {
                                if (c0472f0.f7373d) {
                                    decoratedStart = this.f7044s.getTotalSpaceChange() + this.f7044s.getDecoratedEnd(findViewByPosition2);
                                } else {
                                    decoratedStart = this.f7044s.getDecoratedStart(findViewByPosition2);
                                }
                                c0472f0.f7372c = decoratedStart;
                            }
                        } else {
                            if (getChildCount() > 0) {
                                if (this.f7050y < getPosition(getChildAt(0))) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3 == this.f7047v) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                c0472f0.f7373d = z4;
                            }
                            c0472f0.m1827a();
                        }
                    } else {
                        boolean z9 = this.f7047v;
                        c0472f0.f7373d = z9;
                        if (z9) {
                            c0472f0.f7372c = this.f7044s.getEndAfterPadding() - this.f7051z;
                        } else {
                            c0472f0.f7372c = this.f7044s.getStartAfterPadding() + this.f7051z;
                        }
                    }
                    c0472f0.f7374e = true;
                } else {
                    this.f7050y = -1;
                    this.f7051z = Integer.MIN_VALUE;
                }
            }
            if (getChildCount() != 0) {
                View focusedChild2 = getFocusedChild();
                if (focusedChild2 != null) {
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) focusedChild2.getLayoutParams();
                    if (!layoutParams.isItemRemoved() && layoutParams.getViewLayoutPosition() >= 0 && layoutParams.getViewLayoutPosition() < state.getItemCount()) {
                        c0472f0.m1829c(getPosition(focusedChild2), focusedChild2);
                        c0472f0.f7374e = true;
                    }
                }
                boolean z10 = this.f7045t;
                boolean z11 = this.f7048w;
                if (z10 == z11 && (mo1626x = mo1626x(recycler, state, c0472f0.f7373d, z11)) != null) {
                    c0472f0.m1828b(getPosition(mo1626x), mo1626x);
                    if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                        int decoratedStart3 = this.f7044s.getDecoratedStart(mo1626x);
                        int decoratedEnd = this.f7044s.getDecoratedEnd(mo1626x);
                        int startAfterPadding = this.f7044s.getStartAfterPadding();
                        int endAfterPadding = this.f7044s.getEndAfterPadding();
                        if (decoratedEnd <= startAfterPadding && decoratedStart3 < startAfterPadding) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (decoratedStart3 >= endAfterPadding && decoratedEnd > endAfterPadding) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z || z2) {
                            if (c0472f0.f7373d) {
                                startAfterPadding = endAfterPadding;
                            }
                            c0472f0.f7372c = startAfterPadding;
                        }
                    }
                    c0472f0.f7374e = true;
                }
            }
            c0472f0.m1827a();
            if (this.f7048w) {
                i = state.getItemCount() - 1;
            } else {
                i = 0;
            }
            c0472f0.f7371b = i;
            c0472f0.f7374e = true;
        }
        C0475g0 c0475g0 = this.f7043r;
        if (c0475g0.f7389j >= 0) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        c0475g0.f7385f = i3;
        int[] iArr = this.f7041F;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(state, iArr);
        int startAfterPadding2 = this.f7044s.getStartAfterPadding() + Math.max(0, iArr[0]);
        int endPadding = this.f7044s.getEndPadding() + Math.max(0, iArr[1]);
        if (state.isPreLayout() && (i8 = this.f7050y) != -1 && this.f7051z != Integer.MIN_VALUE && (findViewByPosition = findViewByPosition(i8)) != null) {
            if (this.f7047v) {
                i9 = this.f7044s.getEndAfterPadding() - this.f7044s.getDecoratedEnd(findViewByPosition);
                decoratedStart2 = this.f7051z;
            } else {
                decoratedStart2 = this.f7044s.getDecoratedStart(findViewByPosition) - this.f7044s.getStartAfterPadding();
                i9 = this.f7051z;
            }
            int i13 = i9 - decoratedStart2;
            if (i13 > 0) {
                startAfterPadding2 += i13;
            } else {
                endPadding -= i13;
            }
        }
        if (!c0472f0.f7373d ? !this.f7047v : this.f7047v) {
            i11 = 1;
        }
        mo1614D(recycler, state, c0472f0, i11);
        detachAndScrapAttachedViews(recycler);
        C0475g0 c0475g02 = this.f7043r;
        if (this.f7044s.getMode() == 0 && this.f7044s.getEnd() == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        c0475g02.f7391l = z5;
        C0475g0 c0475g03 = this.f7043r;
        state.isPreLayout();
        c0475g03.getClass();
        this.f7043r.f7388i = 0;
        if (c0472f0.f7373d) {
            m1649K(c0472f0.f7371b, c0472f0.f7372c);
            C0475g0 c0475g04 = this.f7043r;
            c0475g04.f7387h = startAfterPadding2;
            m1656s(recycler, c0475g04, state, false);
            C0475g0 c0475g05 = this.f7043r;
            i5 = c0475g05.f7381b;
            int i14 = c0475g05.f7383d;
            int i15 = c0475g05.f7382c;
            if (i15 > 0) {
                endPadding += i15;
            }
            m1648J(c0472f0.f7371b, c0472f0.f7372c);
            C0475g0 c0475g06 = this.f7043r;
            c0475g06.f7387h = endPadding;
            c0475g06.f7383d += c0475g06.f7384e;
            m1656s(recycler, c0475g06, state, false);
            C0475g0 c0475g07 = this.f7043r;
            i4 = c0475g07.f7381b;
            int i16 = c0475g07.f7382c;
            if (i16 > 0) {
                m1649K(i14, i5);
                C0475g0 c0475g08 = this.f7043r;
                c0475g08.f7387h = i16;
                m1656s(recycler, c0475g08, state, false);
                i5 = this.f7043r.f7381b;
            }
        } else {
            m1648J(c0472f0.f7371b, c0472f0.f7372c);
            C0475g0 c0475g09 = this.f7043r;
            c0475g09.f7387h = endPadding;
            m1656s(recycler, c0475g09, state, false);
            C0475g0 c0475g010 = this.f7043r;
            i4 = c0475g010.f7381b;
            int i17 = c0475g010.f7383d;
            int i18 = c0475g010.f7382c;
            if (i18 > 0) {
                startAfterPadding2 += i18;
            }
            m1649K(c0472f0.f7371b, c0472f0.f7372c);
            C0475g0 c0475g011 = this.f7043r;
            c0475g011.f7387h = startAfterPadding2;
            c0475g011.f7383d += c0475g011.f7384e;
            m1656s(recycler, c0475g011, state, false);
            C0475g0 c0475g012 = this.f7043r;
            int i19 = c0475g012.f7381b;
            int i20 = c0475g012.f7382c;
            if (i20 > 0) {
                m1648J(i17, i4);
                C0475g0 c0475g013 = this.f7043r;
                c0475g013.f7387h = i20;
                m1656s(recycler, c0475g013, state, false);
                i4 = this.f7043r.f7381b;
            }
            i5 = i19;
        }
        if (getChildCount() > 0) {
            if (this.f7047v ^ this.f7048w) {
                int m1661y2 = m1661y(i4, recycler, state, true);
                i6 = i5 + m1661y2;
                i7 = i4 + m1661y2;
                m1661y = m1662z(i6, recycler, state, false);
            } else {
                int m1662z = m1662z(i5, recycler, state, true);
                i6 = i5 + m1662z;
                i7 = i4 + m1662z;
                m1661y = m1661y(i7, recycler, state, false);
            }
            i5 = i6 + m1661y;
            i4 = i7 + m1661y;
        }
        if (state.willRunPredictiveAnimations() && getChildCount() != 0 && !state.isPreLayout() && supportsPredictiveItemAnimations()) {
            List<RecyclerView.ViewHolder> scrapList = recycler.getScrapList();
            int size = scrapList.size();
            int position = getPosition(getChildAt(0));
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            while (i21 < size) {
                RecyclerView.ViewHolder viewHolder = scrapList.get(i21);
                if (!viewHolder.m1762g()) {
                    if (viewHolder.getLayoutPosition() < position) {
                        z6 = z7;
                    } else {
                        z6 = false;
                    }
                    if (z6 != this.f7047v) {
                        i22 += this.f7044s.getDecoratedMeasurement(viewHolder.itemView);
                    } else {
                        i23 += this.f7044s.getDecoratedMeasurement(viewHolder.itemView);
                    }
                }
                i21++;
                z7 = true;
            }
            this.f7043r.f7390k = scrapList;
            if (i22 > 0) {
                m1649K(getPosition(m1642B()), i5);
                C0475g0 c0475g014 = this.f7043r;
                c0475g014.f7387h = i22;
                c0475g014.f7382c = 0;
                c0475g014.m1843a(null);
                m1656s(recycler, this.f7043r, state, false);
            }
            if (i23 > 0) {
                m1648J(getPosition(m1641A()), i4);
                C0475g0 c0475g015 = this.f7043r;
                c0475g015.f7387h = i23;
                c0475g015.f7382c = 0;
                c0475g015.m1843a(null);
                m1656s(recycler, this.f7043r, state, false);
            }
            this.f7043r.f7390k = null;
        }
        if (!state.isPreLayout()) {
            this.f7044s.onLayoutComplete();
        } else {
            c0472f0.m1830d();
        }
        this.f7045t = this.f7048w;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f7037B = null;
        this.f7050y = -1;
        this.f7051z = Integer.MIN_VALUE;
        this.f7038C.m1830d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f7037B = savedState;
            if (this.f7050y != -1) {
                savedState.f7052a = -1;
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public Parcelable onSaveInstanceState() {
        SavedState savedState = this.f7037B;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        if (getChildCount() > 0) {
            m1655r();
            boolean z = this.f7045t ^ this.f7047v;
            savedState2.f7054c = z;
            if (z) {
                View m1641A = m1641A();
                savedState2.f7053b = this.f7044s.getEndAfterPadding() - this.f7044s.getDecoratedEnd(m1641A);
                savedState2.f7052a = getPosition(m1641A);
            } else {
                View m1642B = m1642B();
                savedState2.f7052a = getPosition(m1642B);
                savedState2.f7053b = this.f7044s.getDecoratedStart(m1642B) - this.f7044s.getStartAfterPadding();
            }
        } else {
            savedState2.f7052a = -1;
        }
        return savedState2;
    }

    /* renamed from: p */
    public final int m1653p(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        m1655r();
        return AbstractC0464c1.m1825c(state, this.f7044s, m1658u(!this.f7049x), m1657t(!this.f7049x), this, this.f7049x);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.ViewDropHandler
    public void prepareForDrop(@NonNull View view, @NonNull View view2, int i, int i2) {
        char c;
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        m1655r();
        m1645G();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        if (position < position2) {
            c = 1;
        } else {
            c = 65535;
        }
        if (this.f7047v) {
            if (c == 1) {
                scrollToPositionWithOffset(position2, this.f7044s.getEndAfterPadding() - (this.f7044s.getDecoratedMeasurement(view) + this.f7044s.getDecoratedStart(view2)));
                return;
            }
            scrollToPositionWithOffset(position2, this.f7044s.getEndAfterPadding() - this.f7044s.getDecoratedEnd(view2));
            return;
        }
        if (c == 65535) {
            scrollToPositionWithOffset(position2, this.f7044s.getDecoratedStart(view2));
        } else {
            scrollToPositionWithOffset(position2, this.f7044s.getDecoratedEnd(view2) - this.f7044s.getDecoratedMeasurement(view));
        }
    }

    /* renamed from: q */
    public final int m1654q(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 17) {
                    if (i != 33) {
                        if (i != 66) {
                            if (i == 130 && this.f7042q == 1) {
                                return 1;
                            }
                            return Integer.MIN_VALUE;
                        }
                        if (this.f7042q == 0) {
                            return 1;
                        }
                        return Integer.MIN_VALUE;
                    }
                    if (this.f7042q == 1) {
                        return -1;
                    }
                    return Integer.MIN_VALUE;
                }
                if (this.f7042q == 0) {
                    return -1;
                }
                return Integer.MIN_VALUE;
            }
            if (this.f7042q != 1 && isLayoutRTL()) {
                return -1;
            }
            return 1;
        }
        if (this.f7042q == 1 || !isLayoutRTL()) {
            return -1;
        }
        return 1;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.recyclerview.widget.g0, java.lang.Object] */
    /* renamed from: r */
    public final void m1655r() {
        if (this.f7043r == null) {
            ?? obj = new Object();
            obj.f7380a = true;
            obj.f7387h = 0;
            obj.f7388i = 0;
            obj.f7390k = null;
            this.f7043r = obj;
        }
    }

    /* renamed from: s */
    public final int m1656s(RecyclerView.Recycler recycler, C0475g0 c0475g0, RecyclerView.State state, boolean z) {
        int i;
        int i2 = c0475g0.f7382c;
        int i3 = c0475g0.f7386g;
        if (i3 != Integer.MIN_VALUE) {
            if (i2 < 0) {
                c0475g0.f7386g = i3 + i2;
            }
            m1643E(recycler, c0475g0);
        }
        int i4 = c0475g0.f7382c + c0475g0.f7387h;
        while (true) {
            if ((!c0475g0.f7391l && i4 <= 0) || (i = c0475g0.f7383d) < 0 || i >= state.getItemCount()) {
                break;
            }
            LayoutChunkResult layoutChunkResult = this.f7039D;
            layoutChunkResult.mConsumed = 0;
            layoutChunkResult.mFinished = false;
            layoutChunkResult.mIgnoreConsumed = false;
            layoutChunkResult.mFocusable = false;
            mo1613C(recycler, state, c0475g0, layoutChunkResult);
            if (!layoutChunkResult.mFinished) {
                c0475g0.f7381b = (layoutChunkResult.mConsumed * c0475g0.f7385f) + c0475g0.f7381b;
                if (!layoutChunkResult.mIgnoreConsumed || c0475g0.f7390k != null || !state.isPreLayout()) {
                    int i5 = c0475g0.f7382c;
                    int i6 = layoutChunkResult.mConsumed;
                    c0475g0.f7382c = i5 - i6;
                    i4 -= i6;
                }
                int i7 = c0475g0.f7386g;
                if (i7 != Integer.MIN_VALUE) {
                    int i8 = i7 + layoutChunkResult.mConsumed;
                    c0475g0.f7386g = i8;
                    int i9 = c0475g0.f7382c;
                    if (i9 < 0) {
                        c0475g0.f7386g = i8 + i9;
                    }
                    m1643E(recycler, c0475g0);
                }
                if (z && layoutChunkResult.mFocusable) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - c0475g0.f7382c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f7042q == 1) {
            return 0;
        }
        return m1646H(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.f7050y = i;
        this.f7051z = Integer.MIN_VALUE;
        SavedState savedState = this.f7037B;
        if (savedState != null) {
            savedState.f7052a = -1;
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.f7050y = i;
        this.f7051z = i2;
        SavedState savedState = this.f7037B;
        if (savedState != null) {
            savedState.f7052a = -1;
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f7042q == 0) {
            return 0;
        }
        return m1646H(i, recycler, state);
    }

    public void setInitialPrefetchItemCount(int i) {
        this.f7040E = i;
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(ye0.m8291k(i, "invalid orientation:"));
        }
        assertNotInLayoutOrScroll(null);
        if (i != this.f7042q || this.f7044s == null) {
            OrientationHelper createOrientationHelper = OrientationHelper.createOrientationHelper(this, i);
            this.f7044s = createOrientationHelper;
            this.f7038C.f7370a = createOrientationHelper;
            this.f7042q = i;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.f7036A = z;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z == this.f7046u) {
            return;
        }
        this.f7046u = z;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.f7049x = z;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.f7048w == z) {
            return;
        }
        this.f7048w = z;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        if (this.f7037B == null && this.f7045t == this.f7048w) {
            return true;
        }
        return false;
    }

    /* renamed from: t */
    public final View m1657t(boolean z) {
        if (this.f7047v) {
            return m1660w(0, getChildCount(), z, true);
        }
        return m1660w(getChildCount() - 1, -1, z, true);
    }

    /* renamed from: u */
    public final View m1658u(boolean z) {
        if (this.f7047v) {
            return m1660w(getChildCount() - 1, -1, z, true);
        }
        return m1660w(0, getChildCount(), z, true);
    }

    /* renamed from: v */
    public final View m1659v(int i, int i2) {
        int i3;
        int i4;
        m1655r();
        if (i2 > i || i2 < i) {
            if (this.f7044s.getDecoratedStart(getChildAt(i)) < this.f7044s.getStartAfterPadding()) {
                i3 = 16644;
                i4 = 16388;
            } else {
                i3 = 4161;
                i4 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
            }
            if (this.f7042q == 0) {
                return this.f7164c.m6093c(i, i2, i3, i4);
            }
            return this.f7165d.m6093c(i, i2, i3, i4);
        }
        return getChildAt(i);
    }

    /* renamed from: w */
    public final View m1660w(int i, int i2, boolean z, boolean z2) {
        int i3;
        m1655r();
        int i4 = 320;
        if (z) {
            i3 = 24579;
        } else {
            i3 = 320;
        }
        if (!z2) {
            i4 = 0;
        }
        if (this.f7042q == 0) {
            return this.f7164c.m6093c(i, i2, i3, i4);
        }
        return this.f7165d.m6093c(i, i2, i3, i4);
    }

    /* renamed from: x */
    public View mo1626x(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        boolean z3;
        boolean z4;
        m1655r();
        int childCount = getChildCount();
        if (z2) {
            i2 = getChildCount() - 1;
            i = -1;
            i3 = -1;
        } else {
            i = childCount;
            i2 = 0;
            i3 = 1;
        }
        int itemCount = state.getItemCount();
        int startAfterPadding = this.f7044s.getStartAfterPadding();
        int endAfterPadding = this.f7044s.getEndAfterPadding();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i2 != i) {
            View childAt = getChildAt(i2);
            int position = getPosition(childAt);
            int decoratedStart = this.f7044s.getDecoratedStart(childAt);
            int decoratedEnd = this.f7044s.getDecoratedEnd(childAt);
            if (position >= 0 && position < itemCount) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view3 == null) {
                        view3 = childAt;
                    }
                } else {
                    if (decoratedEnd <= startAfterPadding && decoratedStart < startAfterPadding) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (decoratedStart >= endAfterPadding && decoratedEnd > endAfterPadding) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (!z3 && !z4) {
                        return childAt;
                    }
                    if (z) {
                        if (!z4) {
                            if (view != null) {
                            }
                            view = childAt;
                        }
                        view2 = childAt;
                    } else {
                        if (!z3) {
                            if (view != null) {
                            }
                            view = childAt;
                        }
                        view2 = childAt;
                    }
                }
            }
            i2 += i3;
        }
        if (view == null) {
            if (view2 != null) {
                return view2;
            }
            return view3;
        }
        return view;
    }

    /* renamed from: y */
    public final int m1661y(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int endAfterPadding;
        int endAfterPadding2 = this.f7044s.getEndAfterPadding() - i;
        if (endAfterPadding2 > 0) {
            int i2 = -m1646H(-endAfterPadding2, recycler, state);
            int i3 = i + i2;
            if (z && (endAfterPadding = this.f7044s.getEndAfterPadding() - i3) > 0) {
                this.f7044s.offsetChildren(endAfterPadding);
                return endAfterPadding + i2;
            }
            return i2;
        }
        return 0;
    }

    /* renamed from: z */
    public final int m1662z(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int startAfterPadding;
        int startAfterPadding2 = i - this.f7044s.getStartAfterPadding();
        if (startAfterPadding2 > 0) {
            int i2 = -m1646H(startAfterPadding2, recycler, state);
            int i3 = i + i2;
            if (z && (startAfterPadding = i3 - this.f7044s.getStartAfterPadding()) > 0) {
                this.f7044s.offsetChildren(-startAfterPadding);
                return i2 - startAfterPadding;
            }
            return i2;
        }
        return 0;
    }

    public LinearLayoutManager(@SuppressLint({"UnknownNullness"}) Context context, int i, boolean z) {
        this.f7042q = 1;
        this.f7046u = false;
        this.f7047v = false;
        this.f7048w = false;
        this.f7049x = true;
        this.f7050y = -1;
        this.f7051z = Integer.MIN_VALUE;
        this.f7037B = null;
        this.f7038C = new C0472f0();
        this.f7039D = new LayoutChunkResult();
        this.f7040E = 2;
        this.f7041F = new int[2];
        setOrientation(i);
        setReverseLayout(z);
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f7042q = 1;
        this.f7046u = false;
        this.f7047v = false;
        this.f7048w = false;
        this.f7049x = true;
        this.f7050y = -1;
        this.f7051z = Integer.MIN_VALUE;
        this.f7037B = null;
        this.f7038C = new C0472f0();
        this.f7039D = new LayoutChunkResult();
        this.f7040E = 2;
        this.f7041F = new int[2];
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setReverseLayout(properties.reverseLayout);
        setStackFromEnd(properties.stackFromEnd);
    }
}
