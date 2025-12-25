package p000;

import com.google.common.base.Preconditions;
import com.google.common.hash.Hasher;
import com.google.common.hash.PrimitiveSink;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: r */
/* loaded from: classes2.dex */
public abstract class AbstractC1743r extends AbstractC2003y0 {

    /* renamed from: a */
    public final ByteBuffer f25816a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    /* renamed from: a */
    public abstract void mo5756a(byte b);

    /* renamed from: b */
    public final void m7155b(int i) {
        ByteBuffer byteBuffer = this.f25816a;
        try {
            mo5757e(byteBuffer.array(), 0, i);
        } finally {
            byteBuffer.clear();
        }
    }

    /* renamed from: c */
    public void mo6568c(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            mo5757e(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.limit());
            return;
        }
        for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
            mo5756a(byteBuffer.get());
        }
    }

    /* renamed from: d */
    public void mo6569d(byte[] bArr) {
        mo5757e(bArr, 0, bArr.length);
    }

    /* renamed from: e */
    public abstract void mo5757e(byte[] bArr, int i, int i2);

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putByte(byte b) {
        mo5756a(b);
        return this;
    }

    @Override // p000.AbstractC2003y0, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] bArr) {
        putBytes(bArr);
        return this;
    }

    @Override // p000.AbstractC2003y0, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putChar(char c) {
        putChar(c);
        return this;
    }

    @Override // p000.AbstractC2003y0, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putInt(int i) {
        putInt(i);
        return this;
    }

    @Override // p000.AbstractC2003y0, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putLong(long j) {
        putLong(j);
        return this;
    }

    @Override // p000.AbstractC2003y0, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putShort(short s) {
        putShort(s);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final PrimitiveSink putByte(byte b) {
        mo5756a(b);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] bArr, int i, int i2) {
        putBytes(bArr, i, i2);
        return this;
    }

    @Override // p000.AbstractC2003y0, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putChar(char c) {
        this.f25816a.putChar(c);
        m7155b(2);
        return this;
    }

    @Override // p000.AbstractC2003y0, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putInt(int i) {
        this.f25816a.putInt(i);
        m7155b(4);
        return this;
    }

    @Override // p000.AbstractC2003y0, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putLong(long j) {
        this.f25816a.putLong(j);
        m7155b(8);
        return this;
    }

    @Override // p000.AbstractC2003y0, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putShort(short s) {
        this.f25816a.putShort(s);
        m7155b(2);
        return this;
    }

    @Override // p000.AbstractC2003y0, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBytes(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        mo6569d(bArr);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBytes(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        mo5757e(bArr, i, i2);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBytes(ByteBuffer byteBuffer) {
        mo6568c(byteBuffer);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final PrimitiveSink putBytes(ByteBuffer byteBuffer) {
        mo6568c(byteBuffer);
        return this;
    }
}
