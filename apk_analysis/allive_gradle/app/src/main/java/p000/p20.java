package p000;

import android.app.Fragment;
import android.view.View;
import androidx.leanback.app.DetailsFragment;
import androidx.leanback.app.DetailsFragmentBackgroundController;
import androidx.leanback.widget.BrowseFrameLayout;

/* loaded from: classes.dex */
public final class p20 implements BrowseFrameLayout.OnFocusSearchListener {

    /* renamed from: a */
    public final /* synthetic */ DetailsFragment f25008a;

    public p20(DetailsFragment detailsFragment) {
        this.f25008a = detailsFragment;
    }

    @Override // androidx.leanback.widget.BrowseFrameLayout.OnFocusSearchListener
    public final View onFocusSearch(View view, int i) {
        Fragment fragment;
        DetailsFragment detailsFragment = this.f25008a;
        if (detailsFragment.f4914T.getVerticalGridView() != null && detailsFragment.f4914T.getVerticalGridView().hasFocus()) {
            if (i == 33) {
                DetailsFragmentBackgroundController detailsFragmentBackgroundController = detailsFragment.f4919Y;
                if (detailsFragmentBackgroundController != null && detailsFragmentBackgroundController.canNavigateToVideoFragment() && (fragment = detailsFragment.f4912R) != null && fragment.getView() != null) {
                    return detailsFragment.f4912R.getView();
                }
                if (detailsFragment.getTitleView() != null && detailsFragment.getTitleView().hasFocusable()) {
                    return detailsFragment.getTitleView();
                }
                return view;
            }
            return view;
        }
        if (detailsFragment.getTitleView() != null && detailsFragment.getTitleView().hasFocus() && i == 130 && detailsFragment.f4914T.getVerticalGridView() != null) {
            return detailsFragment.f4914T.getVerticalGridView();
        }
        return view;
    }
}
