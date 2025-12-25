package androidx.leanback.app;

import androidx.leanback.app.SearchFragment;
import androidx.leanback.widget.SearchBar;

/* renamed from: androidx.leanback.app.t */
/* loaded from: classes.dex */
public final class C0286t implements SearchBar.SearchBarListener {

    /* renamed from: a */
    public final /* synthetic */ SearchFragment f5350a;

    public C0286t(SearchFragment searchFragment) {
        this.f5350a = searchFragment;
    }

    @Override // androidx.leanback.widget.SearchBar.SearchBarListener
    public final void onKeyboardDismiss(String str) {
        SearchFragment searchFragment = this.f5350a;
        searchFragment.f5256r |= 2;
        searchFragment.m1346b();
    }

    @Override // androidx.leanback.widget.SearchBar.SearchBarListener
    public final void onSearchQueryChange(String str) {
        SearchFragment searchFragment = this.f5350a;
        SearchFragment.SearchResultProvider searchResultProvider = searchFragment.f5246h;
        if (searchResultProvider != null) {
            if (searchResultProvider.onQueryTextChange(str)) {
                searchFragment.f5256r &= -3;
                return;
            }
            return;
        }
        searchFragment.f5247i = str;
    }

    @Override // androidx.leanback.widget.SearchBar.SearchBarListener
    public final void onSearchQuerySubmit(String str) {
        SearchFragment searchFragment = this.f5350a;
        searchFragment.f5256r |= 2;
        searchFragment.m1346b();
        SearchFragment.SearchResultProvider searchResultProvider = searchFragment.f5246h;
        if (searchResultProvider != null) {
            searchResultProvider.onQueryTextSubmit(str);
        }
    }
}
