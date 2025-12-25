package okio;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.ye0;

@Metadata(m5568d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\rJ\u000f\u0010\u0015\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\u00020\u00128G¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0015\u0010\u0014¨\u0006\u0018"}, m5569d2 = {"Lokio/GzipSink;", "Lokio/Sink;", "sink", "<init>", "(Lokio/Sink;)V", "Lokio/Buffer;", FirebaseAnalytics.Param.SOURCE, "", "byteCount", "", "write", "(Lokio/Buffer;J)V", "flush", "()V", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "close", "Ljava/util/zip/Deflater;", "-deprecated_deflater", "()Ljava/util/zip/Deflater;", "deflater", "b", "Ljava/util/zip/Deflater;", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class GzipSink implements Sink {

    /* renamed from: a */
    public final RealBufferedSink f24712a;

    /* renamed from: b, reason: from kotlin metadata */
    public final Deflater deflater;

    /* renamed from: c */
    public final DeflaterSink f24714c;

    /* renamed from: d */
    public boolean f24715d;

    /* renamed from: e */
    public final CRC32 f24716e;

    public GzipSink(@NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        RealBufferedSink realBufferedSink = new RealBufferedSink(sink);
        this.f24712a = realBufferedSink;
        Deflater deflater = new Deflater(-1, true);
        this.deflater = deflater;
        this.f24714c = new DeflaterSink((BufferedSink) realBufferedSink, deflater);
        this.f24716e = new CRC32();
        Buffer buffer = realBufferedSink.bufferField;
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "deflater", imports = {}))
    @JvmName(name = "-deprecated_deflater")
    @NotNull
    /* renamed from: -deprecated_deflater, reason: not valid java name and from getter */
    public final Deflater getDeflater() {
        return this.deflater;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Deflater deflater = this.deflater;
        RealBufferedSink realBufferedSink = this.f24712a;
        if (this.f24715d) {
            return;
        }
        try {
            this.f24714c.finishDeflate$okio();
            realBufferedSink.writeIntLe((int) this.f24716e.getValue());
            realBufferedSink.writeIntLe((int) deflater.getBytesRead());
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            deflater.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            realBufferedSink.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f24715d = true;
        if (th == null) {
        } else {
            throw th;
        }
    }

    @JvmName(name = "deflater")
    @NotNull
    public final Deflater deflater() {
        return this.deflater;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.f24714c.flush();
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.f24712a.timeout();
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer source, long byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (byteCount >= 0) {
            if (byteCount == 0) {
                return;
            }
            Segment segment = source.head;
            Intrinsics.checkNotNull(segment);
            long j = byteCount;
            while (j > 0) {
                int min = (int) Math.min(j, segment.limit - segment.pos);
                this.f24716e.update(segment.data, segment.pos, min);
                j -= min;
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
            }
            this.f24714c.write(source, byteCount);
            return;
        }
        throw new IllegalArgumentException(ye0.m8294n(byteCount, "byteCount < 0: ").toString());
    }
}
