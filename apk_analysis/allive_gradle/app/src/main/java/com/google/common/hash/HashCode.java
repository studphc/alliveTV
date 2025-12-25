package com.google.common.hash;

import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.CheckForNull;
import p000.lz0;
import p000.mz0;
import p000.nz0;

/* loaded from: classes2.dex */
public abstract class HashCode {

    /* renamed from: a */
    public static final char[] f15057a = "0123456789abcdef".toCharArray();

    /* renamed from: a */
    public static int m4188a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'W';
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append("Illegal hexadecimal character: ");
        sb.append(c);
        throw new IllegalArgumentException(sb.toString());
    }

    public static HashCode fromBytes(byte[] bArr) {
        boolean z = true;
        if (bArr.length < 1) {
            z = false;
        }
        Preconditions.checkArgument(z, "A HashCode must contain at least 1 byte.");
        return new lz0((byte[]) bArr.clone());
    }

    public static HashCode fromInt(int i) {
        return new mz0(i);
    }

    public static HashCode fromLong(long j) {
        return new nz0(j);
    }

    public static HashCode fromString(String str) {
        boolean z;
        boolean z2 = true;
        if (str.length() >= 2) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "input string (%s) must have at least 2 characters", str);
        if (str.length() % 2 != 0) {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "input string (%s) must have an even number of characters", str);
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < str.length(); i += 2) {
            bArr[i / 2] = (byte) ((m4188a(str.charAt(i)) << 4) + m4188a(str.charAt(i + 1)));
        }
        return new lz0(bArr);
    }

    public abstract byte[] asBytes();

    public abstract int asInt();

    public abstract long asLong();

    /* renamed from: b */
    public abstract boolean mo4189b(HashCode hashCode);

    public abstract int bits();

    /* renamed from: c */
    public byte[] mo4190c() {
        return asBytes();
    }

    /* renamed from: d */
    public abstract void mo4191d(byte[] bArr, int i, int i2);

    public final boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof HashCode)) {
            return false;
        }
        HashCode hashCode = (HashCode) obj;
        if (bits() != hashCode.bits() || !mo4189b(hashCode)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        if (bits() >= 32) {
            return asInt();
        }
        byte[] mo4190c = mo4190c();
        int i = mo4190c[0] & 255;
        for (int i2 = 1; i2 < mo4190c.length; i2++) {
            i |= (mo4190c[i2] & 255) << (i2 * 8);
        }
        return i;
    }

    public abstract long padToLong();

    public final String toString() {
        byte[] mo4190c = mo4190c();
        StringBuilder sb = new StringBuilder(mo4190c.length * 2);
        for (byte b : mo4190c) {
            char[] cArr = f15057a;
            sb.append(cArr[(b >> 4) & 15]);
            sb.append(cArr[b & Ascii.f14464SI]);
        }
        return sb.toString();
    }

    @CanIgnoreReturnValue
    public int writeBytesTo(byte[] bArr, int i, int i2) {
        int min = Ints.min(i2, bits() / 8);
        Preconditions.checkPositionIndexes(i, i + min, bArr.length);
        mo4191d(bArr, i, min);
        return min;
    }
}
