package okio;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\bJ\u001f\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, m5569d2 = {"Lokio/InflaterSource;", "Lokio/Source;", "Lokio/BufferedSource;", FirebaseAnalytics.Param.SOURCE, "Ljava/util/zip/Inflater;", "inflater", "<init>", "(Lokio/BufferedSource;Ljava/util/zip/Inflater;)V", "(Lokio/Source;Ljava/util/zip/Inflater;)V", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "readOrInflate", "", "refill", "()Z", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "", "close", "()V", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class InflaterSource implements Source {

    /* renamed from: a */
    public final BufferedSource f24726a;

    /* renamed from: b */
    public final Inflater f24727b;

    /* renamed from: c */
    public int f24728c;

    /* renamed from: d */
    public boolean f24729d;

    public InflaterSource(@NotNull BufferedSource source, @NotNull Inflater inflater) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.f24726a = source;
        this.f24727b = inflater;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f24729d) {
            return;
        }
        this.f24727b.end();
        this.f24729d = true;
        this.f24726a.close();
    }

    @Override // okio.Source
    public long read(@NotNull Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        do {
            long readOrInflate = readOrInflate(sink, byteCount);
            if (readOrInflate > 0) {
                return readOrInflate;
            }
            Inflater inflater = this.f24727b;
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.f24726a.exhausted());
        throw new EOFException("source exhausted prematurely");
    }

    public final long readOrInflate(@NotNull Buffer sink, long byteCount) {
        Inflater inflater = this.f24727b;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount >= 0) {
            if (!this.f24729d) {
                if (byteCount == 0) {
                    return 0L;
                }
                try {
                    Segment writableSegment$okio = sink.writableSegment$okio(1);
                    int min = (int) Math.min(byteCount, 8192 - writableSegment$okio.limit);
                    refill();
                    int inflate = inflater.inflate(writableSegment$okio.data, writableSegment$okio.limit, min);
                    int i = this.f24728c;
                    if (i != 0) {
                        int remaining = i - inflater.getRemaining();
                        this.f24728c -= remaining;
                        this.f24726a.skip(remaining);
                    }
                    if (inflate > 0) {
                        writableSegment$okio.limit += inflate;
                        long j = inflate;
                        sink.setSize$okio(sink.size() + j);
                        return j;
                    }
                    if (writableSegment$okio.pos == writableSegment$okio.limit) {
                        sink.head = writableSegment$okio.pop();
                        SegmentPool.recycle(writableSegment$okio);
                    }
                    return 0L;
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException(ye0.m8294n(byteCount, "byteCount < 0: ").toString());
    }

    public final boolean refill() {
        Inflater inflater = this.f24727b;
        if (!inflater.needsInput()) {
            return false;
        }
        BufferedSource bufferedSource = this.f24726a;
        if (bufferedSource.exhausted()) {
            return true;
        }
        Segment segment = bufferedSource.getBuffer().head;
        Intrinsics.checkNotNull(segment);
        int i = segment.limit;
        int i2 = segment.pos;
        int i3 = i - i2;
        this.f24728c = i3;
        inflater.setInput(segment.data, i2, i3);
        return false;
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.f24726a.timeout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InflaterSource(@NotNull Source source, @NotNull Inflater inflater) {
        this(Okio.buffer(source), inflater);
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
    }
}
