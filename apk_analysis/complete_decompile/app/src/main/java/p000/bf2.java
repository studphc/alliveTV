package p000;

import android.text.TextUtils;
import androidx.leanback.widget.C0386s2;
import androidx.leanback.widget.SearchBar;

/* loaded from: classes.dex */
public final class bf2 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f7995a;

    /* renamed from: b */
    public final /* synthetic */ C0386s2 f7996b;

    public /* synthetic */ bf2(C0386s2 c0386s2, int i) {
        this.f7995a = i;
        this.f7996b = c0386s2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SearchBar.SearchBarListener searchBarListener;
        switch (this.f7995a) {
            case 0:
                SearchBar searchBar = this.f7996b.f6412a;
                if (!TextUtils.isEmpty(searchBar.f6130e) && (searchBarListener = searchBar.f6126a) != null) {
                    searchBarListener.onSearchQuerySubmit(searchBar.f6130e);
                    return;
                }
                return;
            default:
                SearchBar searchBar2 = this.f7996b.f6412a;
                searchBar2.f6136k = true;
                searchBar2.f6128c.requestFocus();
                return;
        }
    }
}
