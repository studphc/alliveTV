package p000;

import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.util.StateMachine;

/* loaded from: classes.dex */
public final class h30 extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ DetailsSupportFragment f17936h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h30(DetailsSupportFragment detailsSupportFragment) {
        super("STATE_SET_ENTRANCE_START_STATE");
        this.f17936h = detailsSupportFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        this.f17936h.f4955X0.setEntranceTransitionState(false);
    }
}
