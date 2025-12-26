package p000;

import android.animation.Animator;

/* loaded from: classes.dex */
public final class k20 implements Animator.AnimatorListener {

    /* renamed from: a */
    public final /* synthetic */ m20 f20724a;

    public k20(m20 m20Var) {
        this.f20724a = m20Var;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f20724a.f22773d = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
