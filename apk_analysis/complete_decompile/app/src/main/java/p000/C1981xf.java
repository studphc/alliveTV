package p000;

import androidx.leanback.app.BaseSupportFragment;
import androidx.leanback.util.StateMachine;

/* renamed from: xf */
/* loaded from: classes.dex */
public final class C1981xf extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ BaseSupportFragment f28531h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1981xf(BaseSupportFragment baseSupportFragment) {
        super("ENTRANCE_ON_ENDED");
        this.f28531h = baseSupportFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        this.f28531h.onEntranceTransitionEnd();
    }
}
