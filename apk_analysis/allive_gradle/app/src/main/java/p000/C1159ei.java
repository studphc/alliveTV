package p000;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.leanback.R;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.app.HeadersSupportFragment;
import androidx.leanback.widget.BrowseFrameLayout;

/* renamed from: ei */
/* loaded from: classes.dex */
public final class C1159ei implements BrowseFrameLayout.OnChildFocusListener {

    /* renamed from: a */
    public final /* synthetic */ BrowseSupportFragment f16829a;

    public C1159ei(BrowseSupportFragment browseSupportFragment) {
        this.f16829a = browseSupportFragment;
    }

    @Override // androidx.leanback.widget.BrowseFrameLayout.OnChildFocusListener
    public final void onRequestChildFocus(View view, View view2) {
        BrowseSupportFragment browseSupportFragment = this.f16829a;
        if (!browseSupportFragment.getChildFragmentManager().isDestroyed() && browseSupportFragment.f4865X0 && !browseSupportFragment.isInHeadersTransition()) {
            int id = view.getId();
            if (id == R.id.browse_container_dock && browseSupportFragment.f4864W0) {
                browseSupportFragment.m1284w(false);
            } else if (id == R.id.browse_headers_dock && !browseSupportFragment.f4864W0) {
                browseSupportFragment.m1284w(true);
            }
        }
    }

    @Override // androidx.leanback.widget.BrowseFrameLayout.OnChildFocusListener
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        HeadersSupportFragment headersSupportFragment;
        BrowseSupportFragment browseSupportFragment = this.f16829a;
        if (browseSupportFragment.getChildFragmentManager().isDestroyed()) {
            return true;
        }
        if (browseSupportFragment.f4865X0 && browseSupportFragment.f4864W0 && (headersSupportFragment = browseSupportFragment.f4852K0) != null && headersSupportFragment.getView() != null && browseSupportFragment.f4852K0.getView().requestFocus(i, rect)) {
            return true;
        }
        Fragment fragment = browseSupportFragment.f4851J0;
        if (fragment != null && fragment.getView() != null && browseSupportFragment.f4851J0.getView().requestFocus(i, rect)) {
            return true;
        }
        if (browseSupportFragment.getTitleView() != null && browseSupportFragment.getTitleView().requestFocus(i, rect)) {
            return true;
        }
        return false;
    }
}
