package p000;

import androidx.leanback.widget.RecyclerViewParallax;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class g92 extends RecyclerView.OnScrollListener {

    /* renamed from: a */
    public final /* synthetic */ RecyclerViewParallax f17620a;

    public g92(RecyclerViewParallax recyclerViewParallax) {
        this.f17620a = recyclerViewParallax;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        this.f17620a.updateValues();
    }
}
