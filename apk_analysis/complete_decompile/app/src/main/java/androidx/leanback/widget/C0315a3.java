package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.widget.ItemBridgeAdapter;

/* renamed from: androidx.leanback.widget.a3 */
/* loaded from: classes.dex */
public final class C0315a3 extends ItemBridgeAdapter {

    /* renamed from: k */
    public final /* synthetic */ VerticalGridPresenter f6268k;

    public C0315a3(VerticalGridPresenter verticalGridPresenter) {
        this.f6268k = verticalGridPresenter;
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter
    public final void onAttachedToWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
        viewHolder.itemView.setActivated(true);
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter
    public final void onBind(ItemBridgeAdapter.ViewHolder viewHolder) {
        if (this.f6268k.getOnItemViewClickedListener() != null) {
            viewHolder.f5876u.view.setOnClickListener(new ViewOnClickListenerC0414z2(this, viewHolder));
        }
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter
    public final void onCreate(ItemBridgeAdapter.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        if (view instanceof ViewGroup) {
            TransitionHelper.setTransitionGroup((ViewGroup) view, true);
        }
        ShadowOverlayHelper shadowOverlayHelper = this.f6268k.f6257j;
        if (shadowOverlayHelper != null) {
            shadowOverlayHelper.onViewCreated(viewHolder.itemView);
        }
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter
    public final void onUnbind(ItemBridgeAdapter.ViewHolder viewHolder) {
        if (this.f6268k.getOnItemViewClickedListener() != null) {
            viewHolder.f5876u.view.setOnClickListener(null);
        }
    }
}
