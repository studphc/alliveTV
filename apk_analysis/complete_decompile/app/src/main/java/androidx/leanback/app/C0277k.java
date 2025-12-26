package androidx.leanback.app;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.transition.TransitionListener;
import androidx.leanback.widget.VerticalGridView;

/* renamed from: androidx.leanback.app.k */
/* loaded from: classes.dex */
public final class C0277k extends TransitionListener {

    /* renamed from: a */
    public final /* synthetic */ BrowseSupportFragment f5333a;

    public C0277k(BrowseSupportFragment browseSupportFragment) {
        this.f5333a = browseSupportFragment;
    }

    @Override // androidx.leanback.transition.TransitionListener
    public final void onTransitionEnd(Object obj) {
        VerticalGridView verticalGridView;
        Fragment fragment;
        View view;
        BrowseSupportFragment browseSupportFragment = this.f5333a;
        browseSupportFragment.f4881n1 = null;
        BrowseSupportFragment.MainFragmentAdapter mainFragmentAdapter = browseSupportFragment.f4850I0;
        if (mainFragmentAdapter != null) {
            mainFragmentAdapter.onTransitionEnd();
            if (!browseSupportFragment.f4864W0 && (fragment = browseSupportFragment.f4851J0) != null && (view = fragment.getView()) != null && !view.hasFocus()) {
                view.requestFocus();
            }
        }
        HeadersSupportFragment headersSupportFragment = browseSupportFragment.f4852K0;
        if (headersSupportFragment != null) {
            headersSupportFragment.onTransitionEnd();
            if (browseSupportFragment.f4864W0 && (verticalGridView = browseSupportFragment.f4852K0.getVerticalGridView()) != null && !verticalGridView.hasFocus()) {
                verticalGridView.requestFocus();
            }
        }
        browseSupportFragment.m1286y();
        BrowseSupportFragment.BrowseTransitionListener browseTransitionListener = browseSupportFragment.f4883p1;
        if (browseTransitionListener != null) {
            browseTransitionListener.onHeadersTransitionStop(browseSupportFragment.f4864W0);
        }
    }

    @Override // androidx.leanback.transition.TransitionListener
    public final void onTransitionStart(Object obj) {
    }
}
