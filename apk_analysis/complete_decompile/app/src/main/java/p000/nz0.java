package p000;

import com.google.common.hash.HashCode;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class nz0 extends HashCode implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: b */
    public final long f23542b;

    public nz0(long j) {
        this.f23542b = j;
    }

    @Override // com.google.common.hash.HashCode
    public final byte[] asBytes() {
        return new byte[]{(byte) this.f23542b, (byte) (r0 >> 8), (byte) (r0 >> 16), (byte) (r0 >> 24), (byte) (r0 >> 32), (byte) (r0 >> 40), (byte) (r0 >> 48), (byte) (r0 >> 56)};
    }

    @Override // com.google.common.hash.HashCode
    public final int asInt() {
        return (int) this.f23542b;
    }

    @Override // com.google.common.hash.HashCode
    public final long asLong() {
        return this.f23542b;
    }

    @Override // com.google.common.hash.HashCode
    /* renamed from: b */
    public final boolean mo4189b(HashCode hashCode) {
        if (this.f23542b == hashCode.asLong()) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.hash.HashCode
    public final int bits() {
        return 64;
    }

    @Override // com.google.common.hash.HashCode
    /* renamed from: d */
    public final void mo4191d(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i + i3] = (byte) (this.f23542b >> (i3 * 8));
        }
    }

    @Override // com.google.common.hash.HashCode
    public final long padToLong() {
        return this.f23542b;
    }
}
