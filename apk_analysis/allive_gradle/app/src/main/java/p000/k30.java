package p000;

import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.util.StateMachine;

/* loaded from: classes.dex */
public final class k30 extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ DetailsSupportFragment f20741h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k30(DetailsSupportFragment detailsSupportFragment) {
        super("STATE_ENTER_TRANSITION_PENDING");
        this.f20741h = detailsSupportFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        DetailsSupportFragment detailsSupportFragment = this.f20741h;
        TransitionHelper.addTransitionListener(TransitionHelper.getEnterTransition(detailsSupportFragment.getActivity().getWindow()), detailsSupportFragment.f4948Q0);
    }
}
