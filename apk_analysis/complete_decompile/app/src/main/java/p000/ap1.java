package p000;

import androidx.constraintlayout.core.motion.utils.DifferentialInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;

/* loaded from: classes.dex */
public final class ap1 implements DifferentialInterpolator {

    /* renamed from: a */
    public float f7696a;

    /* renamed from: b */
    public final /* synthetic */ Easing f7697b;

    public ap1(Easing easing) {
        this.f7697b = easing;
    }

    @Override // androidx.constraintlayout.core.motion.utils.DifferentialInterpolator
    public final float getInterpolation(float f) {
        this.f7696a = f;
        return (float) this.f7697b.get(f);
    }

    @Override // androidx.constraintlayout.core.motion.utils.DifferentialInterpolator
    public final float getVelocity() {
        return (float) this.f7697b.getDiff(this.f7696a);
    }
}
