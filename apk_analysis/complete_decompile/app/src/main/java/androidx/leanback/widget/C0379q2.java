package androidx.leanback.widget;

import androidx.leanback.widget.SearchBar;
import androidx.leanback.widget.SearchEditText;

/* renamed from: androidx.leanback.widget.q2 */
/* loaded from: classes.dex */
public final class C0379q2 implements SearchEditText.OnKeyboardDismissListener {

    /* renamed from: a */
    public final /* synthetic */ SearchBar f6406a;

    public C0379q2(SearchBar searchBar) {
        this.f6406a = searchBar;
    }

    @Override // androidx.leanback.widget.SearchEditText.OnKeyboardDismissListener
    public final void onKeyboardDismiss() {
        SearchBar searchBar = this.f6406a;
        SearchBar.SearchBarListener searchBarListener = searchBar.f6126a;
        if (searchBarListener != null) {
            searchBarListener.onKeyboardDismiss(searchBar.f6130e);
        }
    }
}
