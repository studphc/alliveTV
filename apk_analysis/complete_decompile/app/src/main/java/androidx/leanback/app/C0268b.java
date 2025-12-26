package androidx.leanback.app;

import androidx.leanback.app.HeadersFragment;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowHeaderPresenter;

/* renamed from: androidx.leanback.app.b */
/* loaded from: classes.dex */
public final class C0268b implements HeadersFragment.OnHeaderViewSelectedListener {

    /* renamed from: a */
    public final /* synthetic */ BrowseFragment f5316a;

    public C0268b(BrowseFragment browseFragment) {
        this.f5316a = browseFragment;
    }

    @Override // androidx.leanback.app.HeadersFragment.OnHeaderViewSelectedListener
    public final void onHeaderSelected(RowHeaderPresenter.ViewHolder viewHolder, Row row) {
        BrowseFragment browseFragment = this.f5316a;
        int selectedPosition = browseFragment.f4799G.getSelectedPosition();
        if (browseFragment.f4811S) {
            browseFragment.f4824f0.m90a(selectedPosition, 0, true);
        }
    }
}
