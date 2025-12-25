package p000;

import androidx.leanback.app.PlaybackSupportFragment;
import androidx.leanback.widget.FacetProvider;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.PlaybackSeekUi;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class o52 extends ItemBridgeAdapter.AdapterListener {

    /* renamed from: a */
    public final /* synthetic */ PlaybackSupportFragment f23610a;

    public o52(PlaybackSupportFragment playbackSupportFragment) {
        this.f23610a = playbackSupportFragment;
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
    public final void onAttachedToWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
        if (!this.f23610a.f5158I0) {
            viewHolder.getViewHolder().view.setAlpha(RecyclerView.f7068F0);
        }
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
    public final void onCreate(ItemBridgeAdapter.ViewHolder viewHolder) {
        FacetProvider viewHolder2 = viewHolder.getViewHolder();
        if (viewHolder2 instanceof PlaybackSeekUi) {
            ((PlaybackSeekUi) viewHolder2).setPlaybackSeekUiClient(this.f23610a.f5174Y0);
        }
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
    public final void onDetachedFromWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
        viewHolder.getViewHolder().view.setAlpha(1.0f);
        viewHolder.getViewHolder().view.setTranslationY(RecyclerView.f7068F0);
        viewHolder.getViewHolder().view.setAlpha(1.0f);
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
    public final void onBind(ItemBridgeAdapter.ViewHolder viewHolder) {
    }
}
