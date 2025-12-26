package okhttp3.internal.ws;

import java.io.Closeable;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.DeflaterSink;
import okio.Sink;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, m5569d2 = {"Lokhttp3/internal/ws/MessageDeflater;", "Ljava/io/Closeable;", "", "noContextTakeover", "<init>", "(Z)V", "Lokio/Buffer;", "buffer", "", "deflate", "(Lokio/Buffer;)V", "close", "()V", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class MessageDeflater implements Closeable {

    /* renamed from: a */
    public final boolean f24584a;

    /* renamed from: b */
    public final Buffer f24585b;

    /* renamed from: c */
    public final Deflater f24586c;

    /* renamed from: d */
    public final DeflaterSink f24587d;

    public MessageDeflater(boolean z) {
        this.f24584a = z;
        Buffer buffer = new Buffer();
        this.f24585b = buffer;
        Deflater deflater = new Deflater(-1, true);
        this.f24586c = deflater;
        this.f24587d = new DeflaterSink((Sink) buffer, deflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f24587d.close();
    }

    public final void deflate(@NotNull Buffer buffer) {
        ByteString byteString;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Buffer buffer2 = this.f24585b;
        if (buffer2.size() == 0) {
            if (this.f24584a) {
                this.f24586c.reset();
            }
            long size = buffer.size();
            DeflaterSink deflaterSink = this.f24587d;
            deflaterSink.write(buffer, size);
            deflaterSink.flush();
            byteString = MessageDeflaterKt.f24588a;
            if (buffer2.rangeEquals(buffer2.size() - byteString.size(), byteString)) {
                long size2 = buffer2.size() - 4;
                Buffer.UnsafeCursor readAndWriteUnsafe$default = Buffer.readAndWriteUnsafe$default(buffer2, null, 1, null);
                try {
                    readAndWriteUnsafe$default.resizeBuffer(size2);
                    CloseableKt.closeFinally(readAndWriteUnsafe$default, null);
                } finally {
                }
            } else {
                buffer2.writeByte(0);
            }
            buffer.write(buffer2, buffer2.size());
            return;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }
}
