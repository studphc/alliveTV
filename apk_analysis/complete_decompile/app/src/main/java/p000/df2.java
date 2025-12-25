package p000;

import android.os.Handler;
import androidx.leanback.app.SearchFragment;
import androidx.leanback.widget.ObjectAdapter;

/* loaded from: classes.dex */
public final class df2 extends ObjectAdapter.DataObserver {

    /* renamed from: a */
    public final /* synthetic */ SearchFragment f16356a;

    public df2(SearchFragment searchFragment) {
        this.f16356a = searchFragment;
    }

    @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
    public final void onChanged() {
        SearchFragment searchFragment = this.f16356a;
        Handler handler = searchFragment.f5240b;
        ef2 ef2Var = searchFragment.f5241c;
        handler.removeCallbacks(ef2Var);
        searchFragment.f5240b.post(ef2Var);
    }
}
