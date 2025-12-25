package p000;

import androidx.leanback.app.BrowseSupportFragment;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: bi */
/* loaded from: classes.dex */
public final class C0558bi extends RecyclerView.OnScrollListener {

    /* renamed from: a */
    public final /* synthetic */ BrowseSupportFragment f8017a;

    public C0558bi(BrowseSupportFragment browseSupportFragment) {
        this.f8017a = browseSupportFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            recyclerView.removeOnScrollListener(this);
            BrowseSupportFragment browseSupportFragment = this.f8017a;
            if (!browseSupportFragment.f4875h1) {
                browseSupportFragment.m1275n();
            }
        }
    }
}
