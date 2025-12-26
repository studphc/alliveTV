package p000;

import android.view.View;
import androidx.leanback.widget.SearchBar;

/* loaded from: classes.dex */
public final class ye2 implements View.OnFocusChangeListener {

    /* renamed from: a */
    public final /* synthetic */ int f28926a;

    /* renamed from: b */
    public final /* synthetic */ SearchBar f28927b;

    public /* synthetic */ ye2(SearchBar searchBar, int i) {
        this.f28926a = i;
        this.f28927b = searchBar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        switch (this.f28926a) {
            case 0:
                SearchBar searchBar = this.f28927b;
                if (z) {
                    searchBar.f6134i.post(new ze2(searchBar, 1));
                } else {
                    searchBar.m1481a();
                }
                searchBar.m1483c(z);
                return;
            default:
                SearchBar searchBar2 = this.f28927b;
                if (z) {
                    searchBar2.m1481a();
                    if (searchBar2.f6136k) {
                        searchBar2.startRecognition();
                        searchBar2.f6136k = false;
                    }
                } else {
                    searchBar2.stopRecognition();
                }
                searchBar2.m1483c(z);
                return;
        }
    }
}
