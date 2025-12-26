package p000;

import android.view.View;
import androidx.leanback.R;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.app.SearchSupportFragment;
import androidx.leanback.widget.BrowseFrameLayout;
import androidx.leanback.widget.ObjectAdapter;

/* loaded from: classes.dex */
public final class of2 implements BrowseFrameLayout.OnFocusSearchListener {

    /* renamed from: a */
    public final /* synthetic */ SearchSupportFragment f23798a;

    public of2(SearchSupportFragment searchSupportFragment) {
        this.f23798a = searchSupportFragment;
    }

    @Override // androidx.leanback.widget.BrowseFrameLayout.OnFocusSearchListener
    public final View onFocusSearch(View view, int i) {
        ObjectAdapter objectAdapter;
        SearchSupportFragment searchSupportFragment = this.f23798a;
        RowsSupportFragment rowsSupportFragment = searchSupportFragment.f5270j0;
        if (rowsSupportFragment != null && rowsSupportFragment.getView() != null && searchSupportFragment.f5270j0.getView().hasFocus()) {
            if (i == 33) {
                if (searchSupportFragment.f5264A0) {
                    return searchSupportFragment.f5271k0.findViewById(R.id.lb_search_bar_speech_orb);
                }
                return searchSupportFragment.f5271k0;
            }
            return null;
        }
        if (searchSupportFragment.f5271k0.hasFocus() && i == 130 && searchSupportFragment.f5270j0.getView() != null && (objectAdapter = searchSupportFragment.f5276p0) != null && objectAdapter.size() > 0) {
            return searchSupportFragment.f5270j0.getView();
        }
        return null;
    }
}
