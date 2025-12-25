package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: androidx.recyclerview.widget.g1 */
/* loaded from: classes.dex */
public final class C0476g1 {

    /* renamed from: a */
    public int[] f7392a;

    /* renamed from: b */
    public ArrayList f7393b;

    /* renamed from: a */
    public final void m1845a(StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem) {
        if (this.f7393b == null) {
            this.f7393b = new ArrayList();
        }
        int size = this.f7393b.size();
        for (int i = 0; i < size; i++) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2 = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) this.f7393b.get(i);
            if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.f7295a == staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f7295a) {
                this.f7393b.remove(i);
            }
            if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.f7295a >= staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f7295a) {
                this.f7393b.add(i, staggeredGridLayoutManager$LazySpanLookup$FullSpanItem);
                return;
            }
        }
        this.f7393b.add(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem);
    }

    /* renamed from: b */
    public final void m1846b() {
        int[] iArr = this.f7392a;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        this.f7393b = null;
    }

    /* renamed from: c */
    public final void m1847c(int i) {
        int[] iArr = this.f7392a;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i, 10) + 1];
            this.f7392a = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i >= iArr.length) {
            int length = iArr.length;
            while (length <= i) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.f7392a = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = this.f7392a;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    /* renamed from: d */
    public final void m1848d(int i) {
        ArrayList arrayList = this.f7393b;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) this.f7393b.get(size)).f7295a >= i) {
                    this.f7393b.remove(size);
                }
            }
        }
        m1851g(i);
    }

    /* renamed from: e */
    public final StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem m1849e(int i, int i2, int i3) {
        ArrayList arrayList = this.f7393b;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) this.f7393b.get(i4);
            int i5 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f7295a;
            if (i5 >= i2) {
                return null;
            }
            if (i5 >= i && (i3 == 0 || staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f7296b == i3 || staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f7298d)) {
                return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
            }
        }
        return null;
    }

    /* renamed from: f */
    public final StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem m1850f(int i) {
        ArrayList arrayList = this.f7393b;
        if (arrayList == null) {
            return null;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) this.f7393b.get(size);
            if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f7295a == i) {
                return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0052  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m1851g(int i) {
        int i2;
        int[] iArr = this.f7392a;
        if (iArr == null || i >= iArr.length) {
            return -1;
        }
        if (this.f7393b != null) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem m1850f = m1850f(i);
            if (m1850f != null) {
                this.f7393b.remove(m1850f);
            }
            int size = this.f7393b.size();
            int i3 = 0;
            while (true) {
                if (i3 < size) {
                    if (((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) this.f7393b.get(i3)).f7295a >= i) {
                        break;
                    }
                    i3++;
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 != -1) {
                StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) this.f7393b.get(i3);
                this.f7393b.remove(i3);
                i2 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f7295a;
                if (i2 != -1) {
                    int[] iArr2 = this.f7392a;
                    Arrays.fill(iArr2, i, iArr2.length, -1);
                    return this.f7392a.length;
                }
                int min = Math.min(i2 + 1, this.f7392a.length);
                Arrays.fill(this.f7392a, i, min, -1);
                return min;
            }
        }
        i2 = -1;
        if (i2 != -1) {
        }
    }

    /* renamed from: h */
    public final void m1852h(int i, int i2) {
        int[] iArr = this.f7392a;
        if (iArr != null && i < iArr.length) {
            int i3 = i + i2;
            m1847c(i3);
            int[] iArr2 = this.f7392a;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.f7392a, i, i3, -1);
            ArrayList arrayList = this.f7393b;
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) this.f7393b.get(size);
                    int i4 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f7295a;
                    if (i4 >= i) {
                        staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f7295a = i4 + i2;
                    }
                }
            }
        }
    }

    /* renamed from: i */
    public final void m1853i(int i, int i2) {
        int[] iArr = this.f7392a;
        if (iArr != null && i < iArr.length) {
            int i3 = i + i2;
            m1847c(i3);
            int[] iArr2 = this.f7392a;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.f7392a;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            ArrayList arrayList = this.f7393b;
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) this.f7393b.get(size);
                    int i4 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f7295a;
                    if (i4 >= i) {
                        if (i4 < i3) {
                            this.f7393b.remove(size);
                        } else {
                            staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f7295a = i4 - i2;
                        }
                    }
                }
            }
        }
    }
}
