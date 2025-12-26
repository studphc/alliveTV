package androidx.leanback.widget;

import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.leanback.widget.n0 */
/* loaded from: classes.dex */
public final class C0365n0 extends RecyclerView.OnScrollListener {

    /* renamed from: a */
    public final /* synthetic */ FullWidthDetailsOverviewRowPresenter.ViewHolder f6327a;

    public C0365n0(FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder) {
        this.f6327a = viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        this.f6327a.m1393a();
    }
}
