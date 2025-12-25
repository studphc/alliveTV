package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.ArrayList;

/* renamed from: androidx.vectordrawable.graphics.drawable.b */
/* loaded from: classes.dex */
public final class C0522b extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ AnimatedVectorDrawableCompat f7567a;

    public C0522b(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        this.f7567a = animatedVectorDrawableCompat;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = this.f7567a;
        ArrayList arrayList = new ArrayList(animatedVectorDrawableCompat.f7552e);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animatable2Compat.AnimationCallback) arrayList.get(i)).onAnimationEnd(animatedVectorDrawableCompat);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = this.f7567a;
        ArrayList arrayList = new ArrayList(animatedVectorDrawableCompat.f7552e);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animatable2Compat.AnimationCallback) arrayList.get(i)).onAnimationStart(animatedVectorDrawableCompat);
        }
    }
}
