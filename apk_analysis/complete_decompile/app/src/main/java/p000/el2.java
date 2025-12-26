package p000;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;
import okhttp3.internal.http.HttpStatusCodesKt;

/* loaded from: classes.dex */
public final class el2 {

    /* renamed from: a */
    public final int f16869a;

    /* renamed from: b */
    public final int f16870b;

    /* renamed from: c */
    public final float f16871c;

    /* renamed from: d */
    public final float f16872d;

    /* renamed from: e */
    public final float f16873e;

    /* renamed from: f */
    public final int f16874f;

    /* renamed from: g */
    public final int f16875g;

    /* renamed from: h */
    public final int f16876h;

    /* renamed from: i */
    public final short[] f16877i;

    /* renamed from: j */
    public short[] f16878j;

    /* renamed from: k */
    public int f16879k;

    /* renamed from: l */
    public short[] f16880l;

    /* renamed from: m */
    public int f16881m;

    /* renamed from: n */
    public short[] f16882n;

    /* renamed from: o */
    public int f16883o;

    /* renamed from: p */
    public int f16884p;

    /* renamed from: q */
    public int f16885q;

    /* renamed from: r */
    public int f16886r;

    /* renamed from: s */
    public int f16887s;

    /* renamed from: t */
    public int f16888t;

    /* renamed from: u */
    public int f16889u;

    /* renamed from: v */
    public int f16890v;

    public el2(int i, int i2, float f, float f2, int i3) {
        this.f16869a = i;
        this.f16870b = i2;
        this.f16871c = f;
        this.f16872d = f2;
        this.f16873e = i / i3;
        this.f16874f = i / HttpStatusCodesKt.HTTP_BAD_REQUEST;
        int i4 = i / 65;
        this.f16875g = i4;
        int i5 = i4 * 2;
        this.f16876h = i5;
        this.f16877i = new short[i5];
        this.f16878j = new short[i5 * i2];
        this.f16880l = new short[i5 * i2];
        this.f16882n = new short[i5 * i2];
    }

    /* renamed from: e */
    public static void m4728e(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr3[i8] * i10) + ((i - i10) * sArr2[i9])) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }

    /* renamed from: a */
    public final void m4729a(short[] sArr, int i, int i2) {
        short[] m4731c = m4731c(this.f16880l, this.f16881m, i2);
        this.f16880l = m4731c;
        int i3 = this.f16870b;
        System.arraycopy(sArr, i * i3, m4731c, this.f16881m * i3, i3 * i2);
        this.f16881m += i2;
    }

    /* renamed from: b */
    public final void m4730b(short[] sArr, int i, int i2) {
        int i3 = this.f16876h / i2;
        int i4 = this.f16870b;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.f16877i[i7] = (short) (i8 / i5);
        }
    }

    /* renamed from: c */
    public final short[] m4731c(short[] sArr, int i, int i2) {
        int length = sArr.length;
        int i3 = this.f16870b;
        int i4 = length / i3;
        if (i + i2 <= i4) {
            return sArr;
        }
        return Arrays.copyOf(sArr, (((i4 * 3) / 2) + i2) * i3);
    }

    /* renamed from: d */
    public final int m4732d(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.f16870b;
        int i5 = 255;
        int i6 = 1;
        int i7 = 0;
        int i8 = 0;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                i9 += Math.abs(sArr[i4 + i10] - sArr[(i4 + i2) + i10]);
            }
            if (i9 * i7 < i6 * i2) {
                i7 = i2;
                i6 = i9;
            }
            if (i9 * i5 > i8 * i2) {
                i5 = i2;
                i8 = i9;
            }
            i2++;
        }
        this.f16889u = i6 / i7;
        this.f16890v = i8 / i5;
        return i7;
    }

    /* renamed from: f */
    public final void m4733f() {
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z;
        int i13 = this.f16881m;
        float f2 = this.f16871c;
        float f3 = this.f16872d;
        float f4 = f2 / f3;
        float f5 = this.f16873e * f3;
        double d = f4;
        int i14 = this.f16869a;
        int i15 = this.f16870b;
        int i16 = 1;
        if (d <= 1.00001d && d >= 0.99999d) {
            m4729a(this.f16878j, 0, this.f16879k);
            this.f16879k = 0;
        } else {
            int i17 = this.f16879k;
            int i18 = this.f16876h;
            if (i17 >= i18) {
                int i19 = 0;
                while (true) {
                    int i20 = this.f16886r;
                    if (i20 > 0) {
                        int min = Math.min(i18, i20);
                        m4729a(this.f16878j, i19, min);
                        this.f16886r -= min;
                        i19 += min;
                        i3 = i13;
                        f = f5;
                        i2 = i14;
                    } else {
                        short[] sArr = this.f16878j;
                        if (i14 > 4000) {
                            i = i14 / 4000;
                        } else {
                            i = i16;
                        }
                        int i21 = this.f16875g;
                        int i22 = this.f16874f;
                        if (i15 == i16 && i == i16) {
                            i4 = m4732d(sArr, i19, i22, i21);
                            i3 = i13;
                            f = f5;
                            i2 = i14;
                        } else {
                            m4730b(sArr, i19, i);
                            i2 = i14;
                            i3 = i13;
                            short[] sArr2 = this.f16877i;
                            f = f5;
                            int m4732d = m4732d(sArr2, 0, i22 / i, i21 / i);
                            if (i != 1) {
                                int i23 = m4732d * i;
                                int i24 = i * 4;
                                int i25 = i23 - i24;
                                int i26 = i23 + i24;
                                if (i25 >= i22) {
                                    i22 = i25;
                                }
                                if (i26 <= i21) {
                                    i21 = i26;
                                }
                                if (i15 == 1) {
                                    i4 = m4732d(sArr, i19, i22, i21);
                                } else {
                                    m4730b(sArr, i19, 1);
                                    i4 = m4732d(sArr2, 0, i22, i21);
                                }
                            } else {
                                i4 = m4732d;
                            }
                        }
                        int i27 = this.f16889u;
                        int i28 = this.f16890v;
                        if (i27 == 0 || (i5 = this.f16887s) == 0 || i28 > i27 * 3 || i27 * 2 <= this.f16888t * 3) {
                            i5 = i4;
                        }
                        this.f16888t = i27;
                        this.f16887s = i4;
                        if (d > 1.0d) {
                            short[] sArr3 = this.f16878j;
                            if (f4 >= 2.0f) {
                                i7 = (int) (i5 / (f4 - 1.0f));
                            } else {
                                this.f16886r = (int) (((2.0f - f4) * i5) / (f4 - 1.0f));
                                i7 = i5;
                            }
                            short[] m4731c = m4731c(this.f16880l, this.f16881m, i7);
                            this.f16880l = m4731c;
                            int i29 = i19;
                            m4728e(i7, this.f16870b, m4731c, this.f16881m, sArr3, i29, sArr3, i19 + i5);
                            this.f16881m += i7;
                            i19 = i5 + i7 + i29;
                        } else {
                            int i30 = i19;
                            short[] sArr4 = this.f16878j;
                            if (f4 < 0.5f) {
                                i6 = (int) ((i5 * f4) / (1.0f - f4));
                            } else {
                                this.f16886r = (int) ((((2.0f * f4) - 1.0f) * i5) / (1.0f - f4));
                                i6 = i5;
                            }
                            int i31 = i5 + i6;
                            short[] m4731c2 = m4731c(this.f16880l, this.f16881m, i31);
                            this.f16880l = m4731c2;
                            System.arraycopy(sArr4, i30 * i15, m4731c2, this.f16881m * i15, i5 * i15);
                            m4728e(i6, this.f16870b, this.f16880l, this.f16881m + i5, sArr4, i30 + i5, sArr4, i30);
                            this.f16881m += i31;
                            i19 = i30 + i6;
                        }
                    }
                    if (i19 + i18 > i17) {
                        break;
                    }
                    i14 = i2;
                    i13 = i3;
                    f5 = f;
                    i16 = 1;
                }
                int i32 = this.f16879k - i19;
                short[] sArr5 = this.f16878j;
                System.arraycopy(sArr5, i19 * i15, sArr5, 0, i32 * i15);
                this.f16879k = i32;
                if (f == 1.0f && this.f16881m != (i8 = i3)) {
                    int i33 = i2;
                    int i34 = (int) (i33 / f);
                    int i35 = i33;
                    while (true) {
                        if (i34 <= 16384 && i35 <= 16384) {
                            break;
                        }
                        i34 /= 2;
                        i35 /= 2;
                    }
                    int i36 = this.f16881m - i8;
                    short[] m4731c3 = m4731c(this.f16882n, this.f16883o, i36);
                    this.f16882n = m4731c3;
                    System.arraycopy(this.f16880l, i8 * i15, m4731c3, this.f16883o * i15, i36 * i15);
                    this.f16881m = i8;
                    this.f16883o += i36;
                    int i37 = 0;
                    while (true) {
                        i9 = this.f16883o;
                        i10 = i9 - 1;
                        if (i37 >= i10) {
                            break;
                        }
                        while (true) {
                            i11 = this.f16884p + 1;
                            int i38 = i11 * i34;
                            i12 = this.f16885q;
                            if (i38 <= i12 * i35) {
                                break;
                            }
                            this.f16880l = m4731c(this.f16880l, this.f16881m, 1);
                            for (int i39 = 0; i39 < i15; i39++) {
                                short[] sArr6 = this.f16880l;
                                int i40 = (this.f16881m * i15) + i39;
                                short[] sArr7 = this.f16882n;
                                int i41 = (i37 * i15) + i39;
                                short s = sArr7[i41];
                                short s2 = sArr7[i41 + i15];
                                int i42 = this.f16885q * i35;
                                int i43 = this.f16884p;
                                int i44 = i43 * i34;
                                int i45 = (i43 + 1) * i34;
                                int i46 = i45 - i42;
                                int i47 = i45 - i44;
                                sArr6[i40] = (short) ((((i47 - i46) * s2) + (s * i46)) / i47);
                            }
                            this.f16885q++;
                            this.f16881m++;
                        }
                        this.f16884p = i11;
                        if (i11 == i35) {
                            this.f16884p = 0;
                            if (i12 == i34) {
                                z = true;
                            } else {
                                z = false;
                            }
                            Assertions.checkState(z);
                            this.f16885q = 0;
                        }
                        i37++;
                    }
                    if (i10 != 0) {
                        short[] sArr8 = this.f16882n;
                        System.arraycopy(sArr8, i10 * i15, sArr8, 0, (i9 - i10) * i15);
                        this.f16883o -= i10;
                        return;
                    }
                    return;
                }
            }
        }
        i3 = i13;
        f = f5;
        i2 = i14;
        if (f == 1.0f) {
        }
    }
}
