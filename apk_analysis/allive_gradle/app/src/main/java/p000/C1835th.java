package p000;

import androidx.leanback.app.BrowseFragment;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: th */
/* loaded from: classes.dex */
public final class C1835th extends RecyclerView.OnScrollListener {

    /* renamed from: a */
    public final /* synthetic */ BrowseFragment f26810a;

    public C1835th(BrowseFragment browseFragment) {
        this.f26810a = browseFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            recyclerView.removeOnScrollListener(this);
            BrowseFragment browseFragment = this.f26810a;
            if (!browseFragment.f4822d0) {
                browseFragment.m1263c();
            }
        }
    }
}
