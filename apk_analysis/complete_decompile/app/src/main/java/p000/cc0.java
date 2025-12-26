package p000;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;

/* loaded from: classes2.dex */
public final class cc0 extends AbstractC1570n2 {

    /* renamed from: a */
    public static final cc0 f8324a = new AbstractC1966x0();

    /* renamed from: a */
    public static long m2218a(long j, long j2, long j3) {
        long j4 = (j ^ j2) * j3;
        long j5 = ((j4 ^ (j4 >>> 47)) ^ j2) * j3;
        return (j5 ^ (j5 >>> 47)) * j3;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [pa1, java.lang.Enum] */
    /* renamed from: b */
    public static void m2219b(byte[] bArr, int i, long j, long j2, long[] jArr) {
        ?? r0 = ua1.f27166a;
        long mo6329a = r0.mo6329a(i, bArr);
        long mo6329a2 = r0.mo6329a(i + 8, bArr);
        long mo6329a3 = r0.mo6329a(i + 16, bArr);
        long mo6329a4 = r0.mo6329a(i + 24, bArr);
        long j3 = j + mo6329a;
        long j4 = mo6329a2 + j3 + mo6329a3;
        long rotateRight = Long.rotateRight(j4, 44) + Long.rotateRight(j2 + j3 + mo6329a4, 21);
        jArr[0] = j4 + mo6329a4;
        jArr[1] = rotateRight + j3;
    }

    @Override // com.google.common.hash.HashFunction
    public final int bits() {
        return 64;
    }

    /* JADX WARN: Type inference failed for: r1v13, types: [pa1, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r1v17, types: [pa1, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r1v7, types: [pa1, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r3v2, types: [pa1, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r5v2, types: [pa1, java.lang.Enum] */
    @Override // p000.AbstractC1570n2, p000.AbstractC1966x0, com.google.common.hash.HashFunction
    public final HashCode hashBytes(byte[] bArr, int i, int i2) {
        ?? r5;
        long j;
        long mo6329a;
        long rotateRight;
        long[] jArr;
        int i3;
        int i4 = i + i2;
        Preconditions.checkPositionIndexes(i, i4, bArr.length);
        long j2 = -5435081209227447693L;
        int i5 = 37;
        long j3 = -7286425919675154353L;
        if (i2 <= 32) {
            if (i2 <= 16) {
                if (i2 >= 8) {
                    long j4 = (i2 * 2) - 7286425919675154353L;
                    ?? r1 = ua1.f27166a;
                    long mo6329a2 = r1.mo6329a(i, bArr) - 7286425919675154353L;
                    long mo6329a3 = r1.mo6329a(i4 - 8, bArr);
                    j3 = m2218a((Long.rotateRight(mo6329a3, 37) * j4) + mo6329a2, (Long.rotateRight(mo6329a2, 25) + mo6329a3) * j4, j4);
                } else if (i2 >= 4) {
                    j3 = m2218a(i2 + ((ua1.m7688a(i, bArr) & 4294967295L) << 3), ua1.m7688a(i4 - 4, bArr) & 4294967295L, (i2 * 2) - 7286425919675154353L);
                } else if (i2 > 0) {
                    long j5 = (((bArr[i] & 255) + ((bArr[(i2 >> 1) + i] & 255) << 8)) * (-7286425919675154353L)) ^ ((((bArr[(i2 - 1) + i] & 255) << 2) + i2) * (-4348849565147123417L));
                    j3 = (-7286425919675154353L) * (j5 ^ (j5 >>> 47));
                }
            } else {
                long j6 = (i2 * 2) - 7286425919675154353L;
                ?? r12 = ua1.f27166a;
                long mo6329a4 = r12.mo6329a(i, bArr) * (-5435081209227447693L);
                long mo6329a5 = r12.mo6329a(i + 8, bArr);
                long mo6329a6 = r12.mo6329a(i4 - 8, bArr) * j6;
                j3 = m2218a(Long.rotateRight(mo6329a6, 30) + Long.rotateRight(mo6329a4 + mo6329a5, 43) + (r12.mo6329a(i4 - 16, bArr) * (-7286425919675154353L)), Long.rotateRight(mo6329a5 - 7286425919675154353L, 18) + mo6329a4 + mo6329a6, j6);
            }
        } else if (i2 <= 64) {
            long j7 = (i2 * 2) - 7286425919675154353L;
            ?? r13 = ua1.f27166a;
            long mo6329a7 = r13.mo6329a(i, bArr) * (-7286425919675154353L);
            long mo6329a8 = r13.mo6329a(i + 8, bArr);
            long mo6329a9 = r13.mo6329a(i4 - 8, bArr) * j7;
            long rotateRight2 = Long.rotateRight(mo6329a9, 30) + Long.rotateRight(mo6329a7 + mo6329a8, 43) + (r13.mo6329a(i4 - 16, bArr) * (-7286425919675154353L));
            long m2218a = m2218a(rotateRight2, mo6329a9 + Long.rotateRight(mo6329a8 - 7286425919675154353L, 18) + mo6329a7, j7);
            long mo6329a10 = r13.mo6329a(i + 16, bArr) * j7;
            long mo6329a11 = r13.mo6329a(i + 24, bArr);
            long mo6329a12 = (r13.mo6329a(i4 - 32, bArr) + rotateRight2) * j7;
            j3 = m2218a(((r13.mo6329a(i4 - 24, bArr) + m2218a) * j7) + Long.rotateRight(mo6329a12, 30) + Long.rotateRight(mo6329a10 + mo6329a11, 43), Long.rotateRight(mo6329a11 + mo6329a7, 18) + mo6329a10 + mo6329a12, j7);
        } else {
            long j8 = 81;
            long j9 = (j8 * (-5435081209227447693L)) + 113;
            long j10 = (j9 * (-7286425919675154353L)) + 113;
            long j11 = (j10 ^ (j10 >>> 47)) * (-7286425919675154353L);
            long[] jArr2 = new long[2];
            long[] jArr3 = new long[2];
            int i6 = i2 - 1;
            int i7 = ((i6 / 64) * 64) + i;
            int i8 = i6 & 63;
            int i9 = i7 + i8;
            int i10 = i9 - 63;
            int i11 = i;
            long mo6329a13 = ua1.f27166a.mo6329a(i, bArr) + (j8 * (-7286425919675154353L));
            while (true) {
                long j12 = mo6329a13 + j9 + jArr2[0];
                r5 = ua1.f27166a;
                long rotateRight3 = Long.rotateRight(r5.mo6329a(i11 + 8, bArr) + j12, i5) * j2;
                long rotateRight4 = Long.rotateRight(r5.mo6329a(i11 + 48, bArr) + j9 + jArr2[1], 42) * j2;
                j = rotateRight3 ^ jArr3[1];
                mo6329a = r5.mo6329a(i11 + 40, bArr) + jArr2[0] + rotateRight4;
                rotateRight = Long.rotateRight(j11 + jArr3[0], 33) * j2;
                jArr = jArr3;
                i3 = i8;
                int i12 = i7;
                m2219b(bArr, i11, jArr2[1] * j2, j + jArr3[0], jArr2);
                m2219b(bArr, i11 + 32, rotateRight + jArr[1], r5.mo6329a(i11 + 16, bArr) + mo6329a, jArr);
                i11 += 64;
                if (i11 == i12) {
                    break;
                }
                i8 = i3;
                i7 = i12;
                mo6329a13 = rotateRight;
                jArr3 = jArr;
                j2 = -5435081209227447693L;
                i5 = 37;
                j11 = j;
                j9 = mo6329a;
            }
            long j13 = ((j & 255) << 1) - 5435081209227447693L;
            long j14 = jArr[0] + i3;
            jArr[0] = j14;
            long j15 = jArr2[0] + j14;
            jArr2[0] = j15;
            jArr[0] = jArr[0] + j15;
            long rotateRight5 = Long.rotateRight(r5.mo6329a(i9 - 55, bArr) + rotateRight + mo6329a + jArr2[0], 37) * j13;
            long rotateRight6 = Long.rotateRight(r5.mo6329a(i9 - 15, bArr) + mo6329a + jArr2[1], 42) * j13;
            long j16 = rotateRight5 ^ (jArr[1] * 9);
            long mo6329a14 = r5.mo6329a(i9 - 23, bArr) + (jArr2[0] * 9) + rotateRight6;
            long rotateRight7 = Long.rotateRight(j + jArr[0], 33) * j13;
            m2219b(bArr, i10, jArr2[1] * j13, j16 + jArr[0], jArr2);
            m2219b(bArr, i9 - 31, rotateRight7 + jArr[1], r5.mo6329a(i9 - 47, bArr) + mo6329a14, jArr);
            long m2218a2 = m2218a(jArr2[0], jArr[0], j13);
            long j17 = (mo6329a14 >>> 47) ^ mo6329a14;
            Long.signum(j17);
            j3 = m2218a((j17 * (-4348849565147123417L)) + m2218a2 + j16, m2218a(jArr2[1], jArr[1], j13) + rotateRight7, j13);
        }
        return HashCode.fromLong(j3);
    }

    public final String toString() {
        return "Hashing.farmHashFingerprint64()";
    }
}
