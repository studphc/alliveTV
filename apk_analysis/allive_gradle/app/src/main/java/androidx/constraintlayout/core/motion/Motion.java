package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.key.MotionKey;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyTrigger;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.constraintlayout.core.motion.utils.ViewState;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import p000.AbstractC1726qj;
import p000.ap1;
import p000.dp1;

/* loaded from: classes.dex */
public class Motion implements TypedValues {
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
    public MotionWidget f2060A;

    /* renamed from: B */
    public int f2061B;

    /* renamed from: C */
    public float f2062C;

    /* renamed from: D */
    public ap1 f2063D;

    /* renamed from: E */
    public Motion f2064E;

    /* renamed from: a */
    public MotionWidget f2065a;

    /* renamed from: b */
    public int f2066b;

    /* renamed from: c */
    public final MotionPaths f2067c;

    /* renamed from: d */
    public final MotionPaths f2068d;

    /* renamed from: e */
    public final dp1 f2069e;

    /* renamed from: f */
    public final dp1 f2070f;

    /* renamed from: g */
    public CurveFit[] f2071g;

    /* renamed from: h */
    public CurveFit f2072h;

    /* renamed from: i */
    public float f2073i;

    /* renamed from: j */
    public float f2074j;

    /* renamed from: k */
    public float f2075k;

    /* renamed from: l */
    public int[] f2076l;

    /* renamed from: m */
    public double[] f2077m;
    public String mId;

    /* renamed from: n */
    public double[] f2078n;

    /* renamed from: o */
    public String[] f2079o;

    /* renamed from: p */
    public int[] f2080p;

    /* renamed from: q */
    public final float[] f2081q;

    /* renamed from: r */
    public final ArrayList f2082r;

    /* renamed from: s */
    public final float[] f2083s;

    /* renamed from: t */
    public final ArrayList f2084t;

    /* renamed from: u */
    public HashMap f2085u;

    /* renamed from: v */
    public HashMap f2086v;

    /* renamed from: w */
    public HashMap f2087w;

    /* renamed from: x */
    public MotionKeyTrigger[] f2088x;

    /* renamed from: y */
    public int f2089y;

    /* renamed from: z */
    public int f2090z;

    public Motion(MotionWidget motionWidget) {
        new Rect();
        this.f2066b = 0;
        this.f2067c = new MotionPaths();
        this.f2068d = new MotionPaths();
        this.f2069e = new dp1();
        this.f2070f = new dp1();
        this.f2073i = Float.NaN;
        this.f2074j = RecyclerView.f7068F0;
        this.f2075k = 1.0f;
        this.f2081q = new float[4];
        this.f2082r = new ArrayList();
        this.f2083s = new float[1];
        this.f2084t = new ArrayList();
        this.f2089y = -1;
        this.f2090z = -1;
        this.f2060A = null;
        this.f2061B = -1;
        this.f2062C = Float.NaN;
        this.f2063D = null;
        setView(motionWidget);
    }

    /* renamed from: a */
    public final float m439a(float f, float[] fArr) {
        float f2 = RecyclerView.f7068F0;
        float f3 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f4 = this.f2075k;
            if (f4 != 1.0d) {
                float f5 = this.f2074j;
                if (f < f5) {
                    f = 0.0f;
                }
                if (f > f5 && f < 1.0d) {
                    f = Math.min((f - f5) * f4, 1.0f);
                }
            }
        }
        Easing easing = this.f2067c.f2092a;
        Iterator it = this.f2082r.iterator();
        float f6 = Float.NaN;
        while (it.hasNext()) {
            MotionPaths motionPaths = (MotionPaths) it.next();
            Easing easing2 = motionPaths.f2092a;
            if (easing2 != null) {
                float f7 = motionPaths.f2094c;
                if (f7 < f) {
                    easing = easing2;
                    f2 = f7;
                } else if (Float.isNaN(f6)) {
                    f6 = motionPaths.f2094c;
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

    public void addKey(MotionKey motionKey) {
        this.f2084t.add(motionKey);
    }

    public int buildKeyFrames(float[] fArr, int[] iArr, int[] iArr2) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.f2071g[0].getTimePoints();
        ArrayList arrayList = this.f2082r;
        if (iArr != null) {
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                iArr[i] = ((MotionPaths) it.next()).f2107p;
                i++;
            }
        }
        if (iArr2 != null) {
            Iterator it2 = arrayList.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                iArr2[i2] = (int) (((MotionPaths) it2.next()).f2095d * 100.0f);
                i2++;
            }
        }
        int i3 = 0;
        for (int i4 = 0; i4 < timePoints.length; i4++) {
            this.f2071g[0].getPos(timePoints[i4], this.f2077m);
            this.f2067c.m442b(timePoints[i4], this.f2076l, this.f2077m, fArr, i3);
            i3 += 2;
        }
        return i3 / 2;
    }

    public void buildPath(float[] fArr, int i) {
        SplineSet splineSet;
        SplineSet splineSet2;
        KeyCycleOscillator keyCycleOscillator;
        double d;
        float f = 1.0f;
        float f2 = 1.0f / (i - 1);
        HashMap hashMap = this.f2086v;
        KeyCycleOscillator keyCycleOscillator2 = null;
        if (hashMap == null) {
            splineSet = null;
        } else {
            splineSet = (SplineSet) hashMap.get("translationX");
        }
        HashMap hashMap2 = this.f2086v;
        if (hashMap2 == null) {
            splineSet2 = null;
        } else {
            splineSet2 = (SplineSet) hashMap2.get("translationY");
        }
        HashMap hashMap3 = this.f2087w;
        if (hashMap3 == null) {
            keyCycleOscillator = null;
        } else {
            keyCycleOscillator = (KeyCycleOscillator) hashMap3.get("translationX");
        }
        HashMap hashMap4 = this.f2087w;
        if (hashMap4 != null) {
            keyCycleOscillator2 = (KeyCycleOscillator) hashMap4.get("translationY");
        }
        KeyCycleOscillator keyCycleOscillator3 = keyCycleOscillator2;
        int i2 = 0;
        while (i2 < i) {
            float f3 = i2 * f2;
            float f4 = this.f2075k;
            float f5 = RecyclerView.f7068F0;
            if (f4 != f) {
                float f6 = this.f2074j;
                if (f3 < f6) {
                    f3 = 0.0f;
                }
                if (f3 > f6 && f3 < 1.0d) {
                    f3 = Math.min((f3 - f6) * f4, f);
                }
            }
            float f7 = f3;
            double d2 = f7;
            Easing easing = this.f2067c.f2092a;
            Iterator it = this.f2082r.iterator();
            float f8 = Float.NaN;
            while (it.hasNext()) {
                MotionPaths motionPaths = (MotionPaths) it.next();
                Easing easing2 = motionPaths.f2092a;
                double d3 = d2;
                if (easing2 != null) {
                    float f9 = motionPaths.f2094c;
                    if (f9 < f7) {
                        f5 = f9;
                        easing = easing2;
                    } else if (Float.isNaN(f8)) {
                        f8 = motionPaths.f2094c;
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
            this.f2071g[0].getPos(d, this.f2077m);
            CurveFit curveFit = this.f2072h;
            if (curveFit != null) {
                double[] dArr = this.f2077m;
                if (dArr.length > 0) {
                    curveFit.getPos(d, dArr);
                }
            }
            int i3 = i2 * 2;
            int i4 = i2;
            this.f2067c.m442b(d, this.f2076l, this.f2077m, fArr, i3);
            if (keyCycleOscillator != null) {
                fArr[i3] = keyCycleOscillator.get(f7) + fArr[i3];
            } else if (splineSet != null) {
                fArr[i3] = splineSet.get(f7) + fArr[i3];
            }
            if (keyCycleOscillator3 != null) {
                int i5 = i3 + 1;
                fArr[i5] = keyCycleOscillator3.get(f7) + fArr[i5];
            } else if (splineSet2 != null) {
                int i6 = i3 + 1;
                fArr[i6] = splineSet2.get(f7) + fArr[i6];
            }
            i2 = i4 + 1;
            f = 1.0f;
        }
    }

    public void buildRect(float f, float[] fArr, int i) {
        this.f2071g[0].getPos(m439a(f, null), this.f2077m);
        int[] iArr = this.f2076l;
        double[] dArr = this.f2077m;
        MotionPaths motionPaths = this.f2067c;
        float f2 = motionPaths.f2096e;
        float f3 = motionPaths.f2097f;
        float f4 = motionPaths.f2098g;
        float f5 = motionPaths.f2099h;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f6 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            f5 = f6;
                        }
                    } else {
                        f4 = f6;
                    }
                } else {
                    f3 = f6;
                }
            } else {
                f2 = f6;
            }
        }
        Motion motion = motionPaths.f2105n;
        if (motion != null) {
            float centerX = motion.getCenterX();
            float centerY = motionPaths.f2105n.getCenterY();
            double d = f2;
            double d2 = f3;
            float sin = (float) (((Math.sin(d2) * d) + centerX) - (f4 / 2.0f));
            f3 = (float) ((centerY - (Math.cos(d2) * d)) - (f5 / 2.0f));
            f2 = sin;
        }
        float f7 = f4 + f2;
        float f8 = f5 + f3;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        float f9 = f2 + RecyclerView.f7068F0;
        float f10 = f3 + RecyclerView.f7068F0;
        float f11 = f7 + RecyclerView.f7068F0;
        float f12 = f8 + RecyclerView.f7068F0;
        fArr[i] = f9;
        fArr[i + 1] = f10;
        fArr[i + 2] = f11;
        fArr[i + 3] = f10;
        fArr[i + 4] = f11;
        fArr[i + 5] = f12;
        fArr[i + 6] = f9;
        fArr[i + 7] = f12;
    }

    public String getAnimateRelativeTo() {
        return this.f2067c.f2103l;
    }

    public void getCenter(double d, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f2071g[0].getPos(d, dArr);
        this.f2071g[0].getSlope(d, dArr2);
        float f = RecyclerView.f7068F0;
        Arrays.fill(fArr2, RecyclerView.f7068F0);
        int[] iArr = this.f2076l;
        MotionPaths motionPaths = this.f2067c;
        float f2 = motionPaths.f2096e;
        float f3 = motionPaths.f2097f;
        float f4 = motionPaths.f2098g;
        float f5 = motionPaths.f2099h;
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
        Motion motion = motionPaths.f2105n;
        if (motion != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motion.getCenter(d, fArr3, fArr4);
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

    public void getDpDt(float f, float f2, float f3, float[] fArr) {
        double[] dArr;
        float[] fArr2 = this.f2083s;
        float m439a = m439a(f, fArr2);
        CurveFit[] curveFitArr = this.f2071g;
        int i = 0;
        if (curveFitArr != null) {
            double d = m439a;
            curveFitArr[0].getSlope(d, this.f2078n);
            this.f2071g[0].getPos(d, this.f2077m);
            float f4 = fArr2[0];
            while (true) {
                dArr = this.f2078n;
                if (i >= dArr.length) {
                    break;
                }
                dArr[i] = dArr[i] * f4;
                i++;
            }
            CurveFit curveFit = this.f2072h;
            if (curveFit != null) {
                double[] dArr2 = this.f2077m;
                if (dArr2.length > 0) {
                    curveFit.getPos(d, dArr2);
                    this.f2072h.getSlope(d, this.f2078n);
                    int[] iArr = this.f2076l;
                    double[] dArr3 = this.f2078n;
                    this.f2067c.getClass();
                    MotionPaths.m441c(f2, f3, fArr, iArr, dArr3);
                    return;
                }
                return;
            }
            int[] iArr2 = this.f2076l;
            this.f2067c.getClass();
            MotionPaths.m441c(f2, f3, fArr, iArr2, dArr);
            return;
        }
        MotionPaths motionPaths = this.f2068d;
        float f5 = motionPaths.f2096e;
        MotionPaths motionPaths2 = this.f2067c;
        float f6 = f5 - motionPaths2.f2096e;
        float f7 = motionPaths.f2097f - motionPaths2.f2097f;
        float f8 = motionPaths.f2098g - motionPaths2.f2098g;
        float f9 = (motionPaths.f2099h - motionPaths2.f2099h) + f7;
        fArr[0] = ((f8 + f6) * f2) + ((1.0f - f2) * f6);
        fArr[1] = (f9 * f3) + ((1.0f - f3) * f7);
    }

    public int getDrawPath() {
        int i = this.f2067c.f2093b;
        Iterator it = this.f2082r.iterator();
        while (it.hasNext()) {
            i = Math.max(i, ((MotionPaths) it.next()).f2093b);
        }
        return Math.max(i, this.f2068d.f2093b);
    }

    public float getFinalHeight() {
        return this.f2068d.f2099h;
    }

    public float getFinalWidth() {
        return this.f2068d.f2098g;
    }

    public float getFinalX() {
        return this.f2068d.f2096e;
    }

    public float getFinalY() {
        return this.f2068d.f2097f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        return 0;
    }

    public MotionPaths getKeyFrame(int i) {
        return (MotionPaths) this.f2082r.get(i);
    }

    public int getKeyFrameInfo(int i, int[] iArr) {
        float[] fArr = new float[2];
        Iterator it = this.f2084t.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            MotionKey motionKey = (MotionKey) it.next();
            int i4 = motionKey.mType;
            if (i4 == i || i != -1) {
                iArr[i3] = 0;
                iArr[i3 + 1] = i4;
                int i5 = motionKey.mFramePosition;
                iArr[i3 + 2] = i5;
                double d = i5 / 100.0f;
                this.f2071g[0].getPos(d, this.f2077m);
                this.f2067c.m442b(d, this.f2076l, this.f2077m, fArr, 0);
                iArr[i3 + 3] = Float.floatToIntBits(fArr[0]);
                int i6 = i3 + 4;
                iArr[i6] = Float.floatToIntBits(fArr[1]);
                if (motionKey instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
                    iArr[i3 + 5] = motionKeyPosition.mPositionType;
                    iArr[i3 + 6] = Float.floatToIntBits(motionKeyPosition.mPercentX);
                    i6 = i3 + 7;
                    iArr[i6] = Float.floatToIntBits(motionKeyPosition.mPercentY);
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
        Iterator it = this.f2084t.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            MotionKey motionKey = (MotionKey) it.next();
            int i3 = motionKey.mFramePosition;
            iArr[i] = (motionKey.mType * 1000) + i3;
            double d = i3 / 100.0f;
            this.f2071g[0].getPos(d, this.f2077m);
            this.f2067c.m442b(d, this.f2076l, this.f2077m, fArr, i2);
            i2 += 2;
            i++;
        }
        return i;
    }

    public float getMotionStagger() {
        return this.f2073i;
    }

    public float getStartHeight() {
        return this.f2067c.f2099h;
    }

    public float getStartWidth() {
        return this.f2067c.f2098g;
    }

    public float getStartX() {
        return this.f2067c.f2096e;
    }

    public float getStartY() {
        return this.f2067c.f2097f;
    }

    public int getTransformPivotTarget() {
        return this.f2090z;
    }

    public MotionWidget getView() {
        return this.f2065a;
    }

    public boolean interpolate(MotionWidget motionWidget, float f, long j, KeyCache keyCache) {
        float f2;
        float f3;
        float f4;
        float f5;
        double d;
        MotionPaths motionPaths;
        float f6;
        float f7;
        Motion motion = this;
        MotionWidget motionWidget2 = motionWidget;
        float m439a = motion.m439a(f, null);
        int i = motion.f2061B;
        if (i != -1) {
            float f8 = 1.0f / i;
            float floor = ((float) Math.floor(m439a / f8)) * f8;
            float f9 = (m439a % f8) / f8;
            if (!Float.isNaN(motion.f2062C)) {
                f9 = (f9 + motion.f2062C) % 1.0f;
            }
            ap1 ap1Var = motion.f2063D;
            if (ap1Var != null) {
                f7 = ap1Var.getInterpolation(f9);
            } else if (f9 > 0.5d) {
                f7 = 1.0f;
            } else {
                f7 = RecyclerView.f7068F0;
            }
            m439a = (f7 * f8) + floor;
        }
        float f10 = m439a;
        HashMap hashMap = motion.f2086v;
        if (hashMap != null) {
            Iterator it = hashMap.values().iterator();
            while (it.hasNext()) {
                ((SplineSet) it.next()).setProperty(motionWidget2, f10);
            }
        }
        CurveFit[] curveFitArr = motion.f2071g;
        MotionPaths motionPaths2 = motion.f2067c;
        if (curveFitArr != null) {
            double d2 = f10;
            curveFitArr[0].getPos(d2, motion.f2077m);
            motion.f2071g[0].getSlope(d2, motion.f2078n);
            CurveFit curveFit = motion.f2072h;
            if (curveFit != null) {
                double[] dArr = motion.f2077m;
                if (dArr.length > 0) {
                    curveFit.getPos(d2, dArr);
                    motion.f2072h.getSlope(d2, motion.f2078n);
                }
            }
            int[] iArr = motion.f2076l;
            double[] dArr2 = motion.f2077m;
            double[] dArr3 = motion.f2078n;
            float f11 = motionPaths2.f2096e;
            float f12 = motionPaths2.f2097f;
            float f13 = motionPaths2.f2098g;
            float f14 = motionPaths2.f2099h;
            if (iArr.length != 0 && motionPaths2.f2108q.length <= iArr[iArr.length - 1]) {
                int i2 = iArr[iArr.length - 1] + 1;
                motionPaths2.f2108q = new double[i2];
                motionPaths2.f2109r = new double[i2];
            }
            Arrays.fill(motionPaths2.f2108q, Double.NaN);
            for (int i3 = 0; i3 < iArr.length; i3++) {
                double[] dArr4 = motionPaths2.f2108q;
                int i4 = iArr[i3];
                dArr4[i4] = dArr2[i3];
                motionPaths2.f2109r[i4] = dArr3[i3];
            }
            float f15 = f12;
            float f16 = f13;
            float f17 = f14;
            float f18 = RecyclerView.f7068F0;
            float f19 = RecyclerView.f7068F0;
            float f20 = RecyclerView.f7068F0;
            int i5 = 0;
            float f21 = Float.NaN;
            float f22 = RecyclerView.f7068F0;
            while (true) {
                double[] dArr5 = motionPaths2.f2108q;
                f2 = f20;
                f3 = f19;
                if (i5 >= dArr5.length) {
                    break;
                }
                if (Double.isNaN(dArr5[i5])) {
                    f6 = f22;
                } else {
                    double d3 = 0.0d;
                    if (!Double.isNaN(motionPaths2.f2108q[i5])) {
                        d3 = motionPaths2.f2108q[i5] + 0.0d;
                    }
                    float f23 = (float) d3;
                    f6 = f22;
                    float f24 = (float) motionPaths2.f2109r[i5];
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 3) {
                                if (i5 != 4) {
                                    if (i5 == 5) {
                                        f21 = f23;
                                    }
                                } else {
                                    f20 = f24;
                                    f17 = f23;
                                    f19 = f3;
                                    f22 = f6;
                                }
                            } else {
                                f16 = f23;
                                f20 = f2;
                                f22 = f6;
                                f19 = f24;
                            }
                        } else {
                            f18 = f24;
                            f15 = f23;
                        }
                    } else {
                        f22 = f24;
                        f11 = f23;
                        f20 = f2;
                        f19 = f3;
                    }
                    i5++;
                }
                f20 = f2;
                f19 = f3;
                f22 = f6;
                i5++;
            }
            float f25 = f22;
            Motion motion2 = motionPaths2.f2105n;
            if (motion2 != null) {
                float[] fArr = new float[2];
                float[] fArr2 = new float[2];
                motion2.getCenter(d2, fArr, fArr2);
                float f26 = fArr[0];
                float f27 = fArr[1];
                float f28 = fArr2[0];
                float f29 = fArr2[1];
                d = d2;
                double d4 = f26;
                double d5 = f11;
                float f30 = f21;
                double d6 = f15;
                float sin = (float) (((Math.sin(d6) * d5) + d4) - (f16 / 2.0f));
                double cos = f27 - (Math.cos(d6) * d5);
                float f31 = f16;
                f5 = f17;
                float f32 = (float) (cos - (f17 / 2.0f));
                double d7 = f28;
                double d8 = f25;
                motionPaths = motionPaths2;
                double d9 = f18;
                float cos2 = (float) ((Math.cos(d6) * d5 * d9) + (Math.sin(d6) * d8) + d7);
                f4 = f31;
                float sin2 = (float) ((Math.sin(d6) * d5 * d9) + (f29 - (Math.cos(d6) * d8)));
                if (dArr3.length >= 2) {
                    dArr3[0] = cos2;
                    dArr3[1] = sin2;
                }
                if (!Float.isNaN(f30)) {
                    motionWidget2 = motionWidget;
                    motionWidget2.setRotationZ((float) (Math.toDegrees(Math.atan2(sin2, cos2)) + f30));
                } else {
                    motionWidget2 = motionWidget;
                }
                f15 = f32;
                f11 = sin;
            } else {
                float f33 = f21;
                f4 = f16;
                f5 = f17;
                d = d2;
                motionPaths = motionPaths2;
                if (!Float.isNaN(f33)) {
                    motionWidget2.setRotationZ(((float) (Math.toDegrees(Math.atan2((f2 / 2.0f) + f18, (f3 / 2.0f) + f25)) + f33)) + RecyclerView.f7068F0);
                }
            }
            float f34 = f11 + 0.5f;
            float f35 = f15 + 0.5f;
            motionWidget2.layout((int) f34, (int) f35, (int) (f34 + f4), (int) (f35 + f5));
            motion = this;
            if (motion.f2090z != -1) {
                if (motion.f2060A == null) {
                    motion.f2060A = motionWidget.getParent().findViewById(motion.f2090z);
                }
                if (motion.f2060A != null) {
                    float bottom = (motion.f2060A.getBottom() + r1.getTop()) / 2.0f;
                    float right = (motion.f2060A.getRight() + motion.f2060A.getLeft()) / 2.0f;
                    if (motionWidget.getRight() - motionWidget.getLeft() > 0 && motionWidget.getBottom() - motionWidget.getTop() > 0) {
                        motionWidget2.setPivotX(right - motionWidget.getLeft());
                        motionWidget2.setPivotY(bottom - motionWidget.getTop());
                    }
                }
            }
            int i6 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = motion.f2071g;
                if (i6 >= curveFitArr2.length) {
                    break;
                }
                CurveFit curveFit2 = curveFitArr2[i6];
                float[] fArr3 = motion.f2081q;
                curveFit2.getPos(d, fArr3);
                ((CustomVariable) motionPaths.f2106o.get(motion.f2079o[i6 - 1])).setInterpolatedValue(motionWidget2, fArr3);
                i6++;
            }
            dp1 dp1Var = motion.f2069e;
            dp1Var.getClass();
            if (f10 <= RecyclerView.f7068F0) {
                motionWidget2.setVisibility(dp1Var.f16469b);
            } else {
                dp1 dp1Var2 = motion.f2070f;
                if (f10 >= 1.0f) {
                    motionWidget2.setVisibility(dp1Var2.f16469b);
                } else if (dp1Var2.f16469b != dp1Var.f16469b) {
                    motionWidget2.setVisibility(4);
                }
            }
            if (motion.f2088x != null) {
                int i7 = 0;
                while (true) {
                    MotionKeyTrigger[] motionKeyTriggerArr = motion.f2088x;
                    if (i7 >= motionKeyTriggerArr.length) {
                        break;
                    }
                    motionKeyTriggerArr[i7].conditionallyFire(f10, motionWidget2);
                    i7++;
                }
            }
            f10 = f10;
        } else {
            float f36 = motionPaths2.f2096e;
            MotionPaths motionPaths3 = motion.f2068d;
            float m7051g = AbstractC1726qj.m7051g(motionPaths3.f2096e, f36, f10, f36);
            float f37 = motionPaths2.f2097f;
            float m7051g2 = AbstractC1726qj.m7051g(motionPaths3.f2097f, f37, f10, f37);
            float f38 = motionPaths2.f2098g;
            float m7051g3 = AbstractC1726qj.m7051g(motionPaths3.f2098g, f38, f10, f38);
            float f39 = motionPaths2.f2099h;
            float f40 = m7051g + 0.5f;
            float f41 = m7051g2 + 0.5f;
            motionWidget2.layout((int) f40, (int) f41, (int) (f40 + m7051g3), (int) (f41 + AbstractC1726qj.m7051g(motionPaths3.f2099h, f39, f10, f39)));
        }
        HashMap hashMap2 = motion.f2087w;
        if (hashMap2 != null) {
            for (KeyCycleOscillator keyCycleOscillator : hashMap2.values()) {
                if (keyCycleOscillator instanceof KeyCycleOscillator.PathRotateSet) {
                    double[] dArr6 = motion.f2078n;
                    ((KeyCycleOscillator.PathRotateSet) keyCycleOscillator).setPathRotate(motionWidget, f10, dArr6[0], dArr6[1]);
                } else {
                    keyCycleOscillator.setProperty(motionWidget2, f10);
                }
            }
            return false;
        }
        return false;
    }

    public void setDrawPath(int i) {
        this.f2067c.f2093b = i;
    }

    public void setEnd(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.f2068d;
        motionPaths.f2094c = 1.0f;
        motionPaths.f2095d = 1.0f;
        float x = this.f2065a.getX();
        float y = this.f2065a.getY();
        float width = this.f2065a.getWidth();
        float height = this.f2065a.getHeight();
        motionPaths.f2096e = x;
        motionPaths.f2097f = y;
        motionPaths.f2098g = width;
        motionPaths.f2099h = height;
        float left = motionWidget.getLeft();
        float top = motionWidget.getTop();
        float width2 = motionWidget.getWidth();
        float height2 = motionWidget.getHeight();
        motionPaths.f2096e = left;
        motionPaths.f2097f = top;
        motionPaths.f2098g = width2;
        motionPaths.f2099h = height2;
        motionPaths.applyParameters(motionWidget);
        dp1 dp1Var = this.f2070f;
        dp1Var.getClass();
        motionWidget.getX();
        motionWidget.getY();
        motionWidget.getWidth();
        motionWidget.getHeight();
        dp1Var.m4600b(motionWidget);
    }

    public void setIdString(String str) {
        this.mId = str;
        this.f2067c.mId = str;
    }

    public void setPathMotionArc(int i) {
        this.f2089y = i;
    }

    public void setStaggerOffset(float f) {
        this.f2074j = f;
    }

    public void setStaggerScale(float f) {
        this.f2075k = f;
    }

    public void setStart(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.f2067c;
        motionPaths.f2094c = RecyclerView.f7068F0;
        motionPaths.f2095d = RecyclerView.f7068F0;
        float x = motionWidget.getX();
        float y = motionWidget.getY();
        float width = motionWidget.getWidth();
        float height = motionWidget.getHeight();
        motionPaths.f2096e = x;
        motionPaths.f2097f = y;
        motionPaths.f2098g = width;
        motionPaths.f2099h = height;
        motionPaths.applyParameters(motionWidget);
        dp1 dp1Var = this.f2069e;
        dp1Var.getClass();
        motionWidget.getX();
        motionWidget.getY();
        motionWidget.getWidth();
        motionWidget.getHeight();
        dp1Var.m4600b(motionWidget);
        TypedBundle motionProperties = motionWidget.getWidgetFrame().getMotionProperties();
        if (motionProperties != null) {
            motionProperties.applyDelta(this);
        }
    }

    public void setStartState(ViewState viewState, MotionWidget motionWidget, int i, int i2, int i3) {
        MotionPaths motionPaths = this.f2067c;
        motionPaths.f2094c = RecyclerView.f7068F0;
        motionPaths.f2095d = RecyclerView.f7068F0;
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
        float f = rect.left;
        float f2 = rect.top;
        float width = rect.width();
        float height = rect.height();
        motionPaths.f2096e = f;
        motionPaths.f2097f = f2;
        motionPaths.f2098g = width;
        motionPaths.f2099h = height;
        float f3 = viewState.rotation;
        dp1 dp1Var = this.f2069e;
        dp1Var.getClass();
        rect.width();
        rect.height();
        dp1Var.m4600b(motionWidget);
        dp1Var.f16475h = Float.NaN;
        dp1Var.f16476i = Float.NaN;
        if (i != 1) {
            if (i == 2) {
                dp1Var.f16470c = f3 + 90.0f;
                return;
            }
            return;
        }
        dp1Var.f16470c = f3 - 90.0f;
    }

    public void setTransformPivotTarget(int i) {
        this.f2090z = i;
        this.f2060A = null;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, boolean z) {
        return false;
    }

    public void setView(MotionWidget motionWidget) {
        this.f2065a = motionWidget;
    }

    public void setup(int i, int i2, float f, long j) {
        dp1 dp1Var;
        MotionPaths motionPaths;
        MotionPaths motionPaths2;
        ArrayList arrayList;
        HashSet<String> hashSet;
        String[] strArr;
        boolean z;
        MotionPaths motionPaths3;
        char c;
        String str;
        int numberOfInterpolatedValues;
        int i3;
        boolean z2;
        boolean z3;
        CustomVariable customVariable;
        int i4;
        SplineSet makeSpline;
        CustomVariable customVariable2;
        int i5;
        Integer num;
        Iterator<String> it;
        HashSet<String> hashSet2;
        SplineSet makeSpline2;
        CustomVariable customVariable3;
        dp1 dp1Var2;
        MotionPaths motionPaths4;
        MotionPaths motionPaths5;
        new HashSet();
        HashSet<String> hashSet3 = new HashSet<>();
        HashSet<String> hashSet4 = new HashSet<>();
        HashSet<String> hashSet5 = new HashSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        Motion motion = this.f2064E;
        MotionPaths motionPaths6 = this.f2068d;
        MotionPaths motionPaths7 = this.f2067c;
        if (motion != null) {
            motionPaths7.setupRelative(motion, motion.f2067c);
            Motion motion2 = this.f2064E;
            motionPaths6.setupRelative(motion2, motion2.f2068d);
        }
        int i6 = this.f2089y;
        if (i6 != -1 && motionPaths7.f2102k == -1) {
            motionPaths7.f2102k = i6;
        }
        dp1 dp1Var3 = this.f2069e;
        float f2 = dp1Var3.f16468a;
        dp1 dp1Var4 = this.f2070f;
        if (dp1.m4598c(f2, dp1Var4.f16468a)) {
            hashSet4.add("alpha");
        }
        if (dp1.m4598c(RecyclerView.f7068F0, RecyclerView.f7068F0)) {
            hashSet4.add("translationZ");
        }
        int i7 = dp1Var3.f16469b;
        int i8 = dp1Var4.f16469b;
        if (i7 != i8 && (i7 == 4 || i8 == 4)) {
            hashSet4.add("alpha");
        }
        if (dp1.m4598c(dp1Var3.f16470c, dp1Var4.f16470c)) {
            hashSet4.add("rotationZ");
        }
        if (!Float.isNaN(Float.NaN) || !Float.isNaN(Float.NaN)) {
            hashSet4.add("pathRotate");
        }
        if (!Float.isNaN(Float.NaN) || !Float.isNaN(Float.NaN)) {
            hashSet4.add("progress");
        }
        if (dp1.m4598c(dp1Var3.f16471d, dp1Var4.f16471d)) {
            hashSet4.add("rotationX");
        }
        if (dp1.m4598c(dp1Var3.f16472e, dp1Var4.f16472e)) {
            hashSet4.add("rotationY");
        }
        if (dp1.m4598c(dp1Var3.f16475h, dp1Var4.f16475h)) {
            hashSet4.add("pivotX");
        }
        if (dp1.m4598c(dp1Var3.f16476i, dp1Var4.f16476i)) {
            hashSet4.add("pivotY");
        }
        if (dp1.m4598c(dp1Var3.f16473f, dp1Var4.f16473f)) {
            hashSet4.add("scaleX");
        }
        if (dp1.m4598c(dp1Var3.f16474g, dp1Var4.f16474g)) {
            hashSet4.add("scaleY");
        }
        if (dp1.m4598c(dp1Var3.f16477j, dp1Var4.f16477j)) {
            hashSet4.add("translationX");
        }
        if (dp1.m4598c(dp1Var3.f16478k, dp1Var4.f16478k)) {
            hashSet4.add("translationY");
        }
        if (dp1.m4598c(dp1Var3.f16479l, dp1Var4.f16479l)) {
            hashSet4.add("translationZ");
        }
        if (dp1.m4598c(RecyclerView.f7068F0, RecyclerView.f7068F0)) {
            hashSet4.add("elevation");
        }
        ArrayList arrayList2 = this.f2084t;
        ArrayList arrayList3 = this.f2082r;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            ArrayList arrayList4 = null;
            while (it2.hasNext()) {
                MotionKey motionKey = (MotionKey) it2.next();
                if (motionKey instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
                    motionPaths4 = motionPaths6;
                    MotionPaths motionPaths8 = new MotionPaths(i, i2, motionKeyPosition, this.f2067c, this.f2068d);
                    Iterator it3 = arrayList3.iterator();
                    MotionPaths motionPaths9 = null;
                    while (it3.hasNext()) {
                        Iterator it4 = it3;
                        MotionPaths motionPaths10 = (MotionPaths) it3.next();
                        MotionPaths motionPaths11 = motionPaths7;
                        dp1 dp1Var5 = dp1Var4;
                        if (motionPaths8.f2095d == motionPaths10.f2095d) {
                            motionPaths9 = motionPaths10;
                        }
                        motionPaths7 = motionPaths11;
                        it3 = it4;
                        dp1Var4 = dp1Var5;
                    }
                    dp1Var2 = dp1Var4;
                    motionPaths5 = motionPaths7;
                    if (motionPaths9 != null) {
                        arrayList3.remove(motionPaths9);
                    }
                    int binarySearch = Collections.binarySearch(arrayList3, motionPaths8);
                    if (binarySearch == 0) {
                        Utils.loge("MotionController", " KeyPath position \"" + motionPaths8.f2095d + "\" outside of range");
                    }
                    arrayList3.add((-binarySearch) - 1, motionPaths8);
                    int i9 = motionKeyPosition.mCurveFit;
                    if (i9 != -1) {
                        this.f2066b = i9;
                    }
                } else {
                    dp1Var2 = dp1Var4;
                    motionPaths4 = motionPaths6;
                    motionPaths5 = motionPaths7;
                    if (motionKey instanceof MotionKeyCycle) {
                        motionKey.getAttributeNames(hashSet5);
                    } else if (motionKey instanceof MotionKeyTimeCycle) {
                        motionKey.getAttributeNames(hashSet3);
                    } else if (motionKey instanceof MotionKeyTrigger) {
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        ArrayList arrayList5 = arrayList4;
                        arrayList5.add((MotionKeyTrigger) motionKey);
                        arrayList4 = arrayList5;
                    } else {
                        motionKey.setInterpolation(hashMap);
                        motionKey.getAttributeNames(hashSet4);
                    }
                }
                motionPaths7 = motionPaths5;
                dp1Var4 = dp1Var2;
                motionPaths6 = motionPaths4;
            }
            dp1Var = dp1Var4;
            motionPaths = motionPaths6;
            motionPaths2 = motionPaths7;
            arrayList = arrayList4;
        } else {
            dp1Var = dp1Var4;
            motionPaths = motionPaths6;
            motionPaths2 = motionPaths7;
            arrayList = null;
        }
        if (arrayList != null) {
            this.f2088x = (MotionKeyTrigger[]) arrayList.toArray(new MotionKeyTrigger[0]);
        }
        if (!hashSet4.isEmpty()) {
            this.f2086v = new HashMap();
            Iterator<String> it5 = hashSet4.iterator();
            while (it5.hasNext()) {
                String next = it5.next();
                if (next.startsWith("CUSTOM,")) {
                    KeyFrameArray.CustomVar customVar = new KeyFrameArray.CustomVar();
                    String str2 = next.split(",")[1];
                    Iterator it6 = arrayList2.iterator();
                    while (it6.hasNext()) {
                        Iterator<String> it7 = it5;
                        MotionKey motionKey2 = (MotionKey) it6.next();
                        HashSet<String> hashSet6 = hashSet5;
                        HashMap<String, CustomVariable> hashMap2 = motionKey2.mCustom;
                        if (hashMap2 != null && (customVariable3 = hashMap2.get(str2)) != null) {
                            customVar.append(motionKey2.mFramePosition, customVariable3);
                        }
                        it5 = it7;
                        hashSet5 = hashSet6;
                    }
                    it = it5;
                    hashSet2 = hashSet5;
                    makeSpline2 = SplineSet.makeCustomSplineSet(next, customVar);
                } else {
                    it = it5;
                    hashSet2 = hashSet5;
                    makeSpline2 = SplineSet.makeSpline(next, j);
                }
                if (makeSpline2 != null) {
                    makeSpline2.setType(next);
                    this.f2086v.put(next, makeSpline2);
                }
                it5 = it;
                hashSet5 = hashSet2;
            }
            hashSet = hashSet5;
            if (arrayList2 != null) {
                Iterator it8 = arrayList2.iterator();
                while (it8.hasNext()) {
                    MotionKey motionKey3 = (MotionKey) it8.next();
                    if (motionKey3 instanceof MotionKeyAttributes) {
                        motionKey3.addValues(this.f2086v);
                    }
                }
            }
            dp1Var3.m4599a(this.f2086v, 0);
            dp1Var.m4599a(this.f2086v, 100);
            for (String str3 : this.f2086v.keySet()) {
                if (hashMap.containsKey(str3) && (num = hashMap.get(str3)) != null) {
                    i5 = num.intValue();
                } else {
                    i5 = 0;
                }
                SplineSet splineSet = (SplineSet) this.f2086v.get(str3);
                if (splineSet != null) {
                    splineSet.setup(i5);
                }
            }
        } else {
            hashSet = hashSet5;
        }
        if (!hashSet3.isEmpty()) {
            if (this.f2085u == null) {
                this.f2085u = new HashMap();
            }
            Iterator<String> it9 = hashSet3.iterator();
            while (it9.hasNext()) {
                String next2 = it9.next();
                if (!this.f2085u.containsKey(next2)) {
                    if (next2.startsWith("CUSTOM,")) {
                        KeyFrameArray.CustomVar customVar2 = new KeyFrameArray.CustomVar();
                        String str4 = next2.split(",")[1];
                        Iterator it10 = arrayList2.iterator();
                        while (it10.hasNext()) {
                            MotionKey motionKey4 = (MotionKey) it10.next();
                            HashMap<String, CustomVariable> hashMap3 = motionKey4.mCustom;
                            if (hashMap3 != null && (customVariable2 = hashMap3.get(str4)) != null) {
                                customVar2.append(motionKey4.mFramePosition, customVariable2);
                            }
                        }
                        makeSpline = SplineSet.makeCustomSplineSet(next2, customVar2);
                    } else {
                        makeSpline = SplineSet.makeSpline(next2, j);
                    }
                    if (makeSpline != null) {
                        makeSpline.setType(next2);
                    }
                }
            }
            if (arrayList2 != null) {
                Iterator it11 = arrayList2.iterator();
                while (it11.hasNext()) {
                    MotionKey motionKey5 = (MotionKey) it11.next();
                    if (motionKey5 instanceof MotionKeyTimeCycle) {
                        ((MotionKeyTimeCycle) motionKey5).addTimeValues(this.f2085u);
                    }
                }
            }
            for (String str5 : this.f2085u.keySet()) {
                if (hashMap.containsKey(str5)) {
                    i4 = hashMap.get(str5).intValue();
                } else {
                    i4 = 0;
                }
                ((TimeCycleSplineSet) this.f2085u.get(str5)).setup(i4);
            }
        }
        int size = arrayList3.size();
        int i10 = size + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[i10];
        motionPathsArr[0] = motionPaths2;
        motionPathsArr[size + 1] = motionPaths;
        if (arrayList3.size() > 0 && this.f2066b == MotionKey.UNSET) {
            this.f2066b = 0;
        }
        Iterator it12 = arrayList3.iterator();
        int i11 = 1;
        while (it12.hasNext()) {
            motionPathsArr[i11] = (MotionPaths) it12.next();
            i11++;
        }
        HashSet hashSet7 = new HashSet();
        for (String str6 : motionPaths.f2106o.keySet()) {
            MotionPaths motionPaths12 = motionPaths2;
            if (motionPaths12.f2106o.containsKey(str6)) {
                if (!hashSet4.contains("CUSTOM," + str6)) {
                    hashSet7.add(str6);
                }
            }
            motionPaths2 = motionPaths12;
        }
        MotionPaths motionPaths13 = motionPaths2;
        String[] strArr2 = (String[]) hashSet7.toArray(new String[0]);
        this.f2079o = strArr2;
        this.f2080p = new int[strArr2.length];
        int i12 = 0;
        while (true) {
            strArr = this.f2079o;
            if (i12 >= strArr.length) {
                break;
            }
            String str7 = strArr[i12];
            this.f2080p[i12] = 0;
            int i13 = 0;
            while (true) {
                if (i13 >= i10) {
                    break;
                }
                if (motionPathsArr[i13].f2106o.containsKey(str7) && (customVariable = (CustomVariable) motionPathsArr[i13].f2106o.get(str7)) != null) {
                    int[] iArr = this.f2080p;
                    iArr[i12] = customVariable.numberOfInterpolatedValues() + iArr[i12];
                    break;
                }
                i13++;
            }
            i12++;
        }
        if (motionPathsArr[0].f2102k != -1) {
            z = true;
        } else {
            z = false;
        }
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        int i14 = 1;
        while (i14 < i10) {
            MotionPaths motionPaths14 = motionPathsArr[i14];
            MotionPaths motionPaths15 = motionPathsArr[i14 - 1];
            boolean m440a = MotionPaths.m440a(motionPaths14.f2096e, motionPaths15.f2096e);
            boolean m440a2 = MotionPaths.m440a(motionPaths14.f2097f, motionPaths15.f2097f);
            ArrayList arrayList6 = arrayList3;
            zArr[0] = MotionPaths.m440a(motionPaths14.f2095d, motionPaths15.f2095d) | zArr[0];
            boolean z4 = zArr[1];
            if (!m440a && !m440a2 && !z) {
                z2 = false;
            } else {
                z2 = true;
            }
            zArr[1] = z4 | z2;
            boolean z5 = zArr[2];
            if (!m440a && !m440a2 && !z) {
                z3 = false;
            } else {
                z3 = true;
            }
            zArr[2] = z3 | z5;
            zArr[3] = zArr[3] | MotionPaths.m440a(motionPaths14.f2098g, motionPaths15.f2098g);
            zArr[4] = MotionPaths.m440a(motionPaths14.f2099h, motionPaths15.f2099h) | zArr[4];
            i14++;
            arrayList3 = arrayList6;
        }
        ArrayList arrayList7 = arrayList3;
        int i15 = 0;
        for (int i16 = 1; i16 < length; i16++) {
            if (zArr[i16]) {
                i15++;
            }
        }
        this.f2076l = new int[i15];
        int max = Math.max(2, i15);
        this.f2077m = new double[max];
        this.f2078n = new double[max];
        int i17 = 0;
        int i18 = 1;
        while (i18 < length) {
            if (zArr[i18]) {
                i3 = 1;
                this.f2076l[i17] = i18;
                i17++;
            } else {
                i3 = 1;
            }
            i18 += i3;
        }
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i10, this.f2076l.length);
        double[] dArr2 = new double[i10];
        int i19 = 0;
        while (i19 < i10) {
            MotionPaths motionPaths16 = motionPathsArr[i19];
            double[] dArr3 = dArr[i19];
            int[] iArr2 = this.f2076l;
            MotionPaths motionPaths17 = motionPaths13;
            ArrayList arrayList8 = arrayList2;
            float[] fArr = {motionPaths16.f2095d, motionPaths16.f2096e, motionPaths16.f2097f, motionPaths16.f2098g, motionPaths16.f2099h, motionPaths16.f2100i};
            int i20 = 0;
            for (int i21 : iArr2) {
                if (i21 < 6) {
                    dArr3[i20] = fArr[r14];
                    i20++;
                }
            }
            dArr2[i19] = motionPathsArr[i19].f2094c;
            i19++;
            motionPaths13 = motionPaths17;
            arrayList2 = arrayList8;
        }
        MotionPaths motionPaths18 = motionPaths13;
        ArrayList arrayList9 = arrayList2;
        int i22 = 0;
        while (true) {
            int[] iArr3 = this.f2076l;
            if (i22 >= iArr3.length) {
                break;
            }
            if (iArr3[i22] < 6) {
                String m7061q = AbstractC1726qj.m7061q(new StringBuilder(), MotionPaths.f2091s[this.f2076l[i22]], " [");
                for (int i23 = 0; i23 < i10; i23++) {
                    StringBuilder m7064t = AbstractC1726qj.m7064t(m7061q);
                    m7064t.append(dArr[i23][i22]);
                    m7061q = m7064t.toString();
                }
            }
            i22++;
        }
        this.f2071g = new CurveFit[this.f2079o.length + 1];
        int i24 = 0;
        while (true) {
            String[] strArr3 = this.f2079o;
            if (i24 >= strArr3.length) {
                break;
            }
            String str8 = strArr3[i24];
            double[] dArr4 = null;
            double[][] dArr5 = null;
            int i25 = 0;
            int i26 = 0;
            while (i25 < i10) {
                if (motionPathsArr[i25].f2106o.containsKey(str8)) {
                    if (dArr5 == null) {
                        dArr4 = new double[i10];
                        CustomVariable customVariable4 = (CustomVariable) motionPathsArr[i25].f2106o.get(str8);
                        if (customVariable4 == null) {
                            numberOfInterpolatedValues = 0;
                        } else {
                            numberOfInterpolatedValues = customVariable4.numberOfInterpolatedValues();
                        }
                        dArr5 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i10, numberOfInterpolatedValues);
                    }
                    MotionPaths motionPaths19 = motionPathsArr[i25];
                    dArr4[i26] = motionPaths19.f2094c;
                    double[] dArr6 = dArr5[i26];
                    CustomVariable customVariable5 = (CustomVariable) motionPaths19.f2106o.get(str8);
                    if (customVariable5 != null) {
                        if (customVariable5.numberOfInterpolatedValues() == 1) {
                            dArr6[0] = customVariable5.getValueToInterpolate();
                        } else {
                            int numberOfInterpolatedValues2 = customVariable5.numberOfInterpolatedValues();
                            customVariable5.getValuesToInterpolate(new float[numberOfInterpolatedValues2]);
                            int i27 = 0;
                            int i28 = 0;
                            while (i27 < numberOfInterpolatedValues2) {
                                dArr6[i28] = r14[i27];
                                i27++;
                                str8 = str8;
                                dArr4 = dArr4;
                                dArr5 = dArr5;
                                i28++;
                            }
                        }
                    }
                    str = str8;
                    i26++;
                    dArr4 = dArr4;
                    dArr5 = dArr5;
                } else {
                    str = str8;
                }
                i25++;
                str8 = str;
            }
            i24++;
            this.f2071g[i24] = CurveFit.get(this.f2066b, Arrays.copyOf(dArr4, i26), (double[][]) Arrays.copyOf(dArr5, i26));
        }
        this.f2071g[0] = CurveFit.get(this.f2066b, dArr2, dArr);
        if (motionPathsArr[0].f2102k != -1) {
            int[] iArr4 = new int[i10];
            double[] dArr7 = new double[i10];
            double[][] dArr8 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i10, 2);
            for (int i29 = 0; i29 < i10; i29++) {
                iArr4[i29] = motionPathsArr[i29].f2102k;
                dArr7[i29] = r7.f2094c;
                double[] dArr9 = dArr8[i29];
                dArr9[0] = r7.f2096e;
                dArr9[1] = r7.f2097f;
            }
            this.f2072h = CurveFit.getArc(iArr4, dArr7, dArr8);
        }
        this.f2087w = new HashMap();
        if (arrayList9 != null) {
            Iterator<String> it13 = hashSet.iterator();
            float f3 = Float.NaN;
            while (it13.hasNext()) {
                String next3 = it13.next();
                KeyCycleOscillator makeWidgetCycle = KeyCycleOscillator.makeWidgetCycle(next3);
                if (makeWidgetCycle != null) {
                    if (makeWidgetCycle.variesByPath() && Float.isNaN(f3)) {
                        float[] fArr2 = new float[2];
                        float f4 = 1.0f / 99;
                        double d = 0.0d;
                        double d2 = 0.0d;
                        int i30 = 0;
                        float f5 = RecyclerView.f7068F0;
                        for (int i31 = 100; i30 < i31; i31 = 100) {
                            float f6 = i30 * f4;
                            double d3 = f6;
                            MotionPaths motionPaths20 = motionPaths18;
                            Easing easing = motionPaths20.f2092a;
                            Iterator it14 = arrayList7.iterator();
                            float f7 = Float.NaN;
                            float f8 = RecyclerView.f7068F0;
                            while (it14.hasNext()) {
                                MotionPaths motionPaths21 = (MotionPaths) it14.next();
                                Easing easing2 = motionPaths21.f2092a;
                                if (easing2 != null) {
                                    float f9 = motionPaths21.f2094c;
                                    if (f9 < f6) {
                                        easing = easing2;
                                        f8 = f9;
                                    } else if (Float.isNaN(f7)) {
                                        f7 = motionPaths21.f2094c;
                                    }
                                }
                            }
                            if (easing != null) {
                                if (Float.isNaN(f7)) {
                                    f7 = 1.0f;
                                }
                                d3 = (((float) easing.get((f6 - f8) / r24)) * (f7 - f8)) + f8;
                            }
                            this.f2071g[0].getPos(d3, this.f2077m);
                            this.f2067c.m442b(d3, this.f2076l, this.f2077m, fArr2, 0);
                            if (i30 > 0) {
                                c = 0;
                                f5 += (float) Math.hypot(d2 - fArr2[1], d - fArr2[0]);
                            } else {
                                c = 0;
                            }
                            i30++;
                            motionPaths18 = motionPaths20;
                            d = fArr2[c];
                            d2 = fArr2[1];
                        }
                        motionPaths3 = motionPaths18;
                        f3 = f5;
                    } else {
                        motionPaths3 = motionPaths18;
                    }
                    makeWidgetCycle.setType(next3);
                    this.f2087w.put(next3, makeWidgetCycle);
                    motionPaths18 = motionPaths3;
                }
            }
            Iterator it15 = arrayList9.iterator();
            while (it15.hasNext()) {
                MotionKey motionKey6 = (MotionKey) it15.next();
                if (motionKey6 instanceof MotionKeyCycle) {
                    ((MotionKeyCycle) motionKey6).addCycleValues(this.f2087w);
                }
            }
            Iterator it16 = this.f2087w.values().iterator();
            while (it16.hasNext()) {
                ((KeyCycleOscillator) it16.next()).setup(f3);
            }
        }
    }

    public void setupRelative(Motion motion) {
        this.f2064E = motion;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(" start: x: ");
        MotionPaths motionPaths = this.f2067c;
        sb.append(motionPaths.f2096e);
        sb.append(" y: ");
        sb.append(motionPaths.f2097f);
        sb.append(" end: x: ");
        MotionPaths motionPaths2 = this.f2068d;
        sb.append(motionPaths2.f2096e);
        sb.append(" y: ");
        sb.append(motionPaths2.f2097f);
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i2) {
        if (i == 509) {
            setPathMotionArc(i2);
            return true;
        }
        if (i != 610) {
            return i == 704;
        }
        this.f2061B = i2;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        if (602 == i) {
            this.f2062C = f;
            return true;
        }
        if (600 != i) {
            return false;
        }
        this.f2073i = f;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        if (705 == i || 611 == i) {
            this.f2063D = new ap1(Easing.getInterpolator(str));
            return true;
        }
        if (605 != i) {
            return false;
        }
        this.f2067c.f2103l = str;
        return true;
    }
}
