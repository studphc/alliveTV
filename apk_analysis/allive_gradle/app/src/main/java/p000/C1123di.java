package p000;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.BrowseFrameLayout;
import androidx.leanback.widget.ObjectAdapter;

/* renamed from: di */
/* loaded from: classes.dex */
public final class C1123di implements BrowseFrameLayout.OnFocusSearchListener {

    /* renamed from: a */
    public final /* synthetic */ BrowseSupportFragment f16375a;

    public C1123di(BrowseSupportFragment browseSupportFragment) {
        this.f16375a = browseSupportFragment;
    }

    @Override // androidx.leanback.widget.BrowseFrameLayout.OnFocusSearchListener
    public final View onFocusSearch(View view, int i) {
        int i2;
        Fragment fragment;
        ObjectAdapter objectAdapter;
        BrowseSupportFragment browseSupportFragment = this.f16375a;
        if (browseSupportFragment.f4865X0 && browseSupportFragment.isInHeadersTransition()) {
            return view;
        }
        if (browseSupportFragment.getTitleView() != null && view != browseSupportFragment.getTitleView() && i == 33) {
            return browseSupportFragment.getTitleView();
        }
        if (browseSupportFragment.getTitleView() != null && browseSupportFragment.getTitleView().hasFocus() && i == 130) {
            if (browseSupportFragment.f4865X0 && browseSupportFragment.f4864W0) {
                return browseSupportFragment.f4852K0.getVerticalGridView();
            }
            return browseSupportFragment.f4851J0.getView();
        }
        boolean z = true;
        if (ViewCompat.getLayoutDirection(view) != 1) {
            z = false;
        }
        int i3 = 17;
        if (z) {
            i2 = 66;
        } else {
            i2 = 17;
        }
        if (!z) {
            i3 = 66;
        }
        if (browseSupportFragment.f4865X0 && i == i2) {
            if (!browseSupportFragment.f4852K0.isScrolling() && !browseSupportFragment.f4850I0.isScrolling() && !browseSupportFragment.f4864W0 && (objectAdapter = browseSupportFragment.f4855N0) != null && objectAdapter.size() != 0) {
                return browseSupportFragment.f4852K0.getVerticalGridView();
            }
            return view;
        }
        if (i == i3) {
            if (!browseSupportFragment.f4852K0.isScrolling() && !browseSupportFragment.f4850I0.isScrolling() && (fragment = browseSupportFragment.f4851J0) != null && fragment.getView() != null) {
                return browseSupportFragment.f4851J0.getView();
            }
            return view;
        }
        if (i == 130 && browseSupportFragment.f4864W0) {
            return view;
        }
        return null;
    }
}
