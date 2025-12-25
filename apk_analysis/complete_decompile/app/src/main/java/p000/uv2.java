package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.transition.Transition;
import android.view.View;
import androidx.leanback.R;

/* loaded from: classes.dex */
public final class uv2 extends AnimatorListenerAdapter implements Transition.TransitionListener {

    /* renamed from: a */
    public final View f27484a;

    /* renamed from: b */
    public final View f27485b;

    /* renamed from: c */
    public final int f27486c;

    /* renamed from: d */
    public final int f27487d;

    /* renamed from: e */
    public int[] f27488e;

    /* renamed from: f */
    public float f27489f;

    /* renamed from: g */
    public float f27490g;

    /* renamed from: h */
    public final float f27491h;

    /* renamed from: i */
    public final float f27492i;

    public uv2(View view, View view2, int i, int i2, float f, float f2) {
        this.f27485b = view;
        this.f27484a = view2;
        this.f27486c = i - Math.round(view.getTranslationX());
        this.f27487d = i2 - Math.round(view.getTranslationY());
        this.f27491h = f;
        this.f27492i = f2;
        int i3 = R.id.transitionPosition;
        int[] iArr = (int[]) view2.getTag(i3);
        this.f27488e = iArr;
        if (iArr != null) {
            view2.setTag(i3, null);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        if (this.f27488e == null) {
            this.f27488e = new int[2];
        }
        int[] iArr = this.f27488e;
        float f = this.f27486c;
        View view = this.f27485b;
        iArr[0] = Math.round(view.getTranslationX() + f);
        this.f27488e[1] = Math.round(view.getTranslationY() + this.f27487d);
        this.f27484a.setTag(R.id.transitionPosition, this.f27488e);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        View view = this.f27485b;
        this.f27489f = view.getTranslationX();
        this.f27490g = view.getTranslationY();
        view.setTranslationX(this.f27491h);
        view.setTranslationY(this.f27492i);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        float f = this.f27489f;
        View view = this.f27485b;
        view.setTranslationX(f);
        view.setTranslationY(this.f27490g);
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        float f = this.f27491h;
        View view = this.f27485b;
        view.setTranslationX(f);
        view.setTranslationY(this.f27492i);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
    }
}
