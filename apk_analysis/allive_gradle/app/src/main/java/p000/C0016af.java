package p000;

import androidx.leanback.app.BaseFragment;
import androidx.leanback.util.StateMachine;

/* renamed from: af */
/* loaded from: classes.dex */
public final class C0016af extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ BaseFragment f159h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0016af(BaseFragment baseFragment) {
        super("ENTRANCE_ON_PREPARED", true, false);
        this.f159h = baseFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        this.f159h.f4756y.show();
    }
}
