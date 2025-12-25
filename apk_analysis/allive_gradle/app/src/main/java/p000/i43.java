package p000;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class i43 {

    /* renamed from: k */
    public static final i43 f18285k;

    /* renamed from: a */
    public final float f18286a;

    /* renamed from: b */
    public final float f18287b;

    /* renamed from: c */
    public final float f18288c;

    /* renamed from: d */
    public final float f18289d;

    /* renamed from: e */
    public final float f18290e;

    /* renamed from: f */
    public final float f18291f;

    /* renamed from: g */
    public final float[] f18292g;

    /* renamed from: h */
    public final float f18293h;

    /* renamed from: i */
    public final float f18294i;

    /* renamed from: j */
    public final float f18295j;

    static {
        float f;
        float[] fArr = o63.f23621c;
        float m6460W = (float) ((o63.m6460W() * 63.66197723675813d) / 100.0d);
        float[][] fArr2 = o63.f23619a;
        float f2 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f3 = fArr3[0] * f2;
        float f4 = fArr[1];
        float f5 = (fArr3[1] * f4) + f3;
        float f6 = fArr[2];
        float f7 = (fArr3[2] * f6) + f5;
        float[] fArr4 = fArr2[1];
        float f8 = (fArr4[2] * f6) + (fArr4[1] * f4) + (fArr4[0] * f2);
        float[] fArr5 = fArr2[2];
        float f9 = (f6 * fArr5[2]) + (f4 * fArr5[1]) + (f2 * fArr5[0]);
        if (1.0f >= 0.9d) {
            f = 0.69f;
        } else {
            f = 0.655f;
        }
        float f10 = f;
        float exp = (1.0f - (((float) Math.exp(((-m6460W) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d = exp;
        if (d > 1.0d) {
            exp = 1.0f;
        } else if (d < 0.0d) {
            exp = RecyclerView.f7068F0;
        }
        float[] fArr6 = {(((100.0f / f7) * exp) + 1.0f) - exp, (((100.0f / f8) * exp) + 1.0f) - exp, (((100.0f / f9) * exp) + 1.0f) - exp};
        float f11 = 1.0f / ((5.0f * m6460W) + 1.0f);
        float f12 = f11 * f11 * f11 * f11;
        float f13 = 1.0f - f12;
        float cbrt = (0.1f * f13 * f13 * ((float) Math.cbrt(m6460W * 5.0d))) + (f12 * m6460W);
        float m6460W2 = o63.m6460W() / fArr[1];
        double d2 = m6460W2;
        float sqrt = ((float) Math.sqrt(d2)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d2, 0.2d));
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * cbrt) * f7) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * cbrt) * f8) / 100.0d, 0.42d), (float) Math.pow(((fArr6[2] * cbrt) * f9) / 100.0d, 0.42d)};
        float f14 = fArr7[0];
        float f15 = (f14 * 400.0f) / (f14 + 27.13f);
        float f16 = fArr7[1];
        float f17 = (f16 * 400.0f) / (f16 + 27.13f);
        float f18 = fArr7[2];
        float[] fArr8 = {f15, f17, (400.0f * f18) / (f18 + 27.13f)};
        f18285k = new i43(m6460W2, ((fArr8[2] * 0.05f) + (fArr8[0] * 2.0f) + fArr8[1]) * pow, pow, pow, f10, 1.0f, fArr6, cbrt, (float) Math.pow(cbrt, 0.25d), sqrt);
    }

    public i43(float f, float f2, float f3, float f4, float f5, float f6, float[] fArr, float f7, float f8, float f9) {
        this.f18291f = f;
        this.f18286a = f2;
        this.f18287b = f3;
        this.f18288c = f4;
        this.f18289d = f5;
        this.f18290e = f6;
        this.f18292g = fArr;
        this.f18293h = f7;
        this.f18294i = f8;
        this.f18295j = f9;
    }
}
