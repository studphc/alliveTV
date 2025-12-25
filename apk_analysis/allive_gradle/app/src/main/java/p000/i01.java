package p000;

import android.view.View;
import android.widget.FrameLayout;
import androidx.leanback.widget.ItemBridgeAdapter;

/* loaded from: classes.dex */
public final class i01 extends ItemBridgeAdapter.Wrapper {
    @Override // androidx.leanback.widget.ItemBridgeAdapter.Wrapper
    public final View createWrapper(View view) {
        return new g01(view.getContext(), 1);
    }

    @Override // androidx.leanback.widget.ItemBridgeAdapter.Wrapper
    public final void wrap(View view, View view2) {
        ((FrameLayout) view).addView(view2);
    }
}
