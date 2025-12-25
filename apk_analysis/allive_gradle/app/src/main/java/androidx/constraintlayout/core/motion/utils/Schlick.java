package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes.dex */
public class Schlick extends Easing {

    /* renamed from: c */
    public double f2207c;

    /* renamed from: d */
    public double f2208d;

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double get(double d) {
        double d2 = this.f2208d;
        double d3 = this.f2207c;
        if (d < d2) {
            return (d2 * d) / (((d2 - d) * d3) + d);
        }
        return ((d - 1.0d) * (1.0d - d2)) / ((1.0d - d) - ((d2 - d) * d3));
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double getDiff(double d) {
        double d2 = this.f2208d;
        double d3 = this.f2207c;
        if (d < d2) {
            double d4 = d3 * d2 * d2;
            double d5 = ((d2 - d) * d3) + d;
            return d4 / (d5 * d5);
        }
        double d6 = d2 - 1.0d;
        double d7 = (((d2 - d) * (-d3)) - d) + 1.0d;
        return ((d6 * d3) * d6) / (d7 * d7);
    }
}
