package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.ListRowPresenter;

/* renamed from: androidx.leanback.widget.l1 */
/* loaded from: classes.dex */
public final class C0358l1 extends ItemBridgeAdapter {

    /* renamed from: k */
    public final ListRowPresenter.ViewHolder f6319k;

    /* renamed from: l */
    public final /* synthetic */ ListRowPresenter f6320l;

    public C0358l1(ListRowPresenter listRowPresenter, ListRowPresenter.ViewHolder viewHolder) {
        this.f6320l = listRowPresenter;
        this.f6319k = viewHolder;
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter
    public final void onAddPresenter(Presenter presenter, int i) {
        this.f6319k.getGridView().getRecycledViewPool().setMaxRecycledViews(i, this.f6320l.getRecycledPoolSize(presenter));
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter
    public final void onAttachedToWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        ListRowPresenter listRowPresenter = this.f6320l;
        ListRowPresenter.ViewHolder viewHolder2 = this.f6319k;
        listRowPresenter.applySelectLevelToChild(viewHolder2, view);
        viewHolder2.syncActivatedStatus(viewHolder.itemView);
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter
    public final void onBind(ItemBridgeAdapter.ViewHolder viewHolder) {
        if (this.f6319k.getOnItemViewClickedListener() != null) {
            viewHolder.f5876u.view.setOnClickListener(new ViewOnClickListenerC0354k1(this, viewHolder));
        }
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter
    public final void onCreate(ItemBridgeAdapter.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        if (view instanceof ViewGroup) {
            TransitionHelper.setTransitionGroup((ViewGroup) view, true);
        }
        ShadowOverlayHelper shadowOverlayHelper = this.f6320l.f5898p;
        if (shadowOverlayHelper != null) {
            shadowOverlayHelper.onViewCreated(viewHolder.itemView);
        }
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter
    public final void onUnbind(ItemBridgeAdapter.ViewHolder viewHolder) {
        if (this.f6319k.getOnItemViewClickedListener() != null) {
            viewHolder.f5876u.view.setOnClickListener(null);
        }
    }
}
