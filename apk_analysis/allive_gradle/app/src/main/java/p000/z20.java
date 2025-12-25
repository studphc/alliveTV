package p000;

import androidx.leanback.app.DetailsFragment;
import androidx.leanback.transition.TransitionListener;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class z20 extends TransitionListener {

    /* renamed from: a */
    public final WeakReference f29226a;

    public z20(DetailsFragment detailsFragment) {
        this.f29226a = new WeakReference(detailsFragment);
    }

    @Override // androidx.leanback.transition.TransitionListener
    public final void onTransitionCancel(Object obj) {
        DetailsFragment detailsFragment = (DetailsFragment) this.f29226a.get();
        if (detailsFragment == null) {
            return;
        }
        detailsFragment.f4754w.fireEvent(detailsFragment.f4905K);
    }

    @Override // androidx.leanback.transition.TransitionListener
    public final void onTransitionEnd(Object obj) {
        DetailsFragment detailsFragment = (DetailsFragment) this.f29226a.get();
        if (detailsFragment == null) {
            return;
        }
        detailsFragment.f4754w.fireEvent(detailsFragment.f4905K);
    }

    @Override // androidx.leanback.transition.TransitionListener
    public final void onTransitionStart(Object obj) {
    }
}
