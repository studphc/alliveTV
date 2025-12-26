package p000;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class pn1 extends AbstractC1743r {

    /* renamed from: b */
    public final MessageDigest f25232b;

    /* renamed from: c */
    public final int f25233c;

    /* renamed from: d */
    public boolean f25234d;

    public pn1(MessageDigest messageDigest, int i) {
        this.f25232b = messageDigest;
        this.f25233c = i;
    }

    @Override // p000.AbstractC1743r
    /* renamed from: a */
    public final void mo5756a(byte b) {
        Preconditions.checkState(!this.f25234d, "Cannot re-use a Hasher after calling hash() on it");
        this.f25232b.update(b);
    }

    @Override // p000.AbstractC1743r
    /* renamed from: c */
    public final void mo6568c(ByteBuffer byteBuffer) {
        Preconditions.checkState(!this.f25234d, "Cannot re-use a Hasher after calling hash() on it");
        this.f25232b.update(byteBuffer);
    }

    @Override // p000.AbstractC1743r
    /* renamed from: e */
    public final void mo5757e(byte[] bArr, int i, int i2) {
        Preconditions.checkState(!this.f25234d, "Cannot re-use a Hasher after calling hash() on it");
        this.f25232b.update(bArr, i, i2);
    }

    @Override // com.google.common.hash.Hasher
    public final HashCode hash() {
        Preconditions.checkState(!this.f25234d, "Cannot re-use a Hasher after calling hash() on it");
        this.f25234d = true;
        MessageDigest messageDigest = this.f25232b;
        int digestLength = messageDigest.getDigestLength();
        int i = this.f25233c;
        if (i == digestLength) {
            byte[] digest = messageDigest.digest();
            char[] cArr = HashCode.f15057a;
            return new lz0(digest);
        }
        byte[] copyOf = Arrays.copyOf(messageDigest.digest(), i);
        char[] cArr2 = HashCode.f15057a;
        return new lz0(copyOf);
    }
}
