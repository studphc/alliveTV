package p000;

import android.view.View;
import androidx.leanback.R;
import androidx.leanback.app.RowsFragment;
import androidx.leanback.app.SearchFragment;
import androidx.leanback.widget.BrowseFrameLayout;
import androidx.leanback.widget.ObjectAdapter;

/* loaded from: classes.dex */
public final class hf2 implements BrowseFrameLayout.OnFocusSearchListener {

    /* renamed from: a */
    public final /* synthetic */ SearchFragment f18046a;

    public hf2(SearchFragment searchFragment) {
        this.f18046a = searchFragment;
    }

    @Override // androidx.leanback.widget.BrowseFrameLayout.OnFocusSearchListener
    public final View onFocusSearch(View view, int i) {
        ObjectAdapter objectAdapter;
        SearchFragment searchFragment = this.f18046a;
        RowsFragment rowsFragment = searchFragment.f5244f;
        if (rowsFragment != null && rowsFragment.getView() != null && searchFragment.f5244f.getView().hasFocus()) {
            if (i == 33) {
                if (searchFragment.f5261w) {
                    return searchFragment.f5245g.findViewById(R.id.lb_search_bar_speech_orb);
                }
                return searchFragment.f5245g;
            }
            return null;
        }
        if (searchFragment.f5245g.hasFocus() && i == 130 && searchFragment.f5244f.getView() != null && (objectAdapter = searchFragment.f5250l) != null && objectAdapter.size() > 0) {
            return searchFragment.f5244f.getView();
        }
        return null;
    }
}
