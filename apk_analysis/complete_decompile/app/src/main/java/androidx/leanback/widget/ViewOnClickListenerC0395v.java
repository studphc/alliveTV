package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.DetailsOverviewRowPresenter;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.Presenter;

/* renamed from: androidx.leanback.widget.v */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0395v implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ ItemBridgeAdapter.ViewHolder f6422a;

    /* renamed from: b */
    public final /* synthetic */ C0399w f6423b;

    public ViewOnClickListenerC0395v(C0399w c0399w, ItemBridgeAdapter.ViewHolder viewHolder) {
        this.f6423b = c0399w;
        this.f6422a = viewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C0399w c0399w = this.f6423b;
        BaseOnItemViewClickedListener onItemViewClickedListener = c0399w.f6430k.getOnItemViewClickedListener();
        ItemBridgeAdapter.ViewHolder viewHolder = this.f6422a;
        if (onItemViewClickedListener != null) {
            BaseOnItemViewClickedListener onItemViewClickedListener2 = c0399w.f6430k.getOnItemViewClickedListener();
            Presenter.ViewHolder viewHolder2 = viewHolder.getViewHolder();
            Object item = viewHolder.getItem();
            DetailsOverviewRowPresenter.ViewHolder viewHolder3 = c0399w.f6430k;
            onItemViewClickedListener2.onItemClicked(viewHolder2, item, viewHolder3, viewHolder3.getRow());
        }
        OnActionClickedListener onActionClickedListener = c0399w.f6431l.f5620f;
        if (onActionClickedListener != null) {
            onActionClickedListener.onActionClicked((Action) viewHolder.getItem());
        }
    }
}
