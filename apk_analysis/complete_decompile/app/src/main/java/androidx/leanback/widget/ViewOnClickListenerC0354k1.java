package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.Presenter;

/* renamed from: androidx.leanback.widget.k1 */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0354k1 implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ ItemBridgeAdapter.ViewHolder f6315a;

    /* renamed from: b */
    public final /* synthetic */ C0358l1 f6316b;

    public ViewOnClickListenerC0354k1(C0358l1 c0358l1, ItemBridgeAdapter.ViewHolder viewHolder) {
        this.f6316b = c0358l1;
        this.f6315a = viewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C0358l1 c0358l1 = this.f6316b;
        HorizontalGridView horizontalGridView = c0358l1.f6319k.f5904o;
        ItemBridgeAdapter.ViewHolder viewHolder = this.f6315a;
        ItemBridgeAdapter.ViewHolder viewHolder2 = (ItemBridgeAdapter.ViewHolder) horizontalGridView.getChildViewHolder(viewHolder.itemView);
        if (c0358l1.f6319k.getOnItemViewClickedListener() != null) {
            BaseOnItemViewClickedListener onItemViewClickedListener = c0358l1.f6319k.getOnItemViewClickedListener();
            Presenter.ViewHolder viewHolder3 = viewHolder.f5876u;
            Object obj = viewHolder2.f5877v;
            ListRowPresenter.ViewHolder viewHolder4 = c0358l1.f6319k;
            onItemViewClickedListener.onItemClicked(viewHolder3, obj, viewHolder4, (ListRow) viewHolder4.f6112d);
        }
    }
}
