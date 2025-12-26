package p000;

import android.view.Window;
import androidx.leanback.app.DetailsFragment;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.util.StateMachine;

/* loaded from: classes.dex */
public final class t20 extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ DetailsFragment f26673h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t20(DetailsFragment detailsFragment) {
        super("STATE_ENTER_TRANSITION_CANCEL", false, false);
        this.f26673h = detailsFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        DetailsFragment detailsFragment = this.f26673h;
        detailsFragment.getClass();
        if (detailsFragment.getActivity() != null) {
            Window window = detailsFragment.getActivity().getWindow();
            Object returnTransition = TransitionHelper.getReturnTransition(window);
            Object sharedElementReturnTransition = TransitionHelper.getSharedElementReturnTransition(window);
            TransitionHelper.setEnterTransition(window, (Object) null);
            TransitionHelper.setSharedElementEnterTransition(window, (Object) null);
            TransitionHelper.setReturnTransition(window, returnTransition);
            TransitionHelper.setSharedElementReturnTransition(window, sharedElementReturnTransition);
        }
    }
}
