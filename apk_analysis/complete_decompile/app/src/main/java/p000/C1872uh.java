package p000;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.app.BrowseFragment;
import androidx.leanback.util.StateMachine;

/* renamed from: uh */
/* loaded from: classes.dex */
public final class C1872uh extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ BrowseFragment f27263h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1872uh(BrowseFragment browseFragment) {
        super("SET_ENTRANCE_START_STATE");
        this.f27263h = browseFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        BrowseFragment browseFragment = this.f27263h;
        browseFragment.m1267g(false);
        View searchAffordanceView = browseFragment.getTitleViewAdapter().getSearchAffordanceView();
        if (searchAffordanceView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) searchAffordanceView.getLayoutParams();
            marginLayoutParams.setMarginStart(-browseFragment.f4813U);
            searchAffordanceView.setLayoutParams(marginLayoutParams);
        }
    }
}
