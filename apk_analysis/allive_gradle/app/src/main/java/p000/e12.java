package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.leanback.app.OnboardingSupportFragment;

/* loaded from: classes.dex */
public final class e12 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ int f16646a;

    /* renamed from: b */
    public final /* synthetic */ OnboardingSupportFragment f16647b;

    public /* synthetic */ e12(OnboardingSupportFragment onboardingSupportFragment, int i) {
        this.f16646a = i;
        this.f16647b = onboardingSupportFragment;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f16646a) {
            case 0:
                this.f16647b.f5090p0 = true;
                return;
            case 1:
                this.f16647b.f5080f0.setVisibility(8);
                return;
            default:
                this.f16647b.f5081g0.setVisibility(8);
                return;
        }
    }
}
