package androidx.constraintlayout.motion.utils;

import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import p000.v33;

/* loaded from: classes.dex */
public abstract class ViewSpline extends SplineSet {

    /* loaded from: classes.dex */
    public static class CustomSet extends ViewSpline {

        /* renamed from: c */
        public final SparseArray f2687c;

        /* renamed from: d */
        public float[] f2688d;

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            String str2 = str.split(",")[1];
            this.f2687c = sparseArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setPoint(int i, float f) {
            throw new RuntimeException("call of custom attribute setPoint");
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            this.mCurveFit.getPos(f, this.f2688d);
            CustomSupport.setInterpolatedValue((ConstraintAttribute) this.f2687c.valueAt(0), view, this.f2688d);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setup(int i) {
            SparseArray sparseArray = this.f2687c;
            int size = sparseArray.size();
            int numberOfInterpolatedValues = ((ConstraintAttribute) sparseArray.valueAt(0)).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.f2688d = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, numberOfInterpolatedValues);
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt = sparseArray.keyAt(i2);
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) sparseArray.valueAt(i2);
                dArr[i2] = keyAt * 0.01d;
                constraintAttribute.getValuesToInterpolate(this.f2688d);
                int i3 = 0;
                while (true) {
                    if (i3 < this.f2688d.length) {
                        dArr2[i2][i3] = r7[i3];
                        i3++;
                    }
                }
            }
            this.mCurveFit = CurveFit.get(i, dArr, dArr2);
        }

        public void setPoint(int i, ConstraintAttribute constraintAttribute) {
            this.f2687c.append(i, constraintAttribute);
        }
    }

    /* loaded from: classes.dex */
    public static class PathRotate extends ViewSpline {
        public void setPathRotate(View view, float f, double d, double d2) {
            view.setRotation(get(f) + ((float) Math.toDegrees(Math.atan2(d2, d))));
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
        }
    }

    public static ViewSpline makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    /* JADX WARN: Type inference failed for: r14v6, types: [w33, androidx.constraintlayout.motion.utils.ViewSpline] */
    public static ViewSpline makeSpline(String str) {
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
            case -797520672:
                if (str.equals(Key.WAVE_VARIES_BY)) {
                    c = '\b';
                    break;
                }
                break;
            case -760884510:
                if (str.equals(Key.PIVOT_X)) {
                    c = '\t';
                    break;
                }
                break;
            case -760884509:
                if (str.equals(Key.PIVOT_Y)) {
                    c = '\n';
                    break;
                }
                break;
            case -40300674:
                if (str.equals(Key.ROTATION)) {
                    c = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = '\f';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = '\r';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 14;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c = 15;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new v33(5);
            case 1:
                return new v33(6);
            case 2:
                return new v33(9);
            case 3:
                return new v33(10);
            case 4:
                return new v33(11);
            case 5:
                ?? viewSpline = new ViewSpline();
                viewSpline.f28063c = false;
                return viewSpline;
            case 6:
                return new v33(7);
            case 7:
                return new v33(8);
            case '\b':
                return new v33(0);
            case '\t':
                return new v33(2);
            case '\n':
                return new v33(3);
            case 11:
                return new v33(4);
            case '\f':
                return new v33(1);
            case '\r':
                return new PathRotate();
            case 14:
                return new v33(0);
            case 15:
                return new v33(0);
            default:
                return null;
        }
    }

    public abstract void setProperty(View view, float f);
}
