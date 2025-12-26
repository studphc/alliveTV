package p000;

import android.view.ViewTreeObserver;
import androidx.leanback.app.OnboardingFragment;
import androidx.leanback.app.OnboardingSupportFragment;

/* loaded from: classes.dex */
public final class a12 implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a */
    public final /* synthetic */ int f20a;

    /* renamed from: b */
    public final /* synthetic */ Object f21b;

    public /* synthetic */ a12(int i, Object obj) {
        this.f20a = i;
        this.f21b = obj;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        switch (this.f20a) {
            case 0:
                OnboardingFragment onboardingFragment = (OnboardingFragment) this.f21b;
                onboardingFragment.getView().getViewTreeObserver().removeOnPreDrawListener(this);
                if (!onboardingFragment.m1314c()) {
                    onboardingFragment.f5054k = true;
                    onboardingFragment.onLogoAnimationFinished();
                }
                return true;
            default:
                OnboardingSupportFragment onboardingSupportFragment = (OnboardingSupportFragment) this.f21b;
                onboardingSupportFragment.getView().getViewTreeObserver().removeOnPreDrawListener(this);
                if (!onboardingSupportFragment.m1317n()) {
                    onboardingSupportFragment.f5089o0 = true;
                    onboardingSupportFragment.onLogoAnimationFinished();
                }
                return true;
        }
    }
}
