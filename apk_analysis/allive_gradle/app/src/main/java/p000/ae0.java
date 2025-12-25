package p000;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;

/* loaded from: classes2.dex */
public final class ae0 extends AbstractC1570n2 {

    /* renamed from: a */
    public static final ae0 f150a = new AbstractC1966x0();

    /* renamed from: a */
    public static long m75a(long j, long j2) {
        long j3 = (j2 ^ j) * (-4132994306676758123L);
        long j4 = (j ^ (j3 ^ (j3 >>> 47))) * (-4132994306676758123L);
        return (j4 ^ (j4 >>> 47)) * (-4132994306676758123L);
    }

    /* renamed from: b */
    public static long m76b(long j) {
        return j ^ (j >>> 47);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [pa1, java.lang.Enum] */
    /* renamed from: c */
    public static void m77c(byte[] bArr, int i, long j, long j2, long[] jArr) {
        ?? r0 = ua1.f27166a;
        long mo6329a = r0.mo6329a(i, bArr);
        long mo6329a2 = r0.mo6329a(i + 8, bArr);
        long mo6329a3 = r0.mo6329a(i + 16, bArr);
        long mo6329a4 = r0.mo6329a(i + 24, bArr);
        long j3 = j + mo6329a;
        long j4 = mo6329a2 + j3 + mo6329a3;
        long rotateRight = Long.rotateRight(j4, 23) + Long.rotateRight(j2 + j3 + mo6329a4, 51);
        jArr[0] = j4 + mo6329a4;
        jArr[1] = rotateRight + j3;
    }

    @Override // com.google.common.hash.HashFunction
    public final int bits() {
        return 64;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [pa1, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r12v2, types: [pa1, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r14v1, types: [pa1, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r2v12, types: [pa1, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r2v19, types: [pa1, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r3v18, types: [pa1, java.lang.Enum] */
    @Override // p000.AbstractC1570n2, p000.AbstractC1966x0, com.google.common.hash.HashFunction
    public final HashCode hashBytes(byte[] bArr, int i, int i2) {
        int i3;
        long j;
        long j2;
        long rotateRight;
        long m75a;
        int i4;
        long j3;
        int i5 = i + i2;
        Preconditions.checkPositionIndexes(i, i5, bArr.length);
        long j4 = -6505348102511208375L;
        if (i2 <= 32) {
            int i6 = i2 & (-8);
            int i7 = 7 & i2;
            long j5 = -4132994306676758123L;
            long j6 = (-1397348546323613475L) ^ (i2 * (-4132994306676758123L));
            for (int i8 = 0; i8 < i6; i8 += 8) {
                j6 = (j6 ^ (m76b(ua1.f27166a.mo6329a(i + i8, bArr) * (-4132994306676758123L)) * (-4132994306676758123L))) * (-4132994306676758123L);
            }
            if (i7 != 0) {
                int i9 = i6 + i;
                Enum r6 = ua1.f27166a;
                long j7 = 0;
                for (int i10 = 0; i10 < Math.min(i7, 8); i10++) {
                    j7 |= (bArr[i9 + i10] & 255) << (i10 * 8);
                }
                j5 = -4132994306676758123L;
                j6 = (j6 ^ j7) * (-4132994306676758123L);
            }
            m75a = m76b(m76b(j6) * j5);
            i4 = 8;
            i3 = i5;
        } else {
            if (i2 <= 64) {
                ?? r2 = ua1.f27166a;
                long mo6329a = r2.mo6329a(i + 24, bArr);
                int i11 = i5 - 16;
                long mo6329a2 = ((r2.mo6329a(i11, bArr) + i2) * (-6505348102511208375L)) + r2.mo6329a(i, bArr);
                long rotateRight2 = Long.rotateRight(mo6329a2 + mo6329a, 52);
                long rotateRight3 = Long.rotateRight(mo6329a2, 37);
                long mo6329a3 = r2.mo6329a(i + 8, bArr) + mo6329a2;
                long rotateRight4 = Long.rotateRight(mo6329a3, 7) + rotateRight3;
                int i12 = i + 16;
                long mo6329a4 = r2.mo6329a(i12, bArr) + mo6329a3;
                long j8 = mo6329a + mo6329a4;
                long rotateRight5 = Long.rotateRight(mo6329a4, 31) + rotateRight2 + rotateRight4;
                long mo6329a5 = r2.mo6329a(i5 - 32, bArr) + r2.mo6329a(i12, bArr);
                long mo6329a6 = r2.mo6329a(i5 - 8, bArr);
                i3 = i5;
                long rotateRight6 = Long.rotateRight(mo6329a5 + mo6329a6, 52);
                long rotateRight7 = Long.rotateRight(mo6329a5, 37);
                long mo6329a7 = r2.mo6329a(i3 - 24, bArr) + mo6329a5;
                long rotateRight8 = Long.rotateRight(mo6329a7, 7) + rotateRight7;
                long mo6329a8 = r2.mo6329a(i11, bArr) + mo6329a7;
                m75a = m76b((m76b(((mo6329a8 + mo6329a6 + rotateRight5) * (-6505348102511208375L)) + ((Long.rotateRight(mo6329a8, 31) + rotateRight6 + rotateRight8 + j8) * (-4288712594273399085L))) * (-6505348102511208375L)) + rotateRight5) * (-4288712594273399085L);
            } else {
                i3 = i5;
                ?? r0 = ua1.f27166a;
                long mo6329a9 = r0.mo6329a(i, bArr);
                long mo6329a10 = r0.mo6329a(i3 - 16, bArr) ^ (-8261664234251669945L);
                long mo6329a11 = r0.mo6329a(i3 - 56, bArr) ^ (-6505348102511208375L);
                long[] jArr = new long[2];
                long[] jArr2 = new long[2];
                long j9 = i2;
                m77c(bArr, i3 - 64, j9, mo6329a10, jArr);
                m77c(bArr, i3 - 32, j9 * (-8261664234251669945L), -6505348102511208375L, jArr2);
                long m76b = (m76b(jArr[1]) * (-8261664234251669945L)) + mo6329a11;
                long rotateRight9 = Long.rotateRight(mo6329a9 + m76b, 39) * (-8261664234251669945L);
                long rotateRight10 = Long.rotateRight(mo6329a10, 33) * (-8261664234251669945L);
                int i13 = (i2 - 1) & (-64);
                int i14 = i;
                while (true) {
                    long j10 = rotateRight9 + rotateRight10 + jArr[0];
                    ?? r14 = ua1.f27166a;
                    long rotateRight11 = Long.rotateRight(r14.mo6329a(i14 + 16, bArr) + j10, 37) * (-8261664234251669945L);
                    long rotateRight12 = Long.rotateRight(r14.mo6329a(i14 + 48, bArr) + rotateRight10 + jArr[1], 42) * (-8261664234251669945L);
                    j = rotateRight11 ^ jArr2[1];
                    j2 = rotateRight12 ^ jArr[0];
                    rotateRight = Long.rotateRight(m76b ^ jArr2[0], 33);
                    m77c(bArr, i14, jArr[1] * (-8261664234251669945L), j + jArr2[0], jArr);
                    m77c(bArr, i14 + 32, rotateRight + jArr2[1], j2, jArr2);
                    i14 += 64;
                    i13 -= 64;
                    if (i13 == 0) {
                        break;
                    }
                    m76b = j;
                    rotateRight10 = j2;
                    rotateRight9 = rotateRight;
                }
                m75a = m75a((m76b(j2) * (-8261664234251669945L)) + m75a(jArr[0], jArr2[0]) + j, m75a(jArr[1], jArr2[1]) + rotateRight);
            }
            i4 = 8;
        }
        if (i2 >= i4) {
            j3 = ua1.f27166a.mo6329a(i, bArr);
        } else {
            j3 = -6505348102511208375L;
        }
        if (i2 >= 9) {
            j4 = ua1.f27166a.mo6329a(i3 - 8, bArr);
        }
        long m75a2 = m75a(m75a + j4, j3);
        if (m75a2 == 0 || m75a2 == 1) {
            m75a2 -= 2;
        }
        return HashCode.fromLong(m75a2);
    }

    public final String toString() {
        return "Hashing.fingerprint2011()";
    }
}
