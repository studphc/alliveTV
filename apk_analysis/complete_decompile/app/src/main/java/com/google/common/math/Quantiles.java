package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import p000.ye0;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class Quantiles {

    /* loaded from: classes2.dex */
    public static final class Scale {

        /* renamed from: a */
        public final int f15139a;

        public Scale(int i) {
            boolean z;
            if (i > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Quantile scale must be positive");
            this.f15139a = i;
        }

        public ScaleAndIndex index(int i) {
            return new ScaleAndIndex(this.f15139a, i);
        }

        public ScaleAndIndexes indexes(int... iArr) {
            return new ScaleAndIndexes(this.f15139a, (int[]) iArr.clone());
        }

        public ScaleAndIndexes indexes(Collection<Integer> collection) {
            return new ScaleAndIndexes(this.f15139a, Ints.toArray(collection));
        }
    }

    /* loaded from: classes2.dex */
    public static final class ScaleAndIndex {

        /* renamed from: a */
        public final int f15140a;

        /* renamed from: b */
        public final int f15141b;

        public ScaleAndIndex(int i, int i2) {
            Quantiles.m4212a(i2, i);
            this.f15140a = i;
            this.f15141b = i2;
        }

        public double compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public double computeInPlace(double... dArr) {
            boolean z;
            if (dArr.length > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Cannot calculate quantiles of an empty dataset");
            for (double d : dArr) {
                if (Double.isNaN(d)) {
                    return Double.NaN;
                }
            }
            long length = this.f15141b * (dArr.length - 1);
            int i = this.f15140a;
            long j = i;
            int divide = (int) LongMath.divide(length, j, RoundingMode.DOWN);
            int i2 = (int) (length - (divide * j));
            Quantiles.m4215d(divide, 0, dArr.length - 1, dArr);
            if (i2 == 0) {
                return dArr[divide];
            }
            int i3 = divide + 1;
            Quantiles.m4215d(i3, i3, dArr.length - 1, dArr);
            return Quantiles.m4213b(dArr[divide], dArr[i3], i2, i);
        }

        public double compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public double compute(long... jArr) {
            int length = jArr.length;
            double[] dArr = new double[length];
            for (int i = 0; i < length; i++) {
                dArr[i] = jArr[i];
            }
            return computeInPlace(dArr);
        }

        public double compute(int... iArr) {
            int length = iArr.length;
            double[] dArr = new double[length];
            for (int i = 0; i < length; i++) {
                dArr[i] = iArr[i];
            }
            return computeInPlace(dArr);
        }
    }

    /* loaded from: classes2.dex */
    public static final class ScaleAndIndexes {

        /* renamed from: a */
        public final int f15142a;

        /* renamed from: b */
        public final int[] f15143b;

        public ScaleAndIndexes(int i, int[] iArr) {
            for (int i2 : iArr) {
                Quantiles.m4212a(i2, i);
            }
            Preconditions.checkArgument(iArr.length > 0, "Indexes must be a non empty array");
            this.f15142a = i;
            this.f15143b = iArr;
        }

        public Map<Integer, Double> compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public Map<Integer, Double> computeInPlace(double... dArr) {
            boolean z;
            boolean z2;
            int i;
            double[] dArr2 = dArr;
            if (dArr2.length > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Cannot calculate quantiles of an empty dataset");
            int length = dArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    if (Double.isNaN(dArr2[i2])) {
                        z2 = true;
                        break;
                    }
                    i2++;
                } else {
                    z2 = false;
                    break;
                }
            }
            int[] iArr = this.f15143b;
            if (z2) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (int i3 : iArr) {
                    linkedHashMap.put(Integer.valueOf(i3), Double.valueOf(Double.NaN));
                }
                return Collections.unmodifiableMap(linkedHashMap);
            }
            int[] iArr2 = new int[iArr.length];
            int[] iArr3 = new int[iArr.length];
            int[] iArr4 = new int[iArr.length * 2];
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int length2 = iArr.length;
                i = this.f15142a;
                if (i4 >= length2) {
                    break;
                }
                long length3 = iArr[i4] * (dArr2.length - 1);
                long j = i;
                int divide = (int) LongMath.divide(length3, j, RoundingMode.DOWN);
                int[] iArr5 = iArr;
                int i6 = (int) (length3 - (divide * j));
                iArr2[i4] = divide;
                iArr3[i4] = i6;
                iArr4[i5] = divide;
                int i7 = i5 + 1;
                if (i6 != 0) {
                    iArr4[i7] = divide + 1;
                    i5 += 2;
                } else {
                    i5 = i7;
                }
                i4++;
                iArr = iArr5;
            }
            int[] iArr6 = iArr;
            int i8 = 0;
            Arrays.sort(iArr4, 0, i5);
            Quantiles.m4214c(iArr4, 0, i5 - 1, dArr, 0, dArr2.length - 1);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            while (i8 < iArr6.length) {
                int i9 = iArr2[i8];
                int i10 = iArr3[i8];
                if (i10 == 0) {
                    linkedHashMap2.put(Integer.valueOf(iArr6[i8]), Double.valueOf(dArr2[i9]));
                } else {
                    linkedHashMap2.put(Integer.valueOf(iArr6[i8]), Double.valueOf(Quantiles.m4213b(dArr2[i9], dArr2[i9 + 1], i10, i)));
                }
                i8++;
                dArr2 = dArr;
            }
            return Collections.unmodifiableMap(linkedHashMap2);
        }

        public Map<Integer, Double> compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public Map<Integer, Double> compute(long... jArr) {
            int length = jArr.length;
            double[] dArr = new double[length];
            for (int i = 0; i < length; i++) {
                dArr[i] = jArr[i];
            }
            return computeInPlace(dArr);
        }

        public Map<Integer, Double> compute(int... iArr) {
            int length = iArr.length;
            double[] dArr = new double[length];
            for (int i = 0; i < length; i++) {
                dArr[i] = iArr[i];
            }
            return computeInPlace(dArr);
        }
    }

    /* renamed from: a */
    public static void m4212a(int i, int i2) {
        if (i >= 0 && i <= i2) {
        } else {
            throw new IllegalArgumentException(ye0.m8290j(70, i2, "Quantile indexes must be between 0 and the scale, which is "));
        }
    }

    /* renamed from: b */
    public static double m4213b(double d, double d2, double d3, double d4) {
        if (d == Double.NEGATIVE_INFINITY) {
            return d2 == Double.POSITIVE_INFINITY ? Double.NaN : Double.NEGATIVE_INFINITY;
        }
        if (d2 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        return (((d2 - d) * d3) / d4) + d;
    }

    /* renamed from: c */
    public static void m4214c(int[] iArr, int i, int i2, double[] dArr, int i3, int i4) {
        int i5;
        if (i == i2) {
            i5 = i;
        } else {
            int i6 = i3 + i4;
            int i7 = i6 >>> 1;
            int i8 = i;
            i5 = i2;
            while (true) {
                if (i5 > i8 + 1) {
                    int i9 = (i8 + i5) >>> 1;
                    int i10 = iArr[i9];
                    if (i10 > i7) {
                        i5 = i9;
                    } else if (i10 < i7) {
                        i8 = i9;
                    } else {
                        i5 = i9;
                        break;
                    }
                } else if ((i6 - iArr[i8]) - iArr[i5] <= 0) {
                    i5 = i8;
                }
            }
        }
        int i11 = iArr[i5];
        m4215d(i11, i3, i4, dArr);
        int i12 = i5 - 1;
        while (i12 >= i && iArr[i12] == i11) {
            i12--;
        }
        if (i12 >= i) {
            m4214c(iArr, i, i12, dArr, i3, i11 - 1);
        }
        int i13 = i5 + 1;
        while (i13 <= i2 && iArr[i13] == i11) {
            i13++;
        }
        if (i13 <= i2) {
            m4214c(iArr, i13, i2, dArr, i11 + 1, i4);
        }
    }

    /* renamed from: d */
    public static void m4215d(int i, int i2, int i3, double[] dArr) {
        boolean z;
        boolean z2;
        if (i == i2) {
            int i4 = i2;
            for (int i5 = i2 + 1; i5 <= i3; i5++) {
                if (dArr[i4] > dArr[i5]) {
                    i4 = i5;
                }
            }
            if (i4 != i2) {
                double d = dArr[i4];
                dArr[i4] = dArr[i2];
                dArr[i2] = d;
                return;
            }
            return;
        }
        while (i3 > i2) {
            boolean z3 = true;
            int i6 = (i2 + i3) >>> 1;
            double d2 = dArr[i3];
            double d3 = dArr[i6];
            if (d2 < d3) {
                z = true;
            } else {
                z = false;
            }
            double d4 = dArr[i2];
            if (d3 < d4) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (d2 >= d4) {
                z3 = false;
            }
            if (z == z2) {
                dArr[i6] = d4;
                dArr[i2] = d3;
            } else if (z != z3) {
                dArr[i2] = d2;
                dArr[i3] = d4;
            }
            double d5 = dArr[i2];
            int i7 = i3;
            int i8 = i7;
            while (i7 > i2) {
                double d6 = dArr[i7];
                if (d6 > d5) {
                    double d7 = dArr[i8];
                    dArr[i8] = d6;
                    dArr[i7] = d7;
                    i8--;
                }
                i7--;
            }
            double d8 = dArr[i2];
            dArr[i2] = dArr[i8];
            dArr[i8] = d8;
            if (i8 >= i) {
                i3 = i8 - 1;
            }
            if (i8 <= i) {
                i2 = i8 + 1;
            }
        }
    }

    public static ScaleAndIndex median() {
        return scale(2).index(1);
    }

    public static Scale percentiles() {
        return scale(100);
    }

    public static Scale quartiles() {
        return scale(4);
    }

    public static Scale scale(int i) {
        return new Scale(i);
    }
}
