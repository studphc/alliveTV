package androidx.leanback.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import p000.bf2;

/* renamed from: androidx.leanback.widget.s2 */
/* loaded from: classes.dex */
public final class C0386s2 implements TextView.OnEditorActionListener {

    /* renamed from: a */
    public final /* synthetic */ SearchBar f6412a;

    public C0386s2(SearchBar searchBar) {
        this.f6412a = searchBar;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        SearchBar searchBar = this.f6412a;
        if ((3 == i || i == 0) && searchBar.f6126a != null) {
            searchBar.m1481a();
            searchBar.f6134i.postDelayed(new bf2(this, 0), 500L);
            return true;
        }
        if (1 == i && searchBar.f6126a != null) {
            searchBar.m1481a();
            searchBar.f6134i.postDelayed(new RunnableC0382r2(this), 500L);
            return true;
        }
        if (2 == i) {
            searchBar.m1481a();
            searchBar.f6134i.postDelayed(new bf2(this, 1), 500L);
            return true;
        }
        return false;
    }
}
