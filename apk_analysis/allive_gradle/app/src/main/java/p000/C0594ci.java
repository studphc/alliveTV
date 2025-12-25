package p000;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.util.StateMachine;

/* renamed from: ci */
/* loaded from: classes.dex */
public final class C0594ci extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ BrowseSupportFragment f8369h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0594ci(BrowseSupportFragment browseSupportFragment) {
        super("SET_ENTRANCE_START_STATE");
        this.f8369h = browseSupportFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        BrowseSupportFragment browseSupportFragment = this.f8369h;
        browseSupportFragment.m1279r(false);
        View searchAffordanceView = browseSupportFragment.getTitleViewAdapter().getSearchAffordanceView();
        if (searchAffordanceView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) searchAffordanceView.getLayoutParams();
            marginLayoutParams.setMarginStart(-browseSupportFragment.f4866Y0);
            searchAffordanceView.setLayoutParams(marginLayoutParams);
        }
    }
}
