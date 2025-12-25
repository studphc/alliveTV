package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes.dex */
public class StepCurve extends Easing {

    /* renamed from: c */
    public MonotonicCurveFit f2224c;

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double get(double d) {
        return this.f2224c.getPos(d, 0);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double getDiff(double d) {
        return this.f2224c.getSlope(d, 0);
    }
}
