package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.leanback.widget.m0 */
/* loaded from: classes.dex */
public final class C0361m0 implements OnChildSelectedListener {

    /* renamed from: a */
    public final /* synthetic */ FullWidthDetailsOverviewRowPresenter.ViewHolder f6323a;

    public C0361m0(FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder) {
        this.f6323a = viewHolder;
    }

    @Override // androidx.leanback.widget.OnChildSelectedListener
    public final void onChildSelected(ViewGroup viewGroup, View view, int i, long j) {
        RecyclerView.ViewHolder findViewHolderForPosition;
        FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder = this.f6323a;
        if (viewHolder.isSelected()) {
            HorizontalGridView horizontalGridView = viewHolder.f5657p;
            if (view != null) {
                findViewHolderForPosition = horizontalGridView.getChildViewHolder(view);
            } else {
                findViewHolderForPosition = horizontalGridView.findViewHolderForPosition(horizontalGridView.getSelectedPosition());
            }
            ItemBridgeAdapter.ViewHolder viewHolder2 = (ItemBridgeAdapter.ViewHolder) findViewHolderForPosition;
            if (viewHolder2 == null) {
                if (viewHolder.getOnItemViewSelectedListener() != null) {
                    viewHolder.getOnItemViewSelectedListener().onItemSelected(null, null, viewHolder, viewHolder.getRow());
                }
            } else if (viewHolder.getOnItemViewSelectedListener() != null) {
                viewHolder.getOnItemViewSelectedListener().onItemSelected(viewHolder2.getViewHolder(), viewHolder2.getItem(), viewHolder, viewHolder.getRow());
            }
        }
    }
}
