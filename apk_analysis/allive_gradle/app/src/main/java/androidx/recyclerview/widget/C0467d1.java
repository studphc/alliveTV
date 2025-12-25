package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.d1 */
/* loaded from: classes.dex */
public final class C0467d1 extends RecyclerView.OnScrollListener {

    /* renamed from: a */
    public boolean f7350a = false;

    /* renamed from: b */
    public final /* synthetic */ SnapHelper f7351b;

    public C0467d1(SnapHelper snapHelper) {
        this.f7351b = snapHelper;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        if (i == 0 && this.f7350a) {
            this.f7350a = false;
            this.f7351b.m1770a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (i != 0 || i2 != 0) {
            this.f7350a = true;
        }
    }
}
