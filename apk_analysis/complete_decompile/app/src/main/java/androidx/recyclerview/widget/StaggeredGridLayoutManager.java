package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import p000.AbstractC1726qj;
import p000.sn1;
import p000.tm2;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {

    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    /* renamed from: E */
    public boolean f7273E;

    /* renamed from: F */
    public boolean f7274F;

    /* renamed from: G */
    public SavedState f7275G;

    /* renamed from: H */
    public int f7276H;

    /* renamed from: M */
    public int[] f7281M;

    /* renamed from: r */
    public C0482i1[] f7284r;

    /* renamed from: s */
    public OrientationHelper f7285s;

    /* renamed from: t */
    public OrientationHelper f7286t;

    /* renamed from: u */
    public int f7287u;

    /* renamed from: v */
    public int f7288v;

    /* renamed from: w */
    public final C0469e0 f7289w;

    /* renamed from: z */
    public BitSet f7292z;

    /* renamed from: q */
    public int f7283q = -1;

    /* renamed from: x */
    public boolean f7290x = false;

    /* renamed from: y */
    public boolean f7291y = false;

    /* renamed from: A */
    public int f7269A = -1;

    /* renamed from: B */
    public int f7270B = Integer.MIN_VALUE;

    /* renamed from: C */
    public final C0476g1 f7271C = new Object();

    /* renamed from: D */
    public int f7272D = 2;

    /* renamed from: I */
    public final Rect f7277I = new Rect();

    /* renamed from: J */
    public final tm2 f7278J = new tm2(this);

    /* renamed from: K */
    public boolean f7279K = false;

    /* renamed from: L */
    public final boolean f7280L = true;

    /* renamed from: N */
    public final sn1 f7282N = new sn1(8, this);

    /* loaded from: classes.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;

        /* renamed from: e */
        public C0482i1 f7293e;

        /* renamed from: f */
        public boolean f7294f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int getSpanIndex() {
            C0482i1 c0482i1 = this.f7293e;
            if (c0482i1 == null) {
                return -1;
            }
            return c0482i1.f7409e;
        }

        public boolean isFullSpan() {
            return this.f7294f;
        }

        public void setFullSpan(boolean z) {
            this.f7294f = z;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: a */
        public int f7299a;

        /* renamed from: b */
        public int f7300b;

        /* renamed from: c */
        public int f7301c;

        /* renamed from: d */
        public int[] f7302d;

        /* renamed from: e */
        public int f7303e;

        /* renamed from: f */
        public int[] f7304f;

        /* renamed from: g */
        public ArrayList f7305g;

        /* renamed from: h */
        public boolean f7306h;

        /* renamed from: i */
        public boolean f7307i;

        /* renamed from: j */
        public boolean f7308j;

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f7299a);
            parcel.writeInt(this.f7300b);
            parcel.writeInt(this.f7301c);
            if (this.f7301c > 0) {
                parcel.writeIntArray(this.f7302d);
            }
            parcel.writeInt(this.f7303e);
            if (this.f7303e > 0) {
                parcel.writeIntArray(this.f7304f);
            }
            parcel.writeInt(this.f7306h ? 1 : 0);
            parcel.writeInt(this.f7307i ? 1 : 0);
            parcel.writeInt(this.f7308j ? 1 : 0);
            parcel.writeList(this.f7305g);
        }

        public SavedState(SavedState savedState) {
            this.f7301c = savedState.f7301c;
            this.f7299a = savedState.f7299a;
            this.f7300b = savedState.f7300b;
            this.f7302d = savedState.f7302d;
            this.f7303e = savedState.f7303e;
            this.f7304f = savedState.f7304f;
            this.f7306h = savedState.f7306h;
            this.f7307i = savedState.f7307i;
            this.f7308j = savedState.f7308j;
            this.f7305g = savedState.f7305g;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.recyclerview.widget.g1, java.lang.Object] */
    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setSpanCount(properties.spanCount);
        setReverseLayout(properties.reverseLayout);
        this.f7289w = new C0469e0();
        this.f7285s = OrientationHelper.createOrientationHelper(this, this.f7287u);
        this.f7286t = OrientationHelper.createOrientationHelper(this, 1 - this.f7287u);
    }

    /* renamed from: P */
    public static int m1778P(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            return i;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0037  */
    /* renamed from: A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1779A(int i, int i2, int i3) {
        int m1804w;
        int i4;
        int i5;
        int m1805x;
        if (this.f7291y) {
            m1804w = m1805x();
        } else {
            m1804w = m1804w();
        }
        if (i3 == 8) {
            if (i < i2) {
                i4 = i2 + 1;
            } else {
                i4 = i + 1;
                i5 = i2;
                C0476g1 c0476g1 = this.f7271C;
                c0476g1.m1851g(i5);
                if (i3 == 1) {
                    if (i3 != 2) {
                        if (i3 == 8) {
                            c0476g1.m1853i(i, 1);
                            c0476g1.m1852h(i2, 1);
                        }
                    } else {
                        c0476g1.m1853i(i, i2);
                    }
                } else {
                    c0476g1.m1852h(i, i2);
                }
                if (i4 > m1804w) {
                    return;
                }
                if (this.f7291y) {
                    m1805x = m1804w();
                } else {
                    m1805x = m1805x();
                }
                if (i5 <= m1805x) {
                    requestLayout();
                    return;
                }
                return;
            }
        } else {
            i4 = i + i2;
        }
        i5 = i;
        C0476g1 c0476g12 = this.f7271C;
        c0476g12.m1851g(i5);
        if (i3 == 1) {
        }
        if (i4 > m1804w) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bc, code lost:
    
        if (r10 == r11) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d2, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d0, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ce, code lost:
    
        if (r10 == r11) goto L54;
     */
    /* renamed from: B */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View m1780B() {
        char c;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int childCount = getChildCount();
        int i2 = childCount - 1;
        BitSet bitSet = new BitSet(this.f7283q);
        bitSet.set(0, this.f7283q, true);
        int i3 = -1;
        if (this.f7287u == 1 && isLayoutRTL()) {
            c = 1;
        } else {
            c = 65535;
        }
        if (this.f7291y) {
            childCount = -1;
        } else {
            i2 = 0;
        }
        if (i2 < childCount) {
            i3 = 1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.f7293e.f7409e)) {
                C0482i1 c0482i1 = layoutParams.f7293e;
                if (this.f7291y) {
                    int i4 = c0482i1.f7407c;
                    if (i4 == Integer.MIN_VALUE) {
                        c0482i1.m1861b();
                        i4 = c0482i1.f7407c;
                    }
                    if (i4 < this.f7285s.getEndAfterPadding()) {
                        z4 = ((LayoutParams) ((View) AbstractC1726qj.m7053i(c0482i1.f7405a, 1)).getLayoutParams()).f7294f;
                        z5 = !z4;
                    }
                    z5 = false;
                } else {
                    int i5 = c0482i1.f7406b;
                    if (i5 == Integer.MIN_VALUE) {
                        c0482i1.m1862c();
                        i5 = c0482i1.f7406b;
                    }
                    if (i5 > this.f7285s.getStartAfterPadding()) {
                        z4 = ((LayoutParams) ((View) c0482i1.f7405a.get(0)).getLayoutParams()).f7294f;
                        z5 = !z4;
                    }
                    z5 = false;
                }
                if (z5) {
                    return childAt;
                }
                bitSet.clear(layoutParams.f7293e.f7409e);
            }
            if (!layoutParams.f7294f && (i = i2 + i3) != childCount) {
                View childAt2 = getChildAt(i);
                if (this.f7291y) {
                    int decoratedEnd = this.f7285s.getDecoratedEnd(childAt);
                    int decoratedEnd2 = this.f7285s.getDecoratedEnd(childAt2);
                    if (decoratedEnd < decoratedEnd2) {
                        return childAt;
                    }
                } else {
                    int decoratedStart = this.f7285s.getDecoratedStart(childAt);
                    int decoratedStart2 = this.f7285s.getDecoratedStart(childAt2);
                    if (decoratedStart > decoratedStart2) {
                        return childAt;
                    }
                }
                if (z) {
                    if (layoutParams.f7293e.f7409e - ((LayoutParams) childAt2.getLayoutParams()).f7293e.f7409e < 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (c < 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z2 != z3) {
                        return childAt;
                    }
                } else {
                    continue;
                }
            }
            i2 += i3;
        }
        return null;
    }

    /* renamed from: C */
    public final void m1781C(View view, int i, int i2) {
        Rect rect = this.f7277I;
        calculateItemDecorationsForChild(view, rect);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int m1778P = m1778P(i, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int m1778P2 = m1778P(i2, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect.bottom);
        if (m1738j(view, m1778P, m1778P2, layoutParams)) {
            view.measure(m1778P, m1778P2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:254:0x040b, code lost:
    
        if (m1795n() != false) goto L247;
     */
    /* renamed from: D */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1782D(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        boolean z2;
        SavedState savedState;
        int m1869j;
        int i;
        int i2;
        boolean z3;
        int startAfterPadding;
        int m1804w;
        int startAfterPadding2;
        int startAfterPadding3;
        SavedState savedState2 = this.f7275G;
        tm2 tm2Var = this.f7278J;
        if ((savedState2 != null || this.f7269A != -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            tm2Var.m7500a();
            return;
        }
        boolean z4 = true;
        if (tm2Var.f26885e && this.f7269A == -1 && this.f7275G == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        C0476g1 c0476g1 = this.f7271C;
        StaggeredGridLayoutManager staggeredGridLayoutManager = tm2Var.f26887g;
        if (z2) {
            tm2Var.m7500a();
            SavedState savedState3 = this.f7275G;
            if (savedState3 != null) {
                int i3 = savedState3.f7301c;
                if (i3 > 0) {
                    if (i3 == this.f7283q) {
                        for (int i4 = 0; i4 < this.f7283q; i4++) {
                            this.f7284r[i4].m1863d();
                            SavedState savedState4 = this.f7275G;
                            int i5 = savedState4.f7302d[i4];
                            if (i5 != Integer.MIN_VALUE) {
                                if (savedState4.f7307i) {
                                    startAfterPadding3 = this.f7285s.getEndAfterPadding();
                                } else {
                                    startAfterPadding3 = this.f7285s.getStartAfterPadding();
                                }
                                i5 += startAfterPadding3;
                            }
                            C0482i1 c0482i1 = this.f7284r[i4];
                            c0482i1.f7406b = i5;
                            c0482i1.f7407c = i5;
                        }
                    } else {
                        savedState3.f7302d = null;
                        savedState3.f7301c = 0;
                        savedState3.f7303e = 0;
                        savedState3.f7304f = null;
                        savedState3.f7305g = null;
                        savedState3.f7299a = savedState3.f7300b;
                    }
                }
                SavedState savedState5 = this.f7275G;
                this.f7274F = savedState5.f7308j;
                setReverseLayout(savedState5.f7306h);
                m1788J();
                SavedState savedState6 = this.f7275G;
                int i6 = savedState6.f7299a;
                if (i6 != -1) {
                    this.f7269A = i6;
                    tm2Var.f26883c = savedState6.f7307i;
                } else {
                    tm2Var.f26883c = this.f7291y;
                }
                if (savedState6.f7303e > 1) {
                    c0476g1.f7392a = savedState6.f7304f;
                    c0476g1.f7393b = savedState6.f7305g;
                }
            } else {
                m1788J();
                tm2Var.f26883c = this.f7291y;
            }
            if (!state.isPreLayout() && (i2 = this.f7269A) != -1) {
                if (i2 >= 0 && i2 < state.getItemCount()) {
                    SavedState savedState7 = this.f7275G;
                    if (savedState7 != null && savedState7.f7299a != -1 && savedState7.f7301c >= 1) {
                        tm2Var.f26882b = Integer.MIN_VALUE;
                        tm2Var.f26881a = this.f7269A;
                    } else {
                        View findViewByPosition = findViewByPosition(this.f7269A);
                        if (findViewByPosition != null) {
                            if (this.f7291y) {
                                m1804w = m1805x();
                            } else {
                                m1804w = m1804w();
                            }
                            tm2Var.f26881a = m1804w;
                            if (this.f7270B != Integer.MIN_VALUE) {
                                if (tm2Var.f26883c) {
                                    tm2Var.f26882b = (this.f7285s.getEndAfterPadding() - this.f7270B) - this.f7285s.getDecoratedEnd(findViewByPosition);
                                } else {
                                    tm2Var.f26882b = (this.f7285s.getStartAfterPadding() + this.f7270B) - this.f7285s.getDecoratedStart(findViewByPosition);
                                }
                            } else if (this.f7285s.getDecoratedMeasurement(findViewByPosition) > this.f7285s.getTotalSpace()) {
                                if (tm2Var.f26883c) {
                                    startAfterPadding2 = this.f7285s.getEndAfterPadding();
                                } else {
                                    startAfterPadding2 = this.f7285s.getStartAfterPadding();
                                }
                                tm2Var.f26882b = startAfterPadding2;
                            } else {
                                int decoratedStart = this.f7285s.getDecoratedStart(findViewByPosition) - this.f7285s.getStartAfterPadding();
                                if (decoratedStart < 0) {
                                    tm2Var.f26882b = -decoratedStart;
                                } else {
                                    int endAfterPadding = this.f7285s.getEndAfterPadding() - this.f7285s.getDecoratedEnd(findViewByPosition);
                                    if (endAfterPadding < 0) {
                                        tm2Var.f26882b = endAfterPadding;
                                    } else {
                                        tm2Var.f26882b = Integer.MIN_VALUE;
                                    }
                                }
                            }
                        } else {
                            int i7 = this.f7269A;
                            tm2Var.f26881a = i7;
                            int i8 = this.f7270B;
                            if (i8 == Integer.MIN_VALUE) {
                                if (m1794m(i7) == 1) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                tm2Var.f26883c = z3;
                                if (z3) {
                                    startAfterPadding = staggeredGridLayoutManager.f7285s.getEndAfterPadding();
                                } else {
                                    startAfterPadding = staggeredGridLayoutManager.f7285s.getStartAfterPadding();
                                }
                                tm2Var.f26882b = startAfterPadding;
                            } else if (tm2Var.f26883c) {
                                tm2Var.f26882b = staggeredGridLayoutManager.f7285s.getEndAfterPadding() - i8;
                            } else {
                                tm2Var.f26882b = staggeredGridLayoutManager.f7285s.getStartAfterPadding() + i8;
                            }
                            tm2Var.f26884d = true;
                        }
                    }
                    tm2Var.f26885e = true;
                } else {
                    this.f7269A = -1;
                    this.f7270B = Integer.MIN_VALUE;
                }
            }
            if (this.f7273E) {
                int itemCount = state.getItemCount();
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    i = getPosition(getChildAt(childCount));
                    if (i >= 0 && i < itemCount) {
                        break;
                    }
                }
                i = 0;
                tm2Var.f26881a = i;
                tm2Var.f26882b = Integer.MIN_VALUE;
                tm2Var.f26885e = true;
            } else {
                int itemCount2 = state.getItemCount();
                int childCount2 = getChildCount();
                for (int i9 = 0; i9 < childCount2; i9++) {
                    int position = getPosition(getChildAt(i9));
                    if (position >= 0 && position < itemCount2) {
                        i = position;
                        break;
                    }
                }
                i = 0;
                tm2Var.f26881a = i;
                tm2Var.f26882b = Integer.MIN_VALUE;
                tm2Var.f26885e = true;
            }
        }
        if (this.f7275G == null && this.f7269A == -1 && (tm2Var.f26883c != this.f7273E || isLayoutRTL() != this.f7274F)) {
            c0476g1.m1846b();
            tm2Var.f26884d = true;
        }
        if (getChildCount() > 0 && ((savedState = this.f7275G) == null || savedState.f7301c < 1)) {
            if (tm2Var.f26884d) {
                for (int i10 = 0; i10 < this.f7283q; i10++) {
                    this.f7284r[i10].m1863d();
                    int i11 = tm2Var.f26882b;
                    if (i11 != Integer.MIN_VALUE) {
                        C0482i1 c0482i12 = this.f7284r[i10];
                        c0482i12.f7406b = i11;
                        c0482i12.f7407c = i11;
                    }
                }
            } else if (!z2 && tm2Var.f26886f != null) {
                for (int i12 = 0; i12 < this.f7283q; i12++) {
                    C0482i1 c0482i13 = this.f7284r[i12];
                    c0482i13.m1863d();
                    int i13 = tm2Var.f26886f[i12];
                    c0482i13.f7406b = i13;
                    c0482i13.f7407c = i13;
                }
            } else {
                for (int i14 = 0; i14 < this.f7283q; i14++) {
                    C0482i1 c0482i14 = this.f7284r[i14];
                    boolean z5 = this.f7291y;
                    int i15 = tm2Var.f26882b;
                    if (z5) {
                        m1869j = c0482i14.m1867h(Integer.MIN_VALUE);
                    } else {
                        m1869j = c0482i14.m1869j(Integer.MIN_VALUE);
                    }
                    c0482i14.m1863d();
                    if (m1869j != Integer.MIN_VALUE) {
                        StaggeredGridLayoutManager staggeredGridLayoutManager2 = c0482i14.f7410f;
                        if ((!z5 || m1869j >= staggeredGridLayoutManager2.f7285s.getEndAfterPadding()) && (z5 || m1869j <= staggeredGridLayoutManager2.f7285s.getStartAfterPadding())) {
                            if (i15 != Integer.MIN_VALUE) {
                                m1869j += i15;
                            }
                            c0482i14.f7407c = m1869j;
                            c0482i14.f7406b = m1869j;
                        }
                    }
                }
                C0482i1[] c0482i1Arr = this.f7284r;
                int length = c0482i1Arr.length;
                int[] iArr = tm2Var.f26886f;
                if (iArr == null || iArr.length < length) {
                    tm2Var.f26886f = new int[staggeredGridLayoutManager.f7284r.length];
                }
                for (int i16 = 0; i16 < length; i16++) {
                    tm2Var.f26886f[i16] = c0482i1Arr[i16].m1869j(Integer.MIN_VALUE);
                }
            }
        }
        detachAndScrapAttachedViews(recycler);
        C0469e0 c0469e0 = this.f7289w;
        c0469e0.f7353a = false;
        this.f7279K = false;
        int totalSpace = this.f7286t.getTotalSpace();
        this.f7288v = totalSpace / this.f7283q;
        this.f7276H = View.MeasureSpec.makeMeasureSpec(totalSpace, this.f7286t.getMode());
        m1792N(tm2Var.f26881a, state);
        if (tm2Var.f26883c) {
            m1790L(-1);
            m1799r(recycler, c0469e0, state);
            m1790L(1);
            c0469e0.f7355c = tm2Var.f26881a + c0469e0.f7356d;
            m1799r(recycler, c0469e0, state);
        } else {
            m1790L(1);
            m1799r(recycler, c0469e0, state);
            m1790L(-1);
            c0469e0.f7355c = tm2Var.f26881a + c0469e0.f7356d;
            m1799r(recycler, c0469e0, state);
        }
        if (this.f7286t.getMode() != 1073741824) {
            int childCount3 = getChildCount();
            float f = RecyclerView.f7068F0;
            for (int i17 = 0; i17 < childCount3; i17++) {
                View childAt = getChildAt(i17);
                float decoratedMeasurement = this.f7286t.getDecoratedMeasurement(childAt);
                if (decoratedMeasurement >= f) {
                    if (((LayoutParams) childAt.getLayoutParams()).isFullSpan()) {
                        decoratedMeasurement = (decoratedMeasurement * 1.0f) / this.f7283q;
                    }
                    f = Math.max(f, decoratedMeasurement);
                }
            }
            int i18 = this.f7288v;
            int round = Math.round(f * this.f7283q);
            if (this.f7286t.getMode() == Integer.MIN_VALUE) {
                round = Math.min(round, this.f7286t.getTotalSpace());
            }
            this.f7288v = round / this.f7283q;
            this.f7276H = View.MeasureSpec.makeMeasureSpec(round, this.f7286t.getMode());
            if (this.f7288v != i18) {
                for (int i19 = 0; i19 < childCount3; i19++) {
                    View childAt2 = getChildAt(i19);
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (!layoutParams.f7294f) {
                        if (isLayoutRTL() && this.f7287u == 1) {
                            int i20 = -((this.f7283q - 1) - layoutParams.f7293e.f7409e);
                            childAt2.offsetLeftAndRight((this.f7288v * i20) - (i20 * i18));
                        } else {
                            int i21 = layoutParams.f7293e.f7409e;
                            int i22 = this.f7288v * i21;
                            int i23 = i21 * i18;
                            if (this.f7287u == 1) {
                                childAt2.offsetLeftAndRight(i22 - i23);
                            } else {
                                childAt2.offsetTopAndBottom(i22 - i23);
                            }
                        }
                    }
                }
            }
        }
        if (getChildCount() > 0) {
            if (this.f7291y) {
                m1802u(recycler, state, true);
                m1803v(recycler, state, false);
            } else {
                m1803v(recycler, state, true);
                m1802u(recycler, state, false);
            }
        }
        if (z && !state.isPreLayout() && this.f7272D != 0 && getChildCount() > 0 && (this.f7279K || m1780B() != null)) {
            removeCallbacks(this.f7282N);
        }
        z4 = false;
        if (state.isPreLayout()) {
            tm2Var.m7500a();
        }
        this.f7273E = tm2Var.f26883c;
        this.f7274F = isLayoutRTL();
        if (z4) {
            tm2Var.m7500a();
            m1782D(recycler, state, false);
        }
    }

    /* renamed from: E */
    public final boolean m1783E(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.f7287u == 0) {
            if (i == -1) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3 == this.f7291y) {
                return false;
            }
            return true;
        }
        if (i == -1) {
            z = true;
        } else {
            z = false;
        }
        if (z == this.f7291y) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 != isLayoutRTL()) {
            return false;
        }
        return true;
    }

    /* renamed from: F */
    public final void m1784F(int i, RecyclerView.State state) {
        int m1804w;
        int i2;
        if (i > 0) {
            m1804w = m1805x();
            i2 = 1;
        } else {
            m1804w = m1804w();
            i2 = -1;
        }
        C0469e0 c0469e0 = this.f7289w;
        c0469e0.f7353a = true;
        m1792N(m1804w, state);
        m1790L(i2);
        c0469e0.f7355c = m1804w + c0469e0.f7356d;
        c0469e0.f7354b = Math.abs(i);
    }

    /* renamed from: G */
    public final void m1785G(RecyclerView.Recycler recycler, C0469e0 c0469e0) {
        int min;
        int min2;
        if (c0469e0.f7353a && !c0469e0.f7361i) {
            if (c0469e0.f7354b == 0) {
                if (c0469e0.f7357e == -1) {
                    m1786H(c0469e0.f7359g, recycler);
                    return;
                } else {
                    m1787I(c0469e0.f7358f, recycler);
                    return;
                }
            }
            int i = 1;
            if (c0469e0.f7357e == -1) {
                int i2 = c0469e0.f7358f;
                int m1869j = this.f7284r[0].m1869j(i2);
                while (i < this.f7283q) {
                    int m1869j2 = this.f7284r[i].m1869j(i2);
                    if (m1869j2 > m1869j) {
                        m1869j = m1869j2;
                    }
                    i++;
                }
                int i3 = i2 - m1869j;
                if (i3 < 0) {
                    min2 = c0469e0.f7359g;
                } else {
                    min2 = c0469e0.f7359g - Math.min(i3, c0469e0.f7354b);
                }
                m1786H(min2, recycler);
                return;
            }
            int i4 = c0469e0.f7359g;
            int m1867h = this.f7284r[0].m1867h(i4);
            while (i < this.f7283q) {
                int m1867h2 = this.f7284r[i].m1867h(i4);
                if (m1867h2 < m1867h) {
                    m1867h = m1867h2;
                }
                i++;
            }
            int i5 = m1867h - c0469e0.f7359g;
            if (i5 < 0) {
                min = c0469e0.f7358f;
            } else {
                min = Math.min(i5, c0469e0.f7354b) + c0469e0.f7358f;
            }
            m1787I(min, recycler);
        }
    }

    /* renamed from: H */
    public final void m1786H(int i, RecyclerView.Recycler recycler) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.f7285s.getDecoratedStart(childAt) >= i && this.f7285s.getTransformedStartWithDecoration(childAt) >= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f7294f) {
                    for (int i2 = 0; i2 < this.f7283q; i2++) {
                        if (this.f7284r[i2].f7405a.size() == 1) {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.f7283q; i3++) {
                        this.f7284r[i3].m1870k();
                    }
                } else if (layoutParams.f7293e.f7405a.size() == 1) {
                    return;
                } else {
                    layoutParams.f7293e.m1870k();
                }
                removeAndRecycleView(childAt, recycler);
            } else {
                return;
            }
        }
    }

    /* renamed from: I */
    public final void m1787I(int i, RecyclerView.Recycler recycler) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f7285s.getDecoratedEnd(childAt) <= i && this.f7285s.getTransformedEndWithDecoration(childAt) <= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f7294f) {
                    for (int i2 = 0; i2 < this.f7283q; i2++) {
                        if (this.f7284r[i2].f7405a.size() == 1) {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.f7283q; i3++) {
                        this.f7284r[i3].m1871l();
                    }
                } else if (layoutParams.f7293e.f7405a.size() == 1) {
                    return;
                } else {
                    layoutParams.f7293e.m1871l();
                }
                removeAndRecycleView(childAt, recycler);
            } else {
                return;
            }
        }
    }

    /* renamed from: J */
    public final void m1788J() {
        if (this.f7287u != 1 && isLayoutRTL()) {
            this.f7291y = !this.f7290x;
        } else {
            this.f7291y = this.f7290x;
        }
    }

    /* renamed from: K */
    public final int m1789K(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        m1784F(i, state);
        C0469e0 c0469e0 = this.f7289w;
        int m1799r = m1799r(recycler, c0469e0, state);
        if (c0469e0.f7354b >= m1799r) {
            if (i < 0) {
                i = -m1799r;
            } else {
                i = m1799r;
            }
        }
        this.f7285s.offsetChildren(-i);
        this.f7273E = this.f7291y;
        c0469e0.f7354b = 0;
        m1785G(recycler, c0469e0);
        return i;
    }

    /* renamed from: L */
    public final void m1790L(int i) {
        boolean z;
        C0469e0 c0469e0 = this.f7289w;
        c0469e0.f7357e = i;
        boolean z2 = this.f7291y;
        int i2 = 1;
        if (i == -1) {
            z = true;
        } else {
            z = false;
        }
        if (z2 != z) {
            i2 = -1;
        }
        c0469e0.f7356d = i2;
    }

    /* renamed from: M */
    public final void m1791M(int i, int i2) {
        for (int i3 = 0; i3 < this.f7283q; i3++) {
            if (!this.f7284r[i3].f7405a.isEmpty()) {
                m1793O(this.f7284r[i3], i, i2);
            }
        }
    }

    /* renamed from: N */
    public final void m1792N(int i, RecyclerView.State state) {
        int i2;
        int i3;
        int targetScrollPosition;
        boolean z;
        C0469e0 c0469e0 = this.f7289w;
        boolean z2 = false;
        c0469e0.f7354b = 0;
        c0469e0.f7355c = i;
        if (isSmoothScrolling() && (targetScrollPosition = state.getTargetScrollPosition()) != -1) {
            boolean z3 = this.f7291y;
            if (targetScrollPosition < i) {
                z = true;
            } else {
                z = false;
            }
            if (z3 == z) {
                i2 = this.f7285s.getTotalSpace();
                i3 = 0;
            } else {
                i3 = this.f7285s.getTotalSpace();
                i2 = 0;
            }
        } else {
            i2 = 0;
            i3 = 0;
        }
        if (getClipToPadding()) {
            c0469e0.f7358f = this.f7285s.getStartAfterPadding() - i3;
            c0469e0.f7359g = this.f7285s.getEndAfterPadding() + i2;
        } else {
            c0469e0.f7359g = this.f7285s.getEnd() + i2;
            c0469e0.f7358f = -i3;
        }
        c0469e0.f7360h = false;
        c0469e0.f7353a = true;
        if (this.f7285s.getMode() == 0 && this.f7285s.getEnd() == 0) {
            z2 = true;
        }
        c0469e0.f7361i = z2;
    }

    /* renamed from: O */
    public final void m1793O(C0482i1 c0482i1, int i, int i2) {
        int i3 = c0482i1.f7408d;
        int i4 = c0482i1.f7409e;
        if (i == -1) {
            int i5 = c0482i1.f7406b;
            if (i5 == Integer.MIN_VALUE) {
                c0482i1.m1862c();
                i5 = c0482i1.f7406b;
            }
            if (i5 + i3 <= i2) {
                this.f7292z.set(i4, false);
                return;
            }
            return;
        }
        int i6 = c0482i1.f7407c;
        if (i6 == Integer.MIN_VALUE) {
            c0482i1.m1861b();
            i6 = c0482i1.f7407c;
        }
        if (i6 - i3 >= i2) {
            this.f7292z.set(i4, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.f7275G == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.f7287u == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.f7287u == 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        C0469e0 c0469e0;
        int m1867h;
        int i3;
        if (this.f7287u != 0) {
            i = i2;
        }
        if (getChildCount() != 0 && i != 0) {
            m1784F(i, state);
            int[] iArr = this.f7281M;
            if (iArr == null || iArr.length < this.f7283q) {
                this.f7281M = new int[this.f7283q];
            }
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int i6 = this.f7283q;
                c0469e0 = this.f7289w;
                if (i4 >= i6) {
                    break;
                }
                if (c0469e0.f7356d == -1) {
                    m1867h = c0469e0.f7358f;
                    i3 = this.f7284r[i4].m1869j(m1867h);
                } else {
                    m1867h = this.f7284r[i4].m1867h(c0469e0.f7359g);
                    i3 = c0469e0.f7359g;
                }
                int i7 = m1867h - i3;
                if (i7 >= 0) {
                    this.f7281M[i5] = i7;
                    i5++;
                }
                i4++;
            }
            Arrays.sort(this.f7281M, 0, i5);
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = c0469e0.f7355c;
                if (i9 >= 0 && i9 < state.getItemCount()) {
                    layoutPrefetchRegistry.addPosition(c0469e0.f7355c, this.f7281M[i8]);
                    c0469e0.f7355c += c0469e0.f7356d;
                } else {
                    return;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return m1796o(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return m1797p(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return m1798q(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        int m1794m = m1794m(i);
        PointF pointF = new PointF();
        if (m1794m == 0) {
            return null;
        }
        if (this.f7287u == 0) {
            pointF.x = m1794m;
            pointF.y = RecyclerView.f7068F0;
        } else {
            pointF.x = RecyclerView.f7068F0;
            pointF.y = m1794m;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return m1796o(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return m1797p(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return m1798q(state);
    }

    public int[] findFirstCompletelyVisibleItemPositions(int[] iArr) {
        int m1866g;
        if (iArr == null) {
            iArr = new int[this.f7283q];
        } else if (iArr.length < this.f7283q) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f7283q + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.f7283q; i++) {
            C0482i1 c0482i1 = this.f7284r[i];
            boolean z = c0482i1.f7410f.f7290x;
            ArrayList arrayList = c0482i1.f7405a;
            if (z) {
                m1866g = c0482i1.m1866g(arrayList.size() - 1, -1, true, true, false);
            } else {
                m1866g = c0482i1.m1866g(0, arrayList.size(), true, true, false);
            }
            iArr[i] = m1866g;
        }
        return iArr;
    }

    public int[] findFirstVisibleItemPositions(int[] iArr) {
        int m1866g;
        if (iArr == null) {
            iArr = new int[this.f7283q];
        } else if (iArr.length < this.f7283q) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f7283q + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.f7283q; i++) {
            C0482i1 c0482i1 = this.f7284r[i];
            boolean z = c0482i1.f7410f.f7290x;
            ArrayList arrayList = c0482i1.f7405a;
            if (z) {
                m1866g = c0482i1.m1866g(arrayList.size() - 1, -1, false, true, false);
            } else {
                m1866g = c0482i1.m1866g(0, arrayList.size(), false, true, false);
            }
            iArr[i] = m1866g;
        }
        return iArr;
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] iArr) {
        int m1866g;
        if (iArr == null) {
            iArr = new int[this.f7283q];
        } else if (iArr.length < this.f7283q) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f7283q + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.f7283q; i++) {
            C0482i1 c0482i1 = this.f7284r[i];
            boolean z = c0482i1.f7410f.f7290x;
            ArrayList arrayList = c0482i1.f7405a;
            if (z) {
                m1866g = c0482i1.m1866g(0, arrayList.size(), true, true, false);
            } else {
                m1866g = c0482i1.m1866g(arrayList.size() - 1, -1, true, true, false);
            }
            iArr[i] = m1866g;
        }
        return iArr;
    }

    public int[] findLastVisibleItemPositions(int[] iArr) {
        int m1866g;
        if (iArr == null) {
            iArr = new int[this.f7283q];
        } else if (iArr.length < this.f7283q) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f7283q + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.f7283q; i++) {
            C0482i1 c0482i1 = this.f7284r[i];
            boolean z = c0482i1.f7410f.f7290x;
            ArrayList arrayList = c0482i1.f7405a;
            if (z) {
                m1866g = c0482i1.m1866g(0, arrayList.size(), false, true, false);
            } else {
                m1866g = c0482i1.m1866g(arrayList.size() - 1, -1, false, true, false);
            }
            iArr[i] = m1866g;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.f7287u == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public int getGapStrategy() {
        return this.f7272D;
    }

    public int getOrientation() {
        return this.f7287u;
    }

    public boolean getReverseLayout() {
        return this.f7290x;
    }

    public int getSpanCount() {
        return this.f7283q;
    }

    public void invalidateSpanAssignments() {
        this.f7271C.m1846b();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        if (this.f7272D != 0) {
            return true;
        }
        return false;
    }

    public final boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: m */
    public final int m1794m(int i) {
        boolean z;
        if (getChildCount() == 0) {
            if (!this.f7291y) {
                return -1;
            }
            return 1;
        }
        if (i < m1804w()) {
            z = true;
        } else {
            z = false;
        }
        if (z != this.f7291y) {
            return -1;
        }
        return 1;
    }

    /* renamed from: n */
    public final boolean m1795n() {
        int m1804w;
        int m1805x;
        int i;
        if (getChildCount() == 0 || this.f7272D == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.f7291y) {
            m1804w = m1805x();
            m1805x = m1804w();
        } else {
            m1804w = m1804w();
            m1805x = m1805x();
        }
        C0476g1 c0476g1 = this.f7271C;
        if (m1804w == 0 && m1780B() != null) {
            c0476g1.m1846b();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
        if (!this.f7279K) {
            return false;
        }
        if (this.f7291y) {
            i = -1;
        } else {
            i = 1;
        }
        int i2 = m1805x + 1;
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem m1849e = c0476g1.m1849e(m1804w, i2, i);
        if (m1849e == null) {
            this.f7279K = false;
            c0476g1.m1848d(i2);
            return false;
        }
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem m1849e2 = c0476g1.m1849e(m1804w, m1849e.f7295a, i * (-1));
        if (m1849e2 == null) {
            c0476g1.m1848d(m1849e.f7295a);
        } else {
            c0476g1.m1848d(m1849e2.f7295a + 1);
        }
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    }

    /* renamed from: o */
    public final int m1796o(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        OrientationHelper orientationHelper = this.f7285s;
        boolean z = !this.f7280L;
        return AbstractC0464c1.m1823a(state, orientationHelper, m1801t(z), m1800s(z), this, this.f7280L);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.f7283q; i2++) {
            C0482i1 c0482i1 = this.f7284r[i2];
            int i3 = c0482i1.f7406b;
            if (i3 != Integer.MIN_VALUE) {
                c0482i1.f7406b = i3 + i;
            }
            int i4 = c0482i1.f7407c;
            if (i4 != Integer.MIN_VALUE) {
                c0482i1.f7407c = i4 + i;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.f7283q; i2++) {
            C0482i1 c0482i1 = this.f7284r[i2];
            int i3 = c0482i1.f7406b;
            if (i3 != Integer.MIN_VALUE) {
                c0482i1.f7406b = i3 + i;
            }
            int i4 = c0482i1.f7407c;
            if (i4 != Integer.MIN_VALUE) {
                c0482i1.f7407c = i4 + i;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(@Nullable RecyclerView.Adapter adapter, @Nullable RecyclerView.Adapter adapter2) {
        this.f7271C.m1846b();
        for (int i = 0; i < this.f7283q; i++) {
            this.f7284r[i].m1863d();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        removeCallbacks(this.f7282N);
        for (int i = 0; i < this.f7283q; i++) {
            this.f7284r[i].m1863d();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0039, code lost:
    
        if (r9.f7287u == 1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x003e, code lost:
    
        if (r9.f7287u == 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x004b, code lost:
    
        if (isLayoutRTL() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0058, code lost:
    
        if (isLayoutRTL() == false) goto L38;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        View findContainingItemView;
        int i2;
        int m1804w;
        boolean z;
        boolean z2;
        int m1865f;
        int m1865f2;
        int m1865f3;
        View m1868i;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        m1788J();
        if (i != 1) {
            if (i != 2) {
                if (i != 17) {
                    if (i != 33) {
                        if (i == 66) {
                        }
                    }
                    i2 = Integer.MIN_VALUE;
                }
            } else {
                if (this.f7287u != 1) {
                }
                i2 = 1;
            }
        } else {
            if (this.f7287u != 1) {
            }
            i2 = -1;
        }
        if (i2 == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        boolean z3 = layoutParams.f7294f;
        C0482i1 c0482i1 = layoutParams.f7293e;
        if (i2 == 1) {
            m1804w = m1805x();
        } else {
            m1804w = m1804w();
        }
        m1792N(m1804w, state);
        m1790L(i2);
        C0469e0 c0469e0 = this.f7289w;
        c0469e0.f7355c = c0469e0.f7356d + m1804w;
        c0469e0.f7354b = (int) (this.f7285s.getTotalSpace() * 0.33333334f);
        c0469e0.f7360h = true;
        c0469e0.f7353a = false;
        m1799r(recycler, c0469e0, state);
        this.f7273E = this.f7291y;
        if (!z3 && (m1868i = c0482i1.m1868i(m1804w, i2)) != null && m1868i != findContainingItemView) {
            return m1868i;
        }
        if (m1783E(i2)) {
            for (int i3 = this.f7283q - 1; i3 >= 0; i3--) {
                View m1868i2 = this.f7284r[i3].m1868i(m1804w, i2);
                if (m1868i2 != null && m1868i2 != findContainingItemView) {
                    return m1868i2;
                }
            }
        } else {
            for (int i4 = 0; i4 < this.f7283q; i4++) {
                View m1868i3 = this.f7284r[i4].m1868i(m1804w, i2);
                if (m1868i3 != null && m1868i3 != findContainingItemView) {
                    return m1868i3;
                }
            }
        }
        boolean z4 = !this.f7290x;
        if (i2 == -1) {
            z = true;
        } else {
            z = false;
        }
        if (z4 == z) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z3) {
            if (z2) {
                m1865f3 = c0482i1.m1864e();
            } else {
                m1865f3 = c0482i1.m1865f();
            }
            View findViewByPosition = findViewByPosition(m1865f3);
            if (findViewByPosition != null && findViewByPosition != findContainingItemView) {
                return findViewByPosition;
            }
        }
        if (m1783E(i2)) {
            for (int i5 = this.f7283q - 1; i5 >= 0; i5--) {
                if (i5 != c0482i1.f7409e) {
                    if (z2) {
                        m1865f2 = this.f7284r[i5].m1864e();
                    } else {
                        m1865f2 = this.f7284r[i5].m1865f();
                    }
                    View findViewByPosition2 = findViewByPosition(m1865f2);
                    if (findViewByPosition2 != null && findViewByPosition2 != findContainingItemView) {
                        return findViewByPosition2;
                    }
                }
            }
        } else {
            for (int i6 = 0; i6 < this.f7283q; i6++) {
                if (z2) {
                    m1865f = this.f7284r[i6].m1864e();
                } else {
                    m1865f = this.f7284r[i6].m1865f();
                }
                View findViewByPosition3 = findViewByPosition(m1865f);
                if (findViewByPosition3 != null && findViewByPosition3 != findContainingItemView) {
                    return findViewByPosition3;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View m1801t = m1801t(false);
            View m1800s = m1800s(false);
            if (m1801t != null && m1800s != null) {
                int position = getPosition(m1801t);
                int position2 = getPosition(m1800s);
                if (position < position2) {
                    accessibilityEvent.setFromIndex(position);
                    accessibilityEvent.setToIndex(position2);
                } else {
                    accessibilityEvent.setFromIndex(position2);
                    accessibilityEvent.setToIndex(position);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        m1779A(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.f7271C.m1846b();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        m1779A(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        m1779A(i, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        m1779A(i, i2, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        m1782D(recycler, state, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f7269A = -1;
        this.f7270B = Integer.MIN_VALUE;
        this.f7275G = null;
        this.f7278J.m7500a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f7275G = savedState;
            if (this.f7269A != -1) {
                savedState.f7302d = null;
                savedState.f7301c = 0;
                savedState.f7299a = -1;
                savedState.f7300b = -1;
                savedState.f7302d = null;
                savedState.f7301c = 0;
                savedState.f7303e = 0;
                savedState.f7304f = null;
                savedState.f7305g = null;
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        int m1804w;
        View m1801t;
        int m1869j;
        int startAfterPadding;
        int[] iArr;
        SavedState savedState = this.f7275G;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        savedState2.f7306h = this.f7290x;
        savedState2.f7307i = this.f7273E;
        savedState2.f7308j = this.f7274F;
        C0476g1 c0476g1 = this.f7271C;
        if (c0476g1 != null && (iArr = c0476g1.f7392a) != null) {
            savedState2.f7304f = iArr;
            savedState2.f7303e = iArr.length;
            savedState2.f7305g = c0476g1.f7393b;
        } else {
            savedState2.f7303e = 0;
        }
        int i = -1;
        if (getChildCount() > 0) {
            if (this.f7273E) {
                m1804w = m1805x();
            } else {
                m1804w = m1804w();
            }
            savedState2.f7299a = m1804w;
            if (this.f7291y) {
                m1801t = m1800s(true);
            } else {
                m1801t = m1801t(true);
            }
            if (m1801t != null) {
                i = getPosition(m1801t);
            }
            savedState2.f7300b = i;
            int i2 = this.f7283q;
            savedState2.f7301c = i2;
            savedState2.f7302d = new int[i2];
            for (int i3 = 0; i3 < this.f7283q; i3++) {
                if (this.f7273E) {
                    m1869j = this.f7284r[i3].m1867h(Integer.MIN_VALUE);
                    if (m1869j != Integer.MIN_VALUE) {
                        startAfterPadding = this.f7285s.getEndAfterPadding();
                        m1869j -= startAfterPadding;
                        savedState2.f7302d[i3] = m1869j;
                    } else {
                        savedState2.f7302d[i3] = m1869j;
                    }
                } else {
                    m1869j = this.f7284r[i3].m1869j(Integer.MIN_VALUE);
                    if (m1869j != Integer.MIN_VALUE) {
                        startAfterPadding = this.f7285s.getStartAfterPadding();
                        m1869j -= startAfterPadding;
                        savedState2.f7302d[i3] = m1869j;
                    } else {
                        savedState2.f7302d[i3] = m1869j;
                    }
                }
            }
        } else {
            savedState2.f7299a = -1;
            savedState2.f7300b = -1;
            savedState2.f7301c = 0;
        }
        return savedState2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        if (i == 0) {
            m1795n();
        }
    }

    /* renamed from: p */
    public final int m1797p(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        OrientationHelper orientationHelper = this.f7285s;
        boolean z = !this.f7280L;
        return AbstractC0464c1.m1824b(state, orientationHelper, m1801t(z), m1800s(z), this, this.f7280L, this.f7291y);
    }

    /* renamed from: q */
    public final int m1798q(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        OrientationHelper orientationHelper = this.f7285s;
        boolean z = !this.f7280L;
        return AbstractC0464c1.m1825c(state, orientationHelper, m1801t(z), m1800s(z), this, this.f7280L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0336  */
    /* JADX WARN: Type inference failed for: r9v12, types: [androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v20, types: [androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem, java.lang.Object] */
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m1799r(RecyclerView.Recycler recycler, C0469e0 c0469e0, RecyclerView.State state) {
        int i;
        int i2;
        int startAfterPadding;
        int i3;
        int m1806y;
        int i4;
        int i5;
        C0482i1 c0482i1;
        int i6;
        int m1869j;
        int decoratedMeasurement;
        int i7;
        int i8;
        int i9;
        int startAfterPadding2;
        int i10;
        int decoratedMeasurement2;
        View view;
        LayoutParams layoutParams;
        int i11;
        int i12;
        int endAfterPadding;
        boolean z;
        boolean z2;
        int m1867h;
        int i13;
        int i14;
        int i15;
        RecyclerView.Recycler recycler2 = recycler;
        int i16 = 0;
        int i17 = 1;
        this.f7292z.set(0, this.f7283q, true);
        C0469e0 c0469e02 = this.f7289w;
        if (c0469e02.f7361i) {
            if (c0469e0.f7357e == 1) {
                i2 = Integer.MAX_VALUE;
            } else {
                i2 = Integer.MIN_VALUE;
            }
        } else {
            if (c0469e0.f7357e == 1) {
                i = c0469e0.f7359g + c0469e0.f7354b;
            } else {
                i = c0469e0.f7358f - c0469e0.f7354b;
            }
            i2 = i;
        }
        m1791M(c0469e0.f7357e, i2);
        if (this.f7291y) {
            startAfterPadding = this.f7285s.getEndAfterPadding();
        } else {
            startAfterPadding = this.f7285s.getStartAfterPadding();
        }
        int i18 = startAfterPadding;
        boolean z3 = false;
        while (true) {
            int i19 = c0469e0.f7355c;
            if (i19 >= 0 && i19 < state.getItemCount()) {
                i3 = i17;
            } else {
                i3 = i16;
            }
            if (i3 == 0 || (!c0469e02.f7361i && this.f7292z.isEmpty())) {
                break;
            }
            View viewForPosition = recycler2.getViewForPosition(c0469e0.f7355c);
            c0469e0.f7355c += c0469e0.f7356d;
            LayoutParams layoutParams2 = (LayoutParams) viewForPosition.getLayoutParams();
            int viewLayoutPosition = layoutParams2.getViewLayoutPosition();
            C0476g1 c0476g1 = this.f7271C;
            int[] iArr = c0476g1.f7392a;
            if (iArr != null && viewLayoutPosition < iArr.length) {
                i4 = iArr[viewLayoutPosition];
            } else {
                i4 = -1;
            }
            if (i4 == -1) {
                i5 = i17;
            } else {
                i5 = i16;
            }
            if (i5 != 0) {
                if (layoutParams2.f7294f) {
                    c0482i1 = this.f7284r[i16];
                } else {
                    if (m1783E(c0469e0.f7357e)) {
                        i14 = this.f7283q - i17;
                        i13 = -1;
                        i15 = -1;
                    } else {
                        i13 = this.f7283q;
                        i14 = i16;
                        i15 = i17;
                    }
                    C0482i1 c0482i12 = null;
                    if (c0469e0.f7357e == i17) {
                        int startAfterPadding3 = this.f7285s.getStartAfterPadding();
                        int i20 = Integer.MAX_VALUE;
                        while (i14 != i13) {
                            C0482i1 c0482i13 = this.f7284r[i14];
                            int m1867h2 = c0482i13.m1867h(startAfterPadding3);
                            if (m1867h2 < i20) {
                                i20 = m1867h2;
                                c0482i12 = c0482i13;
                            }
                            i14 += i15;
                        }
                    } else {
                        int endAfterPadding2 = this.f7285s.getEndAfterPadding();
                        int i21 = Integer.MIN_VALUE;
                        while (i14 != i13) {
                            C0482i1 c0482i14 = this.f7284r[i14];
                            int m1869j2 = c0482i14.m1869j(endAfterPadding2);
                            if (m1869j2 > i21) {
                                c0482i12 = c0482i14;
                                i21 = m1869j2;
                            }
                            i14 += i15;
                        }
                    }
                    c0482i1 = c0482i12;
                }
                c0476g1.m1847c(viewLayoutPosition);
                c0476g1.f7392a[viewLayoutPosition] = c0482i1.f7409e;
            } else {
                c0482i1 = this.f7284r[i4];
            }
            C0482i1 c0482i15 = c0482i1;
            layoutParams2.f7293e = c0482i15;
            if (c0469e0.f7357e == 1) {
                addView(viewForPosition);
            } else {
                addView(viewForPosition, 0);
            }
            if (layoutParams2.f7294f) {
                if (this.f7287u == 1) {
                    i6 = i2;
                    m1781C(viewForPosition, this.f7276H, RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop(), ((ViewGroup.MarginLayoutParams) layoutParams2).height, true));
                } else {
                    i6 = i2;
                    m1781C(viewForPosition, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft(), ((ViewGroup.MarginLayoutParams) layoutParams2).width, true), this.f7276H);
                }
            } else {
                i6 = i2;
                if (this.f7287u == 1) {
                    m1781C(viewForPosition, RecyclerView.LayoutManager.getChildMeasureSpec(this.f7288v, getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams2).width, false), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop(), ((ViewGroup.MarginLayoutParams) layoutParams2).height, true));
                } else {
                    m1781C(viewForPosition, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft(), ((ViewGroup.MarginLayoutParams) layoutParams2).width, true), RecyclerView.LayoutManager.getChildMeasureSpec(this.f7288v, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams2).height, false));
                }
            }
            if (c0469e0.f7357e == 1) {
                if (layoutParams2.f7294f) {
                    m1867h = m1806y(i18);
                } else {
                    m1867h = c0482i15.m1867h(i18);
                }
                int decoratedMeasurement3 = this.f7285s.getDecoratedMeasurement(viewForPosition) + m1867h;
                if (i5 != 0 && layoutParams2.f7294f) {
                    ?? obj = new Object();
                    obj.f7297c = new int[this.f7283q];
                    for (int i22 = 0; i22 < this.f7283q; i22++) {
                        obj.f7297c[i22] = m1867h - this.f7284r[i22].m1867h(m1867h);
                    }
                    obj.f7296b = -1;
                    obj.f7295a = viewLayoutPosition;
                    c0476g1.m1845a(obj);
                }
                i7 = decoratedMeasurement3;
                decoratedMeasurement = m1867h;
            } else {
                if (layoutParams2.f7294f) {
                    m1869j = m1807z(i18);
                } else {
                    m1869j = c0482i15.m1869j(i18);
                }
                decoratedMeasurement = m1869j - this.f7285s.getDecoratedMeasurement(viewForPosition);
                if (i5 != 0 && layoutParams2.f7294f) {
                    ?? obj2 = new Object();
                    obj2.f7297c = new int[this.f7283q];
                    for (int i23 = 0; i23 < this.f7283q; i23++) {
                        obj2.f7297c[i23] = this.f7284r[i23].m1869j(m1869j) - m1869j;
                    }
                    obj2.f7296b = 1;
                    obj2.f7295a = viewLayoutPosition;
                    c0476g1.m1845a(obj2);
                }
                i7 = m1869j;
            }
            if (layoutParams2.f7294f && c0469e0.f7356d == -1) {
                if (i5 != 0) {
                    i8 = 1;
                    this.f7279K = true;
                } else {
                    if (c0469e0.f7357e == 1) {
                        int m1867h3 = this.f7284r[0].m1867h(Integer.MIN_VALUE);
                        for (int i24 = 1; i24 < this.f7283q; i24++) {
                            if (this.f7284r[i24].m1867h(Integer.MIN_VALUE) != m1867h3) {
                                z = 1;
                                z2 = false;
                                break;
                            }
                        }
                        z = 1;
                        z2 = true;
                    } else {
                        int m1869j3 = this.f7284r[0].m1869j(Integer.MIN_VALUE);
                        for (int i25 = 1; i25 < this.f7283q; i25++) {
                            if (this.f7284r[i25].m1869j(Integer.MIN_VALUE) != m1869j3) {
                                z = 1;
                                z2 = false;
                                break;
                            }
                        }
                        z = 1;
                        z2 = true;
                    }
                    i9 = z;
                    if (!z2) {
                        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem m1850f = c0476g1.m1850f(viewLayoutPosition);
                        if (m1850f != null) {
                            m1850f.f7298d = z;
                        }
                        this.f7279K = z;
                        i9 = z;
                    }
                    if (c0469e0.f7357e != i9) {
                        if (layoutParams2.f7294f) {
                            for (int i26 = this.f7283q - i9; i26 >= 0; i26--) {
                                this.f7284r[i26].m1860a(viewForPosition);
                            }
                        } else {
                            layoutParams2.f7293e.m1860a(viewForPosition);
                        }
                    } else if (layoutParams2.f7294f) {
                        for (int i27 = this.f7283q - 1; i27 >= 0; i27--) {
                            this.f7284r[i27].m1872m(viewForPosition);
                        }
                    } else {
                        layoutParams2.f7293e.m1872m(viewForPosition);
                    }
                    if (!isLayoutRTL() && this.f7287u == 1) {
                        if (layoutParams2.f7294f) {
                            endAfterPadding = this.f7286t.getEndAfterPadding();
                        } else {
                            endAfterPadding = this.f7286t.getEndAfterPadding() - (((this.f7283q - 1) - c0482i15.f7409e) * this.f7288v);
                        }
                        decoratedMeasurement2 = endAfterPadding;
                        i10 = endAfterPadding - this.f7286t.getDecoratedMeasurement(viewForPosition);
                    } else {
                        if (!layoutParams2.f7294f) {
                            startAfterPadding2 = this.f7286t.getStartAfterPadding();
                        } else {
                            startAfterPadding2 = (c0482i15.f7409e * this.f7288v) + this.f7286t.getStartAfterPadding();
                        }
                        i10 = startAfterPadding2;
                        decoratedMeasurement2 = this.f7286t.getDecoratedMeasurement(viewForPosition) + startAfterPadding2;
                    }
                    if (this.f7287u != 1) {
                        view = viewForPosition;
                        layoutDecoratedWithMargins(viewForPosition, i10, decoratedMeasurement, decoratedMeasurement2, i7);
                        layoutParams = layoutParams2;
                    } else {
                        view = viewForPosition;
                        int i28 = i7;
                        layoutParams = layoutParams2;
                        layoutDecoratedWithMargins(view, decoratedMeasurement, i10, i28, decoratedMeasurement2);
                    }
                    if (!layoutParams.f7294f) {
                        i11 = i6;
                        m1791M(c0469e02.f7357e, i11);
                    } else {
                        i11 = i6;
                        m1793O(c0482i15, c0469e02.f7357e, i11);
                    }
                    m1785G(recycler, c0469e02);
                    if (c0469e02.f7360h && view.hasFocusable()) {
                        if (!layoutParams.f7294f) {
                            this.f7292z.clear();
                        } else {
                            i12 = 0;
                            this.f7292z.set(c0482i15.f7409e, false);
                            recycler2 = recycler;
                            i16 = i12;
                            z3 = true;
                            i17 = 1;
                            i2 = i11;
                        }
                    }
                    i12 = 0;
                    recycler2 = recycler;
                    i16 = i12;
                    z3 = true;
                    i17 = 1;
                    i2 = i11;
                }
            } else {
                i8 = 1;
            }
            i9 = i8;
            if (c0469e0.f7357e != i9) {
            }
            if (!isLayoutRTL()) {
            }
            if (!layoutParams2.f7294f) {
            }
            i10 = startAfterPadding2;
            decoratedMeasurement2 = this.f7286t.getDecoratedMeasurement(viewForPosition) + startAfterPadding2;
            if (this.f7287u != 1) {
            }
            if (!layoutParams.f7294f) {
            }
            m1785G(recycler, c0469e02);
            if (c0469e02.f7360h) {
                if (!layoutParams.f7294f) {
                }
            }
            i12 = 0;
            recycler2 = recycler;
            i16 = i12;
            z3 = true;
            i17 = 1;
            i2 = i11;
        }
        RecyclerView.Recycler recycler3 = recycler2;
        int i29 = i16;
        if (!z3) {
            m1785G(recycler3, c0469e02);
        }
        if (c0469e02.f7357e == -1) {
            m1806y = this.f7285s.getStartAfterPadding() - m1807z(this.f7285s.getStartAfterPadding());
        } else {
            m1806y = m1806y(this.f7285s.getEndAfterPadding()) - this.f7285s.getEndAfterPadding();
        }
        if (m1806y > 0) {
            return Math.min(c0469e0.f7354b, m1806y);
        }
        return i29;
    }

    /* renamed from: s */
    public final View m1800s(boolean z) {
        int startAfterPadding = this.f7285s.getStartAfterPadding();
        int endAfterPadding = this.f7285s.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.f7285s.getDecoratedStart(childAt);
            int decoratedEnd = this.f7285s.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd > endAfterPadding && z) {
                    if (view == null) {
                        view = childAt;
                    }
                } else {
                    return childAt;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return m1789K(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        SavedState savedState = this.f7275G;
        if (savedState != null && savedState.f7299a != i) {
            savedState.f7302d = null;
            savedState.f7301c = 0;
            savedState.f7299a = -1;
            savedState.f7300b = -1;
        }
        this.f7269A = i;
        this.f7270B = Integer.MIN_VALUE;
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        SavedState savedState = this.f7275G;
        if (savedState != null) {
            savedState.f7302d = null;
            savedState.f7301c = 0;
            savedState.f7299a = -1;
            savedState.f7300b = -1;
        }
        this.f7269A = i;
        this.f7270B = i2;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return m1789K(i, recycler, state);
    }

    public void setGapStrategy(int i) {
        assertNotInLayoutOrScroll(null);
        if (i == this.f7272D) {
            return;
        }
        if (i != 0 && i != 2) {
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
        this.f7272D = i;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int chooseSize;
        int chooseSize2;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.f7287u == 1) {
            chooseSize2 = RecyclerView.LayoutManager.chooseSize(i2, rect.height() + paddingBottom, getMinimumHeight());
            chooseSize = RecyclerView.LayoutManager.chooseSize(i, (this.f7288v * this.f7283q) + paddingRight, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.LayoutManager.chooseSize(i, rect.width() + paddingRight, getMinimumWidth());
            chooseSize2 = RecyclerView.LayoutManager.chooseSize(i2, (this.f7288v * this.f7283q) + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i == this.f7287u) {
            return;
        }
        this.f7287u = i;
        OrientationHelper orientationHelper = this.f7285s;
        this.f7285s = this.f7286t;
        this.f7286t = orientationHelper;
        requestLayout();
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.f7275G;
        if (savedState != null && savedState.f7306h != z) {
            savedState.f7306h = z;
        }
        this.f7290x = z;
        requestLayout();
    }

    public void setSpanCount(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.f7283q) {
            invalidateSpanAssignments();
            this.f7283q = i;
            this.f7292z = new BitSet(this.f7283q);
            this.f7284r = new C0482i1[this.f7283q];
            for (int i2 = 0; i2 < this.f7283q; i2++) {
                this.f7284r[i2] = new C0482i1(this, i2);
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        if (this.f7275G == null) {
            return true;
        }
        return false;
    }

    /* renamed from: t */
    public final View m1801t(boolean z) {
        int startAfterPadding = this.f7285s.getStartAfterPadding();
        int endAfterPadding = this.f7285s.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int decoratedStart = this.f7285s.getDecoratedStart(childAt);
            if (this.f7285s.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart < startAfterPadding && z) {
                    if (view == null) {
                        view = childAt;
                    }
                } else {
                    return childAt;
                }
            }
        }
        return view;
    }

    /* renamed from: u */
    public final void m1802u(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int endAfterPadding;
        int m1806y = m1806y(Integer.MIN_VALUE);
        if (m1806y != Integer.MIN_VALUE && (endAfterPadding = this.f7285s.getEndAfterPadding() - m1806y) > 0) {
            int i = endAfterPadding - (-m1789K(-endAfterPadding, recycler, state));
            if (z && i > 0) {
                this.f7285s.offsetChildren(i);
            }
        }
    }

    /* renamed from: v */
    public final void m1803v(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int startAfterPadding;
        int m1807z = m1807z(Integer.MAX_VALUE);
        if (m1807z != Integer.MAX_VALUE && (startAfterPadding = m1807z - this.f7285s.getStartAfterPadding()) > 0) {
            int m1789K = startAfterPadding - m1789K(startAfterPadding, recycler, state);
            if (z && m1789K > 0) {
                this.f7285s.offsetChildren(-m1789K);
            }
        }
    }

    /* renamed from: w */
    public final int m1804w() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    /* renamed from: x */
    public final int m1805x() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    /* renamed from: y */
    public final int m1806y(int i) {
        int m1867h = this.f7284r[0].m1867h(i);
        for (int i2 = 1; i2 < this.f7283q; i2++) {
            int m1867h2 = this.f7284r[i2].m1867h(i);
            if (m1867h2 > m1867h) {
                m1867h = m1867h2;
            }
        }
        return m1867h;
    }

    /* renamed from: z */
    public final int m1807z(int i) {
        int m1869j = this.f7284r[0].m1869j(i);
        for (int i2 = 1; i2 < this.f7283q; i2++) {
            int m1869j2 = this.f7284r[i2].m1869j(i);
            if (m1869j2 < m1869j) {
                m1869j = m1869j2;
            }
        }
        return m1869j;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.recyclerview.widget.g1, java.lang.Object] */
    public StaggeredGridLayoutManager(int i, int i2) {
        this.f7287u = i2;
        setSpanCount(i);
        this.f7289w = new C0469e0();
        this.f7285s = OrientationHelper.createOrientationHelper(this, this.f7287u);
        this.f7286t = OrientationHelper.createOrientationHelper(this, 1 - this.f7287u);
    }
}
