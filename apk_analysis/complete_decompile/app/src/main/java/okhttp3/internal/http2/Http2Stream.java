package okhttp3.internal.http2;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal._UtilJvmKt;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 |2\u00020\u0001:\u0004|}~\u007fB3\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0017\u001a\u00020\u00162\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001dJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\u001f\u0010)\u001a\u00020\u00162\u0006\u0010&\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b)\u0010*J\u0015\u0010,\u001a\u00020\u00162\u0006\u0010+\u001a\u00020%¢\u0006\u0004\b,\u0010-J\u001d\u00101\u001a\u00020\u00162\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u0002¢\u0006\u0004\b1\u00102J\u001d\u00103\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\u00162\u0006\u0010+\u001a\u00020%¢\u0006\u0004\b5\u0010-J\u000f\u00108\u001a\u00020\u0016H\u0000¢\u0006\u0004\b6\u00107J\u0015\u0010;\u001a\u00020\u00162\u0006\u0010:\u001a\u000209¢\u0006\u0004\b;\u0010<J\u000f\u0010>\u001a\u00020\u0016H\u0000¢\u0006\u0004\b=\u00107J\u000f\u0010@\u001a\u00020\u0016H\u0000¢\u0006\u0004\b?\u00107R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR*\u0010O\u001a\u0002092\u0006\u0010I\u001a\u0002098\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010<R*\u0010S\u001a\u0002092\u0006\u0010I\u001a\u0002098\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010K\u001a\u0004\bQ\u0010M\"\u0004\bR\u0010<R*\u0010W\u001a\u0002092\u0006\u0010I\u001a\u0002098\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010K\u001a\u0004\bU\u0010M\"\u0004\bV\u0010<R*\u0010[\u001a\u0002092\u0006\u0010I\u001a\u0002098\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010K\u001a\u0004\bY\u0010M\"\u0004\bZ\u0010<R\u001e\u0010/\u001a\u00060\\R\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u001e\u0010f\u001a\u00060aR\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u001e\u0010\u001c\u001a\u00060gR\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u001e\u0010\u001e\u001a\u00060gR\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\bl\u0010i\u001a\u0004\bm\u0010kR$\u0010+\u001a\u0004\u0018\u00010%8@@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010-R$\u0010(\u001a\u0004\u0018\u00010'8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u0011\u0010y\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\by\u0010zR\u0011\u0010{\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b{\u0010z¨\u0006\u0080\u0001"}, m5569d2 = {"Lokhttp3/internal/http2/Http2Stream;", "", "", "id", "Lokhttp3/internal/http2/Http2Connection;", "connection", "", "outFinished", "inFinished", "Lokhttp3/Headers;", "headers", "<init>", "(ILokhttp3/internal/http2/Http2Connection;ZZLokhttp3/Headers;)V", "callerIsIdle", "takeHeaders", "(Z)Lokhttp3/Headers;", "trailers", "()Lokhttp3/Headers;", "", "Lokhttp3/internal/http2/Header;", "responseHeaders", "flushHeaders", "", "writeHeaders", "(Ljava/util/List;ZZ)V", "enqueueTrailers", "(Lokhttp3/Headers;)V", "Lokio/Timeout;", "readTimeout", "()Lokio/Timeout;", "writeTimeout", "Lokio/Source;", "getSource", "()Lokio/Source;", "Lokio/Sink;", "getSink", "()Lokio/Sink;", "Lokhttp3/internal/http2/ErrorCode;", "rstStatusCode", "Ljava/io/IOException;", "errorException", "close", "(Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)V", "errorCode", "closeLater", "(Lokhttp3/internal/http2/ErrorCode;)V", "Lokio/BufferedSource;", FirebaseAnalytics.Param.SOURCE, "length", "receiveData", "(Lokio/BufferedSource;I)V", "receiveHeaders", "(Lokhttp3/Headers;Z)V", "receiveRstStream", "cancelStreamIfNecessary$okhttp", "()V", "cancelStreamIfNecessary", "", "delta", "addBytesToWriteWindow", "(J)V", "checkOutNotClosed$okhttp", "checkOutNotClosed", "waitForIo$okhttp", "waitForIo", "a", "I", "getId", "()I", "b", "Lokhttp3/internal/http2/Http2Connection;", "getConnection", "()Lokhttp3/internal/http2/Http2Connection;", "<set-?>", "c", "J", "getReadBytesTotal", "()J", "setReadBytesTotal$okhttp", "readBytesTotal", "d", "getReadBytesAcknowledged", "setReadBytesAcknowledged$okhttp", "readBytesAcknowledged", "e", "getWriteBytesTotal", "setWriteBytesTotal$okhttp", "writeBytesTotal", "f", "getWriteBytesMaximum", "setWriteBytesMaximum$okhttp", "writeBytesMaximum", "Lokhttp3/internal/http2/Http2Stream$FramingSource;", "i", "Lokhttp3/internal/http2/Http2Stream$FramingSource;", "getSource$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lokhttp3/internal/http2/Http2Stream$FramingSink;", "j", "Lokhttp3/internal/http2/Http2Stream$FramingSink;", "getSink$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSink;", "sink", "Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "k", "Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "getReadTimeout$okhttp", "()Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "l", "getWriteTimeout$okhttp", "m", "Lokhttp3/internal/http2/ErrorCode;", "getErrorCode$okhttp", "()Lokhttp3/internal/http2/ErrorCode;", "setErrorCode$okhttp", "n", "Ljava/io/IOException;", "getErrorException$okhttp", "()Ljava/io/IOException;", "setErrorException$okhttp", "(Ljava/io/IOException;)V", "isOpen", "()Z", "isLocallyInitiated", "Companion", "FramingSink", "FramingSource", "StreamTimeout", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Http2Stream {
    public static final long EMIT_BUFFER_SIZE = 16384;

    /* renamed from: a, reason: from kotlin metadata */
    public final int id;

    /* renamed from: b, reason: from kotlin metadata */
    public final Http2Connection connection;

    /* renamed from: c, reason: from kotlin metadata */
    public long readBytesTotal;

    /* renamed from: d, reason: from kotlin metadata */
    public long readBytesAcknowledged;

    /* renamed from: e, reason: from kotlin metadata */
    public long writeBytesTotal;

    /* renamed from: f, reason: from kotlin metadata */
    public long writeBytesMaximum;

    /* renamed from: g */
    public final ArrayDeque f24492g;

    /* renamed from: h */
    public boolean f24493h;

    /* renamed from: i, reason: from kotlin metadata */
    public final FramingSource source;

    /* renamed from: j, reason: from kotlin metadata */
    public final FramingSink sink;

    /* renamed from: k, reason: from kotlin metadata */
    public final StreamTimeout readTimeout;

    /* renamed from: l, reason: from kotlin metadata */
    public final StreamTimeout writeTimeout;

    /* renamed from: m, reason: from kotlin metadata */
    public ErrorCode errorCode;

    /* renamed from: n, reason: from kotlin metadata */
    public IOException errorException;

    @Metadata(m5568d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0005\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0017\u0010\"\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010%\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010!R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00101\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0019\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u0010\u001d¨\u00062"}, m5569d2 = {"Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lokio/Source;", "", "maxByteCount", "", "finished", "<init>", "(Lokhttp3/internal/http2/Http2Stream;JZ)V", "Lokio/Buffer;", "sink", "byteCount", "read", "(Lokio/Buffer;J)J", "Lokio/BufferedSource;", FirebaseAnalytics.Param.SOURCE, "", "receive$okhttp", "(Lokio/BufferedSource;J)V", "receive", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "close", "()V", "b", "Z", "getFinished$okhttp", "()Z", "setFinished$okhttp", "(Z)V", "c", "Lokio/Buffer;", "getReceiveBuffer", "()Lokio/Buffer;", "receiveBuffer", "d", "getReadBuffer", "readBuffer", "Lokhttp3/Headers;", "e", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "trailers", "f", "getClosed$okhttp", "setClosed$okhttp", "closed", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public final class FramingSource implements Source {

        /* renamed from: a */
        public final long f24505a;

        /* renamed from: b, reason: from kotlin metadata */
        public boolean finished;

        /* renamed from: c, reason: from kotlin metadata */
        public final Buffer receiveBuffer = new Buffer();

        /* renamed from: d, reason: from kotlin metadata */
        public final Buffer readBuffer = new Buffer();

        /* renamed from: e, reason: from kotlin metadata */
        public Headers trailers;

        /* renamed from: f, reason: from kotlin metadata */
        public boolean closed;

        public FramingSource(long j, boolean z) {
            this.f24505a = j;
            this.finished = z;
        }

        /* renamed from: a */
        public final void m6636a(long j) {
            boolean z = _UtilJvmKt.assertionsEnabled;
            Http2Stream http2Stream = Http2Stream.this;
            if (z && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            http2Stream.getConnection().updateConnectionFlowControl$okhttp(j);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            long size;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                this.closed = true;
                size = this.readBuffer.size();
                this.readBuffer.clear();
                http2Stream.notifyAll();
            }
            if (size > 0) {
                m6636a(size);
            }
            Http2Stream.this.cancelStreamIfNecessary$okhttp();
        }

        /* renamed from: getClosed$okhttp, reason: from getter */
        public final boolean getClosed() {
            return this.closed;
        }

        /* renamed from: getFinished$okhttp, reason: from getter */
        public final boolean getFinished() {
            return this.finished;
        }

        @NotNull
        public final Buffer getReadBuffer() {
            return this.readBuffer;
        }

        @NotNull
        public final Buffer getReceiveBuffer() {
            return this.receiveBuffer;
        }

        @Nullable
        public final Headers getTrailers() {
            return this.trailers;
        }

        /* JADX WARN: Code restructure failed: missing block: B:51:0x00d7, code lost:
        
            throw new java.io.IOException("stream closed");
         */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00b6 A[Catch: all -> 0x0022, DONT_GENERATE, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:6:0x0014, B:8:0x001a, B:29:0x00b6, B:57:0x00da, B:58:0x00e1, B:10:0x0025, B:12:0x002b, B:14:0x002f, B:16:0x0035, B:17:0x0046, B:19:0x004a, B:21:0x0056, B:23:0x0078, B:25:0x008d, B:43:0x00a6, B:46:0x00ac, B:50:0x00d0, B:51:0x00d7), top: B:5:0x0014, inners: #0 }] */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long read(@NotNull Buffer sink, long byteCount) {
            IOException iOException;
            long j;
            boolean z;
            long j2;
            Intrinsics.checkNotNullParameter(sink, "sink");
            long j3 = 0;
            if (byteCount < 0) {
                throw new IllegalArgumentException(ye0.m8294n(byteCount, "byteCount < 0: ").toString());
            }
            while (true) {
                Http2Stream http2Stream = Http2Stream.this;
                synchronized (http2Stream) {
                    boolean access$doReadTimeout = Http2Stream.access$doReadTimeout(http2Stream);
                    if (access$doReadTimeout) {
                        http2Stream.getReadTimeout().enter();
                    }
                    try {
                        if (http2Stream.getErrorCode$okhttp() != null && !this.finished) {
                            iOException = http2Stream.getErrorException();
                            if (iOException == null) {
                                ErrorCode errorCode$okhttp = http2Stream.getErrorCode$okhttp();
                                Intrinsics.checkNotNull(errorCode$okhttp);
                                iOException = new StreamResetException(errorCode$okhttp);
                            }
                        } else {
                            iOException = null;
                        }
                        if (this.closed) {
                            break;
                        }
                        if (this.readBuffer.size() > j3) {
                            Buffer buffer = this.readBuffer;
                            long read = buffer.read(sink, Math.min(byteCount, buffer.size()));
                            http2Stream.setReadBytesTotal$okhttp(http2Stream.getReadBytesTotal() + read);
                            long readBytesTotal = http2Stream.getReadBytesTotal() - http2Stream.getReadBytesAcknowledged();
                            if (iOException == null) {
                                j2 = read;
                                if (readBytesTotal >= http2Stream.getConnection().getOkHttpSettings().getInitialWindowSize() / 2) {
                                    http2Stream.getConnection().writeWindowUpdateLater$okhttp(http2Stream.getId(), readBytesTotal);
                                    http2Stream.setReadBytesAcknowledged$okhttp(http2Stream.getReadBytesTotal());
                                }
                            } else {
                                j2 = read;
                            }
                            j = j2;
                        } else if (!this.finished && iOException == null) {
                            http2Stream.waitForIo$okhttp();
                            z = true;
                            j = -1;
                        } else {
                            j = -1;
                        }
                        z = false;
                    } finally {
                        if (access$doReadTimeout) {
                            http2Stream.getReadTimeout().exitAndThrowIfTimedOut();
                        }
                    }
                }
                if (z) {
                    j3 = 0;
                } else {
                    if (j != -1) {
                        m6636a(j);
                        return j;
                    }
                    if (iOException == null) {
                        return -1L;
                    }
                    throw iOException;
                }
            }
        }

        public final void receive$okhttp(@NotNull BufferedSource source, long byteCount) {
            boolean z;
            boolean z2;
            boolean z3;
            long j;
            Intrinsics.checkNotNullParameter(source, "source");
            Http2Stream http2Stream = Http2Stream.this;
            if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            while (byteCount > 0) {
                synchronized (Http2Stream.this) {
                    z = this.finished;
                    z2 = false;
                    if (this.readBuffer.size() + byteCount > this.f24505a) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                }
                if (z3) {
                    source.skip(byteCount);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    source.skip(byteCount);
                    return;
                }
                long read = source.read(this.receiveBuffer, byteCount);
                if (read != -1) {
                    byteCount -= read;
                    Http2Stream http2Stream2 = Http2Stream.this;
                    synchronized (http2Stream2) {
                        try {
                            if (this.closed) {
                                j = this.receiveBuffer.size();
                                this.receiveBuffer.clear();
                            } else {
                                if (this.readBuffer.size() == 0) {
                                    z2 = true;
                                }
                                this.readBuffer.writeAll(this.receiveBuffer);
                                if (z2) {
                                    http2Stream2.notifyAll();
                                }
                                j = 0;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (j > 0) {
                        m6636a(j);
                    }
                } else {
                    throw new EOFException();
                }
            }
        }

        public final void setClosed$okhttp(boolean z) {
            this.closed = z;
        }

        public final void setFinished$okhttp(boolean z) {
            this.finished = z;
        }

        public final void setTrailers(@Nullable Headers headers) {
            this.trailers = headers;
        }

        @Override // okio.Source
        @NotNull
        /* renamed from: timeout */
        public Timeout getF24750a() {
            return Http2Stream.this.getReadTimeout();
        }
    }

    @Metadata(m5568d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\b\u001a\u00020\u0004H\u0014¨\u0006\t"}, m5569d2 = {"Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "Lokio/AsyncTimeout;", "(Lokhttp3/internal/http2/Http2Stream;)V", "exitAndThrowIfTimedOut", "", "newTimeoutException", "Ljava/io/IOException;", "cause", "timedOut", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public final class StreamTimeout extends AsyncTimeout {
        public StreamTimeout() {
        }

        public final void exitAndThrowIfTimedOut() {
            if (!exit()) {
            } else {
                throw newTimeoutException(null);
            }
        }

        @Override // okio.AsyncTimeout
        @NotNull
        public IOException newTimeoutException(@Nullable IOException cause) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (cause != null) {
                socketTimeoutException.initCause(cause);
            }
            return socketTimeoutException;
        }

        @Override // okio.AsyncTimeout
        public void timedOut() {
            ErrorCode errorCode = ErrorCode.CANCEL;
            Http2Stream http2Stream = Http2Stream.this;
            http2Stream.closeLater(errorCode);
            http2Stream.getConnection().sendDegradedPingLater$okhttp();
        }
    }

    public Http2Stream(int i, @NotNull Http2Connection connection, boolean z, boolean z2, @Nullable Headers headers) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.id = i;
        this.connection = connection;
        this.writeBytesMaximum = connection.getPeerSettings().getInitialWindowSize();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f24492g = arrayDeque;
        this.source = new FramingSource(connection.getOkHttpSettings().getInitialWindowSize(), z2);
        this.sink = new FramingSink(z);
        this.readTimeout = new StreamTimeout();
        this.writeTimeout = new StreamTimeout();
        if (headers != null) {
            if (!isLocallyInitiated()) {
                arrayDeque.add(headers);
                return;
            }
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (isLocallyInitiated()) {
        } else {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    public static final boolean access$doReadTimeout(Http2Stream http2Stream) {
        if (http2Stream.connection.getClient()) {
            FramingSink framingSink = http2Stream.sink;
            if (!framingSink.getClosed() && !framingSink.getFinished()) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ Headers takeHeaders$default(Http2Stream http2Stream, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return http2Stream.takeHeaders(z);
    }

    /* renamed from: a */
    public final boolean m6634a(ErrorCode errorCode, IOException iOException) {
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.getFinished() && this.sink.getFinished()) {
                return false;
            }
            this.errorCode = errorCode;
            this.errorException = iOException;
            notifyAll();
            this.connection.removeStream$okhttp(this.id);
            return true;
        }
    }

    public final void addBytesToWriteWindow(long delta) {
        this.writeBytesMaximum += delta;
        if (delta > 0) {
            notifyAll();
        }
    }

    public final void cancelStreamIfNecessary$okhttp() {
        boolean z;
        boolean isOpen;
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            try {
                if (this.source.getFinished() || !this.source.getClosed() || (!this.sink.getFinished() && !this.sink.getClosed())) {
                    z = false;
                    isOpen = isOpen();
                }
                z = true;
                isOpen = isOpen();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            close(ErrorCode.CANCEL, null);
        } else if (!isOpen) {
            this.connection.removeStream$okhttp(this.id);
        }
    }

    public final void checkOutNotClosed$okhttp() {
        FramingSink framingSink = this.sink;
        if (!framingSink.getClosed()) {
            if (!framingSink.getFinished()) {
                if (this.errorCode != null) {
                    IOException iOException = this.errorException;
                    if (iOException == null) {
                        ErrorCode errorCode = this.errorCode;
                        Intrinsics.checkNotNull(errorCode);
                        throw new StreamResetException(errorCode);
                    }
                    throw iOException;
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    public final void close(@NotNull ErrorCode rstStatusCode, @Nullable IOException errorException) {
        Intrinsics.checkNotNullParameter(rstStatusCode, "rstStatusCode");
        if (!m6634a(rstStatusCode, errorException)) {
            return;
        }
        this.connection.writeSynReset$okhttp(this.id, rstStatusCode);
    }

    public final void closeLater(@NotNull ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (!m6634a(errorCode, null)) {
            return;
        }
        this.connection.writeSynResetLater$okhttp(this.id, errorCode);
    }

    public final void enqueueTrailers(@NotNull Headers trailers) {
        Intrinsics.checkNotNullParameter(trailers, "trailers");
        synchronized (this) {
            if (!this.sink.getFinished()) {
                if (trailers.size() != 0) {
                    this.sink.setTrailers(trailers);
                } else {
                    throw new IllegalArgumentException("trailers.size() == 0");
                }
            } else {
                throw new IllegalStateException("already finished");
            }
        }
    }

    @NotNull
    public final Http2Connection getConnection() {
        return this.connection;
    }

    @Nullable
    public final synchronized ErrorCode getErrorCode$okhttp() {
        return this.errorCode;
    }

    @Nullable
    /* renamed from: getErrorException$okhttp, reason: from getter */
    public final IOException getErrorException() {
        return this.errorException;
    }

    public final int getId() {
        return this.id;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    @NotNull
    /* renamed from: getReadTimeout$okhttp, reason: from getter */
    public final StreamTimeout getReadTimeout() {
        return this.readTimeout;
    }

    @NotNull
    public final Sink getSink() {
        synchronized (this) {
            if (!this.f24493h && !isLocallyInitiated()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.sink;
    }

    @NotNull
    /* renamed from: getSink$okhttp, reason: from getter */
    public final FramingSink getSink() {
        return this.sink;
    }

    @NotNull
    public final Source getSource() {
        return this.source;
    }

    @NotNull
    /* renamed from: getSource$okhttp, reason: from getter */
    public final FramingSource getSource() {
        return this.source;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    @NotNull
    /* renamed from: getWriteTimeout$okhttp, reason: from getter */
    public final StreamTimeout getWriteTimeout() {
        return this.writeTimeout;
    }

    public final boolean isLocallyInitiated() {
        boolean z;
        if ((this.id & 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        if (this.connection.getClient() == z) {
            return true;
        }
        return false;
    }

    public final synchronized boolean isOpen() {
        try {
            if (this.errorCode != null) {
                return false;
            }
            if (!this.source.getFinished()) {
                if (this.source.getClosed()) {
                }
                return true;
            }
            if (this.sink.getFinished() || this.sink.getClosed()) {
                if (this.f24493h) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @NotNull
    public final Timeout readTimeout() {
        return this.readTimeout;
    }

    public final void receiveData(@NotNull BufferedSource source, int length) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        this.source.receive$okhttp(source, length);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005c A[Catch: all -> 0x0051, TryCatch #0 {all -> 0x0051, blocks: (B:10:0x0035, B:12:0x003a, B:14:0x0042, B:17:0x004b, B:19:0x005c, B:20:0x0061, B:27:0x0053), top: B:9:0x0035 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void receiveHeaders(@NotNull Headers headers, boolean inFinished) {
        boolean isOpen;
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            try {
                if (this.f24493h && headers.get(Header.RESPONSE_STATUS_UTF8) == null && headers.get(Header.TARGET_METHOD_UTF8) == null) {
                    this.source.setTrailers(headers);
                    if (inFinished) {
                        this.source.setFinished$okhttp(true);
                    }
                    isOpen = isOpen();
                    notifyAll();
                }
                this.f24493h = true;
                this.f24492g.add(headers);
                if (inFinished) {
                }
                isOpen = isOpen();
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!isOpen) {
            this.connection.removeStream$okhttp(this.id);
        }
    }

    public final synchronized void receiveRstStream(@NotNull ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    public final void setErrorCode$okhttp(@Nullable ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public final void setErrorException$okhttp(@Nullable IOException iOException) {
        this.errorException = iOException;
    }

    public final void setReadBytesAcknowledged$okhttp(long j) {
        this.readBytesAcknowledged = j;
    }

    public final void setReadBytesTotal$okhttp(long j) {
        this.readBytesTotal = j;
    }

    public final void setWriteBytesMaximum$okhttp(long j) {
        this.writeBytesMaximum = j;
    }

    public final void setWriteBytesTotal$okhttp(long j) {
        this.writeBytesTotal = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002e  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized Headers takeHeaders(boolean callerIsIdle) {
        Object removeFirst;
        boolean z;
        while (this.f24492g.isEmpty() && this.errorCode == null) {
            boolean z2 = true;
            if (!callerIsIdle) {
                if (this.connection.getClient()) {
                    FramingSink framingSink = this.sink;
                    if (!framingSink.getClosed() && !framingSink.getFinished()) {
                        z = false;
                        if (z) {
                            z2 = false;
                        }
                    }
                }
                z = true;
                if (z) {
                }
            }
            if (z2) {
                this.readTimeout.enter();
            }
            try {
                waitForIo$okhttp();
                if (z2) {
                    this.readTimeout.exitAndThrowIfTimedOut();
                }
            } catch (Throwable th) {
                if (z2) {
                    this.readTimeout.exitAndThrowIfTimedOut();
                }
                throw th;
            }
        }
        if (!this.f24492g.isEmpty()) {
            removeFirst = this.f24492g.removeFirst();
            Intrinsics.checkNotNullExpressionValue(removeFirst, "headersQueue.removeFirst()");
        } else {
            IOException iOException = this.errorException;
            if (iOException == null) {
                ErrorCode errorCode = this.errorCode;
                Intrinsics.checkNotNull(errorCode);
                throw new StreamResetException(errorCode);
            }
            throw iOException;
        }
        return (Headers) removeFirst;
    }

    @NotNull
    public final synchronized Headers trailers() {
        Headers trailers;
        if (this.source.getFinished() && this.source.getReceiveBuffer().exhausted() && this.source.getReadBuffer().exhausted()) {
            trailers = this.source.getTrailers();
            if (trailers == null) {
                trailers = _UtilJvmKt.EMPTY_HEADERS;
            }
        } else {
            if (this.errorCode != null) {
                IOException iOException = this.errorException;
                if (iOException == null) {
                    ErrorCode errorCode = this.errorCode;
                    Intrinsics.checkNotNull(errorCode);
                    throw new StreamResetException(errorCode);
                }
                throw iOException;
            }
            throw new IllegalStateException("too early; can't read the trailers yet");
        }
        return trailers;
    }

    public final void waitForIo$okhttp() {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final void writeHeaders(@NotNull List<Header> responseHeaders, boolean outFinished, boolean flushHeaders) {
        boolean z;
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            z = true;
            this.f24493h = true;
            if (outFinished) {
                this.sink.setFinished(true);
                notifyAll();
            }
        }
        if (!flushHeaders) {
            synchronized (this.connection) {
                if (this.connection.getWriteBytesTotal() < this.connection.getWriteBytesMaximum()) {
                    z = false;
                }
            }
            flushHeaders = z;
        }
        this.connection.writeHeaders$okhttp(this.id, outFinished, responseHeaders);
        if (flushHeaders) {
            this.connection.flush();
        }
    }

    @NotNull
    public final Timeout writeTimeout() {
        return this.writeTimeout;
    }

    @Metadata(m5568d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u000eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018¨\u0006%"}, m5569d2 = {"Lokhttp3/internal/http2/Http2Stream$FramingSink;", "Lokio/Sink;", "", "finished", "<init>", "(Lokhttp3/internal/http2/Http2Stream;Z)V", "Lokio/Buffer;", FirebaseAnalytics.Param.SOURCE, "", "byteCount", "", "write", "(Lokio/Buffer;J)V", "flush", "()V", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "close", "a", "Z", "getFinished", "()Z", "setFinished", "(Z)V", "Lokhttp3/Headers;", "c", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "trailers", "d", "getClosed", "setClosed", "closed", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public final class FramingSink implements Sink {

        /* renamed from: a, reason: from kotlin metadata */
        public boolean finished;

        /* renamed from: b */
        public final Buffer f24501b;

        /* renamed from: c, reason: from kotlin metadata */
        public Headers trailers;

        /* renamed from: d, reason: from kotlin metadata */
        public boolean closed;

        public FramingSink(boolean z) {
            this.finished = z;
            this.f24501b = new Buffer();
        }

        /* renamed from: a */
        public final void m6635a(boolean z) {
            long min;
            boolean z2;
            boolean z3;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                http2Stream.getWriteTimeout().enter();
                while (http2Stream.getWriteBytesTotal() >= http2Stream.getWriteBytesMaximum() && !this.finished && !this.closed && http2Stream.getErrorCode$okhttp() == null) {
                    try {
                        http2Stream.waitForIo$okhttp();
                    } finally {
                        http2Stream.getWriteTimeout().exitAndThrowIfTimedOut();
                    }
                }
                http2Stream.getWriteTimeout().exitAndThrowIfTimedOut();
                http2Stream.checkOutNotClosed$okhttp();
                min = Math.min(http2Stream.getWriteBytesMaximum() - http2Stream.getWriteBytesTotal(), this.f24501b.size());
                http2Stream.setWriteBytesTotal$okhttp(http2Stream.getWriteBytesTotal() + min);
                if (z && min == this.f24501b.size()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z2;
            }
            Http2Stream.this.getWriteTimeout().enter();
            try {
                Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), z3, this.f24501b, min);
            } finally {
                http2Stream = Http2Stream.this;
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            boolean z;
            boolean z2;
            Http2Stream http2Stream = Http2Stream.this;
            if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            Http2Stream http2Stream2 = Http2Stream.this;
            synchronized (http2Stream2) {
                if (this.closed) {
                    return;
                }
                if (http2Stream2.getErrorCode$okhttp() == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (!Http2Stream.this.getSink().finished) {
                    if (this.f24501b.size() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (this.trailers != null) {
                        while (this.f24501b.size() > 0) {
                            m6635a(false);
                        }
                        Http2Connection connection = Http2Stream.this.getConnection();
                        int id = Http2Stream.this.getId();
                        Headers headers = this.trailers;
                        Intrinsics.checkNotNull(headers);
                        connection.writeHeaders$okhttp(id, z, _UtilJvmKt.toHeaderList(headers));
                    } else if (z2) {
                        while (this.f24501b.size() > 0) {
                            m6635a(true);
                        }
                    } else if (z) {
                        Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), true, null, 0L);
                    }
                }
                Http2Stream http2Stream3 = Http2Stream.this;
                synchronized (http2Stream3) {
                    this.closed = true;
                    http2Stream3.notifyAll();
                }
                Http2Stream.this.getConnection().flush();
                Http2Stream.this.cancelStreamIfNecessary$okhttp();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            Http2Stream http2Stream = Http2Stream.this;
            if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            Http2Stream http2Stream2 = Http2Stream.this;
            synchronized (http2Stream2) {
                http2Stream2.checkOutNotClosed$okhttp();
            }
            while (this.f24501b.size() > 0) {
                m6635a(false);
                Http2Stream.this.getConnection().flush();
            }
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final boolean getFinished() {
            return this.finished;
        }

        @Nullable
        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        public final void setFinished(boolean z) {
            this.finished = z;
        }

        public final void setTrailers(@Nullable Headers headers) {
            this.trailers = headers;
        }

        @Override // okio.Sink
        @NotNull
        /* renamed from: timeout */
        public Timeout getF24748a() {
            return Http2Stream.this.getWriteTimeout();
        }

        @Override // okio.Sink
        public void write(@NotNull Buffer source, long byteCount) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (_UtilJvmKt.assertionsEnabled) {
                Http2Stream http2Stream = Http2Stream.this;
                if (Thread.holdsLock(http2Stream)) {
                    throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
                }
            }
            Buffer buffer = this.f24501b;
            buffer.write(source, byteCount);
            while (buffer.size() >= 16384) {
                m6635a(false);
            }
        }

        public /* synthetic */ FramingSink(Http2Stream http2Stream, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }
    }
}
