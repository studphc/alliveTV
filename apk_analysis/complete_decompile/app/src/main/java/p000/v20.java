package p000;

import androidx.leanback.app.DetailsFragment;
import androidx.leanback.util.StateMachine;

/* loaded from: classes.dex */
public final class v20 extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ DetailsFragment f27627h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v20(DetailsFragment detailsFragment) {
        super("STATE_ENTER_TRANSITION_PENDING");
        this.f27627h = detailsFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        DetailsFragment detailsFragment = this.f27627h;
        detailsFragment.getClass();
        new c30(detailsFragment);
    }
}
