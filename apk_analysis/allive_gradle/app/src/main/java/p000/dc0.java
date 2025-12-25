package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.recyclerview.widget.C0504s;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class dc0 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public boolean f16341a = false;

    /* renamed from: b */
    public final /* synthetic */ C0504s f16342b;

    public dc0(C0504s c0504s) {
        this.f16342b = c0504s;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f16341a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (this.f16341a) {
            this.f16341a = false;
            return;
        }
        C0504s c0504s = this.f16342b;
        if (((Float) c0504s.f7498z.getAnimatedValue()).floatValue() == RecyclerView.f7068F0) {
            c0504s.f7471A = 0;
            c0504s.m1887d(0);
        } else {
            c0504s.f7471A = 2;
            c0504s.f7491s.invalidate();
        }
    }
}
