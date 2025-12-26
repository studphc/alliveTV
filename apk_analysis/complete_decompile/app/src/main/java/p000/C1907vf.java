package p000;

import androidx.leanback.app.BaseSupportFragment;
import androidx.leanback.util.StateMachine;

/* renamed from: vf */
/* loaded from: classes.dex */
public final class C1907vf extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ BaseSupportFragment f27756h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1907vf(BaseSupportFragment baseSupportFragment) {
        super("ENTRANCE_ON_PREPARED_ON_CREATEVIEW");
        this.f27756h = baseSupportFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        this.f27756h.onEntranceTransitionPrepare();
    }
}
