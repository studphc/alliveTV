package androidx.leanback.widget;

import androidx.leanback.widget.DetailsOverviewRowPresenter;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.leanback.widget.b0 */
/* loaded from: classes.dex */
public final class C0317b0 extends RecyclerView.OnScrollListener {

    /* renamed from: a */
    public final /* synthetic */ DetailsOverviewRowPresenter.ViewHolder f6270a;

    public C0317b0(DetailsOverviewRowPresenter.ViewHolder viewHolder) {
        this.f6270a = viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        this.f6270a.m1390b();
    }
}
