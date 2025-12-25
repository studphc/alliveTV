package androidx.constraintlayout.motion.utils;

import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Array;
import p000.z33;

/* loaded from: classes.dex */
public abstract class ViewTimeCycle extends TimeCycleSplineSet {

    /* loaded from: classes.dex */
    public static class CustomSet extends ViewTimeCycle {

        /* renamed from: a */
        public final String f2689a;

        /* renamed from: b */
        public final SparseArray f2690b;

        /* renamed from: c */
        public final SparseArray f2691c = new SparseArray();

        /* renamed from: d */
        public float[] f2692d;

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.f2689a = str.split(",")[1];
            this.f2690b = sparseArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int i, float f, float f2, int i2, float f3) {
            throw new RuntimeException("Wrong call for custom attribute");
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            boolean z;
            this.mCurveFit.getPos(f, this.f2692d);
            float[] fArr = this.f2692d;
            float f2 = fArr[fArr.length - 2];
            float f3 = fArr[fArr.length - 1];
            long j2 = j - this.mLastTime;
            if (Float.isNaN(this.mLastCycle)) {
                float floatValue = keyCache.getFloatValue(view, this.f2689a, 0);
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
                float[] fArr2 = this.mCache;
                if (i >= fArr2.length) {
                    break;
                }
                boolean z2 = this.mContinue;
                float f5 = this.f2692d[i];
                if (f5 != 0.0d) {
                    z = true;
                } else {
                    z = false;
                }
                this.mContinue = z2 | z;
                fArr2[i] = (f5 * calcWave) + f3;
                i++;
            }
            CustomSupport.setInterpolatedValue((ConstraintAttribute) this.f2690b.valueAt(0), view, this.mCache);
            if (f2 != RecyclerView.f7068F0) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int i) {
            SparseArray sparseArray = this.f2690b;
            int size = sparseArray.size();
            int numberOfInterpolatedValues = ((ConstraintAttribute) sparseArray.valueAt(0)).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i2 = numberOfInterpolatedValues + 2;
            this.f2692d = new float[i2];
            this.mCache = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i2);
            for (int i3 = 0; i3 < size; i3++) {
                int keyAt = sparseArray.keyAt(i3);
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) sparseArray.valueAt(i3);
                float[] fArr = (float[]) this.f2691c.valueAt(i3);
                dArr[i3] = keyAt * 0.01d;
                constraintAttribute.getValuesToInterpolate(this.f2692d);
                int i4 = 0;
                while (true) {
                    if (i4 < this.f2692d.length) {
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

        public void setPoint(int i, ConstraintAttribute constraintAttribute, float f, int i2, float f2) {
            this.f2690b.append(i, constraintAttribute);
            this.f2691c.append(i, new float[]{f, f2});
            this.mWaveShape = Math.max(this.mWaveShape, i2);
        }
    }

    /* loaded from: classes.dex */
    public static class PathRotate extends ViewTimeCycle {
        public boolean setPathRotate(View view, KeyCache keyCache, float f, long j, double d, double d2) {
            view.setRotation(get(f, j, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d2, d))));
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            return this.mContinue;
        }
    }

    public static ViewTimeCycle makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:39:0x00a7. Please report as an issue. */
    /* JADX WARN: Type inference failed for: r12v6, types: [a43, androidx.constraintlayout.motion.utils.ViewTimeCycle] */
    public static ViewTimeCycle makeSpline(String str, long j) {
        ViewTimeCycle viewTimeCycle;
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = 7;
                    break;
                }
                break;
            case -40300674:
                if (str.equals(Key.ROTATION)) {
                    c = '\b';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = '\t';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = '\n';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 11;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                viewTimeCycle = new z33(3);
                viewTimeCycle.setStartTime(j);
                return viewTimeCycle;
            case 1:
                viewTimeCycle = new z33(4);
                viewTimeCycle.setStartTime(j);
                return viewTimeCycle;
            case 2:
                viewTimeCycle = new z33(7);
                viewTimeCycle.setStartTime(j);
                return viewTimeCycle;
            case 3:
                viewTimeCycle = new z33(8);
                viewTimeCycle.setStartTime(j);
                return viewTimeCycle;
            case 4:
                viewTimeCycle = new z33(9);
                viewTimeCycle.setStartTime(j);
                return viewTimeCycle;
            case 5:
                ?? viewTimeCycle2 = new ViewTimeCycle();
                viewTimeCycle2.f38a = false;
                viewTimeCycle = viewTimeCycle2;
                viewTimeCycle.setStartTime(j);
                return viewTimeCycle;
            case 6:
                viewTimeCycle = new z33(5);
                viewTimeCycle.setStartTime(j);
                return viewTimeCycle;
            case 7:
                viewTimeCycle = new z33(6);
                viewTimeCycle.setStartTime(j);
                return viewTimeCycle;
            case '\b':
                viewTimeCycle = new z33(2);
                viewTimeCycle.setStartTime(j);
                return viewTimeCycle;
            case '\t':
                viewTimeCycle = new z33(1);
                viewTimeCycle.setStartTime(j);
                return viewTimeCycle;
            case '\n':
                viewTimeCycle = new PathRotate();
                viewTimeCycle.setStartTime(j);
                return viewTimeCycle;
            case 11:
                viewTimeCycle = new z33(0);
                viewTimeCycle.setStartTime(j);
                return viewTimeCycle;
            default:
                return null;
        }
    }

    public float get(float f, long j, View view, KeyCache keyCache) {
        boolean z;
        this.mCurveFit.getPos(f, this.mCache);
        float[] fArr = this.mCache;
        float f2 = fArr[1];
        if (f2 == RecyclerView.f7068F0) {
            this.mContinue = false;
            return fArr[2];
        }
        if (Float.isNaN(this.mLastCycle)) {
            float floatValue = keyCache.getFloatValue(view, this.mType, 0);
            this.mLastCycle = floatValue;
            if (Float.isNaN(floatValue)) {
                this.mLastCycle = RecyclerView.f7068F0;
            }
        }
        float f3 = (float) (((((j - this.mLastTime) * 1.0E-9d) * f2) + this.mLastCycle) % 1.0d);
        this.mLastCycle = f3;
        keyCache.setFloatValue(view, this.mType, 0, f3);
        this.mLastTime = j;
        float f4 = this.mCache[0];
        float calcWave = (calcWave(this.mLastCycle) * f4) + this.mCache[2];
        if (f4 == RecyclerView.f7068F0 && f2 == RecyclerView.f7068F0) {
            z = false;
        } else {
            z = true;
        }
        this.mContinue = z;
        return calcWave;
    }

    public abstract boolean setProperty(View view, float f, long j, KeyCache keyCache);
}
