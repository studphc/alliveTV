package androidx.leanback.app;

import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;

/* renamed from: androidx.leanback.app.n */
/* loaded from: classes.dex */
public final class C0280n implements OnItemViewSelectedListener {

    /* renamed from: a */
    public final BrowseSupportFragment.MainFragmentRowsAdapter f5341a;

    /* renamed from: b */
    public final /* synthetic */ BrowseSupportFragment f5342b;

    public C0280n(BrowseSupportFragment browseSupportFragment, BrowseSupportFragment.MainFragmentRowsAdapter mainFragmentRowsAdapter) {
        this.f5342b = browseSupportFragment;
        this.f5341a = mainFragmentRowsAdapter;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
    public final void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        Row row2 = row;
        int selectedPosition = this.f5341a.getSelectedPosition();
        BrowseSupportFragment browseSupportFragment = this.f5342b;
        browseSupportFragment.f4877j1.m90a(selectedPosition, 0, true);
        OnItemViewSelectedListener onItemViewSelectedListener = browseSupportFragment.f4869b1;
        if (onItemViewSelectedListener != null) {
            onItemViewSelectedListener.onItemSelected(viewHolder, obj, viewHolder2, row2);
        }
    }
}
