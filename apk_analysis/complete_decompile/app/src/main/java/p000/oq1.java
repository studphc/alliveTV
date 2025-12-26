package p000;

import androidx.collection.ScatterMapKt;
import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import java.io.Serializable;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class oq1 extends AbstractC1966x0 implements Serializable {

    /* renamed from: c */
    public static final oq1 f24864c = new oq1(0, false);

    /* renamed from: d */
    public static final oq1 f24865d = new oq1(0, true);

    /* renamed from: e */
    public static final oq1 f24866e = new oq1(Hashing.f15058a, true);
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final int f24867a;

    /* renamed from: b */
    public final boolean f24868b;

    public oq1(int i, boolean z) {
        this.f24867a = i;
        this.f24868b = z;
    }

    /* renamed from: a */
    public static long m6715a(char c) {
        return (c >>> '\f') | 224 | ((((c >>> 6) & 63) | 128) << 8) | (((c & '?') | 128) << 16);
    }

    /* renamed from: b */
    public static long m6716b(int i) {
        return (i >>> 18) | 240 | ((((i >>> 12) & 63) | 128) << 8) | ((((i >>> 6) & 63) | 128) << 16) | (((i & 63) | 128) << 24);
    }

    /* renamed from: c */
    public static HashCode m6717c(int i, int i2) {
        int i3 = i ^ i2;
        int i4 = (i3 ^ (i3 >>> 16)) * (-2048144789);
        int i5 = (i4 ^ (i4 >>> 13)) * (-1028477387);
        return HashCode.fromInt(i5 ^ (i5 >>> 16));
    }

    /* renamed from: d */
    public static int m6718d(int i, int i2) {
        return (Integer.rotateLeft(i ^ i2, 13) * 5) - 430675100;
    }

    /* renamed from: e */
    public static int m6719e(int i) {
        return Integer.rotateLeft(i * ScatterMapKt.MurmurHashC1, 15) * 461845907;
    }

    @Override // com.google.common.hash.HashFunction
    public final int bits() {
        return 32;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof oq1)) {
            return false;
        }
        oq1 oq1Var = (oq1) obj;
        if (this.f24867a != oq1Var.f24867a || this.f24868b != oq1Var.f24868b) {
            return false;
        }
        return true;
    }

    @Override // p000.AbstractC1966x0, com.google.common.hash.HashFunction
    public final HashCode hashBytes(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        int i3 = this.f24867a;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5 + 4;
            if (i6 > i2) {
                break;
            }
            int i7 = i5 + i;
            i3 = m6718d(i3, m6719e(Ints.fromBytes(bArr[i7 + 3], bArr[i7 + 2], bArr[i7 + 1], bArr[i7])));
            i5 = i6;
        }
        int i8 = i5;
        int i9 = 0;
        while (i8 < i2) {
            i4 ^= UnsignedBytes.toInt(bArr[i + i8]) << i9;
            i8++;
            i9 += 8;
        }
        return m6717c(m6719e(i4) ^ i3, i2);
    }

    public final int hashCode() {
        return oq1.class.hashCode() ^ this.f24867a;
    }

    @Override // p000.AbstractC1966x0, com.google.common.hash.HashFunction
    public final HashCode hashInt(int i) {
        return m6717c(m6718d(this.f24867a, m6719e(i)), 4);
    }

    @Override // p000.AbstractC1966x0, com.google.common.hash.HashFunction
    public final HashCode hashLong(long j) {
        return m6717c(m6718d(m6718d(this.f24867a, m6719e((int) j)), m6719e((int) (j >>> 32))), 8);
    }

    @Override // p000.AbstractC1966x0, com.google.common.hash.HashFunction
    public final HashCode hashString(CharSequence charSequence, Charset charset) {
        int i;
        if (Charsets.UTF_8.equals(charset)) {
            int length = charSequence.length();
            int i2 = this.f24867a;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = i3 + 4;
                if (i5 > length) {
                    break;
                }
                char charAt = charSequence.charAt(i3);
                char charAt2 = charSequence.charAt(i3 + 1);
                char charAt3 = charSequence.charAt(i3 + 2);
                char charAt4 = charSequence.charAt(i3 + 3);
                if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                    break;
                }
                i2 = m6718d(i2, m6719e((charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24)));
                i4 += 4;
                i3 = i5;
            }
            long j = 0;
            int i6 = 0;
            while (i3 < length) {
                char charAt5 = charSequence.charAt(i3);
                if (charAt5 < 128) {
                    j |= charAt5 << i6;
                    i6 += 8;
                    i4++;
                    i = i2;
                } else if (charAt5 < 2048) {
                    i = i2;
                    j |= ((((charAt5 & '?') | 128) << 8) | ((charAt5 >>> 6) | 192)) << i6;
                    i6 += 16;
                    i4 += 2;
                } else {
                    i = i2;
                    if (charAt5 >= 55296 && charAt5 <= 57343) {
                        int codePointAt = Character.codePointAt(charSequence, i3);
                        if (codePointAt == charAt5) {
                            byte[] bytes = charSequence.toString().getBytes(charset);
                            return hashBytes(bytes, 0, bytes.length);
                        }
                        i3++;
                        j |= m6716b(codePointAt) << i6;
                        if (this.f24868b) {
                            i6 += 32;
                        }
                        i4 += 4;
                    } else {
                        j |= m6715a(charAt5) << i6;
                        i6 += 24;
                        i4 += 3;
                    }
                }
                if (i6 >= 32) {
                    i2 = m6718d(i, m6719e((int) j));
                    j >>>= 32;
                    i6 -= 32;
                } else {
                    i2 = i;
                }
                i3++;
            }
            return m6717c(m6719e((int) j) ^ i2, i4);
        }
        byte[] bytes2 = charSequence.toString().getBytes(charset);
        return hashBytes(bytes2, 0, bytes2.length);
    }

    @Override // p000.AbstractC1966x0, com.google.common.hash.HashFunction
    public final HashCode hashUnencodedChars(CharSequence charSequence) {
        int i = this.f24867a;
        for (int i2 = 1; i2 < charSequence.length(); i2 += 2) {
            i = m6718d(i, m6719e(charSequence.charAt(i2 - 1) | (charSequence.charAt(i2) << 16)));
        }
        if ((charSequence.length() & 1) == 1) {
            i ^= m6719e(charSequence.charAt(charSequence.length() - 1));
        }
        return m6717c(i, charSequence.length() * 2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.common.hash.Hasher, nq1] */
    @Override // com.google.common.hash.HashFunction
    public final Hasher newHasher() {
        ?? obj = new Object();
        obj.f23457a = this.f24867a;
        obj.f23460d = 0;
        obj.f23461e = false;
        return obj;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(31);
        sb.append("Hashing.murmur3_32(");
        sb.append(this.f24867a);
        sb.append(")");
        return sb.toString();
    }
}
