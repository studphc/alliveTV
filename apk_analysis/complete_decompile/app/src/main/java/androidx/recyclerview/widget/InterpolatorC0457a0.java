package androidx.recyclerview.widget;

import android.view.animation.Interpolator;

/* renamed from: androidx.recyclerview.widget.a0 */
/* loaded from: classes.dex */
public final class InterpolatorC0457a0 implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }
}
