package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.ItemBridgeAdapter;

/* renamed from: androidx.leanback.widget.j0 */
/* loaded from: classes.dex */
public final class C0349j0 extends ItemBridgeAdapter {

    /* renamed from: k */
    public final FullWidthDetailsOverviewRowPresenter.ViewHolder f6310k;

    /* renamed from: l */
    public final /* synthetic */ FullWidthDetailsOverviewRowPresenter f6311l;

    public C0349j0(FullWidthDetailsOverviewRowPresenter fullWidthDetailsOverviewRowPresenter, FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder) {
        this.f6311l = fullWidthDetailsOverviewRowPresenter;
        this.f6310k = viewHolder;
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter
    public final void onAttachedToWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder2 = this.f6310k;
        view.removeOnLayoutChangeListener(viewHolder2.f5664w);
        viewHolder.itemView.addOnLayoutChangeListener(viewHolder2.f5664w);
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter
    public final void onBind(ItemBridgeAdapter.ViewHolder viewHolder) {
        if (this.f6310k.getOnItemViewClickedListener() != null || this.f6311l.f5647g != null) {
            viewHolder.getPresenter().setOnClickListener(viewHolder.getViewHolder(), new ViewOnClickListenerC0345i0(this, viewHolder));
        }
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter
    public final void onDetachedFromWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder2 = this.f6310k;
        view.removeOnLayoutChangeListener(viewHolder2.f5664w);
        viewHolder2.m1393a();
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter
    public final void onUnbind(ItemBridgeAdapter.ViewHolder viewHolder) {
        if (this.f6310k.getOnItemViewClickedListener() != null || this.f6311l.f5647g != null) {
            viewHolder.getPresenter().setOnClickListener(viewHolder.getViewHolder(), null);
        }
    }
}
