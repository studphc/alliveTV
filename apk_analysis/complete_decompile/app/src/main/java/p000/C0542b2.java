package p000;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: b2 */
/* loaded from: classes.dex */
public final class C0542b2 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ ViewGroup.MarginLayoutParams f7856a;

    /* renamed from: b */
    public final /* synthetic */ int f7857b;

    /* renamed from: c */
    public final /* synthetic */ float f7858c;

    /* renamed from: d */
    public final /* synthetic */ int f7859d;

    /* renamed from: e */
    public final /* synthetic */ float f7860e;

    /* renamed from: f */
    public final /* synthetic */ View f7861f;

    public C0542b2(ViewGroup.MarginLayoutParams marginLayoutParams, int i, float f, int i2, float f2, View view) {
        this.f7856a = marginLayoutParams;
        this.f7857b = i;
        this.f7858c = f;
        this.f7859d = i2;
        this.f7860e = f2;
        this.f7861f = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        int round = Math.round((this.f7858c * animatedFraction) + this.f7857b);
        ViewGroup.MarginLayoutParams marginLayoutParams = this.f7856a;
        marginLayoutParams.leftMargin = round;
        marginLayoutParams.width = Math.round((this.f7860e * animatedFraction) + this.f7859d);
        this.f7861f.requestLayout();
    }
}
