package p000;

import androidx.leanback.app.VerticalGridSupportFragment;
import androidx.leanback.util.StateMachine;

/* loaded from: classes.dex */
public final class y13 extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ VerticalGridSupportFragment f28804h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y13(VerticalGridSupportFragment verticalGridSupportFragment) {
        super("SET_ENTRANCE_START_STATE");
        this.f28804h = verticalGridSupportFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        VerticalGridSupportFragment verticalGridSupportFragment = this.f28804h;
        verticalGridSupportFragment.f5298E0.setEntranceTransitionState(verticalGridSupportFragment.f5299F0, false);
    }
}
