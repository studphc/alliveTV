package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.leanback.app.OnboardingFragment;

/* loaded from: classes.dex */
public final class c12 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ int f8229a;

    /* renamed from: b */
    public final /* synthetic */ Object f8230b;

    public /* synthetic */ c12(int i, Object obj) {
        this.f8229a = i;
        this.f8230b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f8229a) {
            case 3:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f8230b;
                actionBarOverlayLayout.f1067w = null;
                actionBarOverlayLayout.f1054j = false;
                return;
            default:
                super.onAnimationCancel(animator);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f8229a) {
            case 0:
                ((OnboardingFragment) this.f8230b).f5055l = true;
                return;
            case 1:
                ((OnboardingFragment) this.f8230b).f5045b.setVisibility(8);
                return;
            case 2:
                ((OnboardingFragment) this.f8230b).f5046c.setVisibility(8);
                return;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f8230b;
                actionBarOverlayLayout.f1067w = null;
                actionBarOverlayLayout.f1054j = false;
                return;
        }
    }
}
