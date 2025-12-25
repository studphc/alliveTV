package p000;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class lz0 extends HashCode implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: b */
    public final byte[] f22724b;

    public lz0(byte[] bArr) {
        this.f22724b = (byte[]) Preconditions.checkNotNull(bArr);
    }

    @Override // com.google.common.hash.HashCode
    public final byte[] asBytes() {
        return (byte[]) this.f22724b.clone();
    }

    @Override // com.google.common.hash.HashCode
    public final int asInt() {
        boolean z;
        byte[] bArr = this.f22724b;
        if (bArr.length >= 4) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", bArr.length);
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
    }

    @Override // com.google.common.hash.HashCode
    public final long asLong() {
        boolean z;
        byte[] bArr = this.f22724b;
        if (bArr.length >= 8) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", bArr.length);
        return padToLong();
    }

    @Override // com.google.common.hash.HashCode
    /* renamed from: b */
    public final boolean mo4189b(HashCode hashCode) {
        boolean z;
        byte[] bArr = this.f22724b;
        if (bArr.length != hashCode.mo4190c().length) {
            return false;
        }
        boolean z2 = true;
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] == hashCode.mo4190c()[i]) {
                z = true;
            } else {
                z = false;
            }
            z2 &= z;
        }
        return z2;
    }

    @Override // com.google.common.hash.HashCode
    public final int bits() {
        return this.f22724b.length * 8;
    }

    @Override // com.google.common.hash.HashCode
    /* renamed from: c */
    public final byte[] mo4190c() {
        return this.f22724b;
    }

    @Override // com.google.common.hash.HashCode
    /* renamed from: d */
    public final void mo4191d(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f22724b, 0, bArr, i, i2);
    }

    @Override // com.google.common.hash.HashCode
    public final long padToLong() {
        byte[] bArr = this.f22724b;
        long j = bArr[0] & 255;
        for (int i = 1; i < Math.min(bArr.length, 8); i++) {
            j |= (bArr[i] & 255) << (i * 8);
        }
        return j;
    }
}
