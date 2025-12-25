package androidx.leanback.app;

import android.app.Fragment;
import androidx.leanback.app.HeadersFragment;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowHeaderPresenter;

/* renamed from: androidx.leanback.app.a */
/* loaded from: classes.dex */
public final class C0267a implements HeadersFragment.OnHeaderClickedListener {

    /* renamed from: a */
    public final /* synthetic */ BrowseFragment f5315a;

    public C0267a(BrowseFragment browseFragment) {
        this.f5315a = browseFragment;
    }

    @Override // androidx.leanback.app.HeadersFragment.OnHeaderClickedListener
    public final void onHeaderClicked(RowHeaderPresenter.ViewHolder viewHolder, Row row) {
        Fragment fragment;
        BrowseFragment browseFragment = this.f5315a;
        if (browseFragment.f4812T && browseFragment.f4811S && !browseFragment.isInHeadersTransition() && (fragment = browseFragment.f4798F) != null && fragment.getView() != null) {
            browseFragment.m1272l(false);
            browseFragment.f4798F.getView().requestFocus();
        }
    }
}
