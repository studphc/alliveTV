package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.net.Socket;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Route;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 \u0080\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0080\u0001Bc\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u0019H\u0000¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001f\u001a\u00020\u0019H\u0000¢\u0006\u0004\b\u001e\u0010\u001bJ\r\u0010 \u001a\u00020\u0019¢\u0006\u0004\b \u0010\u001bJ'\u0010(\u001a\u00020%2\u0006\u0010\"\u001a\u00020!2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010#H\u0000¢\u0006\u0004\b&\u0010'J\u001f\u00100\u001a\u00020-2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0000¢\u0006\u0004\b.\u0010/J\u0017\u00106\u001a\u0002032\u0006\u00102\u001a\u000201H\u0000¢\u0006\u0004\b4\u00105J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u00107J\u000f\u00108\u001a\u00020\u0019H\u0016¢\u0006\u0004\b8\u0010\u001bJ\u000f\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u00109J\u0015\u0010;\u001a\u00020%2\u0006\u0010:\u001a\u00020%¢\u0006\u0004\b;\u0010<J\u0017\u0010?\u001a\u00020\u00192\u0006\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\b?\u0010@J\u001f\u0010E\u001a\u00020\u00192\u0006\u0010B\u001a\u00020A2\u0006\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bE\u0010FJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010GJ'\u0010M\u001a\u00020\u00192\u0006\u0010*\u001a\u00020)2\u0006\u0010H\u001a\u00020\b2\u0006\u0010J\u001a\u00020IH\u0000¢\u0006\u0004\bK\u0010LJ!\u0010Q\u001a\u00020\u00192\u0006\u0010O\u001a\u00020N2\b\u0010P\u001a\u0004\u0018\u00010IH\u0016¢\u0006\u0004\bQ\u0010RJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010SJ\u000f\u0010U\u001a\u00020TH\u0016¢\u0006\u0004\bU\u0010VR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u00107R\"\u0010\u001a\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\"\u0010n\u001a\u00020\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR#\u0010u\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0p0o8\u0006¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR\"\u0010}\u001a\u00020v8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0014\u0010\u007f\u001a\u00020%8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b~\u0010e¨\u0006\u0081\u0001"}, m5569d2 = {"Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/internal/http2/Http2Connection$Listener;", "Lokhttp3/Connection;", "Lokhttp3/internal/http/ExchangeCodec$Carrier;", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/Route;", "route", "Ljava/net/Socket;", "rawSocket", "socket", "Lokhttp3/Handshake;", "handshake", "Lokhttp3/Protocol;", "protocol", "Lokio/BufferedSource;", FirebaseAnalytics.Param.SOURCE, "Lokio/BufferedSink;", "sink", "", "pingIntervalMillis", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Route;Ljava/net/Socket;Ljava/net/Socket;Lokhttp3/Handshake;Lokhttp3/Protocol;Lokio/BufferedSource;Lokio/BufferedSink;I)V", "", "noNewExchanges", "()V", "noCoalescedConnections$okhttp", "noCoalescedConnections", "incrementSuccessCount$okhttp", "incrementSuccessCount", "start", "Lokhttp3/Address;", "address", "", "routes", "", "isEligible$okhttp", "(Lokhttp3/Address;Ljava/util/List;)Z", "isEligible", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/internal/http/RealInterceptorChain;", "chain", "Lokhttp3/internal/http/ExchangeCodec;", "newCodec$okhttp", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/http/RealInterceptorChain;)Lokhttp3/internal/http/ExchangeCodec;", "newCodec", "Lokhttp3/internal/connection/Exchange;", "exchange", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "newWebSocketStreams$okhttp", "(Lokhttp3/internal/connection/Exchange;)Lokhttp3/internal/ws/RealWebSocket$Streams;", "newWebSocketStreams", "()Lokhttp3/Route;", "cancel", "()Ljava/net/Socket;", "doExtensiveChecks", "isHealthy", "(Z)Z", "Lokhttp3/internal/http2/Http2Stream;", "stream", "onStream", "(Lokhttp3/internal/http2/Http2Stream;)V", "Lokhttp3/internal/http2/Http2Connection;", "connection", "Lokhttp3/internal/http2/Settings;", "settings", "onSettings", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Settings;)V", "()Lokhttp3/Handshake;", "failedRoute", "Ljava/io/IOException;", "failure", "connectFailed$okhttp", "(Lokhttp3/OkHttpClient;Lokhttp3/Route;Ljava/io/IOException;)V", "connectFailed", "Lokhttp3/internal/connection/RealCall;", NotificationCompat.CATEGORY_CALL, "e", "trackFailure", "(Lokhttp3/internal/connection/RealCall;Ljava/io/IOException;)V", "()Lokhttp3/Protocol;", "", "toString", "()Ljava/lang/String;", "a", "Lokhttp3/internal/concurrent/TaskRunner;", "getTaskRunner", "()Lokhttp3/internal/concurrent/TaskRunner;", "b", "Lokhttp3/internal/connection/RealConnectionPool;", "getConnectionPool", "()Lokhttp3/internal/connection/RealConnectionPool;", "c", "Lokhttp3/Route;", "getRoute", "l", "Z", "getNoNewExchanges", "()Z", "setNoNewExchanges", "(Z)V", "n", "I", "getRouteFailureCount$okhttp", "()I", "setRouteFailureCount$okhttp", "(I)V", "routeFailureCount", "", "Ljava/lang/ref/Reference;", "r", "Ljava/util/List;", "getCalls", "()Ljava/util/List;", "calls", "", "s", "J", "getIdleAtNs", "()J", "setIdleAtNs", "(J)V", "idleAtNs", "isMultiplexed$okhttp", "isMultiplexed", "Companion", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class RealConnection extends Http2Connection.Listener implements Connection, ExchangeCodec.Carrier {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final long IDLE_CONNECTION_HEALTHY_NS = 10000000000L;

    /* renamed from: a, reason: from kotlin metadata */
    public final TaskRunner taskRunner;

    /* renamed from: b, reason: from kotlin metadata */
    public final RealConnectionPool connectionPool;

    /* renamed from: c, reason: from kotlin metadata */
    public final Route route;

    /* renamed from: d */
    public final Socket f24335d;

    /* renamed from: e */
    public final Socket f24336e;

    /* renamed from: f */
    public final Handshake f24337f;

    /* renamed from: g */
    public final Protocol f24338g;

    /* renamed from: h */
    public final BufferedSource f24339h;

    /* renamed from: i */
    public final BufferedSink f24340i;

    /* renamed from: j */
    public final int f24341j;

    /* renamed from: k */
    public Http2Connection f24342k;

    /* renamed from: l, reason: from kotlin metadata */
    public boolean noNewExchanges;

    /* renamed from: m */
    public boolean f24344m;

    /* renamed from: n, reason: from kotlin metadata */
    public int routeFailureCount;

    /* renamed from: o */
    public int f24346o;

    /* renamed from: p */
    public int f24347p;

    /* renamed from: q */
    public int f24348q;

    /* renamed from: r */
    public final ArrayList f24349r;

    /* renamed from: s, reason: from kotlin metadata */
    public long idleAtNs;

    @Metadata(m5568d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001J5\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m5569d2 = {"Lokhttp3/internal/connection/RealConnection$Companion;", "", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/Route;", "route", "Ljava/net/Socket;", "socket", "", "idleAtNs", "Lokhttp3/internal/connection/RealConnection;", "newTestConnection", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Route;Ljava/net/Socket;J)Lokhttp3/internal/connection/RealConnection;", "IDLE_CONNECTION_HEALTHY_NS", "J", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @NotNull
        public final RealConnection newTestConnection(@NotNull TaskRunner taskRunner, @NotNull RealConnectionPool connectionPool, @NotNull Route route, @NotNull Socket socket, long idleAtNs) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
            Intrinsics.checkNotNullParameter(route, "route");
            Intrinsics.checkNotNullParameter(socket, "socket");
            RealConnection realConnection = new RealConnection(taskRunner, connectionPool, route, null, socket, null, null, null, null, 0);
            realConnection.setIdleAtNs(idleAtNs);
            return realConnection;
        }
    }

    public RealConnection(@NotNull TaskRunner taskRunner, @NotNull RealConnectionPool connectionPool, @NotNull Route route, @Nullable Socket socket, @Nullable Socket socket2, @Nullable Handshake handshake, @Nullable Protocol protocol, @Nullable BufferedSource bufferedSource, @Nullable BufferedSink bufferedSink, int i) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(route, "route");
        this.taskRunner = taskRunner;
        this.connectionPool = connectionPool;
        this.route = route;
        this.f24335d = socket;
        this.f24336e = socket2;
        this.f24337f = handshake;
        this.f24338g = protocol;
        this.f24339h = bufferedSource;
        this.f24340i = bufferedSink;
        this.f24341j = i;
        this.f24348q = 1;
        this.f24349r = new ArrayList();
        this.idleAtNs = Long.MAX_VALUE;
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    /* renamed from: cancel */
    public void mo9049cancel() {
        Socket socket = this.f24335d;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
    }

    public final void connectFailed$okhttp(@NotNull OkHttpClient client, @NotNull Route failedRoute, @NotNull IOException failure) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(failedRoute, "failedRoute");
        Intrinsics.checkNotNullParameter(failure, "failure");
        if (failedRoute.proxy().type() != Proxy.Type.DIRECT) {
            Address address = failedRoute.address();
            address.proxySelector().connectFailed(address.url().uri(), failedRoute.proxy().address(), failure);
        }
        client.getRouteDatabase().failed(failedRoute);
    }

    @NotNull
    public final List<Reference<RealCall>> getCalls() {
        return this.f24349r;
    }

    @NotNull
    public final RealConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    public final long getIdleAtNs() {
        return this.idleAtNs;
    }

    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    @NotNull
    public Route getRoute() {
        return this.route;
    }

    /* renamed from: getRouteFailureCount$okhttp, reason: from getter */
    public final int getRouteFailureCount() {
        return this.routeFailureCount;
    }

    @NotNull
    public final TaskRunner getTaskRunner() {
        return this.taskRunner;
    }

    @Override // okhttp3.Connection
    @Nullable
    /* renamed from: handshake, reason: from getter */
    public Handshake getF24337f() {
        return this.f24337f;
    }

    public final synchronized void incrementSuccessCount$okhttp() {
        this.f24346o++;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0140, code lost:
    
        if (r0.verify(r9.host(), (java.security.cert.X509Certificate) r1.get(0)) != false) goto L64;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isEligible$okhttp(@NotNull Address address, @Nullable List<Route> routes) {
        Handshake handshake;
        Intrinsics.checkNotNullParameter(address, "address");
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        if (this.f24349r.size() >= this.f24348q || this.noNewExchanges || !getRoute().address().equalsNonHost$okhttp(address)) {
            return false;
        }
        if (Intrinsics.areEqual(address.url().host(), route().address().url().host())) {
            return true;
        }
        if (this.f24342k != null && routes != null && !routes.isEmpty()) {
            Iterator<T> it = routes.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Route route = (Route) it.next();
                Proxy.Type type = route.proxy().type();
                Proxy.Type type2 = Proxy.Type.DIRECT;
                if (type == type2 && getRoute().proxy().type() == type2 && Intrinsics.areEqual(getRoute().socketAddress(), route.socketAddress())) {
                    HostnameVerifier hostnameVerifier = address.hostnameVerifier();
                    OkHostnameVerifier okHostnameVerifier = OkHostnameVerifier.INSTANCE;
                    if (hostnameVerifier != okHostnameVerifier) {
                        return false;
                    }
                    HttpUrl url = address.url();
                    if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(this)) {
                        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
                    }
                    HttpUrl url2 = getRoute().address().url();
                    if (url.port() == url2.port()) {
                        if (!Intrinsics.areEqual(url.host(), url2.host())) {
                            if (!this.f24344m && (handshake = this.f24337f) != null) {
                                Intrinsics.checkNotNull(handshake);
                                List<Certificate> peerCertificates = handshake.peerCertificates();
                                if (!peerCertificates.isEmpty()) {
                                }
                            }
                        }
                        try {
                            CertificatePinner certificatePinner = address.certificatePinner();
                            Intrinsics.checkNotNull(certificatePinner);
                            String host = address.url().host();
                            Handshake f24337f = getF24337f();
                            Intrinsics.checkNotNull(f24337f);
                            certificatePinner.check(host, f24337f.peerCertificates());
                            return true;
                        } catch (SSLPeerUnverifiedException unused) {
                        }
                    }
                }
            }
        }
        return false;
    }

    public final boolean isHealthy(boolean doExtensiveChecks) {
        long j;
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        long nanoTime = System.nanoTime();
        Socket socket = this.f24335d;
        Intrinsics.checkNotNull(socket);
        Socket socket2 = this.f24336e;
        Intrinsics.checkNotNull(socket2);
        BufferedSource bufferedSource = this.f24339h;
        Intrinsics.checkNotNull(bufferedSource);
        if (!socket.isClosed() && !socket2.isClosed() && !socket2.isInputShutdown() && !socket2.isOutputShutdown()) {
            Http2Connection http2Connection = this.f24342k;
            if (http2Connection != null) {
                return http2Connection.isHealthy(nanoTime);
            }
            synchronized (this) {
                j = nanoTime - this.idleAtNs;
            }
            if (j >= IDLE_CONNECTION_HEALTHY_NS && doExtensiveChecks) {
                return _UtilJvmKt.isHealthy(socket2, bufferedSource);
            }
            return true;
        }
        return false;
    }

    public final boolean isMultiplexed$okhttp() {
        if (this.f24342k != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ExchangeCodec newCodec$okhttp(@NotNull OkHttpClient client, @NotNull RealInterceptorChain chain) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Socket socket = this.f24336e;
        Intrinsics.checkNotNull(socket);
        BufferedSource bufferedSource = this.f24339h;
        Intrinsics.checkNotNull(bufferedSource);
        BufferedSink bufferedSink = this.f24340i;
        Intrinsics.checkNotNull(bufferedSink);
        Http2Connection http2Connection = this.f24342k;
        if (http2Connection != null) {
            return new Http2ExchangeCodec(client, this, chain, http2Connection);
        }
        socket.setSoTimeout(chain.readTimeoutMillis());
        Timeout f24675a = bufferedSource.getF24675a();
        long readTimeoutMillis = chain.getReadTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        f24675a.timeout(readTimeoutMillis, timeUnit);
        bufferedSink.getF24673a().timeout(chain.getWriteTimeoutMillis(), timeUnit);
        return new Http1ExchangeCodec(client, this, bufferedSource, bufferedSink);
    }

    @NotNull
    public final RealWebSocket.Streams newWebSocketStreams$okhttp(@NotNull final Exchange exchange) {
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        Socket socket = this.f24336e;
        Intrinsics.checkNotNull(socket);
        final BufferedSource bufferedSource = this.f24339h;
        Intrinsics.checkNotNull(bufferedSource);
        final BufferedSink bufferedSink = this.f24340i;
        Intrinsics.checkNotNull(bufferedSink);
        socket.setSoTimeout(0);
        noNewExchanges();
        return new RealWebSocket.Streams(bufferedSource, bufferedSink) { // from class: okhttp3.internal.connection.RealConnection$newWebSocketStreams$1
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                exchange.bodyComplete(-1L, true, true, null);
            }
        };
    }

    public final synchronized void noCoalescedConnections$okhttp() {
        this.f24344m = true;
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public synchronized void noNewExchanges() {
        this.noNewExchanges = true;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public synchronized void onSettings(@NotNull Http2Connection connection, @NotNull Settings settings) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.f24348q = settings.getMaxConcurrentStreams();
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(@NotNull Http2Stream stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        stream.close(ErrorCode.REFUSED_STREAM, null);
    }

    @Override // okhttp3.Connection
    @NotNull
    public Protocol protocol() {
        Protocol protocol = this.f24338g;
        Intrinsics.checkNotNull(protocol);
        return protocol;
    }

    @Override // okhttp3.Connection
    @NotNull
    public Route route() {
        return getRoute();
    }

    public final void setIdleAtNs(long j) {
        this.idleAtNs = j;
    }

    public final void setNoNewExchanges(boolean z) {
        this.noNewExchanges = z;
    }

    public final void setRouteFailureCount$okhttp(int i) {
        this.routeFailureCount = i;
    }

    @Override // okhttp3.Connection
    @NotNull
    public Socket socket() {
        Socket socket = this.f24336e;
        Intrinsics.checkNotNull(socket);
        return socket;
    }

    public final void start() {
        this.idleAtNs = System.nanoTime();
        Protocol protocol = Protocol.HTTP_2;
        Protocol protocol2 = this.f24338g;
        if (protocol2 == protocol || protocol2 == Protocol.H2_PRIOR_KNOWLEDGE) {
            Socket socket = this.f24336e;
            Intrinsics.checkNotNull(socket);
            BufferedSource bufferedSource = this.f24339h;
            Intrinsics.checkNotNull(bufferedSource);
            BufferedSink bufferedSink = this.f24340i;
            Intrinsics.checkNotNull(bufferedSink);
            socket.setSoTimeout(0);
            Http2Connection build = new Http2Connection.Builder(true, this.taskRunner).socket(socket, getRoute().address().url().host(), bufferedSource, bufferedSink).listener(this).pingIntervalMillis(this.f24341j).build();
            this.f24342k = build;
            this.f24348q = Http2Connection.INSTANCE.getDEFAULT_SETTINGS().getMaxConcurrentStreams();
            Http2Connection.start$default(build, false, 1, null);
        }
    }

    @NotNull
    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("Connection{");
        sb.append(getRoute().address().url().host());
        sb.append(':');
        sb.append(getRoute().address().url().port());
        sb.append(", proxy=");
        sb.append(getRoute().proxy());
        sb.append(" hostAddress=");
        sb.append(getRoute().socketAddress());
        sb.append(" cipherSuite=");
        Handshake handshake = this.f24337f;
        if (handshake == null || (obj = handshake.cipherSuite()) == null) {
            obj = SchedulerSupport.NONE;
        }
        sb.append(obj);
        sb.append(" protocol=");
        sb.append(this.f24338g);
        sb.append('}');
        return sb.toString();
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public synchronized void trackFailure(@NotNull RealCall call, @Nullable IOException e) {
        try {
            Intrinsics.checkNotNullParameter(call, "call");
            if (e instanceof StreamResetException) {
                if (((StreamResetException) e).errorCode == ErrorCode.REFUSED_STREAM) {
                    int i = this.f24347p + 1;
                    this.f24347p = i;
                    if (i > 1) {
                        this.noNewExchanges = true;
                        this.routeFailureCount++;
                    }
                } else if (((StreamResetException) e).errorCode != ErrorCode.CANCEL || !call.getF24324p()) {
                    this.noNewExchanges = true;
                    this.routeFailureCount++;
                }
            } else if (!isMultiplexed$okhttp() || (e instanceof ConnectionShutdownException)) {
                this.noNewExchanges = true;
                if (this.f24346o == 0) {
                    if (e != null) {
                        connectFailed$okhttp(call.getClient(), getRoute(), e);
                    }
                    this.routeFailureCount++;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
