package androidx.leanback.app;

import androidx.leanback.app.SearchSupportFragment;
import androidx.leanback.widget.SearchBar;

/* renamed from: androidx.leanback.app.v */
/* loaded from: classes.dex */
public final class C0288v implements SearchBar.SearchBarListener {

    /* renamed from: a */
    public final /* synthetic */ SearchSupportFragment f5352a;

    public C0288v(SearchSupportFragment searchSupportFragment) {
        this.f5352a = searchSupportFragment;
    }

    @Override // androidx.leanback.widget.SearchBar.SearchBarListener
    public final void onKeyboardDismiss(String str) {
        SearchSupportFragment searchSupportFragment = this.f5352a;
        searchSupportFragment.f5282v0 |= 2;
        searchSupportFragment.m1350m();
    }

    @Override // androidx.leanback.widget.SearchBar.SearchBarListener
    public final void onSearchQueryChange(String str) {
        SearchSupportFragment searchSupportFragment = this.f5352a;
        SearchSupportFragment.SearchResultProvider searchResultProvider = searchSupportFragment.f5272l0;
        if (searchResultProvider != null) {
            if (searchResultProvider.onQueryTextChange(str)) {
                searchSupportFragment.f5282v0 &= -3;
                return;
            }
            return;
        }
        searchSupportFragment.f5273m0 = str;
    }

    @Override // androidx.leanback.widget.SearchBar.SearchBarListener
    public final void onSearchQuerySubmit(String str) {
        SearchSupportFragment searchSupportFragment = this.f5352a;
        searchSupportFragment.f5282v0 |= 2;
        searchSupportFragment.m1350m();
        SearchSupportFragment.SearchResultProvider searchResultProvider = searchSupportFragment.f5272l0;
        if (searchResultProvider != null) {
            searchResultProvider.onQueryTextSubmit(str);
        }
    }
}
