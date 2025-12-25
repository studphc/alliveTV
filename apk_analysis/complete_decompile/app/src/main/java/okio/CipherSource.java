package okio;

import com.google.firebase.analytics.FirebaseAnalytics;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.ye0;

@Metadata(m5568d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, m5569d2 = {"Lokio/CipherSource;", "Lokio/Source;", "Lokio/BufferedSource;", FirebaseAnalytics.Param.SOURCE, "Ljavax/crypto/Cipher;", "cipher", "<init>", "(Lokio/BufferedSource;Ljavax/crypto/Cipher;)V", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "", "close", "()V", "b", "Ljavax/crypto/Cipher;", "getCipher", "()Ljavax/crypto/Cipher;", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class CipherSource implements Source {

    /* renamed from: a */
    public final BufferedSource f24688a;

    /* renamed from: b, reason: from kotlin metadata */
    public final Cipher cipher;

    /* renamed from: c */
    public final int f24690c;

    /* renamed from: d */
    public final Buffer f24691d;

    /* renamed from: e */
    public boolean f24692e;

    /* renamed from: f */
    public boolean f24693f;

    public CipherSource(@NotNull BufferedSource source, @NotNull Cipher cipher) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        this.f24688a = source;
        this.cipher = cipher;
        int blockSize = cipher.getBlockSize();
        this.f24690c = blockSize;
        this.f24691d = new Buffer();
        if (blockSize > 0) {
            return;
        }
        throw new IllegalArgumentException(("Block cipher required " + cipher).toString());
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f24693f = true;
        this.f24688a.close();
    }

    @NotNull
    public final Cipher getCipher() {
        return this.cipher;
    }

    @Override // okio.Source
    public long read(@NotNull Buffer sink, long byteCount) {
        Buffer buffer;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount >= 0) {
            if (!this.f24693f) {
                if (byteCount == 0) {
                    return 0L;
                }
                while (true) {
                    buffer = this.f24691d;
                    if (buffer.size() != 0 || this.f24692e) {
                        break;
                    }
                    BufferedSource bufferedSource = this.f24688a;
                    boolean exhausted = bufferedSource.exhausted();
                    Cipher cipher = this.cipher;
                    if (exhausted) {
                        this.f24692e = true;
                        int outputSize = cipher.getOutputSize(0);
                        if (outputSize != 0) {
                            Segment writableSegment$okio = buffer.writableSegment$okio(outputSize);
                            int doFinal = cipher.doFinal(writableSegment$okio.data, writableSegment$okio.pos);
                            writableSegment$okio.limit += doFinal;
                            buffer.setSize$okio(buffer.size() + doFinal);
                            if (writableSegment$okio.pos == writableSegment$okio.limit) {
                                buffer.head = writableSegment$okio.pop();
                                SegmentPool.recycle(writableSegment$okio);
                            }
                        }
                    } else {
                        Segment segment = bufferedSource.getBuffer().head;
                        Intrinsics.checkNotNull(segment);
                        int i = segment.limit - segment.pos;
                        int outputSize2 = cipher.getOutputSize(i);
                        while (true) {
                            if (outputSize2 > 8192) {
                                int i2 = this.f24690c;
                                if (i <= i2) {
                                    this.f24692e = true;
                                    byte[] doFinal2 = cipher.doFinal(bufferedSource.readByteArray());
                                    Intrinsics.checkNotNullExpressionValue(doFinal2, "cipher.doFinal(source.readByteArray())");
                                    buffer.write(doFinal2);
                                    break;
                                }
                                i -= i2;
                                outputSize2 = cipher.getOutputSize(i);
                            } else {
                                Segment writableSegment$okio2 = buffer.writableSegment$okio(outputSize2);
                                int update = this.cipher.update(segment.data, segment.pos, i, writableSegment$okio2.data, writableSegment$okio2.pos);
                                bufferedSource.skip(i);
                                writableSegment$okio2.limit += update;
                                buffer.setSize$okio(buffer.size() + update);
                                if (writableSegment$okio2.pos == writableSegment$okio2.limit) {
                                    buffer.head = writableSegment$okio2.pop();
                                    SegmentPool.recycle(writableSegment$okio2);
                                }
                            }
                        }
                    }
                }
                return buffer.read(sink, byteCount);
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException(ye0.m8294n(byteCount, "byteCount < 0: ").toString());
    }

    @Override // okio.Source
    @NotNull
    /* renamed from: timeout */
    public Timeout getF24750a() {
        return this.f24688a.getF24750a();
    }
}
