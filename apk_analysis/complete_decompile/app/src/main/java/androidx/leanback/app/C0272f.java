package androidx.leanback.app;

import androidx.leanback.app.BrowseFragment;

/* renamed from: androidx.leanback.app.f */
/* loaded from: classes.dex */
public final class C0272f implements BrowseFragment.FragmentHost {

    /* renamed from: a */
    public boolean f5325a = true;

    /* renamed from: b */
    public final /* synthetic */ BrowseFragment f5326b;

    public C0272f(BrowseFragment browseFragment) {
        this.f5326b = browseFragment;
    }

    @Override // androidx.leanback.app.BrowseFragment.FragmentHost
    public final void notifyDataReady(BrowseFragment.MainFragmentAdapter mainFragmentAdapter) {
        BrowseFragment browseFragment = this.f5326b;
        BrowseFragment.MainFragmentAdapter mainFragmentAdapter2 = browseFragment.f4797E;
        if (mainFragmentAdapter2 == null || mainFragmentAdapter2.getFragmentHost() != this || !browseFragment.f4820b0) {
            return;
        }
        browseFragment.f4754w.fireEvent(browseFragment.f4795C);
    }

    @Override // androidx.leanback.app.BrowseFragment.FragmentHost
    public final void notifyViewCreated(BrowseFragment.MainFragmentAdapter mainFragmentAdapter) {
        BrowseFragment browseFragment = this.f5326b;
        browseFragment.f4754w.fireEvent(browseFragment.f4794B);
        if (!browseFragment.f4820b0) {
            browseFragment.f4754w.fireEvent(browseFragment.f4795C);
        }
    }

    @Override // androidx.leanback.app.BrowseFragment.FragmentHost
    public final void showTitleView(boolean z) {
        this.f5325a = z;
        BrowseFragment browseFragment = this.f5326b;
        BrowseFragment.MainFragmentAdapter mainFragmentAdapter = browseFragment.f4797E;
        if (mainFragmentAdapter == null || mainFragmentAdapter.getFragmentHost() != this || !browseFragment.f4820b0) {
            return;
        }
        browseFragment.m1274n();
    }
}
