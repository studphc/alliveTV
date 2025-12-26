package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;
import p000.C1902va;

/* loaded from: classes.dex */
public class ArcCurveFit extends CurveFit {
    public static final int ARC_ABOVE = 5;
    public static final int ARC_BELOW = 4;
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;

    /* renamed from: a */
    public final double[] f2164a;

    /* renamed from: b */
    public final C1902va[] f2165b;

    /* renamed from: c */
    public final boolean f2166c = true;

    /* JADX WARN: Code restructure failed: missing block: B:91:0x0032, code lost:
    
        if (r5 == r2) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Object, va] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArcCurveFit(int[] iArr, double[] dArr, double[][] dArr2) {
        boolean z;
        boolean z2;
        boolean z3;
        C1902va[] c1902vaArr;
        C1902va c1902va;
        boolean z4;
        int i;
        int i2;
        double d;
        double[] dArr3;
        boolean z5;
        boolean z6;
        ArcCurveFit arcCurveFit = this;
        double[] dArr4 = dArr;
        ?? r2 = 1;
        arcCurveFit.f2164a = dArr4;
        arcCurveFit.f2165b = new C1902va[dArr4.length - 1];
        char c = 0;
        boolean z7 = true;
        boolean z8 = true;
        int i3 = 0;
        while (true) {
            C1902va[] c1902vaArr2 = arcCurveFit.f2165b;
            if (i3 < c1902vaArr2.length) {
                int i4 = iArr[i3];
                if (i4 != 0) {
                    if (i4 != r2) {
                        z2 = z7;
                        z = z8;
                        if (i4 != 2) {
                            if (i4 != 3) {
                                if (i4 != 4) {
                                    if (i4 == 5) {
                                        z = 5;
                                        z2 = z7;
                                    }
                                } else {
                                    z = 4;
                                    z2 = z7;
                                }
                            }
                        }
                        z6 = 2;
                        z = z6;
                        z2 = z6;
                    }
                    z6 = r2;
                    z = z6;
                    z2 = z6;
                } else {
                    z = 3;
                    z2 = z7;
                }
                double d2 = dArr4[i3];
                int i5 = i3 + 1;
                double d3 = dArr4[i5];
                double[] dArr5 = dArr2[i3];
                double d4 = dArr5[c];
                double d5 = dArr5[r2];
                double[] dArr6 = dArr2[i5];
                double d6 = dArr6[c];
                int i6 = i3;
                double d7 = dArr6[r2];
                ?? obj = new Object();
                obj.f27711r = false;
                double d8 = d6 - d4;
                double d9 = d7 - d5;
                if (z != r2) {
                    if (z != 4) {
                        if (z != 5) {
                            obj.f27710q = false;
                        } else {
                            obj.f27710q = d9 < 0.0d ? r2 : false;
                        }
                    } else {
                        if (d9 > 0.0d) {
                            z5 = r2;
                        } else {
                            z5 = false;
                        }
                        obj.f27710q = z5;
                    }
                } else {
                    obj.f27710q = r2;
                }
                obj.f27696c = d2;
                boolean z9 = z2;
                obj.f27697d = d3;
                double d10 = d3 - d2;
                double d11 = 1.0d / d10;
                obj.f27702i = d11;
                if (3 == z) {
                    obj.f27711r = true;
                }
                if (obj.f27711r || Math.abs(d8) < 0.001d || Math.abs(d9) < 0.001d) {
                    z3 = z ? 1 : 0;
                    c1902vaArr = c1902vaArr2;
                    c1902va = obj;
                    z4 = true;
                    c1902va.f27711r = true;
                    c1902va.f27698e = d4;
                    c1902va.f27699f = d6;
                    c1902va.f27700g = d5;
                    c1902va.f27701h = d7;
                    double hypot = Math.hypot(d9, d8);
                    c1902va.f27695b = hypot;
                    c1902va.f27707n = hypot * d11;
                    c1902va.f27705l = d8 / d10;
                    c1902va.f27706m = d9 / d10;
                } else {
                    obj.f27694a = new double[101];
                    boolean z10 = obj.f27710q;
                    if (z10) {
                        i = -1;
                    } else {
                        i = 1;
                    }
                    obj.f27703j = i * d8;
                    if (z10) {
                        i2 = 1;
                    } else {
                        i2 = -1;
                    }
                    obj.f27704k = d9 * i2;
                    obj.f27705l = z10 ? d6 : d4;
                    if (z10) {
                        d = d5;
                    } else {
                        d = d7;
                    }
                    obj.f27706m = d;
                    double d12 = d5 - d7;
                    double d13 = 0.0d;
                    double d14 = 0.0d;
                    double d15 = 0.0d;
                    int i7 = 0;
                    boolean z11 = z;
                    C1902va c1902va2 = obj;
                    while (true) {
                        dArr3 = C1902va.f27693s;
                        z3 = z11;
                        if (i7 >= 91) {
                            break;
                        }
                        C1902va[] c1902vaArr3 = c1902vaArr2;
                        C1902va c1902va3 = c1902va2;
                        double d16 = d13;
                        double radians = Math.toRadians((i7 * 90.0d) / 90);
                        double sin = Math.sin(radians) * d8;
                        double cos = Math.cos(radians) * d12;
                        if (i7 > 0) {
                            double hypot2 = Math.hypot(sin - d14, cos - d15) + d16;
                            dArr3[i7] = hypot2;
                            d16 = hypot2;
                        }
                        i7++;
                        d15 = cos;
                        d14 = sin;
                        d13 = d16;
                        z11 = z3;
                        c1902vaArr2 = c1902vaArr3;
                        c1902va2 = c1902va3;
                    }
                    c1902vaArr = c1902vaArr2;
                    c1902va = c1902va2;
                    c1902va.f27695b = d13;
                    for (int i8 = 0; i8 < 91; i8++) {
                        dArr3[i8] = dArr3[i8] / d13;
                    }
                    int i9 = 0;
                    while (true) {
                        double[] dArr7 = c1902va.f27694a;
                        if (i9 >= dArr7.length) {
                            break;
                        }
                        double[] dArr8 = dArr3;
                        double length = i9 / (dArr7.length - 1);
                        int binarySearch = Arrays.binarySearch(dArr8, length);
                        if (binarySearch >= 0) {
                            dArr7[i9] = binarySearch / 90;
                        } else if (binarySearch == -1) {
                            dArr7[i9] = 0.0d;
                        } else {
                            int i10 = -binarySearch;
                            int i11 = i10 - 2;
                            double d17 = dArr8[i11];
                            dArr7[i9] = (((length - d17) / (dArr8[i10 - 1] - d17)) + i11) / 90;
                        }
                        i9++;
                        dArr3 = dArr8;
                    }
                    c1902va.f27707n = c1902va.f27695b * c1902va.f27702i;
                    z4 = true;
                }
                c1902vaArr[i6] = c1902va;
                arcCurveFit = this;
                dArr4 = dArr;
                r2 = z4;
                z7 = z9;
                i3 = i5;
                z8 = z3;
                c = 0;
            } else {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        boolean z = this.f2166c;
        C1902va[] c1902vaArr = this.f2165b;
        if (z) {
            C1902va c1902va = c1902vaArr[0];
            double d2 = c1902va.f27696c;
            if (d < d2) {
                double d3 = d - d2;
                if (c1902va.f27711r) {
                    double m7881c = c1902va.m7881c(d2);
                    C1902va c1902va2 = c1902vaArr[0];
                    dArr[0] = (c1902va2.f27705l * d3) + m7881c;
                    dArr[1] = (d3 * c1902vaArr[0].f27706m) + c1902va2.m7882d(d2);
                    return;
                }
                c1902va.m7885g(d2);
                dArr[0] = (c1902vaArr[0].m7879a() * d3) + c1902vaArr[0].m7883e();
                dArr[1] = (c1902vaArr[0].m7880b() * d3) + c1902vaArr[0].m7884f();
                return;
            }
            if (d > c1902vaArr[c1902vaArr.length - 1].f27697d) {
                double d4 = c1902vaArr[c1902vaArr.length - 1].f27697d;
                double d5 = d - d4;
                int length = c1902vaArr.length - 1;
                C1902va c1902va3 = c1902vaArr[length];
                if (c1902va3.f27711r) {
                    double m7881c2 = c1902va3.m7881c(d4);
                    C1902va c1902va4 = c1902vaArr[length];
                    dArr[0] = (c1902va4.f27705l * d5) + m7881c2;
                    dArr[1] = (d5 * c1902vaArr[length].f27706m) + c1902va4.m7882d(d4);
                    return;
                }
                c1902va3.m7885g(d);
                dArr[0] = (c1902vaArr[length].m7879a() * d5) + c1902vaArr[length].m7883e();
                dArr[1] = (c1902vaArr[length].m7880b() * d5) + c1902vaArr[length].m7884f();
                return;
            }
        } else {
            double d6 = c1902vaArr[0].f27696c;
            if (d < d6) {
                d = d6;
            }
            if (d > c1902vaArr[c1902vaArr.length - 1].f27697d) {
                d = c1902vaArr[c1902vaArr.length - 1].f27697d;
            }
        }
        for (int i = 0; i < c1902vaArr.length; i++) {
            C1902va c1902va5 = c1902vaArr[i];
            if (d <= c1902va5.f27697d) {
                if (c1902va5.f27711r) {
                    dArr[0] = c1902va5.m7881c(d);
                    dArr[1] = c1902vaArr[i].m7882d(d);
                    return;
                } else {
                    c1902va5.m7885g(d);
                    dArr[0] = c1902vaArr[i].m7883e();
                    dArr[1] = c1902vaArr[i].m7884f();
                    return;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        C1902va[] c1902vaArr = this.f2165b;
        double d2 = c1902vaArr[0].f27696c;
        if (d < d2) {
            d = d2;
        } else if (d > c1902vaArr[c1902vaArr.length - 1].f27697d) {
            d = c1902vaArr[c1902vaArr.length - 1].f27697d;
        }
        for (int i = 0; i < c1902vaArr.length; i++) {
            C1902va c1902va = c1902vaArr[i];
            if (d <= c1902va.f27697d) {
                if (c1902va.f27711r) {
                    dArr[0] = c1902va.f27705l;
                    dArr[1] = c1902va.f27706m;
                    return;
                } else {
                    c1902va.m7885g(d);
                    dArr[0] = c1902vaArr[i].m7879a();
                    dArr[1] = c1902vaArr[i].m7880b();
                    return;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.f2164a;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d, int i) {
        C1902va[] c1902vaArr = this.f2165b;
        double d2 = c1902vaArr[0].f27696c;
        if (d < d2) {
            d = d2;
        }
        if (d > c1902vaArr[c1902vaArr.length - 1].f27697d) {
            d = c1902vaArr[c1902vaArr.length - 1].f27697d;
        }
        for (int i2 = 0; i2 < c1902vaArr.length; i2++) {
            C1902va c1902va = c1902vaArr[i2];
            if (d <= c1902va.f27697d) {
                if (c1902va.f27711r) {
                    if (i == 0) {
                        return c1902va.f27705l;
                    }
                    return c1902va.f27706m;
                }
                c1902va.m7885g(d);
                if (i == 0) {
                    return c1902vaArr[i2].m7879a();
                }
                return c1902vaArr[i2].m7880b();
            }
        }
        return Double.NaN;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        boolean z = this.f2166c;
        C1902va[] c1902vaArr = this.f2165b;
        if (z) {
            C1902va c1902va = c1902vaArr[0];
            double d2 = c1902va.f27696c;
            if (d < d2) {
                double d3 = d - d2;
                if (c1902va.f27711r) {
                    double m7881c = c1902va.m7881c(d2);
                    C1902va c1902va2 = c1902vaArr[0];
                    fArr[0] = (float) ((c1902va2.f27705l * d3) + m7881c);
                    fArr[1] = (float) ((d3 * c1902vaArr[0].f27706m) + c1902va2.m7882d(d2));
                    return;
                }
                c1902va.m7885g(d2);
                fArr[0] = (float) ((c1902vaArr[0].m7879a() * d3) + c1902vaArr[0].m7883e());
                fArr[1] = (float) ((c1902vaArr[0].m7880b() * d3) + c1902vaArr[0].m7884f());
                return;
            }
            if (d > c1902vaArr[c1902vaArr.length - 1].f27697d) {
                double d4 = c1902vaArr[c1902vaArr.length - 1].f27697d;
                double d5 = d - d4;
                int length = c1902vaArr.length - 1;
                C1902va c1902va3 = c1902vaArr[length];
                if (c1902va3.f27711r) {
                    double m7881c2 = c1902va3.m7881c(d4);
                    C1902va c1902va4 = c1902vaArr[length];
                    fArr[0] = (float) ((c1902va4.f27705l * d5) + m7881c2);
                    fArr[1] = (float) ((d5 * c1902vaArr[length].f27706m) + c1902va4.m7882d(d4));
                    return;
                }
                c1902va3.m7885g(d);
                fArr[0] = (float) c1902vaArr[length].m7883e();
                fArr[1] = (float) c1902vaArr[length].m7884f();
                return;
            }
        } else {
            double d6 = c1902vaArr[0].f27696c;
            if (d < d6) {
                d = d6;
            } else if (d > c1902vaArr[c1902vaArr.length - 1].f27697d) {
                d = c1902vaArr[c1902vaArr.length - 1].f27697d;
            }
        }
        for (int i = 0; i < c1902vaArr.length; i++) {
            C1902va c1902va5 = c1902vaArr[i];
            if (d <= c1902va5.f27697d) {
                if (c1902va5.f27711r) {
                    fArr[0] = (float) c1902va5.m7881c(d);
                    fArr[1] = (float) c1902vaArr[i].m7882d(d);
                    return;
                } else {
                    c1902va5.m7885g(d);
                    fArr[0] = (float) c1902vaArr[i].m7883e();
                    fArr[1] = (float) c1902vaArr[i].m7884f();
                    return;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d, int i) {
        double m7884f;
        double m7880b;
        boolean z = this.f2166c;
        C1902va[] c1902vaArr = this.f2165b;
        if (z) {
            C1902va c1902va = c1902vaArr[0];
            double d2 = c1902va.f27696c;
            if (d < d2) {
                double d3 = d - d2;
                if (c1902va.f27711r) {
                    if (i == 0) {
                        return (d3 * c1902vaArr[0].f27705l) + c1902va.m7881c(d2);
                    }
                    return (d3 * c1902vaArr[0].f27706m) + c1902va.m7882d(d2);
                }
                c1902va.m7885g(d2);
                if (i == 0) {
                    m7884f = c1902vaArr[0].m7883e();
                    m7880b = c1902vaArr[0].m7879a();
                } else {
                    m7884f = c1902vaArr[0].m7884f();
                    m7880b = c1902vaArr[0].m7880b();
                }
                return (m7880b * d3) + m7884f;
            }
            if (d > c1902vaArr[c1902vaArr.length - 1].f27697d) {
                double d4 = c1902vaArr[c1902vaArr.length - 1].f27697d;
                double d5 = d - d4;
                int length = c1902vaArr.length - 1;
                if (i == 0) {
                    return (d5 * c1902vaArr[length].f27705l) + c1902vaArr[length].m7881c(d4);
                }
                return (d5 * c1902vaArr[length].f27706m) + c1902vaArr[length].m7882d(d4);
            }
        } else {
            double d6 = c1902vaArr[0].f27696c;
            if (d < d6) {
                d = d6;
            } else if (d > c1902vaArr[c1902vaArr.length - 1].f27697d) {
                d = c1902vaArr[c1902vaArr.length - 1].f27697d;
            }
        }
        for (int i2 = 0; i2 < c1902vaArr.length; i2++) {
            C1902va c1902va2 = c1902vaArr[i2];
            if (d <= c1902va2.f27697d) {
                if (c1902va2.f27711r) {
                    if (i == 0) {
                        return c1902va2.m7881c(d);
                    }
                    return c1902va2.m7882d(d);
                }
                c1902va2.m7885g(d);
                if (i == 0) {
                    return c1902vaArr[i2].m7883e();
                }
                return c1902vaArr[i2].m7884f();
            }
        }
        return Double.NaN;
    }
}
