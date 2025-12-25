package okhttp3.internal.http2;

import com.google.android.exoplayer2.upstream.DataSchemeDataSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import p000.r82;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u00122\u00020\u0001:\u0003\u0012\u0013\u0014B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, m5569d2 = {"Lokhttp3/internal/http2/Http2Reader;", "Ljava/io/Closeable;", "Lokio/BufferedSource;", FirebaseAnalytics.Param.SOURCE, "", "client", "<init>", "(Lokio/BufferedSource;Z)V", "Lokhttp3/internal/http2/Http2Reader$Handler;", "handler", "", "readConnectionPreface", "(Lokhttp3/internal/http2/Http2Reader$Handler;)V", "requireSettings", "nextFrame", "(ZLokhttp3/internal/http2/Http2Reader$Handler;)Z", "close", "()V", "Companion", "ContinuationSource", "Handler", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Http2Reader implements Closeable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e */
    public static final Logger f24475e;

    /* renamed from: a */
    public final BufferedSource f24476a;

    /* renamed from: b */
    public final boolean f24477b;

    /* renamed from: c */
    public final ContinuationSource f24478c;

    /* renamed from: d */
    public final Hpack.Reader f24479d;

    @Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001J%\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m5569d2 = {"Lokhttp3/internal/http2/Http2Reader$Companion;", "", "", "length", "flags", "padding", "lengthWithoutPadding", "(III)I", "Ljava/util/logging/Logger;", "logger", "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @NotNull
        public final Logger getLogger() {
            return Http2Reader.f24475e;
        }

        public final int lengthWithoutPadding(int length, int flags, int padding) {
            if ((flags & 8) != 0) {
                length--;
            }
            if (padding <= length) {
                return length - padding;
            }
            throw new IOException(ye0.m8293m(padding, "PROTOCOL_ERROR padding ", " > remaining length ", length));
        }
    }

    @Metadata(m5568d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010!\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\"\u0010%\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\"\u0010)\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0014\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018¨\u0006*"}, m5569d2 = {"Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "Lokio/Source;", "Lokio/BufferedSource;", FirebaseAnalytics.Param.SOURCE, "<init>", "(Lokio/BufferedSource;)V", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "", "close", "()V", "", "b", "I", "getLength", "()I", "setLength", "(I)V", "length", "c", "getFlags", "setFlags", "flags", "d", "getStreamId", "setStreamId", "streamId", "e", "getLeft", "setLeft", "left", "f", "getPadding", "setPadding", "padding", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class ContinuationSource implements Source {

        /* renamed from: a */
        public final BufferedSource f24480a;

        /* renamed from: b, reason: from kotlin metadata */
        public int length;

        /* renamed from: c, reason: from kotlin metadata */
        public int flags;

        /* renamed from: d, reason: from kotlin metadata */
        public int streamId;

        /* renamed from: e, reason: from kotlin metadata */
        public int left;

        /* renamed from: f, reason: from kotlin metadata */
        public int padding;

        public ContinuationSource(@NotNull BufferedSource source) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.f24480a = source;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final int getStreamId() {
            return this.streamId;
        }

        @Override // okio.Source
        public long read(@NotNull Buffer sink, long byteCount) {
            int i;
            int readInt;
            Intrinsics.checkNotNullParameter(sink, "sink");
            do {
                int i2 = this.left;
                BufferedSource bufferedSource = this.f24480a;
                if (i2 == 0) {
                    bufferedSource.skip(this.padding);
                    this.padding = 0;
                    if ((this.flags & 4) != 0) {
                        return -1L;
                    }
                    i = this.streamId;
                    int readMedium = _UtilCommonKt.readMedium(bufferedSource);
                    this.left = readMedium;
                    this.length = readMedium;
                    int and = _UtilCommonKt.and(bufferedSource.readByte(), 255);
                    this.flags = _UtilCommonKt.and(bufferedSource.readByte(), 255);
                    Companion companion = Http2Reader.INSTANCE;
                    if (companion.getLogger().isLoggable(Level.FINE)) {
                        companion.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, and, this.flags));
                    }
                    readInt = bufferedSource.readInt() & Integer.MAX_VALUE;
                    this.streamId = readInt;
                    if (and != 9) {
                        throw new IOException(and + " != TYPE_CONTINUATION");
                    }
                } else {
                    long read = bufferedSource.read(sink, Math.min(byteCount, i2));
                    if (read == -1) {
                        return -1L;
                    }
                    this.left -= (int) read;
                    return read;
                }
            } while (readInt == i);
            throw new IOException("TYPE_CONTINUATION streamId changed");
        }

        public final void setFlags(int i) {
            this.flags = i;
        }

        public final void setLeft(int i) {
            this.left = i;
        }

        public final void setLength(int i) {
            this.length = i;
        }

        public final void setPadding(int i) {
            this.padding = i;
        }

        public final void setStreamId(int i) {
            this.streamId = i;
        }

        @Override // okio.Source
        @NotNull
        /* renamed from: timeout */
        public Timeout getF24243a() {
            return this.f24480a.getF24243a();
        }
    }

    @Metadata(m5568d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J8\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH&J(\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H&J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH&J.\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH&J \u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H&J(\u0010#\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0011H&J&\u0010'\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH&J\u0018\u0010*\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0018\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u00112\u0006\u0010+\u001a\u00020-H&J\u0018\u0010.\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u000eH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00060À\u0006\u0001"}, m5569d2 = {"Lokhttp3/internal/http2/Http2Reader$Handler;", "", "ackSettings", "", "alternateService", "streamId", "", "origin", "", "protocol", "Lokio/ByteString;", "host", "port", "maxAge", "", DataSchemeDataSource.SCHEME_DATA, "inFinished", "", FirebaseAnalytics.Param.SOURCE, "Lokio/BufferedSource;", "length", "goAway", "lastGoodStreamId", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "debugData", "headers", "associatedStreamId", "headerBlock", "", "Lokhttp3/internal/http2/Header;", "ping", "ack", "payload1", "payload2", "priority", "streamDependency", "weight", "exclusive", "pushPromise", "promisedStreamId", "requestHeaders", "rstStream", "settings", "clearPrevious", "Lokhttp3/internal/http2/Settings;", "windowUpdate", "windowSizeIncrement", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public interface Handler {
        void ackSettings();

        void alternateService(int streamId, @NotNull String origin, @NotNull ByteString protocol, @NotNull String host, int port, long maxAge);

        void data(boolean inFinished, int streamId, @NotNull BufferedSource source, int length);

        void goAway(int lastGoodStreamId, @NotNull ErrorCode errorCode, @NotNull ByteString debugData);

        void headers(boolean inFinished, int streamId, int associatedStreamId, @NotNull List<Header> headerBlock);

        void ping(boolean ack, int payload1, int payload2);

        void priority(int streamId, int streamDependency, int weight, boolean exclusive);

        void pushPromise(int streamId, int promisedStreamId, @NotNull List<Header> requestHeaders);

        void rstStream(int streamId, @NotNull ErrorCode errorCode);

        void settings(boolean clearPrevious, @NotNull Settings settings);

        void windowUpdate(int streamId, long windowSizeIncrement);
    }

    static {
        Logger logger = Logger.getLogger(Http2.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(Http2::class.java.name)");
        f24475e = logger;
    }

    public Http2Reader(@NotNull BufferedSource source, boolean z) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f24476a = source;
        this.f24477b = z;
        ContinuationSource continuationSource = new ContinuationSource(source);
        this.f24478c = continuationSource;
        this.f24479d = new Hpack.Reader(continuationSource, 4096, 0, 4, null);
    }

    /* renamed from: a */
    public final List m6632a(int i, int i2, int i3, int i4) {
        ContinuationSource continuationSource = this.f24478c;
        continuationSource.setLeft(i);
        continuationSource.setLength(continuationSource.getLeft());
        continuationSource.setPadding(i2);
        continuationSource.setFlags(i3);
        continuationSource.setStreamId(i4);
        Hpack.Reader reader = this.f24479d;
        reader.readHeaders();
        return reader.getAndResetHeaderList();
    }

    /* renamed from: b */
    public final void m6633b(Handler handler, int i) {
        boolean z;
        BufferedSource bufferedSource = this.f24476a;
        int readInt = bufferedSource.readInt();
        if ((Integer.MIN_VALUE & readInt) != 0) {
            z = true;
        } else {
            z = false;
        }
        handler.priority(i, readInt & Integer.MAX_VALUE, _UtilCommonKt.and(bufferedSource.readByte(), 255) + 1, z);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f24476a.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x0201, code lost:
    
        throw new java.io.IOException(p000.ye0.m8291k(r11, "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean nextFrame(boolean requireSettings, @NotNull Handler handler) {
        int i;
        Logger logger;
        int i2;
        boolean z;
        int i3;
        int i4;
        BufferedSource bufferedSource = this.f24476a;
        Intrinsics.checkNotNullParameter(handler, "handler");
        try {
            bufferedSource.require(9L);
            int readMedium = _UtilCommonKt.readMedium(bufferedSource);
            if (readMedium <= 16384) {
                int and = _UtilCommonKt.and(bufferedSource.readByte(), 255);
                int and2 = _UtilCommonKt.and(bufferedSource.readByte(), 255);
                int readInt = bufferedSource.readInt() & Integer.MAX_VALUE;
                Logger logger2 = f24475e;
                if (and == 8 || !logger2.isLoggable(Level.FINE)) {
                    i = 8;
                    logger = logger2;
                    i2 = readInt;
                } else {
                    i3 = readInt;
                    i = 8;
                    logger = logger2;
                    i2 = readInt;
                    logger.fine(Http2.INSTANCE.frameLog(true, i3, readMedium, and, and2));
                }
                if (requireSettings && and != 4) {
                    throw new IOException("Expected a SETTINGS frame but was " + Http2.INSTANCE.formattedType$okhttp(and));
                }
                switch (and) {
                    case 0:
                        int i5 = i2;
                        if (i5 == 0) {
                            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
                        }
                        boolean z2 = (and2 & 1) != 0;
                        if ((and2 & 32) == 0) {
                            int and3 = (and2 & 8) != 0 ? _UtilCommonKt.and(bufferedSource.readByte(), 255) : 0;
                            handler.data(z2, i5, bufferedSource, INSTANCE.lengthWithoutPadding(readMedium, and2, and3));
                            bufferedSource.skip(and3);
                            return true;
                        }
                        throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
                    case 1:
                        int i6 = i2;
                        if (i6 != 0) {
                            boolean z3 = (and2 & 1) != 0;
                            int and4 = (and2 & 8) != 0 ? _UtilCommonKt.and(bufferedSource.readByte(), 255) : 0;
                            if ((and2 & 32) != 0) {
                                m6633b(handler, i6);
                                readMedium -= 5;
                            }
                            handler.headers(z3, i6, -1, m6632a(INSTANCE.lengthWithoutPadding(readMedium, and2, and4), and4, and2, i6));
                            return true;
                        }
                        throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
                    case 2:
                        int i7 = i2;
                        if (readMedium != 5) {
                            throw new IOException(ye0.m8292l(readMedium, "TYPE_PRIORITY length: ", " != 5"));
                        }
                        if (i7 != 0) {
                            m6633b(handler, i7);
                            return true;
                        }
                        throw new IOException("TYPE_PRIORITY streamId == 0");
                    case 3:
                        int i8 = i2;
                        if (readMedium != 4) {
                            throw new IOException(ye0.m8292l(readMedium, "TYPE_RST_STREAM length: ", " != 4"));
                        }
                        if (i8 != 0) {
                            int readInt2 = bufferedSource.readInt();
                            ErrorCode fromHttp2 = ErrorCode.INSTANCE.fromHttp2(readInt2);
                            if (fromHttp2 != null) {
                                handler.rstStream(i8, fromHttp2);
                                return true;
                            }
                            throw new IOException(ye0.m8291k(readInt2, "TYPE_RST_STREAM unexpected error code: "));
                        }
                        throw new IOException("TYPE_RST_STREAM streamId == 0");
                    case 4:
                        if (i2 != 0) {
                            throw new IOException("TYPE_SETTINGS streamId != 0");
                        }
                        if ((and2 & 1) != 0) {
                            if (readMedium == 0) {
                                handler.ackSettings();
                                return true;
                            }
                            throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
                        }
                        if (readMedium % 6 == 0) {
                            Settings settings = new Settings();
                            IntProgression step = r82.step(r82.until(0, readMedium), 6);
                            int first = step.getFirst();
                            int last = step.getLast();
                            int step2 = step.getStep();
                            if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                                while (true) {
                                    int and5 = _UtilCommonKt.and(bufferedSource.readShort(), 65535);
                                    int readInt3 = bufferedSource.readInt();
                                    if (and5 != 2) {
                                        if (and5 == 3) {
                                            and5 = 4;
                                        } else if (and5 != 4) {
                                            if (and5 == 5 && (readInt3 < 16384 || readInt3 > 16777215)) {
                                            }
                                        } else {
                                            if (readInt3 < 0) {
                                                throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                                            }
                                            and5 = 7;
                                        }
                                    } else if (readInt3 != 0 && readInt3 != 1) {
                                        throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                                    }
                                    settings.set(and5, readInt3);
                                    if (first != last) {
                                        first += step2;
                                    }
                                }
                            }
                            handler.settings(false, settings);
                            return true;
                        }
                        throw new IOException(ye0.m8291k(readMedium, "TYPE_SETTINGS length % 6 != 0: "));
                    case 5:
                        int i9 = i2;
                        if (i9 != 0) {
                            int and6 = (and2 & 8) != 0 ? _UtilCommonKt.and(bufferedSource.readByte(), 255) : 0;
                            handler.pushPromise(i9, bufferedSource.readInt() & Integer.MAX_VALUE, m6632a(INSTANCE.lengthWithoutPadding(readMedium - 4, and2, and6), and6, and2, i9));
                            return true;
                        }
                        throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
                    case 6:
                        z = true;
                        int i10 = i2;
                        if (readMedium != i) {
                            throw new IOException(ye0.m8291k(readMedium, "TYPE_PING length != 8: "));
                        }
                        if (i10 == 0) {
                            handler.ping((and2 & 1) != 0, bufferedSource.readInt(), bufferedSource.readInt());
                            break;
                        } else {
                            throw new IOException("TYPE_PING streamId != 0");
                        }
                    case 7:
                        z = true;
                        int i11 = i2;
                        if (readMedium < i) {
                            throw new IOException(ye0.m8291k(readMedium, "TYPE_GOAWAY length < 8: "));
                        }
                        if (i11 == 0) {
                            int readInt4 = bufferedSource.readInt();
                            int readInt5 = bufferedSource.readInt();
                            int i12 = readMedium - i;
                            ErrorCode fromHttp22 = ErrorCode.INSTANCE.fromHttp2(readInt5);
                            if (fromHttp22 != null) {
                                ByteString byteString = ByteString.EMPTY;
                                if (i12 > 0) {
                                    byteString = bufferedSource.readByteString(i12);
                                }
                                handler.goAway(readInt4, fromHttp22, byteString);
                                break;
                            } else {
                                throw new IOException(ye0.m8291k(readInt5, "TYPE_GOAWAY unexpected error code: "));
                            }
                        } else {
                            throw new IOException("TYPE_GOAWAY streamId != 0");
                        }
                    case 8:
                        try {
                            if (readMedium != 4) {
                                throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + readMedium);
                            }
                            try {
                                long and7 = _UtilCommonKt.and(bufferedSource.readInt(), 2147483647L);
                                if (and7 != 0) {
                                    if (logger.isLoggable(Level.FINE)) {
                                        i4 = i2;
                                        z = true;
                                        logger.fine(Http2.INSTANCE.frameLogWindowUpdate(true, i4, readMedium, and7));
                                    } else {
                                        z = true;
                                        i4 = i2;
                                    }
                                    handler.windowUpdate(i4, and7);
                                    break;
                                } else {
                                    throw new IOException("windowSizeIncrement was 0");
                                }
                            } catch (Exception e) {
                                e = e;
                                i3 = i2;
                                logger.fine(Http2.INSTANCE.frameLog(true, i3, readMedium, 8, and2));
                                throw e;
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                    default:
                        bufferedSource.skip(readMedium);
                        return true;
                }
                return z;
            }
            throw new IOException(ye0.m8291k(readMedium, "FRAME_SIZE_ERROR: "));
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void readConnectionPreface(@NotNull Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (this.f24477b) {
            if (!nextFrame(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        ByteString byteString = Http2.CONNECTION_PREFACE;
        ByteString readByteString = this.f24476a.readByteString(byteString.size());
        Level level = Level.FINE;
        Logger logger = f24475e;
        if (logger.isLoggable(level)) {
            logger.fine(_UtilJvmKt.format("<< CONNECTION " + readByteString.hex(), new Object[0]));
        }
        if (Intrinsics.areEqual(byteString, readByteString)) {
            return;
        }
        throw new IOException("Expected a connection header but was " + readByteString.utf8());
    }
}
