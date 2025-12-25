package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public class HyperSpline {

    /* renamed from: a */
    public int f2169a;

    /* renamed from: b */
    public Cubic[][] f2170b;

    /* renamed from: c */
    public int f2171c;

    /* renamed from: d */
    public double[] f2172d;

    /* renamed from: e */
    public double f2173e;

    /* renamed from: f */
    public double[][] f2174f;

    /* loaded from: classes.dex */
    public static class Cubic {

        /* renamed from: a */
        public final double f2175a;

        /* renamed from: b */
        public final double f2176b;

        /* renamed from: c */
        public final double f2177c;

        /* renamed from: d */
        public final double f2178d;

        public Cubic(double d, double d2, double d3, double d4) {
            this.f2175a = d;
            this.f2176b = d2;
            this.f2177c = d3;
            this.f2178d = d4;
        }

        public double eval(double d) {
            return (((((this.f2178d * d) + this.f2177c) * d) + this.f2176b) * d) + this.f2175a;
        }

        public double vel(double d) {
            return (((this.f2177c * 2.0d) + (this.f2178d * 3.0d * d)) * d) + this.f2176b;
        }
    }

    public HyperSpline(double[][] dArr) {
        setup(dArr);
    }

    public double approxLength(Cubic[] cubicArr) {
        int i;
        int length = cubicArr.length;
        double[] dArr = new double[length];
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        while (true) {
            i = 0;
            if (d2 >= 1.0d) {
                break;
            }
            double d4 = 0.0d;
            while (i < length) {
                double d5 = dArr[i];
                double eval = cubicArr[i].eval(d2);
                dArr[i] = eval;
                double d6 = d5 - eval;
                d4 += d6 * d6;
                i++;
            }
            if (d2 > 0.0d) {
                d3 += Math.sqrt(d4);
            }
            d2 += 0.1d;
        }
        while (i < length) {
            double d7 = dArr[i];
            double eval2 = cubicArr[i].eval(1.0d);
            dArr[i] = eval2;
            double d8 = d7 - eval2;
            d += d8 * d8;
            i++;
        }
        return Math.sqrt(d) + d3;
    }

    public void getPos(double d, double[] dArr) {
        double d2 = d * this.f2173e;
        int i = 0;
        while (true) {
            double[] dArr2 = this.f2172d;
            if (i >= dArr2.length - 1) {
                break;
            }
            double d3 = dArr2[i];
            if (d3 >= d2) {
                break;
            }
            d2 -= d3;
            i++;
        }
        for (int i2 = 0; i2 < dArr.length; i2++) {
            dArr[i2] = this.f2170b[i2][i].eval(d2 / this.f2172d[i]);
        }
    }

    public void getVelocity(double d, double[] dArr) {
        double d2 = d * this.f2173e;
        int i = 0;
        while (true) {
            double[] dArr2 = this.f2172d;
            if (i >= dArr2.length - 1) {
                break;
            }
            double d3 = dArr2[i];
            if (d3 >= d2) {
                break;
            }
            d2 -= d3;
            i++;
        }
        for (int i2 = 0; i2 < dArr.length; i2++) {
            dArr[i2] = this.f2170b[i2][i].vel(d2 / this.f2172d[i]);
        }
    }

    public void setup(double[][] dArr) {
        int i;
        int i2 = 0;
        int length = dArr[0].length;
        this.f2171c = length;
        int length2 = dArr.length;
        this.f2169a = length2;
        this.f2174f = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length2);
        this.f2170b = new Cubic[this.f2171c];
        for (int i3 = 0; i3 < this.f2171c; i3++) {
            for (int i4 = 0; i4 < this.f2169a; i4++) {
                this.f2174f[i3][i4] = dArr[i4][i3];
            }
        }
        int i5 = 0;
        while (true) {
            i = this.f2171c;
            if (i5 >= i) {
                break;
            }
            Cubic[][] cubicArr = this.f2170b;
            double[] dArr2 = this.f2174f[i5];
            int length3 = dArr2.length;
            double[] dArr3 = new double[length3];
            double[] dArr4 = new double[length3];
            double[] dArr5 = new double[length3];
            int i6 = length3 - 1;
            dArr3[i2] = 0.5d;
            for (int i7 = 1; i7 < i6; i7++) {
                dArr3[i7] = 1.0d / (4.0d - dArr3[i7 - 1]);
            }
            int i8 = length3 - 2;
            dArr3[i6] = 1.0d / (2.0d - dArr3[i8]);
            dArr4[i2] = (dArr2[1] - dArr2[i2]) * 3.0d * dArr3[i2];
            int i9 = 1;
            while (i9 < i6) {
                int i10 = i9 + 1;
                int i11 = i9 - 1;
                dArr4[i9] = (((dArr2[i10] - dArr2[i11]) * 3.0d) - dArr4[i11]) * dArr3[i9];
                i9 = i10;
            }
            double d = (((dArr2[i6] - dArr2[i8]) * 3.0d) - dArr4[i8]) * dArr3[i6];
            dArr4[i6] = d;
            dArr5[i6] = d;
            while (i8 >= 0) {
                dArr5[i8] = dArr4[i8] - (dArr3[i8] * dArr5[i8 + 1]);
                i8--;
            }
            Cubic[] cubicArr2 = new Cubic[i6];
            int i12 = i2;
            while (i12 < i6) {
                double d2 = dArr2[i12];
                double d3 = dArr5[i12];
                int i13 = i12 + 1;
                double d4 = dArr2[i13];
                double d5 = dArr5[i13];
                cubicArr2[i12] = new Cubic((float) d2, d3, (((d4 - d2) * 3.0d) - (d3 * 2.0d)) - d5, ((d2 - d4) * 2.0d) + d3 + d5);
                cubicArr = cubicArr;
                i12 = i13;
            }
            cubicArr[i5] = cubicArr2;
            i5++;
            i2 = 0;
        }
        this.f2172d = new double[this.f2169a - 1];
        this.f2173e = 0.0d;
        Cubic[] cubicArr3 = new Cubic[i];
        for (int i14 = 0; i14 < this.f2172d.length; i14++) {
            for (int i15 = 0; i15 < this.f2171c; i15++) {
                cubicArr3[i15] = this.f2170b[i15][i14];
            }
            double d6 = this.f2173e;
            double[] dArr6 = this.f2172d;
            double approxLength = approxLength(cubicArr3);
            dArr6[i14] = approxLength;
            this.f2173e = d6 + approxLength;
        }
    }

    public HyperSpline() {
    }

    public void getPos(double d, float[] fArr) {
        double d2 = d * this.f2173e;
        int i = 0;
        while (true) {
            double[] dArr = this.f2172d;
            if (i >= dArr.length - 1) {
                break;
            }
            double d3 = dArr[i];
            if (d3 >= d2) {
                break;
            }
            d2 -= d3;
            i++;
        }
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = (float) this.f2170b[i2][i].eval(d2 / this.f2172d[i]);
        }
    }

    public double getPos(double d, int i) {
        double[] dArr;
        double d2 = d * this.f2173e;
        int i2 = 0;
        while (true) {
            dArr = this.f2172d;
            if (i2 >= dArr.length - 1) {
                break;
            }
            double d3 = dArr[i2];
            if (d3 >= d2) {
                break;
            }
            d2 -= d3;
            i2++;
        }
        return this.f2170b[i][i2].eval(d2 / dArr[i2]);
    }
}
