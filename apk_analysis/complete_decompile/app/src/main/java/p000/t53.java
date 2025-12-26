package p000;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.PathInterpolator;
import androidx.core.graphics.Insets;
import androidx.core.view.C0211i;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Collections;

/* loaded from: classes.dex */
public final class t53 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ WindowInsetsAnimationCompat f26700a;

    /* renamed from: b */
    public final /* synthetic */ WindowInsetsCompat f26701b;

    /* renamed from: c */
    public final /* synthetic */ WindowInsetsCompat f26702c;

    /* renamed from: d */
    public final /* synthetic */ int f26703d;

    /* renamed from: e */
    public final /* synthetic */ View f26704e;

    public t53(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, int i, View view) {
        this.f26700a = windowInsetsAnimationCompat;
        this.f26701b = windowInsetsCompat;
        this.f26702c = windowInsetsCompat2;
        this.f26703d = i;
        this.f26704e = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f;
        WindowInsetsAnimationCompat windowInsetsAnimationCompat;
        float animatedFraction = valueAnimator.getAnimatedFraction();
        WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = this.f26700a;
        windowInsetsAnimationCompat2.setFraction(animatedFraction);
        float interpolatedFraction = windowInsetsAnimationCompat2.getInterpolatedFraction();
        PathInterpolator pathInterpolator = C0211i.f3987f;
        WindowInsetsCompat windowInsetsCompat = this.f26701b;
        WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(windowInsetsCompat);
        int i = 1;
        while (i <= 256) {
            if ((this.f26703d & i) == 0) {
                builder.setInsets(i, windowInsetsCompat.getInsets(i));
                f = interpolatedFraction;
                windowInsetsAnimationCompat = windowInsetsAnimationCompat2;
            } else {
                Insets insets = windowInsetsCompat.getInsets(i);
                Insets insets2 = this.f26702c.getInsets(i);
                int i2 = (int) (((insets.left - insets2.left) * r10) + 0.5d);
                int i3 = (int) (((insets.top - insets2.top) * r10) + 0.5d);
                f = interpolatedFraction;
                int i4 = (int) (((insets.right - insets2.right) * r10) + 0.5d);
                float f2 = (insets.bottom - insets2.bottom) * (1.0f - interpolatedFraction);
                windowInsetsAnimationCompat = windowInsetsAnimationCompat2;
                builder.setInsets(i, WindowInsetsCompat.m918a(insets, i2, i3, i4, (int) (f2 + 0.5d)));
            }
            i <<= 1;
            interpolatedFraction = f;
            windowInsetsAnimationCompat2 = windowInsetsAnimationCompat;
        }
        C0211i.m953i(this.f26704e, builder.build(), Collections.singletonList(windowInsetsAnimationCompat2));
    }
}
