package p000;

import androidx.leanback.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class wx0 extends RecyclerView.OnScrollListener {

    /* renamed from: a */
    public final /* synthetic */ GridLayoutManager f28375a;

    public wx0(GridLayoutManager gridLayoutManager) {
        this.f28375a = gridLayoutManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            GridLayoutManager gridLayoutManager = this.f28375a;
            gridLayoutManager.f5714s.removeOnScrollListener(this);
            gridLayoutManager.requestLayout();
        }
    }
}
