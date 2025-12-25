package p000;

import androidx.leanback.app.DetailsFragment;
import androidx.leanback.util.StateMachine;

/* loaded from: classes.dex */
public final class r20 extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ DetailsFragment f25838h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r20(DetailsFragment detailsFragment) {
        super("STATE_SET_ENTRANCE_START_STATE");
        this.f25838h = detailsFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        this.f25838h.f4914T.setEntranceTransitionState(false);
    }
}
