package p000;

import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.util.StateMachine;

/* loaded from: classes.dex */
public final class l30 extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ DetailsSupportFragment f22312h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l30(DetailsSupportFragment detailsSupportFragment) {
        super("STATE_ENTER_TRANSITION_PENDING");
        this.f22312h = detailsSupportFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        DetailsSupportFragment detailsSupportFragment = this.f22312h;
        detailsSupportFragment.getClass();
        new q30(detailsSupportFragment);
    }
}
