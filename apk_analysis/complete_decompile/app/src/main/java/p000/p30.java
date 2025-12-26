package p000;

import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.transition.TransitionListener;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class p30 extends TransitionListener {

    /* renamed from: a */
    public final WeakReference f25020a;

    public p30(DetailsSupportFragment detailsSupportFragment) {
        this.f25020a = new WeakReference(detailsSupportFragment);
    }

    @Override // androidx.leanback.transition.TransitionListener
    public final void onTransitionCancel(Object obj) {
        DetailsSupportFragment detailsSupportFragment = (DetailsSupportFragment) this.f25020a.get();
        if (detailsSupportFragment == null) {
            return;
        }
        detailsSupportFragment.f4757A0.fireEvent(detailsSupportFragment.f4946O0);
    }

    @Override // androidx.leanback.transition.TransitionListener
    public final void onTransitionEnd(Object obj) {
        DetailsSupportFragment detailsSupportFragment = (DetailsSupportFragment) this.f25020a.get();
        if (detailsSupportFragment == null) {
            return;
        }
        detailsSupportFragment.f4757A0.fireEvent(detailsSupportFragment.f4946O0);
    }

    @Override // androidx.leanback.transition.TransitionListener
    public final void onTransitionStart(Object obj) {
    }
}
