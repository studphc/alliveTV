package okio;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ye0;

@Metadata(m5568d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0010\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001c\u001a\u00020\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010$\u001a\u00020\u001d8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010(\u001a\u00020\u001d8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\"\u0010,\u001a\u00020\u001d8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010!\"\u0004\b+\u0010#R$\u00101\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\f\"\u0004\b0\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00068G¢\u0006\f\n\u0004\b2\u0010.\u001a\u0004\b\u0007\u0010\fR\u0017\u0010\u0010\u001a\u00020\r8G¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b\u0010\u0010\u000f¨\u00065"}, m5569d2 = {"Lokio/Pipe;", "", "", "maxBufferSize", "<init>", "(J)V", "Lokio/Sink;", "sink", "", "fold", "(Lokio/Sink;)V", "-deprecated_sink", "()Lokio/Sink;", "Lokio/Source;", "-deprecated_source", "()Lokio/Source;", FirebaseAnalytics.Param.SOURCE, "cancel", "()V", "a", "J", "getMaxBufferSize$okio", "()J", "Lokio/Buffer;", "b", "Lokio/Buffer;", "getBuffer$okio", "()Lokio/Buffer;", "buffer", "", "c", "Z", "getCanceled$okio", "()Z", "setCanceled$okio", "(Z)V", "canceled", "d", "getSinkClosed$okio", "setSinkClosed$okio", "sinkClosed", "e", "getSourceClosed$okio", "setSourceClosed$okio", "sourceClosed", "f", "Lokio/Sink;", "getFoldedSink$okio", "setFoldedSink$okio", "foldedSink", "g", "h", "Lokio/Source;", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Pipe {

    /* renamed from: a, reason: from kotlin metadata */
    public final long maxBufferSize;

    /* renamed from: b, reason: from kotlin metadata */
    public final Buffer buffer = new Buffer();

    /* renamed from: c, reason: from kotlin metadata */
    public boolean canceled;

    /* renamed from: d, reason: from kotlin metadata */
    public boolean sinkClosed;

    /* renamed from: e, reason: from kotlin metadata */
    public boolean sourceClosed;

    /* renamed from: f, reason: from kotlin metadata */
    public Sink foldedSink;

    /* renamed from: g */
    public final Pipe$sink$1 f24746g;

    /* renamed from: h */
    public final Pipe$source$1 f24747h;

    /* JADX WARN: Type inference failed for: r3v3, types: [okio.Pipe$sink$1] */
    /* JADX WARN: Type inference failed for: r3v4, types: [okio.Pipe$source$1] */
    public Pipe(long j) {
        this.maxBufferSize = j;
        if (j >= 1) {
            this.f24746g = new Sink() { // from class: okio.Pipe$sink$1

                /* renamed from: a */
                public final Timeout f24748a = new Timeout();

                @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    Buffer buffer = Pipe.this.getBuffer();
                    Pipe pipe = Pipe.this;
                    synchronized (buffer) {
                        try {
                            if (pipe.getSinkClosed()) {
                                return;
                            }
                            Sink foldedSink = pipe.getFoldedSink();
                            if (foldedSink == null) {
                                if (pipe.getSourceClosed() && pipe.getBuffer().size() > 0) {
                                    throw new IOException("source is closed");
                                }
                                pipe.setSinkClosed$okio(true);
                                pipe.getBuffer().notifyAll();
                                foldedSink = null;
                            }
                            if (foldedSink != null) {
                                Pipe pipe2 = Pipe.this;
                                Timeout f24748a = foldedSink.getF24748a();
                                Timeout f24748a2 = pipe2.sink().getF24748a();
                                long f24767c = f24748a.getF24767c();
                                long minTimeout = Timeout.INSTANCE.minTimeout(f24748a2.getF24767c(), f24748a.getF24767c());
                                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                                f24748a.timeout(minTimeout, timeUnit);
                                if (f24748a.getF24765a()) {
                                    long deadlineNanoTime = f24748a.deadlineNanoTime();
                                    if (f24748a2.getF24765a()) {
                                        f24748a.deadlineNanoTime(Math.min(f24748a.deadlineNanoTime(), f24748a2.deadlineNanoTime()));
                                    }
                                    try {
                                        foldedSink.close();
                                        f24748a.timeout(f24767c, timeUnit);
                                        if (f24748a2.getF24765a()) {
                                            f24748a.deadlineNanoTime(deadlineNanoTime);
                                            return;
                                        }
                                        return;
                                    } catch (Throwable th) {
                                        f24748a.timeout(f24767c, TimeUnit.NANOSECONDS);
                                        if (f24748a2.getF24765a()) {
                                            f24748a.deadlineNanoTime(deadlineNanoTime);
                                        }
                                        throw th;
                                    }
                                }
                                if (f24748a2.getF24765a()) {
                                    f24748a.deadlineNanoTime(f24748a2.deadlineNanoTime());
                                }
                                try {
                                    foldedSink.close();
                                    f24748a.timeout(f24767c, timeUnit);
                                    if (f24748a2.getF24765a()) {
                                        f24748a.clearDeadline();
                                    }
                                } catch (Throwable th2) {
                                    f24748a.timeout(f24767c, TimeUnit.NANOSECONDS);
                                    if (f24748a2.getF24765a()) {
                                        f24748a.clearDeadline();
                                    }
                                    throw th2;
                                }
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                }

                @Override // okio.Sink, java.io.Flushable
                public void flush() {
                    Sink foldedSink;
                    Buffer buffer = Pipe.this.getBuffer();
                    Pipe pipe = Pipe.this;
                    synchronized (buffer) {
                        if (!pipe.getSinkClosed()) {
                            if (!pipe.getCanceled()) {
                                foldedSink = pipe.getFoldedSink();
                                if (foldedSink == null) {
                                    if (pipe.getSourceClosed() && pipe.getBuffer().size() > 0) {
                                        throw new IOException("source is closed");
                                    }
                                    foldedSink = null;
                                }
                            } else {
                                throw new IOException("canceled");
                            }
                        } else {
                            throw new IllegalStateException("closed");
                        }
                    }
                    if (foldedSink != null) {
                        Pipe pipe2 = Pipe.this;
                        Timeout f24748a = foldedSink.getF24748a();
                        Timeout f24748a2 = pipe2.sink().getF24748a();
                        long f24767c = f24748a.getF24767c();
                        long minTimeout = Timeout.INSTANCE.minTimeout(f24748a2.getF24767c(), f24748a.getF24767c());
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        f24748a.timeout(minTimeout, timeUnit);
                        if (f24748a.getF24765a()) {
                            long deadlineNanoTime = f24748a.deadlineNanoTime();
                            if (f24748a2.getF24765a()) {
                                f24748a.deadlineNanoTime(Math.min(f24748a.deadlineNanoTime(), f24748a2.deadlineNanoTime()));
                            }
                            try {
                                foldedSink.flush();
                                f24748a.timeout(f24767c, timeUnit);
                                if (f24748a2.getF24765a()) {
                                    f24748a.deadlineNanoTime(deadlineNanoTime);
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                f24748a.timeout(f24767c, TimeUnit.NANOSECONDS);
                                if (f24748a2.getF24765a()) {
                                    f24748a.deadlineNanoTime(deadlineNanoTime);
                                }
                                throw th;
                            }
                        }
                        if (f24748a2.getF24765a()) {
                            f24748a.deadlineNanoTime(f24748a2.deadlineNanoTime());
                        }
                        try {
                            foldedSink.flush();
                            f24748a.timeout(f24767c, timeUnit);
                            if (f24748a2.getF24765a()) {
                                f24748a.clearDeadline();
                            }
                        } catch (Throwable th2) {
                            f24748a.timeout(f24767c, TimeUnit.NANOSECONDS);
                            if (f24748a2.getF24765a()) {
                                f24748a.clearDeadline();
                            }
                            throw th2;
                        }
                    }
                }

                @Override // okio.Sink
                @NotNull
                /* renamed from: timeout, reason: from getter */
                public Timeout getF24748a() {
                    return this.f24748a;
                }

                @Override // okio.Sink
                public void write(@NotNull Buffer source, long byteCount) {
                    Sink sink;
                    Intrinsics.checkNotNullParameter(source, "source");
                    Buffer buffer = Pipe.this.getBuffer();
                    Pipe pipe = Pipe.this;
                    synchronized (buffer) {
                        try {
                            if (!pipe.getSinkClosed()) {
                                if (!pipe.getCanceled()) {
                                    while (true) {
                                        if (byteCount > 0) {
                                            sink = pipe.getFoldedSink();
                                            if (sink != null) {
                                                break;
                                            }
                                            if (!pipe.getSourceClosed()) {
                                                long maxBufferSize = pipe.getMaxBufferSize() - pipe.getBuffer().size();
                                                if (maxBufferSize == 0) {
                                                    this.f24748a.waitUntilNotified(pipe.getBuffer());
                                                    if (pipe.getCanceled()) {
                                                        throw new IOException("canceled");
                                                    }
                                                } else {
                                                    long min = Math.min(maxBufferSize, byteCount);
                                                    pipe.getBuffer().write(source, min);
                                                    byteCount -= min;
                                                    pipe.getBuffer().notifyAll();
                                                }
                                            } else {
                                                throw new IOException("source is closed");
                                            }
                                        } else {
                                            sink = null;
                                            break;
                                        }
                                    }
                                } else {
                                    throw new IOException("canceled");
                                }
                            } else {
                                throw new IllegalStateException("closed");
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (sink != null) {
                        Pipe pipe2 = Pipe.this;
                        Timeout f24748a = sink.getF24748a();
                        Timeout f24748a2 = pipe2.sink().getF24748a();
                        long f24767c = f24748a.getF24767c();
                        long minTimeout = Timeout.INSTANCE.minTimeout(f24748a2.getF24767c(), f24748a.getF24767c());
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        f24748a.timeout(minTimeout, timeUnit);
                        if (f24748a.getF24765a()) {
                            long deadlineNanoTime = f24748a.deadlineNanoTime();
                            if (f24748a2.getF24765a()) {
                                f24748a.deadlineNanoTime(Math.min(f24748a.deadlineNanoTime(), f24748a2.deadlineNanoTime()));
                            }
                            try {
                                sink.write(source, byteCount);
                                f24748a.timeout(f24767c, timeUnit);
                                if (f24748a2.getF24765a()) {
                                    f24748a.deadlineNanoTime(deadlineNanoTime);
                                    return;
                                }
                                return;
                            } catch (Throwable th2) {
                                f24748a.timeout(f24767c, TimeUnit.NANOSECONDS);
                                if (f24748a2.getF24765a()) {
                                    f24748a.deadlineNanoTime(deadlineNanoTime);
                                }
                                throw th2;
                            }
                        }
                        if (f24748a2.getF24765a()) {
                            f24748a.deadlineNanoTime(f24748a2.deadlineNanoTime());
                        }
                        try {
                            sink.write(source, byteCount);
                            f24748a.timeout(f24767c, timeUnit);
                            if (f24748a2.getF24765a()) {
                                f24748a.clearDeadline();
                            }
                        } catch (Throwable th3) {
                            f24748a.timeout(f24767c, TimeUnit.NANOSECONDS);
                            if (f24748a2.getF24765a()) {
                                f24748a.clearDeadline();
                            }
                            throw th3;
                        }
                    }
                }
            };
            this.f24747h = new Source() { // from class: okio.Pipe$source$1

                /* renamed from: a */
                public final Timeout f24750a = new Timeout();

                @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    Buffer buffer = Pipe.this.getBuffer();
                    Pipe pipe = Pipe.this;
                    synchronized (buffer) {
                        pipe.setSourceClosed$okio(true);
                        pipe.getBuffer().notifyAll();
                    }
                }

                @Override // okio.Source
                public long read(@NotNull Buffer sink, long byteCount) {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    Buffer buffer = Pipe.this.getBuffer();
                    Pipe pipe = Pipe.this;
                    synchronized (buffer) {
                        try {
                            if (!pipe.getSourceClosed()) {
                                if (!pipe.getCanceled()) {
                                    while (pipe.getBuffer().size() == 0) {
                                        if (pipe.getSinkClosed()) {
                                            return -1L;
                                        }
                                        this.f24750a.waitUntilNotified(pipe.getBuffer());
                                        if (pipe.getCanceled()) {
                                            throw new IOException("canceled");
                                        }
                                    }
                                    long read = pipe.getBuffer().read(sink, byteCount);
                                    pipe.getBuffer().notifyAll();
                                    return read;
                                }
                                throw new IOException("canceled");
                            }
                            throw new IllegalStateException("closed");
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }

                @Override // okio.Source
                @NotNull
                /* renamed from: timeout, reason: from getter */
                public Timeout getF24750a() {
                    return this.f24750a;
                }
            };
            return;
        }
        throw new IllegalArgumentException(ye0.m8294n(j, "maxBufferSize < 1: ").toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sink", imports = {}))
    @JvmName(name = "-deprecated_sink")
    @NotNull
    /* renamed from: -deprecated_sink, reason: not valid java name */
    public final Sink m9077deprecated_sink() {
        return this.f24746g;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = FirebaseAnalytics.Param.SOURCE, imports = {}))
    @JvmName(name = "-deprecated_source")
    @NotNull
    /* renamed from: -deprecated_source, reason: not valid java name */
    public final Source m9078deprecated_source() {
        return this.f24747h;
    }

    public final void cancel() {
        synchronized (this.buffer) {
            this.canceled = true;
            this.buffer.clear();
            this.buffer.notifyAll();
        }
    }

    public final void fold(@NotNull Sink sink) {
        boolean z;
        Buffer buffer;
        Intrinsics.checkNotNullParameter(sink, "sink");
        while (true) {
            synchronized (this.buffer) {
                if (this.foldedSink == null) {
                    if (!this.canceled) {
                        if (this.buffer.exhausted()) {
                            this.sourceClosed = true;
                            this.foldedSink = sink;
                            return;
                        } else {
                            z = this.sinkClosed;
                            buffer = new Buffer();
                            Buffer buffer2 = this.buffer;
                            buffer.write(buffer2, buffer2.size());
                            this.buffer.notifyAll();
                        }
                    } else {
                        this.foldedSink = sink;
                        throw new IOException("canceled");
                    }
                } else {
                    throw new IllegalStateException("sink already folded");
                }
            }
            try {
                sink.write(buffer, buffer.size());
                if (z) {
                    sink.close();
                } else {
                    sink.flush();
                }
            } catch (Throwable th) {
                synchronized (this.buffer) {
                    this.sourceClosed = true;
                    this.buffer.notifyAll();
                    throw th;
                }
            }
        }
    }

    @NotNull
    /* renamed from: getBuffer$okio, reason: from getter */
    public final Buffer getBuffer() {
        return this.buffer;
    }

    /* renamed from: getCanceled$okio, reason: from getter */
    public final boolean getCanceled() {
        return this.canceled;
    }

    @Nullable
    /* renamed from: getFoldedSink$okio, reason: from getter */
    public final Sink getFoldedSink() {
        return this.foldedSink;
    }

    /* renamed from: getMaxBufferSize$okio, reason: from getter */
    public final long getMaxBufferSize() {
        return this.maxBufferSize;
    }

    /* renamed from: getSinkClosed$okio, reason: from getter */
    public final boolean getSinkClosed() {
        return this.sinkClosed;
    }

    /* renamed from: getSourceClosed$okio, reason: from getter */
    public final boolean getSourceClosed() {
        return this.sourceClosed;
    }

    public final void setCanceled$okio(boolean z) {
        this.canceled = z;
    }

    public final void setFoldedSink$okio(@Nullable Sink sink) {
        this.foldedSink = sink;
    }

    public final void setSinkClosed$okio(boolean z) {
        this.sinkClosed = z;
    }

    public final void setSourceClosed$okio(boolean z) {
        this.sourceClosed = z;
    }

    @JvmName(name = "sink")
    @NotNull
    public final Sink sink() {
        return this.f24746g;
    }

    @JvmName(name = FirebaseAnalytics.Param.SOURCE)
    @NotNull
    public final Source source() {
        return this.f24747h;
    }
}
