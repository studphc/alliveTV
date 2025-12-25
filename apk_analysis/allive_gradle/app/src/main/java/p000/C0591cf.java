package p000;

import android.view.View;
import androidx.leanback.app.BaseFragment;
import androidx.leanback.util.StateMachine;

/* renamed from: cf */
/* loaded from: classes.dex */
public final class C0591cf extends StateMachine.State {

    /* renamed from: h */
    public final /* synthetic */ BaseFragment f8350h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0591cf(BaseFragment baseFragment) {
        super("STATE_ENTRANCE_PERFORM");
        this.f8350h = baseFragment;
    }

    @Override // androidx.leanback.util.StateMachine.State
    public final void run() {
        BaseFragment baseFragment = this.f8350h;
        baseFragment.f4756y.hide();
        View view = baseFragment.getView();
        if (view != null) {
            view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC1193ff(baseFragment, view));
            view.invalidate();
        }
    }
}
