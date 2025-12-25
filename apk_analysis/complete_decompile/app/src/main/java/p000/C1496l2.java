package p000;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.PrimitiveSink;
import java.nio.ByteBuffer;

/* renamed from: l2 */
/* loaded from: classes2.dex */
public final class C1496l2 extends AbstractC2003y0 {

    /* renamed from: a */
    public final C1533m2 f22299a;

    /* renamed from: b */
    public final /* synthetic */ AbstractC1570n2 f22300b;

    public C1496l2(AbstractC1570n2 abstractC1570n2, int i) {
        this.f22300b = abstractC1570n2;
        this.f22299a = new C1533m2(i, 0);
    }

    @Override // com.google.common.hash.Hasher
    public final HashCode hash() {
        C1533m2 c1533m2 = this.f22299a;
        return this.f22300b.hashBytes(c1533m2.m6004a(), 0, c1533m2.m6006c());
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putByte(byte b) {
        this.f22299a.write(b);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBytes(byte[] bArr, int i, int i2) {
        this.f22299a.write(bArr, i, i2);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final PrimitiveSink putByte(byte b) {
        this.f22299a.write(b);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final PrimitiveSink putBytes(byte[] bArr, int i, int i2) {
        this.f22299a.write(bArr, i, i2);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBytes(ByteBuffer byteBuffer) {
        this.f22299a.m6007d(byteBuffer);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final PrimitiveSink putBytes(ByteBuffer byteBuffer) {
        this.f22299a.m6007d(byteBuffer);
        return this;
    }
}
