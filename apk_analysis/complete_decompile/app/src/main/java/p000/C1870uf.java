package p000;

import androidx.leanback.app.BaseSupportFragment;
import androidx.leanback.util.StateMachine;

/* renamed from: uf */
/* loaded from: classes.dex */
public final class C1870uf extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ BaseSupportFragment f27245h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1870uf(BaseSupportFragment baseSupportFragment) {
        super("ENTRANCE_ON_PREPARED", true, false);
        this.f27245h = baseSupportFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        this.f27245h.f4759C0.show();
    }
}
