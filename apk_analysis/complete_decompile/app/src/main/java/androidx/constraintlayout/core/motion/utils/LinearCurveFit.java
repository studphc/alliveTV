package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes.dex */
public class LinearCurveFit extends CurveFit {

    /* renamed from: a */
    public final double[] f2193a;

    /* renamed from: b */
    public final double[][] f2194b;

    /* renamed from: c */
    public final boolean f2195c = true;

    /* renamed from: d */
    public final double[] f2196d;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr2[0].length;
        this.f2196d = new double[length];
        this.f2193a = dArr;
        this.f2194b = dArr2;
        if (length > 2) {
            double d = 0.0d;
            int i = 0;
            while (true) {
                double d2 = d;
                if (i < dArr.length) {
                    double d3 = dArr2[i][0];
                    if (i > 0) {
                        Math.hypot(d3 - d, d3 - d2);
                    }
                    i++;
                    d = d3;
                } else {
                    return;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        double[] dArr2 = this.f2193a;
        int length = dArr2.length;
        double[][] dArr3 = this.f2194b;
        int i = 0;
        int length2 = dArr3[0].length;
        if (this.f2195c) {
            double d2 = dArr2[0];
            double[] dArr4 = this.f2196d;
            if (d <= d2) {
                getSlope(d2, dArr4);
                for (int i2 = 0; i2 < length2; i2++) {
                    dArr[i2] = ((d - dArr2[0]) * dArr4[i2]) + dArr3[0][i2];
                }
                return;
            }
            int i3 = length - 1;
            double d3 = dArr2[i3];
            if (d >= d3) {
                getSlope(d3, dArr4);
                while (i < length2) {
                    dArr[i] = ((d - dArr2[i3]) * dArr4[i]) + dArr3[i3][i];
                    i++;
                }
                return;
            }
        } else {
            if (d <= dArr2[0]) {
                for (int i4 = 0; i4 < length2; i4++) {
                    dArr[i4] = dArr3[0][i4];
                }
                return;
            }
            int i5 = length - 1;
            if (d >= dArr2[i5]) {
                while (i < length2) {
                    dArr[i] = dArr3[i5][i];
                    i++;
                }
                return;
            }
        }
        int i6 = 0;
        while (i6 < length - 1) {
            if (d == dArr2[i6]) {
                for (int i7 = 0; i7 < length2; i7++) {
                    dArr[i7] = dArr3[i6][i7];
                }
            }
            int i8 = i6 + 1;
            double d4 = dArr2[i8];
            if (d < d4) {
                double d5 = dArr2[i6];
                double d6 = (d - d5) / (d4 - d5);
                while (i < length2) {
                    dArr[i] = (dArr3[i8][i] * d6) + ((1.0d - d6) * dArr3[i6][i]);
                    i++;
                }
                return;
            }
            i6 = i8;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0017, code lost:
    
        if (r12 >= r5) goto L4;
     */
    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getSlope(double d, double[] dArr) {
        double[] dArr2 = this.f2193a;
        int length = dArr2.length;
        double[][] dArr3 = this.f2194b;
        int length2 = dArr3[0].length;
        double d2 = dArr2[0];
        if (d > d2) {
            d2 = dArr2[length - 1];
        }
        d = d2;
        int i = 0;
        while (i < length - 1) {
            int i2 = i + 1;
            double d3 = dArr2[i2];
            if (d <= d3) {
                double d4 = d3 - dArr2[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    dArr[i3] = (dArr3[i2][i3] - dArr3[i][i3]) / d4;
                }
                return;
            }
            i = i2;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.f2193a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0012, code lost:
    
        if (r8 >= r3) goto L4;
     */
    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double getSlope(double d, int i) {
        double[] dArr = this.f2193a;
        int length = dArr.length;
        int i2 = 0;
        double d2 = dArr[0];
        if (d >= d2) {
            d2 = dArr[length - 1];
        }
        d = d2;
        while (i2 < length - 1) {
            int i3 = i2 + 1;
            double d3 = dArr[i3];
            if (d <= d3) {
                double d4 = d3 - dArr[i2];
                double[][] dArr2 = this.f2194b;
                return (dArr2[i3][i] - dArr2[i2][i]) / d4;
            }
            i2 = i3;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        double[] dArr = this.f2193a;
        int length = dArr.length;
        double[][] dArr2 = this.f2194b;
        int i = 0;
        int length2 = dArr2[0].length;
        if (this.f2195c) {
            double d2 = dArr[0];
            double[] dArr3 = this.f2196d;
            if (d <= d2) {
                getSlope(d2, dArr3);
                for (int i2 = 0; i2 < length2; i2++) {
                    fArr[i2] = (float) (((d - dArr[0]) * dArr3[i2]) + dArr2[0][i2]);
                }
                return;
            }
            int i3 = length - 1;
            double d3 = dArr[i3];
            if (d >= d3) {
                getSlope(d3, dArr3);
                while (i < length2) {
                    fArr[i] = (float) (((d - dArr[i3]) * dArr3[i]) + dArr2[i3][i]);
                    i++;
                }
                return;
            }
        } else {
            if (d <= dArr[0]) {
                for (int i4 = 0; i4 < length2; i4++) {
                    fArr[i4] = (float) dArr2[0][i4];
                }
                return;
            }
            int i5 = length - 1;
            if (d >= dArr[i5]) {
                while (i < length2) {
                    fArr[i] = (float) dArr2[i5][i];
                    i++;
                }
                return;
            }
        }
        int i6 = 0;
        while (i6 < length - 1) {
            if (d == dArr[i6]) {
                for (int i7 = 0; i7 < length2; i7++) {
                    fArr[i7] = (float) dArr2[i6][i7];
                }
            }
            int i8 = i6 + 1;
            double d4 = dArr[i8];
            if (d < d4) {
                double d5 = dArr[i6];
                double d6 = (d - d5) / (d4 - d5);
                while (i < length2) {
                    fArr[i] = (float) ((dArr2[i8][i] * d6) + ((1.0d - d6) * dArr2[i6][i]));
                    i++;
                }
                return;
            }
            i6 = i8;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d, int i) {
        double d2;
        double d3;
        double slope;
        double[] dArr = this.f2193a;
        int length = dArr.length;
        boolean z = this.f2195c;
        double[][] dArr2 = this.f2194b;
        int i2 = 0;
        if (z) {
            double d4 = dArr[0];
            if (d <= d4) {
                d2 = dArr2[0][i];
                d3 = d - d4;
                slope = getSlope(d4, i);
            } else {
                int i3 = length - 1;
                double d5 = dArr[i3];
                if (d >= d5) {
                    d2 = dArr2[i3][i];
                    d3 = d - d5;
                    slope = getSlope(d5, i);
                }
            }
            return (slope * d3) + d2;
        }
        if (d <= dArr[0]) {
            return dArr2[0][i];
        }
        int i4 = length - 1;
        if (d >= dArr[i4]) {
            return dArr2[i4][i];
        }
        while (i2 < length - 1) {
            double d6 = dArr[i2];
            if (d == d6) {
                return dArr2[i2][i];
            }
            int i5 = i2 + 1;
            double d7 = dArr[i5];
            if (d < d7) {
                double d8 = (d - d6) / (d7 - d6);
                return (dArr2[i5][i] * d8) + ((1.0d - d8) * dArr2[i2][i]);
            }
            i2 = i5;
        }
        return 0.0d;
    }
}
