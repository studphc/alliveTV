package androidx.leanback.app;

import androidx.fragment.app.Fragment;
import androidx.leanback.app.HeadersSupportFragment;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowHeaderPresenter;

/* renamed from: androidx.leanback.app.h */
/* loaded from: classes.dex */
public final class C0274h implements HeadersSupportFragment.OnHeaderClickedListener {

    /* renamed from: a */
    public final /* synthetic */ BrowseSupportFragment f5329a;

    public C0274h(BrowseSupportFragment browseSupportFragment) {
        this.f5329a = browseSupportFragment;
    }

    @Override // androidx.leanback.app.HeadersSupportFragment.OnHeaderClickedListener
    public final void onHeaderClicked(RowHeaderPresenter.ViewHolder viewHolder, Row row) {
        Fragment fragment;
        BrowseSupportFragment browseSupportFragment = this.f5329a;
        if (browseSupportFragment.f4865X0 && browseSupportFragment.f4864W0 && !browseSupportFragment.isInHeadersTransition() && (fragment = browseSupportFragment.f4851J0) != null && fragment.getView() != null) {
            browseSupportFragment.m1284w(false);
            browseSupportFragment.f4851J0.getView().requestFocus();
        }
    }
}
