package androidx.leanback.app;

import android.os.Handler;
import androidx.leanback.widget.ObjectAdapter;
import p000.kf2;
import p000.lf2;

/* renamed from: androidx.leanback.app.u */
/* loaded from: classes.dex */
public final class RunnableC0287u implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ SearchSupportFragment f5351a;

    public RunnableC0287u(SearchSupportFragment searchSupportFragment) {
        this.f5351a = searchSupportFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        ObjectAdapter objectAdapter;
        SearchSupportFragment searchSupportFragment = this.f5351a;
        if (searchSupportFragment.f5270j0 == null) {
            return;
        }
        ObjectAdapter resultsAdapter = searchSupportFragment.f5272l0.getResultsAdapter();
        ObjectAdapter objectAdapter2 = searchSupportFragment.f5276p0;
        if (resultsAdapter != objectAdapter2) {
            if (objectAdapter2 == null) {
                z = true;
            } else {
                z = false;
            }
            kf2 kf2Var = searchSupportFragment.f5265e0;
            if (objectAdapter2 != null) {
                objectAdapter2.unregisterObserver(kf2Var);
                searchSupportFragment.f5276p0 = null;
            }
            searchSupportFragment.f5276p0 = resultsAdapter;
            if (resultsAdapter != null) {
                resultsAdapter.registerObserver(kf2Var);
            }
            if (!z || ((objectAdapter = searchSupportFragment.f5276p0) != null && objectAdapter.size() != 0)) {
                searchSupportFragment.f5270j0.setAdapter(searchSupportFragment.f5276p0);
            }
            String str = searchSupportFragment.f5273m0;
            if (str != null && searchSupportFragment.f5276p0 != null) {
                searchSupportFragment.f5273m0 = null;
                if (searchSupportFragment.f5272l0.onQueryTextChange(str)) {
                    searchSupportFragment.f5282v0 &= -3;
                }
            }
        }
        if (searchSupportFragment.f5283w0) {
            Handler handler = searchSupportFragment.f5266f0;
            lf2 lf2Var = searchSupportFragment.f5269i0;
            handler.removeCallbacks(lf2Var);
            handler.postDelayed(lf2Var, 300L);
            return;
        }
        searchSupportFragment.m1351n();
    }
}
