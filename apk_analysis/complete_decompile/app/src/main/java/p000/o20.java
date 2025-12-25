package p000;

import android.graphics.Rect;
import android.view.View;
import androidx.leanback.R;
import androidx.leanback.app.DetailsFragment;
import androidx.leanback.widget.BrowseFrameLayout;

/* loaded from: classes.dex */
public final class o20 implements BrowseFrameLayout.OnChildFocusListener {

    /* renamed from: a */
    public final /* synthetic */ DetailsFragment f23573a;

    public o20(DetailsFragment detailsFragment) {
        this.f23573a = detailsFragment;
    }

    @Override // androidx.leanback.widget.BrowseFrameLayout.OnChildFocusListener
    public final void onRequestChildFocus(View view, View view2) {
        DetailsFragment detailsFragment = this.f23573a;
        if (view != detailsFragment.f4909O.getFocusedChild()) {
            if (view.getId() == R.id.details_fragment_root) {
                if (!detailsFragment.f4920Z) {
                    if (detailsFragment.m1287c() != null) {
                        detailsFragment.m1287c().animateIn();
                    }
                    detailsFragment.showTitle(true);
                    return;
                }
                return;
            }
            if (view.getId() == R.id.video_surface_container) {
                if (detailsFragment.m1287c() != null) {
                    detailsFragment.m1287c().animateOut();
                }
                detailsFragment.showTitle(false);
                return;
            }
            detailsFragment.showTitle(true);
        }
    }

    @Override // androidx.leanback.widget.BrowseFrameLayout.OnChildFocusListener
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        return false;
    }
}
