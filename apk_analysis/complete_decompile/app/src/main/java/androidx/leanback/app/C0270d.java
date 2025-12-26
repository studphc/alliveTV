package androidx.leanback.app;

import android.app.Fragment;
import android.view.View;
import androidx.leanback.app.BrowseFragment;
import androidx.leanback.transition.TransitionListener;
import androidx.leanback.widget.VerticalGridView;

/* renamed from: androidx.leanback.app.d */
/* loaded from: classes.dex */
public final class C0270d extends TransitionListener {

    /* renamed from: a */
    public final /* synthetic */ BrowseFragment f5319a;

    public C0270d(BrowseFragment browseFragment) {
        this.f5319a = browseFragment;
    }

    @Override // androidx.leanback.transition.TransitionListener
    public final void onTransitionEnd(Object obj) {
        VerticalGridView verticalGridView;
        Fragment fragment;
        View view;
        BrowseFragment browseFragment = this.f5319a;
        browseFragment.f4828j0 = null;
        BrowseFragment.MainFragmentAdapter mainFragmentAdapter = browseFragment.f4797E;
        if (mainFragmentAdapter != null) {
            mainFragmentAdapter.onTransitionEnd();
            if (!browseFragment.f4811S && (fragment = browseFragment.f4798F) != null && (view = fragment.getView()) != null && !view.hasFocus()) {
                view.requestFocus();
            }
        }
        HeadersFragment headersFragment = browseFragment.f4799G;
        if (headersFragment != null) {
            headersFragment.onTransitionEnd();
            if (browseFragment.f4811S && (verticalGridView = browseFragment.f4799G.getVerticalGridView()) != null && !verticalGridView.hasFocus()) {
                verticalGridView.requestFocus();
            }
        }
        browseFragment.m1274n();
        BrowseFragment.BrowseTransitionListener browseTransitionListener = browseFragment.f4830l0;
        if (browseTransitionListener != null) {
            browseTransitionListener.onHeadersTransitionStop(browseFragment.f4811S);
        }
    }

    @Override // androidx.leanback.transition.TransitionListener
    public final void onTransitionStart(Object obj) {
    }
}
