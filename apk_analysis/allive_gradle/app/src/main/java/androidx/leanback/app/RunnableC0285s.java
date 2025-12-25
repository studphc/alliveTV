package androidx.leanback.app;

import android.os.Handler;
import androidx.leanback.widget.ObjectAdapter;
import p000.df2;
import p000.ef2;

/* renamed from: androidx.leanback.app.s */
/* loaded from: classes.dex */
public final class RunnableC0285s implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ SearchFragment f5349a;

    public RunnableC0285s(SearchFragment searchFragment) {
        this.f5349a = searchFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        ObjectAdapter objectAdapter;
        SearchFragment searchFragment = this.f5349a;
        if (searchFragment.f5244f == null) {
            return;
        }
        ObjectAdapter resultsAdapter = searchFragment.f5246h.getResultsAdapter();
        ObjectAdapter objectAdapter2 = searchFragment.f5250l;
        if (resultsAdapter != objectAdapter2) {
            if (objectAdapter2 == null) {
                z = true;
            } else {
                z = false;
            }
            df2 df2Var = searchFragment.f5239a;
            if (objectAdapter2 != null) {
                objectAdapter2.unregisterObserver(df2Var);
                searchFragment.f5250l = null;
            }
            searchFragment.f5250l = resultsAdapter;
            if (resultsAdapter != null) {
                resultsAdapter.registerObserver(df2Var);
            }
            if (!z || ((objectAdapter = searchFragment.f5250l) != null && objectAdapter.size() != 0)) {
                searchFragment.f5244f.setAdapter(searchFragment.f5250l);
            }
            String str = searchFragment.f5247i;
            if (str != null && searchFragment.f5250l != null) {
                searchFragment.f5247i = null;
                if (searchFragment.f5246h.onQueryTextChange(str)) {
                    searchFragment.f5256r &= -3;
                }
            }
        }
        if (searchFragment.f5257s) {
            Handler handler = searchFragment.f5240b;
            ef2 ef2Var = searchFragment.f5243e;
            handler.removeCallbacks(ef2Var);
            handler.postDelayed(ef2Var, 300L);
            return;
        }
        searchFragment.m1347c();
    }
}
