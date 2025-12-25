package p000;

import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.HorizontalGridView;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class bd2 extends ItemBridgeAdapter.AdapterListener {

    /* renamed from: a */
    public final /* synthetic */ RowsSupportFragment f7972a;

    public bd2(RowsSupportFragment rowsSupportFragment) {
        this.f7972a = rowsSupportFragment;
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
    public final void onAddPresenter(Presenter presenter, int i) {
        ItemBridgeAdapter.AdapterListener adapterListener = this.f7972a.f5236z0;
        if (adapterListener != null) {
            adapterListener.onAddPresenter(presenter, i);
        }
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
    public final void onAttachedToWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
        RowsSupportFragment rowsSupportFragment = this.f7972a;
        ((RowPresenter) viewHolder.getPresenter()).setRowViewExpanded(viewHolder.getViewHolder(), rowsSupportFragment.f5227q0);
        RowPresenter rowPresenter = (RowPresenter) viewHolder.getPresenter();
        RowPresenter.ViewHolder rowViewHolder = rowPresenter.getRowViewHolder(viewHolder.getViewHolder());
        rowPresenter.setEntranceTransitionState(rowViewHolder, rowsSupportFragment.f5230t0);
        rowViewHolder.setOnItemViewSelectedListener(rowsSupportFragment.f5232v0);
        rowViewHolder.setOnItemViewClickedListener(rowsSupportFragment.f5233w0);
        rowPresenter.freeze(rowViewHolder, rowsSupportFragment.f5231u0);
        ItemBridgeAdapter.AdapterListener adapterListener = rowsSupportFragment.f5236z0;
        if (adapterListener != null) {
            adapterListener.onAttachedToWindow(viewHolder);
        }
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
    public final void onBind(ItemBridgeAdapter.ViewHolder viewHolder) {
        ItemBridgeAdapter.AdapterListener adapterListener = this.f7972a.f5236z0;
        if (adapterListener != null) {
            adapterListener.onBind(viewHolder);
        }
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
    public final void onCreate(ItemBridgeAdapter.ViewHolder viewHolder) {
        RowsSupportFragment rowsSupportFragment = this.f7972a;
        VerticalGridView verticalGridView = rowsSupportFragment.getVerticalGridView();
        if (verticalGridView != null) {
            verticalGridView.setClipChildren(false);
        }
        RowPresenter.ViewHolder rowViewHolder = ((RowPresenter) viewHolder.getPresenter()).getRowViewHolder(viewHolder.getViewHolder());
        if (rowViewHolder instanceof ListRowPresenter.ViewHolder) {
            ListRowPresenter.ViewHolder viewHolder2 = (ListRowPresenter.ViewHolder) rowViewHolder;
            HorizontalGridView gridView = viewHolder2.getGridView();
            RecyclerView.RecycledViewPool recycledViewPool = rowsSupportFragment.f5234x0;
            if (recycledViewPool == null) {
                rowsSupportFragment.f5234x0 = gridView.getRecycledViewPool();
            } else {
                gridView.setRecycledViewPool(recycledViewPool);
            }
            ItemBridgeAdapter bridgeAdapter = viewHolder2.getBridgeAdapter();
            ArrayList<Presenter> arrayList = rowsSupportFragment.f5235y0;
            if (arrayList == null) {
                rowsSupportFragment.f5235y0 = bridgeAdapter.getPresenterMapper();
            } else {
                bridgeAdapter.setPresenterMapper(arrayList);
            }
        }
        rowsSupportFragment.f5228r0 = true;
        viewHolder.setExtraObject(new ed2(viewHolder));
        RowsSupportFragment.m1343r(viewHolder, false, true);
        ItemBridgeAdapter.AdapterListener adapterListener = rowsSupportFragment.f5236z0;
        if (adapterListener != null) {
            adapterListener.onCreate(viewHolder);
        }
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
    public final void onDetachedFromWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
        RowsSupportFragment rowsSupportFragment = this.f7972a;
        ItemBridgeAdapter.ViewHolder viewHolder2 = rowsSupportFragment.f5225o0;
        if (viewHolder2 == viewHolder) {
            RowsSupportFragment.m1343r(viewHolder2, false, true);
            rowsSupportFragment.f5225o0 = null;
        }
        RowPresenter.ViewHolder rowViewHolder = ((RowPresenter) viewHolder.getPresenter()).getRowViewHolder(viewHolder.getViewHolder());
        rowViewHolder.setOnItemViewSelectedListener(null);
        rowViewHolder.setOnItemViewClickedListener(null);
        ItemBridgeAdapter.AdapterListener adapterListener = rowsSupportFragment.f5236z0;
        if (adapterListener != null) {
            adapterListener.onDetachedFromWindow(viewHolder);
        }
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
    public final void onUnbind(ItemBridgeAdapter.ViewHolder viewHolder) {
        RowsSupportFragment.m1343r(viewHolder, false, true);
        ItemBridgeAdapter.AdapterListener adapterListener = this.f7972a.f5236z0;
        if (adapterListener != null) {
            adapterListener.onUnbind(viewHolder);
        }
    }
}
