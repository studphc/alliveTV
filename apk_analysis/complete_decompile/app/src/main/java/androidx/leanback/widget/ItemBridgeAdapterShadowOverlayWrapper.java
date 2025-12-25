package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.ItemBridgeAdapter;

/* loaded from: classes.dex */
public class ItemBridgeAdapterShadowOverlayWrapper extends ItemBridgeAdapter.Wrapper {

    /* renamed from: a */
    public final ShadowOverlayHelper f5879a;

    public ItemBridgeAdapterShadowOverlayWrapper(ShadowOverlayHelper shadowOverlayHelper) {
        this.f5879a = shadowOverlayHelper;
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.Wrapper
    public View createWrapper(View view) {
        return this.f5879a.createShadowOverlayContainer(view.getContext());
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.Wrapper
    public void wrap(View view, View view2) {
        ((ShadowOverlayContainer) view).wrap(view2);
    }
}
