package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import p000.AbstractC1726qj;

/* renamed from: androidx.recyclerview.widget.i1 */
/* loaded from: classes.dex */
public final class C0482i1 {

    /* renamed from: a */
    public final ArrayList f7405a = new ArrayList();

    /* renamed from: b */
    public int f7406b = Integer.MIN_VALUE;

    /* renamed from: c */
    public int f7407c = Integer.MIN_VALUE;

    /* renamed from: d */
    public int f7408d = 0;

    /* renamed from: e */
    public final int f7409e;

    /* renamed from: f */
    public final /* synthetic */ StaggeredGridLayoutManager f7410f;

    public C0482i1(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
        this.f7410f = staggeredGridLayoutManager;
        this.f7409e = i;
    }

    /* renamed from: a */
    public final void m1860a(View view) {
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
        layoutParams.f7293e = this;
        ArrayList arrayList = this.f7405a;
        arrayList.add(view);
        this.f7407c = Integer.MIN_VALUE;
        if (arrayList.size() == 1) {
            this.f7406b = Integer.MIN_VALUE;
        }
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            this.f7408d = this.f7410f.f7285s.getDecoratedMeasurement(view) + this.f7408d;
        }
    }

    /* renamed from: b */
    public final void m1861b() {
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem m1850f;
        int i;
        View view = (View) AbstractC1726qj.m7053i(this.f7405a, 1);
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f7410f;
        this.f7407c = staggeredGridLayoutManager.f7285s.getDecoratedEnd(view);
        if (layoutParams.f7294f && (m1850f = staggeredGridLayoutManager.f7271C.m1850f(layoutParams.getViewLayoutPosition())) != null && m1850f.f7296b == 1) {
            int i2 = this.f7407c;
            int[] iArr = m1850f.f7297c;
            if (iArr == null) {
                i = 0;
            } else {
                i = iArr[this.f7409e];
            }
            this.f7407c = i2 + i;
        }
    }

    /* renamed from: c */
    public final void m1862c() {
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem m1850f;
        int i = 0;
        View view = (View) this.f7405a.get(0);
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f7410f;
        this.f7406b = staggeredGridLayoutManager.f7285s.getDecoratedStart(view);
        if (layoutParams.f7294f && (m1850f = staggeredGridLayoutManager.f7271C.m1850f(layoutParams.getViewLayoutPosition())) != null && m1850f.f7296b == -1) {
            int i2 = this.f7406b;
            int[] iArr = m1850f.f7297c;
            if (iArr != null) {
                i = iArr[this.f7409e];
            }
            this.f7406b = i2 - i;
        }
    }

    /* renamed from: d */
    public final void m1863d() {
        this.f7405a.clear();
        this.f7406b = Integer.MIN_VALUE;
        this.f7407c = Integer.MIN_VALUE;
        this.f7408d = 0;
    }

    /* renamed from: e */
    public final int m1864e() {
        boolean z = this.f7410f.f7290x;
        ArrayList arrayList = this.f7405a;
        if (z) {
            return m1866g(arrayList.size() - 1, -1, false, false, true);
        }
        return m1866g(0, arrayList.size(), false, false, true);
    }

    /* renamed from: f */
    public final int m1865f() {
        boolean z = this.f7410f.f7290x;
        ArrayList arrayList = this.f7405a;
        if (z) {
            return m1866g(0, arrayList.size(), false, false, true);
        }
        return m1866g(arrayList.size() - 1, -1, false, false, true);
    }

    /* renamed from: g */
    public final int m1866g(int i, int i2, boolean z, boolean z2, boolean z3) {
        int i3;
        boolean z4;
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f7410f;
        int startAfterPadding = staggeredGridLayoutManager.f7285s.getStartAfterPadding();
        int endAfterPadding = staggeredGridLayoutManager.f7285s.getEndAfterPadding();
        int i4 = i;
        if (i2 > i4) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        while (i4 != i2) {
            View view = (View) this.f7405a.get(i4);
            int decoratedStart = staggeredGridLayoutManager.f7285s.getDecoratedStart(view);
            int decoratedEnd = staggeredGridLayoutManager.f7285s.getDecoratedEnd(view);
            boolean z5 = false;
            if (!z3 ? decoratedStart < endAfterPadding : decoratedStart <= endAfterPadding) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z3 ? decoratedEnd > startAfterPadding : decoratedEnd >= startAfterPadding) {
                z5 = true;
            }
            if (z4 && z5) {
                if (z && z2) {
                    if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                        return staggeredGridLayoutManager.getPosition(view);
                    }
                } else {
                    if (z2) {
                        return staggeredGridLayoutManager.getPosition(view);
                    }
                    if (decoratedStart < startAfterPadding || decoratedEnd > endAfterPadding) {
                        return staggeredGridLayoutManager.getPosition(view);
                    }
                }
            }
            i4 += i3;
        }
        return -1;
    }

    /* renamed from: h */
    public final int m1867h(int i) {
        int i2 = this.f7407c;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (this.f7405a.size() == 0) {
            return i;
        }
        m1861b();
        return this.f7407c;
    }

    /* renamed from: i */
    public final View m1868i(int i, int i2) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f7410f;
        ArrayList arrayList = this.f7405a;
        View view = null;
        if (i2 == -1) {
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                View view2 = (View) arrayList.get(i3);
                if ((staggeredGridLayoutManager.f7290x && staggeredGridLayoutManager.getPosition(view2) <= i) || ((!staggeredGridLayoutManager.f7290x && staggeredGridLayoutManager.getPosition(view2) >= i) || !view2.hasFocusable())) {
                    break;
                }
                i3++;
                view = view2;
            }
        } else {
            int size2 = arrayList.size() - 1;
            while (size2 >= 0) {
                View view3 = (View) arrayList.get(size2);
                if ((staggeredGridLayoutManager.f7290x && staggeredGridLayoutManager.getPosition(view3) >= i) || ((!staggeredGridLayoutManager.f7290x && staggeredGridLayoutManager.getPosition(view3) <= i) || !view3.hasFocusable())) {
                    break;
                }
                size2--;
                view = view3;
            }
        }
        return view;
    }

    /* renamed from: j */
    public final int m1869j(int i) {
        int i2 = this.f7406b;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (this.f7405a.size() == 0) {
            return i;
        }
        m1862c();
        return this.f7406b;
    }

    /* renamed from: k */
    public final void m1870k() {
        ArrayList arrayList = this.f7405a;
        int size = arrayList.size();
        View view = (View) arrayList.remove(size - 1);
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
        layoutParams.f7293e = null;
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            this.f7408d -= this.f7410f.f7285s.getDecoratedMeasurement(view);
        }
        if (size == 1) {
            this.f7406b = Integer.MIN_VALUE;
        }
        this.f7407c = Integer.MIN_VALUE;
    }

    /* renamed from: l */
    public final void m1871l() {
        ArrayList arrayList = this.f7405a;
        View view = (View) arrayList.remove(0);
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
        layoutParams.f7293e = null;
        if (arrayList.size() == 0) {
            this.f7407c = Integer.MIN_VALUE;
        }
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            this.f7408d -= this.f7410f.f7285s.getDecoratedMeasurement(view);
        }
        this.f7406b = Integer.MIN_VALUE;
    }

    /* renamed from: m */
    public final void m1872m(View view) {
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
        layoutParams.f7293e = this;
        ArrayList arrayList = this.f7405a;
        arrayList.add(0, view);
        this.f7406b = Integer.MIN_VALUE;
        if (arrayList.size() == 1) {
            this.f7407c = Integer.MIN_VALUE;
        }
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            this.f7408d = this.f7410f.f7285s.getDecoratedMeasurement(view) + this.f7408d;
        }
    }
}
