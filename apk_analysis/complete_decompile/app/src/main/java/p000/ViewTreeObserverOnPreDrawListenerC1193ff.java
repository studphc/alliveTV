package p000;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.leanback.app.BaseFragment;
import androidx.leanback.transition.TransitionHelper;

/* renamed from: ff */
/* loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC1193ff implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a */
    public final /* synthetic */ View f17238a;

    /* renamed from: b */
    public final /* synthetic */ BaseFragment f17239b;

    public ViewTreeObserverOnPreDrawListenerC1193ff(BaseFragment baseFragment, View view) {
        this.f17239b = baseFragment;
        this.f17238a = view;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.f17238a.getViewTreeObserver().removeOnPreDrawListener(this);
        BaseFragment baseFragment = this.f17239b;
        if (ou0.m6729a(baseFragment) != null && baseFragment.getView() != null) {
            Object createEntranceTransition = baseFragment.createEntranceTransition();
            baseFragment.f4755x = createEntranceTransition;
            if (createEntranceTransition != null) {
                TransitionHelper.addTransitionListener(createEntranceTransition, new C1230gf(baseFragment));
            }
            baseFragment.onEntranceTransitionStart();
            Object obj = baseFragment.f4755x;
            if (obj != null) {
                baseFragment.runEntranceTransition(obj);
                return false;
            }
            baseFragment.f4754w.fireEvent(baseFragment.f4752u);
            return false;
        }
        return true;
    }
}
