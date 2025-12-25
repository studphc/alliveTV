package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* loaded from: classes.dex */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int CUSTOM = 7;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;

    /* renamed from: a */
    public float[] f2202a = new float[0];

    /* renamed from: b */
    public double[] f2203b = new double[0];

    /* renamed from: c */
    public double[] f2204c;

    /* renamed from: d */
    public MonotonicCurveFit f2205d;

    /* renamed from: e */
    public int f2206e;

    /* renamed from: a */
    public final double m445a(double d) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        if (d >= 1.0d) {
            return 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.f2203b, d);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        float[] fArr = this.f2202a;
        float f = fArr[binarySearch];
        int i = binarySearch - 1;
        float f2 = fArr[i];
        double d2 = f - f2;
        double[] dArr = this.f2203b;
        double d3 = dArr[binarySearch];
        double d4 = dArr[i];
        double d5 = d2 / (d3 - d4);
        return ((((d * d) - (d4 * d4)) * d5) / 2.0d) + ((d - d4) * (f2 - (d5 * d4))) + this.f2204c[i];
    }

    public void addPoint(double d, float f) {
        int length = this.f2202a.length + 1;
        int binarySearch = Arrays.binarySearch(this.f2203b, d);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.f2203b = Arrays.copyOf(this.f2203b, length);
        this.f2202a = Arrays.copyOf(this.f2202a, length);
        this.f2204c = new double[length];
        double[] dArr = this.f2203b;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.f2203b[binarySearch] = d;
        this.f2202a[binarySearch] = f;
    }

    public double getSlope(double d, double d2, double d3) {
        double d4;
        double m445a = m445a(d) + d2;
        if (d <= 0.0d) {
            d4 = 0.0d;
        } else if (d >= 1.0d) {
            d4 = 1.0d;
        } else {
            int binarySearch = Arrays.binarySearch(this.f2203b, d);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 1;
            }
            float[] fArr = this.f2202a;
            float f = fArr[binarySearch];
            int i = binarySearch - 1;
            float f2 = fArr[i];
            double d5 = f - f2;
            double[] dArr = this.f2203b;
            double d6 = dArr[binarySearch];
            double d7 = dArr[i];
            double d8 = d5 / (d6 - d7);
            d4 = (f2 - (d8 * d7)) + (d * d8);
        }
        double d9 = d4 + d3;
        switch (this.f2206e) {
            case 1:
                return 0.0d;
            case 2:
                return Math.signum((((m445a * 4.0d) + 3.0d) % 4.0d) - 2.0d) * d9 * 4.0d;
            case 3:
                return d9 * 2.0d;
            case 4:
                return (-d9) * 2.0d;
            case 5:
                return Math.sin(6.283185307179586d * m445a) * (-6.283185307179586d) * d9;
            case 6:
                return ((((m445a * 4.0d) + 2.0d) % 4.0d) - 2.0d) * d9 * 4.0d;
            case 7:
                return this.f2205d.getSlope(m445a % 1.0d, 0);
            default:
                return Math.cos(6.283185307179586d * m445a) * d9 * 6.283185307179586d;
        }
    }

    public double getValue(double d, double d2) {
        double abs;
        double m445a = m445a(d) + d2;
        switch (this.f2206e) {
            case 1:
                return Math.signum(0.5d - (m445a % 1.0d));
            case 2:
                abs = Math.abs((((m445a * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((m445a * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((m445a * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos((d2 + m445a) * 6.283185307179586d);
            case 6:
                double abs2 = 1.0d - Math.abs(((m445a * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            case 7:
                return this.f2205d.getPos(m445a % 1.0d, 0);
            default:
                return Math.sin(6.283185307179586d * m445a);
        }
        return 1.0d - abs;
    }

    public void normalize() {
        double d = 0.0d;
        int i = 0;
        while (true) {
            if (i >= this.f2202a.length) {
                break;
            }
            d += r6[i];
            i++;
        }
        int i2 = 1;
        double d2 = 0.0d;
        int i3 = 1;
        while (true) {
            float[] fArr = this.f2202a;
            if (i3 >= fArr.length) {
                break;
            }
            int i4 = i3 - 1;
            float f = (fArr[i4] + fArr[i3]) / 2.0f;
            double[] dArr = this.f2203b;
            d2 += (dArr[i3] - dArr[i4]) * f;
            i3++;
        }
        int i5 = 0;
        while (true) {
            float[] fArr2 = this.f2202a;
            if (i5 >= fArr2.length) {
                break;
            }
            fArr2[i5] = fArr2[i5] * ((float) (d / d2));
            i5++;
        }
        this.f2204c[0] = 0.0d;
        while (true) {
            float[] fArr3 = this.f2202a;
            if (i2 < fArr3.length) {
                int i6 = i2 - 1;
                float f2 = (fArr3[i6] + fArr3[i2]) / 2.0f;
                double[] dArr2 = this.f2203b;
                double d3 = dArr2[i2] - dArr2[i6];
                double[] dArr3 = this.f2204c;
                dArr3[i2] = (d3 * f2) + dArr3[i6];
                i2++;
            } else {
                return;
            }
        }
    }

    public void setType(int i, String str) {
        this.f2206e = i;
        if (str != null) {
            this.f2205d = MonotonicCurveFit.buildWave(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.f2203b) + " period=" + Arrays.toString(this.f2202a);
    }
}
