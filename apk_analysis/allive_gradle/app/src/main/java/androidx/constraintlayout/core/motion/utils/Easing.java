package androidx.constraintlayout.core.motion.utils;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import p000.q70;

/* loaded from: classes.dex */
public class Easing {

    /* renamed from: a */
    public String f2168a = "identity";

    /* renamed from: b */
    public static final Easing f2167b = new Easing();
    public static String[] NAMED_EASING = {"standard", "accelerate", "decelerate", "linear"};

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x015d, code lost:
    
        if (r21.equals("linear") == false) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21, types: [androidx.constraintlayout.core.motion.utils.Easing, androidx.constraintlayout.core.motion.utils.Schlick] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Easing getInterpolator(String str) {
        int i;
        char c = 3;
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new q70(str);
        }
        if (str.startsWith("spline")) {
            Easing easing = new Easing();
            easing.f2168a = str;
            double[] dArr = new double[str.length() / 2];
            int indexOf = str.indexOf(40) + 1;
            int indexOf2 = str.indexOf(44, indexOf);
            int i2 = 0;
            while (indexOf2 != -1) {
                dArr[i2] = Double.parseDouble(str.substring(indexOf, indexOf2).trim());
                indexOf = indexOf2 + 1;
                indexOf2 = str.indexOf(44, indexOf);
                i2++;
            }
            dArr[i2] = Double.parseDouble(str.substring(indexOf, str.indexOf(41, indexOf)).trim());
            double[] copyOf = Arrays.copyOf(dArr, i2 + 1);
            int length = (copyOf.length * 3) - 2;
            int length2 = copyOf.length - 1;
            double d = 1.0d / length2;
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, 1);
            double[] dArr3 = new double[length];
            int i3 = 0;
            while (i3 < copyOf.length) {
                double d2 = copyOf[i3];
                int i4 = i3 + length2;
                dArr2[i4][0] = d2;
                Easing easing2 = easing;
                double d3 = i3 * d;
                dArr3[i4] = d3;
                if (i3 > 0) {
                    int i5 = (length2 * 2) + i3;
                    dArr2[i5][0] = d2 + 1.0d;
                    dArr3[i5] = d3 + 1.0d;
                    i = 1;
                    int i6 = i3 - 1;
                    dArr2[i6][0] = (d2 - 1.0d) - d;
                    dArr3[i6] = (d3 - 1.0d) - d;
                } else {
                    i = 1;
                }
                i3 += i;
                easing = easing2;
            }
            StepCurve stepCurve = easing;
            MonotonicCurveFit monotonicCurveFit = new MonotonicCurveFit(dArr3, dArr2);
            PrintStream printStream = System.out;
            printStream.println(" 0 " + monotonicCurveFit.getPos(0.0d, 0));
            printStream.println(" 1 " + monotonicCurveFit.getPos(1.0d, 0));
            stepCurve.f2224c = monotonicCurveFit;
            return stepCurve;
        }
        if (str.startsWith("Schlick")) {
            ?? easing3 = new Easing();
            easing3.f2168a = str;
            int indexOf3 = str.indexOf(40);
            int indexOf4 = str.indexOf(44, indexOf3);
            easing3.f2207c = Double.parseDouble(str.substring(indexOf3 + 1, indexOf4).trim());
            int i7 = indexOf4 + 1;
            easing3.f2208d = Double.parseDouble(str.substring(i7, str.indexOf(44, i7)).trim());
            return easing3;
        }
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals("accelerate")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1263948740:
                if (str.equals("decelerate")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1197605014:
                if (str.equals("anticipate")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1102672091:
                break;
            case -749065269:
                if (str.equals("overshoot")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1312628413:
                if (str.equals("standard")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return new q70("cubic(0.4, 0.05, 0.8, 0.7)");
            case 1:
                return new q70("cubic(0.0, 0.0, 0.2, 0.95)");
            case 2:
                return new q70("cubic(0.36, 0, 0.66, -0.56)");
            case 3:
                return new q70("cubic(1, 1, 0, 0)");
            case 4:
                return new q70("cubic(0.34, 1.56, 0.64, 1)");
            case 5:
                return new q70("cubic(0.4, 0.0, 0.2, 1)");
            default:
                System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(NAMED_EASING));
                return f2167b;
        }
    }

    public double get(double d) {
        return d;
    }

    public double getDiff(double d) {
        return 1.0d;
    }

    public String toString() {
        return this.f2168a;
    }
}
