package p000;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.PrimitiveSink;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: c3 */
/* loaded from: classes2.dex */
public abstract class AbstractC0579c3 extends AbstractC2003y0 {

    /* renamed from: a */
    public final ByteBuffer f8239a;

    /* renamed from: b */
    public final int f8240b;

    /* renamed from: c */
    public final int f8241c;

    public AbstractC0579c3(int i) {
        boolean z;
        if (i % i == 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f8239a = ByteBuffer.allocate(i + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f8240b = i;
        this.f8241c = i;
    }

    /* renamed from: a */
    public abstract HashCode mo2184a();

    /* renamed from: b */
    public final void m2185b() {
        ByteBuffer byteBuffer = this.f8239a;
        byteBuffer.flip();
        while (byteBuffer.remaining() >= this.f8241c) {
            mo2187d(byteBuffer);
        }
        byteBuffer.compact();
    }

    /* renamed from: c */
    public final void m2186c() {
        if (this.f8239a.remaining() < 8) {
            m2185b();
        }
    }

    /* renamed from: d */
    public abstract void mo2187d(ByteBuffer byteBuffer);

    /* renamed from: e */
    public abstract void mo2188e(ByteBuffer byteBuffer);

    /* renamed from: f */
    public final void m2189f(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        ByteBuffer byteBuffer2 = this.f8239a;
        if (remaining <= byteBuffer2.remaining()) {
            byteBuffer2.put(byteBuffer);
            m2186c();
            return;
        }
        int position = this.f8240b - byteBuffer2.position();
        for (int i = 0; i < position; i++) {
            byteBuffer2.put(byteBuffer.get());
        }
        m2185b();
        while (byteBuffer.remaining() >= this.f8241c) {
            mo2187d(byteBuffer);
        }
        byteBuffer2.put(byteBuffer);
    }

    @Override // com.google.common.hash.Hasher
    public final HashCode hash() {
        m2185b();
        ByteBuffer byteBuffer = this.f8239a;
        byteBuffer.flip();
        if (byteBuffer.remaining() > 0) {
            mo2188e(byteBuffer);
            byteBuffer.position(byteBuffer.limit());
        }
        return mo2184a();
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
    public final Hasher putByte(byte b) {
        this.f8239a.put(b);
        m2186c();
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] bArr, int i, int i2) {
        putBytes(bArr, i, i2);
        return this;
    }

    @Override // p000.AbstractC2003y0, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putChar(char c) {
        this.f8239a.putChar(c);
        m2186c();
        return this;
    }

    @Override // p000.AbstractC2003y0, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putInt(int i) {
        this.f8239a.putInt(i);
        m2186c();
        return this;
    }

    @Override // p000.AbstractC2003y0, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putLong(long j) {
        this.f8239a.putLong(j);
        m2186c();
        return this;
    }

    @Override // p000.AbstractC2003y0, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putShort(short s) {
        this.f8239a.putShort(s);
        m2186c();
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBytes(byte[] bArr, int i, int i2) {
        m2189f(ByteBuffer.wrap(bArr, i, i2).order(ByteOrder.LITTLE_ENDIAN));
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBytes(ByteBuffer byteBuffer) {
        ByteOrder order = byteBuffer.order();
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            m2189f(byteBuffer);
            return this;
        } finally {
            byteBuffer.order(order);
        }
    }
}
