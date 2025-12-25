package p000;

import androidx.leanback.app.RowsFragment;
import androidx.leanback.widget.HorizontalGridView;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class xc2 extends ItemBridgeAdapter.AdapterListener {

    /* renamed from: a */
    public final /* synthetic */ RowsFragment f28510a;

    public xc2(RowsFragment rowsFragment) {
        this.f28510a = rowsFragment;
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
    public final void onAddPresenter(Presenter presenter, int i) {
        ItemBridgeAdapter.AdapterListener adapterListener = this.f28510a.f5220v;
        if (adapterListener != null) {
            adapterListener.onAddPresenter(presenter, i);
        }
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
    public final void onAttachedToWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
        RowsFragment rowsFragment = this.f28510a;
        ((RowPresenter) viewHolder.getPresenter()).setRowViewExpanded(viewHolder.getViewHolder(), rowsFragment.f5211m);
        RowPresenter rowPresenter = (RowPresenter) viewHolder.getPresenter();
        RowPresenter.ViewHolder rowViewHolder = rowPresenter.getRowViewHolder(viewHolder.getViewHolder());
        rowPresenter.setEntranceTransitionState(rowViewHolder, rowsFragment.f5214p);
        rowViewHolder.setOnItemViewSelectedListener(rowsFragment.f5216r);
        rowViewHolder.setOnItemViewClickedListener(rowsFragment.f5217s);
        rowPresenter.freeze(rowViewHolder, rowsFragment.f5215q);
        ItemBridgeAdapter.AdapterListener adapterListener = rowsFragment.f5220v;
        if (adapterListener != null) {
            adapterListener.onAttachedToWindow(viewHolder);
        }
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
    public final void onBind(ItemBridgeAdapter.ViewHolder viewHolder) {
        ItemBridgeAdapter.AdapterListener adapterListener = this.f28510a.f5220v;
        if (adapterListener != null) {
            adapterListener.onBind(viewHolder);
        }
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
    public final void onCreate(ItemBridgeAdapter.ViewHolder viewHolder) {
        RowsFragment rowsFragment = this.f28510a;
        VerticalGridView verticalGridView = rowsFragment.getVerticalGridView();
        if (verticalGridView != null) {
            verticalGridView.setClipChildren(false);
        }
        RowPresenter.ViewHolder rowViewHolder = ((RowPresenter) viewHolder.getPresenter()).getRowViewHolder(viewHolder.getViewHolder());
        if (rowViewHolder instanceof ListRowPresenter.ViewHolder) {
            ListRowPresenter.ViewHolder viewHolder2 = (ListRowPresenter.ViewHolder) rowViewHolder;
            HorizontalGridView gridView = viewHolder2.getGridView();
            RecyclerView.RecycledViewPool recycledViewPool = rowsFragment.f5218t;
            if (recycledViewPool == null) {
                rowsFragment.f5218t = gridView.getRecycledViewPool();
            } else {
                gridView.setRecycledViewPool(recycledViewPool);
            }
            ItemBridgeAdapter bridgeAdapter = viewHolder2.getBridgeAdapter();
            ArrayList<Presenter> arrayList = rowsFragment.f5219u;
            if (arrayList == null) {
                rowsFragment.f5219u = bridgeAdapter.getPresenterMapper();
            } else {
                bridgeAdapter.setPresenterMapper(arrayList);
            }
        }
        rowsFragment.f5212n = true;
        viewHolder.setExtraObject(new ad2(viewHolder));
        RowsFragment.m1340g(viewHolder, false, true);
        ItemBridgeAdapter.AdapterListener adapterListener = rowsFragment.f5220v;
        if (adapterListener != null) {
            adapterListener.onCreate(viewHolder);
        }
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
    public final void onDetachedFromWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
        RowsFragment rowsFragment = this.f28510a;
        ItemBridgeAdapter.ViewHolder viewHolder2 = rowsFragment.f5209k;
        if (viewHolder2 == viewHolder) {
            RowsFragment.m1340g(viewHolder2, false, true);
            rowsFragment.f5209k = null;
        }
        RowPresenter.ViewHolder rowViewHolder = ((RowPresenter) viewHolder.getPresenter()).getRowViewHolder(viewHolder.getViewHolder());
        rowViewHolder.setOnItemViewSelectedListener(null);
        rowViewHolder.setOnItemViewClickedListener(null);
        ItemBridgeAdapter.AdapterListener adapterListener = rowsFragment.f5220v;
        if (adapterListener != null) {
            adapterListener.onDetachedFromWindow(viewHolder);
        }
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
    public final void onUnbind(ItemBridgeAdapter.ViewHolder viewHolder) {
        RowsFragment.m1340g(viewHolder, false, true);
        ItemBridgeAdapter.AdapterListener adapterListener = this.f28510a.f5220v;
        if (adapterListener != null) {
            adapterListener.onUnbind(viewHolder);
        }
    }
}
