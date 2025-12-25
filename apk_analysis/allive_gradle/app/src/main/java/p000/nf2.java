package p000;

import androidx.leanback.app.SearchSupportFragment;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;

/* loaded from: classes.dex */
public final class nf2 implements OnItemViewSelectedListener {

    /* renamed from: a */
    public final /* synthetic */ SearchSupportFragment f23350a;

    public nf2(SearchSupportFragment searchSupportFragment) {
        this.f23350a = searchSupportFragment;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
    public final void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        Row row2 = row;
        SearchSupportFragment searchSupportFragment = this.f23350a;
        searchSupportFragment.m1352o();
        OnItemViewSelectedListener onItemViewSelectedListener = searchSupportFragment.f5274n0;
        if (onItemViewSelectedListener != null) {
            onItemViewSelectedListener.onItemSelected(viewHolder, obj, viewHolder2, row2);
        }
    }
}
