package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.Presenter;

/* renamed from: androidx.leanback.widget.i0 */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0345i0 implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ ItemBridgeAdapter.ViewHolder f6305a;

    /* renamed from: b */
    public final /* synthetic */ C0349j0 f6306b;

    public ViewOnClickListenerC0345i0(C0349j0 c0349j0, ItemBridgeAdapter.ViewHolder viewHolder) {
        this.f6306b = c0349j0;
        this.f6305a = viewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C0349j0 c0349j0 = this.f6306b;
        BaseOnItemViewClickedListener onItemViewClickedListener = c0349j0.f6310k.getOnItemViewClickedListener();
        ItemBridgeAdapter.ViewHolder viewHolder = this.f6305a;
        if (onItemViewClickedListener != null) {
            BaseOnItemViewClickedListener onItemViewClickedListener2 = c0349j0.f6310k.getOnItemViewClickedListener();
            Presenter.ViewHolder viewHolder2 = viewHolder.getViewHolder();
            Object item = viewHolder.getItem();
            FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder3 = c0349j0.f6310k;
            onItemViewClickedListener2.onItemClicked(viewHolder2, item, viewHolder3, viewHolder3.getRow());
        }
        OnActionClickedListener onActionClickedListener = c0349j0.f6311l.f5647g;
        if (onActionClickedListener != null) {
            onActionClickedListener.onActionClicked((Action) viewHolder.getItem());
        }
    }
}
