package p000;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import java.nio.ByteBuffer;
import javax.crypto.Mac;

/* loaded from: classes2.dex */
public final class oe1 extends AbstractC1743r {

    /* renamed from: b */
    public final Mac f23789b;

    /* renamed from: c */
    public boolean f23790c;

    public oe1(Mac mac) {
        this.f23789b = mac;
    }

    @Override // p000.AbstractC1743r
    /* renamed from: a */
    public final void mo5756a(byte b) {
        m6570f();
        this.f23789b.update(b);
    }

    @Override // p000.AbstractC1743r
    /* renamed from: c */
    public final void mo6568c(ByteBuffer byteBuffer) {
        m6570f();
        Preconditions.checkNotNull(byteBuffer);
        this.f23789b.update(byteBuffer);
    }

    @Override // p000.AbstractC1743r
    /* renamed from: d */
    public final void mo6569d(byte[] bArr) {
        m6570f();
        this.f23789b.update(bArr);
    }

    @Override // p000.AbstractC1743r
    /* renamed from: e */
    public final void mo5757e(byte[] bArr, int i, int i2) {
        m6570f();
        this.f23789b.update(bArr, i, i2);
    }

    /* renamed from: f */
    public final void m6570f() {
        Preconditions.checkState(!this.f23790c, "Cannot re-use a Hasher after calling hash() on it");
    }

    @Override // com.google.common.hash.Hasher
    public final HashCode hash() {
        m6570f();
        this.f23790c = true;
        byte[] doFinal = this.f23789b.doFinal();
        char[] cArr = HashCode.f15057a;
        return new lz0(doFinal);
    }
}
