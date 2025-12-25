package p000;

import androidx.leanback.app.DetailsFragment;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.util.StateMachine;

/* loaded from: classes.dex */
public final class u20 extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ DetailsFragment f27072h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u20(DetailsFragment detailsFragment) {
        super("STATE_ENTER_TRANSITION_PENDING");
        this.f27072h = detailsFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        DetailsFragment detailsFragment = this.f27072h;
        TransitionHelper.addTransitionListener(TransitionHelper.getEnterTransition(detailsFragment.getActivity().getWindow()), detailsFragment.f4907M);
    }
}
