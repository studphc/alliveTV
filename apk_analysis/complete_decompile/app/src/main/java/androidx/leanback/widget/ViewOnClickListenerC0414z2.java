package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.ItemBridgeAdapter;

/* renamed from: androidx.leanback.widget.z2 */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0414z2 implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ ItemBridgeAdapter.ViewHolder f6461a;

    /* renamed from: b */
    public final /* synthetic */ C0315a3 f6462b;

    public ViewOnClickListenerC0414z2(C0315a3 c0315a3, ItemBridgeAdapter.ViewHolder viewHolder) {
        this.f6462b = c0315a3;
        this.f6461a = viewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C0315a3 c0315a3 = this.f6462b;
        if (c0315a3.f6268k.getOnItemViewClickedListener() != null) {
            OnItemViewClickedListener onItemViewClickedListener = c0315a3.f6268k.getOnItemViewClickedListener();
            ItemBridgeAdapter.ViewHolder viewHolder = this.f6461a;
            onItemViewClickedListener.onItemClicked(viewHolder.f5876u, viewHolder.f5877v, null, null);
        }
    }
}
