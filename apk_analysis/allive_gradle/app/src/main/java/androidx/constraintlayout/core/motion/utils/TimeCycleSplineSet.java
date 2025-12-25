package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import p000.h71;
import p000.ye0;

/* loaded from: classes.dex */
public abstract class TimeCycleSplineSet {
    protected static final int CURVE_OFFSET = 2;
    protected static final int CURVE_PERIOD = 1;
    protected static final int CURVE_VALUE = 0;
    protected static float sVal2PI = 6.2831855f;
    protected int mCount;
    protected CurveFit mCurveFit;
    protected long mLastTime;
    protected String mType;
    protected int mWaveShape = 0;
    protected int[] mTimePoints = new int[10];
    protected float[][] mValues = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 10, 3);
    protected float[] mCache = new float[3];
    protected boolean mContinue = false;
    protected float mLastCycle = Float.NaN;

    /* loaded from: classes.dex */
    public static class CustomSet extends TimeCycleSplineSet {

        /* renamed from: a */
        public final String f2247a;

        /* renamed from: b */
        public final KeyFrameArray.CustomArray f2248b;

        /* renamed from: c */
        public final h71 f2249c = new h71(0, false);

        /* renamed from: d */
        public float[] f2250d;

        /* renamed from: e */
        public float[] f2251e;

        public CustomSet(String str, KeyFrameArray.CustomArray customArray) {
            this.f2247a = str.split(",")[1];
            this.f2248b = customArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int i, float f, float f2, int i2, float f3) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(MotionWidget motionWidget, float f, long j, KeyCache keyCache) {
            boolean z;
            this.mCurveFit.getPos(f, this.f2250d);
            float[] fArr = this.f2250d;
            float f2 = fArr[fArr.length - 2];
            float f3 = fArr[fArr.length - 1];
            long j2 = j - this.mLastTime;
            if (Float.isNaN(this.mLastCycle)) {
                float floatValue = keyCache.getFloatValue(motionWidget, this.f2247a, 0);
                this.mLastCycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.mLastCycle = RecyclerView.f7068F0;
                }
            }
            float f4 = (float) ((((j2 * 1.0E-9d) * f2) + this.mLastCycle) % 1.0d);
            this.mLastCycle = f4;
            this.mLastTime = j;
            float calcWave = calcWave(f4);
            this.mContinue = false;
            int i = 0;
            while (true) {
                float[] fArr2 = this.f2251e;
                if (i >= fArr2.length) {
                    break;
                }
                boolean z2 = this.mContinue;
                float f5 = this.f2250d[i];
                if (f5 != 0.0d) {
                    z = true;
                } else {
                    z = false;
                }
                this.mContinue = z2 | z;
                fArr2[i] = (f5 * calcWave) + f3;
                i++;
            }
            motionWidget.setInterpolatedValue(this.f2248b.valueAt(0), this.f2251e);
            if (f2 != RecyclerView.f7068F0) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int i) {
            KeyFrameArray.CustomArray customArray = this.f2248b;
            int size = customArray.size();
            int numberOfInterpolatedValues = customArray.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i2 = numberOfInterpolatedValues + 2;
            this.f2250d = new float[i2];
            this.f2251e = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i2);
            for (int i3 = 0; i3 < size; i3++) {
                int keyAt = customArray.keyAt(i3);
                CustomAttribute valueAt = customArray.valueAt(i3);
                h71 h71Var = this.f2249c;
                float[] fArr = ((float[][]) h71Var.f17966c)[((int[]) h71Var.f17965b)[i3]];
                dArr[i3] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.f2250d);
                int i4 = 0;
                while (true) {
                    if (i4 < this.f2250d.length) {
                        dArr2[i3][i4] = r10[i4];
                        i4++;
                    }
                }
                double[] dArr3 = dArr2[i3];
                dArr3[numberOfInterpolatedValues] = fArr[0];
                dArr3[numberOfInterpolatedValues + 1] = fArr[1];
            }
            this.mCurveFit = CurveFit.get(i, dArr, dArr2);
        }

        public void setPoint(int i, CustomAttribute customAttribute, float f, int i2, float f2) {
            this.f2248b.append(i, customAttribute);
            this.f2249c.m5040a(i, new float[]{f, f2});
            this.mWaveShape = Math.max(this.mWaveShape, i2);
        }
    }

    /* loaded from: classes.dex */
    public static class CustomVarSet extends TimeCycleSplineSet {

        /* renamed from: a */
        public final String f2252a;

        /* renamed from: b */
        public final KeyFrameArray.CustomVar f2253b;

        /* renamed from: c */
        public final h71 f2254c = new h71(0, false);

        /* renamed from: d */
        public float[] f2255d;

        /* renamed from: e */
        public float[] f2256e;

        public CustomVarSet(String str, KeyFrameArray.CustomVar customVar) {
            this.f2252a = str.split(",")[1];
            this.f2253b = customVar;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int i, float f, float f2, int i2, float f3) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(MotionWidget motionWidget, float f, long j, KeyCache keyCache) {
            boolean z;
            this.mCurveFit.getPos(f, this.f2255d);
            float[] fArr = this.f2255d;
            float f2 = fArr[fArr.length - 2];
            float f3 = fArr[fArr.length - 1];
            long j2 = j - this.mLastTime;
            if (Float.isNaN(this.mLastCycle)) {
                float floatValue = keyCache.getFloatValue(motionWidget, this.f2252a, 0);
                this.mLastCycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.mLastCycle = RecyclerView.f7068F0;
                }
            }
            float f4 = (float) ((((j2 * 1.0E-9d) * f2) + this.mLastCycle) % 1.0d);
            this.mLastCycle = f4;
            this.mLastTime = j;
            float calcWave = calcWave(f4);
            this.mContinue = false;
            int i = 0;
            while (true) {
                float[] fArr2 = this.f2256e;
                if (i >= fArr2.length) {
                    break;
                }
                boolean z2 = this.mContinue;
                float f5 = this.f2255d[i];
                if (f5 != 0.0d) {
                    z = true;
                } else {
                    z = false;
                }
                this.mContinue = z2 | z;
                fArr2[i] = (f5 * calcWave) + f3;
                i++;
            }
            this.f2253b.valueAt(0).setInterpolatedValue(motionWidget, this.f2256e);
            if (f2 != RecyclerView.f7068F0) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int i) {
            KeyFrameArray.CustomVar customVar = this.f2253b;
            int size = customVar.size();
            int numberOfInterpolatedValues = customVar.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i2 = numberOfInterpolatedValues + 2;
            this.f2255d = new float[i2];
            this.f2256e = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i2);
            for (int i3 = 0; i3 < size; i3++) {
                int keyAt = customVar.keyAt(i3);
                CustomVariable valueAt = customVar.valueAt(i3);
                h71 h71Var = this.f2254c;
                float[] fArr = ((float[][]) h71Var.f17966c)[((int[]) h71Var.f17965b)[i3]];
                dArr[i3] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.f2255d);
                int i4 = 0;
                while (true) {
                    if (i4 < this.f2255d.length) {
                        dArr2[i3][i4] = r10[i4];
                        i4++;
                    }
                }
                double[] dArr3 = dArr2[i3];
                dArr3[numberOfInterpolatedValues] = fArr[0];
                dArr3[numberOfInterpolatedValues + 1] = fArr[1];
            }
            this.mCurveFit = CurveFit.get(i, dArr, dArr2);
        }

        public void setPoint(int i, CustomVariable customVariable, float f, int i2, float f2) {
            this.f2253b.append(i, customVariable);
            this.f2254c.m5040a(i, new float[]{f, f2});
            this.mWaveShape = Math.max(this.mWaveShape, i2);
        }
    }

    /* loaded from: classes.dex */
    public static class Sort {
    }

    public float calcWave(float f) {
        float abs;
        switch (this.mWaveShape) {
            case 1:
                return Math.signum(f * sVal2PI);
            case 2:
                abs = Math.abs(f);
                break;
            case 3:
                return (((f * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f * sVal2PI);
            case 6:
                float abs2 = 1.0f - Math.abs(((f * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin(f * sVal2PI);
        }
        return 1.0f - abs;
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int i, float f, float f2, int i2, float f3) {
        int[] iArr = this.mTimePoints;
        int i3 = this.mCount;
        iArr[i3] = i;
        float[] fArr = this.mValues[i3];
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        this.mWaveShape = Math.max(this.mWaveShape, i2);
        this.mCount++;
    }

    public void setStartTime(long j) {
        this.mLastTime = j;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i) {
        int i2 = this.mCount;
        if (i2 == 0) {
            System.err.println("Error no points added to " + this.mType);
            return;
        }
        int[] iArr = this.mTimePoints;
        float[][] fArr = this.mValues;
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
                        float[] fArr2 = fArr[i10];
                        fArr[i10] = fArr[i9];
                        fArr[i9] = fArr2;
                        i10++;
                    }
                    i9++;
                }
                int i13 = iArr[i10];
                iArr[i10] = iArr[i7];
                iArr[i7] = i13;
                float[] fArr3 = fArr[i10];
                fArr[i10] = fArr[i7];
                fArr[i7] = fArr3;
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
        int i16 = 0;
        while (true) {
            int[] iArr3 = this.mTimePoints;
            if (i15 >= iArr3.length) {
                break;
            }
            if (iArr3[i15] != iArr3[i15 - 1]) {
                i16++;
            }
            i15++;
        }
        if (i16 == 0) {
            i16 = 1;
        }
        double[] dArr = new double[i16];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i16, 3);
        int i17 = 0;
        for (int i18 = 0; i18 < this.mCount; i18++) {
            if (i18 > 0) {
                int[] iArr4 = this.mTimePoints;
                if (iArr4[i18] == iArr4[i18 - 1]) {
                }
            }
            dArr[i17] = this.mTimePoints[i18] * 0.01d;
            double[] dArr3 = dArr2[i17];
            float[] fArr4 = this.mValues[i18];
            dArr3[0] = fArr4[0];
            dArr3[1] = fArr4[1];
            dArr3[2] = fArr4[2];
            i17++;
        }
        this.mCurveFit = CurveFit.get(i, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.mCount; i++) {
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
