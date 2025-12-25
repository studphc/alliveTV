package p000;

import android.app.Fragment;
import android.graphics.Rect;
import android.view.View;
import androidx.leanback.R;
import androidx.leanback.app.BrowseFragment;
import androidx.leanback.app.HeadersFragment;
import androidx.leanback.widget.BrowseFrameLayout;

/* renamed from: xh */
/* loaded from: classes.dex */
public final class C1983xh implements BrowseFrameLayout.OnChildFocusListener {

    /* renamed from: a */
    public final /* synthetic */ BrowseFragment f28557a;

    public C1983xh(BrowseFragment browseFragment) {
        this.f28557a = browseFragment;
    }

    @Override // androidx.leanback.widget.BrowseFrameLayout.OnChildFocusListener
    public final void onRequestChildFocus(View view, View view2) {
        BrowseFragment browseFragment = this.f28557a;
        if (!browseFragment.getChildFragmentManager().isDestroyed() && browseFragment.f4812T && !browseFragment.isInHeadersTransition()) {
            int id = view.getId();
            if (id == R.id.browse_container_dock && browseFragment.f4811S) {
                browseFragment.m1272l(false);
            } else if (id == R.id.browse_headers_dock && !browseFragment.f4811S) {
                browseFragment.m1272l(true);
            }
        }
    }

    @Override // androidx.leanback.widget.BrowseFrameLayout.OnChildFocusListener
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        HeadersFragment headersFragment;
        BrowseFragment browseFragment = this.f28557a;
        if (browseFragment.getChildFragmentManager().isDestroyed()) {
            return true;
        }
        if (browseFragment.f4812T && browseFragment.f4811S && (headersFragment = browseFragment.f4799G) != null && headersFragment.getView() != null && browseFragment.f4799G.getView().requestFocus(i, rect)) {
            return true;
        }
        Fragment fragment = browseFragment.f4798F;
        if (fragment != null && fragment.getView() != null && browseFragment.f4798F.getView().requestFocus(i, rect)) {
            return true;
        }
        if (browseFragment.getTitleView() != null && browseFragment.getTitleView().requestFocus(i, rect)) {
            return true;
        }
        return false;
    }
}
