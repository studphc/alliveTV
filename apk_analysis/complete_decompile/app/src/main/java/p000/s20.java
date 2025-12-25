package p000;

import androidx.leanback.app.DetailsFragment;
import androidx.leanback.app.DetailsFragmentBackgroundController;
import androidx.leanback.util.StateMachine;

/* loaded from: classes.dex */
public final class s20 extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ DetailsFragment f26209h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s20(DetailsFragment detailsFragment) {
        super("STATE_SWITCH_TO_VIDEO_IN_ON_CREATE", false, false);
        this.f26209h = detailsFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        DetailsFragment detailsFragment = this.f26209h;
        DetailsFragmentBackgroundController detailsFragmentBackgroundController = detailsFragment.f4919Y;
        detailsFragmentBackgroundController.f4929e.m6009b(true, true);
        detailsFragmentBackgroundController.f4933i = true;
        detailsFragment.showTitle(false);
        detailsFragment.f4920Z = true;
        if (detailsFragment.m1287c() != null) {
            detailsFragment.m1287c().animateOut();
        }
    }
}
