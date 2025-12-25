package p000;

import android.media.MediaDataSource;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class c23 extends MediaDataSource {

    /* renamed from: a */
    public final /* synthetic */ ByteBuffer f8238a;

    public c23(ByteBuffer byteBuffer) {
        this.f8238a = byteBuffer;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return this.f8238a.limit();
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j, byte[] bArr, int i, int i2) {
        ByteBuffer byteBuffer = this.f8238a;
        if (j >= byteBuffer.limit()) {
            return -1;
        }
        byteBuffer.position((int) j);
        int min = Math.min(i2, byteBuffer.remaining());
        byteBuffer.get(bArr, i, min);
        return min;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
