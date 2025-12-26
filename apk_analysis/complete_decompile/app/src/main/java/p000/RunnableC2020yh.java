package p000;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.app.BrowseFragment;

/* renamed from: yh */
/* loaded from: classes.dex */
public final class RunnableC2020yh implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f28949a;

    /* renamed from: b */
    public final /* synthetic */ BrowseFragment f28950b;

    public /* synthetic */ RunnableC2020yh(BrowseFragment browseFragment, int i) {
        this.f28949a = i;
        this.f28950b = browseFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f28949a) {
            case 0:
                this.f28950b.m1271k(true);
                return;
            case 1:
                this.f28950b.m1271k(false);
                return;
            default:
                BrowseFragment browseFragment = this.f28950b;
                browseFragment.m1267g(browseFragment.f4811S);
                View searchAffordanceView = browseFragment.getTitleViewAdapter().getSearchAffordanceView();
                if (searchAffordanceView != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) searchAffordanceView.getLayoutParams();
                    marginLayoutParams.setMarginStart(0);
                    searchAffordanceView.setLayoutParams(marginLayoutParams);
                }
                browseFragment.f4797E.setEntranceTransitionState(true);
                return;
        }
    }
}
