package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.RoutePlanner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1829tb;
import p000.C1950wl;
import p000.mo2;
import p000.ro2;

@Metadata(m5568d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001KBY\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u001a\u0010\u0018J%\u0010\"\u001a\u00020\u00002\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0000¢\u0006\u0004\b \u0010!J'\u0010$\u001a\u0004\u0018\u00010\u00002\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0000¢\u0006\u0004\b#\u0010!J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J!\u0010+\u001a\u00020*2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020*H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020*H\u0016¢\u0006\u0004\b/\u0010.J\u000f\u00100\u001a\u00020\u0001H\u0016¢\u0006\u0004\b0\u00101J\r\u00102\u001a\u00020*¢\u0006\u0004\b2\u0010.R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b)\u00107\u001a\u0004\b8\u00109R\u001a\u0010\u0011\u001a\u00020\r8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001a\u0010\u0013\u001a\u00020\u00128\u0000X\u0080\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR$\u0010I\u001a\u0004\u0018\u00010B8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0014\u0010J\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010A¨\u0006L"}, m5569d2 = {"Lokhttp3/internal/connection/ConnectPlan;", "Lokhttp3/internal/connection/RoutePlanner$Plan;", "Lokhttp3/internal/http/ExchangeCodec$Carrier;", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/internal/connection/RealCall;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/internal/connection/RealRoutePlanner;", "routePlanner", "Lokhttp3/Route;", "route", "", "routes", "", "attempt", "Lokhttp3/Request;", "tunnelRequest", "connectionSpecIndex", "", "isTlsFallback", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealCall;Lokhttp3/internal/connection/RealRoutePlanner;Lokhttp3/Route;Ljava/util/List;ILokhttp3/Request;IZ)V", "Lokhttp3/internal/connection/RoutePlanner$ConnectResult;", "connectTcp", "()Lokhttp3/internal/connection/RoutePlanner$ConnectResult;", "connectTlsEtc", "connectTunnel$okhttp", "connectTunnel", "Lokhttp3/ConnectionSpec;", "connectionSpecs", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "planWithCurrentOrInitialConnectionSpec$okhttp", "(Ljava/util/List;Ljavax/net/ssl/SSLSocket;)Lokhttp3/internal/connection/ConnectPlan;", "planWithCurrentOrInitialConnectionSpec", "nextConnectionSpec$okhttp", "nextConnectionSpec", "Lokhttp3/internal/connection/RealConnection;", "handleSuccess", "()Lokhttp3/internal/connection/RealConnection;", "Ljava/io/IOException;", "e", "", "trackFailure", "(Lokhttp3/internal/connection/RealCall;Ljava/io/IOException;)V", "noNewExchanges", "()V", "cancel", "retry", "()Lokhttp3/internal/connection/RoutePlanner$Plan;", "closeQuietly", "d", "Lokhttp3/Route;", "getRoute", "()Lokhttp3/Route;", "Ljava/util/List;", "getRoutes$okhttp", "()Ljava/util/List;", "h", "I", "getConnectionSpecIndex$okhttp", "()I", "i", "Z", "isTlsFallback$okhttp", "()Z", "Ljava/net/Socket;", "m", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "setSocket$okhttp", "(Ljava/net/Socket;)V", "socket", "isReady", "Companion", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class ConnectPlan implements RoutePlanner.Plan, ExchangeCodec.Carrier {

    /* renamed from: a */
    public final OkHttpClient f24270a;

    /* renamed from: b */
    public final RealCall f24271b;

    /* renamed from: c */
    public final RealRoutePlanner f24272c;

    /* renamed from: d, reason: from kotlin metadata */
    public final Route route;

    /* renamed from: e, reason: from kotlin metadata */
    public final List routes;

    /* renamed from: f */
    public final int f24275f;

    /* renamed from: g */
    public final Request f24276g;

    /* renamed from: h, reason: from kotlin metadata */
    public final int connectionSpecIndex;

    /* renamed from: i, reason: from kotlin metadata */
    public final boolean isTlsFallback;

    /* renamed from: j */
    public final EventListener f24279j;

    /* renamed from: k */
    public volatile boolean f24280k;

    /* renamed from: l */
    public Socket f24281l;

    /* renamed from: m, reason: from kotlin metadata */
    public Socket socket;

    /* renamed from: n */
    public Handshake f24283n;

    /* renamed from: o */
    public Protocol f24284o;

    /* renamed from: p */
    public BufferedSource f24285p;

    /* renamed from: q */
    public BufferedSink f24286q;

    /* renamed from: r */
    public RealConnection f24287r;

    @Metadata(m5570k = 3, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            iArr[Proxy.Type.HTTP.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ConnectPlan(@NotNull OkHttpClient client, @NotNull RealCall call, @NotNull RealRoutePlanner routePlanner, @NotNull Route route, @Nullable List<Route> list, int i, @Nullable Request request, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(routePlanner, "routePlanner");
        Intrinsics.checkNotNullParameter(route, "route");
        this.f24270a = client;
        this.f24271b = call;
        this.f24272c = routePlanner;
        this.route = route;
        this.routes = list;
        this.f24275f = i;
        this.f24276g = request;
        this.connectionSpecIndex = i2;
        this.isTlsFallback = z;
        this.f24279j = call.getEventListener();
    }

    /* renamed from: c */
    public static ConnectPlan m6612c(ConnectPlan connectPlan, int i, Request request, int i2, boolean z, int i3) {
        if ((i3 & 1) != 0) {
            i = connectPlan.f24275f;
        }
        int i4 = i;
        if ((i3 & 2) != 0) {
            request = connectPlan.f24276g;
        }
        Request request2 = request;
        if ((i3 & 4) != 0) {
            i2 = connectPlan.connectionSpecIndex;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            z = connectPlan.isTlsFallback;
        }
        Route route = connectPlan.getRoute();
        OkHttpClient okHttpClient = connectPlan.f24270a;
        List list = connectPlan.routes;
        return new ConnectPlan(okHttpClient, connectPlan.f24271b, connectPlan.f24272c, route, list, i4, request2, i5, z);
    }

    /* renamed from: a */
    public final void m6613a() {
        int i;
        Socket createSocket;
        Proxy.Type type = getRoute().proxy().type();
        if (type == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        }
        if (i != 1 && i != 2) {
            createSocket = new Socket(getRoute().proxy());
        } else {
            createSocket = getRoute().address().socketFactory().createSocket();
            Intrinsics.checkNotNull(createSocket);
        }
        this.f24281l = createSocket;
        if (!this.f24280k) {
            createSocket.setSoTimeout(this.f24270a.readTimeoutMillis());
            try {
                Platform.INSTANCE.get().connectSocket(createSocket, getRoute().socketAddress(), this.f24270a.connectTimeoutMillis());
                try {
                    this.f24285p = Okio.buffer(Okio.source(createSocket));
                    this.f24286q = Okio.buffer(Okio.sink(createSocket));
                    return;
                } catch (NullPointerException e) {
                    if (!Intrinsics.areEqual(e.getMessage(), "throw with null exception")) {
                        return;
                    } else {
                        throw new IOException(e);
                    }
                }
            } catch (ConnectException e2) {
                ConnectException connectException = new ConnectException("Failed to connect to " + getRoute().socketAddress());
                connectException.initCause(e2);
                throw connectException;
            }
        }
        throw new IOException("canceled");
    }

    /* renamed from: b */
    public final void m6614b(SSLSocket sSLSocket, ConnectionSpec connectionSpec) {
        Protocol protocol;
        Address address = getRoute().address();
        try {
            if (connectionSpec.supportsTlsExtensions()) {
                Platform.INSTANCE.get().configureTlsExtensions(sSLSocket, address.url().host(), address.protocols());
            }
            sSLSocket.startHandshake();
            SSLSession sslSocketSession = sSLSocket.getSession();
            Handshake.Companion companion = Handshake.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(sslSocketSession, "sslSocketSession");
            Handshake handshake = companion.get(sslSocketSession);
            HostnameVerifier hostnameVerifier = address.hostnameVerifier();
            Intrinsics.checkNotNull(hostnameVerifier);
            boolean verify = hostnameVerifier.verify(address.url().host(), sslSocketSession);
            String str = null;
            if (!verify) {
                List<Certificate> peerCertificates = handshake.peerCertificates();
                if (!peerCertificates.isEmpty()) {
                    X509Certificate x509Certificate = (X509Certificate) peerCertificates.get(0);
                    throw new SSLPeerUnverifiedException(mo2.trimMargin$default("\n            |Hostname " + address.url().host() + " not verified:\n            |    certificate: " + CertificatePinner.INSTANCE.pin(x509Certificate) + "\n            |    DN: " + x509Certificate.getSubjectDN().getName() + "\n            |    subjectAltNames: " + OkHostnameVerifier.INSTANCE.allSubjectAltNames(x509Certificate) + "\n            ", null, 1, null));
                }
                throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified (no certificates)");
            }
            CertificatePinner certificatePinner = address.certificatePinner();
            Intrinsics.checkNotNull(certificatePinner);
            Handshake handshake2 = new Handshake(handshake.tlsVersion(), handshake.cipherSuite(), handshake.localCertificates(), new C1950wl(certificatePinner, handshake, address, 1));
            this.f24283n = handshake2;
            certificatePinner.check$okhttp(address.url().host(), new C1829tb(6, handshake2));
            if (connectionSpec.supportsTlsExtensions()) {
                str = Platform.INSTANCE.get().getSelectedProtocol(sSLSocket);
            }
            this.socket = sSLSocket;
            this.f24285p = Okio.buffer(Okio.source(sSLSocket));
            this.f24286q = Okio.buffer(Okio.sink(sSLSocket));
            if (str != null) {
                protocol = Protocol.INSTANCE.get(str);
            } else {
                protocol = Protocol.HTTP_1_1;
            }
            this.f24284o = protocol;
            Platform.INSTANCE.get().afterHandshake(sSLSocket);
        } catch (Throwable th) {
            Platform.INSTANCE.get().afterHandshake(sSLSocket);
            _UtilJvmKt.closeQuietly(sSLSocket);
            throw th;
        }
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan, okhttp3.internal.http.ExchangeCodec.Carrier
    /* renamed from: cancel */
    public void mo9049cancel() {
        this.f24280k = true;
        Socket socket = this.f24281l;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
    }

    public final void closeQuietly() {
        Socket socket = this.socket;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    @NotNull
    /* renamed from: connectTcp */
    public RoutePlanner.ConnectResult getResult() {
        Socket socket;
        Socket socket2;
        if (this.f24281l == null) {
            RealCall realCall = this.f24271b;
            realCall.getPlansToCancel$okhttp().add(this);
            boolean z = false;
            try {
                try {
                    this.f24279j.connectStart(realCall, getRoute().socketAddress(), getRoute().proxy());
                    m6613a();
                    z = true;
                    RoutePlanner.ConnectResult connectResult = new RoutePlanner.ConnectResult(this, null, null, 6, null);
                    realCall.getPlansToCancel$okhttp().remove(this);
                    return connectResult;
                } catch (IOException e) {
                    this.f24279j.connectFailed(this.f24271b, getRoute().socketAddress(), getRoute().proxy(), null, e);
                    RoutePlanner.ConnectResult connectResult2 = new RoutePlanner.ConnectResult(this, null, e, 2, null);
                    realCall.getPlansToCancel$okhttp().remove(this);
                    if (!z && (socket = this.f24281l) != null) {
                        _UtilJvmKt.closeQuietly(socket);
                    }
                    return connectResult2;
                }
            } catch (Throwable th) {
                realCall.getPlansToCancel$okhttp().remove(this);
                if (!z && (socket2 = this.f24281l) != null) {
                    _UtilJvmKt.closeQuietly(socket2);
                }
                throw th;
            }
        }
        throw new IllegalStateException("TCP already connected");
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x019e A[Catch: all -> 0x01a7, TryCatch #4 {all -> 0x01a7, blocks: (B:56:0x017e, B:58:0x019e, B:62:0x01a9), top: B:55:0x017e }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01cf  */
    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    @NotNull
    /* renamed from: connectTlsEtc */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RoutePlanner.ConnectResult mo9054connectTlsEtc() {
        ConnectPlan connectPlan;
        boolean z;
        ConnectPlan connectPlan2;
        BufferedSink bufferedSink;
        Buffer buffer;
        Buffer buffer2;
        OkHttpClient okHttpClient = this.f24270a;
        if (this.f24281l != null) {
            if (!isReady()) {
                List<ConnectionSpec> connectionSpecs = getRoute().address().connectionSpecs();
                RealCall realCall = this.f24271b;
                realCall.getPlansToCancel$okhttp().add(this);
                ConnectPlan connectPlan3 = null;
                try {
                    try {
                        if (this.f24276g != null) {
                            RoutePlanner.ConnectResult connectTunnel$okhttp = connectTunnel$okhttp();
                            if (connectTunnel$okhttp.getNextPlan() != null || connectTunnel$okhttp.getThrowable() != null) {
                                realCall.getPlansToCancel$okhttp().remove(this);
                                Socket socket = this.socket;
                                if (socket != null) {
                                    _UtilJvmKt.closeQuietly(socket);
                                }
                                Socket socket2 = this.f24281l;
                                if (socket2 != null) {
                                    _UtilJvmKt.closeQuietly(socket2);
                                }
                                return connectTunnel$okhttp;
                            }
                        }
                        SSLSocketFactory sslSocketFactory = getRoute().address().sslSocketFactory();
                        EventListener eventListener = this.f24279j;
                        if (sslSocketFactory != null) {
                            BufferedSource bufferedSource = this.f24285p;
                            if ((bufferedSource != null && (buffer2 = bufferedSource.getBuffer()) != null && !buffer2.exhausted()) || ((bufferedSink = this.f24286q) != null && (buffer = bufferedSink.getBuffer()) != null && !buffer.exhausted())) {
                                throw new IOException("TLS tunnel buffered too many bytes!");
                            }
                            eventListener.secureConnectStart(realCall);
                            Socket createSocket = getRoute().address().sslSocketFactory().createSocket(this.f24281l, getRoute().address().url().host(), getRoute().address().url().port(), true);
                            if (createSocket != null) {
                                SSLSocket sSLSocket = (SSLSocket) createSocket;
                                ConnectPlan planWithCurrentOrInitialConnectionSpec$okhttp = planWithCurrentOrInitialConnectionSpec$okhttp(connectionSpecs, sSLSocket);
                                ConnectionSpec connectionSpec = connectionSpecs.get(planWithCurrentOrInitialConnectionSpec$okhttp.connectionSpecIndex);
                                connectPlan = planWithCurrentOrInitialConnectionSpec$okhttp.nextConnectionSpec$okhttp(connectionSpecs, sSLSocket);
                                try {
                                    connectionSpec.apply$okhttp(sSLSocket, planWithCurrentOrInitialConnectionSpec$okhttp.isTlsFallback);
                                    m6614b(sSLSocket, connectionSpec);
                                    eventListener.secureConnectEnd(realCall, this.f24283n);
                                    connectPlan2 = connectPlan;
                                } catch (IOException e) {
                                    e = e;
                                    z = false;
                                    try {
                                        this.f24279j.connectFailed(this.f24271b, getRoute().socketAddress(), getRoute().proxy(), null, e);
                                        if (okHttpClient.retryOnConnectionFailure()) {
                                            connectPlan3 = connectPlan;
                                        }
                                        RoutePlanner.ConnectResult connectResult = new RoutePlanner.ConnectResult(this, connectPlan3, e);
                                        realCall.getPlansToCancel$okhttp().remove(this);
                                        if (!z) {
                                        }
                                        return connectResult;
                                    } catch (Throwable th) {
                                        th = th;
                                        realCall.getPlansToCancel$okhttp().remove(this);
                                        if (!z) {
                                            Socket socket3 = this.socket;
                                            if (socket3 != null) {
                                                _UtilJvmKt.closeQuietly(socket3);
                                            }
                                            Socket socket4 = this.f24281l;
                                            if (socket4 != null) {
                                                _UtilJvmKt.closeQuietly(socket4);
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
                            }
                        } else {
                            this.socket = this.f24281l;
                            List<Protocol> protocols = getRoute().address().protocols();
                            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
                            if (!protocols.contains(protocol)) {
                                protocol = Protocol.HTTP_1_1;
                            }
                            this.f24284o = protocol;
                            connectPlan2 = null;
                        }
                        try {
                            RealConnection realConnection = new RealConnection(okHttpClient.getTaskRunner(), okHttpClient.connectionPool().getDelegate(), getRoute(), this.f24281l, this.socket, this.f24283n, this.f24284o, this.f24285p, this.f24286q, okHttpClient.pingIntervalMillis());
                            this.f24287r = realConnection;
                            realConnection.start();
                            eventListener.connectEnd(realCall, getRoute().socketAddress(), getRoute().proxy(), this.f24284o);
                        } catch (IOException e2) {
                            e = e2;
                            connectPlan = connectPlan2;
                            z = false;
                            this.f24279j.connectFailed(this.f24271b, getRoute().socketAddress(), getRoute().proxy(), null, e);
                            if (okHttpClient.retryOnConnectionFailure() && TlsHandshakeKt.retryTlsHandshake(e)) {
                                connectPlan3 = connectPlan;
                            }
                            RoutePlanner.ConnectResult connectResult2 = new RoutePlanner.ConnectResult(this, connectPlan3, e);
                            realCall.getPlansToCancel$okhttp().remove(this);
                            if (!z) {
                                Socket socket5 = this.socket;
                                if (socket5 != null) {
                                    _UtilJvmKt.closeQuietly(socket5);
                                }
                                Socket socket6 = this.f24281l;
                                if (socket6 != null) {
                                    _UtilJvmKt.closeQuietly(socket6);
                                }
                            }
                            return connectResult2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z = false;
                    }
                } catch (IOException e3) {
                    e = e3;
                    connectPlan = null;
                }
                try {
                    RoutePlanner.ConnectResult connectResult3 = new RoutePlanner.ConnectResult(this, null, null, 6, null);
                    realCall.getPlansToCancel$okhttp().remove(this);
                    return connectResult3;
                } catch (IOException e4) {
                    e = e4;
                    z = true;
                    connectPlan = connectPlan2;
                    this.f24279j.connectFailed(this.f24271b, getRoute().socketAddress(), getRoute().proxy(), null, e);
                    if (okHttpClient.retryOnConnectionFailure()) {
                    }
                    RoutePlanner.ConnectResult connectResult22 = new RoutePlanner.ConnectResult(this, connectPlan3, e);
                    realCall.getPlansToCancel$okhttp().remove(this);
                    if (!z) {
                    }
                    return connectResult22;
                } catch (Throwable th3) {
                    th = th3;
                    z = true;
                    realCall.getPlansToCancel$okhttp().remove(this);
                    if (!z) {
                    }
                    throw th;
                }
            }
            throw new IllegalStateException("already connected");
        }
        throw new IllegalStateException("TCP not connected");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00c8, code lost:
    
        if (r4 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00d5, code lost:
    
        return new okhttp3.internal.connection.RoutePlanner.ConnectResult(r13, null, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00d6, code lost:
    
        r0 = r13.f24281l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00d8, code lost:
    
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00da, code lost:
    
        okhttp3.internal._UtilJvmKt.closeQuietly(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00dd, code lost:
    
        r3 = 1 + r13.f24275f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00e2, code lost:
    
        if (r3 >= 21) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00e4, code lost:
    
        r13.f24279j.connectEnd(r13.f24271b, getRoute().socketAddress(), getRoute().proxy(), null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x010e, code lost:
    
        return new okhttp3.internal.connection.RoutePlanner.ConnectResult(r13, m6612c(r13, r3, r4, 0, false, 12), null, 4, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x010f, code lost:
    
        r0 = new java.net.ProtocolException("Too many tunnel connections attempted: 21");
        r13.f24279j.connectFailed(r13.f24271b, getRoute().socketAddress(), getRoute().proxy(), null, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x013a, code lost:
    
        return new okhttp3.internal.connection.RoutePlanner.ConnectResult(r13, null, r0, 2, null);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final RoutePlanner.ConnectResult connectTunnel$okhttp() {
        Request request;
        Request request2 = this.f24276g;
        Intrinsics.checkNotNull(request2);
        String str = "CONNECT " + _UtilJvmKt.toHostHeader(getRoute().address().url(), true) + " HTTP/1.1";
        while (true) {
            BufferedSource bufferedSource = this.f24285p;
            Intrinsics.checkNotNull(bufferedSource);
            BufferedSink bufferedSink = this.f24286q;
            Intrinsics.checkNotNull(bufferedSink);
            Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec(null, this, bufferedSource, bufferedSink);
            Timeout f24243a = bufferedSource.getF24243a();
            long readTimeoutMillis = this.f24270a.readTimeoutMillis();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            f24243a.timeout(readTimeoutMillis, timeUnit);
            bufferedSink.getF24748a().timeout(r7.writeTimeoutMillis(), timeUnit);
            http1ExchangeCodec.writeRequest(request2.headers(), str);
            http1ExchangeCodec.finishRequest();
            Response.Builder readResponseHeaders = http1ExchangeCodec.readResponseHeaders(false);
            Intrinsics.checkNotNull(readResponseHeaders);
            Response build = readResponseHeaders.request(request2).build();
            http1ExchangeCodec.skipConnectBody(build);
            int code = build.code();
            if (code != 200) {
                if (code == 407) {
                    Request authenticate = getRoute().address().proxyAuthenticator().authenticate(getRoute(), build);
                    if (authenticate != null) {
                        if (ro2.equals("close", Response.header$default(build, HttpHeaders.CONNECTION, null, 2, null), true)) {
                            request = authenticate;
                            break;
                        }
                        request2 = authenticate;
                    } else {
                        throw new IOException("Failed to authenticate with proxy");
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + build.code());
                }
            } else {
                request = null;
                break;
            }
        }
    }

    /* renamed from: getConnectionSpecIndex$okhttp, reason: from getter */
    public final int getConnectionSpecIndex() {
        return this.connectionSpecIndex;
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    @NotNull
    public Route getRoute() {
        return this.route;
    }

    @Nullable
    public final List<Route> getRoutes$okhttp() {
        return this.routes;
    }

    @Nullable
    /* renamed from: getSocket$okhttp, reason: from getter */
    public final Socket getSocket() {
        return this.socket;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    @NotNull
    /* renamed from: handleSuccess */
    public RealConnection mo9050handleSuccess() {
        this.f24271b.getClient().getRouteDatabase().connected(getRoute());
        ReusePlan planReusePooledConnection$okhttp = this.f24272c.planReusePooledConnection$okhttp(this, this.routes);
        if (planReusePooledConnection$okhttp != null) {
            return planReusePooledConnection$okhttp.getConnection();
        }
        RealConnection realConnection = this.f24287r;
        Intrinsics.checkNotNull(realConnection);
        synchronized (realConnection) {
            this.f24270a.connectionPool().getDelegate().put(realConnection);
            this.f24271b.acquireConnectionNoEvents(realConnection);
        }
        this.f24279j.connectionAcquired(this.f24271b, realConnection);
        return realConnection;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public boolean isReady() {
        if (this.f24284o != null) {
            return true;
        }
        return false;
    }

    /* renamed from: isTlsFallback$okhttp, reason: from getter */
    public final boolean getIsTlsFallback() {
        return this.isTlsFallback;
    }

    @Nullable
    public final ConnectPlan nextConnectionSpec$okhttp(@NotNull List<ConnectionSpec> connectionSpecs, @NotNull SSLSocket sslSocket) {
        boolean z;
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        int i = this.connectionSpecIndex;
        int size = connectionSpecs.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (connectionSpecs.get(i2).isCompatible(sslSocket)) {
                if (i != -1) {
                    z = true;
                } else {
                    z = false;
                }
                return m6612c(this, 0, null, i2, z, 3);
            }
        }
        return null;
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public void noNewExchanges() {
    }

    @NotNull
    public final ConnectPlan planWithCurrentOrInitialConnectionSpec$okhttp(@NotNull List<ConnectionSpec> connectionSpecs, @NotNull SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        if (this.connectionSpecIndex != -1) {
            return this;
        }
        ConnectPlan nextConnectionSpec$okhttp = nextConnectionSpec$okhttp(connectionSpecs, sslSocket);
        if (nextConnectionSpec$okhttp != null) {
            return nextConnectionSpec$okhttp;
        }
        StringBuilder sb = new StringBuilder("Unable to find acceptable protocols. isFallback=");
        sb.append(this.isTlsFallback);
        sb.append(", modes=");
        sb.append(connectionSpecs);
        sb.append(", supported protocols=");
        String[] enabledProtocols = sslSocket.getEnabledProtocols();
        Intrinsics.checkNotNull(enabledProtocols);
        String arrays = Arrays.toString(enabledProtocols);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        sb.append(arrays);
        throw new UnknownServiceException(sb.toString());
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    @NotNull
    /* renamed from: retry */
    public RoutePlanner.Plan mo9051retry() {
        return new ConnectPlan(this.f24270a, this.f24271b, this.f24272c, getRoute(), this.routes, this.f24275f, this.f24276g, this.connectionSpecIndex, this.isTlsFallback);
    }

    public final void setSocket$okhttp(@Nullable Socket socket) {
        this.socket = socket;
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public void trackFailure(@NotNull RealCall call, @Nullable IOException e) {
        Intrinsics.checkNotNullParameter(call, "call");
    }
}
