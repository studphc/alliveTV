package p000;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: cj */
/* loaded from: classes.dex */
public final class C0595cj extends InputStream {

    /* renamed from: a */
    public final ByteBuffer f8376a;

    /* renamed from: b */
    public int f8377b = -1;

    public C0595cj(ByteBuffer byteBuffer) {
        this.f8376a = byteBuffer;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f8376a.remaining();
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i) {
        this.f8377b = this.f8376a.position();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() {
        ByteBuffer byteBuffer = this.f8376a;
        if (byteBuffer.hasRemaining()) {
            return byteBuffer.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        int i = this.f8377b;
        if (i != -1) {
            this.f8376a.position(i);
        } else {
            throw new IOException("Cannot reset to unset mark position");
        }
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        ByteBuffer byteBuffer = this.f8376a;
        if (!byteBuffer.hasRemaining()) {
            return -1L;
        }
        long min = Math.min(j, byteBuffer.remaining());
        byteBuffer.position((int) (byteBuffer.position() + min));
        return min;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        ByteBuffer byteBuffer = this.f8376a;
        if (!byteBuffer.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i2, byteBuffer.remaining());
        byteBuffer.get(bArr, i, min);
        return min;
    }
}
