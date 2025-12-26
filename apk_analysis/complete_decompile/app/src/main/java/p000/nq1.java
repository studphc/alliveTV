package p000;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.PrimitiveSink;
import com.google.common.primitives.Ints;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class nq1 extends AbstractC2003y0 {

    /* renamed from: a */
    public int f23457a;

    /* renamed from: b */
    public long f23458b;

    /* renamed from: c */
    public int f23459c;

    /* renamed from: d */
    public int f23460d;

    /* renamed from: e */
    public boolean f23461e;

    /* renamed from: a */
    public final void m6394a(int i, long j) {
        long j2 = this.f23458b;
        int i2 = this.f23459c;
        long j3 = ((j & 4294967295L) << i2) | j2;
        this.f23458b = j3;
        int i3 = (i * 8) + i2;
        this.f23459c = i3;
        this.f23460d += i;
        if (i3 >= 32) {
            this.f23457a = oq1.m6718d(this.f23457a, oq1.m6719e((int) j3));
            this.f23458b >>>= 32;
            this.f23459c -= 32;
        }
    }

    @Override // com.google.common.hash.Hasher
    public final HashCode hash() {
        Preconditions.checkState(!this.f23461e);
        this.f23461e = true;
        int m6719e = this.f23457a ^ oq1.m6719e((int) this.f23458b);
        this.f23457a = m6719e;
        return oq1.m6717c(m6719e, this.f23460d);
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putByte(byte b) {
        putByte(b);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putBytes(ByteBuffer byteBuffer) {
        putBytes(byteBuffer);
        return this;
    }

    @Override // p000.AbstractC2003y0, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putChar(char c) {
        m6394a(2, c);
        return this;
    }

    @Override // p000.AbstractC2003y0, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putInt(int i) {
        m6394a(4, i);
        return this;
    }

    @Override // p000.AbstractC2003y0, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putLong(long j) {
        putLong(j);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putByte(byte b) {
        m6394a(1, b & 255);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] bArr, int i, int i2) {
        putBytes(bArr, i, i2);
        return this;
    }

    @Override // p000.AbstractC2003y0, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final PrimitiveSink putChar(char c) {
        m6394a(2, c);
        return this;
    }

    @Override // p000.AbstractC2003y0, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final PrimitiveSink putInt(int i) {
        m6394a(4, i);
        return this;
    }

    @Override // p000.AbstractC2003y0, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putLong(long j) {
        m6394a(4, (int) j);
        m6394a(4, j >>> 32);
        return this;
    }

    @Override // p000.AbstractC2003y0, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putString(CharSequence charSequence, Charset charset) {
        if (Charsets.UTF_8.equals(charset)) {
            int length = charSequence.length();
            int i = 0;
            while (true) {
                int i2 = i + 4;
                if (i2 > length) {
                    break;
                }
                char charAt = charSequence.charAt(i);
                char charAt2 = charSequence.charAt(i + 1);
                char charAt3 = charSequence.charAt(i + 2);
                char charAt4 = charSequence.charAt(i + 3);
                if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                    break;
                }
                m6394a(4, (charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24));
                i = i2;
            }
            while (i < length) {
                char charAt5 = charSequence.charAt(i);
                if (charAt5 < 128) {
                    m6394a(1, charAt5);
                } else if (charAt5 < 2048) {
                    m6394a(2, (charAt5 >>> 6) | 192 | (((charAt5 & '?') | 128) << 8));
                } else if (charAt5 >= 55296 && charAt5 <= 57343) {
                    int codePointAt = Character.codePointAt(charSequence, i);
                    if (codePointAt == charAt5) {
                        putBytes(charSequence.subSequence(i, length).toString().getBytes(charset));
                        return this;
                    }
                    i++;
                    m6394a(4, oq1.m6716b(codePointAt));
                } else {
                    m6394a(3, oq1.m6715a(charAt5));
                }
                i++;
            }
            return this;
        }
        return super.putString(charSequence, charset);
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBytes(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        int i3 = 0;
        while (true) {
            int i4 = i3 + 4;
            if (i4 > i2) {
                break;
            }
            int i5 = i3 + i;
            m6394a(4, Ints.fromBytes(bArr[i5 + 3], bArr[i5 + 2], bArr[i5 + 1], bArr[i5]));
            i3 = i4;
        }
        while (i3 < i2) {
            putByte(bArr[i + i3]);
            i3++;
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBytes(ByteBuffer byteBuffer) {
        ByteOrder order = byteBuffer.order();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        while (byteBuffer.remaining() >= 4) {
            putInt(byteBuffer.getInt());
        }
        while (byteBuffer.hasRemaining()) {
            putByte(byteBuffer.get());
        }
        byteBuffer.order(order);
        return this;
    }
}
