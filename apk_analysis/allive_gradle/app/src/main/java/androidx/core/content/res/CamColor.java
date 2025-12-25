package androidx.core.content.res;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.RecyclerView;
import p000.i43;
import p000.o63;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class CamColor {

    /* renamed from: a */
    public final float f3606a;

    /* renamed from: b */
    public final float f3607b;

    /* renamed from: c */
    public final float f3608c;

    /* renamed from: d */
    public final float f3609d;

    /* renamed from: e */
    public final float f3610e;

    /* renamed from: f */
    public final float f3611f;

    public CamColor(float f, float f2, float f3, float f4, float f5, float f6) {
        this.f3606a = f;
        this.f3607b = f2;
        this.f3608c = f3;
        this.f3609d = f4;
        this.f3610e = f5;
        this.f3611f = f6;
    }

    /* renamed from: a */
    public static CamColor m814a(int i) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        m815b(i, i43.f18285k, fArr, fArr2);
        return new CamColor(fArr2[0], fArr2[1], fArr[0], fArr[4], fArr[5], fArr[6]);
    }

    /* renamed from: b */
    public static void m815b(int i, i43 i43Var, float[] fArr, float[] fArr2) {
        float f;
        float m6477v = o63.m6477v(Color.red(i));
        float m6477v2 = o63.m6477v(Color.green(i));
        float m6477v3 = o63.m6477v(Color.blue(i));
        float[][] fArr3 = o63.f23622d;
        float[] fArr4 = fArr3[0];
        float f2 = (fArr4[2] * m6477v3) + (fArr4[1] * m6477v2) + (fArr4[0] * m6477v);
        fArr2[0] = f2;
        float[] fArr5 = fArr3[1];
        float f3 = (fArr5[2] * m6477v3) + (fArr5[1] * m6477v2) + (fArr5[0] * m6477v);
        fArr2[1] = f3;
        float[] fArr6 = fArr3[2];
        float f4 = (m6477v3 * fArr6[2]) + (m6477v2 * fArr6[1]) + (m6477v * fArr6[0]);
        fArr2[2] = f4;
        float[][] fArr7 = o63.f23619a;
        float[] fArr8 = fArr7[0];
        float f5 = (fArr8[2] * f4) + (fArr8[1] * f3) + (fArr8[0] * f2);
        float[] fArr9 = fArr7[1];
        float f6 = (fArr9[2] * f4) + (fArr9[1] * f3) + (fArr9[0] * f2);
        float[] fArr10 = fArr7[2];
        float f7 = (f4 * fArr10[2]) + (f3 * fArr10[1]) + (f2 * fArr10[0]);
        float[] fArr11 = i43Var.f18292g;
        float f8 = fArr11[0] * f5;
        float f9 = fArr11[1] * f6;
        float f10 = fArr11[2] * f7;
        float abs = Math.abs(f8);
        float f11 = i43Var.f18293h;
        float pow = (float) Math.pow((abs * f11) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow((Math.abs(f9) * f11) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((Math.abs(f10) * f11) / 100.0d, 0.42d);
        float signum = ((Math.signum(f8) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f9) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f10) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d = signum3;
        float f12 = ((float) (((signum2 * (-12.0d)) + (signum * 11.0d)) + d)) / 11.0f;
        float f13 = ((float) ((signum + signum2) - (d * 2.0d))) / 9.0f;
        float f14 = signum2 * 20.0f;
        float f15 = ((21.0f * signum3) + ((signum * 20.0f) + f14)) / 20.0f;
        float f16 = (((signum * 40.0f) + f14) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(f13, f12)) * 180.0f) / 3.1415927f;
        if (atan2 < RecyclerView.f7068F0) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f17 = (3.1415927f * atan2) / 180.0f;
        float f18 = f16 * i43Var.f18287b;
        float f19 = i43Var.f18286a;
        double d2 = f18 / f19;
        float f20 = i43Var.f18295j;
        float f21 = i43Var.f18289d;
        float pow4 = ((float) Math.pow(d2, f20 * f21)) * 100.0f;
        float sqrt = (4.0f / f21) * ((float) Math.sqrt(pow4 / 100.0f)) * (f19 + 4.0f);
        float f22 = i43Var.f18294i;
        float f23 = sqrt * f22;
        if (atan2 < 20.14d) {
            f = 360.0f + atan2;
        } else {
            f = atan2;
        }
        float sqrt2 = ((float) Math.sqrt(pow4 / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, i43Var.f18291f), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((f * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * i43Var.f18290e) * i43Var.f18288c) * ((float) Math.sqrt((f13 * f13) + (f12 * f12)))) / (f15 + 0.305f), 0.9d));
        float f24 = f22 * sqrt2;
        float sqrt3 = ((float) Math.sqrt((r0 * f21) / r2)) * 50.0f;
        float f25 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log = ((float) Math.log((0.0228f * f24) + 1.0f)) * 43.85965f;
        double d3 = f17;
        float cos = ((float) Math.cos(d3)) * log;
        float sin = log * ((float) Math.sin(d3));
        fArr2[0] = atan2;
        fArr2[1] = sqrt2;
        if (fArr != null) {
            fArr[0] = pow4;
            fArr[1] = f23;
            fArr[2] = f24;
            fArr[3] = sqrt3;
            fArr[4] = f25;
            fArr[5] = cos;
            fArr[6] = sin;
        }
    }

    /* renamed from: c */
    public static CamColor m816c(float f, float f2, float f3) {
        i43 i43Var = i43.f18285k;
        float f4 = i43Var.f18289d;
        Math.sqrt(f / 100.0d);
        float f5 = i43Var.f18286a + 4.0f;
        float f6 = i43Var.f18294i * f2;
        Math.sqrt(((f2 / ((float) Math.sqrt(r1))) * i43Var.f18289d) / f5);
        float f7 = (1.7f * f) / ((0.007f * f) + 1.0f);
        float log = ((float) Math.log((f6 * 0.0228d) + 1.0d)) * 43.85965f;
        double d = (3.1415927f * f3) / 180.0f;
        return new CamColor(f3, f2, f, f7, log * ((float) Math.cos(d)), log * ((float) Math.sin(d)));
    }

    public static void getM3HCTfromColor(@ColorInt int i, @NonNull @Size(3) float[] fArr) {
        m815b(i, i43.f18285k, null, fArr);
        fArr[2] = o63.m6476u(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int toColor(@FloatRange(from = 0.0d, m152to = 360.0d) float f, @FloatRange(from = 0.0d, m152to = Double.POSITIVE_INFINITY, toInclusive = false) float f2, @FloatRange(from = 0.0d, m152to = 100.0d) float f3) {
        float min;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        i43 i43Var = i43.f18285k;
        float f9 = f2;
        if (f9 >= 1.0d && Math.round(f3) > 0.0d && Math.round(f3) < 100.0d) {
            float f10 = RecyclerView.f7068F0;
            if (f < RecyclerView.f7068F0) {
                min = 0.0f;
            } else {
                min = Math.min(360.0f, f);
            }
            float f11 = 0.0f;
            boolean z = true;
            CamColor camColor = null;
            float f12 = f9;
            while (Math.abs(f11 - f9) >= 0.4f) {
                float f13 = 100.0f;
                float f14 = 1000.0f;
                float f15 = f10;
                float f16 = 1000.0f;
                CamColor camColor2 = null;
                while (true) {
                    if (Math.abs(f15 - f13) > 0.01f) {
                        float f17 = ((f13 - f15) / 2.0f) + f15;
                        int m817d = m816c(f17, f12, min).m817d(i43.f18285k);
                        float m6476u = o63.m6476u(m817d);
                        float abs = Math.abs(f3 - m6476u);
                        if (abs < 0.2f) {
                            CamColor m814a = m814a(m817d);
                            f6 = f12;
                            CamColor m816c = m816c(m814a.f3608c, m814a.f3607b, min);
                            f4 = min;
                            float f18 = m814a.f3609d - m816c.f3609d;
                            f7 = f13;
                            float f19 = m814a.f3610e - m816c.f3610e;
                            float f20 = m814a.f3611f - m816c.f3611f;
                            float f21 = f20 * f20;
                            double sqrt = Math.sqrt(f21 + (f19 * f19) + (f18 * f18));
                            f8 = f14;
                            float pow = (float) (Math.pow(sqrt, 0.63d) * 1.41d);
                            if (pow <= 1.0f) {
                                camColor2 = m814a;
                                f16 = pow;
                                f14 = abs;
                                f5 = RecyclerView.f7068F0;
                                if (f14 != RecyclerView.f7068F0 && f16 == RecyclerView.f7068F0) {
                                    break;
                                }
                                if (m6476u >= f3) {
                                    f15 = f17;
                                    f13 = f7;
                                } else {
                                    f13 = f17;
                                }
                                f10 = 0.0f;
                                f12 = f6;
                                min = f4;
                            }
                        } else {
                            f4 = min;
                            f6 = f12;
                            f7 = f13;
                            f8 = f14;
                        }
                        f14 = f8;
                        f5 = RecyclerView.f7068F0;
                        if (f14 != RecyclerView.f7068F0) {
                        }
                        if (m6476u >= f3) {
                        }
                        f10 = 0.0f;
                        f12 = f6;
                        min = f4;
                    } else {
                        f4 = min;
                        f5 = f10;
                        f6 = f12;
                        break;
                    }
                }
                if (z) {
                    if (camColor2 != null) {
                        return camColor2.m817d(i43Var);
                    }
                    f12 = ((f9 - f11) / 2.0f) + f11;
                    z = false;
                } else {
                    if (camColor2 == null) {
                        f9 = f6;
                    } else {
                        camColor = camColor2;
                        f11 = f6;
                    }
                    f12 = ((f9 - f11) / 2.0f) + f11;
                }
                f10 = f5;
                min = f4;
            }
            if (camColor == null) {
                return o63.m6474r(f3);
            }
            return camColor.m817d(i43Var);
        }
        return o63.m6474r(f3);
    }

    /* renamed from: d */
    public final int m817d(i43 i43Var) {
        float f;
        float f2 = this.f3607b;
        double d = f2;
        float f3 = this.f3608c;
        if (d != 0.0d) {
            double d2 = f3;
            if (d2 != 0.0d) {
                f = f2 / ((float) Math.sqrt(d2 / 100.0d));
                float pow = (float) Math.pow(f / Math.pow(1.64d - Math.pow(0.29d, i43Var.f18291f), 0.73d), 1.1111111111111112d);
                double d3 = (this.f3606a * 3.1415927f) / 180.0f;
                float cos = ((float) (Math.cos(2.0d + d3) + 3.8d)) * 0.25f;
                float pow2 = i43Var.f18286a * ((float) Math.pow(f3 / 100.0d, (1.0d / i43Var.f18289d) / i43Var.f18295j));
                float f4 = cos * 3846.1538f * i43Var.f18290e * i43Var.f18288c;
                float f5 = pow2 / i43Var.f18287b;
                float sin = (float) Math.sin(d3);
                float cos2 = (float) Math.cos(d3);
                float f6 = (((0.305f + f5) * 23.0f) * pow) / (((pow * 108.0f) * sin) + (((11.0f * pow) * cos2) + (f4 * 23.0f)));
                float f7 = cos2 * f6;
                float f8 = f6 * sin;
                float f9 = f5 * 460.0f;
                float f10 = ((288.0f * f8) + ((451.0f * f7) + f9)) / 1403.0f;
                float f11 = ((f9 - (891.0f * f7)) - (261.0f * f8)) / 1403.0f;
                float f12 = ((f9 - (f7 * 220.0f)) - (f8 * 6300.0f)) / 1403.0f;
                float max = (float) Math.max(0.0d, (Math.abs(f10) * 27.13d) / (400.0d - Math.abs(f10)));
                float signum = Math.signum(f10);
                float f13 = 100.0f / i43Var.f18293h;
                float pow3 = signum * f13 * ((float) Math.pow(max, 2.380952380952381d));
                float signum2 = Math.signum(f11) * f13 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f11) * 27.13d) / (400.0d - Math.abs(f11))), 2.380952380952381d));
                float signum3 = Math.signum(f12) * f13 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f12) * 27.13d) / (400.0d - Math.abs(f12))), 2.380952380952381d));
                float[] fArr = i43Var.f18292g;
                float f14 = pow3 / fArr[0];
                float f15 = signum2 / fArr[1];
                float f16 = signum3 / fArr[2];
                float[][] fArr2 = o63.f23620b;
                float[] fArr3 = fArr2[0];
                float f17 = (fArr3[2] * f16) + (fArr3[1] * f15) + (fArr3[0] * f14);
                float[] fArr4 = fArr2[1];
                float f18 = (fArr4[2] * f16) + (fArr4[1] * f15) + (fArr4[0] * f14);
                float[] fArr5 = fArr2[2];
                return ColorUtils.XYZToColor(f17, f18, (f16 * fArr5[2]) + (f15 * fArr5[1]) + (f14 * fArr5[0]));
            }
        }
        f = RecyclerView.f7068F0;
        float pow4 = (float) Math.pow(f / Math.pow(1.64d - Math.pow(0.29d, i43Var.f18291f), 0.73d), 1.1111111111111112d);
        double d32 = (this.f3606a * 3.1415927f) / 180.0f;
        float cos3 = ((float) (Math.cos(2.0d + d32) + 3.8d)) * 0.25f;
        float pow22 = i43Var.f18286a * ((float) Math.pow(f3 / 100.0d, (1.0d / i43Var.f18289d) / i43Var.f18295j));
        float f42 = cos3 * 3846.1538f * i43Var.f18290e * i43Var.f18288c;
        float f52 = pow22 / i43Var.f18287b;
        float sin2 = (float) Math.sin(d32);
        float cos22 = (float) Math.cos(d32);
        float f62 = (((0.305f + f52) * 23.0f) * pow4) / (((pow4 * 108.0f) * sin2) + (((11.0f * pow4) * cos22) + (f42 * 23.0f)));
        float f72 = cos22 * f62;
        float f82 = f62 * sin2;
        float f92 = f52 * 460.0f;
        float f102 = ((288.0f * f82) + ((451.0f * f72) + f92)) / 1403.0f;
        float f112 = ((f92 - (891.0f * f72)) - (261.0f * f82)) / 1403.0f;
        float f122 = ((f92 - (f72 * 220.0f)) - (f82 * 6300.0f)) / 1403.0f;
        float max2 = (float) Math.max(0.0d, (Math.abs(f102) * 27.13d) / (400.0d - Math.abs(f102)));
        float signum4 = Math.signum(f102);
        float f132 = 100.0f / i43Var.f18293h;
        float pow32 = signum4 * f132 * ((float) Math.pow(max2, 2.380952380952381d));
        float signum22 = Math.signum(f112) * f132 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f112) * 27.13d) / (400.0d - Math.abs(f112))), 2.380952380952381d));
        float signum32 = Math.signum(f122) * f132 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f122) * 27.13d) / (400.0d - Math.abs(f122))), 2.380952380952381d));
        float[] fArr6 = i43Var.f18292g;
        float f142 = pow32 / fArr6[0];
        float f152 = signum22 / fArr6[1];
        float f162 = signum32 / fArr6[2];
        float[][] fArr22 = o63.f23620b;
        float[] fArr32 = fArr22[0];
        float f172 = (fArr32[2] * f162) + (fArr32[1] * f152) + (fArr32[0] * f142);
        float[] fArr42 = fArr22[1];
        float f182 = (fArr42[2] * f162) + (fArr42[1] * f152) + (fArr42[0] * f142);
        float[] fArr52 = fArr22[2];
        return ColorUtils.XYZToColor(f172, f182, (f162 * fArr52[2]) + (f152 * fArr52[1]) + (f142 * fArr52[0]));
    }
}
