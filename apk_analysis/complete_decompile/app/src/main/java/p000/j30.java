package p000;

import android.view.Window;
import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.util.StateMachine;

/* loaded from: classes.dex */
public final class j30 extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ DetailsSupportFragment f20359h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j30(DetailsSupportFragment detailsSupportFragment) {
        super("STATE_ENTER_TRANSITION_CANCEL", false, false);
        this.f20359h = detailsSupportFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        DetailsSupportFragment detailsSupportFragment = this.f20359h;
        detailsSupportFragment.getClass();
        if (detailsSupportFragment.getActivity() != null) {
            Window window = detailsSupportFragment.getActivity().getWindow();
            Object returnTransition = TransitionHelper.getReturnTransition(window);
            Object sharedElementReturnTransition = TransitionHelper.getSharedElementReturnTransition(window);
            TransitionHelper.setEnterTransition(window, (Object) null);
            TransitionHelper.setSharedElementEnterTransition(window, (Object) null);
            TransitionHelper.setReturnTransition(window, returnTransition);
            TransitionHelper.setSharedElementReturnTransition(window, sharedElementReturnTransition);
        }
    }
}
