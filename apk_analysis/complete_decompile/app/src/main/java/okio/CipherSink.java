package okio;

import com.google.firebase.analytics.FirebaseAnalytics;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, m5569d2 = {"Lokio/CipherSink;", "Lokio/Sink;", "Lokio/BufferedSink;", "sink", "Ljavax/crypto/Cipher;", "cipher", "<init>", "(Lokio/BufferedSink;Ljavax/crypto/Cipher;)V", "Lokio/Buffer;", FirebaseAnalytics.Param.SOURCE, "", "byteCount", "", "write", "(Lokio/Buffer;J)V", "flush", "()V", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "close", "b", "Ljavax/crypto/Cipher;", "getCipher", "()Ljavax/crypto/Cipher;", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class CipherSink implements Sink {

    /* renamed from: a */
    public final BufferedSink f24684a;

    /* renamed from: b, reason: from kotlin metadata */
    public final Cipher cipher;

    /* renamed from: c */
    public final int f24686c;

    /* renamed from: d */
    public boolean f24687d;

    public CipherSink(@NotNull BufferedSink sink, @NotNull Cipher cipher) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        this.f24684a = sink;
        this.cipher = cipher;
        int blockSize = cipher.getBlockSize();
        this.f24686c = blockSize;
        if (blockSize > 0) {
            return;
        }
        throw new IllegalArgumentException(("Block cipher required " + cipher).toString());
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f24687d) {
            return;
        }
        this.f24687d = true;
        Cipher cipher = this.cipher;
        int outputSize = cipher.getOutputSize(0);
        BufferedSink bufferedSink = this.f24684a;
        Throwable th = null;
        if (outputSize != 0) {
            if (outputSize > 8192) {
                try {
                    byte[] doFinal = cipher.doFinal();
                    Intrinsics.checkNotNullExpressionValue(doFinal, "cipher.doFinal()");
                    bufferedSink.write(doFinal);
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                Buffer buffer = bufferedSink.getBuffer();
                Segment writableSegment$okio = buffer.writableSegment$okio(outputSize);
                try {
                    int doFinal2 = cipher.doFinal(writableSegment$okio.data, writableSegment$okio.limit);
                    writableSegment$okio.limit += doFinal2;
                    buffer.setSize$okio(buffer.size() + doFinal2);
                } catch (Throwable th3) {
                    th = th3;
                }
                if (writableSegment$okio.pos == writableSegment$okio.limit) {
                    buffer.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                }
            }
        }
        try {
            bufferedSink.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        if (th == null) {
        } else {
            throw th;
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.f24684a.flush();
    }

    @NotNull
    public final Cipher getCipher() {
        return this.cipher;
    }

    @Override // okio.Sink
    @NotNull
    /* renamed from: timeout */
    public Timeout getF24748a() {
        return this.f24684a.getF24748a();
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer source, long byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        _UtilKt.checkOffsetAndCount(source.size(), 0L, byteCount);
        if (!this.f24687d) {
            while (byteCount > 0) {
                Segment segment = source.head;
                Intrinsics.checkNotNull(segment);
                int min = (int) Math.min(byteCount, segment.limit - segment.pos);
                BufferedSink bufferedSink = this.f24684a;
                Buffer buffer = bufferedSink.getBuffer();
                Cipher cipher = this.cipher;
                int outputSize = cipher.getOutputSize(min);
                while (true) {
                    if (outputSize > 8192) {
                        int i = this.f24686c;
                        if (min <= i) {
                            byte[] update = cipher.update(source.readByteArray(byteCount));
                            Intrinsics.checkNotNullExpressionValue(update, "cipher.update(source.readByteArray(remaining))");
                            bufferedSink.write(update);
                            min = (int) byteCount;
                            break;
                        }
                        min -= i;
                        outputSize = cipher.getOutputSize(min);
                    } else {
                        Segment writableSegment$okio = buffer.writableSegment$okio(outputSize);
                        int update2 = this.cipher.update(segment.data, segment.pos, min, writableSegment$okio.data, writableSegment$okio.limit);
                        writableSegment$okio.limit += update2;
                        buffer.setSize$okio(buffer.size() + update2);
                        if (writableSegment$okio.pos == writableSegment$okio.limit) {
                            buffer.head = writableSegment$okio.pop();
                            SegmentPool.recycle(writableSegment$okio);
                        }
                        bufferedSink.emitCompleteSegments();
                        source.setSize$okio(source.size() - min);
                        int i2 = segment.pos + min;
                        segment.pos = i2;
                        if (i2 == segment.limit) {
                            source.head = segment.pop();
                            SegmentPool.recycle(segment);
                        }
                    }
                }
                byteCount -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }
}
