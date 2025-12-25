package androidx.recyclerview.widget;

import android.view.animation.Interpolator;

/* renamed from: androidx.recyclerview.widget.z */
/* loaded from: classes.dex */
public final class InterpolatorC0518z implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        return f * f * f * f * f;
    }
}
