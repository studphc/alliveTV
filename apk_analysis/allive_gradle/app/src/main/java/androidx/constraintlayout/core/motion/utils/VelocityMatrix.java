package androidx.constraintlayout.core.motion.utils;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class VelocityMatrix {

    /* renamed from: a */
    public float f2270a;

    /* renamed from: b */
    public float f2271b;

    /* renamed from: c */
    public float f2272c;

    /* renamed from: d */
    public float f2273d;

    /* renamed from: e */
    public float f2274e;

    /* renamed from: f */
    public float f2275f;

    public void applyTransform(float f, float f2, int i, int i2, float[] fArr) {
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = (f2 - 0.5f) * 2.0f;
        float f6 = f3 + this.f2272c;
        float f7 = f4 + this.f2273d;
        float f8 = (this.f2270a * (f - 0.5f) * 2.0f) + f6;
        float f9 = (this.f2271b * f5) + f7;
        float radians = (float) Math.toRadians(this.f2275f);
        float radians2 = (float) Math.toRadians(this.f2274e);
        double d = radians;
        double d2 = i2 * f5;
        float sin = (((float) ((Math.sin(d) * ((-i) * r7)) - (Math.cos(d) * d2))) * radians2) + f8;
        float cos = (radians2 * ((float) ((Math.cos(d) * (i * r7)) - (Math.sin(d) * d2)))) + f9;
        fArr[0] = sin;
        fArr[1] = cos;
    }

    public void clear() {
        this.f2274e = RecyclerView.f7068F0;
        this.f2273d = RecyclerView.f7068F0;
        this.f2272c = RecyclerView.f7068F0;
        this.f2271b = RecyclerView.f7068F0;
        this.f2270a = RecyclerView.f7068F0;
    }

    public void setRotationVelocity(SplineSet splineSet, float f) {
        if (splineSet != null) {
            this.f2274e = splineSet.getSlope(f);
            this.f2275f = splineSet.get(f);
        }
    }

    public void setScaleVelocity(SplineSet splineSet, SplineSet splineSet2, float f) {
        if (splineSet != null) {
            this.f2270a = splineSet.getSlope(f);
        }
        if (splineSet2 != null) {
            this.f2271b = splineSet2.getSlope(f);
        }
    }

    public void setTranslationVelocity(SplineSet splineSet, SplineSet splineSet2, float f) {
        if (splineSet != null) {
            this.f2272c = splineSet.getSlope(f);
        }
        if (splineSet2 != null) {
            this.f2273d = splineSet2.getSlope(f);
        }
    }

    public void setRotationVelocity(KeyCycleOscillator keyCycleOscillator, float f) {
        if (keyCycleOscillator != null) {
            this.f2274e = keyCycleOscillator.getSlope(f);
        }
    }

    public void setScaleVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f) {
        if (keyCycleOscillator != null) {
            this.f2270a = keyCycleOscillator.getSlope(f);
        }
        if (keyCycleOscillator2 != null) {
            this.f2271b = keyCycleOscillator2.getSlope(f);
        }
    }

    public void setTranslationVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f) {
        if (keyCycleOscillator != null) {
            this.f2272c = keyCycleOscillator.getSlope(f);
        }
        if (keyCycleOscillator2 != null) {
            this.f2273d = keyCycleOscillator2.getSlope(f);
        }
    }
}
