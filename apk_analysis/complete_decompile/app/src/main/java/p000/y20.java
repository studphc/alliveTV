package p000;

import androidx.leanback.R;
import androidx.leanback.app.DetailsFragment;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.ItemBridgeAdapter;

/* loaded from: classes.dex */
public final class y20 extends ItemBridgeAdapter.AdapterListener {

    /* renamed from: a */
    public final /* synthetic */ DetailsFragment f28805a;

    public y20(DetailsFragment detailsFragment) {
        this.f28805a = detailsFragment;
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
    public final void onCreate(ItemBridgeAdapter.ViewHolder viewHolder) {
        DetailsFragment detailsFragment = this.f28805a;
        if (detailsFragment.f4913S != null && (viewHolder.getViewHolder() instanceof FullWidthDetailsOverviewRowPresenter.ViewHolder)) {
            ((FullWidthDetailsOverviewRowPresenter.ViewHolder) viewHolder.getViewHolder()).getOverviewView().setTag(R.id.lb_parallax_source, detailsFragment.f4913S);
        }
    }
}
