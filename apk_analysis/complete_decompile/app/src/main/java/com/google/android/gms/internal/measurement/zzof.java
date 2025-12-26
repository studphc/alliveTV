package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import p000.le3;
import p000.wc3;
import p000.ye0;

/* loaded from: classes.dex */
public final class zzof {

    /* renamed from: f */
    public static final zzof f13893f = new zzof(0, new int[0], new Object[0], false);

    /* renamed from: a */
    public int f13894a;

    /* renamed from: b */
    public int[] f13895b;

    /* renamed from: c */
    public Object[] f13896c;

    /* renamed from: d */
    public int f13897d = -1;

    /* renamed from: e */
    public boolean f13898e;

    public zzof(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f13894a = i;
        this.f13895b = iArr;
        this.f13896c = objArr;
        this.f13898e = z;
    }

    /* renamed from: a */
    public static zzof m3477a() {
        return new zzof(0, new int[8], new Object[8], true);
    }

    public static zzof zzc() {
        return f13893f;
    }

    /* renamed from: b */
    public final void m3478b(int i, Object obj) {
        if (this.f13898e) {
            m3479c(this.f13894a + 1);
            int[] iArr = this.f13895b;
            int i2 = this.f13894a;
            iArr[i2] = i;
            this.f13896c[i2] = obj;
            this.f13894a = i2 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    /* renamed from: c */
    public final void m3479c(int i) {
        int[] iArr = this.f13895b;
        if (i > iArr.length) {
            int i2 = this.f13894a;
            int i3 = (i2 / 2) + i2;
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.f13895b = Arrays.copyOf(iArr, i);
            this.f13896c = Arrays.copyOf(this.f13896c, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzof)) {
            return false;
        }
        zzof zzofVar = (zzof) obj;
        int i = this.f13894a;
        if (i == zzofVar.f13894a) {
            int[] iArr = this.f13895b;
            int[] iArr2 = zzofVar.f13895b;
            int i2 = 0;
            while (true) {
                if (i2 < i) {
                    if (iArr[i2] != iArr2[i2]) {
                        break;
                    }
                    i2++;
                } else {
                    Object[] objArr = this.f13896c;
                    Object[] objArr2 = zzofVar.f13896c;
                    int i3 = this.f13894a;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f13894a;
        int i2 = i + 527;
        int[] iArr = this.f13895b;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = ((i2 * 31) + i4) * 31;
        Object[] objArr = this.f13896c;
        int i7 = this.f13894a;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final int zza() {
        int zzz;
        int zzA;
        int zzz2;
        int i = this.f13897d;
        if (i == -1) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.f13894a; i3++) {
                int i4 = this.f13895b[i3];
                int i5 = i4 >>> 3;
                int i6 = i4 & 7;
                if (i6 != 0) {
                    if (i6 != 1) {
                        if (i6 != 2) {
                            if (i6 != 3) {
                                if (i6 == 5) {
                                    ((Integer) this.f13896c[i3]).getClass();
                                    zzz2 = zzlk.zzz(i5 << 3) + 4;
                                } else {
                                    throw new IllegalStateException(new zzml("Protocol message tag had invalid wire type."));
                                }
                            } else {
                                int zzz3 = zzlk.zzz(i5 << 3);
                                zzz = zzz3 + zzz3;
                                zzA = ((zzof) this.f13896c[i3]).zza();
                            }
                        } else {
                            int i7 = i5 << 3;
                            zzld zzldVar = (zzld) this.f13896c[i3];
                            int zzz4 = zzlk.zzz(i7);
                            int zzd = zzldVar.zzd();
                            i2 = zzlk.zzz(zzd) + zzd + zzz4 + i2;
                        }
                    } else {
                        ((Long) this.f13896c[i3]).getClass();
                        zzz2 = zzlk.zzz(i5 << 3) + 8;
                    }
                    i2 = zzz2 + i2;
                } else {
                    int i8 = i5 << 3;
                    long longValue = ((Long) this.f13896c[i3]).longValue();
                    zzz = zzlk.zzz(i8);
                    zzA = zzlk.zzA(longValue);
                }
                i2 = zzA + zzz + i2;
            }
            this.f13897d = i2;
            return i2;
        }
        return i;
    }

    public final int zzb() {
        int i = this.f13897d;
        if (i == -1) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.f13894a; i3++) {
                int i4 = this.f13895b[i3] >>> 3;
                zzld zzldVar = (zzld) this.f13896c[i3];
                int zzz = zzlk.zzz(8);
                int zzz2 = zzlk.zzz(i4) + zzlk.zzz(16);
                int zzz3 = zzlk.zzz(24);
                int zzd = zzldVar.zzd();
                i2 += zzz + zzz + zzz2 + ye0.m8285e(zzd, zzd, zzz3);
            }
            this.f13897d = i2;
            return i2;
        }
        return i;
    }

    public final void zzh() {
        if (this.f13898e) {
            this.f13898e = false;
        }
    }

    public final void zzl(le3 le3Var) {
        if (this.f13894a != 0) {
            for (int i = 0; i < this.f13894a; i++) {
                int i2 = this.f13895b[i];
                Object obj = this.f13896c[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 5) {
                                    ((wc3) le3Var).m8038k(i4, ((Integer) obj).intValue());
                                } else {
                                    throw new RuntimeException(new zzml("Protocol message tag had invalid wire type."));
                                }
                            } else {
                                ((wc3) le3Var).f28137a.zzr(i4, 3);
                                ((zzof) obj).zzl(le3Var);
                                ((wc3) le3Var).f28137a.zzr(i4, 4);
                            }
                        } else {
                            ((wc3) le3Var).m8034g(i4, (zzld) obj);
                        }
                    } else {
                        ((wc3) le3Var).m8039l(i4, ((Long) obj).longValue());
                    }
                } else {
                    ((wc3) le3Var).m8043p(i4, ((Long) obj).longValue());
                }
            }
        }
    }
}
