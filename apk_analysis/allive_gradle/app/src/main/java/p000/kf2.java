package p000;

import android.os.Handler;
import androidx.leanback.app.SearchSupportFragment;
import androidx.leanback.widget.ObjectAdapter;

/* loaded from: classes.dex */
public final class kf2 extends ObjectAdapter.DataObserver {

    /* renamed from: a */
    public final /* synthetic */ SearchSupportFragment f20843a;

    public kf2(SearchSupportFragment searchSupportFragment) {
        this.f20843a = searchSupportFragment;
    }

    @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
    public final void onChanged() {
        SearchSupportFragment searchSupportFragment = this.f20843a;
        Handler handler = searchSupportFragment.f5266f0;
        lf2 lf2Var = searchSupportFragment.f5267g0;
        handler.removeCallbacks(lf2Var);
        searchSupportFragment.f5266f0.post(lf2Var);
    }
}
