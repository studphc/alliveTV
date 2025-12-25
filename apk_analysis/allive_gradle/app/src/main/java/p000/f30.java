package p000;

import android.graphics.Rect;
import android.view.View;
import androidx.leanback.R;
import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.widget.BrowseFrameLayout;

/* loaded from: classes.dex */
public final class f30 implements BrowseFrameLayout.OnChildFocusListener {

    /* renamed from: a */
    public final /* synthetic */ DetailsSupportFragment f17114a;

    public f30(DetailsSupportFragment detailsSupportFragment) {
        this.f17114a = detailsSupportFragment;
    }

    @Override // androidx.leanback.widget.BrowseFrameLayout.OnChildFocusListener
    public final void onRequestChildFocus(View view, View view2) {
        DetailsSupportFragment detailsSupportFragment = this.f17114a;
        if (view != detailsSupportFragment.f4950S0.getFocusedChild()) {
            if (view.getId() == R.id.details_fragment_root) {
                if (!detailsSupportFragment.f4961d1) {
                    if (detailsSupportFragment.getVerticalGridView() != null) {
                        detailsSupportFragment.getVerticalGridView().animateIn();
                    }
                    detailsSupportFragment.showTitle(true);
                    return;
                }
                return;
            }
            if (view.getId() == R.id.video_surface_container) {
                if (detailsSupportFragment.getVerticalGridView() != null) {
                    detailsSupportFragment.getVerticalGridView().animateOut();
                }
                detailsSupportFragment.showTitle(false);
                return;
            }
            detailsSupportFragment.showTitle(true);
        }
    }

    @Override // androidx.leanback.widget.BrowseFrameLayout.OnChildFocusListener
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        return false;
    }
}
