package p000;

import androidx.leanback.app.SearchFragment;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;

/* loaded from: classes.dex */
public final class gf2 implements OnItemViewSelectedListener {

    /* renamed from: a */
    public final /* synthetic */ SearchFragment f17680a;

    public gf2(SearchFragment searchFragment) {
        this.f17680a = searchFragment;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
    public final void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        Row row2 = row;
        SearchFragment searchFragment = this.f17680a;
        searchFragment.m1348d();
        OnItemViewSelectedListener onItemViewSelectedListener = searchFragment.f5248j;
        if (onItemViewSelectedListener != null) {
            onItemViewSelectedListener.onItemSelected(viewHolder, obj, viewHolder2, row2);
        }
    }
}
