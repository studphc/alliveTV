package androidx.leanback.app;

import android.view.View;
import androidx.leanback.app.HeadersFragment;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowHeaderPresenter;
import p000.d01;

/* renamed from: androidx.leanback.app.o */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0281o implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ ItemBridgeAdapter.ViewHolder f5343a;

    /* renamed from: b */
    public final /* synthetic */ d01 f5344b;

    public ViewOnClickListenerC0281o(d01 d01Var, ItemBridgeAdapter.ViewHolder viewHolder) {
        this.f5344b = d01Var;
        this.f5343a = viewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        HeadersFragment.OnHeaderClickedListener onHeaderClickedListener = this.f5344b.f16193a.f5022j;
        if (onHeaderClickedListener != null) {
            ItemBridgeAdapter.ViewHolder viewHolder = this.f5343a;
            onHeaderClickedListener.onHeaderClicked((RowHeaderPresenter.ViewHolder) viewHolder.getViewHolder(), (Row) viewHolder.getItem());
        }
    }
}
