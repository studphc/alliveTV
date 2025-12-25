package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.VerticalGridPresenter;

/* renamed from: androidx.leanback.widget.y2 */
/* loaded from: classes.dex */
public final class C0410y2 implements OnChildSelectedListener {

    /* renamed from: a */
    public final /* synthetic */ VerticalGridPresenter.ViewHolder f6442a;

    /* renamed from: b */
    public final /* synthetic */ VerticalGridPresenter f6443b;

    public C0410y2(VerticalGridPresenter verticalGridPresenter, VerticalGridPresenter.ViewHolder viewHolder) {
        this.f6443b = verticalGridPresenter;
        this.f6442a = viewHolder;
    }

    @Override // androidx.leanback.widget.OnChildSelectedListener
    public final void onChildSelected(ViewGroup viewGroup, View view, int i, long j) {
        ItemBridgeAdapter.ViewHolder viewHolder;
        VerticalGridPresenter verticalGridPresenter = this.f6443b;
        if (verticalGridPresenter.getOnItemViewSelectedListener() != null) {
            if (view == null) {
                viewHolder = null;
            } else {
                viewHolder = (ItemBridgeAdapter.ViewHolder) this.f6442a.getGridView().getChildViewHolder(view);
            }
            if (viewHolder == null) {
                verticalGridPresenter.getOnItemViewSelectedListener().onItemSelected(null, null, null, null);
            } else {
                verticalGridPresenter.getOnItemViewSelectedListener().onItemSelected(viewHolder.f5876u, viewHolder.f5877v, null, null);
            }
        }
    }
}
