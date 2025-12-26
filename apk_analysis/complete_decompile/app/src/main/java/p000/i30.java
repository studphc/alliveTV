package p000;

import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.app.DetailsSupportFragmentBackgroundController;
import androidx.leanback.util.StateMachine;

/* loaded from: classes.dex */
public final class i30 extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ DetailsSupportFragment f18279h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i30(DetailsSupportFragment detailsSupportFragment) {
        super("STATE_SWITCH_TO_VIDEO_IN_ON_CREATE", false, false);
        this.f18279h = detailsSupportFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        DetailsSupportFragment detailsSupportFragment = this.f18279h;
        DetailsSupportFragmentBackgroundController detailsSupportFragmentBackgroundController = detailsSupportFragment.f4960c1;
        detailsSupportFragmentBackgroundController.f4969e.m6009b(true, true);
        detailsSupportFragmentBackgroundController.f4973i = true;
        detailsSupportFragment.showTitle(false);
        detailsSupportFragment.f4961d1 = true;
        if (detailsSupportFragment.getVerticalGridView() != null) {
            detailsSupportFragment.getVerticalGridView().animateOut();
        }
    }
}
