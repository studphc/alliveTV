package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

/* renamed from: androidx.recyclerview.widget.t */
/* loaded from: classes.dex */
public final class C0506t implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {

    /* renamed from: a */
    public int f7500a;

    /* renamed from: b */
    public int f7501b;

    /* renamed from: c */
    public int[] f7502c;

    /* renamed from: d */
    public int f7503d;

    /* renamed from: a */
    public final void m1889a(RecyclerView recyclerView, boolean z) {
        this.f7503d = 0;
        int[] iArr = this.f7502c;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.f7126n;
        if (recyclerView.f7124m != null && layoutManager != null && layoutManager.isItemPrefetchEnabled()) {
            if (z) {
                if (!recyclerView.f7108e.m1814g()) {
                    layoutManager.collectInitialPrefetchPositions(recyclerView.f7124m.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                layoutManager.collectAdjacentPrefetchPositions(this.f7500a, this.f7501b, recyclerView.f7117i0, this);
            }
            int i = this.f7503d;
            if (i > layoutManager.f7172k) {
                layoutManager.f7172k = i;
                layoutManager.f7173l = z;
                recyclerView.f7104c.m1752l();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry
    public final void addPosition(int i, int i2) {
        if (i >= 0) {
            if (i2 >= 0) {
                int i3 = this.f7503d;
                int i4 = i3 * 2;
                int[] iArr = this.f7502c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.f7502c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i4 >= iArr.length) {
                    int[] iArr3 = new int[i3 * 4];
                    this.f7502c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.f7502c;
                iArr4[i4] = i;
                iArr4[i4 + 1] = i2;
                this.f7503d++;
                return;
            }
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }
        throw new IllegalArgumentException("Layout positions must be non-negative");
    }
}
