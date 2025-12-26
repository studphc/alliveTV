package p000;

import android.view.View;
import androidx.leanback.app.BaseSupportFragment;
import androidx.leanback.util.StateMachine;

/* renamed from: wf */
/* loaded from: classes.dex */
public final class C1944wf extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ BaseSupportFragment f28167h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1944wf(BaseSupportFragment baseSupportFragment) {
        super("STATE_ENTRANCE_PERFORM");
        this.f28167h = baseSupportFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        BaseSupportFragment baseSupportFragment = this.f28167h;
        baseSupportFragment.f4759C0.hide();
        View view = baseSupportFragment.getView();
        if (view != null) {
            view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC2055zf(baseSupportFragment, view));
            view.invalidate();
        }
    }
}
