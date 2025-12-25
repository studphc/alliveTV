package p000;

import com.google.common.hash.HashCode;
import com.google.common.primitives.UnsignedInts;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class mz0 extends HashCode implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: b */
    public final int f23168b;

    public mz0(int i) {
        this.f23168b = i;
    }

    @Override // com.google.common.hash.HashCode
    public final byte[] asBytes() {
        int i = this.f23168b;
        return new byte[]{(byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }

    @Override // com.google.common.hash.HashCode
    public final int asInt() {
        return this.f23168b;
    }

    @Override // com.google.common.hash.HashCode
    public final long asLong() {
        throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
    }

    @Override // com.google.common.hash.HashCode
    /* renamed from: b */
    public final boolean mo4189b(HashCode hashCode) {
        if (this.f23168b == hashCode.asInt()) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.hash.HashCode
    public final int bits() {
        return 32;
    }

    @Override // com.google.common.hash.HashCode
    /* renamed from: d */
    public final void mo4191d(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i + i3] = (byte) (this.f23168b >> (i3 * 8));
        }
    }

    @Override // com.google.common.hash.HashCode
    public final long padToLong() {
        return UnsignedInts.toLong(this.f23168b);
    }
}
