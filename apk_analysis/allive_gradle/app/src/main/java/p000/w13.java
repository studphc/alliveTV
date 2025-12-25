package p000;

import androidx.leanback.app.VerticalGridFragment;
import androidx.leanback.util.StateMachine;

/* loaded from: classes.dex */
public final class w13 extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ VerticalGridFragment f28043h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w13(VerticalGridFragment verticalGridFragment) {
        super("SET_ENTRANCE_START_STATE");
        this.f28043h = verticalGridFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        VerticalGridFragment verticalGridFragment = this.f28043h;
        verticalGridFragment.f5287A.setEntranceTransitionState(verticalGridFragment.f5288B, false);
    }
}
