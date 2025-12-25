package okhttp3.internal.http2;

import com.google.android.exoplayer2.upstream.DataSchemeDataSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001EB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\nJ\u001d\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u000f¢\u0006\u0004\b\u001c\u0010\u001dJ/\u0010\"\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u000f¢\u0006\u0004\b\"\u0010#J/\u0010&\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\b\u0010%\u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u000f¢\u0006\u0004\b&\u0010'J\u0015\u0010(\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u000b¢\u0006\u0004\b(\u0010\u000eJ%\u0010,\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000f¢\u0006\u0004\b,\u0010-J%\u00101\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102J\u001d\u00105\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J-\u00109\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\bH\u0016¢\u0006\u0004\b;\u0010\nJ+\u0010=\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b=\u0010>R\u0017\u0010D\u001a\u00020?8\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C¨\u0006F"}, m5569d2 = {"Lokhttp3/internal/http2/Http2Writer;", "Ljava/io/Closeable;", "Lokio/BufferedSink;", "sink", "", "client", "<init>", "(Lokio/BufferedSink;Z)V", "", "connectionPreface", "()V", "Lokhttp3/internal/http2/Settings;", "peerSettings", "applyAndAckSettings", "(Lokhttp3/internal/http2/Settings;)V", "", "streamId", "promisedStreamId", "", "Lokhttp3/internal/http2/Header;", "requestHeaders", "pushPromise", "(IILjava/util/List;)V", "flush", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "rstStream", "(ILokhttp3/internal/http2/ErrorCode;)V", "maxDataLength", "()I", "outFinished", "Lokio/Buffer;", FirebaseAnalytics.Param.SOURCE, "byteCount", DataSchemeDataSource.SCHEME_DATA, "(ZILokio/Buffer;I)V", "flags", "buffer", "dataFrame", "(IILokio/Buffer;I)V", "settings", "ack", "payload1", "payload2", "ping", "(ZII)V", "lastGoodStreamId", "", "debugData", "goAway", "(ILokhttp3/internal/http2/ErrorCode;[B)V", "", "windowSizeIncrement", "windowUpdate", "(IJ)V", "length", "type", "frameHeader", "(IIII)V", "close", "headerBlock", "headers", "(ZILjava/util/List;)V", "Lokhttp3/internal/http2/Hpack$Writer;", "f", "Lokhttp3/internal/http2/Hpack$Writer;", "getHpackWriter", "()Lokhttp3/internal/http2/Hpack$Writer;", "hpackWriter", "Companion", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Http2Writer implements Closeable {

    /* renamed from: g */
    public static final Logger f24513g = Logger.getLogger(Http2.class.getName());

    /* renamed from: a */
    public final BufferedSink f24514a;

    /* renamed from: b */
    public final boolean f24515b;

    /* renamed from: c */
    public final Buffer f24516c;

    /* renamed from: d */
    public int f24517d;

    /* renamed from: e */
    public boolean f24518e;

    /* renamed from: f, reason: from kotlin metadata */
    public final Hpack.Writer hpackWriter;

    public Http2Writer(@NotNull BufferedSink sink, boolean z) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.f24514a = sink;
        this.f24515b = z;
        Buffer buffer = new Buffer();
        this.f24516c = buffer;
        this.f24517d = 16384;
        this.hpackWriter = new Hpack.Writer(0, false, buffer, 3, null);
    }

    /* renamed from: a */
    public final void m6637a(int i, long j) {
        int i2;
        while (j > 0) {
            long min = Math.min(this.f24517d, j);
            j -= min;
            int i3 = (int) min;
            if (j == 0) {
                i2 = 4;
            } else {
                i2 = 0;
            }
            frameHeader(i, i3, 9, i2);
            this.f24514a.write(this.f24516c, min);
        }
    }

    public final synchronized void applyAndAckSettings(@NotNull Settings peerSettings) {
        try {
            Intrinsics.checkNotNullParameter(peerSettings, "peerSettings");
            if (!this.f24518e) {
                this.f24517d = peerSettings.getMaxFrameSize(this.f24517d);
                if (peerSettings.getHeaderTableSize() != -1) {
                    this.hpackWriter.resizeHeaderTable(peerSettings.getHeaderTableSize());
                }
                frameHeader(0, 0, 4, 1);
                this.f24514a.flush();
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f24518e = true;
        this.f24514a.close();
    }

    public final synchronized void connectionPreface() {
        try {
            if (!this.f24518e) {
                if (!this.f24515b) {
                    return;
                }
                Logger logger = f24513g;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(_UtilJvmKt.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.hex(), new Object[0]));
                }
                this.f24514a.write(Http2.CONNECTION_PREFACE);
                this.f24514a.flush();
                return;
            }
            throw new IOException("closed");
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void data(boolean outFinished, int streamId, @Nullable Buffer source, int byteCount) {
        if (!this.f24518e) {
            dataFrame(streamId, outFinished ? 1 : 0, source, byteCount);
        } else {
            throw new IOException("closed");
        }
    }

    public final void dataFrame(int streamId, int flags, @Nullable Buffer buffer, int byteCount) {
        frameHeader(streamId, byteCount, 0, flags);
        if (byteCount > 0) {
            Intrinsics.checkNotNull(buffer);
            this.f24514a.write(buffer, byteCount);
        }
    }

    public final synchronized void flush() {
        if (!this.f24518e) {
            this.f24514a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final void frameHeader(int streamId, int length, int type, int flags) {
        if (type != 8) {
            Level level = Level.FINE;
            Logger logger = f24513g;
            if (logger.isLoggable(level)) {
                logger.fine(Http2.INSTANCE.frameLog(false, streamId, length, type, flags));
            }
        }
        if (length <= this.f24517d) {
            if ((Integer.MIN_VALUE & streamId) == 0) {
                BufferedSink bufferedSink = this.f24514a;
                _UtilCommonKt.writeMedium(bufferedSink, length);
                bufferedSink.writeByte(type & 255);
                bufferedSink.writeByte(flags & 255);
                bufferedSink.writeInt(streamId & Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException(ye0.m8291k(streamId, "reserved bit set: ").toString());
        }
        throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f24517d + ": " + length).toString());
    }

    @NotNull
    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final synchronized void goAway(int lastGoodStreamId, @NotNull ErrorCode errorCode, @NotNull byte[] debugData) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullParameter(debugData, "debugData");
        if (!this.f24518e) {
            if (errorCode.getHttpCode() != -1) {
                frameHeader(0, debugData.length + 8, 7, 0);
                this.f24514a.writeInt(lastGoodStreamId);
                this.f24514a.writeInt(errorCode.getHttpCode());
                if (debugData.length != 0) {
                    this.f24514a.write(debugData);
                }
                this.f24514a.flush();
            } else {
                throw new IllegalArgumentException("errorCode.httpCode == -1");
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void headers(boolean outFinished, int streamId, @NotNull List<Header> headerBlock) {
        int i;
        Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
        if (!this.f24518e) {
            this.hpackWriter.writeHeaders(headerBlock);
            long size = this.f24516c.size();
            long min = Math.min(this.f24517d, size);
            if (size == min) {
                i = 4;
            } else {
                i = 0;
            }
            if (outFinished) {
                i |= 1;
            }
            frameHeader(streamId, (int) min, 1, i);
            this.f24514a.write(this.f24516c, min);
            if (size > min) {
                m6637a(streamId, size - min);
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: maxDataLength, reason: from getter */
    public final int getF24517d() {
        return this.f24517d;
    }

    public final synchronized void ping(boolean ack, int payload1, int payload2) {
        if (!this.f24518e) {
            frameHeader(0, 8, 6, ack ? 1 : 0);
            this.f24514a.writeInt(payload1);
            this.f24514a.writeInt(payload2);
            this.f24514a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void pushPromise(int streamId, int promisedStreamId, @NotNull List<Header> requestHeaders) {
        int i;
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        if (!this.f24518e) {
            this.hpackWriter.writeHeaders(requestHeaders);
            long size = this.f24516c.size();
            int min = (int) Math.min(this.f24517d - 4, size);
            int i2 = min + 4;
            long j = min;
            if (size == j) {
                i = 4;
            } else {
                i = 0;
            }
            frameHeader(streamId, i2, 5, i);
            this.f24514a.writeInt(promisedStreamId & Integer.MAX_VALUE);
            this.f24514a.write(this.f24516c, j);
            if (size > j) {
                m6637a(streamId, size - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void rstStream(int streamId, @NotNull ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (!this.f24518e) {
            if (errorCode.getHttpCode() != -1) {
                frameHeader(streamId, 4, 3, 0);
                this.f24514a.writeInt(errorCode.getHttpCode());
                this.f24514a.flush();
            } else {
                throw new IllegalArgumentException("Failed requirement.");
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void settings(@NotNull Settings settings) {
        int i;
        try {
            Intrinsics.checkNotNullParameter(settings, "settings");
            if (!this.f24518e) {
                frameHeader(0, settings.size() * 6, 4, 0);
                for (int i2 = 0; i2 < 10; i2++) {
                    if (settings.isSet(i2)) {
                        if (i2 != 4) {
                            if (i2 != 7) {
                                i = i2;
                            } else {
                                i = 4;
                            }
                        } else {
                            i = 3;
                        }
                        this.f24514a.writeShort(i);
                        this.f24514a.writeInt(settings.get(i2));
                    }
                }
                this.f24514a.flush();
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void windowUpdate(int streamId, long windowSizeIncrement) {
        try {
            if (!this.f24518e) {
                if (windowSizeIncrement != 0 && windowSizeIncrement <= 2147483647L) {
                    Logger logger = f24513g;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(Http2.INSTANCE.frameLogWindowUpdate(false, streamId, 4, windowSizeIncrement));
                    }
                    frameHeader(streamId, 4, 8, 0);
                    this.f24514a.writeInt((int) windowSizeIncrement);
                    this.f24514a.flush();
                } else {
                    throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + windowSizeIncrement).toString());
                }
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
