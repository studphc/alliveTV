package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.state.WidgetFrame;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;
import p000.ly2;
import p000.ye0;

/* loaded from: classes.dex */
public abstract class SplineSet {

    /* renamed from: a */
    public int f2209a;

    /* renamed from: b */
    public String f2210b;
    protected CurveFit mCurveFit;
    protected int[] mTimePoints = new int[10];
    protected float[] mValues = new float[10];

    /* loaded from: classes.dex */
    public static class CustomSet extends SplineSet {

        /* renamed from: c */
        public final KeyFrameArray.CustomArray f2211c;

        /* renamed from: d */
        public float[] f2212d;

        public CustomSet(String str, KeyFrameArray.CustomArray customArray) {
            String str2 = str.split(",")[1];
            this.f2211c = customArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setPoint(int i, float f) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setProperty(WidgetFrame widgetFrame, float f) {
            this.mCurveFit.getPos(f, this.f2212d);
            widgetFrame.setCustomValue(this.f2211c.valueAt(0), this.f2212d);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setup(int i) {
            KeyFrameArray.CustomArray customArray = this.f2211c;
            int size = customArray.size();
            int numberOfInterpolatedValues = customArray.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.f2212d = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, numberOfInterpolatedValues);
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt = customArray.keyAt(i2);
                CustomAttribute valueAt = customArray.valueAt(i2);
                dArr[i2] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.f2212d);
                int i3 = 0;
                while (true) {
                    if (i3 < this.f2212d.length) {
                        dArr2[i2][i3] = r7[i3];
                        i3++;
                    }
                }
            }
            this.mCurveFit = CurveFit.get(i, dArr, dArr2);
        }

        public void setPoint(int i, CustomAttribute customAttribute) {
            this.f2211c.append(i, customAttribute);
        }
    }

    /* loaded from: classes.dex */
    public static class CustomSpline extends SplineSet {

        /* renamed from: c */
        public final KeyFrameArray.CustomVar f2213c;

        /* renamed from: d */
        public float[] f2214d;

        public CustomSpline(String str, KeyFrameArray.CustomVar customVar) {
            String str2 = str.split(",")[1];
            this.f2213c = customVar;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setPoint(int i, float f) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setProperty(TypedValues typedValues, float f) {
            setProperty((MotionWidget) typedValues, f);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setup(int i) {
            KeyFrameArray.CustomVar customVar = this.f2213c;
            int size = customVar.size();
            int numberOfInterpolatedValues = customVar.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.f2214d = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, numberOfInterpolatedValues);
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt = customVar.keyAt(i2);
                CustomVariable valueAt = customVar.valueAt(i2);
                dArr[i2] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.f2214d);
                int i3 = 0;
                while (true) {
                    if (i3 < this.f2214d.length) {
                        dArr2[i2][i3] = r7[i3];
                        i3++;
                    }
                }
            }
            this.mCurveFit = CurveFit.get(i, dArr, dArr2);
        }

        public void setPoint(int i, CustomVariable customVariable) {
            this.f2213c.append(i, customVariable);
        }

        public void setProperty(MotionWidget motionWidget, float f) {
            this.mCurveFit.getPos(f, this.f2214d);
            this.f2213c.valueAt(0).setInterpolatedValue(motionWidget, this.f2214d);
        }
    }

    public static SplineSet makeCustomSpline(String str, KeyFrameArray.CustomArray customArray) {
        return new CustomSet(str, customArray);
    }

    public static SplineSet makeCustomSplineSet(String str, KeyFrameArray.CustomVar customVar) {
        return new CustomSpline(str, customVar);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.constraintlayout.core.motion.utils.SplineSet, cm2] */
    public static SplineSet makeSpline(String str, long j) {
        ?? splineSet = new SplineSet();
        splineSet.f8418c = str;
        return splineSet;
    }

    public float get(float f) {
        return (float) this.mCurveFit.getPos(f, 0);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f) {
        return (float) this.mCurveFit.getSlope(f, 0);
    }

    public void setPoint(int i, float f) {
        int[] iArr = this.mTimePoints;
        if (iArr.length < this.f2209a + 1) {
            this.mTimePoints = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValues;
            this.mValues = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTimePoints;
        int i2 = this.f2209a;
        iArr2[i2] = i;
        this.mValues[i2] = f;
        this.f2209a = i2 + 1;
    }

    public void setProperty(TypedValues typedValues, float f) {
        typedValues.setValue(ly2.m5999a(this.f2210b), get(f));
    }

    public void setType(String str) {
        this.f2210b = str;
    }

    public void setup(int i) {
        int i2 = this.f2209a;
        if (i2 == 0) {
            return;
        }
        int[] iArr = this.mTimePoints;
        float[] fArr = this.mValues;
        int[] iArr2 = new int[iArr.length + 10];
        iArr2[0] = i2 - 1;
        iArr2[1] = 0;
        int i3 = 2;
        while (i3 > 0) {
            int i4 = i3 - 1;
            int i5 = iArr2[i4];
            int i6 = i3 - 2;
            int i7 = iArr2[i6];
            if (i5 < i7) {
                int i8 = iArr[i7];
                int i9 = i5;
                int i10 = i9;
                while (i9 < i7) {
                    int i11 = iArr[i9];
                    if (i11 <= i8) {
                        int i12 = iArr[i10];
                        iArr[i10] = i11;
                        iArr[i9] = i12;
                        float f = fArr[i10];
                        fArr[i10] = fArr[i9];
                        fArr[i9] = f;
                        i10++;
                    }
                    i9++;
                }
                int i13 = iArr[i10];
                iArr[i10] = iArr[i7];
                iArr[i7] = i13;
                float f2 = fArr[i10];
                fArr[i10] = fArr[i7];
                fArr[i7] = f2;
                iArr2[i6] = i10 - 1;
                iArr2[i4] = i5;
                int i14 = i3 + 1;
                iArr2[i3] = i7;
                i3 += 2;
                iArr2[i14] = i10 + 1;
            } else {
                i3 = i6;
            }
        }
        int i15 = 1;
        for (int i16 = 1; i16 < this.f2209a; i16++) {
            int[] iArr3 = this.mTimePoints;
            if (iArr3[i16 - 1] != iArr3[i16]) {
                i15++;
            }
        }
        double[] dArr = new double[i15];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i15, 1);
        int i17 = 0;
        for (int i18 = 0; i18 < this.f2209a; i18++) {
            if (i18 > 0) {
                int[] iArr4 = this.mTimePoints;
                if (iArr4[i18] == iArr4[i18 - 1]) {
                }
            }
            dArr[i17] = this.mTimePoints[i18] * 0.01d;
            dArr2[i17][0] = this.mValues[i18];
            i17++;
        }
        this.mCurveFit = CurveFit.get(i, dArr, dArr2);
    }

    public String toString() {
        String str = this.f2210b;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.f2209a; i++) {
            StringBuilder m8303w = ye0.m8303w(str, "[");
            m8303w.append(this.mTimePoints[i]);
            m8303w.append(" , ");
            m8303w.append(decimalFormat.format(this.mValues[i]));
            m8303w.append("] ");
            str = m8303w.toString();
        }
        return str;
    }
}
