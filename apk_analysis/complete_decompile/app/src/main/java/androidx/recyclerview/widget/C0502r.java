package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.r */
/* loaded from: classes.dex */
public final class C0502r extends RecyclerView.OnScrollListener {

    /* renamed from: a */
    public final /* synthetic */ C0504s f7467a;

    public C0502r(C0504s c0504s) {
        this.f7467a = c0504s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        boolean z;
        boolean z2;
        int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
        int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        C0504s c0504s = this.f7467a;
        int computeVerticalScrollRange = c0504s.f7491s.computeVerticalScrollRange();
        int i3 = c0504s.f7490r;
        int i4 = computeVerticalScrollRange - i3;
        int i5 = c0504s.f7473a;
        if (i4 > 0 && i3 >= i5) {
            z = true;
        } else {
            z = false;
        }
        c0504s.f7492t = z;
        int computeHorizontalScrollRange = c0504s.f7491s.computeHorizontalScrollRange();
        int i6 = c0504s.f7489q;
        if (computeHorizontalScrollRange - i6 > 0 && i6 >= i5) {
            z2 = true;
        } else {
            z2 = false;
        }
        c0504s.f7493u = z2;
        boolean z3 = c0504s.f7492t;
        if (!z3 && !z2) {
            if (c0504s.f7494v != 0) {
                c0504s.m1887d(0);
                return;
            }
            return;
        }
        if (z3) {
            float f = i3;
            c0504s.f7484l = (int) ((((f / 2.0f) + computeVerticalScrollOffset) * f) / computeVerticalScrollRange);
            c0504s.f7483k = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
        }
        if (c0504s.f7493u) {
            float f2 = computeHorizontalScrollOffset;
            float f3 = i6;
            c0504s.f7487o = (int) ((((f3 / 2.0f) + f2) * f3) / computeHorizontalScrollRange);
            c0504s.f7486n = Math.min(i6, (i6 * i6) / computeHorizontalScrollRange);
        }
        int i7 = c0504s.f7494v;
        if (i7 == 0 || i7 == 1) {
            c0504s.m1887d(1);
        }
    }
}
