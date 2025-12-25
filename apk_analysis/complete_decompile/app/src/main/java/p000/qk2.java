package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Property;
import android.view.View;
import androidx.leanback.R;

/* loaded from: classes.dex */
public final class qk2 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public boolean f25633a = false;

    /* renamed from: b */
    public float f25634b;

    /* renamed from: c */
    public final View f25635c;

    /* renamed from: d */
    public final float f25636d;

    /* renamed from: e */
    public final float f25637e;

    /* renamed from: f */
    public final int f25638f;

    /* renamed from: g */
    public final Property f25639g;

    public qk2(View view, Property property, float f, float f2, int i) {
        this.f25639g = property;
        this.f25635c = view;
        this.f25637e = f;
        this.f25636d = f2;
        this.f25638f = i;
        view.setVisibility(0);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        View view = this.f25635c;
        view.setTag(R.id.lb_slide_transition_value, new float[]{view.getTranslationX(), view.getTranslationY()});
        this.f25639g.set(view, Float.valueOf(this.f25637e));
        this.f25633a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        boolean z = this.f25633a;
        View view = this.f25635c;
        if (!z) {
            this.f25639g.set(view, Float.valueOf(this.f25637e));
        }
        view.setVisibility(this.f25638f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        Property property = this.f25639g;
        View view = this.f25635c;
        this.f25634b = ((Float) property.get(view)).floatValue();
        property.set(view, Float.valueOf(this.f25636d));
        view.setVisibility(this.f25638f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        Float valueOf = Float.valueOf(this.f25634b);
        Property property = this.f25639g;
        View view = this.f25635c;
        property.set(view, valueOf);
        view.setVisibility(0);
    }
}
