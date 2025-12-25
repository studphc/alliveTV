package p000;

import androidx.leanback.app.DetailsFragment;
import androidx.leanback.app.RowsFragment;
import androidx.leanback.widget.BaseOnItemViewSelectedListener;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.VerticalGridView;

/* loaded from: classes.dex */
public final class x20 implements BaseOnItemViewSelectedListener {

    /* renamed from: a */
    public final /* synthetic */ DetailsFragment f28426a;

    public x20(DetailsFragment detailsFragment) {
        this.f28426a = detailsFragment;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
    public final void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Object obj2) {
        DetailsFragment detailsFragment = this.f28426a;
        int selectedPosition = detailsFragment.f4914T.getVerticalGridView().getSelectedPosition();
        int selectedSubPosition = detailsFragment.f4914T.getVerticalGridView().getSelectedSubPosition();
        ObjectAdapter adapter = detailsFragment.getAdapter();
        RowsFragment rowsFragment = detailsFragment.f4914T;
        if (rowsFragment != null && rowsFragment.getView() != null && detailsFragment.f4914T.getView().hasFocus() && !detailsFragment.f4920Z && (adapter == null || adapter.size() == 0 || (detailsFragment.m1287c().getSelectedPosition() == 0 && detailsFragment.m1287c().getSelectedSubPosition() == 0))) {
            detailsFragment.showTitle(true);
        } else {
            detailsFragment.showTitle(false);
        }
        if (adapter != null && adapter.size() > selectedPosition) {
            VerticalGridView m1287c = detailsFragment.m1287c();
            int childCount = m1287c.getChildCount();
            if (childCount > 0) {
                detailsFragment.f4754w.fireEvent(detailsFragment.f4904J);
            }
            for (int i = 0; i < childCount; i++) {
                ItemBridgeAdapter.ViewHolder viewHolder3 = (ItemBridgeAdapter.ViewHolder) m1287c.getChildViewHolder(m1287c.getChildAt(i));
                RowPresenter rowPresenter = (RowPresenter) viewHolder3.getPresenter();
                detailsFragment.onSetRowStatus(rowPresenter, rowPresenter.getRowViewHolder(viewHolder3.getViewHolder()), viewHolder3.getAbsoluteAdapterPosition(), selectedPosition, selectedSubPosition);
            }
        }
        BaseOnItemViewSelectedListener baseOnItemViewSelectedListener = detailsFragment.f4917W;
        if (baseOnItemViewSelectedListener != null) {
            baseOnItemViewSelectedListener.onItemSelected(viewHolder, obj, viewHolder2, obj2);
        }
    }
}
