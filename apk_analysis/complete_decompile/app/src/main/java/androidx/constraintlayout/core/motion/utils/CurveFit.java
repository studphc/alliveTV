package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes.dex */
public abstract class CurveFit {
    public static final int CONSTANT = 2;
    public static final int LINEAR = 1;
    public static final int SPLINE = 0;

    /* JADX WARN: Type inference failed for: r3v3, types: [bx, androidx.constraintlayout.core.motion.utils.CurveFit] */
    public static CurveFit get(int i, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i = 2;
        }
        if (i != 0) {
            if (i != 2) {
                return new LinearCurveFit(dArr, dArr2);
            }
            double d = dArr[0];
            double[] dArr3 = dArr2[0];
            ?? curveFit = new CurveFit();
            curveFit.f8171a = d;
            curveFit.f8172b = dArr3;
            return curveFit;
        }
        return new MonotonicCurveFit(dArr, dArr2);
    }

    public static CurveFit getArc(int[] iArr, double[] dArr, double[][] dArr2) {
        return new ArcCurveFit(iArr, dArr, dArr2);
    }

    public abstract double getPos(double d, int i);

    public abstract void getPos(double d, double[] dArr);

    public abstract void getPos(double d, float[] fArr);

    public abstract double getSlope(double d, int i);

    public abstract void getSlope(double d, double[] dArr);

    public abstract double[] getTimePoints();
}
