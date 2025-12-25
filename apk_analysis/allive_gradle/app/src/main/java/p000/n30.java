package p000;

import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.BaseOnItemViewSelectedListener;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.VerticalGridView;

/* loaded from: classes.dex */
public final class n30 implements BaseOnItemViewSelectedListener {

    /* renamed from: a */
    public final /* synthetic */ DetailsSupportFragment f23210a;

    public n30(DetailsSupportFragment detailsSupportFragment) {
        this.f23210a = detailsSupportFragment;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
    public final void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Object obj2) {
        DetailsSupportFragment detailsSupportFragment = this.f23210a;
        int selectedPosition = detailsSupportFragment.f4955X0.getVerticalGridView().getSelectedPosition();
        int selectedSubPosition = detailsSupportFragment.f4955X0.getVerticalGridView().getSelectedSubPosition();
        ObjectAdapter adapter = detailsSupportFragment.getAdapter();
        RowsSupportFragment rowsSupportFragment = detailsSupportFragment.f4955X0;
        if (rowsSupportFragment != null && rowsSupportFragment.getView() != null && detailsSupportFragment.f4955X0.getView().hasFocus() && !detailsSupportFragment.f4961d1 && (adapter == null || adapter.size() == 0 || (detailsSupportFragment.getVerticalGridView().getSelectedPosition() == 0 && detailsSupportFragment.getVerticalGridView().getSelectedSubPosition() == 0))) {
            detailsSupportFragment.showTitle(true);
        } else {
            detailsSupportFragment.showTitle(false);
        }
        if (adapter != null && adapter.size() > selectedPosition) {
            VerticalGridView verticalGridView = detailsSupportFragment.getVerticalGridView();
            int childCount = verticalGridView.getChildCount();
            if (childCount > 0) {
                detailsSupportFragment.f4757A0.fireEvent(detailsSupportFragment.f4945N0);
            }
            for (int i = 0; i < childCount; i++) {
                ItemBridgeAdapter.ViewHolder viewHolder3 = (ItemBridgeAdapter.ViewHolder) verticalGridView.getChildViewHolder(verticalGridView.getChildAt(i));
                RowPresenter rowPresenter = (RowPresenter) viewHolder3.getPresenter();
                detailsSupportFragment.onSetRowStatus(rowPresenter, rowPresenter.getRowViewHolder(viewHolder3.getViewHolder()), viewHolder3.getAbsoluteAdapterPosition(), selectedPosition, selectedSubPosition);
            }
        }
        BaseOnItemViewSelectedListener baseOnItemViewSelectedListener = detailsSupportFragment.f4958a1;
        if (baseOnItemViewSelectedListener != null) {
            baseOnItemViewSelectedListener.onItemSelected(viewHolder, obj, viewHolder2, obj2);
        }
    }
}
