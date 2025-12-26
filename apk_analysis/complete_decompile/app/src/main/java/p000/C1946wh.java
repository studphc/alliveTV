package p000;

import android.app.Fragment;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.leanback.app.BrowseFragment;
import androidx.leanback.widget.BrowseFrameLayout;
import androidx.leanback.widget.ObjectAdapter;

/* renamed from: wh */
/* loaded from: classes.dex */
public final class C1946wh implements BrowseFrameLayout.OnFocusSearchListener {

    /* renamed from: a */
    public final /* synthetic */ BrowseFragment f28183a;

    public C1946wh(BrowseFragment browseFragment) {
        this.f28183a = browseFragment;
    }

    @Override // androidx.leanback.widget.BrowseFrameLayout.OnFocusSearchListener
    public final View onFocusSearch(View view, int i) {
        int i2;
        Fragment fragment;
        ObjectAdapter objectAdapter;
        BrowseFragment browseFragment = this.f28183a;
        if (browseFragment.f4812T && browseFragment.isInHeadersTransition()) {
            return view;
        }
        if (browseFragment.getTitleView() != null && view != browseFragment.getTitleView() && i == 33) {
            return browseFragment.getTitleView();
        }
        if (browseFragment.getTitleView() != null && browseFragment.getTitleView().hasFocus() && i == 130) {
            if (browseFragment.f4812T && browseFragment.f4811S) {
                return browseFragment.f4799G.getVerticalGridView();
            }
            return browseFragment.f4798F.getView();
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
        if (browseFragment.f4812T && i == i2) {
            if (!browseFragment.f4799G.isScrolling() && !browseFragment.f4797E.isScrolling() && !browseFragment.f4811S && (objectAdapter = browseFragment.f4802J) != null && objectAdapter.size() != 0) {
                return browseFragment.f4799G.getVerticalGridView();
            }
            return view;
        }
        if (i == i3) {
            if (!browseFragment.f4799G.isScrolling() && !browseFragment.f4797E.isScrolling() && (fragment = browseFragment.f4798F) != null && fragment.getView() != null) {
                return browseFragment.f4798F.getView();
            }
            return view;
        }
        if (i == 130 && browseFragment.f4811S) {
            return view;
        }
        return null;
    }
}
