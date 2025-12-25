package okio;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.nc0;
import p000.oc0;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u00002\u00060\u0001j\u0002`\u0002:\u000256B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u0018\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u0018\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001a\u001a\u00020\u001e2\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u001d\u0010\"\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0007¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0011\u001a\u00020$2\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010%J\r\u0010&\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0015\u0010 \u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020$¢\u0006\u0004\b \u0010(J\u001d\u0010\"\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020$2\u0006\u0010 \u001a\u00020\u0007¢\u0006\u0004\b\"\u0010)J\r\u0010*\u001a\u00020\u0015¢\u0006\u0004\b*\u0010\u001dJ/\u0010+\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH$¢\u0006\u0004\b+\u0010\u000fJ/\u0010,\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH$¢\u0006\u0004\b,\u0010\u0019J\u000f\u0010-\u001a\u00020\u0015H$¢\u0006\u0004\b-\u0010\u001dJ\u0017\u0010.\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0007H$¢\u0006\u0004\b.\u0010\u0017J\u000f\u0010/\u001a\u00020\u0007H$¢\u0006\u0004\b/\u0010\u0014J\u000f\u00100\u001a\u00020\u0015H$¢\u0006\u0004\b0\u0010\u001dR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00067"}, m5569d2 = {"Lokio/FileHandle;", "Ljava/io/Closeable;", "Lokio/Closeable;", "", "readWrite", "<init>", "(Z)V", "", "fileOffset", "", "array", "", "arrayOffset", "byteCount", "read", "(J[BII)I", "Lokio/Buffer;", "sink", "(JLokio/Buffer;J)J", "size", "()J", "", "resize", "(J)V", "write", "(J[BII)V", FirebaseAnalytics.Param.SOURCE, "(JLokio/Buffer;J)V", "flush", "()V", "Lokio/Source;", "(J)Lokio/Source;", "position", "(Lokio/Source;)J", "reposition", "(Lokio/Source;J)V", "Lokio/Sink;", "(J)Lokio/Sink;", "appendingSink", "()Lokio/Sink;", "(Lokio/Sink;)J", "(Lokio/Sink;J)V", "close", "protectedRead", "protectedWrite", "protectedFlush", "protectedResize", "protectedSize", "protectedClose", "a", "Z", "getReadWrite", "()Z", "nc0", "oc0", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public abstract class FileHandle implements Closeable {

    /* renamed from: a, reason: from kotlin metadata */
    public final boolean readWrite;

    /* renamed from: b */
    public boolean f24698b;

    /* renamed from: c */
    public int f24699c;

    public FileHandle(boolean z) {
        this.readWrite = z;
    }

    public static /* synthetic */ Sink sink$default(FileHandle fileHandle, long j, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = 0;
            }
            return fileHandle.sink(j);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
    }

    public static /* synthetic */ Source source$default(FileHandle fileHandle, long j, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = 0;
            }
            return fileHandle.source(j);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: source");
    }

    /* renamed from: a */
    public final long m6661a(long j, Buffer buffer, long j2) {
        if (j2 >= 0) {
            long j3 = j2 + j;
            long j4 = j;
            while (true) {
                if (j4 >= j3) {
                    break;
                }
                Segment writableSegment$okio = buffer.writableSegment$okio(1);
                int protectedRead = protectedRead(j4, writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j3 - j4, 8192 - r7));
                if (protectedRead == -1) {
                    if (writableSegment$okio.pos == writableSegment$okio.limit) {
                        buffer.head = writableSegment$okio.pop();
                        SegmentPool.recycle(writableSegment$okio);
                    }
                    if (j == j4) {
                        return -1L;
                    }
                } else {
                    writableSegment$okio.limit += protectedRead;
                    long j5 = protectedRead;
                    j4 += j5;
                    buffer.setSize$okio(buffer.size() + j5);
                }
            }
            return j4 - j;
        }
        throw new IllegalArgumentException(ye0.m8294n(j2, "byteCount < 0: ").toString());
    }

    @NotNull
    public final Sink appendingSink() {
        return sink(size());
    }

    /* renamed from: b */
    public final void m6662b(long j, Buffer buffer, long j2) {
        _UtilKt.checkOffsetAndCount(buffer.size(), 0L, j2);
        long j3 = j2 + j;
        while (j < j3) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int min = (int) Math.min(j3 - j, segment.limit - segment.pos);
            protectedWrite(j, segment.data, segment.pos, min);
            segment.pos += min;
            long j4 = min;
            j += j4;
            buffer.setSize$okio(buffer.size() - j4);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            if (this.f24698b) {
                return;
            }
            this.f24698b = true;
            if (this.f24699c != 0) {
                return;
            }
            protectedClose();
        }
    }

    public final void flush() {
        if (this.readWrite) {
            synchronized (this) {
                if (this.f24698b) {
                    throw new IllegalStateException("closed");
                }
            }
            protectedFlush();
            return;
        }
        throw new IllegalStateException("file handle is read-only");
    }

    public final boolean getReadWrite() {
        return this.readWrite;
    }

    public final long position(@NotNull Source source) {
        long j;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source instanceof RealBufferedSource) {
            RealBufferedSource realBufferedSource = (RealBufferedSource) source;
            j = realBufferedSource.bufferField.size();
            source = realBufferedSource.source;
        } else {
            j = 0;
        }
        if (source instanceof oc0) {
            oc0 oc0Var = (oc0) source;
            if (oc0Var.f23762a == this) {
                if (!oc0Var.f23764c) {
                    return oc0Var.f23763b - j;
                }
                throw new IllegalStateException("closed");
            }
        }
        throw new IllegalArgumentException("source was not created by this FileHandle");
    }

    public abstract void protectedClose();

    public abstract void protectedFlush();

    public abstract int protectedRead(long fileOffset, @NotNull byte[] array, int arrayOffset, int byteCount);

    public abstract void protectedResize(long size);

    public abstract long protectedSize();

    public abstract void protectedWrite(long fileOffset, @NotNull byte[] array, int arrayOffset, int byteCount);

    public final int read(long fileOffset, @NotNull byte[] array, int arrayOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(array, "array");
        synchronized (this) {
            if (this.f24698b) {
                throw new IllegalStateException("closed");
            }
        }
        return protectedRead(fileOffset, array, arrayOffset, byteCount);
    }

    public final void reposition(@NotNull Source source, long position) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (source instanceof RealBufferedSource) {
            RealBufferedSource realBufferedSource = (RealBufferedSource) source;
            Source source2 = realBufferedSource.source;
            if (source2 instanceof oc0) {
                oc0 oc0Var = (oc0) source2;
                if (oc0Var.f23762a == this) {
                    if (!oc0Var.f23764c) {
                        long size = realBufferedSource.bufferField.size();
                        long j = position - (oc0Var.f23763b - size);
                        if (0 <= j && j < size) {
                            realBufferedSource.skip(j);
                            return;
                        } else {
                            realBufferedSource.bufferField.clear();
                            oc0Var.f23763b = position;
                            return;
                        }
                    }
                    throw new IllegalStateException("closed");
                }
            }
            throw new IllegalArgumentException("source was not created by this FileHandle");
        }
        if (source instanceof oc0) {
            oc0 oc0Var2 = (oc0) source;
            if (oc0Var2.f23762a == this) {
                if (!oc0Var2.f23764c) {
                    oc0Var2.f23763b = position;
                    return;
                }
                throw new IllegalStateException("closed");
            }
        }
        throw new IllegalArgumentException("source was not created by this FileHandle");
    }

    public final void resize(long size) {
        if (this.readWrite) {
            synchronized (this) {
                if (this.f24698b) {
                    throw new IllegalStateException("closed");
                }
            }
            protectedResize(size);
            return;
        }
        throw new IllegalStateException("file handle is read-only");
    }

    @NotNull
    public final Sink sink(long fileOffset) {
        if (this.readWrite) {
            synchronized (this) {
                if (!this.f24698b) {
                    this.f24699c++;
                } else {
                    throw new IllegalStateException("closed");
                }
            }
            return new nc0(this, fileOffset);
        }
        throw new IllegalStateException("file handle is read-only");
    }

    public final long size() {
        synchronized (this) {
            if (this.f24698b) {
                throw new IllegalStateException("closed");
            }
        }
        return protectedSize();
    }

    @NotNull
    public final Source source(long fileOffset) {
        synchronized (this) {
            if (!this.f24698b) {
                this.f24699c++;
            } else {
                throw new IllegalStateException("closed");
            }
        }
        return new oc0(this, fileOffset);
    }

    public final void write(long fileOffset, @NotNull byte[] array, int arrayOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (this.readWrite) {
            synchronized (this) {
                if (this.f24698b) {
                    throw new IllegalStateException("closed");
                }
            }
            protectedWrite(fileOffset, array, arrayOffset, byteCount);
            return;
        }
        throw new IllegalStateException("file handle is read-only");
    }

    public final long read(long fileOffset, @NotNull Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        synchronized (this) {
            if (this.f24698b) {
                throw new IllegalStateException("closed");
            }
        }
        return m6661a(fileOffset, sink, byteCount);
    }

    public final void write(long fileOffset, @NotNull Buffer source, long byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.readWrite) {
            synchronized (this) {
                if (this.f24698b) {
                    throw new IllegalStateException("closed");
                }
            }
            m6662b(fileOffset, source, byteCount);
            return;
        }
        throw new IllegalStateException("file handle is read-only");
    }

    public final long position(@NotNull Sink sink) {
        long j;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (sink instanceof RealBufferedSink) {
            RealBufferedSink realBufferedSink = (RealBufferedSink) sink;
            j = realBufferedSink.bufferField.size();
            sink = realBufferedSink.sink;
        } else {
            j = 0;
        }
        if (sink instanceof nc0) {
            nc0 nc0Var = (nc0) sink;
            if (nc0Var.f23321a == this) {
                if (!nc0Var.f23323c) {
                    return nc0Var.f23322b + j;
                }
                throw new IllegalStateException("closed");
            }
        }
        throw new IllegalArgumentException("sink was not created by this FileHandle");
    }

    public final void reposition(@NotNull Sink sink, long position) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (sink instanceof RealBufferedSink) {
            RealBufferedSink realBufferedSink = (RealBufferedSink) sink;
            Sink sink2 = realBufferedSink.sink;
            if (sink2 instanceof nc0) {
                nc0 nc0Var = (nc0) sink2;
                if (nc0Var.f23321a == this) {
                    if (!nc0Var.f23323c) {
                        realBufferedSink.emit();
                        nc0Var.f23322b = position;
                        return;
                    }
                    throw new IllegalStateException("closed");
                }
            }
            throw new IllegalArgumentException("sink was not created by this FileHandle");
        }
        if (sink instanceof nc0) {
            nc0 nc0Var2 = (nc0) sink;
            if (nc0Var2.f23321a == this) {
                if (!nc0Var2.f23323c) {
                    nc0Var2.f23322b = position;
                    return;
                }
                throw new IllegalStateException("closed");
            }
        }
        throw new IllegalArgumentException("sink was not created by this FileHandle");
    }
}
