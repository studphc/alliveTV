package p000;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.app.BrowseSupportFragment;

/* renamed from: fi */
/* loaded from: classes.dex */
public final class RunnableC1196fi implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f17272a;

    /* renamed from: b */
    public final /* synthetic */ BrowseSupportFragment f17273b;

    public /* synthetic */ RunnableC1196fi(BrowseSupportFragment browseSupportFragment, int i) {
        this.f17272a = i;
        this.f17273b = browseSupportFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f17272a) {
            case 0:
                this.f17273b.m1283v(true);
                return;
            case 1:
                this.f17273b.m1283v(false);
                return;
            default:
                BrowseSupportFragment browseSupportFragment = this.f17273b;
                browseSupportFragment.m1279r(browseSupportFragment.f4864W0);
                View searchAffordanceView = browseSupportFragment.getTitleViewAdapter().getSearchAffordanceView();
                if (searchAffordanceView != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) searchAffordanceView.getLayoutParams();
                    marginLayoutParams.setMarginStart(0);
                    searchAffordanceView.setLayoutParams(marginLayoutParams);
                }
                browseSupportFragment.f4850I0.setEntranceTransitionState(true);
                return;
        }
    }
}
