package p000;

import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class lp1 implements Comparable {

    /* renamed from: r */
    public static final String[] f22607r = {"position", "x", "y", "width", "height", "pathRotate"};

    /* renamed from: a */
    public Easing f22608a;

    /* renamed from: c */
    public float f22610c;

    /* renamed from: d */
    public float f22611d;

    /* renamed from: e */
    public float f22612e;

    /* renamed from: f */
    public float f22613f;

    /* renamed from: g */
    public float f22614g;

    /* renamed from: h */
    public float f22615h;

    /* renamed from: j */
    public int f22617j;

    /* renamed from: k */
    public int f22618k;

    /* renamed from: l */
    public float f22619l;

    /* renamed from: m */
    public MotionController f22620m;

    /* renamed from: n */
    public LinkedHashMap f22621n;

    /* renamed from: o */
    public int f22622o;

    /* renamed from: p */
    public double[] f22623p;

    /* renamed from: q */
    public double[] f22624q;

    /* renamed from: b */
    public int f22609b = 0;

    /* renamed from: i */
    public float f22616i = Float.NaN;

    public lp1() {
        int i = Key.UNSET;
        this.f22617j = i;
        this.f22618k = i;
        this.f22619l = Float.NaN;
        this.f22620m = null;
        this.f22621n = new LinkedHashMap();
        this.f22622o = 0;
        this.f22623p = new double[18];
        this.f22624q = new double[18];
    }

    /* renamed from: b */
    public static boolean m5963b(float f, float f2) {
        if (!Float.isNaN(f) && !Float.isNaN(f2)) {
            if (Math.abs(f - f2) <= 1.0E-6f) {
                return false;
            }
            return true;
        }
        if (Float.isNaN(f) == Float.isNaN(f2)) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public static void m5964f(float f, float f2, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f7 = (float) dArr[i];
            double d = dArr2[i];
            int i2 = iArr[i];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            f6 = f7;
                        }
                    } else {
                        f4 = f7;
                    }
                } else {
                    f5 = f7;
                }
            } else {
                f3 = f7;
            }
        }
        float f8 = f3 - ((RecyclerView.f7068F0 * f4) / 2.0f);
        float f9 = f5 - ((RecyclerView.f7068F0 * f6) / 2.0f);
        fArr[0] = (((f4 * 1.0f) + f8) * f) + ((1.0f - f) * f8) + RecyclerView.f7068F0;
        fArr[1] = (((f6 * 1.0f) + f9) * f2) + ((1.0f - f2) * f9) + RecyclerView.f7068F0;
    }

    /* renamed from: a */
    public final void m5965a(ConstraintSet.Constraint constraint) {
        this.f22608a = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        ConstraintSet.Motion motion = constraint.motion;
        this.f22617j = motion.mPathMotionArc;
        this.f22618k = motion.mAnimateRelativeTo;
        this.f22616i = motion.mPathRotate;
        this.f22609b = motion.mDrawPath;
        int i = motion.mAnimateCircleAngleTo;
        float f = constraint.propertySet.mProgress;
        this.f22619l = constraint.layout.circleAngle;
        for (String str : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(str);
            if (constraintAttribute != null && constraintAttribute.isContinuous()) {
                this.f22621n.put(str, constraintAttribute);
            }
        }
    }

    /* renamed from: c */
    public final void m5966c(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.f22612e;
        float f2 = this.f22613f;
        float f3 = this.f22614g;
        float f4 = this.f22615h;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            f4 = f5;
                        }
                    } else {
                        f3 = f5;
                    }
                } else {
                    f2 = f5;
                }
            } else {
                f = f5;
            }
        }
        MotionController motionController = this.f22620m;
        if (motionController != null) {
            float[] fArr2 = new float[2];
            motionController.getCenter(d, fArr2, new float[2]);
            float f6 = fArr2[0];
            float f7 = fArr2[1];
            double d2 = f6;
            double d3 = f;
            double d4 = f2;
            f = (float) (((Math.sin(d4) * d3) + d2) - (f3 / 2.0f));
            f2 = (float) ((f7 - (Math.cos(d4) * d3)) - (f4 / 2.0f));
        }
        fArr[i] = (f3 / 2.0f) + f + RecyclerView.f7068F0;
        fArr[i + 1] = (f4 / 2.0f) + f2 + RecyclerView.f7068F0;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Float.compare(this.f22611d, ((lp1) obj).f22611d);
    }

    /* renamed from: d */
    public final void m5967d(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.f22612e;
        float f2 = this.f22613f;
        float f3 = this.f22614g;
        float f4 = this.f22615h;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            f4 = f5;
                        }
                    } else {
                        f3 = f5;
                    }
                } else {
                    f2 = f5;
                }
            } else {
                f = f5;
            }
        }
        MotionController motionController = this.f22620m;
        if (motionController != null) {
            float centerX = motionController.getCenterX();
            float centerY = this.f22620m.getCenterY();
            double d = f;
            double d2 = f2;
            float sin = (float) (((Math.sin(d2) * d) + centerX) - (f3 / 2.0f));
            f2 = (float) ((centerY - (Math.cos(d2) * d)) - (f4 / 2.0f));
            f = sin;
        }
        float f6 = f3 + f;
        float f7 = f4 + f2;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        float f8 = f + RecyclerView.f7068F0;
        float f9 = f2 + RecyclerView.f7068F0;
        float f10 = f6 + RecyclerView.f7068F0;
        float f11 = f2 + RecyclerView.f7068F0;
        float f12 = f6 + RecyclerView.f7068F0;
        float f13 = f7 + RecyclerView.f7068F0;
        float f14 = f + RecyclerView.f7068F0;
        float f15 = f7 + RecyclerView.f7068F0;
        fArr[i] = f8;
        fArr[i + 1] = f9;
        fArr[i + 2] = f10;
        fArr[i + 3] = f11;
        fArr[i + 4] = f12;
        fArr[i + 5] = f13;
        fArr[i + 6] = f14;
        fArr[i + 7] = f15;
    }

    /* renamed from: e */
    public final void m5968e(float f, float f2, float f3, float f4) {
        this.f22612e = f;
        this.f22613f = f2;
        this.f22614g = f3;
        this.f22615h = f4;
    }

    /* renamed from: g */
    public final void m5969g(MotionController motionController, lp1 lp1Var) {
        double d = (((this.f22614g / 2.0f) + this.f22612e) - lp1Var.f22612e) - (lp1Var.f22614g / 2.0f);
        double d2 = (((this.f22615h / 2.0f) + this.f22613f) - lp1Var.f22613f) - (lp1Var.f22615h / 2.0f);
        this.f22620m = motionController;
        this.f22612e = (float) Math.hypot(d2, d);
        if (Float.isNaN(this.f22619l)) {
            this.f22613f = (float) (Math.atan2(d2, d) + 1.5707963267948966d);
        } else {
            this.f22613f = (float) Math.toRadians(this.f22619l);
        }
    }
}
