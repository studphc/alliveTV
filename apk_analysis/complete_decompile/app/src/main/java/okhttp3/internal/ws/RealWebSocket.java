package okhttp3.internal.ws;

import com.google.android.exoplayer2.upstream.DataSchemeDataSource;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hisona.allive.HttpRequest;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.internal.ws.WebSocketReader;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1167eq;
import p000.C1829tb;
import p000.c92;
import p000.e11;
import p000.ro2;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0005\\[]^_BA\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010#\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0004\b!\u0010\"J\u001d\u0010(\u001a\u00020\u00162\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\u0016¢\u0006\u0004\b*\u0010\u0018J\r\u0010,\u001a\u00020+¢\u0006\u0004\b,\u0010-J\u001d\u00101\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u000b2\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\u0016¢\u0006\u0004\b3\u0010\u0018J\r\u00105\u001a\u000204¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u000204¢\u0006\u0004\b7\u00106J\r\u00108\u001a\u000204¢\u0006\u0004\b8\u00106J\u0017\u0010:\u001a\u00020\u00162\u0006\u00109\u001a\u00020$H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010:\u001a\u00020\u00162\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b:\u0010>J\u0017\u0010@\u001a\u00020\u00162\u0006\u0010?\u001a\u00020<H\u0016¢\u0006\u0004\b@\u0010>J\u0017\u0010A\u001a\u00020\u00162\u0006\u0010?\u001a\u00020<H\u0016¢\u0006\u0004\bA\u0010>J\u001f\u0010D\u001a\u00020\u00162\u0006\u0010B\u001a\u0002042\u0006\u0010C\u001a\u00020$H\u0016¢\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u00020+2\u0006\u00109\u001a\u00020$H\u0016¢\u0006\u0004\bF\u0010GJ\u0017\u0010F\u001a\u00020+2\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\bF\u0010HJ\u0015\u0010I\u001a\u00020+2\u0006\u0010?\u001a\u00020<¢\u0006\u0004\bI\u0010HJ!\u0010J\u001a\u00020+2\u0006\u0010B\u001a\u0002042\b\u0010C\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\bJ\u0010KJ'\u0010J\u001a\u00020+2\u0006\u0010B\u001a\u0002042\b\u0010C\u001a\u0004\u0018\u00010$2\u0006\u0010L\u001a\u00020\u000b¢\u0006\u0004\bJ\u0010MJ\u000f\u0010O\u001a\u00020+H\u0000¢\u0006\u0004\bN\u0010-J\u000f\u0010Q\u001a\u00020\u0016H\u0000¢\u0006\u0004\bP\u0010\u0018J#\u0010U\u001a\u00020\u00162\n\u0010T\u001a\u00060Rj\u0002`S2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\bU\u0010VR\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z¨\u0006`"}, m5569d2 = {"Lokhttp3/internal/ws/RealWebSocket;", "Lokhttp3/WebSocket;", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "Lokhttp3/Request;", "originalRequest", "Lokhttp3/WebSocketListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Ljava/util/Random;", "random", "", "pingIntervalMillis", "Lokhttp3/internal/ws/WebSocketExtensions;", "extensions", "minimumDeflateSize", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/Request;Lokhttp3/WebSocketListener;Ljava/util/Random;JLokhttp3/internal/ws/WebSocketExtensions;J)V", "request", "()Lokhttp3/Request;", "queueSize", "()J", "", "cancel", "()V", "Lokhttp3/OkHttpClient;", "client", "connect", "(Lokhttp3/OkHttpClient;)V", "Lokhttp3/Response;", "response", "Lokhttp3/internal/connection/Exchange;", "exchange", "checkUpgradeSuccess$okhttp", "(Lokhttp3/Response;Lokhttp3/internal/connection/Exchange;)V", "checkUpgradeSuccess", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "Lokhttp3/internal/ws/RealWebSocket$Streams;", "streams", "initReaderAndWriter", "(Ljava/lang/String;Lokhttp3/internal/ws/RealWebSocket$Streams;)V", "loopReader", "", "processNextFrame", "()Z", "timeout", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "awaitTermination", "(JLjava/util/concurrent/TimeUnit;)V", "tearDown", "", "sentPingCount", "()I", "receivedPingCount", "receivedPongCount", MimeTypes.BASE_TYPE_TEXT, "onReadMessage", "(Ljava/lang/String;)V", "Lokio/ByteString;", "bytes", "(Lokio/ByteString;)V", "payload", "onReadPing", "onReadPong", "code", "reason", "onReadClose", "(ILjava/lang/String;)V", "send", "(Ljava/lang/String;)Z", "(Lokio/ByteString;)Z", "pong", "close", "(ILjava/lang/String;)Z", "cancelAfterCloseMillis", "(ILjava/lang/String;J)Z", "writeOneFrame$okhttp", "writeOneFrame", "writePingFrame$okhttp", "writePingFrame", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "failWebSocket", "(Ljava/lang/Exception;Lokhttp3/Response;)V", "b", "Lokhttp3/WebSocketListener;", "getListener$okhttp", "()Lokhttp3/WebSocketListener;", "Companion", "Close", "Message", "Streams", "c92", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 1024;

    /* renamed from: a */
    public final Request f24594a;

    /* renamed from: b, reason: from kotlin metadata */
    public final WebSocketListener listener;

    /* renamed from: c */
    public final Random f24596c;

    /* renamed from: d */
    public final long f24597d;

    /* renamed from: e */
    public WebSocketExtensions f24598e;

    /* renamed from: f */
    public final long f24599f;

    /* renamed from: g */
    public final String f24600g;

    /* renamed from: h */
    public RealCall f24601h;

    /* renamed from: i */
    public c92 f24602i;

    /* renamed from: j */
    public WebSocketReader f24603j;

    /* renamed from: k */
    public WebSocketWriter f24604k;

    /* renamed from: l */
    public final TaskQueue f24605l;

    /* renamed from: m */
    public String f24606m;

    /* renamed from: n */
    public Streams f24607n;

    /* renamed from: o */
    public final ArrayDeque f24608o;

    /* renamed from: p */
    public final ArrayDeque f24609p;

    /* renamed from: q */
    public long f24610q;

    /* renamed from: r */
    public boolean f24611r;

    /* renamed from: s */
    public int f24612s;

    /* renamed from: t */
    public String f24613t;

    /* renamed from: u */
    public boolean f24614u;

    /* renamed from: v */
    public int f24615v;

    /* renamed from: w */
    public int f24616w;

    /* renamed from: x */
    public int f24617x;

    /* renamed from: y */
    public boolean f24618y;

    /* renamed from: z */
    public static final List f24593z = AbstractC1167eq.listOf(Protocol.HTTP_1_1);

    @Metadata(m5568d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, m5569d2 = {"Lokhttp3/internal/ws/RealWebSocket$Close;", "", "", "code", "Lokio/ByteString;", "reason", "", "cancelAfterCloseMillis", "<init>", "(ILokio/ByteString;J)V", "a", "I", "getCode", "()I", "b", "Lokio/ByteString;", "getReason", "()Lokio/ByteString;", "c", "J", "getCancelAfterCloseMillis", "()J", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Close {

        /* renamed from: a, reason: from kotlin metadata */
        public final int code;

        /* renamed from: b, reason: from kotlin metadata */
        public final ByteString reason;

        /* renamed from: c, reason: from kotlin metadata */
        public final long cancelAfterCloseMillis;

        public Close(int i, @Nullable ByteString byteString, long j) {
            this.code = i;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }

        public final int getCode() {
            return this.code;
        }

        @Nullable
        public final ByteString getReason() {
            return this.reason;
        }
    }

    @Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m5569d2 = {"Lokhttp3/internal/ws/RealWebSocket$Message;", "", "", "formatOpcode", "Lokio/ByteString;", DataSchemeDataSource.SCHEME_DATA, "<init>", "(ILokio/ByteString;)V", "a", "I", "getFormatOpcode", "()I", "b", "Lokio/ByteString;", "getData", "()Lokio/ByteString;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Message {

        /* renamed from: a, reason: from kotlin metadata */
        public final int formatOpcode;

        /* renamed from: b, reason: from kotlin metadata */
        public final ByteString data;

        public Message(int i, @NotNull ByteString data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.formatOpcode = i;
            this.data = data;
        }

        @NotNull
        public final ByteString getData() {
            return this.data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }
    }

    @Metadata(m5568d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, m5569d2 = {"Lokhttp3/internal/ws/RealWebSocket$Streams;", "Ljava/io/Closeable;", "", "client", "Lokio/BufferedSource;", FirebaseAnalytics.Param.SOURCE, "Lokio/BufferedSink;", "sink", "<init>", "(ZLokio/BufferedSource;Lokio/BufferedSink;)V", "a", "Z", "getClient", "()Z", "b", "Lokio/BufferedSource;", "getSource", "()Lokio/BufferedSource;", "c", "Lokio/BufferedSink;", "getSink", "()Lokio/BufferedSink;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class Streams implements Closeable {

        /* renamed from: a, reason: from kotlin metadata */
        public final boolean client;

        /* renamed from: b, reason: from kotlin metadata */
        public final BufferedSource source;

        /* renamed from: c, reason: from kotlin metadata */
        public final BufferedSink sink;

        public Streams(boolean z, @NotNull BufferedSource source, @NotNull BufferedSink sink) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(sink, "sink");
            this.client = z;
            this.source = source;
            this.sink = sink;
        }

        public final boolean getClient() {
            return this.client;
        }

        @NotNull
        public final BufferedSink getSink() {
            return this.sink;
        }

        @NotNull
        public final BufferedSource getSource() {
            return this.source;
        }
    }

    public RealWebSocket(@NotNull TaskRunner taskRunner, @NotNull Request originalRequest, @NotNull WebSocketListener listener, @NotNull Random random, long j, @Nullable WebSocketExtensions webSocketExtensions, long j2) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(random, "random");
        this.f24594a = originalRequest;
        this.listener = listener;
        this.f24596c = random;
        this.f24597d = j;
        this.f24598e = webSocketExtensions;
        this.f24599f = j2;
        this.f24605l = taskRunner.newQueue();
        this.f24608o = new ArrayDeque();
        this.f24609p = new ArrayDeque();
        this.f24612s = -1;
        if (Intrinsics.areEqual(HttpRequest.METHOD_GET, originalRequest.method())) {
            ByteString.Companion companion = ByteString.INSTANCE;
            byte[] bArr = new byte[16];
            random.nextBytes(bArr);
            this.f24600g = ByteString.Companion.of$default(companion, bArr, 0, 0, 3, null).base64();
            return;
        }
        throw new IllegalArgumentException(("Request must be GET: " + originalRequest.method()).toString());
    }

    public static final boolean access$isValid(RealWebSocket realWebSocket, WebSocketExtensions webSocketExtensions) {
        realWebSocket.getClass();
        if (webSocketExtensions.unknownValues || webSocketExtensions.clientMaxWindowBits != null) {
            return false;
        }
        if (webSocketExtensions.serverMaxWindowBits != null && !new IntRange(8, 15).contains(webSocketExtensions.serverMaxWindowBits.intValue())) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public final void m6644a() {
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        c92 c92Var = this.f24602i;
        if (c92Var != null) {
            TaskQueue.schedule$default(this.f24605l, c92Var, 0L, 2, null);
        }
    }

    public final void awaitTermination(long timeout, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        this.f24605l.idleLatch().await(timeout, timeUnit);
    }

    /* renamed from: b */
    public final synchronized boolean m6645b(int i, ByteString byteString) {
        if (!this.f24614u && !this.f24611r) {
            if (this.f24610q + byteString.size() > 16777216) {
                close(1001, null);
                return false;
            }
            this.f24610q += byteString.size();
            this.f24609p.add(new Message(i, byteString));
            m6644a();
            return true;
        }
        return false;
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        RealCall realCall = this.f24601h;
        Intrinsics.checkNotNull(realCall);
        realCall.cancel();
    }

    public final void checkUpgradeSuccess$okhttp(@NotNull Response response, @Nullable Exchange exchange) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.code() == 101) {
            String header$default = Response.header$default(response, HttpHeaders.CONNECTION, null, 2, null);
            if (ro2.equals(HttpHeaders.UPGRADE, header$default, true)) {
                String header$default2 = Response.header$default(response, HttpHeaders.UPGRADE, null, 2, null);
                if (ro2.equals("websocket", header$default2, true)) {
                    String header$default3 = Response.header$default(response, HttpHeaders.SEC_WEBSOCKET_ACCEPT, null, 2, null);
                    String base64 = ByteString.INSTANCE.encodeUtf8(this.f24600g + WebSocketProtocol.ACCEPT_MAGIC).sha1().base64();
                    if (Intrinsics.areEqual(base64, header$default3)) {
                        if (exchange != null) {
                            return;
                        } else {
                            throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
                        }
                    }
                    throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header$default3 + '\'');
                }
                throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header$default2 + '\'');
            }
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header$default + '\'');
        }
        throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + ' ' + response.message() + '\'');
    }

    @Override // okhttp3.WebSocket
    public boolean close(int code, @Nullable String reason) {
        return close(code, reason, 60000L);
    }

    public final void connect(@NotNull OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        Request request = this.f24594a;
        if (request.header(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS) != null) {
            failWebSocket(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
            return;
        }
        OkHttpClient build = client.newBuilder().eventListener(EventListener.NONE).protocols(f24593z).build();
        final Request build2 = request.newBuilder().header(HttpHeaders.UPGRADE, "websocket").header(HttpHeaders.CONNECTION, HttpHeaders.UPGRADE).header(HttpHeaders.SEC_WEBSOCKET_KEY, this.f24600g).header(HttpHeaders.SEC_WEBSOCKET_VERSION, "13").header(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS, "permessage-deflate").build();
        RealCall realCall = new RealCall(build, build2, true);
        this.f24601h = realCall;
        Intrinsics.checkNotNull(realCall);
        realCall.enqueue(new Callback() { // from class: okhttp3.internal.ws.RealWebSocket$connect$1
            @Override // okhttp3.Callback
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e, "e");
                RealWebSocket.this.failWebSocket(e, null);
            }

            @Override // okhttp3.Callback
            public void onResponse(@NotNull Call call, @NotNull Response response) {
                ArrayDeque arrayDeque;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                Exchange exchange = response.getExchange();
                try {
                    RealWebSocket.this.checkUpgradeSuccess$okhttp(response, exchange);
                    Intrinsics.checkNotNull(exchange);
                    RealWebSocket.Streams newWebSocketStreams = exchange.newWebSocketStreams();
                    WebSocketExtensions parse = WebSocketExtensions.INSTANCE.parse(response.headers());
                    RealWebSocket.this.f24598e = parse;
                    if (!RealWebSocket.access$isValid(RealWebSocket.this, parse)) {
                        RealWebSocket realWebSocket = RealWebSocket.this;
                        synchronized (realWebSocket) {
                            arrayDeque = realWebSocket.f24609p;
                            arrayDeque.clear();
                            realWebSocket.close(1010, "unexpected Sec-WebSocket-Extensions in response header");
                        }
                    }
                    try {
                        RealWebSocket.this.initReaderAndWriter(_UtilJvmKt.okHttpName + " WebSocket " + build2.url().redact(), newWebSocketStreams);
                        RealWebSocket.this.getListener().onOpen(RealWebSocket.this, response);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e) {
                        RealWebSocket.this.failWebSocket(e, null);
                    }
                } catch (IOException e2) {
                    if (exchange != null) {
                        exchange.webSocketUpgradeFailed();
                    }
                    RealWebSocket.this.failWebSocket(e2, response);
                    _UtilCommonKt.closeQuietly(response);
                }
            }
        });
    }

    public final void failWebSocket(@NotNull Exception e, @Nullable Response response) {
        Intrinsics.checkNotNullParameter(e, "e");
        synchronized (this) {
            if (this.f24614u) {
                return;
            }
            this.f24614u = true;
            Streams streams = this.f24607n;
            this.f24607n = null;
            WebSocketReader webSocketReader = this.f24603j;
            this.f24603j = null;
            WebSocketWriter webSocketWriter = this.f24604k;
            this.f24604k = null;
            this.f24605l.shutdown();
            try {
                this.listener.onFailure(this, e, response);
            } finally {
                if (streams != null) {
                    _UtilCommonKt.closeQuietly(streams);
                }
                if (webSocketReader != null) {
                    _UtilCommonKt.closeQuietly(webSocketReader);
                }
                if (webSocketWriter != null) {
                    _UtilCommonKt.closeQuietly(webSocketWriter);
                }
            }
        }
    }

    @NotNull
    /* renamed from: getListener$okhttp, reason: from getter */
    public final WebSocketListener getListener() {
        return this.listener;
    }

    public final void initReaderAndWriter(@NotNull String name, @NotNull Streams streams) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(streams, "streams");
        WebSocketExtensions webSocketExtensions = this.f24598e;
        Intrinsics.checkNotNull(webSocketExtensions);
        synchronized (this) {
            try {
                this.f24606m = name;
                this.f24607n = streams;
                this.f24604k = new WebSocketWriter(streams.getClient(), streams.getSink(), this.f24596c, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(streams.getClient()), this.f24599f);
                this.f24602i = new c92(this);
                long j = this.f24597d;
                if (j != 0) {
                    long nanos = TimeUnit.MILLISECONDS.toNanos(j);
                    this.f24605l.schedule(name + " ping", nanos, new e11(this, nanos, 1));
                }
                if (!this.f24609p.isEmpty()) {
                    m6644a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f24603j = new WebSocketReader(streams.getClient(), streams.getSource(), this, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(!streams.getClient()));
    }

    public final void loopReader() {
        while (this.f24612s == -1) {
            WebSocketReader webSocketReader = this.f24603j;
            Intrinsics.checkNotNull(webSocketReader);
            webSocketReader.processNextFrame();
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int code, @NotNull String reason) {
        Streams streams;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter;
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (code != -1) {
            synchronized (this) {
                if (this.f24612s == -1) {
                    this.f24612s = code;
                    this.f24613t = reason;
                    streams = null;
                    if (this.f24611r && this.f24609p.isEmpty()) {
                        Streams streams2 = this.f24607n;
                        this.f24607n = null;
                        webSocketReader = this.f24603j;
                        this.f24603j = null;
                        webSocketWriter = this.f24604k;
                        this.f24604k = null;
                        this.f24605l.shutdown();
                        streams = streams2;
                    } else {
                        webSocketReader = null;
                        webSocketWriter = null;
                    }
                } else {
                    throw new IllegalStateException("already closed");
                }
            }
            try {
                this.listener.onClosing(this, code, reason);
                if (streams != null) {
                    this.listener.onClosed(this, code, reason);
                }
                if (webSocketWriter != null) {
                    return;
                } else {
                    return;
                }
            } finally {
                if (streams != null) {
                    _UtilCommonKt.closeQuietly(streams);
                }
                if (webSocketReader != null) {
                    _UtilCommonKt.closeQuietly(webSocketReader);
                }
                if (webSocketWriter != null) {
                    _UtilCommonKt.closeQuietly(webSocketWriter);
                }
            }
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.listener.onMessage(this, text);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(@NotNull ByteString payload) {
        try {
            Intrinsics.checkNotNullParameter(payload, "payload");
            if (!this.f24614u && (!this.f24611r || !this.f24609p.isEmpty())) {
                this.f24608o.add(payload);
                m6644a();
                this.f24616w++;
            }
        } finally {
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(@NotNull ByteString payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.f24617x++;
        this.f24618y = false;
    }

    public final synchronized boolean pong(@NotNull ByteString payload) {
        try {
            Intrinsics.checkNotNullParameter(payload, "payload");
            if (!this.f24614u && (!this.f24611r || !this.f24609p.isEmpty())) {
                this.f24608o.add(payload);
                m6644a();
                return true;
            }
            return false;
        } finally {
        }
    }

    public final boolean processNextFrame() {
        try {
            WebSocketReader webSocketReader = this.f24603j;
            Intrinsics.checkNotNull(webSocketReader);
            webSocketReader.processNextFrame();
            if (this.f24612s != -1) {
                return false;
            }
            return true;
        } catch (Exception e) {
            failWebSocket(e, null);
            return false;
        }
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.f24610q;
    }

    public final synchronized int receivedPingCount() {
        return this.f24616w;
    }

    public final synchronized int receivedPongCount() {
        return this.f24617x;
    }

    @Override // okhttp3.WebSocket
    @NotNull
    /* renamed from: request, reason: from getter */
    public Request getF24594a() {
        return this.f24594a;
    }

    @Override // okhttp3.WebSocket
    public boolean send(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return m6645b(1, ByteString.INSTANCE.encodeUtf8(text));
    }

    public final synchronized int sentPingCount() {
        return this.f24615v;
    }

    public final void tearDown() {
        TaskQueue taskQueue = this.f24605l;
        taskQueue.shutdown();
        taskQueue.idleLatch().await(10L, TimeUnit.SECONDS);
    }

    public final boolean writeOneFrame$okhttp() {
        String str;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter;
        int i;
        Streams streams;
        synchronized (this) {
            try {
                if (this.f24614u) {
                    return false;
                }
                WebSocketWriter webSocketWriter2 = this.f24604k;
                Object poll = this.f24608o.poll();
                Object obj = null;
                if (poll == null) {
                    Object poll2 = this.f24609p.poll();
                    if (poll2 instanceof Close) {
                        i = this.f24612s;
                        str = this.f24613t;
                        if (i != -1) {
                            streams = this.f24607n;
                            this.f24607n = null;
                            webSocketReader = this.f24603j;
                            this.f24603j = null;
                            webSocketWriter = this.f24604k;
                            this.f24604k = null;
                            this.f24605l.shutdown();
                        } else {
                            long cancelAfterCloseMillis = ((Close) poll2).getCancelAfterCloseMillis();
                            TaskQueue.execute$default(this.f24605l, this.f24606m + " cancel", TimeUnit.MILLISECONDS.toNanos(cancelAfterCloseMillis), false, new C1829tb(10, this), 4, null);
                            streams = null;
                            webSocketReader = null;
                            webSocketWriter = null;
                        }
                    } else {
                        if (poll2 == null) {
                            return false;
                        }
                        str = null;
                        webSocketReader = null;
                        webSocketWriter = null;
                        i = -1;
                        streams = null;
                    }
                    obj = poll2;
                } else {
                    str = null;
                    webSocketReader = null;
                    webSocketWriter = null;
                    i = -1;
                    streams = null;
                }
                try {
                    if (poll != null) {
                        Intrinsics.checkNotNull(webSocketWriter2);
                        webSocketWriter2.writePong((ByteString) poll);
                    } else if (obj instanceof Message) {
                        Message message = (Message) obj;
                        Intrinsics.checkNotNull(webSocketWriter2);
                        webSocketWriter2.writeMessageFrame(message.getFormatOpcode(), message.getData());
                        synchronized (this) {
                            this.f24610q -= message.getData().size();
                        }
                    } else if (obj instanceof Close) {
                        Close close = (Close) obj;
                        Intrinsics.checkNotNull(webSocketWriter2);
                        webSocketWriter2.writeClose(close.getCode(), close.getReason());
                        if (streams != null) {
                            WebSocketListener webSocketListener = this.listener;
                            Intrinsics.checkNotNull(str);
                            webSocketListener.onClosed(this, i, str);
                        }
                    } else {
                        throw new AssertionError();
                    }
                } finally {
                    if (streams != null) {
                        _UtilCommonKt.closeQuietly(streams);
                    }
                    if (webSocketReader != null) {
                        _UtilCommonKt.closeQuietly(webSocketReader);
                    }
                    if (webSocketWriter != null) {
                        _UtilCommonKt.closeQuietly(webSocketWriter);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void writePingFrame$okhttp() {
        int i;
        synchronized (this) {
            try {
                if (this.f24614u) {
                    return;
                }
                WebSocketWriter webSocketWriter = this.f24604k;
                if (webSocketWriter == null) {
                    return;
                }
                if (this.f24618y) {
                    i = this.f24615v;
                } else {
                    i = -1;
                }
                this.f24615v++;
                this.f24618y = true;
                if (i != -1) {
                    StringBuilder sb = new StringBuilder("sent ping but didn't receive pong within ");
                    sb.append(this.f24597d);
                    sb.append("ms (after ");
                    failWebSocket(new SocketTimeoutException(ye0.m8298r(sb, " successful ping/pongs)", i - 1)), null);
                    return;
                }
                try {
                    webSocketWriter.writePing(ByteString.EMPTY);
                } catch (IOException e) {
                    failWebSocket(e, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized boolean close(int code, @Nullable String reason, long cancelAfterCloseMillis) {
        ByteString byteString;
        try {
            WebSocketProtocol.INSTANCE.validateCloseCode(code);
            if (reason != null) {
                byteString = ByteString.INSTANCE.encodeUtf8(reason);
                if (byteString.size() > 123) {
                    throw new IllegalArgumentException("reason.size() > 123: ".concat(reason).toString());
                }
            } else {
                byteString = null;
            }
            if (!this.f24614u && !this.f24611r) {
                this.f24611r = true;
                this.f24609p.add(new Close(code, byteString, cancelAfterCloseMillis));
                m6644a();
                return true;
            }
            return false;
        } finally {
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(@NotNull ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.listener.onMessage(this, bytes);
    }

    @Override // okhttp3.WebSocket
    public boolean send(@NotNull ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return m6645b(2, bytes);
    }
}
