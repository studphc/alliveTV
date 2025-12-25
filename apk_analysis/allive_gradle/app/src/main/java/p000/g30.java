package p000;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.app.DetailsSupportFragmentBackgroundController;
import androidx.leanback.widget.BrowseFrameLayout;

/* loaded from: classes.dex */
public final class g30 implements BrowseFrameLayout.OnFocusSearchListener {

    /* renamed from: a */
    public final /* synthetic */ DetailsSupportFragment f17537a;

    public g30(DetailsSupportFragment detailsSupportFragment) {
        this.f17537a = detailsSupportFragment;
    }

    @Override // androidx.leanback.widget.BrowseFrameLayout.OnFocusSearchListener
    public final View onFocusSearch(View view, int i) {
        Fragment fragment;
        DetailsSupportFragment detailsSupportFragment = this.f17537a;
        if (detailsSupportFragment.f4955X0.getVerticalGridView() != null && detailsSupportFragment.f4955X0.getVerticalGridView().hasFocus()) {
            if (i == 33) {
                DetailsSupportFragmentBackgroundController detailsSupportFragmentBackgroundController = detailsSupportFragment.f4960c1;
                if (detailsSupportFragmentBackgroundController != null && detailsSupportFragmentBackgroundController.canNavigateToVideoSupportFragment() && (fragment = detailsSupportFragment.f4953V0) != null && fragment.getView() != null) {
                    return detailsSupportFragment.f4953V0.getView();
                }
                if (detailsSupportFragment.getTitleView() != null && detailsSupportFragment.getTitleView().hasFocusable()) {
                    return detailsSupportFragment.getTitleView();
                }
                return view;
            }
            return view;
        }
        if (detailsSupportFragment.getTitleView() != null && detailsSupportFragment.getTitleView().hasFocus() && i == 130 && detailsSupportFragment.f4955X0.getVerticalGridView() != null) {
            return detailsSupportFragment.f4955X0.getVerticalGridView();
        }
        return view;
    }
}
