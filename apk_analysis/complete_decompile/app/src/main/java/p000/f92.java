package p000;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public final class f92 implements Interpolator {

    /* renamed from: a */
    public final /* synthetic */ int f17184a;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        switch (this.f17184a) {
            case 0:
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            case 1:
                float f3 = f - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            default:
                float f4 = f - 1.0f;
                return (f4 * f4 * f4 * f4 * f4) + 1.0f;
        }
    }
}
