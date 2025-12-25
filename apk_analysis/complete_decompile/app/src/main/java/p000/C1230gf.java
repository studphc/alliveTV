package p000;

import androidx.leanback.app.BaseFragment;
import androidx.leanback.transition.TransitionListener;

/* renamed from: gf */
/* loaded from: classes.dex */
public final class C1230gf extends TransitionListener {

    /* renamed from: a */
    public final /* synthetic */ BaseFragment f17678a;

    public C1230gf(BaseFragment baseFragment) {
        this.f17678a = baseFragment;
    }

    @Override // androidx.leanback.transition.TransitionListener
    public final void onTransitionEnd(Object obj) {
        BaseFragment baseFragment = this.f17678a;
        baseFragment.f4755x = null;
        baseFragment.f4754w.fireEvent(baseFragment.f4752u);
    }
}
