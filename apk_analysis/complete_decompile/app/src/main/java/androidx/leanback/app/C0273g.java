package androidx.leanback.app;

import androidx.leanback.app.BrowseFragment;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;

/* renamed from: androidx.leanback.app.g */
/* loaded from: classes.dex */
public final class C0273g implements OnItemViewSelectedListener {

    /* renamed from: a */
    public final BrowseFragment.MainFragmentRowsAdapter f5327a;

    /* renamed from: b */
    public final /* synthetic */ BrowseFragment f5328b;

    public C0273g(BrowseFragment browseFragment, BrowseFragment.MainFragmentRowsAdapter mainFragmentRowsAdapter) {
        this.f5328b = browseFragment;
        this.f5327a = mainFragmentRowsAdapter;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
    public final void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        Row row2 = row;
        int selectedPosition = this.f5327a.getSelectedPosition();
        BrowseFragment browseFragment = this.f5328b;
        browseFragment.f4824f0.m90a(selectedPosition, 0, true);
        OnItemViewSelectedListener onItemViewSelectedListener = browseFragment.f4816X;
        if (onItemViewSelectedListener != null) {
            onItemViewSelectedListener.onItemSelected(viewHolder, obj, viewHolder2, row2);
        }
    }
}
