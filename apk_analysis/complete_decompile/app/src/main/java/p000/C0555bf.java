package p000;

import androidx.leanback.app.BaseFragment;
import androidx.leanback.util.StateMachine;

/* renamed from: bf */
/* loaded from: classes.dex */
public final class C0555bf extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ BaseFragment f7990h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0555bf(BaseFragment baseFragment) {
        super("ENTRANCE_ON_PREPARED_ON_CREATEVIEW");
        this.f7990h = baseFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        this.f7990h.onEntranceTransitionPrepare();
    }
}
