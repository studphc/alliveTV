package okio;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0011J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, m5569d2 = {"Lokio/DeflaterSink;", "Lokio/Sink;", "Lokio/BufferedSink;", "sink", "Ljava/util/zip/Deflater;", "deflater", "<init>", "(Lokio/BufferedSink;Ljava/util/zip/Deflater;)V", "(Lokio/Sink;Ljava/util/zip/Deflater;)V", "Lokio/Buffer;", FirebaseAnalytics.Param.SOURCE, "", "byteCount", "", "write", "(Lokio/Buffer;J)V", "flush", "()V", "finishDeflate$okio", "finishDeflate", "close", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "", "toString", "()Ljava/lang/String;", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class DeflaterSink implements Sink {

    /* renamed from: a */
    public final BufferedSink f24694a;

    /* renamed from: b */
    public final Deflater f24695b;

    /* renamed from: c */
    public boolean f24696c;

    public DeflaterSink(@NotNull BufferedSink sink, @NotNull Deflater deflater) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
        this.f24694a = sink;
        this.f24695b = deflater;
    }

    /* renamed from: a */
    public final void m6660a(boolean z) {
        Segment writableSegment$okio;
        int deflate;
        BufferedSink bufferedSink = this.f24694a;
        Buffer buffer = bufferedSink.getBuffer();
        while (true) {
            writableSegment$okio = buffer.writableSegment$okio(1);
            Deflater deflater = this.f24695b;
            if (z) {
                byte[] bArr = writableSegment$okio.data;
                int i = writableSegment$okio.limit;
                deflate = deflater.deflate(bArr, i, 8192 - i, 2);
            } else {
                byte[] bArr2 = writableSegment$okio.data;
                int i2 = writableSegment$okio.limit;
                deflate = deflater.deflate(bArr2, i2, 8192 - i2);
            }
            if (deflate > 0) {
                writableSegment$okio.limit += deflate;
                buffer.setSize$okio(buffer.size() + deflate);
                bufferedSink.emitCompleteSegments();
            } else if (deflater.needsInput()) {
                break;
            }
        }
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f24696c) {
            return;
        }
        try {
            finishDeflate$okio();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f24695b.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.f24694a.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f24696c = true;
        if (th == null) {
        } else {
            throw th;
        }
    }

    public final void finishDeflate$okio() {
        this.f24695b.finish();
        m6660a(false);
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        m6660a(true);
        this.f24694a.flush();
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.f24694a.timeout();
    }

    @NotNull
    public String toString() {
        return "DeflaterSink(" + this.f24694a + ')';
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer source, long byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        _UtilKt.checkOffsetAndCount(source.size(), 0L, byteCount);
        while (byteCount > 0) {
            Segment segment = source.head;
            Intrinsics.checkNotNull(segment);
            int min = (int) Math.min(byteCount, segment.limit - segment.pos);
            this.f24695b.setInput(segment.data, segment.pos, min);
            m6660a(false);
            long j = min;
            source.setSize$okio(source.size() - j);
            int i = segment.pos + min;
            segment.pos = i;
            if (i == segment.limit) {
                source.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            byteCount -= j;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeflaterSink(@NotNull Sink sink, @NotNull Deflater deflater) {
        this(Okio.buffer(sink), deflater);
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
    }
}
