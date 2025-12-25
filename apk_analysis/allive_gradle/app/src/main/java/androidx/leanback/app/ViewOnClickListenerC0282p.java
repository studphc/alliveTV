package androidx.leanback.app;

import android.view.View;
import androidx.leanback.app.HeadersSupportFragment;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowHeaderPresenter;
import p000.h01;

/* renamed from: androidx.leanback.app.p */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0282p implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ ItemBridgeAdapter.ViewHolder f5345a;

    /* renamed from: b */
    public final /* synthetic */ h01 f5346b;

    public ViewOnClickListenerC0282p(h01 h01Var, ItemBridgeAdapter.ViewHolder viewHolder) {
        this.f5346b = h01Var;
        this.f5345a = viewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        HeadersSupportFragment.OnHeaderClickedListener onHeaderClickedListener = this.f5346b.f17905a.f5032n0;
        if (onHeaderClickedListener != null) {
            ItemBridgeAdapter.ViewHolder viewHolder = this.f5345a;
            onHeaderClickedListener.onHeaderClicked((RowHeaderPresenter.ViewHolder) viewHolder.getViewHolder(), (Row) viewHolder.getItem());
        }
    }
}
