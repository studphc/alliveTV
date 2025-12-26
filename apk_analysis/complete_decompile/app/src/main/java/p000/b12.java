package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import androidx.core.view.C0211i;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.leanback.app.OnboardingFragment;
import androidx.leanback.app.OnboardingSupportFragment;

/* loaded from: classes.dex */
public final class b12 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ int f7851a;

    /* renamed from: b */
    public final /* synthetic */ Object f7852b;

    /* renamed from: c */
    public final /* synthetic */ Object f7853c;

    public /* synthetic */ b12(Object obj, Context context, int i) {
        this.f7851a = i;
        this.f7853c = obj;
        this.f7852b = context;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f7851a) {
            case 2:
                ((ViewPropertyAnimatorListener) this.f7852b).onAnimationCancel((View) this.f7853c);
                return;
            default:
                super.onAnimationCancel(animator);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f7851a) {
            case 0:
                if (((Context) this.f7852b) != null) {
                    OnboardingFragment onboardingFragment = (OnboardingFragment) this.f7853c;
                    onboardingFragment.f5054k = true;
                    onboardingFragment.onLogoAnimationFinished();
                    return;
                }
                return;
            case 1:
                if (((Context) this.f7852b) != null) {
                    OnboardingSupportFragment onboardingSupportFragment = (OnboardingSupportFragment) this.f7853c;
                    onboardingSupportFragment.f5089o0 = true;
                    onboardingSupportFragment.onLogoAnimationFinished();
                    return;
                }
                return;
            case 2:
                ((ViewPropertyAnimatorListener) this.f7852b).onAnimationEnd((View) this.f7853c);
                return;
            default:
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = (WindowInsetsAnimationCompat) this.f7852b;
                windowInsetsAnimationCompat.setFraction(1.0f);
                C0211i.m951g((View) this.f7853c, windowInsetsAnimationCompat);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f7851a) {
            case 2:
                ((ViewPropertyAnimatorListener) this.f7852b).onAnimationStart((View) this.f7853c);
                return;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }

    public /* synthetic */ b12(Object obj, View view, int i) {
        this.f7851a = i;
        this.f7852b = obj;
        this.f7853c = view;
    }
}
