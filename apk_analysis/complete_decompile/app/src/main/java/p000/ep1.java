package p000;

import android.view.animation.Interpolator;
import androidx.constraintlayout.core.motion.utils.Easing;

/* loaded from: classes.dex */
public final class ep1 implements Interpolator {

    /* renamed from: a */
    public final /* synthetic */ int f16942a;

    /* renamed from: b */
    public final /* synthetic */ Easing f16943b;

    public /* synthetic */ ep1(Easing easing, int i) {
        this.f16942a = i;
        this.f16943b = easing;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        switch (this.f16942a) {
            case 0:
                return (float) this.f16943b.get(f);
            case 1:
                return (float) this.f16943b.get(f);
            default:
                return (float) this.f16943b.get(f);
        }
    }
}
