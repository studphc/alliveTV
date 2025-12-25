package p000;

import android.view.View;
import androidx.leanback.app.HeadersSupportFragment;
import androidx.leanback.app.ViewOnClickListenerC0282p;
import androidx.leanback.widget.ItemBridgeAdapter;

/* loaded from: classes.dex */
public final class h01 extends ItemBridgeAdapter.AdapterListener {

    /* renamed from: a */
    public final /* synthetic */ HeadersSupportFragment f17905a;

    public h01(HeadersSupportFragment headersSupportFragment) {
        this.f17905a = headersSupportFragment;
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
    public final void onCreate(ItemBridgeAdapter.ViewHolder viewHolder) {
        View view = viewHolder.getViewHolder().view;
        view.setOnClickListener(new ViewOnClickListenerC0282p(this, viewHolder));
        if (this.f17905a.f5038t0 != null) {
            viewHolder.itemView.addOnLayoutChangeListener(HeadersSupportFragment.f5030v0);
        } else {
            view.addOnLayoutChangeListener(HeadersSupportFragment.f5030v0);
        }
    }
}
