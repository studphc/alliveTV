package okio;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m5569d2 = {"Lokio/GzipSource;", "Lokio/Source;", FirebaseAnalytics.Param.SOURCE, "<init>", "(Lokio/Source;)V", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "", "close", "()V", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class GzipSource implements Source {

    /* renamed from: a */
    public byte f24717a;

    /* renamed from: b */
    public final RealBufferedSource f24718b;

    /* renamed from: c */
    public final Inflater f24719c;

    /* renamed from: d */
    public final InflaterSource f24720d;

    /* renamed from: e */
    public final CRC32 f24721e;

    public GzipSource(@NotNull Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        RealBufferedSource realBufferedSource = new RealBufferedSource(source);
        this.f24718b = realBufferedSource;
        Inflater inflater = new Inflater(true);
        this.f24719c = inflater;
        this.f24720d = new InflaterSource((BufferedSource) realBufferedSource, inflater);
        this.f24721e = new CRC32();
    }

    /* renamed from: a */
    public static void m6663a(int i, int i2, String str) {
        if (i2 == i) {
            return;
        }
        String format = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        throw new IOException(format);
    }

    /* renamed from: b */
    public final void m6664b(long j, Buffer buffer, long j2) {
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        while (true) {
            int i = segment.limit;
            int i2 = segment.pos;
            if (j < i - i2) {
                break;
            }
            j -= i - i2;
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
        }
        while (j2 > 0) {
            int min = (int) Math.min(segment.limit - r5, j2);
            this.f24721e.update(segment.data, (int) (segment.pos + j), min);
            j2 -= min;
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
            j = 0;
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f24720d.close();
    }

    @Override // okio.Source
    public long read(@NotNull Buffer sink, long byteCount) {
        boolean z;
        byte b;
        long j;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount >= 0) {
            if (byteCount == 0) {
                return 0L;
            }
            byte b2 = this.f24717a;
            CRC32 crc32 = this.f24721e;
            RealBufferedSource realBufferedSource = this.f24718b;
            if (b2 == 0) {
                realBufferedSource.require(10L);
                byte b3 = realBufferedSource.bufferField.getByte(3L);
                if (((b3 >> 1) & 1) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    b = 0;
                    m6664b(0L, realBufferedSource.bufferField, 10L);
                } else {
                    b = 0;
                }
                m6663a(8075, realBufferedSource.readShort(), "ID1ID2");
                realBufferedSource.skip(8L);
                if (((b3 >> 2) & 1) == 1) {
                    realBufferedSource.require(2L);
                    if (z) {
                        m6664b(0L, realBufferedSource.bufferField, 2L);
                    }
                    long readShortLe = realBufferedSource.bufferField.readShortLe();
                    realBufferedSource.require(readShortLe);
                    if (z) {
                        m6664b(0L, realBufferedSource.bufferField, readShortLe);
                        j = readShortLe;
                    } else {
                        j = readShortLe;
                    }
                    realBufferedSource.skip(j);
                }
                if (((b3 >> 3) & 1) == 1) {
                    long indexOf = realBufferedSource.indexOf(b);
                    if (indexOf != -1) {
                        if (z) {
                            m6664b(0L, realBufferedSource.bufferField, indexOf + 1);
                        }
                        realBufferedSource.skip(indexOf + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (((b3 >> 4) & 1) == 1) {
                    long indexOf2 = realBufferedSource.indexOf(b);
                    if (indexOf2 != -1) {
                        if (z) {
                            m6664b(0L, realBufferedSource.bufferField, indexOf2 + 1);
                        }
                        realBufferedSource.skip(indexOf2 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (z) {
                    m6663a(realBufferedSource.readShortLe(), (short) crc32.getValue(), "FHCRC");
                    crc32.reset();
                }
                this.f24717a = (byte) 1;
            }
            if (this.f24717a == 1) {
                long size = sink.size();
                long read = this.f24720d.read(sink, byteCount);
                if (read != -1) {
                    m6664b(size, sink, read);
                    return read;
                }
                this.f24717a = (byte) 2;
            }
            if (this.f24717a == 2) {
                m6663a(realBufferedSource.readIntLe(), (int) crc32.getValue(), "CRC");
                m6663a(realBufferedSource.readIntLe(), (int) this.f24719c.getBytesWritten(), "ISIZE");
                this.f24717a = (byte) 3;
                if (realBufferedSource.exhausted()) {
                    return -1L;
                }
                throw new IOException("gzip finished without exhausting source");
            }
            return -1L;
        }
        throw new IllegalArgumentException(ye0.m8294n(byteCount, "byteCount < 0: ").toString());
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.f24718b.timeout();
    }
}
