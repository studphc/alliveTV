package p000;

import androidx.leanback.R;
import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.ItemBridgeAdapter;

/* loaded from: classes.dex */
public final class o30 extends ItemBridgeAdapter.AdapterListener {

    /* renamed from: a */
    public final /* synthetic */ DetailsSupportFragment f23582a;

    public o30(DetailsSupportFragment detailsSupportFragment) {
        this.f23582a = detailsSupportFragment;
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
    public final void onCreate(ItemBridgeAdapter.ViewHolder viewHolder) {
        DetailsSupportFragment detailsSupportFragment = this.f23582a;
        if (detailsSupportFragment.f4954W0 != null && (viewHolder.getViewHolder() instanceof FullWidthDetailsOverviewRowPresenter.ViewHolder)) {
            ((FullWidthDetailsOverviewRowPresenter.ViewHolder) viewHolder.getViewHolder()).getOverviewView().setTag(R.id.lb_parallax_source, detailsSupportFragment.f4954W0);
        }
    }
}
