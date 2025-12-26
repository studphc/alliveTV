package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.MotionWidget;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import p000.f71;
import p000.g71;
import p000.ny2;
import p000.x30;
import p000.ye0;

/* loaded from: classes.dex */
public abstract class KeyCycleOscillator {

    /* renamed from: a */
    public CurveFit f2180a;

    /* renamed from: b */
    public f71 f2181b;

    /* renamed from: c */
    public String f2182c;

    /* renamed from: d */
    public int f2183d = 0;

    /* renamed from: e */
    public String f2184e = null;
    public int mVariesBy = 0;

    /* renamed from: f */
    public final ArrayList f2185f = new ArrayList();

    /* loaded from: classes.dex */
    public static class PathRotateSet extends KeyCycleOscillator {

        /* renamed from: g */
        public final int f2186g;

        public PathRotateSet(String str) {
            this.f2186g = ny2.m6400a(str);
        }

        public void setPathRotate(MotionWidget motionWidget, float f, double d, double d2) {
            motionWidget.setRotationZ(get(f) + ((float) Math.toDegrees(Math.atan2(d2, d))));
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f) {
            motionWidget.setValue(this.f2186g, get(f));
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.constraintlayout.core.motion.utils.KeyCycleOscillator, androidx.constraintlayout.core.motion.utils.a] */
    public static KeyCycleOscillator makeWidgetCycle(String str) {
        if (str.equals("pathRotate")) {
            return new PathRotateSet(str);
        }
        ?? keyCycleOscillator = new KeyCycleOscillator();
        keyCycleOscillator.f2276g = ny2.m6400a(str);
        return keyCycleOscillator;
    }

    public float get(float f) {
        f71 f71Var = this.f2181b;
        CurveFit curveFit = f71Var.f17158g;
        if (curveFit != null) {
            curveFit.getPos(f, f71Var.f17159h);
        } else {
            double[] dArr = f71Var.f17159h;
            dArr[0] = f71Var.f17156e[0];
            dArr[1] = f71Var.f17157f[0];
            dArr[2] = f71Var.f17153b[0];
        }
        double[] dArr2 = f71Var.f17159h;
        return (float) ((f71Var.f17152a.getValue(f, dArr2[1]) * f71Var.f17159h[2]) + dArr2[0]);
    }

    public CurveFit getCurveFit() {
        return this.f2180a;
    }

    public float getSlope(float f) {
        f71 f71Var = this.f2181b;
        CurveFit curveFit = f71Var.f17158g;
        if (curveFit != null) {
            double d = f;
            curveFit.getSlope(d, f71Var.f17160i);
            f71Var.f17158g.getPos(d, f71Var.f17159h);
        } else {
            double[] dArr = f71Var.f17160i;
            dArr[0] = 0.0d;
            dArr[1] = 0.0d;
            dArr[2] = 0.0d;
        }
        double d2 = f;
        double value = f71Var.f17152a.getValue(d2, f71Var.f17159h[1]);
        double slope = f71Var.f17152a.getSlope(d2, f71Var.f17159h[1], f71Var.f17160i[1]);
        double[] dArr2 = f71Var.f17160i;
        return (float) ((slope * f71Var.f17159h[2]) + (value * dArr2[2]) + dArr2[0]);
    }

    public void setCustom(Object obj) {
    }

    public void setPoint(int i, int i2, String str, int i3, float f, float f2, float f3, float f4, Object obj) {
        this.f2185f.add(new g71(i, f, f2, f3, f4));
        if (i3 != -1) {
            this.mVariesBy = i3;
        }
        this.f2183d = i2;
        setCustom(obj);
        this.f2184e = str;
    }

    public void setProperty(MotionWidget motionWidget, float f) {
    }

    public void setType(String str) {
        this.f2182c = str;
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [f71, java.lang.Object] */
    public void setup(float f) {
        int i;
        ArrayList arrayList = this.f2185f;
        int size = arrayList.size();
        if (size == 0) {
            return;
        }
        Collections.sort(arrayList, new x30(2));
        double[] dArr = new double[size];
        char c = 1;
        char c2 = 0;
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 3);
        int i2 = this.f2183d;
        String str = this.f2184e;
        ?? obj = new Object();
        Oscillator oscillator = new Oscillator();
        obj.f17152a = oscillator;
        oscillator.setType(i2, str);
        obj.f17153b = new float[size];
        obj.f17154c = new double[size];
        obj.f17155d = new float[size];
        obj.f17156e = new float[size];
        obj.f17157f = new float[size];
        float[] fArr = new float[size];
        this.f2181b = obj;
        Iterator it = arrayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            g71 g71Var = (g71) it.next();
            float f2 = g71Var.f17570d;
            dArr[i3] = f2 * 0.01d;
            double[] dArr3 = dArr2[i3];
            float f3 = g71Var.f17568b;
            dArr3[c2] = f3;
            float f4 = g71Var.f17569c;
            dArr3[c] = f4;
            float f5 = g71Var.f17571e;
            dArr3[2] = f5;
            f71 f71Var = this.f2181b;
            f71Var.f17154c[i3] = g71Var.f17567a / 100.0d;
            f71Var.f17155d[i3] = f2;
            f71Var.f17156e[i3] = f4;
            f71Var.f17157f[i3] = f5;
            f71Var.f17153b[i3] = f3;
            i3++;
            c = 1;
            c2 = 0;
        }
        f71 f71Var2 = this.f2181b;
        double[] dArr4 = f71Var2.f17154c;
        double[][] dArr5 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, dArr4.length, 3);
        float[] fArr2 = f71Var2.f17153b;
        f71Var2.f17159h = new double[fArr2.length + 2];
        f71Var2.f17160i = new double[fArr2.length + 2];
        double d = dArr4[0];
        float[] fArr3 = f71Var2.f17155d;
        Oscillator oscillator2 = f71Var2.f17152a;
        if (d > 0.0d) {
            oscillator2.addPoint(0.0d, fArr3[0]);
        }
        int length = dArr4.length - 1;
        if (dArr4[length] < 1.0d) {
            oscillator2.addPoint(1.0d, fArr3[length]);
        }
        for (int i4 = 0; i4 < dArr5.length; i4++) {
            double[] dArr6 = dArr5[i4];
            dArr6[0] = f71Var2.f17156e[i4];
            dArr6[1] = f71Var2.f17157f[i4];
            dArr6[2] = fArr2[i4];
            oscillator2.addPoint(dArr4[i4], fArr3[i4]);
        }
        oscillator2.normalize();
        if (dArr4.length > 1) {
            i = 0;
            f71Var2.f17158g = CurveFit.get(0, dArr4, dArr5);
        } else {
            i = 0;
            f71Var2.f17158g = null;
        }
        this.f2180a = CurveFit.get(i, dArr, dArr2);
    }

    public String toString() {
        String str = this.f2182c;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator it = this.f2185f.iterator();
        while (it.hasNext()) {
            g71 g71Var = (g71) it.next();
            StringBuilder m8303w = ye0.m8303w(str, "[");
            m8303w.append(g71Var.f17567a);
            m8303w.append(" , ");
            m8303w.append(decimalFormat.format(g71Var.f17568b));
            m8303w.append("] ");
            str = m8303w.toString();
        }
        return str;
    }

    public boolean variesByPath() {
        if (this.mVariesBy == 1) {
            return true;
        }
        return false;
    }

    public void setPoint(int i, int i2, String str, int i3, float f, float f2, float f3, float f4) {
        this.f2185f.add(new g71(i, f, f2, f3, f4));
        if (i3 != -1) {
            this.mVariesBy = i3;
        }
        this.f2183d = i2;
        this.f2184e = str;
    }
}
