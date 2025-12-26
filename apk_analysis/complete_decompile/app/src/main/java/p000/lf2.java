package p000;

import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.app.SearchSupportFragment;

/* loaded from: classes.dex */
public final class lf2 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f22493a;

    /* renamed from: b */
    public final /* synthetic */ SearchSupportFragment f22494b;

    public /* synthetic */ lf2(SearchSupportFragment searchSupportFragment, int i) {
        this.f22493a = i;
        this.f22494b = searchSupportFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f22493a) {
            case 0:
                SearchSupportFragment searchSupportFragment = this.f22494b;
                RowsSupportFragment rowsSupportFragment = searchSupportFragment.f5270j0;
                if (rowsSupportFragment != null && rowsSupportFragment.getAdapter() != searchSupportFragment.f5276p0 && (searchSupportFragment.f5270j0.getAdapter() != null || searchSupportFragment.f5276p0.size() != 0)) {
                    searchSupportFragment.f5270j0.setAdapter(searchSupportFragment.f5276p0);
                    searchSupportFragment.f5270j0.setSelectedPosition(0);
                }
                searchSupportFragment.m1352o();
                int i = searchSupportFragment.f5282v0 | 1;
                searchSupportFragment.f5282v0 = i;
                if ((i & 2) != 0) {
                    searchSupportFragment.m1351n();
                    return;
                }
                return;
            default:
                SearchSupportFragment searchSupportFragment2 = this.f22494b;
                searchSupportFragment2.f5283w0 = false;
                searchSupportFragment2.f5271k0.startRecognition();
                return;
        }
    }
}
