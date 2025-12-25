package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import p000.ye0;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public static final int DEFAULT_SPAN_COUNT = -1;

    /* renamed from: G */
    public boolean f6987G;

    /* renamed from: H */
    public int f6988H;

    /* renamed from: I */
    public int[] f6989I;

    /* renamed from: J */
    public View[] f6990J;

    /* renamed from: K */
    public final SparseIntArray f6991K;

    /* renamed from: L */
    public final SparseIntArray f6992L;

    /* renamed from: M */
    public SpanSizeLookup f6993M;

    /* renamed from: N */
    public final Rect f6994N;

    /* renamed from: O */
    public boolean f6995O;

    /* loaded from: classes.dex */
    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanIndex(int i, int i2) {
            return i % i2;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            return 1;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SpanSizeLookup {

        /* renamed from: a */
        public final SparseIntArray f6998a = new SparseIntArray();

        /* renamed from: b */
        public final SparseIntArray f6999b = new SparseIntArray();

        /* renamed from: c */
        public boolean f7000c = false;

        /* renamed from: d */
        public boolean f7001d = false;

        /* renamed from: a */
        public static int m1627a(SparseIntArray sparseIntArray, int i) {
            int size = sparseIntArray.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 >= 0 && i4 < sparseIntArray.size()) {
                return sparseIntArray.keyAt(i4);
            }
            return -1;
        }

        /* renamed from: b */
        public final int m1628b(int i, int i2) {
            if (!this.f7001d) {
                return getSpanGroupIndex(i, i2);
            }
            SparseIntArray sparseIntArray = this.f6999b;
            int i3 = sparseIntArray.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int spanGroupIndex = getSpanGroupIndex(i, i2);
            sparseIntArray.put(i, spanGroupIndex);
            return spanGroupIndex;
        }

        /* renamed from: c */
        public final int m1629c(int i, int i2) {
            if (!this.f7000c) {
                return getSpanIndex(i, i2);
            }
            SparseIntArray sparseIntArray = this.f6998a;
            int i3 = sparseIntArray.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int spanIndex = getSpanIndex(i, i2);
            sparseIntArray.put(i, spanIndex);
            return spanIndex;
        }

        public int getSpanGroupIndex(int i, int i2) {
            int i3;
            int i4;
            int i5;
            SparseIntArray sparseIntArray;
            int m1627a;
            if (this.f7001d && (m1627a = m1627a((sparseIntArray = this.f6999b), i)) != -1) {
                i3 = sparseIntArray.get(m1627a);
                i5 = m1627a + 1;
                i4 = getSpanSize(m1627a) + m1629c(m1627a, i2);
                if (i4 == i2) {
                    i3++;
                    i4 = 0;
                }
            } else {
                i3 = 0;
                i4 = 0;
                i5 = 0;
            }
            int spanSize = getSpanSize(i);
            while (i5 < i) {
                int spanSize2 = getSpanSize(i5);
                i4 += spanSize2;
                if (i4 == i2) {
                    i3++;
                    i4 = 0;
                } else if (i4 > i2) {
                    i3++;
                    i4 = spanSize2;
                }
                i5++;
            }
            if (i4 + spanSize > i2) {
                return i3 + 1;
            }
            return i3;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0029 -> B:10:0x002e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002b -> B:10:0x002e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002d -> B:10:0x002e). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int getSpanIndex(int i, int i2) {
            int i3;
            int i4;
            SparseIntArray sparseIntArray;
            int spanSize = getSpanSize(i);
            if (spanSize == i2) {
                return 0;
            }
            if (this.f7000c && (i3 = m1627a((sparseIntArray = this.f6998a), i)) >= 0) {
                i4 = getSpanSize(i3) + sparseIntArray.get(i3);
                i3++;
                if (i3 >= i) {
                }
            } else {
                i3 = 0;
                i4 = 0;
                if (i3 >= i) {
                    int spanSize2 = getSpanSize(i3);
                    i4 += spanSize2;
                    if (i4 == i2) {
                        i4 = 0;
                    } else if (i4 > i2) {
                        i4 = spanSize2;
                    }
                    i3++;
                    if (i3 >= i) {
                        if (spanSize + i4 > i2) {
                            return 0;
                        }
                        return i4;
                    }
                }
            }
        }

        public abstract int getSpanSize(int i);

        public void invalidateSpanGroupIndexCache() {
            this.f6999b.clear();
        }

        public void invalidateSpanIndexCache() {
            this.f6998a.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.f7001d;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.f7000c;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z) {
            if (!z) {
                this.f6999b.clear();
            }
            this.f7001d = z;
        }

        public void setSpanIndexCacheEnabled(boolean z) {
            if (!z) {
                this.f6999b.clear();
            }
            this.f7000c = z;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f6987G = false;
        this.f6988H = -1;
        this.f6991K = new SparseIntArray();
        this.f6992L = new SparseIntArray();
        this.f6993M = new DefaultSpanSizeLookup();
        this.f6994N = new Rect();
        setSpanCount(RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2).spanCount);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x008c, code lost:
    
        r21.mFinished = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008e, code lost:
    
        return;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /* renamed from: C */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mo1613C(RecyclerView.Recycler recycler, RecyclerView.State state, C0475g0 c0475g0, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        boolean z;
        int i;
        boolean z2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int decoratedMeasurementInOther;
        int childMeasureSpec;
        int i12;
        boolean z3;
        int i13;
        View m1844b;
        int modeInOther = this.f7044s.getModeInOther();
        if (modeInOther != 1073741824) {
            z = true;
        } else {
            z = false;
        }
        if (getChildCount() > 0) {
            i = this.f6989I[this.f6988H];
        } else {
            i = 0;
        }
        if (z) {
            m1624U();
        }
        if (c0475g0.f7384e == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i14 = this.f6988H;
        if (!z2) {
            i14 = m1621R(c0475g0.f7383d, recycler, state) + m1622S(c0475g0.f7383d, recycler, state);
        }
        int i15 = 0;
        while (i15 < this.f6988H && (i13 = c0475g0.f7383d) >= 0 && i13 < state.getItemCount() && i14 > 0) {
            int i16 = c0475g0.f7383d;
            int m1622S = m1622S(i16, recycler, state);
            if (m1622S <= this.f6988H) {
                i14 -= m1622S;
                if (i14 < 0 || (m1844b = c0475g0.m1844b(recycler)) == null) {
                    break;
                }
                this.f6990J[i15] = m1844b;
                i15++;
            } else {
                throw new IllegalArgumentException(ye0.m8298r(ye0.m8302v("Item at position ", i16, " requires ", m1622S, " spans but GridLayoutManager has only "), " spans.", this.f6988H));
            }
        }
        if (z2) {
            i4 = 1;
            i3 = i15;
            i2 = 0;
        } else {
            i2 = i15 - 1;
            i3 = -1;
            i4 = -1;
        }
        int i17 = 0;
        while (i2 != i3) {
            View view = this.f6990J[i2];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int m1622S2 = m1622S(getPosition(view), recycler, state);
            layoutParams.f6997f = m1622S2;
            layoutParams.f6996e = i17;
            i17 += m1622S2;
            i2 += i4;
        }
        float f = RecyclerView.f7068F0;
        int i18 = 0;
        for (int i19 = 0; i19 < i15; i19++) {
            View view2 = this.f6990J[i19];
            if (c0475g0.f7390k == null) {
                if (z2) {
                    addView(view2);
                    z3 = false;
                } else {
                    z3 = false;
                    addView(view2, 0);
                }
            } else {
                z3 = false;
                if (z2) {
                    addDisappearingView(view2);
                } else {
                    addDisappearingView(view2, 0);
                }
            }
            calculateItemDecorationsForChild(view2, this.f6994N);
            m1623T(modeInOther, view2, z3);
            int decoratedMeasurement = this.f7044s.getDecoratedMeasurement(view2);
            if (decoratedMeasurement > i18) {
                i18 = decoratedMeasurement;
            }
            float decoratedMeasurementInOther2 = (this.f7044s.getDecoratedMeasurementInOther(view2) * 1.0f) / ((LayoutParams) view2.getLayoutParams()).f6997f;
            if (decoratedMeasurementInOther2 > f) {
                f = decoratedMeasurementInOther2;
            }
        }
        if (z) {
            m1615L(Math.max(Math.round(f * this.f6988H), i));
            i18 = 0;
            for (int i20 = 0; i20 < i15; i20++) {
                View view3 = this.f6990J[i20];
                m1623T(1073741824, view3, true);
                int decoratedMeasurement2 = this.f7044s.getDecoratedMeasurement(view3);
                if (decoratedMeasurement2 > i18) {
                    i18 = decoratedMeasurement2;
                }
            }
        }
        for (int i21 = 0; i21 < i15; i21++) {
            View view4 = this.f6990J[i21];
            if (this.f7044s.getDecoratedMeasurement(view4) != i18) {
                LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
                Rect rect = layoutParams2.f7179b;
                int i22 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                int i23 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                int m1619P = m1619P(layoutParams2.f6996e, layoutParams2.f6997f);
                if (this.f7042q == 1) {
                    i12 = RecyclerView.LayoutManager.getChildMeasureSpec(m1619P, 1073741824, i23, ((ViewGroup.MarginLayoutParams) layoutParams2).width, false);
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18 - i22, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18 - i23, 1073741824);
                    childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(m1619P, 1073741824, i22, ((ViewGroup.MarginLayoutParams) layoutParams2).height, false);
                    i12 = makeMeasureSpec;
                }
                if (m1739l(view4, i12, childMeasureSpec, (RecyclerView.LayoutParams) view4.getLayoutParams())) {
                    view4.measure(i12, childMeasureSpec);
                }
            }
        }
        int i24 = 0;
        layoutChunkResult.mConsumed = i18;
        if (this.f7042q == 1) {
            if (c0475g0.f7385f == -1) {
                i8 = c0475g0.f7381b;
                i7 = i8 - i18;
                i6 = 0;
                i5 = 0;
            } else {
                int i25 = c0475g0.f7381b;
                i7 = i25;
                i5 = 0;
                i8 = i25 + i18;
                i6 = 0;
            }
        } else {
            if (c0475g0.f7385f == -1) {
                int i26 = c0475g0.f7381b;
                i6 = i26 - i18;
                i5 = i26;
            } else {
                int i27 = c0475g0.f7381b;
                i5 = i27 + i18;
                i6 = i27;
            }
            i7 = 0;
            i8 = 0;
        }
        while (i24 < i15) {
            View view5 = this.f6990J[i24];
            LayoutParams layoutParams3 = (LayoutParams) view5.getLayoutParams();
            if (this.f7042q == 1) {
                if (isLayoutRTL()) {
                    int paddingLeft = getPaddingLeft() + this.f6989I[this.f6988H - layoutParams3.f6996e];
                    i10 = paddingLeft;
                    i11 = i7;
                    decoratedMeasurementInOther = i8;
                    i9 = paddingLeft - this.f7044s.getDecoratedMeasurementInOther(view5);
                } else {
                    int paddingLeft2 = getPaddingLeft() + this.f6989I[layoutParams3.f6996e];
                    i10 = this.f7044s.getDecoratedMeasurementInOther(view5) + paddingLeft2;
                    i11 = i7;
                    decoratedMeasurementInOther = i8;
                    i9 = paddingLeft2;
                }
            } else {
                int paddingTop = getPaddingTop() + this.f6989I[layoutParams3.f6996e];
                i9 = i6;
                i10 = i5;
                i11 = paddingTop;
                decoratedMeasurementInOther = this.f7044s.getDecoratedMeasurementInOther(view5) + paddingTop;
            }
            layoutDecoratedWithMargins(view5, i9, i11, i10, decoratedMeasurementInOther);
            if (layoutParams3.isItemRemoved() || layoutParams3.isItemChanged()) {
                layoutChunkResult.mIgnoreConsumed = true;
            }
            layoutChunkResult.mFocusable |= view5.hasFocusable();
            i24++;
            i6 = i9;
            i5 = i10;
            i7 = i11;
            i8 = decoratedMeasurementInOther;
        }
        Arrays.fill(this.f6990J, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /* renamed from: D */
    public final void mo1614D(RecyclerView.Recycler recycler, RecyclerView.State state, C0472f0 c0472f0, int i) {
        boolean z;
        m1624U();
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            int m1621R = m1621R(c0472f0.f7371b, recycler, state);
            if (z) {
                while (m1621R > 0) {
                    int i2 = c0472f0.f7371b;
                    if (i2 <= 0) {
                        break;
                    }
                    int i3 = i2 - 1;
                    c0472f0.f7371b = i3;
                    m1621R = m1621R(i3, recycler, state);
                }
            } else {
                int itemCount = state.getItemCount() - 1;
                int i4 = c0472f0.f7371b;
                while (i4 < itemCount) {
                    int i5 = i4 + 1;
                    int m1621R2 = m1621R(i5, recycler, state);
                    if (m1621R2 <= m1621R) {
                        break;
                    }
                    i4 = i5;
                    m1621R = m1621R2;
                }
                c0472f0.f7371b = i4;
            }
        }
        m1618O();
    }

    /* renamed from: L */
    public final void m1615L(int i) {
        int i2;
        int[] iArr = this.f6989I;
        int i3 = this.f6988H;
        if (iArr == null || iArr.length != i3 + 1 || iArr[iArr.length - 1] != i) {
            iArr = new int[i3 + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i / i3;
        int i6 = i % i3;
        int i7 = 0;
        for (int i8 = 1; i8 <= i3; i8++) {
            i4 += i6;
            if (i4 > 0 && i3 - i4 < i6) {
                i2 = i5 + 1;
                i4 -= i3;
            } else {
                i2 = i5;
            }
            i7 += i2;
            iArr[i8] = i7;
        }
        this.f6989I = iArr;
    }

    /* renamed from: M */
    public final int m1616M(RecyclerView.State state) {
        int max;
        if (getChildCount() != 0 && state.getItemCount() != 0) {
            m1655r();
            boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            boolean z = !isSmoothScrollbarEnabled;
            View m1658u = m1658u(z);
            View m1657t = m1657t(z);
            if (m1658u != null && m1657t != null) {
                int m1628b = this.f6993M.m1628b(getPosition(m1658u), this.f6988H);
                int m1628b2 = this.f6993M.m1628b(getPosition(m1657t), this.f6988H);
                int min = Math.min(m1628b, m1628b2);
                int max2 = Math.max(m1628b, m1628b2);
                int m1628b3 = this.f6993M.m1628b(state.getItemCount() - 1, this.f6988H) + 1;
                if (this.f7047v) {
                    max = Math.max(0, (m1628b3 - max2) - 1);
                } else {
                    max = Math.max(0, min);
                }
                if (!isSmoothScrollbarEnabled) {
                    return max;
                }
                return Math.round((max * (Math.abs(this.f7044s.getDecoratedEnd(m1657t) - this.f7044s.getDecoratedStart(m1658u)) / ((this.f6993M.m1628b(getPosition(m1657t), this.f6988H) - this.f6993M.m1628b(getPosition(m1658u), this.f6988H)) + 1))) + (this.f7044s.getStartAfterPadding() - this.f7044s.getDecoratedStart(m1658u)));
            }
        }
        return 0;
    }

    /* renamed from: N */
    public final int m1617N(RecyclerView.State state) {
        if (getChildCount() != 0 && state.getItemCount() != 0) {
            m1655r();
            View m1658u = m1658u(!isSmoothScrollbarEnabled());
            View m1657t = m1657t(!isSmoothScrollbarEnabled());
            if (m1658u != null && m1657t != null) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.f6993M.m1628b(state.getItemCount() - 1, this.f6988H) + 1;
                }
                int decoratedEnd = this.f7044s.getDecoratedEnd(m1657t) - this.f7044s.getDecoratedStart(m1658u);
                int m1628b = this.f6993M.m1628b(getPosition(m1658u), this.f6988H);
                return (int) ((decoratedEnd / ((this.f6993M.m1628b(getPosition(m1657t), this.f6988H) - m1628b) + 1)) * (this.f6993M.m1628b(state.getItemCount() - 1, this.f6988H) + 1));
            }
        }
        return 0;
    }

    /* renamed from: O */
    public final void m1618O() {
        View[] viewArr = this.f6990J;
        if (viewArr == null || viewArr.length != this.f6988H) {
            this.f6990J = new View[this.f6988H];
        }
    }

    /* renamed from: P */
    public final int m1619P(int i, int i2) {
        if (this.f7042q == 1 && isLayoutRTL()) {
            int[] iArr = this.f6989I;
            int i3 = this.f6988H;
            return iArr[i3 - i] - iArr[(i3 - i) - i2];
        }
        int[] iArr2 = this.f6989I;
        return iArr2[i2 + i] - iArr2[i];
    }

    /* renamed from: Q */
    public final int m1620Q(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!state.isPreLayout()) {
            return this.f6993M.m1628b(i, this.f6988H);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
            return 0;
        }
        return this.f6993M.m1628b(convertPreLayoutPositionToPostLayout, this.f6988H);
    }

    /* renamed from: R */
    public final int m1621R(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!state.isPreLayout()) {
            return this.f6993M.m1629c(i, this.f6988H);
        }
        int i2 = this.f6992L.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 0;
        }
        return this.f6993M.m1629c(convertPreLayoutPositionToPostLayout, this.f6988H);
    }

    /* renamed from: S */
    public final int m1622S(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!state.isPreLayout()) {
            return this.f6993M.getSpanSize(i);
        }
        int i2 = this.f6991K.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 1;
        }
        return this.f6993M.getSpanSize(convertPreLayoutPositionToPostLayout);
    }

    /* renamed from: T */
    public final void m1623T(int i, View view, boolean z) {
        int i2;
        int i3;
        boolean m1738j;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f7179b;
        int i4 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int i5 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int m1619P = m1619P(layoutParams.f6996e, layoutParams.f6997f);
        if (this.f7042q == 1) {
            i3 = RecyclerView.LayoutManager.getChildMeasureSpec(m1619P, i, i5, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
            i2 = RecyclerView.LayoutManager.getChildMeasureSpec(this.f7044s.getTotalSpace(), getHeightMode(), i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
        } else {
            int childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(m1619P, i, i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
            int childMeasureSpec2 = RecyclerView.LayoutManager.getChildMeasureSpec(this.f7044s.getTotalSpace(), getWidthMode(), i5, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
            i2 = childMeasureSpec;
            i3 = childMeasureSpec2;
        }
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            m1738j = m1739l(view, i3, i2, layoutParams2);
        } else {
            m1738j = m1738j(view, i3, i2, layoutParams2);
        }
        if (m1738j) {
            view.measure(i3, i2);
        }
    }

    /* renamed from: U */
    public final void m1624U() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        m1615L(height - paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        if (this.f6995O) {
            return m1616M(state);
        }
        return super.computeHorizontalScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        if (this.f6995O) {
            return m1617N(state);
        }
        return super.computeHorizontalScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        if (this.f6995O) {
            return m1616M(state);
        }
        return super.computeVerticalScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        if (this.f6995O) {
            return m1617N(state);
        }
        return super.computeVerticalScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.f7042q == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f7042q == 1) {
            return this.f6988H;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return m1620Q(state.getItemCount() - 1, recycler, state) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f7042q == 0) {
            return this.f6988H;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return m1620Q(state.getItemCount() - 1, recycler, state) + 1;
    }

    public int getSpanCount() {
        return this.f6988H;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.f6993M;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.f6995O;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /* renamed from: m */
    public final void mo1625m(RecyclerView.State state, C0475g0 c0475g0, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i;
        int i2 = this.f6988H;
        for (int i3 = 0; i3 < this.f6988H && (i = c0475g0.f7383d) >= 0 && i < state.getItemCount() && i2 > 0; i3++) {
            int i4 = c0475g0.f7383d;
            layoutPrefetchRegistry.addPosition(i4, Math.max(0, c0475g0.f7386g));
            i2 -= this.f6993M.getSpanSize(i4);
            c0475g0.f7383d += c0475g0.f7384e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d1, code lost:
    
        if (r13 == r7) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00f1, code lost:
    
        if (r13 == r10) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010f  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z;
        int childCount;
        int i2;
        int i3;
        boolean z2;
        View view2;
        View view3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z3;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        View findContainingItemView = findContainingItemView(view);
        View view4 = null;
        if (findContainingItemView == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        int i8 = layoutParams.f6996e;
        int i9 = layoutParams.f6997f + i8;
        if (super.onFocusSearchFailed(view, i, recycler, state) == null) {
            return null;
        }
        if (m1654q(i) == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z != this.f7047v) {
            i3 = getChildCount() - 1;
            childCount = -1;
            i2 = -1;
        } else {
            childCount = getChildCount();
            i2 = 1;
            i3 = 0;
        }
        if (this.f7042q == 1 && isLayoutRTL()) {
            z2 = true;
        } else {
            z2 = false;
        }
        int m1620Q = m1620Q(i3, recycler2, state2);
        int i10 = -1;
        int i11 = -1;
        int i12 = 0;
        int i13 = 0;
        int i14 = i3;
        View view5 = null;
        while (i14 != childCount) {
            int m1620Q2 = m1620Q(i14, recycler2, state2);
            View childAt = getChildAt(i14);
            if (childAt == findContainingItemView) {
                break;
            }
            if (childAt.hasFocusable() && m1620Q2 != m1620Q) {
                if (view4 != null) {
                    break;
                }
                view2 = findContainingItemView;
                view3 = view5;
            } else {
                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                int i15 = layoutParams2.f6996e;
                view2 = findContainingItemView;
                int i16 = layoutParams2.f6997f + i15;
                if (childAt.hasFocusable() && i15 == i8 && i16 == i9) {
                    return childAt;
                }
                if ((childAt.hasFocusable() && view4 == null) || (!childAt.hasFocusable() && view5 == null)) {
                    view3 = view5;
                } else {
                    view3 = view5;
                    int min = Math.min(i16, i9) - Math.max(i15, i8);
                    if (childAt.hasFocusable()) {
                        if (min <= i12) {
                            if (min == i12) {
                                if (i15 > i10) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                            }
                        }
                    } else if (view4 == null) {
                        i4 = i12;
                        i5 = childCount;
                        boolean z4 = true;
                        if (isViewPartiallyVisible(childAt, false, true)) {
                            i6 = i13;
                            if (min > i6) {
                                i7 = i11;
                            } else {
                                if (min == i6) {
                                    i7 = i11;
                                    if (i15 <= i7) {
                                        z4 = false;
                                    }
                                } else {
                                    i7 = i11;
                                }
                                i11 = i7;
                                i13 = i6;
                                i12 = i4;
                                view5 = view3;
                                i14 += i2;
                                recycler2 = recycler;
                                state2 = state;
                                findContainingItemView = view2;
                                childCount = i5;
                            }
                            if (!childAt.hasFocusable()) {
                                i10 = layoutParams2.f6996e;
                                i11 = i7;
                                i13 = i6;
                                view5 = view3;
                                view4 = childAt;
                                i12 = Math.min(i16, i9) - Math.max(i15, i8);
                            } else {
                                int i17 = layoutParams2.f6996e;
                                i13 = Math.min(i16, i9) - Math.max(i15, i8);
                                i11 = i17;
                                i12 = i4;
                                view5 = childAt;
                            }
                            i14 += i2;
                            recycler2 = recycler;
                            state2 = state;
                            findContainingItemView = view2;
                            childCount = i5;
                        }
                        i7 = i11;
                        i6 = i13;
                        i11 = i7;
                        i13 = i6;
                        i12 = i4;
                        view5 = view3;
                        i14 += i2;
                        recycler2 = recycler;
                        state2 = state;
                        findContainingItemView = view2;
                        childCount = i5;
                    }
                }
                i4 = i12;
                i5 = childCount;
                i7 = i11;
                i6 = i13;
                if (!childAt.hasFocusable()) {
                }
                i14 += i2;
                recycler2 = recycler;
                state2 = state;
                findContainingItemView = view2;
                childCount = i5;
            }
            i4 = i12;
            i5 = childCount;
            i7 = i11;
            i6 = i13;
            i11 = i7;
            i13 = i6;
            i12 = i4;
            view5 = view3;
            i14 += i2;
            recycler2 = recycler;
            state2 = state;
            findContainingItemView = view2;
            childCount = i5;
        }
        View view6 = view5;
        if (view4 == null) {
            return view6;
        }
        return view4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(GridView.class.getName());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            m1731c(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int m1620Q = m1620Q(layoutParams2.getViewLayoutPosition(), recycler, state);
        if (this.f7042q == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), m1620Q, 1, false, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(m1620Q, 1, layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.f6993M.invalidateSpanIndexCache();
        this.f6993M.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.f6993M.invalidateSpanIndexCache();
        this.f6993M.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f6993M.invalidateSpanIndexCache();
        this.f6993M.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.f6993M.invalidateSpanIndexCache();
        this.f6993M.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f6993M.invalidateSpanIndexCache();
        this.f6993M.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean isPreLayout = state.isPreLayout();
        SparseIntArray sparseIntArray = this.f6992L;
        SparseIntArray sparseIntArray2 = this.f6991K;
        if (isPreLayout) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
                int viewLayoutPosition = layoutParams.getViewLayoutPosition();
                sparseIntArray2.put(viewLayoutPosition, layoutParams.getSpanSize());
                sparseIntArray.put(viewLayoutPosition, layoutParams.getSpanIndex());
            }
        }
        super.onLayoutChildren(recycler, state);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f6987G = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        m1624U();
        m1618O();
        return super.scrollHorizontallyBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        m1624U();
        m1618O();
        return super.scrollVerticallyBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int chooseSize;
        int chooseSize2;
        if (this.f6989I == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.f7042q == 1) {
            chooseSize2 = RecyclerView.LayoutManager.chooseSize(i2, rect.height() + paddingBottom, getMinimumHeight());
            int[] iArr = this.f6989I;
            chooseSize = RecyclerView.LayoutManager.chooseSize(i, iArr[iArr.length - 1] + paddingRight, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.LayoutManager.chooseSize(i, rect.width() + paddingRight, getMinimumWidth());
            int[] iArr2 = this.f6989I;
            chooseSize2 = RecyclerView.LayoutManager.chooseSize(i2, iArr2[iArr2.length - 1] + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    public void setSpanCount(int i) {
        if (i == this.f6988H) {
            return;
        }
        this.f6987G = true;
        if (i >= 1) {
            this.f6988H = i;
            this.f6993M.invalidateSpanIndexCache();
            requestLayout();
            return;
        }
        throw new IllegalArgumentException(ye0.m8291k(i, "Span count should be at least 1. Provided "));
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.f6993M = spanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z) {
        if (!z) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean z) {
        this.f6995O = z;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        if (this.f7037B == null && !this.f6987G) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /* renamed from: x */
    public final View mo1626x(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z, boolean z2) {
        int i;
        int i2;
        int childCount = getChildCount();
        int i3 = 1;
        if (z2) {
            i2 = getChildCount() - 1;
            i = -1;
            i3 = -1;
        } else {
            i = childCount;
            i2 = 0;
        }
        int itemCount = state.getItemCount();
        m1655r();
        int startAfterPadding = this.f7044s.getStartAfterPadding();
        int endAfterPadding = this.f7044s.getEndAfterPadding();
        View view = null;
        View view2 = null;
        while (i2 != i) {
            View childAt = getChildAt(i2);
            int position = getPosition(childAt);
            if (position >= 0 && position < itemCount && m1621R(position, recycler, state) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.f7044s.getDecoratedStart(childAt) < endAfterPadding && this.f7044s.getDecoratedEnd(childAt) >= startAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i2 += i3;
        }
        if (view == null) {
            return view2;
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;

        /* renamed from: e */
        public int f6996e;

        /* renamed from: f */
        public int f6997f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f6996e = -1;
            this.f6997f = 0;
        }

        public int getSpanIndex() {
            return this.f6996e;
        }

        public int getSpanSize() {
            return this.f6997f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f6996e = -1;
            this.f6997f = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f6996e = -1;
            this.f6997f = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f6996e = -1;
            this.f6997f = 0;
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
            this.f6996e = -1;
            this.f6997f = 0;
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.f6987G = false;
        this.f6988H = -1;
        this.f6991K = new SparseIntArray();
        this.f6992L = new SparseIntArray();
        this.f6993M = new DefaultSpanSizeLookup();
        this.f6994N = new Rect();
        setSpanCount(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        this.f6987G = false;
        this.f6988H = -1;
        this.f6991K = new SparseIntArray();
        this.f6992L = new SparseIntArray();
        this.f6993M = new DefaultSpanSizeLookup();
        this.f6994N = new Rect();
        setSpanCount(i);
    }
}
