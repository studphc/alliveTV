package androidx.constraintlayout.core.motion.utils;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class SpringStopEngine implements StopEngine {

    /* renamed from: b */
    public double f2216b;

    /* renamed from: c */
    public double f2217c;

    /* renamed from: d */
    public float f2218d;

    /* renamed from: e */
    public float f2219e;

    /* renamed from: f */
    public float f2220f;

    /* renamed from: g */
    public float f2221g;

    /* renamed from: h */
    public float f2222h;

    /* renamed from: a */
    public double f2215a = 0.5d;

    /* renamed from: i */
    public int f2223i = 0;

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String str, float f) {
        return null;
    }

    public float getAcceleration() {
        return ((float) (((-this.f2216b) * (this.f2219e - this.f2217c)) - (this.f2215a * this.f2220f))) / this.f2221g;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f) {
        SpringStopEngine springStopEngine;
        float f2;
        SpringStopEngine springStopEngine2 = this;
        double d = f - springStopEngine2.f2218d;
        if (d <= 0.0d) {
            springStopEngine = springStopEngine2;
            f2 = f;
        } else {
            double d2 = springStopEngine2.f2216b;
            double d3 = springStopEngine2.f2215a;
            int sqrt = (int) ((9.0d / ((Math.sqrt(d2 / springStopEngine2.f2221g) * d) * 4.0d)) + 1.0d);
            double d4 = d / sqrt;
            int i = 0;
            while (i < sqrt) {
                float f3 = springStopEngine2.f2219e;
                double d5 = f3;
                double d6 = springStopEngine2.f2217c;
                int i2 = sqrt;
                int i3 = i;
                double d7 = (-d2) * (d5 - d6);
                float f4 = springStopEngine2.f2220f;
                double d8 = d2;
                double d9 = f4;
                double d10 = springStopEngine2.f2221g;
                double d11 = ((((d7 - (d3 * d9)) / d10) * d4) / 2.0d) + d9;
                double d12 = ((((-((((d4 * d11) / 2.0d) + d5) - d6)) * d8) - (d11 * d3)) / d10) * d4;
                float f5 = f4 + ((float) d12);
                this.f2220f = f5;
                float f6 = f3 + ((float) (((d12 / 2.0d) + d9) * d4));
                this.f2219e = f6;
                int i4 = this.f2223i;
                if (i4 > 0) {
                    if (f6 < RecyclerView.f7068F0 && (i4 & 1) == 1) {
                        this.f2219e = -f6;
                        this.f2220f = -f5;
                    }
                    float f7 = this.f2219e;
                    if (f7 > 1.0f && (i4 & 2) == 2) {
                        this.f2219e = 2.0f - f7;
                        this.f2220f = -this.f2220f;
                    }
                }
                i = i3 + 1;
                springStopEngine2 = this;
                sqrt = i2;
                d2 = d8;
            }
            springStopEngine = springStopEngine2;
            f2 = f;
        }
        springStopEngine.f2218d = f2;
        if (isStopped()) {
            springStopEngine.f2219e = (float) springStopEngine.f2217c;
        }
        return springStopEngine.f2219e;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return RecyclerView.f7068F0;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        double d = this.f2219e - this.f2217c;
        double d2 = this.f2216b;
        double d3 = this.f2220f;
        if (Math.sqrt((((d2 * d) * d) + ((d3 * d3) * this.f2221g)) / d2) <= this.f2222h) {
            return true;
        }
        return false;
    }

    public void springConfig(float f, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        this.f2217c = f2;
        this.f2215a = f6;
        this.f2219e = f;
        this.f2216b = f5;
        this.f2221g = f4;
        this.f2222h = f7;
        this.f2223i = i;
        this.f2218d = RecyclerView.f7068F0;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float f) {
        return this.f2220f;
    }
}
