package androidx.leanback.app;

import androidx.leanback.app.BrowseSupportFragment;

/* renamed from: androidx.leanback.app.m */
/* loaded from: classes.dex */
public final class C0279m implements BrowseSupportFragment.FragmentHost {

    /* renamed from: a */
    public boolean f5339a = true;

    /* renamed from: b */
    public final /* synthetic */ BrowseSupportFragment f5340b;

    public C0279m(BrowseSupportFragment browseSupportFragment) {
        this.f5340b = browseSupportFragment;
    }

    @Override // androidx.leanback.app.BrowseSupportFragment.FragmentHost
    public final void notifyDataReady(BrowseSupportFragment.MainFragmentAdapter mainFragmentAdapter) {
        BrowseSupportFragment browseSupportFragment = this.f5340b;
        BrowseSupportFragment.MainFragmentAdapter mainFragmentAdapter2 = browseSupportFragment.f4850I0;
        if (mainFragmentAdapter2 == null || mainFragmentAdapter2.getFragmentHost() != this || !browseSupportFragment.f4873f1) {
            return;
        }
        browseSupportFragment.f4757A0.fireEvent(browseSupportFragment.f4848G0);
    }

    @Override // androidx.leanback.app.BrowseSupportFragment.FragmentHost
    public final void notifyViewCreated(BrowseSupportFragment.MainFragmentAdapter mainFragmentAdapter) {
        BrowseSupportFragment browseSupportFragment = this.f5340b;
        browseSupportFragment.f4757A0.fireEvent(browseSupportFragment.f4847F0);
        if (!browseSupportFragment.f4873f1) {
            browseSupportFragment.f4757A0.fireEvent(browseSupportFragment.f4848G0);
        }
    }

    @Override // androidx.leanback.app.BrowseSupportFragment.FragmentHost
    public final void showTitleView(boolean z) {
        this.f5339a = z;
        BrowseSupportFragment browseSupportFragment = this.f5340b;
        BrowseSupportFragment.MainFragmentAdapter mainFragmentAdapter = browseSupportFragment.f4850I0;
        if (mainFragmentAdapter == null || mainFragmentAdapter.getFragmentHost() != this || !browseSupportFragment.f4873f1) {
            return;
        }
        browseSupportFragment.m1286y();
    }
}
