package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.DetailsOverviewRowPresenter;
import androidx.leanback.widget.ItemBridgeAdapter;

/* renamed from: androidx.leanback.widget.w */
/* loaded from: classes.dex */
public final class C0399w extends ItemBridgeAdapter {

    /* renamed from: k */
    public final DetailsOverviewRowPresenter.ViewHolder f6430k;

    /* renamed from: l */
    public final /* synthetic */ DetailsOverviewRowPresenter f6431l;

    public C0399w(DetailsOverviewRowPresenter detailsOverviewRowPresenter, DetailsOverviewRowPresenter.ViewHolder viewHolder) {
        this.f6431l = detailsOverviewRowPresenter;
        this.f6430k = viewHolder;
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter
    public final void onAttachedToWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        DetailsOverviewRowPresenter.ViewHolder viewHolder2 = this.f6430k;
        view.removeOnLayoutChangeListener(viewHolder2.f5625A);
        viewHolder.itemView.addOnLayoutChangeListener(viewHolder2.f5625A);
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter
    public final void onBind(ItemBridgeAdapter.ViewHolder viewHolder) {
        if (this.f6430k.getOnItemViewClickedListener() != null || this.f6431l.f5620f != null) {
            viewHolder.getPresenter().setOnClickListener(viewHolder.getViewHolder(), new ViewOnClickListenerC0395v(this, viewHolder));
        }
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter
    public final void onDetachedFromWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        DetailsOverviewRowPresenter.ViewHolder viewHolder2 = this.f6430k;
        view.removeOnLayoutChangeListener(viewHolder2.f5625A);
        viewHolder2.m1390b();
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter
    public final void onUnbind(ItemBridgeAdapter.ViewHolder viewHolder) {
        if (this.f6430k.getOnItemViewClickedListener() != null || this.f6431l.f5620f != null) {
            viewHolder.getPresenter().setOnClickListener(viewHolder.getViewHolder(), null);
        }
    }
}
