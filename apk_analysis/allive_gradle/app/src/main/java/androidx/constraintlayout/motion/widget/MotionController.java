package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.utils.CustomSupport;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import p000.AbstractC1726qj;
import p000.cp1;
import p000.lp1;

/* loaded from: classes.dex */
public class MotionController {
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    public static final int ROTATION_LEFT = 2;
    public static final int ROTATION_RIGHT = 1;
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;

    /* renamed from: A */
    public KeyTrigger[] f2788A;

    /* renamed from: B */
    public int f2789B;

    /* renamed from: C */
    public int f2790C;

    /* renamed from: D */
    public View f2791D;

    /* renamed from: E */
    public int f2792E;

    /* renamed from: F */
    public float f2793F;

    /* renamed from: G */
    public Interpolator f2794G;

    /* renamed from: H */
    public boolean f2795H;

    /* renamed from: b */
    public View f2797b;

    /* renamed from: c */
    public int f2798c;

    /* renamed from: j */
    public CurveFit[] f2805j;

    /* renamed from: k */
    public CurveFit f2806k;

    /* renamed from: o */
    public int[] f2810o;

    /* renamed from: p */
    public double[] f2811p;

    /* renamed from: q */
    public double[] f2812q;

    /* renamed from: r */
    public String[] f2813r;

    /* renamed from: s */
    public int[] f2814s;

    /* renamed from: x */
    public HashMap f2819x;

    /* renamed from: y */
    public HashMap f2820y;

    /* renamed from: z */
    public HashMap f2821z;

    /* renamed from: a */
    public final Rect f2796a = new Rect();

    /* renamed from: d */
    public boolean f2799d = false;

    /* renamed from: e */
    public int f2800e = -1;

    /* renamed from: f */
    public final lp1 f2801f = new lp1();

    /* renamed from: g */
    public final lp1 f2802g = new lp1();

    /* renamed from: h */
    public final cp1 f2803h = new cp1();

    /* renamed from: i */
    public final cp1 f2804i = new cp1();

    /* renamed from: l */
    public float f2807l = Float.NaN;

    /* renamed from: m */
    public float f2808m = RecyclerView.f7068F0;

    /* renamed from: n */
    public float f2809n = 1.0f;

    /* renamed from: t */
    public final float[] f2815t = new float[4];

    /* renamed from: u */
    public final ArrayList f2816u = new ArrayList();

    /* renamed from: v */
    public final float[] f2817v = new float[1];

    /* renamed from: w */
    public final ArrayList f2818w = new ArrayList();

    public MotionController(View view) {
        int i = Key.UNSET;
        this.f2789B = i;
        this.f2790C = i;
        this.f2791D = null;
        this.f2792E = i;
        this.f2793F = Float.NaN;
        this.f2794G = null;
        this.f2795H = false;
        setView(view);
    }

    /* renamed from: h */
    public static void m562h(int i, int i2, int i3, Rect rect, Rect rect2) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        int i4 = rect.left + rect.right;
                        rect2.left = i2 - ((rect.width() + (rect.bottom + rect.top)) / 2);
                        rect2.top = (i4 - rect.height()) / 2;
                        rect2.right = rect.width() + rect2.left;
                        rect2.bottom = rect.height() + rect2.top;
                        return;
                    }
                    return;
                }
                int i5 = rect.left + rect.right;
                rect2.left = ((rect.height() / 2) + rect.top) - (i5 / 2);
                rect2.top = i3 - ((rect.height() + i5) / 2);
                rect2.right = rect.width() + rect2.left;
                rect2.bottom = rect.height() + rect2.top;
                return;
            }
            int i6 = rect.left + rect.right;
            rect2.left = i2 - ((rect.width() + (rect.top + rect.bottom)) / 2);
            rect2.top = (i6 - rect.height()) / 2;
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        int i7 = rect.left + rect.right;
        rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
        rect2.top = i3 - ((rect.height() + i7) / 2);
        rect2.right = rect.width() + rect2.left;
        rect2.bottom = rect.height() + rect2.top;
    }

    /* renamed from: a */
    public final int m563a(int[] iArr, float[] fArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.f2805j[0].getTimePoints();
        if (iArr != null) {
            Iterator it = this.f2816u.iterator();
            int i = 0;
            while (it.hasNext()) {
                iArr[i] = ((lp1) it.next()).f22622o;
                i++;
            }
        }
        int i2 = 0;
        for (int i3 = 0; i3 < timePoints.length; i3++) {
            this.f2805j[0].getPos(timePoints[i3], this.f2811p);
            this.f2801f.m5966c(timePoints[i3], this.f2810o, this.f2811p, fArr, i2);
            i2 += 2;
        }
        return i2 / 2;
    }

    public void addKey(Key key) {
        this.f2818w.add(key);
    }

    /* renamed from: b */
    public final void m564b(float[] fArr, int i) {
        SplineSet splineSet;
        SplineSet splineSet2;
        ViewOscillator viewOscillator;
        double d;
        float f = 1.0f;
        float f2 = 1.0f / (i - 1);
        HashMap hashMap = this.f2820y;
        ViewOscillator viewOscillator2 = null;
        if (hashMap == null) {
            splineSet = null;
        } else {
            splineSet = (SplineSet) hashMap.get("translationX");
        }
        HashMap hashMap2 = this.f2820y;
        if (hashMap2 == null) {
            splineSet2 = null;
        } else {
            splineSet2 = (SplineSet) hashMap2.get("translationY");
        }
        HashMap hashMap3 = this.f2821z;
        if (hashMap3 == null) {
            viewOscillator = null;
        } else {
            viewOscillator = (ViewOscillator) hashMap3.get("translationX");
        }
        HashMap hashMap4 = this.f2821z;
        if (hashMap4 != null) {
            viewOscillator2 = (ViewOscillator) hashMap4.get("translationY");
        }
        ViewOscillator viewOscillator3 = viewOscillator2;
        int i2 = 0;
        while (i2 < i) {
            float f3 = i2 * f2;
            float f4 = this.f2809n;
            float f5 = RecyclerView.f7068F0;
            if (f4 != f) {
                float f6 = this.f2808m;
                if (f3 < f6) {
                    f3 = 0.0f;
                }
                if (f3 > f6 && f3 < 1.0d) {
                    f3 = Math.min((f3 - f6) * f4, f);
                }
            }
            float f7 = f3;
            double d2 = f7;
            Easing easing = this.f2801f.f22608a;
            Iterator it = this.f2816u.iterator();
            float f8 = Float.NaN;
            while (it.hasNext()) {
                lp1 lp1Var = (lp1) it.next();
                Easing easing2 = lp1Var.f22608a;
                double d3 = d2;
                if (easing2 != null) {
                    float f9 = lp1Var.f22610c;
                    if (f9 < f7) {
                        f5 = f9;
                        easing = easing2;
                    } else if (Float.isNaN(f8)) {
                        f8 = lp1Var.f22610c;
                    }
                }
                d2 = d3;
            }
            double d4 = d2;
            if (easing != null) {
                if (Float.isNaN(f8)) {
                    f8 = 1.0f;
                }
                d = (((float) easing.get((f7 - f5) / r16)) * (f8 - f5)) + f5;
            } else {
                d = d4;
            }
            this.f2805j[0].getPos(d, this.f2811p);
            CurveFit curveFit = this.f2806k;
            if (curveFit != null) {
                double[] dArr = this.f2811p;
                if (dArr.length > 0) {
                    curveFit.getPos(d, dArr);
                }
            }
            int i3 = i2 * 2;
            int i4 = i2;
            this.f2801f.m5966c(d, this.f2810o, this.f2811p, fArr, i3);
            if (viewOscillator != null) {
                fArr[i3] = viewOscillator.get(f7) + fArr[i3];
            } else if (splineSet != null) {
                fArr[i3] = splineSet.get(f7) + fArr[i3];
            }
            if (viewOscillator3 != null) {
                int i5 = i3 + 1;
                fArr[i5] = viewOscillator3.get(f7) + fArr[i5];
            } else if (splineSet2 != null) {
                int i6 = i3 + 1;
                fArr[i6] = splineSet2.get(f7) + fArr[i6];
            }
            i2 = i4 + 1;
            f = 1.0f;
        }
    }

    /* renamed from: c */
    public final float m565c(float f, float[] fArr) {
        float f2 = RecyclerView.f7068F0;
        float f3 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f4 = this.f2809n;
            if (f4 != 1.0d) {
                float f5 = this.f2808m;
                if (f < f5) {
                    f = 0.0f;
                }
                if (f > f5 && f < 1.0d) {
                    f = Math.min((f - f5) * f4, 1.0f);
                }
            }
        }
        Easing easing = this.f2801f.f22608a;
        Iterator it = this.f2816u.iterator();
        float f6 = Float.NaN;
        while (it.hasNext()) {
            lp1 lp1Var = (lp1) it.next();
            Easing easing2 = lp1Var.f22608a;
            if (easing2 != null) {
                float f7 = lp1Var.f22610c;
                if (f7 < f) {
                    easing = easing2;
                    f2 = f7;
                } else if (Float.isNaN(f6)) {
                    f6 = lp1Var.f22610c;
                }
            }
        }
        if (easing != null) {
            if (!Float.isNaN(f6)) {
                f3 = f6;
            }
            float f8 = f3 - f2;
            double d = (f - f2) / f8;
            f = (((float) easing.get(d)) * f8) + f2;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d);
            }
        }
        return f;
    }

    /* renamed from: d */
    public final void m566d(float f, float f2, float f3, float[] fArr) {
        double[] dArr;
        float[] fArr2 = this.f2817v;
        float m565c = m565c(f, fArr2);
        CurveFit[] curveFitArr = this.f2805j;
        int i = 0;
        if (curveFitArr != null) {
            double d = m565c;
            curveFitArr[0].getSlope(d, this.f2812q);
            this.f2805j[0].getPos(d, this.f2811p);
            float f4 = fArr2[0];
            while (true) {
                dArr = this.f2812q;
                if (i >= dArr.length) {
                    break;
                }
                dArr[i] = dArr[i] * f4;
                i++;
            }
            CurveFit curveFit = this.f2806k;
            if (curveFit != null) {
                double[] dArr2 = this.f2811p;
                if (dArr2.length > 0) {
                    curveFit.getPos(d, dArr2);
                    this.f2806k.getSlope(d, this.f2812q);
                    int[] iArr = this.f2810o;
                    double[] dArr3 = this.f2812q;
                    double[] dArr4 = this.f2811p;
                    this.f2801f.getClass();
                    lp1.m5964f(f2, f3, fArr, iArr, dArr3, dArr4);
                    return;
                }
                return;
            }
            int[] iArr2 = this.f2810o;
            double[] dArr5 = this.f2811p;
            this.f2801f.getClass();
            lp1.m5964f(f2, f3, fArr, iArr2, dArr, dArr5);
            return;
        }
        lp1 lp1Var = this.f2802g;
        float f5 = lp1Var.f22612e;
        lp1 lp1Var2 = this.f2801f;
        float f6 = f5 - lp1Var2.f22612e;
        float f7 = lp1Var.f22613f - lp1Var2.f22613f;
        float f8 = lp1Var.f22614g - lp1Var2.f22614g;
        float f9 = (lp1Var.f22615h - lp1Var2.f22615h) + f7;
        fArr[0] = ((f8 + f6) * f2) + ((1.0f - f2) * f6);
        fArr[1] = (f9 * f3) + ((1.0f - f3) * f7);
    }

    /* renamed from: e */
    public final float m567e(int i, float f, float f2) {
        lp1 lp1Var = this.f2802g;
        float f3 = lp1Var.f22612e;
        lp1 lp1Var2 = this.f2801f;
        float f4 = lp1Var2.f22612e;
        float f5 = f3 - f4;
        float f6 = lp1Var.f22613f;
        float f7 = lp1Var2.f22613f;
        float f8 = f6 - f7;
        float f9 = (lp1Var2.f22614g / 2.0f) + f4;
        float f10 = (lp1Var2.f22615h / 2.0f) + f7;
        float hypot = (float) Math.hypot(f5, f8);
        if (hypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f11 = f - f9;
        float f12 = f2 - f10;
        if (((float) Math.hypot(f11, f12)) == RecyclerView.f7068F0) {
            return RecyclerView.f7068F0;
        }
        float f13 = (f12 * f8) + (f11 * f5);
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return RecyclerView.f7068F0;
                            }
                            return f12 / f8;
                        }
                        return f11 / f8;
                    }
                    return f12 / f5;
                }
                return f11 / f5;
            }
            return (float) Math.sqrt((hypot * hypot) - (f13 * f13));
        }
        return f13 / hypot;
    }

    /* renamed from: f */
    public final boolean m568f(View view, float f, long j, KeyCache keyCache) {
        ViewTimeCycle.PathRotate pathRotate;
        boolean z;
        View view2;
        float f2;
        int i;
        double d;
        ViewTimeCycle.PathRotate pathRotate2;
        lp1 lp1Var;
        float f3;
        lp1 lp1Var2;
        double d2;
        float f4;
        boolean z2;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        MotionController motionController = this;
        View view3 = view;
        float m565c = motionController.m565c(f, null);
        int i2 = motionController.f2792E;
        if (i2 != Key.UNSET) {
            float f11 = 1.0f / i2;
            float floor = ((float) Math.floor(m565c / f11)) * f11;
            float f12 = (m565c % f11) / f11;
            if (!Float.isNaN(motionController.f2793F)) {
                f12 = (f12 + motionController.f2793F) % 1.0f;
            }
            Interpolator interpolator = motionController.f2794G;
            if (interpolator != null) {
                f10 = interpolator.getInterpolation(f12);
            } else if (f12 > 0.5d) {
                f10 = 1.0f;
            } else {
                f10 = RecyclerView.f7068F0;
            }
            m565c = (f10 * f11) + floor;
        }
        float f13 = m565c;
        HashMap hashMap = motionController.f2820y;
        if (hashMap != null) {
            Iterator it = hashMap.values().iterator();
            while (it.hasNext()) {
                ((ViewSpline) it.next()).setProperty(view3, f13);
            }
        }
        HashMap hashMap2 = motionController.f2819x;
        if (hashMap2 != null) {
            pathRotate = null;
            boolean z3 = false;
            for (ViewTimeCycle viewTimeCycle : hashMap2.values()) {
                if (viewTimeCycle instanceof ViewTimeCycle.PathRotate) {
                    pathRotate = (ViewTimeCycle.PathRotate) viewTimeCycle;
                } else {
                    z3 |= viewTimeCycle.setProperty(view, f13, j, keyCache);
                }
            }
            z = z3;
        } else {
            pathRotate = null;
            z = false;
        }
        CurveFit[] curveFitArr = motionController.f2805j;
        lp1 lp1Var3 = motionController.f2801f;
        if (curveFitArr != null) {
            double d3 = f13;
            curveFitArr[0].getPos(d3, motionController.f2811p);
            motionController.f2805j[0].getSlope(d3, motionController.f2812q);
            CurveFit curveFit = motionController.f2806k;
            if (curveFit != null) {
                double[] dArr = motionController.f2811p;
                if (dArr.length > 0) {
                    curveFit.getPos(d3, dArr);
                    motionController.f2806k.getSlope(d3, motionController.f2812q);
                }
            }
            if (!motionController.f2795H) {
                int[] iArr = motionController.f2810o;
                double[] dArr2 = motionController.f2811p;
                double[] dArr3 = motionController.f2812q;
                boolean z4 = motionController.f2799d;
                float f14 = lp1Var3.f22612e;
                float f15 = lp1Var3.f22613f;
                float f16 = lp1Var3.f22614g;
                float f17 = lp1Var3.f22615h;
                if (iArr.length != 0) {
                    f4 = f14;
                    if (lp1Var3.f22623p.length <= iArr[iArr.length - 1]) {
                        int i3 = iArr[iArr.length - 1] + 1;
                        lp1Var3.f22623p = new double[i3];
                        lp1Var3.f22624q = new double[i3];
                    }
                } else {
                    f4 = f14;
                }
                f3 = f13;
                Arrays.fill(lp1Var3.f22623p, Double.NaN);
                for (int i4 = 0; i4 < iArr.length; i4++) {
                    double[] dArr4 = lp1Var3.f22623p;
                    int i5 = iArr[i4];
                    dArr4[i5] = dArr2[i4];
                    lp1Var3.f22624q[i5] = dArr3[i4];
                }
                float f18 = Float.NaN;
                pathRotate2 = pathRotate;
                float f19 = f17;
                float f20 = f4;
                float f21 = RecyclerView.f7068F0;
                int i6 = 0;
                float f22 = RecyclerView.f7068F0;
                float f23 = RecyclerView.f7068F0;
                float f24 = RecyclerView.f7068F0;
                while (true) {
                    double[] dArr5 = lp1Var3.f22623p;
                    z2 = z4;
                    f5 = f23;
                    if (i6 >= dArr5.length) {
                        break;
                    }
                    if (Double.isNaN(dArr5[i6])) {
                        f9 = f20;
                        f8 = f19;
                    } else {
                        double d4 = 0.0d;
                        if (!Double.isNaN(lp1Var3.f22623p[i6])) {
                            d4 = lp1Var3.f22623p[i6] + 0.0d;
                        }
                        f8 = f19;
                        float f25 = (float) d4;
                        f9 = f20;
                        float f26 = (float) lp1Var3.f22624q[i6];
                        if (i6 != 1) {
                            if (i6 != 2) {
                                if (i6 != 3) {
                                    if (i6 != 4) {
                                        if (i6 == 5) {
                                            f19 = f8;
                                            f18 = f25;
                                        }
                                    } else {
                                        f24 = f26;
                                        f19 = f25;
                                    }
                                } else {
                                    f19 = f8;
                                    f16 = f25;
                                    f20 = f9;
                                    f23 = f26;
                                }
                            } else {
                                f19 = f8;
                                f22 = f26;
                                f15 = f25;
                            }
                            f23 = f5;
                            f20 = f9;
                        } else {
                            f19 = f8;
                            f21 = f26;
                            f20 = f25;
                            f23 = f5;
                        }
                        i6++;
                        z4 = z2;
                    }
                    f19 = f8;
                    f23 = f5;
                    f20 = f9;
                    i6++;
                    z4 = z2;
                }
                float f27 = f20;
                float f28 = f19;
                MotionController motionController2 = lp1Var3.f22620m;
                if (motionController2 != null) {
                    float[] fArr = new float[2];
                    float[] fArr2 = new float[2];
                    motionController2.getCenter(d3, fArr, fArr2);
                    float f29 = fArr[0];
                    float f30 = fArr[1];
                    float f31 = fArr2[0];
                    float f32 = fArr2[1];
                    d = d3;
                    double d5 = f27;
                    double d6 = f15;
                    float sin = (float) (((Math.sin(d6) * d5) + f29) - (f16 / 2.0f));
                    lp1Var = lp1Var3;
                    float cos = (float) ((f30 - (Math.cos(d6) * d5)) - (f28 / 2.0f));
                    double d7 = f21;
                    f6 = f16;
                    double d8 = f22;
                    float cos2 = (float) ((Math.cos(d6) * d5 * d8) + (Math.sin(d6) * d7) + f31);
                    float sin2 = (float) ((Math.sin(d6) * d5 * d8) + (f32 - (Math.cos(d6) * d7)));
                    if (dArr3.length >= 2) {
                        dArr3[0] = cos2;
                        dArr3[1] = sin2;
                    }
                    if (!Float.isNaN(f18)) {
                        view3 = view;
                        view3.setRotation((float) (Math.toDegrees(Math.atan2(sin2, cos2)) + f18));
                    } else {
                        view3 = view;
                    }
                    f15 = cos;
                    f7 = sin;
                } else {
                    f6 = f16;
                    d = d3;
                    lp1Var = lp1Var3;
                    if (!Float.isNaN(f18)) {
                        view3.setRotation(f18 + ((float) Math.toDegrees(Math.atan2((f24 / 2.0f) + f22, (f5 / 2.0f) + f21))) + RecyclerView.f7068F0);
                    }
                    f7 = f27;
                }
                if (view3 instanceof FloatLayout) {
                    ((FloatLayout) view3).layout(f7, f15, f7 + f6, f15 + f28);
                } else {
                    float f33 = f7 + 0.5f;
                    int i7 = (int) f33;
                    float f34 = f15 + 0.5f;
                    int i8 = (int) f34;
                    int i9 = (int) (f33 + f6);
                    int i10 = (int) (f34 + f28);
                    int i11 = i9 - i7;
                    int i12 = i10 - i8;
                    if (i11 != view.getMeasuredWidth() || i12 != view.getMeasuredHeight() || z2) {
                        view3.measure(View.MeasureSpec.makeMeasureSpec(i11, 1073741824), View.MeasureSpec.makeMeasureSpec(i12, 1073741824));
                    }
                    view3.layout(i7, i8, i9, i10);
                }
                motionController = this;
                motionController.f2799d = false;
            } else {
                d = d3;
                pathRotate2 = pathRotate;
                lp1Var = lp1Var3;
                f3 = f13;
            }
            if (motionController.f2790C != Key.UNSET) {
                if (motionController.f2791D == null) {
                    motionController.f2791D = ((View) view.getParent()).findViewById(motionController.f2790C);
                }
                if (motionController.f2791D != null) {
                    float bottom = (motionController.f2791D.getBottom() + r1.getTop()) / 2.0f;
                    float right = (motionController.f2791D.getRight() + motionController.f2791D.getLeft()) / 2.0f;
                    if (view.getRight() - view.getLeft() > 0 && view.getBottom() - view.getTop() > 0) {
                        view3.setPivotX(right - view.getLeft());
                        view3.setPivotY(bottom - view.getTop());
                    }
                }
            }
            HashMap hashMap3 = motionController.f2820y;
            if (hashMap3 != null) {
                for (SplineSet splineSet : hashMap3.values()) {
                    if (splineSet instanceof ViewSpline.PathRotate) {
                        double[] dArr6 = motionController.f2812q;
                        if (dArr6.length > 1) {
                            d2 = d;
                            ((ViewSpline.PathRotate) splineSet).setPathRotate(view, f3, dArr6[0], dArr6[1]);
                            d = d2;
                        }
                    }
                    d2 = d;
                    d = d2;
                }
            }
            double d9 = d;
            if (pathRotate2 != null) {
                double[] dArr7 = motionController.f2812q;
                i = 1;
                lp1Var2 = lp1Var;
                z |= pathRotate2.setPathRotate(view, keyCache, f3, j, dArr7[0], dArr7[1]);
            } else {
                lp1Var2 = lp1Var;
                i = 1;
            }
            int i13 = i;
            while (true) {
                CurveFit[] curveFitArr2 = motionController.f2805j;
                if (i13 >= curveFitArr2.length) {
                    break;
                }
                CurveFit curveFit2 = curveFitArr2[i13];
                float[] fArr3 = motionController.f2815t;
                curveFit2.getPos(d9, fArr3);
                CustomSupport.setInterpolatedValue((ConstraintAttribute) lp1Var2.f22621n.get(motionController.f2813r[i13 - 1]), view, fArr3);
                i13++;
            }
            view2 = view;
            cp1 cp1Var = motionController.f2803h;
            if (cp1Var.f16047b == 0) {
                if (f3 <= RecyclerView.f7068F0) {
                    view2.setVisibility(cp1Var.f16048c);
                } else {
                    cp1 cp1Var2 = motionController.f2804i;
                    if (f3 >= 1.0f) {
                        view2.setVisibility(cp1Var2.f16048c);
                    } else if (cp1Var2.f16048c != cp1Var.f16048c) {
                        view2.setVisibility(0);
                    }
                }
            }
            if (motionController.f2788A != null) {
                int i14 = 0;
                while (true) {
                    KeyTrigger[] keyTriggerArr = motionController.f2788A;
                    if (i14 >= keyTriggerArr.length) {
                        break;
                    }
                    keyTriggerArr[i14].conditionallyFire(f3, view2);
                    i14++;
                }
            }
            f2 = f3;
        } else {
            view2 = view3;
            f2 = f13;
            i = 1;
            float f35 = lp1Var3.f22612e;
            lp1 lp1Var4 = motionController.f2802g;
            float m7051g = AbstractC1726qj.m7051g(lp1Var4.f22612e, f35, f2, f35);
            float f36 = lp1Var3.f22613f;
            float m7051g2 = AbstractC1726qj.m7051g(lp1Var4.f22613f, f36, f2, f36);
            float f37 = lp1Var3.f22614g;
            float f38 = lp1Var4.f22614g;
            float m7051g3 = AbstractC1726qj.m7051g(f38, f37, f2, f37);
            float f39 = lp1Var3.f22615h;
            float f40 = lp1Var4.f22615h;
            float f41 = m7051g + 0.5f;
            int i15 = (int) f41;
            float f42 = m7051g2 + 0.5f;
            int i16 = (int) f42;
            int i17 = (int) (f41 + m7051g3);
            int m7051g4 = (int) (f42 + AbstractC1726qj.m7051g(f40, f39, f2, f39));
            int i18 = i17 - i15;
            int i19 = m7051g4 - i16;
            if (f38 != f37 || f40 != f39 || motionController.f2799d) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(i18, 1073741824), View.MeasureSpec.makeMeasureSpec(i19, 1073741824));
                motionController.f2799d = false;
            }
            view2.layout(i15, i16, i17, m7051g4);
        }
        HashMap hashMap4 = motionController.f2821z;
        if (hashMap4 != null) {
            for (ViewOscillator viewOscillator : hashMap4.values()) {
                if (viewOscillator instanceof ViewOscillator.PathRotateSet) {
                    double[] dArr8 = motionController.f2812q;
                    ((ViewOscillator.PathRotateSet) viewOscillator).setPathRotate(view, f2, dArr8[0], dArr8[i]);
                } else {
                    viewOscillator.setProperty(view2, f2);
                }
            }
        }
        return z;
    }

    /* renamed from: g */
    public final void m569g(lp1 lp1Var) {
        lp1Var.m5968e((int) this.f2797b.getX(), (int) this.f2797b.getY(), this.f2797b.getWidth(), this.f2797b.getHeight());
    }

    public int getAnimateRelativeTo() {
        return this.f2801f.f22618k;
    }

    public void getCenter(double d, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f2805j[0].getPos(d, dArr);
        this.f2805j[0].getSlope(d, dArr2);
        float f = RecyclerView.f7068F0;
        Arrays.fill(fArr2, RecyclerView.f7068F0);
        int[] iArr = this.f2810o;
        lp1 lp1Var = this.f2801f;
        float f2 = lp1Var.f22612e;
        float f3 = lp1Var.f22613f;
        float f4 = lp1Var.f22614g;
        float f5 = lp1Var.f22615h;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f9 = (float) dArr[i];
            float f10 = (float) dArr2[i];
            int i2 = iArr[i];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            f5 = f9;
                            f7 = f10;
                        }
                    } else {
                        f4 = f9;
                        f6 = f10;
                    }
                } else {
                    f3 = f9;
                    f8 = f10;
                }
            } else {
                f2 = f9;
                f = f10;
            }
        }
        float f11 = 2.0f;
        float f12 = (f6 / 2.0f) + f;
        float f13 = (f7 / 2.0f) + f8;
        MotionController motionController = lp1Var.f22620m;
        if (motionController != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motionController.getCenter(d, fArr3, fArr4);
            float f14 = fArr3[0];
            float f15 = fArr3[1];
            float f16 = fArr4[0];
            float f17 = fArr4[1];
            double d2 = f2;
            double d3 = f3;
            float sin = (float) (((Math.sin(d3) * d2) + f14) - (f4 / 2.0f));
            float cos = (float) ((f15 - (Math.cos(d3) * d2)) - (f5 / 2.0f));
            double d4 = f16;
            double d5 = f;
            double d6 = f8;
            float cos2 = (float) ((Math.cos(d3) * d6) + (Math.sin(d3) * d5) + d4);
            f13 = (float) ((Math.sin(d3) * d6) + (f17 - (Math.cos(d3) * d5)));
            f2 = sin;
            f3 = cos;
            f12 = cos2;
            f11 = 2.0f;
        }
        fArr[0] = (f4 / f11) + f2 + RecyclerView.f7068F0;
        fArr[1] = (f5 / f11) + f3 + RecyclerView.f7068F0;
        fArr2[0] = f12;
        fArr2[1] = f13;
    }

    public float getCenterX() {
        return RecyclerView.f7068F0;
    }

    public float getCenterY() {
        return RecyclerView.f7068F0;
    }

    public int getDrawPath() {
        int i = this.f2801f.f22609b;
        Iterator it = this.f2816u.iterator();
        while (it.hasNext()) {
            i = Math.max(i, ((lp1) it.next()).f22609b);
        }
        return Math.max(i, this.f2802g.f22609b);
    }

    public float getFinalHeight() {
        return this.f2802g.f22615h;
    }

    public float getFinalWidth() {
        return this.f2802g.f22614g;
    }

    public float getFinalX() {
        return this.f2802g.f22612e;
    }

    public float getFinalY() {
        return this.f2802g.f22613f;
    }

    public int getKeyFrameInfo(int i, int[] iArr) {
        float[] fArr = new float[2];
        Iterator it = this.f2818w.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            Key key = (Key) it.next();
            int i4 = key.mType;
            if (i4 == i || i != -1) {
                iArr[i3] = 0;
                iArr[i3 + 1] = i4;
                int i5 = key.f2700a;
                iArr[i3 + 2] = i5;
                double d = i5 / 100.0f;
                this.f2805j[0].getPos(d, this.f2811p);
                this.f2801f.m5966c(d, this.f2810o, this.f2811p, fArr, 0);
                iArr[i3 + 3] = Float.floatToIntBits(fArr[0]);
                int i6 = i3 + 4;
                iArr[i6] = Float.floatToIntBits(fArr[1]);
                if (key instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) key;
                    iArr[i3 + 5] = keyPosition.f2749o;
                    iArr[i3 + 6] = Float.floatToIntBits(keyPosition.f2745k);
                    i6 = i3 + 7;
                    iArr[i6] = Float.floatToIntBits(keyPosition.f2746l);
                }
                int i7 = i6 + 1;
                iArr[i3] = i7 - i3;
                i2++;
                i3 = i7;
            }
        }
        return i2;
    }

    public int getKeyFramePositions(int[] iArr, float[] fArr) {
        Iterator it = this.f2818w.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            Key key = (Key) it.next();
            int i3 = key.f2700a;
            iArr[i] = (key.mType * 1000) + i3;
            double d = i3 / 100.0f;
            this.f2805j[0].getPos(d, this.f2811p);
            this.f2801f.m5966c(d, this.f2810o, this.f2811p, fArr, i2);
            i2 += 2;
            i++;
        }
        return i;
    }

    public float getStartHeight() {
        return this.f2801f.f22615h;
    }

    public float getStartWidth() {
        return this.f2801f.f22614g;
    }

    public float getStartX() {
        return this.f2801f.f22612e;
    }

    public float getStartY() {
        return this.f2801f.f22613f;
    }

    public int getTransformPivotTarget() {
        return this.f2790C;
    }

    public View getView() {
        return this.f2797b;
    }

    public void remeasure() {
        this.f2799d = true;
    }

    public void setDrawPath(int i) {
        this.f2801f.f22609b = i;
    }

    public void setPathMotionArc(int i) {
        this.f2789B = i;
    }

    public void setStartState(ViewState viewState, View view, int i, int i2, int i3) {
        lp1 lp1Var = this.f2801f;
        lp1Var.f22610c = RecyclerView.f7068F0;
        lp1Var.f22611d = RecyclerView.f7068F0;
        Rect rect = new Rect();
        if (i != 1) {
            if (i == 2) {
                int i4 = viewState.left + viewState.right;
                rect.left = i3 - ((viewState.width() + (viewState.top + viewState.bottom)) / 2);
                rect.top = (i4 - viewState.height()) / 2;
                rect.right = viewState.width() + rect.left;
                rect.bottom = viewState.height() + rect.top;
            }
        } else {
            int i5 = viewState.left + viewState.right;
            rect.left = ((viewState.top + viewState.bottom) - viewState.width()) / 2;
            rect.top = i2 - ((viewState.height() + i5) / 2);
            rect.right = viewState.width() + rect.left;
            rect.bottom = viewState.height() + rect.top;
        }
        lp1Var.m5968e(rect.left, rect.top, rect.width(), rect.height());
        float f = viewState.rotation;
        cp1 cp1Var = this.f2803h;
        cp1Var.getClass();
        rect.width();
        rect.height();
        cp1Var.m4484b(view);
        cp1Var.f16056k = Float.NaN;
        cp1Var.f16057l = Float.NaN;
        if (i != 1) {
            if (i == 2) {
                cp1Var.f16052g = f + 90.0f;
                return;
            }
            return;
        }
        cp1Var.f16052g = f - 90.0f;
    }

    public void setTransformPivotTarget(int i) {
        this.f2790C = i;
        this.f2791D = null;
    }

    public void setView(View view) {
        this.f2797b = view;
        this.f2798c = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
        }
    }

    /* JADX WARN: Type inference failed for: r10v27, types: [java.lang.Object, lp1] */
    public void setup(int i, int i2, float f, long j) {
        lp1 lp1Var;
        cp1 cp1Var;
        ArrayList arrayList;
        cp1 cp1Var2;
        HashSet hashSet;
        HashSet hashSet2;
        HashMap<String, Integer> hashMap;
        MotionController motionController;
        ArrayList arrayList2;
        HashSet hashSet3;
        ArrayList arrayList3;
        String[] strArr;
        lp1 lp1Var2;
        char c;
        String str;
        int i3;
        ConstraintAttribute constraintAttribute;
        ViewTimeCycle makeSpline;
        ConstraintAttribute constraintAttribute2;
        Integer num;
        Iterator it;
        ViewSpline makeSpline2;
        ConstraintAttribute constraintAttribute3;
        lp1 lp1Var3;
        cp1 cp1Var3;
        ArrayList arrayList4;
        cp1 cp1Var4;
        MotionController motionController2;
        ArrayList arrayList5;
        HashSet hashSet4;
        HashSet hashSet5;
        HashMap<String, Integer> hashMap2;
        HashSet hashSet6;
        HashSet hashSet7;
        HashMap<String, Integer> hashMap3;
        ArrayList arrayList6;
        HashSet hashSet8;
        HashSet hashSet9;
        KeyPosition keyPosition;
        float f2;
        float min;
        float f3;
        MotionController motionController3 = this;
        float f4 = Float.NaN;
        ArrayList arrayList7 = motionController3.f2816u;
        int i4 = 0;
        new HashSet();
        HashSet hashSet10 = new HashSet();
        HashSet hashSet11 = new HashSet();
        HashSet hashSet12 = new HashSet();
        HashMap<String, Integer> hashMap4 = new HashMap<>();
        int i5 = motionController3.f2789B;
        int i6 = Key.UNSET;
        lp1 lp1Var4 = motionController3.f2801f;
        if (i5 != i6) {
            lp1Var4.f22617j = i5;
        }
        cp1 cp1Var5 = motionController3.f2803h;
        float f5 = cp1Var5.f16050e;
        cp1 cp1Var6 = motionController3.f2804i;
        if (cp1.m4482c(f5, cp1Var6.f16050e)) {
            hashSet11.add("alpha");
        }
        if (cp1.m4482c(cp1Var5.f16051f, cp1Var6.f16051f)) {
            hashSet11.add("elevation");
        }
        int i7 = cp1Var5.f16048c;
        int i8 = cp1Var6.f16048c;
        if (i7 != i8 && cp1Var5.f16047b == 0 && (i7 == 0 || i8 == 0)) {
            hashSet11.add("alpha");
        }
        if (cp1.m4482c(cp1Var5.f16052g, cp1Var6.f16052g)) {
            hashSet11.add(Key.ROTATION);
        }
        if (!Float.isNaN(cp1Var5.f16061p) || !Float.isNaN(cp1Var6.f16061p)) {
            hashSet11.add("transitionPathRotate");
        }
        if (!Float.isNaN(cp1Var5.f16062q) || !Float.isNaN(cp1Var6.f16062q)) {
            hashSet11.add("progress");
        }
        if (cp1.m4482c(cp1Var5.f16053h, cp1Var6.f16053h)) {
            hashSet11.add("rotationX");
        }
        if (cp1.m4482c(cp1Var5.f16046a, cp1Var6.f16046a)) {
            hashSet11.add("rotationY");
        }
        if (cp1.m4482c(cp1Var5.f16056k, cp1Var6.f16056k)) {
            hashSet11.add(Key.PIVOT_X);
        }
        if (cp1.m4482c(cp1Var5.f16057l, cp1Var6.f16057l)) {
            hashSet11.add(Key.PIVOT_Y);
        }
        if (cp1.m4482c(cp1Var5.f16054i, cp1Var6.f16054i)) {
            hashSet11.add("scaleX");
        }
        if (cp1.m4482c(cp1Var5.f16055j, cp1Var6.f16055j)) {
            hashSet11.add("scaleY");
        }
        if (cp1.m4482c(cp1Var5.f16058m, cp1Var6.f16058m)) {
            hashSet11.add("translationX");
        }
        if (cp1.m4482c(cp1Var5.f16059n, cp1Var6.f16059n)) {
            hashSet11.add("translationY");
        }
        if (cp1.m4482c(cp1Var5.f16060o, cp1Var6.f16060o)) {
            hashSet11.add("translationZ");
        }
        ArrayList arrayList8 = motionController3.f2818w;
        lp1 lp1Var5 = motionController3.f2802g;
        MotionController motionController4 = null;
        if (arrayList8 != null) {
            Iterator it2 = arrayList8.iterator();
            ArrayList arrayList9 = null;
            while (it2.hasNext()) {
                Key key = (Key) it2.next();
                if (key instanceof KeyPosition) {
                    KeyPosition keyPosition2 = (KeyPosition) key;
                    ?? obj = new Object();
                    obj.f22609b = i4;
                    obj.f22616i = f4;
                    int i9 = Key.UNSET;
                    obj.f22617j = i9;
                    obj.f22618k = i9;
                    obj.f22619l = f4;
                    obj.f22620m = motionController4;
                    obj.f22621n = new LinkedHashMap();
                    obj.f22622o = 0;
                    obj.f22623p = new double[18];
                    obj.f22624q = new double[18];
                    if (lp1Var4.f22618k != Key.UNSET) {
                        float f6 = keyPosition2.f2700a / 100.0f;
                        obj.f22610c = f6;
                        obj.f22609b = keyPosition2.f2742h;
                        obj.f22622o = keyPosition2.f2749o;
                        float f7 = Float.isNaN(keyPosition2.f2743i) ? f6 : keyPosition2.f2743i;
                        if (Float.isNaN(keyPosition2.f2744j)) {
                            cp1Var3 = cp1Var6;
                            f2 = f6;
                        } else {
                            f2 = keyPosition2.f2744j;
                            cp1Var3 = cp1Var6;
                        }
                        float f8 = lp1Var5.f22614g;
                        cp1Var4 = cp1Var5;
                        float f9 = lp1Var4.f22614g;
                        arrayList4 = arrayList8;
                        float f10 = lp1Var5.f22615h;
                        hashSet7 = hashSet11;
                        float f11 = lp1Var4.f22615h;
                        hashMap3 = hashMap4;
                        obj.f22611d = obj.f22610c;
                        obj.f22614g = (int) (((f8 - f9) * f7) + f9);
                        obj.f22615h = (int) (((f10 - f11) * f2) + f11);
                        if (keyPosition2.f2749o != 2) {
                            float f12 = Float.isNaN(keyPosition2.f2745k) ? f6 : keyPosition2.f2745k;
                            float f13 = lp1Var5.f22612e;
                            float f14 = lp1Var4.f22612e;
                            obj.f22612e = AbstractC1726qj.m7051g(f13, f14, f12, f14);
                            if (!Float.isNaN(keyPosition2.f2746l)) {
                                f6 = keyPosition2.f2746l;
                            }
                            float f15 = lp1Var5.f22613f;
                            float f16 = lp1Var4.f22613f;
                            obj.f22613f = AbstractC1726qj.m7051g(f15, f16, f6, f16);
                        } else {
                            if (Float.isNaN(keyPosition2.f2745k)) {
                                float f17 = lp1Var5.f22612e;
                                float f18 = lp1Var4.f22612e;
                                min = AbstractC1726qj.m7051g(f17, f18, f6, f18);
                            } else {
                                min = keyPosition2.f2745k * Math.min(f2, f7);
                            }
                            obj.f22612e = min;
                            if (Float.isNaN(keyPosition2.f2746l)) {
                                float f19 = lp1Var5.f22613f;
                                float f20 = lp1Var4.f22613f;
                                f3 = AbstractC1726qj.m7051g(f19, f20, f6, f20);
                            } else {
                                f3 = keyPosition2.f2746l;
                            }
                            obj.f22613f = f3;
                        }
                        obj.f22618k = lp1Var4.f22618k;
                        obj.f22608a = Easing.getInterpolator(keyPosition2.f2740f);
                        obj.f22617j = keyPosition2.f2741g;
                        lp1Var3 = lp1Var4;
                        arrayList5 = arrayList7;
                        keyPosition = keyPosition2;
                        hashSet8 = hashSet10;
                        hashSet9 = hashSet12;
                    } else {
                        cp1Var3 = cp1Var6;
                        arrayList4 = arrayList8;
                        cp1Var4 = cp1Var5;
                        hashSet7 = hashSet11;
                        hashMap3 = hashMap4;
                        int i10 = keyPosition2.f2749o;
                        if (i10 == 1) {
                            lp1 lp1Var6 = lp1Var4;
                            arrayList6 = arrayList7;
                            hashSet8 = hashSet10;
                            hashSet9 = hashSet12;
                            float f21 = keyPosition2.f2700a / 100.0f;
                            obj.f22610c = f21;
                            obj.f22609b = keyPosition2.f2742h;
                            float f22 = Float.isNaN(keyPosition2.f2743i) ? f21 : keyPosition2.f2743i;
                            float f23 = Float.isNaN(keyPosition2.f2744j) ? f21 : keyPosition2.f2744j;
                            float f24 = lp1Var5.f22614g - lp1Var6.f22614g;
                            float f25 = lp1Var5.f22615h - lp1Var6.f22615h;
                            obj.f22611d = obj.f22610c;
                            if (!Float.isNaN(keyPosition2.f2745k)) {
                                f21 = keyPosition2.f2745k;
                            }
                            float f26 = lp1Var6.f22612e;
                            float f27 = lp1Var6.f22614g;
                            float f28 = lp1Var6.f22613f;
                            float f29 = lp1Var6.f22615h;
                            float f30 = ((lp1Var5.f22614g / 2.0f) + lp1Var5.f22612e) - ((f27 / 2.0f) + f26);
                            float f31 = ((lp1Var5.f22615h / 2.0f) + lp1Var5.f22613f) - ((f29 / 2.0f) + f28);
                            float f32 = f30 * f21;
                            float f33 = (f24 * f22) / 2.0f;
                            obj.f22612e = (int) ((f26 + f32) - f33);
                            float f34 = f21 * f31;
                            float f35 = (f25 * f23) / 2.0f;
                            obj.f22613f = (int) ((f28 + f34) - f35);
                            obj.f22614g = (int) (f27 + r3);
                            obj.f22615h = (int) (f29 + r5);
                            keyPosition = keyPosition2;
                            float f36 = Float.isNaN(keyPosition.f2746l) ? RecyclerView.f7068F0 : keyPosition.f2746l;
                            float f37 = (-f31) * f36;
                            float f38 = f30 * f36;
                            obj.f22622o = 1;
                            lp1Var3 = lp1Var6;
                            float f39 = (int) ((lp1Var3.f22612e + f32) - f33);
                            float f40 = (int) ((lp1Var3.f22613f + f34) - f35);
                            obj.f22612e = f39 + f37;
                            obj.f22613f = f40 + f38;
                            obj.f22618k = obj.f22618k;
                            obj.f22608a = Easing.getInterpolator(keyPosition.f2740f);
                            obj.f22617j = keyPosition.f2741g;
                        } else if (i10 == 2) {
                            ArrayList arrayList10 = arrayList7;
                            hashSet8 = hashSet10;
                            hashSet9 = hashSet12;
                            lp1 lp1Var7 = lp1Var4;
                            float f41 = keyPosition2.f2700a / 100.0f;
                            obj.f22610c = f41;
                            obj.f22609b = keyPosition2.f2742h;
                            float f42 = Float.isNaN(keyPosition2.f2743i) ? f41 : keyPosition2.f2743i;
                            float f43 = Float.isNaN(keyPosition2.f2744j) ? f41 : keyPosition2.f2744j;
                            float f44 = lp1Var5.f22614g;
                            float f45 = f44 - lp1Var7.f22614g;
                            float f46 = lp1Var5.f22615h;
                            float f47 = f46 - lp1Var7.f22615h;
                            obj.f22611d = obj.f22610c;
                            float f48 = lp1Var7.f22612e;
                            float f49 = lp1Var7.f22613f;
                            float f50 = (f44 / 2.0f) + lp1Var5.f22612e;
                            float f51 = (f46 / 2.0f) + lp1Var5.f22613f;
                            float f52 = f45 * f42;
                            obj.f22612e = (int) ((((f50 - ((r4 / 2.0f) + f48)) * f41) + f48) - (f52 / 2.0f));
                            float f53 = f47 * f43;
                            obj.f22613f = (int) ((((f51 - ((r11 / 2.0f) + f49)) * f41) + f49) - (f53 / 2.0f));
                            obj.f22614g = (int) (r4 + f52);
                            obj.f22615h = (int) (r11 + f53);
                            obj.f22622o = 2;
                            if (!Float.isNaN(keyPosition2.f2745k)) {
                                obj.f22612e = (int) (keyPosition2.f2745k * (i - ((int) obj.f22614g)));
                            }
                            if (!Float.isNaN(keyPosition2.f2746l)) {
                                obj.f22613f = (int) (keyPosition2.f2746l * (i2 - ((int) obj.f22615h)));
                            }
                            obj.f22618k = obj.f22618k;
                            obj.f22608a = Easing.getInterpolator(keyPosition2.f2740f);
                            obj.f22617j = keyPosition2.f2741g;
                            keyPosition = keyPosition2;
                            arrayList5 = arrayList10;
                            lp1Var3 = lp1Var7;
                        } else if (i10 != 3) {
                            float f54 = keyPosition2.f2700a / 100.0f;
                            obj.f22610c = f54;
                            obj.f22609b = keyPosition2.f2742h;
                            float f55 = Float.isNaN(keyPosition2.f2743i) ? f54 : keyPosition2.f2743i;
                            float f56 = Float.isNaN(keyPosition2.f2744j) ? f54 : keyPosition2.f2744j;
                            float f57 = lp1Var5.f22614g;
                            float f58 = lp1Var4.f22614g;
                            float f59 = f57 - f58;
                            float f60 = lp1Var5.f22615h;
                            float f61 = lp1Var4.f22615h;
                            float f62 = f60 - f61;
                            hashSet8 = hashSet10;
                            obj.f22611d = obj.f22610c;
                            float f63 = lp1Var4.f22612e;
                            hashSet9 = hashSet12;
                            float f64 = lp1Var4.f22613f;
                            float f65 = ((f57 / 2.0f) + lp1Var5.f22612e) - ((f58 / 2.0f) + f63);
                            float f66 = ((f60 / 2.0f) + lp1Var5.f22613f) - ((f61 / 2.0f) + f64);
                            float f67 = (f59 * f55) / 2.0f;
                            obj.f22612e = (int) (((f65 * f54) + f63) - f67);
                            float f68 = (f62 * f56) / 2.0f;
                            obj.f22613f = (int) (((f66 * f54) + f64) - f68);
                            obj.f22614g = (int) (f58 + r14);
                            obj.f22615h = (int) (f61 + r25);
                            float f69 = Float.isNaN(keyPosition2.f2745k) ? f54 : keyPosition2.f2745k;
                            float f70 = Float.isNaN(keyPosition2.f2748n) ? RecyclerView.f7068F0 : keyPosition2.f2748n;
                            if (!Float.isNaN(keyPosition2.f2746l)) {
                                f54 = keyPosition2.f2746l;
                            }
                            float f71 = Float.isNaN(keyPosition2.f2747m) ? RecyclerView.f7068F0 : keyPosition2.f2747m;
                            obj.f22622o = 0;
                            obj.f22612e = (int) (((f71 * f66) + ((f69 * f65) + lp1Var4.f22612e)) - f67);
                            obj.f22613f = (int) (((f66 * f54) + ((f65 * f70) + lp1Var4.f22613f)) - f68);
                            obj.f22608a = Easing.getInterpolator(keyPosition2.f2740f);
                            obj.f22617j = keyPosition2.f2741g;
                            lp1Var3 = lp1Var4;
                            arrayList5 = arrayList7;
                            keyPosition = keyPosition2;
                        } else {
                            hashSet8 = hashSet10;
                            hashSet9 = hashSet12;
                            float f72 = keyPosition2.f2700a / 100.0f;
                            obj.f22610c = f72;
                            obj.f22609b = keyPosition2.f2742h;
                            float f73 = Float.isNaN(keyPosition2.f2743i) ? f72 : keyPosition2.f2743i;
                            float f74 = Float.isNaN(keyPosition2.f2744j) ? f72 : keyPosition2.f2744j;
                            float f75 = lp1Var5.f22614g;
                            float f76 = lp1Var4.f22614g;
                            float f77 = f75 - f76;
                            float f78 = lp1Var5.f22615h;
                            float f79 = lp1Var4.f22615h;
                            float f80 = f78 - f79;
                            obj.f22611d = obj.f22610c;
                            float f81 = (f76 / 2.0f) + lp1Var4.f22612e;
                            arrayList6 = arrayList7;
                            float f82 = (f79 / 2.0f) + lp1Var4.f22613f;
                            lp1 lp1Var8 = lp1Var4;
                            float f83 = (f75 / 2.0f) + lp1Var5.f22612e;
                            float f84 = (f78 / 2.0f) + lp1Var5.f22613f;
                            if (f81 > f83) {
                                f81 = f83;
                                f83 = f81;
                            }
                            if (f82 <= f84) {
                                f82 = f84;
                                f84 = f82;
                            }
                            float f85 = f83 - f81;
                            float f86 = f82 - f84;
                            float f87 = (f77 * f73) / 2.0f;
                            obj.f22612e = (int) (((f85 * f72) + r14) - f87);
                            float f88 = (f80 * f74) / 2.0f;
                            obj.f22613f = (int) (((f86 * f72) + r7) - f88);
                            obj.f22614g = (int) (f76 + r8);
                            obj.f22615h = (int) (f79 + r13);
                            float f89 = Float.isNaN(keyPosition2.f2745k) ? f72 : keyPosition2.f2745k;
                            float f90 = Float.isNaN(keyPosition2.f2748n) ? RecyclerView.f7068F0 : keyPosition2.f2748n;
                            if (!Float.isNaN(keyPosition2.f2746l)) {
                                f72 = keyPosition2.f2746l;
                            }
                            float f91 = Float.isNaN(keyPosition2.f2747m) ? RecyclerView.f7068F0 : keyPosition2.f2747m;
                            obj.f22622o = 0;
                            obj.f22612e = (int) (((f91 * f86) + ((f89 * f85) + lp1Var8.f22612e)) - f87);
                            obj.f22613f = (int) (((f86 * f72) + ((f85 * f90) + lp1Var8.f22613f)) - f88);
                            obj.f22608a = Easing.getInterpolator(keyPosition2.f2740f);
                            obj.f22617j = keyPosition2.f2741g;
                            lp1Var3 = lp1Var8;
                            keyPosition = keyPosition2;
                        }
                        arrayList5 = arrayList6;
                    }
                    int binarySearch = Collections.binarySearch(arrayList5, obj);
                    if (binarySearch == 0) {
                        Log.e("MotionController", " KeyPath position \"" + obj.f22611d + "\" outside of range");
                    }
                    arrayList5.add((-binarySearch) - 1, obj);
                    int i11 = keyPosition.f20396e;
                    if (i11 != Key.UNSET) {
                        motionController2 = this;
                        motionController2.f2800e = i11;
                    } else {
                        motionController2 = this;
                    }
                    hashSet6 = hashSet7;
                    hashMap2 = hashMap3;
                    hashSet5 = hashSet8;
                    hashSet4 = hashSet9;
                } else {
                    lp1Var3 = lp1Var4;
                    cp1Var3 = cp1Var6;
                    arrayList4 = arrayList8;
                    cp1Var4 = cp1Var5;
                    HashSet hashSet13 = hashSet10;
                    HashSet hashSet14 = hashSet11;
                    HashSet hashSet15 = hashSet12;
                    HashMap<String, Integer> hashMap5 = hashMap4;
                    motionController2 = motionController3;
                    arrayList5 = arrayList7;
                    if (key instanceof KeyCycle) {
                        hashSet4 = hashSet15;
                        key.getAttributeNames(hashSet4);
                        hashSet6 = hashSet14;
                        hashMap2 = hashMap5;
                        hashSet5 = hashSet13;
                    } else {
                        hashSet4 = hashSet15;
                        if (key instanceof KeyTimeCycle) {
                            hashSet5 = hashSet13;
                            key.getAttributeNames(hashSet5);
                        } else {
                            hashSet5 = hashSet13;
                            if (key instanceof KeyTrigger) {
                                if (arrayList9 == null) {
                                    arrayList9 = new ArrayList();
                                }
                                ArrayList arrayList11 = arrayList9;
                                arrayList11.add((KeyTrigger) key);
                                arrayList9 = arrayList11;
                            } else {
                                hashMap2 = hashMap5;
                                key.setInterpolation(hashMap2);
                                hashSet6 = hashSet14;
                                key.getAttributeNames(hashSet6);
                            }
                        }
                        hashSet6 = hashSet14;
                        hashMap2 = hashMap5;
                    }
                }
                hashSet12 = hashSet4;
                hashSet10 = hashSet5;
                hashMap4 = hashMap2;
                lp1Var4 = lp1Var3;
                hashSet11 = hashSet6;
                cp1Var5 = cp1Var4;
                arrayList8 = arrayList4;
                f4 = Float.NaN;
                i4 = 0;
                motionController4 = null;
                arrayList7 = arrayList5;
                motionController3 = motionController2;
                cp1Var6 = cp1Var3;
            }
            lp1Var = lp1Var4;
            cp1Var = cp1Var6;
            arrayList = arrayList8;
            cp1Var2 = cp1Var5;
            hashSet = hashSet10;
            hashSet2 = hashSet12;
            hashMap = hashMap4;
            motionController = motionController3;
            arrayList2 = arrayList7;
            hashSet3 = hashSet11;
            arrayList3 = arrayList9;
        } else {
            lp1Var = lp1Var4;
            cp1Var = cp1Var6;
            arrayList = arrayList8;
            cp1Var2 = cp1Var5;
            hashSet = hashSet10;
            hashSet2 = hashSet12;
            hashMap = hashMap4;
            motionController = motionController3;
            arrayList2 = arrayList7;
            hashSet3 = hashSet11;
            arrayList3 = null;
        }
        if (arrayList3 != null) {
            motionController.f2788A = (KeyTrigger[]) arrayList3.toArray(new KeyTrigger[0]);
        }
        if (!hashSet3.isEmpty()) {
            motionController.f2820y = new HashMap();
            Iterator it3 = hashSet3.iterator();
            while (it3.hasNext()) {
                String str2 = (String) it3.next();
                if (str2.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str3 = str2.split(",")[1];
                    Iterator it4 = arrayList.iterator();
                    while (it4.hasNext()) {
                        Key key2 = (Key) it4.next();
                        Iterator it5 = it3;
                        HashMap hashMap6 = key2.f2703d;
                        if (hashMap6 != null && (constraintAttribute3 = (ConstraintAttribute) hashMap6.get(str3)) != null) {
                            sparseArray.append(key2.f2700a, constraintAttribute3);
                        }
                        it3 = it5;
                    }
                    it = it3;
                    makeSpline2 = ViewSpline.makeCustomSpline(str2, (SparseArray<ConstraintAttribute>) sparseArray);
                } else {
                    it = it3;
                    makeSpline2 = ViewSpline.makeSpline(str2);
                }
                if (makeSpline2 != null) {
                    makeSpline2.setType(str2);
                    motionController.f2820y.put(str2, makeSpline2);
                }
                it3 = it;
            }
            if (arrayList != null) {
                Iterator it6 = arrayList.iterator();
                while (it6.hasNext()) {
                    Key key3 = (Key) it6.next();
                    if (key3 instanceof KeyAttributes) {
                        key3.addValues(motionController.f2820y);
                    }
                }
            }
            cp1Var2.m4483a(motionController.f2820y, 0);
            cp1Var.m4483a(motionController.f2820y, 100);
            for (String str4 : motionController.f2820y.keySet()) {
                int intValue = (!hashMap.containsKey(str4) || (num = hashMap.get(str4)) == null) ? 0 : num.intValue();
                SplineSet splineSet = (SplineSet) motionController.f2820y.get(str4);
                if (splineSet != null) {
                    splineSet.setup(intValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (motionController.f2819x == null) {
                motionController.f2819x = new HashMap();
            }
            Iterator it7 = hashSet.iterator();
            while (it7.hasNext()) {
                String str5 = (String) it7.next();
                if (!motionController.f2819x.containsKey(str5)) {
                    if (str5.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str6 = str5.split(",")[1];
                        Iterator it8 = arrayList.iterator();
                        while (it8.hasNext()) {
                            Key key4 = (Key) it8.next();
                            HashMap hashMap7 = key4.f2703d;
                            if (hashMap7 != null && (constraintAttribute2 = (ConstraintAttribute) hashMap7.get(str6)) != null) {
                                sparseArray2.append(key4.f2700a, constraintAttribute2);
                            }
                        }
                        makeSpline = ViewTimeCycle.makeCustomSpline(str5, sparseArray2);
                    } else {
                        makeSpline = ViewTimeCycle.makeSpline(str5, j);
                    }
                    if (makeSpline != null) {
                        makeSpline.setType(str5);
                        motionController.f2819x.put(str5, makeSpline);
                    }
                }
            }
            if (arrayList != null) {
                Iterator it9 = arrayList.iterator();
                while (it9.hasNext()) {
                    Key key5 = (Key) it9.next();
                    if (key5 instanceof KeyTimeCycle) {
                        ((KeyTimeCycle) key5).addTimeValues(motionController.f2819x);
                    }
                }
            }
            for (String str7 : motionController.f2819x.keySet()) {
                ((ViewTimeCycle) motionController.f2819x.get(str7)).setup(hashMap.containsKey(str7) ? hashMap.get(str7).intValue() : 0);
            }
        }
        int size = arrayList2.size();
        int i12 = size + 2;
        lp1[] lp1VarArr = new lp1[i12];
        lp1VarArr[0] = lp1Var;
        lp1VarArr[size + 1] = lp1Var5;
        if (arrayList2.size() > 0 && motionController.f2800e == -1) {
            motionController.f2800e = 0;
        }
        Iterator it10 = arrayList2.iterator();
        int i13 = 1;
        while (it10.hasNext()) {
            lp1VarArr[i13] = (lp1) it10.next();
            i13++;
        }
        HashSet hashSet16 = new HashSet();
        for (String str8 : lp1Var5.f22621n.keySet()) {
            if (lp1Var.f22621n.containsKey(str8)) {
                if (!hashSet3.contains("CUSTOM," + str8)) {
                    hashSet16.add(str8);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet16.toArray(new String[0]);
        motionController.f2813r = strArr2;
        motionController.f2814s = new int[strArr2.length];
        int i14 = 0;
        while (true) {
            strArr = motionController.f2813r;
            if (i14 >= strArr.length) {
                break;
            }
            String str9 = strArr[i14];
            motionController.f2814s[i14] = 0;
            int i15 = 0;
            while (true) {
                if (i15 >= i12) {
                    break;
                }
                if (lp1VarArr[i15].f22621n.containsKey(str9) && (constraintAttribute = (ConstraintAttribute) lp1VarArr[i15].f22621n.get(str9)) != null) {
                    int[] iArr = motionController.f2814s;
                    iArr[i14] = constraintAttribute.numberOfInterpolatedValues() + iArr[i14];
                    break;
                }
                i15++;
            }
            i14++;
        }
        boolean z = lp1VarArr[0].f22617j != Key.UNSET;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        int i16 = 1;
        while (i16 < i12) {
            lp1 lp1Var9 = lp1VarArr[i16];
            lp1 lp1Var10 = lp1VarArr[i16 - 1];
            boolean m5963b = lp1.m5963b(lp1Var9.f22612e, lp1Var10.f22612e);
            boolean m5963b2 = lp1.m5963b(lp1Var9.f22613f, lp1Var10.f22613f);
            zArr[0] = lp1.m5963b(lp1Var9.f22611d, lp1Var10.f22611d) | zArr[0];
            boolean z2 = m5963b | m5963b2 | z;
            zArr[1] = zArr[1] | z2;
            zArr[2] = z2 | zArr[2];
            zArr[3] = zArr[3] | lp1.m5963b(lp1Var9.f22614g, lp1Var10.f22614g);
            zArr[4] = lp1.m5963b(lp1Var9.f22615h, lp1Var10.f22615h) | zArr[4];
            i16++;
            arrayList2 = arrayList2;
        }
        ArrayList arrayList12 = arrayList2;
        int i17 = 0;
        for (int i18 = 1; i18 < length; i18++) {
            if (zArr[i18]) {
                i17++;
            }
        }
        motionController.f2810o = new int[i17];
        int max = Math.max(2, i17);
        motionController.f2811p = new double[max];
        motionController.f2812q = new double[max];
        int i19 = 1;
        int i20 = 0;
        while (i19 < length) {
            if (zArr[i19]) {
                i3 = 1;
                motionController.f2810o[i20] = i19;
                i20++;
            } else {
                i3 = 1;
            }
            i19 += i3;
        }
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i12, motionController.f2810o.length);
        double[] dArr2 = new double[i12];
        int i21 = 0;
        while (i21 < i12) {
            lp1 lp1Var11 = lp1VarArr[i21];
            double[] dArr3 = dArr[i21];
            int[] iArr2 = motionController.f2810o;
            HashSet hashSet17 = hashSet2;
            lp1 lp1Var12 = lp1Var;
            float[] fArr = {lp1Var11.f22611d, lp1Var11.f22612e, lp1Var11.f22613f, lp1Var11.f22614g, lp1Var11.f22615h, lp1Var11.f22616i};
            int i22 = 0;
            for (int i23 : iArr2) {
                if (i23 < 6) {
                    dArr3[i22] = fArr[r14];
                    i22++;
                }
            }
            dArr2[i21] = lp1VarArr[i21].f22610c;
            i21++;
            hashSet2 = hashSet17;
            lp1Var = lp1Var12;
        }
        HashSet hashSet18 = hashSet2;
        lp1 lp1Var13 = lp1Var;
        int i24 = 0;
        while (true) {
            int[] iArr3 = motionController.f2810o;
            if (i24 >= iArr3.length) {
                break;
            }
            if (iArr3[i24] < 6) {
                String m7061q = AbstractC1726qj.m7061q(new StringBuilder(), lp1.f22607r[motionController.f2810o[i24]], " [");
                for (int i25 = 0; i25 < i12; i25++) {
                    StringBuilder m7064t = AbstractC1726qj.m7064t(m7061q);
                    m7064t.append(dArr[i25][i24]);
                    m7061q = m7064t.toString();
                }
            }
            i24++;
        }
        motionController.f2805j = new CurveFit[motionController.f2813r.length + 1];
        int i26 = 0;
        while (true) {
            String[] strArr3 = motionController.f2813r;
            if (i26 >= strArr3.length) {
                break;
            }
            String str10 = strArr3[i26];
            int i27 = 0;
            int i28 = 0;
            double[] dArr4 = null;
            double[][] dArr5 = null;
            while (i27 < i12) {
                if (lp1VarArr[i27].f22621n.containsKey(str10)) {
                    if (dArr5 == null) {
                        dArr4 = new double[i12];
                        ConstraintAttribute constraintAttribute4 = (ConstraintAttribute) lp1VarArr[i27].f22621n.get(str10);
                        dArr5 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i12, constraintAttribute4 == null ? 0 : constraintAttribute4.numberOfInterpolatedValues());
                    }
                    lp1 lp1Var14 = lp1VarArr[i27];
                    dArr4[i28] = lp1Var14.f22610c;
                    double[] dArr6 = dArr5[i28];
                    ConstraintAttribute constraintAttribute5 = (ConstraintAttribute) lp1Var14.f22621n.get(str10);
                    if (constraintAttribute5 != null) {
                        if (constraintAttribute5.numberOfInterpolatedValues() == 1) {
                            dArr6[0] = constraintAttribute5.getValueToInterpolate();
                        } else {
                            int numberOfInterpolatedValues = constraintAttribute5.numberOfInterpolatedValues();
                            float[] fArr2 = new float[numberOfInterpolatedValues];
                            constraintAttribute5.getValuesToInterpolate(fArr2);
                            int i29 = 0;
                            int i30 = 0;
                            while (i29 < numberOfInterpolatedValues) {
                                dArr6[i30] = fArr2[i29];
                                i29++;
                                str10 = str10;
                                numberOfInterpolatedValues = numberOfInterpolatedValues;
                                i30++;
                                fArr2 = fArr2;
                            }
                        }
                    }
                    str = str10;
                    i28++;
                } else {
                    str = str10;
                }
                i27++;
                str10 = str;
            }
            i26++;
            motionController.f2805j[i26] = CurveFit.get(motionController.f2800e, Arrays.copyOf(dArr4, i28), (double[][]) Arrays.copyOf(dArr5, i28));
        }
        motionController.f2805j[0] = CurveFit.get(motionController.f2800e, dArr2, dArr);
        if (lp1VarArr[0].f22617j != Key.UNSET) {
            int[] iArr4 = new int[i12];
            double[] dArr7 = new double[i12];
            double[][] dArr8 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i12, 2);
            for (int i31 = 0; i31 < i12; i31++) {
                iArr4[i31] = lp1VarArr[i31].f22617j;
                dArr7[i31] = r6.f22610c;
                double[] dArr9 = dArr8[i31];
                dArr9[0] = r6.f22612e;
                dArr9[1] = r6.f22613f;
            }
            motionController.f2806k = CurveFit.getArc(iArr4, dArr7, dArr8);
        }
        motionController.f2821z = new HashMap();
        if (arrayList != null) {
            Iterator it11 = hashSet18.iterator();
            float f92 = Float.NaN;
            while (it11.hasNext()) {
                String str11 = (String) it11.next();
                ViewOscillator makeSpline3 = ViewOscillator.makeSpline(str11);
                if (makeSpline3 != null) {
                    if (makeSpline3.variesByPath() && Float.isNaN(f92)) {
                        float[] fArr3 = new float[2];
                        float f93 = 1.0f / 99;
                        double d = 0.0d;
                        double d2 = 0.0d;
                        int i32 = 0;
                        float f94 = RecyclerView.f7068F0;
                        for (int i33 = 100; i32 < i33; i33 = 100) {
                            float f95 = i32 * f93;
                            double d3 = f95;
                            lp1 lp1Var15 = lp1Var13;
                            Easing easing = lp1Var15.f22608a;
                            Iterator it12 = arrayList12.iterator();
                            float f96 = Float.NaN;
                            float f97 = RecyclerView.f7068F0;
                            while (it12.hasNext()) {
                                lp1 lp1Var16 = (lp1) it12.next();
                                Easing easing2 = lp1Var16.f22608a;
                                if (easing2 != null) {
                                    float f98 = lp1Var16.f22610c;
                                    if (f98 < f95) {
                                        easing = easing2;
                                        f97 = f98;
                                    } else if (Float.isNaN(f96)) {
                                        f96 = lp1Var16.f22610c;
                                    }
                                }
                            }
                            if (easing != null) {
                                if (Float.isNaN(f96)) {
                                    f96 = 1.0f;
                                }
                                d3 = (((float) easing.get((f95 - f97) / r22)) * (f96 - f97)) + f97;
                            }
                            motionController.f2805j[0].getPos(d3, motionController.f2811p);
                            int i34 = i32;
                            motionController.f2801f.m5966c(d3, motionController.f2810o, motionController.f2811p, fArr3, 0);
                            if (i34 > 0) {
                                c = 0;
                                f94 += (float) Math.hypot(d2 - fArr3[1], d - fArr3[0]);
                            } else {
                                c = 0;
                            }
                            i32 = i34 + 1;
                            d = fArr3[c];
                            d2 = fArr3[1];
                            lp1Var13 = lp1Var15;
                        }
                        lp1Var2 = lp1Var13;
                        f92 = f94;
                    } else {
                        lp1Var2 = lp1Var13;
                    }
                    makeSpline3.setType(str11);
                    motionController.f2821z.put(str11, makeSpline3);
                    lp1Var13 = lp1Var2;
                }
            }
            Iterator it13 = arrayList.iterator();
            while (it13.hasNext()) {
                Key key6 = (Key) it13.next();
                if (key6 instanceof KeyCycle) {
                    ((KeyCycle) key6).addCycleValues(motionController.f2821z);
                }
            }
            Iterator it14 = motionController.f2821z.values().iterator();
            while (it14.hasNext()) {
                ((ViewOscillator) it14.next()).setup(f92);
            }
        }
    }

    public void setupRelative(MotionController motionController) {
        this.f2801f.m5969g(motionController, motionController.f2801f);
        this.f2802g.m5969g(motionController, motionController.f2802g);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(" start: x: ");
        lp1 lp1Var = this.f2801f;
        sb.append(lp1Var.f22612e);
        sb.append(" y: ");
        sb.append(lp1Var.f22613f);
        sb.append(" end: x: ");
        lp1 lp1Var2 = this.f2802g;
        sb.append(lp1Var2.f22612e);
        sb.append(" y: ");
        sb.append(lp1Var2.f22613f);
        return sb.toString();
    }
}
