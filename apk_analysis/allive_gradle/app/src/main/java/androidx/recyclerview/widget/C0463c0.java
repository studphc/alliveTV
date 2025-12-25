package androidx.recyclerview.widget;

import android.animation.ValueAnimator;

/* renamed from: androidx.recyclerview.widget.c0 */
/* loaded from: classes.dex */
public final class C0463c0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ AbstractC0466d0 f7331a;

    public C0463c0(AbstractC0466d0 abstractC0466d0) {
        this.f7331a = abstractC0466d0;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f7331a.f7349m = valueAnimator.getAnimatedFraction();
    }
}
