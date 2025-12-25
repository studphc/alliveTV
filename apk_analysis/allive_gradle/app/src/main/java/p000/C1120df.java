package p000;

import androidx.leanback.app.BaseFragment;
import androidx.leanback.util.StateMachine;

/* renamed from: df */
/* loaded from: classes.dex */
public final class C1120df extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ BaseFragment f16354h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1120df(BaseFragment baseFragment) {
        super("ENTRANCE_ON_ENDED");
        this.f16354h = baseFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        this.f16354h.onEntranceTransitionEnd();
    }
}
