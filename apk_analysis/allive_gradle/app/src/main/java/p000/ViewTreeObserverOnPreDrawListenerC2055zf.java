package p000;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.leanback.app.BaseSupportFragment;
import androidx.leanback.transition.TransitionHelper;

/* renamed from: zf */
/* loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC2055zf implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a */
    public final /* synthetic */ View f29344a;

    /* renamed from: b */
    public final /* synthetic */ BaseSupportFragment f29345b;

    public ViewTreeObserverOnPreDrawListenerC2055zf(BaseSupportFragment baseSupportFragment, View view) {
        this.f29345b = baseSupportFragment;
        this.f29344a = view;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.f29344a.getViewTreeObserver().removeOnPreDrawListener(this);
        BaseSupportFragment baseSupportFragment = this.f29345b;
        if (baseSupportFragment.getContext() != null && baseSupportFragment.getView() != null) {
            Object createEntranceTransition = baseSupportFragment.createEntranceTransition();
            baseSupportFragment.f4758B0 = createEntranceTransition;
            if (createEntranceTransition != null) {
                TransitionHelper.addTransitionListener(createEntranceTransition, new C0017ag(baseSupportFragment));
            }
            baseSupportFragment.onEntranceTransitionStart();
            Object obj = baseSupportFragment.f4758B0;
            if (obj != null) {
                baseSupportFragment.runEntranceTransition(obj);
                return false;
            }
            baseSupportFragment.f4757A0.fireEvent(baseSupportFragment.f4771y0);
            return false;
        }
        return true;
    }
}
