package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;
import p000.ye0;

/* renamed from: com.google.common.io.a */
/* loaded from: classes2.dex */
public final class C0967a {

    /* renamed from: a */
    public final String f15092a;

    /* renamed from: b */
    public final char[] f15093b;

    /* renamed from: c */
    public final int f15094c;

    /* renamed from: d */
    public final int f15095d;

    /* renamed from: e */
    public final int f15096e;

    /* renamed from: f */
    public final int f15097f;

    /* renamed from: g */
    public final byte[] f15098g;

    /* renamed from: h */
    public final boolean[] f15099h;

    public C0967a(String str, char[] cArr) {
        String str2;
        boolean z;
        boolean z2;
        this.f15092a = (String) Preconditions.checkNotNull(str);
        this.f15093b = (char[]) Preconditions.checkNotNull(cArr);
        try {
            int log2 = IntMath.log2(cArr.length, RoundingMode.UNNECESSARY);
            this.f15095d = log2;
            int min = Math.min(8, Integer.lowestOneBit(log2));
            try {
                this.f15096e = 8 / min;
                this.f15097f = log2 / min;
                this.f15094c = cArr.length - 1;
                byte[] bArr = new byte[128];
                Arrays.fill(bArr, (byte) -1);
                for (int i = 0; i < cArr.length; i++) {
                    char c = cArr[i];
                    if (c < 128) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Preconditions.checkArgument(z, "Non-ASCII character: %s", c);
                    if (bArr[c] == -1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Preconditions.checkArgument(z2, "Duplicate character: %s", c);
                    bArr[c] = (byte) i;
                }
                this.f15098g = bArr;
                boolean[] zArr = new boolean[this.f15096e];
                for (int i2 = 0; i2 < this.f15097f; i2++) {
                    zArr[IntMath.divide(i2 * 8, this.f15095d, RoundingMode.CEILING)] = true;
                }
                this.f15099h = zArr;
            } catch (ArithmeticException e) {
                String str3 = new String(cArr);
                if (str3.length() != 0) {
                    str2 = "Illegal alphabet ".concat(str3);
                } else {
                    str2 = new String("Illegal alphabet ");
                }
                throw new IllegalArgumentException(str2, e);
            }
        } catch (ArithmeticException e2) {
            throw new IllegalArgumentException(ye0.m8290j(35, cArr.length, "Illegal alphabet length "), e2);
        }
    }

    /* renamed from: a */
    public final int m4206a(char c) {
        String str;
        String str2;
        if (c > 127) {
            String valueOf = String.valueOf(Integer.toHexString(c));
            if (valueOf.length() != 0) {
                str2 = "Unrecognized character: 0x".concat(valueOf);
            } else {
                str2 = new String("Unrecognized character: 0x");
            }
            throw new IOException(str2);
        }
        byte b = this.f15098g[c];
        if (b == -1) {
            if (c > ' ' && c != 127) {
                StringBuilder sb = new StringBuilder(25);
                sb.append("Unrecognized character: ");
                sb.append(c);
                throw new IOException(sb.toString());
            }
            String valueOf2 = String.valueOf(Integer.toHexString(c));
            if (valueOf2.length() != 0) {
                str = "Unrecognized character: 0x".concat(valueOf2);
            } else {
                str = new String("Unrecognized character: 0x");
            }
            throw new IOException(str);
        }
        return b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0967a) {
            return Arrays.equals(this.f15093b, ((C0967a) obj).f15093b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f15093b);
    }

    public final String toString() {
        return this.f15092a;
    }
}
