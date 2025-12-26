package p000;

import androidx.leanback.app.RowsFragment;
import androidx.leanback.app.SearchFragment;

/* loaded from: classes.dex */
public final class ef2 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f16792a;

    /* renamed from: b */
    public final /* synthetic */ SearchFragment f16793b;

    public /* synthetic */ ef2(SearchFragment searchFragment, int i) {
        this.f16792a = i;
        this.f16793b = searchFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16792a) {
            case 0:
                SearchFragment searchFragment = this.f16793b;
                RowsFragment rowsFragment = searchFragment.f5244f;
                if (rowsFragment != null && rowsFragment.getAdapter() != searchFragment.f5250l && (searchFragment.f5244f.getAdapter() != null || searchFragment.f5250l.size() != 0)) {
                    searchFragment.f5244f.setAdapter(searchFragment.f5250l);
                    searchFragment.f5244f.setSelectedPosition(0);
                }
                searchFragment.m1348d();
                int i = searchFragment.f5256r | 1;
                searchFragment.f5256r = i;
                if ((i & 2) != 0) {
                    searchFragment.m1347c();
                    return;
                }
                return;
            default:
                SearchFragment searchFragment2 = this.f16793b;
                searchFragment2.f5257s = false;
                searchFragment2.f5245g.startRecognition();
                return;
        }
    }
}
