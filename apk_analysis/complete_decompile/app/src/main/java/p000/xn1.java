package p000;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

/* loaded from: classes.dex */
public final class xn1 implements yn1 {

    /* renamed from: a */
    public final byte[] f28655a;

    /* renamed from: b */
    public final ByteBuffer f28656b;

    /* renamed from: c */
    public final InputStream f28657c;

    /* renamed from: d */
    public long f28658d = 0;

    public xn1(InputStream inputStream) {
        this.f28657c = inputStream;
        byte[] bArr = new byte[4];
        this.f28655a = bArr;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f28656b = wrap;
        wrap.order(ByteOrder.BIG_ENDIAN);
    }

    @Override // p000.yn1
    /* renamed from: a */
    public final int mo7516a() {
        ByteBuffer byteBuffer = this.f28656b;
        byteBuffer.position(0);
        m8175c(4);
        return byteBuffer.getInt();
    }

    @Override // p000.yn1
    /* renamed from: b */
    public final long mo7517b() {
        this.f28656b.position(0);
        m8175c(4);
        return r1.getInt() & 4294967295L;
    }

    /* renamed from: c */
    public final void m8175c(int i) {
        if (this.f28657c.read(this.f28655a, 0, i) == i) {
            this.f28658d += i;
            return;
        }
        throw new IOException("read failed");
    }

    @Override // p000.yn1
    public final long getPosition() {
        return this.f28658d;
    }

    @Override // p000.yn1
    public final int readUnsignedShort() {
        ByteBuffer byteBuffer = this.f28656b;
        byteBuffer.position(0);
        m8175c(2);
        return byteBuffer.getShort() & UShort.MAX_VALUE;
    }

    @Override // p000.yn1
    public final void skip(int i) {
        while (i > 0) {
            int skip = (int) this.f28657c.skip(i);
            if (skip >= 1) {
                i -= skip;
                this.f28658d += skip;
            } else {
                throw new IOException("Skip didn't move at least 1 byte forward");
            }
        }
    }
}
