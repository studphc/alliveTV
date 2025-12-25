package p000;

import androidx.leanback.app.BaseSupportFragment;
import androidx.leanback.transition.TransitionListener;

/* renamed from: ag */
/* loaded from: classes.dex */
public final class C0017ag extends TransitionListener {

    /* renamed from: a */
    public final /* synthetic */ BaseSupportFragment f172a;

    public C0017ag(BaseSupportFragment baseSupportFragment) {
        this.f172a = baseSupportFragment;
    }

    @Override // androidx.leanback.transition.TransitionListener
    public final void onTransitionEnd(Object obj) {
        BaseSupportFragment baseSupportFragment = this.f172a;
        baseSupportFragment.f4758B0 = null;
        baseSupportFragment.f4757A0.fireEvent(baseSupportFragment.f4771y0);
    }
}
