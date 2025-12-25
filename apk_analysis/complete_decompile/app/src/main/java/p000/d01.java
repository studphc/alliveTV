package p000;

import android.view.View;
import androidx.leanback.app.HeadersFragment;
import androidx.leanback.app.ViewOnClickListenerC0281o;
import androidx.leanback.widget.ItemBridgeAdapter;

/* loaded from: classes.dex */
public final class d01 extends ItemBridgeAdapter.AdapterListener {

    /* renamed from: a */
    public final /* synthetic */ HeadersFragment f16193a;

    public d01(HeadersFragment headersFragment) {
        this.f16193a = headersFragment;
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
    public final void onCreate(ItemBridgeAdapter.ViewHolder viewHolder) {
        View view = viewHolder.getViewHolder().view;
        view.setOnClickListener(new ViewOnClickListenerC0281o(this, viewHolder));
        if (this.f16193a.f5028p != null) {
            viewHolder.itemView.addOnLayoutChangeListener(HeadersFragment.f5020r);
        } else {
            view.addOnLayoutChangeListener(HeadersFragment.f5020r);
        }
    }
}
