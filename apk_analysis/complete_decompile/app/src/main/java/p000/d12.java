package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import androidx.leanback.app.OnboardingFragment;
import androidx.leanback.app.OnboardingSupportFragment;

/* loaded from: classes.dex */
public final class d12 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ int f16210a;

    /* renamed from: b */
    public final /* synthetic */ int f16211b;

    /* renamed from: c */
    public final /* synthetic */ Object f16212c;

    public /* synthetic */ d12(int i, int i2, Object obj) {
        this.f16210a = i2;
        this.f16212c = obj;
        this.f16211b = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f16210a) {
            case 0:
                OnboardingFragment onboardingFragment = (OnboardingFragment) this.f16212c;
                TextView textView = onboardingFragment.f5050g;
                int i = this.f16211b;
                textView.setText(onboardingFragment.getPageTitle(i));
                onboardingFragment.f5051h.setText(onboardingFragment.getPageDescription(i));
                return;
            default:
                OnboardingSupportFragment onboardingSupportFragment = (OnboardingSupportFragment) this.f16212c;
                TextView textView2 = onboardingSupportFragment.f5085k0;
                int i2 = this.f16211b;
                textView2.setText(onboardingSupportFragment.getPageTitle(i2));
                onboardingSupportFragment.f5086l0.setText(onboardingSupportFragment.getPageDescription(i2));
                return;
        }
    }
}
