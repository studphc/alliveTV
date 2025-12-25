package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public class MotionPaths implements Comparable<MotionPaths> {
    public static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    public static final boolean OLD_WAY = false;
    public static final int PERPENDICULAR = 1;
    public static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";

    /* renamed from: s */
    public static final String[] f2091s = {"position", "x", "y", "width", "height", "pathRotate"};

    /* renamed from: a */
    public Easing f2092a;

    /* renamed from: b */
    public int f2093b;

    /* renamed from: c */
    public float f2094c;

    /* renamed from: d */
    public float f2095d;

    /* renamed from: e */
    public float f2096e;

    /* renamed from: f */
    public float f2097f;

    /* renamed from: g */
    public float f2098g;

    /* renamed from: h */
    public float f2099h;

    /* renamed from: i */
    public float f2100i;

    /* renamed from: j */
    public float f2101j;

    /* renamed from: k */
    public int f2102k;

    /* renamed from: l */
    public String f2103l;

    /* renamed from: m */
    public float f2104m;
    public String mId;

    /* renamed from: n */
    public Motion f2105n;

    /* renamed from: o */
    public final HashMap f2106o;

    /* renamed from: p */
    public final int f2107p;

    /* renamed from: q */
    public double[] f2108q;

    /* renamed from: r */
    public double[] f2109r;

    public MotionPaths() {
        this.f2093b = 0;
        this.f2100i = Float.NaN;
        this.f2101j = Float.NaN;
        this.f2102k = -1;
        this.f2103l = null;
        this.f2104m = Float.NaN;
        this.f2105n = null;
        this.f2106o = new HashMap();
        this.f2107p = 0;
        this.f2108q = new double[18];
        this.f2109r = new double[18];
    }

    /* renamed from: a */
    public static boolean m440a(float f, float f2) {
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

    /* renamed from: c */
    public static void m441c(float f, float f2, float[] fArr, int[] iArr, double[] dArr) {
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f7 = (float) dArr[i];
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

    public void applyParameters(MotionWidget motionWidget) {
        ConstraintWidget constraintWidget;
        this.f2092a = Easing.getInterpolator(motionWidget.f2111b.mTransitionEasing);
        MotionWidget.Motion motion = motionWidget.f2111b;
        this.f2102k = motion.mPathMotionArc;
        this.f2103l = motion.mAnimateRelativeTo;
        this.f2100i = motion.mPathRotate;
        this.f2093b = motion.mDrawPath;
        int i = motion.mAnimateCircleAngleTo;
        this.f2101j = motionWidget.f2112c.mProgress;
        WidgetFrame widgetFrame = motionWidget.f2110a;
        if (widgetFrame != null && (constraintWidget = widgetFrame.widget) != null) {
            this.f2104m = constraintWidget.mCircleConstraintAngle;
        }
        for (String str : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(str);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.f2106o.put(str, customAttribute);
            }
        }
    }

    /* renamed from: b */
    public final void m442b(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.f2096e;
        float f2 = this.f2097f;
        float f3 = this.f2098g;
        float f4 = this.f2099h;
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
        Motion motion = this.f2105n;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d, fArr2, new float[2]);
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

    public void configureRelativeTo(Motion motion) {
        double d = this.f2101j;
        motion.f2071g[0].getPos(d, motion.f2077m);
        CurveFit curveFit = motion.f2072h;
        if (curveFit != null) {
            double[] dArr = motion.f2077m;
            if (dArr.length > 0) {
                curveFit.getPos(d, dArr);
            }
        }
    }

    public void setupRelative(Motion motion, MotionPaths motionPaths) {
        double d = (((this.f2098g / 2.0f) + this.f2096e) - motionPaths.f2096e) - (motionPaths.f2098g / 2.0f);
        double d2 = (((this.f2099h / 2.0f) + this.f2097f) - motionPaths.f2097f) - (motionPaths.f2099h / 2.0f);
        this.f2105n = motion;
        this.f2096e = (float) Math.hypot(d2, d);
        if (Float.isNaN(this.f2104m)) {
            this.f2097f = (float) (Math.atan2(d2, d) + 1.5707963267948966d);
        } else {
            this.f2097f = (float) Math.toRadians(this.f2104m);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.f2095d, motionPaths.f2095d);
    }

    public MotionPaths(int i, int i2, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f;
        int i3;
        float min;
        float f2;
        this.f2093b = 0;
        this.f2100i = Float.NaN;
        this.f2101j = Float.NaN;
        this.f2102k = -1;
        this.f2103l = null;
        this.f2104m = Float.NaN;
        this.f2105n = null;
        this.f2106o = new HashMap();
        this.f2107p = 0;
        this.f2108q = new double[18];
        this.f2109r = new double[18];
        if (motionPaths.f2103l != null) {
            float f3 = motionKeyPosition.mFramePosition / 100.0f;
            this.f2094c = f3;
            this.f2093b = motionKeyPosition.mDrawPath;
            this.f2107p = motionKeyPosition.mPositionType;
            float f4 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f3 : motionKeyPosition.mPercentWidth;
            float f5 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f3 : motionKeyPosition.mPercentHeight;
            float f6 = motionPaths2.f2098g;
            float f7 = motionPaths.f2098g;
            float f8 = motionPaths2.f2099h;
            float f9 = motionPaths.f2099h;
            this.f2095d = this.f2094c;
            this.f2098g = (int) (((f6 - f7) * f4) + f7);
            this.f2099h = (int) (((f8 - f9) * f5) + f9);
            int i4 = motionKeyPosition.mPositionType;
            if (i4 == 1) {
                float f10 = Float.isNaN(motionKeyPosition.mPercentX) ? f3 : motionKeyPosition.mPercentX;
                float f11 = motionPaths2.f2096e;
                float f12 = motionPaths.f2096e;
                this.f2096e = AbstractC1726qj.m7051g(f11, f12, f10, f12);
                f3 = Float.isNaN(motionKeyPosition.mPercentY) ? f3 : motionKeyPosition.mPercentY;
                float f13 = motionPaths2.f2097f;
                float f14 = motionPaths.f2097f;
                this.f2097f = AbstractC1726qj.m7051g(f13, f14, f3, f14);
            } else if (i4 != 2) {
                float f15 = Float.isNaN(motionKeyPosition.mPercentX) ? f3 : motionKeyPosition.mPercentX;
                float f16 = motionPaths2.f2096e;
                float f17 = motionPaths.f2096e;
                this.f2096e = AbstractC1726qj.m7051g(f16, f17, f15, f17);
                f3 = Float.isNaN(motionKeyPosition.mPercentY) ? f3 : motionKeyPosition.mPercentY;
                float f18 = motionPaths2.f2097f;
                float f19 = motionPaths.f2097f;
                this.f2097f = AbstractC1726qj.m7051g(f18, f19, f3, f19);
            } else {
                if (Float.isNaN(motionKeyPosition.mPercentX)) {
                    float f20 = motionPaths2.f2096e;
                    float f21 = motionPaths.f2096e;
                    min = AbstractC1726qj.m7051g(f20, f21, f3, f21);
                } else {
                    min = Math.min(f5, f4) * motionKeyPosition.mPercentX;
                }
                this.f2096e = min;
                if (Float.isNaN(motionKeyPosition.mPercentY)) {
                    float f22 = motionPaths2.f2097f;
                    float f23 = motionPaths.f2097f;
                    f2 = AbstractC1726qj.m7051g(f22, f23, f3, f23);
                } else {
                    f2 = motionKeyPosition.mPercentY;
                }
                this.f2097f = f2;
            }
            this.f2103l = motionPaths.f2103l;
            this.f2092a = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
            this.f2102k = motionKeyPosition.mPathMotionArc;
            return;
        }
        int i5 = motionKeyPosition.mPositionType;
        if (i5 == 1) {
            float f24 = motionKeyPosition.mFramePosition / 100.0f;
            this.f2094c = f24;
            this.f2093b = motionKeyPosition.mDrawPath;
            float f25 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f24 : motionKeyPosition.mPercentWidth;
            float f26 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f24 : motionKeyPosition.mPercentHeight;
            float f27 = motionPaths2.f2098g - motionPaths.f2098g;
            float f28 = motionPaths2.f2099h - motionPaths.f2099h;
            this.f2095d = this.f2094c;
            f24 = Float.isNaN(motionKeyPosition.mPercentX) ? f24 : motionKeyPosition.mPercentX;
            float f29 = motionPaths.f2096e;
            float f30 = motionPaths.f2098g;
            float f31 = motionPaths.f2097f;
            float f32 = motionPaths.f2099h;
            float f33 = ((motionPaths2.f2098g / 2.0f) + motionPaths2.f2096e) - ((f30 / 2.0f) + f29);
            float f34 = ((motionPaths2.f2099h / 2.0f) + motionPaths2.f2097f) - ((f32 / 2.0f) + f31);
            float f35 = f33 * f24;
            float f36 = (f27 * f25) / 2.0f;
            this.f2096e = (int) ((f29 + f35) - f36);
            float f37 = f24 * f34;
            float f38 = (f28 * f26) / 2.0f;
            this.f2097f = (int) ((f31 + f37) - f38);
            this.f2098g = (int) (f30 + r6);
            this.f2099h = (int) (f32 + r8);
            float f39 = Float.isNaN(motionKeyPosition.mPercentY) ? RecyclerView.f7068F0 : motionKeyPosition.mPercentY;
            this.f2107p = 1;
            float f40 = (int) ((motionPaths.f2096e + f35) - f36);
            float f41 = (int) ((motionPaths.f2097f + f37) - f38);
            this.f2096e = f40 + ((-f34) * f39);
            this.f2097f = f41 + (f33 * f39);
            this.f2103l = this.f2103l;
            this.f2092a = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
            this.f2102k = motionKeyPosition.mPathMotionArc;
            return;
        }
        if (i5 != 2) {
            float f42 = motionKeyPosition.mFramePosition / 100.0f;
            this.f2094c = f42;
            this.f2093b = motionKeyPosition.mDrawPath;
            float f43 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f42 : motionKeyPosition.mPercentWidth;
            float f44 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f42 : motionKeyPosition.mPercentHeight;
            float f45 = motionPaths2.f2098g;
            float f46 = motionPaths.f2098g;
            float f47 = f45 - f46;
            float f48 = motionPaths2.f2099h;
            float f49 = motionPaths.f2099h;
            float f50 = f48 - f49;
            this.f2095d = this.f2094c;
            float f51 = motionPaths.f2096e;
            float f52 = motionPaths.f2097f;
            float f53 = ((f45 / 2.0f) + motionPaths2.f2096e) - ((f46 / 2.0f) + f51);
            float f54 = ((f48 / 2.0f) + motionPaths2.f2097f) - ((f49 / 2.0f) + f52);
            float f55 = (f47 * f43) / 2.0f;
            this.f2096e = (int) (((f53 * f42) + f51) - f55);
            float f56 = (f54 * f42) + f52;
            float f57 = (f50 * f44) / 2.0f;
            this.f2097f = (int) (f56 - f57);
            this.f2098g = (int) (f46 + r12);
            this.f2099h = (int) (f49 + r15);
            float f58 = Float.isNaN(motionKeyPosition.mPercentX) ? f42 : motionKeyPosition.mPercentX;
            float f59 = Float.isNaN(motionKeyPosition.mAltPercentY) ? RecyclerView.f7068F0 : motionKeyPosition.mAltPercentY;
            f42 = Float.isNaN(motionKeyPosition.mPercentY) ? f42 : motionKeyPosition.mPercentY;
            if (Float.isNaN(motionKeyPosition.mAltPercentX)) {
                i3 = 0;
                f = RecyclerView.f7068F0;
            } else {
                f = motionKeyPosition.mAltPercentX;
                i3 = 0;
            }
            this.f2107p = i3;
            this.f2096e = (int) (((f * f54) + ((f58 * f53) + motionPaths.f2096e)) - f55);
            this.f2097f = (int) (((f54 * f42) + ((f53 * f59) + motionPaths.f2097f)) - f57);
            this.f2092a = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
            this.f2102k = motionKeyPosition.mPathMotionArc;
            return;
        }
        float f60 = motionKeyPosition.mFramePosition / 100.0f;
        this.f2094c = f60;
        this.f2093b = motionKeyPosition.mDrawPath;
        float f61 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f60 : motionKeyPosition.mPercentWidth;
        float f62 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f60 : motionKeyPosition.mPercentHeight;
        float f63 = motionPaths2.f2098g;
        float f64 = f63 - motionPaths.f2098g;
        float f65 = motionPaths2.f2099h;
        float f66 = f65 - motionPaths.f2099h;
        this.f2095d = this.f2094c;
        float f67 = motionPaths.f2096e;
        float f68 = motionPaths.f2097f;
        float f69 = (f63 / 2.0f) + motionPaths2.f2096e;
        float f70 = (f65 / 2.0f) + motionPaths2.f2097f;
        float f71 = f64 * f61;
        this.f2096e = (int) ((((f69 - ((r8 / 2.0f) + f67)) * f60) + f67) - (f71 / 2.0f));
        float f72 = f66 * f62;
        this.f2097f = (int) ((((f70 - ((r13 / 2.0f) + f68)) * f60) + f68) - (f72 / 2.0f));
        this.f2098g = (int) (r8 + f71);
        this.f2099h = (int) (r13 + f72);
        this.f2107p = 2;
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            this.f2096e = (int) (motionKeyPosition.mPercentX * (i - ((int) this.f2098g)));
        }
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            this.f2097f = (int) (motionKeyPosition.mPercentY * (i2 - ((int) this.f2099h)));
        }
        this.f2103l = this.f2103l;
        this.f2092a = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.f2102k = motionKeyPosition.mPathMotionArc;
    }
}
