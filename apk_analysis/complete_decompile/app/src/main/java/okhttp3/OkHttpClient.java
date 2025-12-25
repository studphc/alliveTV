package okhttp3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.net.Proxy;
import java.net.ProxySelector;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.WebSocket;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1327iq;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 °\u00012\u00020\u00012\u00020\u0002:\u0004±\u0001°\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u001b\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007¢\u0006\u0004\b!\u0010\u001fJ\u000f\u0010&\u001a\u00020#H\u0007¢\u0006\u0004\b$\u0010%J\u000f\u0010*\u001a\u00020'H\u0007¢\u0006\u0004\b(\u0010)J\u000f\u0010.\u001a\u00020+H\u0007¢\u0006\u0004\b,\u0010-J\u000f\u00100\u001a\u00020'H\u0007¢\u0006\u0004\b/\u0010)J\u000f\u00102\u001a\u00020'H\u0007¢\u0006\u0004\b1\u0010)J\u000f\u00106\u001a\u000203H\u0007¢\u0006\u0004\b4\u00105J\u0011\u0010:\u001a\u0004\u0018\u000107H\u0007¢\u0006\u0004\b8\u00109J\u000f\u0010>\u001a\u00020;H\u0007¢\u0006\u0004\b<\u0010=J\u0011\u0010B\u001a\u0004\u0018\u00010?H\u0007¢\u0006\u0004\b@\u0010AJ\u000f\u0010F\u001a\u00020CH\u0007¢\u0006\u0004\bD\u0010EJ\u000f\u0010H\u001a\u00020+H\u0007¢\u0006\u0004\bG\u0010-J\u000f\u0010L\u001a\u00020IH\u0007¢\u0006\u0004\bJ\u0010KJ\u000f\u0010P\u001a\u00020MH\u0007¢\u0006\u0004\bN\u0010OJ\u0015\u0010S\u001a\b\u0012\u0004\u0012\u00020Q0\u001cH\u0007¢\u0006\u0004\bR\u0010\u001fJ\u0015\u0010V\u001a\b\u0012\u0004\u0012\u00020T0\u001cH\u0007¢\u0006\u0004\bU\u0010\u001fJ\u000f\u0010Z\u001a\u00020WH\u0007¢\u0006\u0004\bX\u0010YJ\u000f\u0010^\u001a\u00020[H\u0007¢\u0006\u0004\b\\\u0010]J\u000f\u0010b\u001a\u00020_H\u0007¢\u0006\u0004\b`\u0010aJ\u000f\u0010d\u001a\u00020_H\u0007¢\u0006\u0004\bc\u0010aJ\u000f\u0010f\u001a\u00020_H\u0007¢\u0006\u0004\be\u0010aJ\u000f\u0010h\u001a\u00020_H\u0007¢\u0006\u0004\bg\u0010aJ\u000f\u0010j\u001a\u00020_H\u0007¢\u0006\u0004\bi\u0010aR\u0017\u0010\u0017\u001a\u00020\u00148G¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00188G¢\u0006\f\n\u0004\bm\u0010n\u001a\u0004\b\u001b\u0010\u001aR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8G¢\u0006\f\n\u0004\bo\u0010p\u001a\u0004\b \u0010\u001fR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8G¢\u0006\f\n\u0004\bq\u0010p\u001a\u0004\b\"\u0010\u001fR\u0017\u0010&\u001a\u00020#8G¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\b&\u0010%R\u0017\u0010*\u001a\u00020'8G¢\u0006\f\n\u0004\bt\u0010u\u001a\u0004\b*\u0010)R\u0017\u0010w\u001a\u00020'8G¢\u0006\f\n\u0004\bv\u0010u\u001a\u0004\bw\u0010)R\u0017\u0010.\u001a\u00020+8G¢\u0006\f\n\u0004\bx\u0010y\u001a\u0004\b.\u0010-R\u0017\u00100\u001a\u00020'8G¢\u0006\f\n\u0004\bz\u0010u\u001a\u0004\b0\u0010)R\u0017\u00102\u001a\u00020'8G¢\u0006\f\n\u0004\b{\u0010u\u001a\u0004\b2\u0010)R\u0017\u00106\u001a\u0002038G¢\u0006\f\n\u0004\b|\u0010}\u001a\u0004\b6\u00105R\u0019\u0010:\u001a\u0004\u0018\u0001078G¢\u0006\f\n\u0004\b~\u0010\u007f\u001a\u0004\b:\u00109R\u0019\u0010>\u001a\u00020;8G¢\u0006\u000e\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0004\b>\u0010=R\u001b\u0010B\u001a\u0004\u0018\u00010?8G¢\u0006\u000e\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0004\bB\u0010AR\u0019\u0010F\u001a\u00020C8G¢\u0006\u000e\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0004\bF\u0010ER\u0018\u0010H\u001a\u00020+8G¢\u0006\r\n\u0005\b\u0086\u0001\u0010y\u001a\u0004\bH\u0010-R\u0019\u0010L\u001a\u00020I8G¢\u0006\u000e\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0004\bL\u0010KR\u001f\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0089\u00018G¢\u0006\u0010\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001e\u0010S\u001a\b\u0012\u0004\u0012\u00020Q0\u001c8G¢\u0006\r\n\u0005\b\u008e\u0001\u0010p\u001a\u0004\bS\u0010\u001fR\u001e\u0010V\u001a\b\u0012\u0004\u0012\u00020T0\u001c8G¢\u0006\r\n\u0005\b\u008f\u0001\u0010p\u001a\u0004\bV\u0010\u001fR\u0019\u0010Z\u001a\u00020W8G¢\u0006\u000e\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0004\bZ\u0010YR\u0019\u0010^\u001a\u00020[8G¢\u0006\u000e\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0004\b^\u0010]R\u001f\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0094\u00018G¢\u0006\u0010\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0019\u0010b\u001a\u00020_8G¢\u0006\u000e\n\u0006\b\u0099\u0001\u0010\u009a\u0001\u001a\u0004\bb\u0010aR\u0019\u0010d\u001a\u00020_8G¢\u0006\u000e\n\u0006\b\u009b\u0001\u0010\u009a\u0001\u001a\u0004\bd\u0010aR\u0019\u0010f\u001a\u00020_8G¢\u0006\u000e\n\u0006\b\u009c\u0001\u0010\u009a\u0001\u001a\u0004\bf\u0010aR\u0019\u0010h\u001a\u00020_8G¢\u0006\u000e\n\u0006\b\u009d\u0001\u0010\u009a\u0001\u001a\u0004\bh\u0010aR\u0019\u0010j\u001a\u00020_8G¢\u0006\u000e\n\u0006\b\u009e\u0001\u0010\u009a\u0001\u001a\u0004\bj\u0010aR\u001d\u0010¢\u0001\u001a\u00030\u009f\u00018G¢\u0006\u0010\n\u0006\b \u0001\u0010¡\u0001\u001a\u0006\b¢\u0001\u0010£\u0001R \u0010©\u0001\u001a\u00030¤\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001R \u0010¯\u0001\u001a\u00030ª\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0006\b\u00ad\u0001\u0010®\u0001R\u0011\u0010P\u001a\u00020M8G¢\u0006\u0006\u001a\u0004\bP\u0010O¨\u0006²\u0001"}, m5569d2 = {"Lokhttp3/OkHttpClient;", "Lokhttp3/Call$Factory;", "Lokhttp3/WebSocket$Factory;", "Lokhttp3/OkHttpClient$Builder;", "builder", "<init>", "(Lokhttp3/OkHttpClient$Builder;)V", "()V", "Lokhttp3/Request;", "request", "Lokhttp3/Call;", "newCall", "(Lokhttp3/Request;)Lokhttp3/Call;", "Lokhttp3/WebSocketListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lokhttp3/WebSocket;", "newWebSocket", "(Lokhttp3/Request;Lokhttp3/WebSocketListener;)Lokhttp3/WebSocket;", "newBuilder", "()Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Dispatcher;", "-deprecated_dispatcher", "()Lokhttp3/Dispatcher;", "dispatcher", "Lokhttp3/ConnectionPool;", "-deprecated_connectionPool", "()Lokhttp3/ConnectionPool;", "connectionPool", "", "Lokhttp3/Interceptor;", "-deprecated_interceptors", "()Ljava/util/List;", "interceptors", "-deprecated_networkInterceptors", "networkInterceptors", "Lokhttp3/EventListener$Factory;", "-deprecated_eventListenerFactory", "()Lokhttp3/EventListener$Factory;", "eventListenerFactory", "", "-deprecated_retryOnConnectionFailure", "()Z", "retryOnConnectionFailure", "Lokhttp3/Authenticator;", "-deprecated_authenticator", "()Lokhttp3/Authenticator;", "authenticator", "-deprecated_followRedirects", "followRedirects", "-deprecated_followSslRedirects", "followSslRedirects", "Lokhttp3/CookieJar;", "-deprecated_cookieJar", "()Lokhttp3/CookieJar;", "cookieJar", "Lokhttp3/Cache;", "-deprecated_cache", "()Lokhttp3/Cache;", "cache", "Lokhttp3/Dns;", "-deprecated_dns", "()Lokhttp3/Dns;", "dns", "Ljava/net/Proxy;", "-deprecated_proxy", "()Ljava/net/Proxy;", "proxy", "Ljava/net/ProxySelector;", "-deprecated_proxySelector", "()Ljava/net/ProxySelector;", "proxySelector", "-deprecated_proxyAuthenticator", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "-deprecated_socketFactory", "()Ljavax/net/SocketFactory;", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "-deprecated_sslSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Lokhttp3/ConnectionSpec;", "-deprecated_connectionSpecs", "connectionSpecs", "Lokhttp3/Protocol;", "-deprecated_protocols", "protocols", "Ljavax/net/ssl/HostnameVerifier;", "-deprecated_hostnameVerifier", "()Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Lokhttp3/CertificatePinner;", "-deprecated_certificatePinner", "()Lokhttp3/CertificatePinner;", "certificatePinner", "", "-deprecated_callTimeoutMillis", "()I", "callTimeoutMillis", "-deprecated_connectTimeoutMillis", "connectTimeoutMillis", "-deprecated_readTimeoutMillis", "readTimeoutMillis", "-deprecated_writeTimeoutMillis", "writeTimeoutMillis", "-deprecated_pingIntervalMillis", "pingIntervalMillis", "a", "Lokhttp3/Dispatcher;", "b", "Lokhttp3/ConnectionPool;", "c", "Ljava/util/List;", "d", "e", "Lokhttp3/EventListener$Factory;", "f", "Z", "g", "fastFallback", "h", "Lokhttp3/Authenticator;", "i", "j", "k", "Lokhttp3/CookieJar;", "l", "Lokhttp3/Cache;", "m", "Lokhttp3/Dns;", "n", "Ljava/net/Proxy;", "o", "Ljava/net/ProxySelector;", "p", "q", "Ljavax/net/SocketFactory;", "Ljavax/net/ssl/X509TrustManager;", "s", "Ljavax/net/ssl/X509TrustManager;", "x509TrustManager", "()Ljavax/net/ssl/X509TrustManager;", "t", "u", "v", "Ljavax/net/ssl/HostnameVerifier;", "w", "Lokhttp3/CertificatePinner;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "x", "Lokhttp3/internal/tls/CertificateChainCleaner;", "certificateChainCleaner", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "y", "I", "z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "", "D", "J", "minWebSocketMessageToCompress", "()J", "Lokhttp3/internal/connection/RouteDatabase;", ExifInterface.LONGITUDE_EAST, "Lokhttp3/internal/connection/RouteDatabase;", "getRouteDatabase$okhttp", "()Lokhttp3/internal/connection/RouteDatabase;", "routeDatabase", "Lokhttp3/internal/concurrent/TaskRunner;", "F", "Lokhttp3/internal/concurrent/TaskRunner;", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "Companion", "Builder", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public class OkHttpClient implements Call.Factory, WebSocket.Factory {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: G */
    public static final List f24008G = _UtilJvmKt.immutableListOf(Protocol.HTTP_2, Protocol.HTTP_1_1);

    /* renamed from: H */
    public static final List f24009H = _UtilJvmKt.immutableListOf(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT);

    /* renamed from: A, reason: from kotlin metadata */
    public final int readTimeoutMillis;

    /* renamed from: B, reason: from kotlin metadata */
    public final int writeTimeoutMillis;

    /* renamed from: C, reason: from kotlin metadata */
    public final int pingIntervalMillis;

    /* renamed from: D, reason: from kotlin metadata */
    public final long minWebSocketMessageToCompress;

    /* renamed from: E, reason: from kotlin metadata */
    public final RouteDatabase routeDatabase;

    /* renamed from: F, reason: from kotlin metadata */
    public final TaskRunner taskRunner;

    /* renamed from: a, reason: from kotlin metadata */
    public final Dispatcher dispatcher;

    /* renamed from: b, reason: from kotlin metadata */
    public final ConnectionPool connectionPool;

    /* renamed from: c, reason: from kotlin metadata */
    public final List interceptors;

    /* renamed from: d, reason: from kotlin metadata */
    public final List networkInterceptors;

    /* renamed from: e, reason: from kotlin metadata */
    public final EventListener.Factory eventListenerFactory;

    /* renamed from: f, reason: from kotlin metadata */
    public final boolean retryOnConnectionFailure;

    /* renamed from: g, reason: from kotlin metadata */
    public final boolean fastFallback;

    /* renamed from: h, reason: from kotlin metadata */
    public final Authenticator authenticator;

    /* renamed from: i, reason: from kotlin metadata */
    public final boolean followRedirects;

    /* renamed from: j, reason: from kotlin metadata */
    public final boolean followSslRedirects;

    /* renamed from: k, reason: from kotlin metadata */
    public final CookieJar cookieJar;

    /* renamed from: l, reason: from kotlin metadata */
    public final Cache cache;

    /* renamed from: m, reason: from kotlin metadata */
    public final Dns dns;

    /* renamed from: n, reason: from kotlin metadata */
    public final Proxy proxy;

    /* renamed from: o, reason: from kotlin metadata */
    public final ProxySelector proxySelector;

    /* renamed from: p, reason: from kotlin metadata */
    public final Authenticator proxyAuthenticator;

    /* renamed from: q, reason: from kotlin metadata */
    public final SocketFactory socketFactory;

    /* renamed from: r */
    public final SSLSocketFactory f24033r;

    /* renamed from: s, reason: from kotlin metadata */
    public final X509TrustManager x509TrustManager;

    /* renamed from: t, reason: from kotlin metadata */
    public final List connectionSpecs;

    /* renamed from: u, reason: from kotlin metadata */
    public final List protocols;

    /* renamed from: v, reason: from kotlin metadata */
    public final HostnameVerifier hostnameVerifier;

    /* renamed from: w, reason: from kotlin metadata */
    public final CertificatePinner certificatePinner;

    /* renamed from: x, reason: from kotlin metadata */
    public final CertificateChainCleaner certificateChainCleaner;

    /* renamed from: y, reason: from kotlin metadata */
    public final int callTimeoutMillis;

    /* renamed from: z, reason: from kotlin metadata */
    public final int connectTimeoutMillis;

    @Metadata(m5568d1 = {"\u0000\u0081\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0003\b\u0080\u0001\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J8\u0010\u0012\u001a\u00020\u00002#\b\u0004\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00190\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u001d\u0010\u0010J\u0015\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u001e\u0010\u0013J8\u0010\u001e\u001a\u00020\u00002#\b\u0004\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00190\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001cJ\u0015\u0010!\u001a\u00020\u00002\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\u00002\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020&¢\u0006\u0004\b)\u0010(J\u0015\u0010+\u001a\u00020\u00002\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b+\u0010,J\u0015\u0010-\u001a\u00020\u00002\u0006\u0010-\u001a\u00020&¢\u0006\u0004\b-\u0010(J\u0015\u0010/\u001a\u00020\u00002\u0006\u0010.\u001a\u00020&¢\u0006\u0004\b/\u0010(J\u0015\u00101\u001a\u00020\u00002\u0006\u00101\u001a\u000200¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\b4\u00105J\u0015\u00107\u001a\u00020\u00002\u0006\u00107\u001a\u000206¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u00020\u00002\b\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b:\u0010;J\u0015\u0010=\u001a\u00020\u00002\u0006\u0010=\u001a\u00020<¢\u0006\u0004\b=\u0010>J\u0015\u0010?\u001a\u00020\u00002\u0006\u0010?\u001a\u00020*¢\u0006\u0004\b?\u0010,J\u0015\u0010A\u001a\u00020\u00002\u0006\u0010A\u001a\u00020@¢\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001a\u00020\u00002\u0006\u0010D\u001a\u00020CH\u0007¢\u0006\u0004\bD\u0010EJ\u001d\u0010D\u001a\u00020\u00002\u0006\u0010D\u001a\u00020C2\u0006\u0010G\u001a\u00020F¢\u0006\u0004\bD\u0010HJ\u001b\u0010K\u001a\u00020\u00002\f\u0010K\u001a\b\u0012\u0004\u0012\u00020J0I¢\u0006\u0004\bK\u0010LJ\u001b\u0010N\u001a\u00020\u00002\f\u0010N\u001a\b\u0012\u0004\u0012\u00020M0I¢\u0006\u0004\bN\u0010LJ\u0015\u0010P\u001a\u00020\u00002\u0006\u0010P\u001a\u00020O¢\u0006\u0004\bP\u0010QJ\u0015\u0010S\u001a\u00020\u00002\u0006\u0010S\u001a\u00020R¢\u0006\u0004\bS\u0010TJ\u001d\u0010Y\u001a\u00020\u00002\u0006\u0010V\u001a\u00020U2\u0006\u0010X\u001a\u00020W¢\u0006\u0004\bY\u0010ZJ\u0017\u0010Y\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020[H\u0007¢\u0006\u0004\bY\u0010]J\u001d\u0010^\u001a\u00020\u00002\u0006\u0010V\u001a\u00020U2\u0006\u0010X\u001a\u00020W¢\u0006\u0004\b^\u0010ZJ\u0017\u0010^\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020[H\u0007¢\u0006\u0004\b^\u0010]J\u001d\u0010_\u001a\u00020\u00002\u0006\u0010V\u001a\u00020U2\u0006\u0010X\u001a\u00020W¢\u0006\u0004\b_\u0010ZJ\u0017\u0010_\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020[H\u0007¢\u0006\u0004\b_\u0010]J\u001d\u0010`\u001a\u00020\u00002\u0006\u0010V\u001a\u00020U2\u0006\u0010X\u001a\u00020W¢\u0006\u0004\b`\u0010ZJ\u0017\u0010`\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020[H\u0007¢\u0006\u0004\b`\u0010]J\u001d\u0010b\u001a\u00020\u00002\u0006\u0010a\u001a\u00020U2\u0006\u0010X\u001a\u00020W¢\u0006\u0004\bb\u0010ZJ\u0017\u0010b\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020[H\u0007¢\u0006\u0004\bb\u0010]J\u0015\u0010d\u001a\u00020\u00002\u0006\u0010c\u001a\u00020U¢\u0006\u0004\bd\u0010eJ\r\u0010f\u001a\u00020\u0004¢\u0006\u0004\bf\u0010gR\"\u0010\b\u001a\u00020\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010\u000b\u001a\u00020\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bt\u0010u\u001a\u0004\bv\u0010\u0010R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bw\u0010u\u001a\u0004\bx\u0010\u0010R\"\u0010$\u001a\u00020#8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\by\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R'\u0010'\u001a\u00020&8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R(\u0010)\u001a\u00020&8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0080\u0001\u001a\u0006\b\u0086\u0001\u0010\u0082\u0001\"\u0006\b\u0087\u0001\u0010\u0084\u0001R(\u0010+\u001a\u00020*8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R(\u0010-\u001a\u00020&8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u0080\u0001\u001a\u0006\b\u008f\u0001\u0010\u0082\u0001\"\u0006\b\u0090\u0001\u0010\u0084\u0001R(\u0010/\u001a\u00020&8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0080\u0001\u001a\u0006\b\u0092\u0001\u0010\u0082\u0001\"\u0006\b\u0093\u0001\u0010\u0084\u0001R(\u00101\u001a\u0002008\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R*\u00104\u001a\u0004\u0018\u0001038\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R(\u00107\u001a\u0002068\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b \u0001\u0010¡\u0001\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001R*\u0010:\u001a\u0004\u0018\u0001098\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b¦\u0001\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R*\u0010=\u001a\u0004\u0018\u00010<8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b¬\u0001\u0010\u00ad\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R(\u0010?\u001a\u00020*8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b²\u0001\u0010\u0089\u0001\u001a\u0006\b³\u0001\u0010\u008b\u0001\"\u0006\b´\u0001\u0010\u008d\u0001R(\u0010A\u001a\u00020@8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bµ\u0001\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R+\u0010Á\u0001\u001a\u0004\u0018\u00010C8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b»\u0001\u0010¼\u0001\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001R+\u0010È\u0001\u001a\u0004\u0018\u00010F8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÂ\u0001\u0010Ã\u0001\u001a\u0006\bÄ\u0001\u0010Å\u0001\"\u0006\bÆ\u0001\u0010Ç\u0001R,\u0010K\u001a\b\u0012\u0004\u0012\u00020J0I8\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0005\bÉ\u0001\u0010u\u001a\u0005\bÊ\u0001\u0010\u0010\"\u0006\bË\u0001\u0010Ì\u0001R,\u0010N\u001a\b\u0012\u0004\u0012\u00020M0I8\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0005\bÍ\u0001\u0010u\u001a\u0005\bÎ\u0001\u0010\u0010\"\u0006\bÏ\u0001\u0010Ì\u0001R(\u0010P\u001a\u00020O8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÐ\u0001\u0010Ñ\u0001\u001a\u0006\bÒ\u0001\u0010Ó\u0001\"\u0006\bÔ\u0001\u0010Õ\u0001R(\u0010S\u001a\u00020R8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÖ\u0001\u0010×\u0001\u001a\u0006\bØ\u0001\u0010Ù\u0001\"\u0006\bÚ\u0001\u0010Û\u0001R,\u0010ã\u0001\u001a\u0005\u0018\u00010Ü\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÝ\u0001\u0010Þ\u0001\u001a\u0006\bß\u0001\u0010à\u0001\"\u0006\bá\u0001\u0010â\u0001R)\u0010Y\u001a\u00030ä\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bå\u0001\u0010æ\u0001\u001a\u0006\bç\u0001\u0010è\u0001\"\u0006\bé\u0001\u0010ê\u0001R)\u0010^\u001a\u00030ä\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bë\u0001\u0010æ\u0001\u001a\u0006\bì\u0001\u0010è\u0001\"\u0006\bí\u0001\u0010ê\u0001R)\u0010_\u001a\u00030ä\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bî\u0001\u0010æ\u0001\u001a\u0006\bï\u0001\u0010è\u0001\"\u0006\bð\u0001\u0010ê\u0001R)\u0010`\u001a\u00030ä\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bñ\u0001\u0010æ\u0001\u001a\u0006\bò\u0001\u0010è\u0001\"\u0006\bó\u0001\u0010ê\u0001R)\u0010b\u001a\u00030ä\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bô\u0001\u0010æ\u0001\u001a\u0006\bõ\u0001\u0010è\u0001\"\u0006\bö\u0001\u0010ê\u0001R(\u0010d\u001a\u00020U8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b÷\u0001\u0010ø\u0001\u001a\u0006\bù\u0001\u0010ú\u0001\"\u0006\bû\u0001\u0010ü\u0001R,\u0010\u0084\u0002\u001a\u0005\u0018\u00010ý\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bþ\u0001\u0010ÿ\u0001\u001a\u0006\b\u0080\u0002\u0010\u0081\u0002\"\u0006\b\u0082\u0002\u0010\u0083\u0002R,\u0010\u008c\u0002\u001a\u0005\u0018\u00010\u0085\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0086\u0002\u0010\u0087\u0002\u001a\u0006\b\u0088\u0002\u0010\u0089\u0002\"\u0006\b\u008a\u0002\u0010\u008b\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u008d\u0002"}, m5569d2 = {"Lokhttp3/OkHttpClient$Builder;", "", "<init>", "()V", "Lokhttp3/OkHttpClient;", "okHttpClient", "(Lokhttp3/OkHttpClient;)V", "Lokhttp3/Dispatcher;", "dispatcher", "(Lokhttp3/Dispatcher;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/ConnectionPool;", "connectionPool", "(Lokhttp3/ConnectionPool;)Lokhttp3/OkHttpClient$Builder;", "", "Lokhttp3/Interceptor;", "interceptors", "()Ljava/util/List;", "interceptor", "addInterceptor", "(Lokhttp3/Interceptor;)Lokhttp3/OkHttpClient$Builder;", "Lkotlin/Function1;", "Lokhttp3/Interceptor$Chain;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "chain", "Lokhttp3/Response;", "block", "-addInterceptor", "(Lkotlin/jvm/functions/Function1;)Lokhttp3/OkHttpClient$Builder;", "networkInterceptors", "addNetworkInterceptor", "-addNetworkInterceptor", "Lokhttp3/EventListener;", "eventListener", "(Lokhttp3/EventListener;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/EventListener$Factory;", "eventListenerFactory", "(Lokhttp3/EventListener$Factory;)Lokhttp3/OkHttpClient$Builder;", "", "retryOnConnectionFailure", "(Z)Lokhttp3/OkHttpClient$Builder;", "fastFallback", "Lokhttp3/Authenticator;", "authenticator", "(Lokhttp3/Authenticator;)Lokhttp3/OkHttpClient$Builder;", "followRedirects", "followProtocolRedirects", "followSslRedirects", "Lokhttp3/CookieJar;", "cookieJar", "(Lokhttp3/CookieJar;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Cache;", "cache", "(Lokhttp3/Cache;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Dns;", "dns", "(Lokhttp3/Dns;)Lokhttp3/OkHttpClient$Builder;", "Ljava/net/Proxy;", "proxy", "(Ljava/net/Proxy;)Lokhttp3/OkHttpClient$Builder;", "Ljava/net/ProxySelector;", "proxySelector", "(Ljava/net/ProxySelector;)Lokhttp3/OkHttpClient$Builder;", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "socketFactory", "(Ljavax/net/SocketFactory;)Lokhttp3/OkHttpClient$Builder;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "(Ljavax/net/ssl/SSLSocketFactory;)Lokhttp3/OkHttpClient$Builder;", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/X509TrustManager;)Lokhttp3/OkHttpClient$Builder;", "", "Lokhttp3/ConnectionSpec;", "connectionSpecs", "(Ljava/util/List;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Protocol;", "protocols", "Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "(Ljavax/net/ssl/HostnameVerifier;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/CertificatePinner;", "certificatePinner", "(Lokhttp3/CertificatePinner;)Lokhttp3/OkHttpClient$Builder;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "callTimeout", "(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;", "Ljava/time/Duration;", TypedValues.TransitionType.S_DURATION, "(Ljava/time/Duration;)Lokhttp3/OkHttpClient$Builder;", "connectTimeout", "readTimeout", "writeTimeout", "interval", "pingInterval", "bytes", "minWebSocketMessageToCompress", "(J)Lokhttp3/OkHttpClient$Builder;", "build", "()Lokhttp3/OkHttpClient;", "a", "Lokhttp3/Dispatcher;", "getDispatcher$okhttp", "()Lokhttp3/Dispatcher;", "setDispatcher$okhttp", "(Lokhttp3/Dispatcher;)V", "b", "Lokhttp3/ConnectionPool;", "getConnectionPool$okhttp", "()Lokhttp3/ConnectionPool;", "setConnectionPool$okhttp", "(Lokhttp3/ConnectionPool;)V", "c", "Ljava/util/List;", "getInterceptors$okhttp", "d", "getNetworkInterceptors$okhttp", "e", "Lokhttp3/EventListener$Factory;", "getEventListenerFactory$okhttp", "()Lokhttp3/EventListener$Factory;", "setEventListenerFactory$okhttp", "(Lokhttp3/EventListener$Factory;)V", "f", "Z", "getRetryOnConnectionFailure$okhttp", "()Z", "setRetryOnConnectionFailure$okhttp", "(Z)V", "g", "getFastFallback$okhttp", "setFastFallback$okhttp", "h", "Lokhttp3/Authenticator;", "getAuthenticator$okhttp", "()Lokhttp3/Authenticator;", "setAuthenticator$okhttp", "(Lokhttp3/Authenticator;)V", "i", "getFollowRedirects$okhttp", "setFollowRedirects$okhttp", "j", "getFollowSslRedirects$okhttp", "setFollowSslRedirects$okhttp", "k", "Lokhttp3/CookieJar;", "getCookieJar$okhttp", "()Lokhttp3/CookieJar;", "setCookieJar$okhttp", "(Lokhttp3/CookieJar;)V", "l", "Lokhttp3/Cache;", "getCache$okhttp", "()Lokhttp3/Cache;", "setCache$okhttp", "(Lokhttp3/Cache;)V", "m", "Lokhttp3/Dns;", "getDns$okhttp", "()Lokhttp3/Dns;", "setDns$okhttp", "(Lokhttp3/Dns;)V", "n", "Ljava/net/Proxy;", "getProxy$okhttp", "()Ljava/net/Proxy;", "setProxy$okhttp", "(Ljava/net/Proxy;)V", "o", "Ljava/net/ProxySelector;", "getProxySelector$okhttp", "()Ljava/net/ProxySelector;", "setProxySelector$okhttp", "(Ljava/net/ProxySelector;)V", "p", "getProxyAuthenticator$okhttp", "setProxyAuthenticator$okhttp", "q", "Ljavax/net/SocketFactory;", "getSocketFactory$okhttp", "()Ljavax/net/SocketFactory;", "setSocketFactory$okhttp", "(Ljavax/net/SocketFactory;)V", "r", "Ljavax/net/ssl/SSLSocketFactory;", "getSslSocketFactoryOrNull$okhttp", "()Ljavax/net/ssl/SSLSocketFactory;", "setSslSocketFactoryOrNull$okhttp", "(Ljavax/net/ssl/SSLSocketFactory;)V", "sslSocketFactoryOrNull", "s", "Ljavax/net/ssl/X509TrustManager;", "getX509TrustManagerOrNull$okhttp", "()Ljavax/net/ssl/X509TrustManager;", "setX509TrustManagerOrNull$okhttp", "(Ljavax/net/ssl/X509TrustManager;)V", "x509TrustManagerOrNull", "t", "getConnectionSpecs$okhttp", "setConnectionSpecs$okhttp", "(Ljava/util/List;)V", "u", "getProtocols$okhttp", "setProtocols$okhttp", "v", "Ljavax/net/ssl/HostnameVerifier;", "getHostnameVerifier$okhttp", "()Ljavax/net/ssl/HostnameVerifier;", "setHostnameVerifier$okhttp", "(Ljavax/net/ssl/HostnameVerifier;)V", "w", "Lokhttp3/CertificatePinner;", "getCertificatePinner$okhttp", "()Lokhttp3/CertificatePinner;", "setCertificatePinner$okhttp", "(Lokhttp3/CertificatePinner;)V", "Lokhttp3/internal/tls/CertificateChainCleaner;", "x", "Lokhttp3/internal/tls/CertificateChainCleaner;", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "setCertificateChainCleaner$okhttp", "(Lokhttp3/internal/tls/CertificateChainCleaner;)V", "certificateChainCleaner", "", "y", "I", "getCallTimeout$okhttp", "()I", "setCallTimeout$okhttp", "(I)V", "z", "getConnectTimeout$okhttp", "setConnectTimeout$okhttp", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getReadTimeout$okhttp", "setReadTimeout$okhttp", "B", "getWriteTimeout$okhttp", "setWriteTimeout$okhttp", "C", "getPingInterval$okhttp", "setPingInterval$okhttp", "D", "J", "getMinWebSocketMessageToCompress$okhttp", "()J", "setMinWebSocketMessageToCompress$okhttp", "(J)V", "Lokhttp3/internal/connection/RouteDatabase;", ExifInterface.LONGITUDE_EAST, "Lokhttp3/internal/connection/RouteDatabase;", "getRouteDatabase$okhttp", "()Lokhttp3/internal/connection/RouteDatabase;", "setRouteDatabase$okhttp", "(Lokhttp3/internal/connection/RouteDatabase;)V", "routeDatabase", "Lokhttp3/internal/concurrent/TaskRunner;", "F", "Lokhttp3/internal/concurrent/TaskRunner;", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "setTaskRunner$okhttp", "(Lokhttp3/internal/concurrent/TaskRunner;)V", "taskRunner", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: A, reason: from kotlin metadata */
        public int readTimeout;

        /* renamed from: B, reason: from kotlin metadata */
        public int writeTimeout;

        /* renamed from: C, reason: from kotlin metadata */
        public int pingInterval;

        /* renamed from: D, reason: from kotlin metadata */
        public long minWebSocketMessageToCompress;

        /* renamed from: E, reason: from kotlin metadata */
        public RouteDatabase routeDatabase;

        /* renamed from: F, reason: from kotlin metadata */
        public TaskRunner taskRunner;

        /* renamed from: a, reason: from kotlin metadata */
        public Dispatcher dispatcher;

        /* renamed from: b, reason: from kotlin metadata */
        public ConnectionPool connectionPool;

        /* renamed from: c */
        public final ArrayList f24050c;

        /* renamed from: d */
        public final ArrayList f24051d;

        /* renamed from: e, reason: from kotlin metadata */
        public EventListener.Factory eventListenerFactory;

        /* renamed from: f, reason: from kotlin metadata */
        public boolean retryOnConnectionFailure;

        /* renamed from: g, reason: from kotlin metadata */
        public boolean fastFallback;

        /* renamed from: h, reason: from kotlin metadata */
        public Authenticator authenticator;

        /* renamed from: i, reason: from kotlin metadata */
        public boolean followRedirects;

        /* renamed from: j, reason: from kotlin metadata */
        public boolean followSslRedirects;

        /* renamed from: k, reason: from kotlin metadata */
        public CookieJar cookieJar;

        /* renamed from: l, reason: from kotlin metadata */
        public Cache cache;

        /* renamed from: m, reason: from kotlin metadata */
        public Dns dns;

        /* renamed from: n, reason: from kotlin metadata */
        public Proxy proxy;

        /* renamed from: o, reason: from kotlin metadata */
        public ProxySelector proxySelector;

        /* renamed from: p, reason: from kotlin metadata */
        public Authenticator proxyAuthenticator;

        /* renamed from: q, reason: from kotlin metadata */
        public SocketFactory socketFactory;

        /* renamed from: r, reason: from kotlin metadata */
        public SSLSocketFactory sslSocketFactoryOrNull;

        /* renamed from: s, reason: from kotlin metadata */
        public X509TrustManager x509TrustManagerOrNull;

        /* renamed from: t, reason: from kotlin metadata */
        public List connectionSpecs;

        /* renamed from: u, reason: from kotlin metadata */
        public List protocols;

        /* renamed from: v, reason: from kotlin metadata */
        public HostnameVerifier hostnameVerifier;

        /* renamed from: w, reason: from kotlin metadata */
        public CertificatePinner certificatePinner;

        /* renamed from: x, reason: from kotlin metadata */
        public CertificateChainCleaner certificateChainCleaner;

        /* renamed from: y, reason: from kotlin metadata */
        public int callTimeout;

        /* renamed from: z, reason: from kotlin metadata */
        public int connectTimeout;

        public Builder() {
            this.dispatcher = new Dispatcher();
            this.connectionPool = new ConnectionPool();
            this.f24050c = new ArrayList();
            this.f24051d = new ArrayList();
            this.eventListenerFactory = _UtilJvmKt.asFactory(EventListener.NONE);
            this.retryOnConnectionFailure = true;
            Authenticator authenticator = Authenticator.NONE;
            this.authenticator = authenticator;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = CookieJar.NO_COOKIES;
            this.dns = Dns.SYSTEM;
            this.proxyAuthenticator = authenticator;
            SocketFactory socketFactory = SocketFactory.getDefault();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "getDefault()");
            this.socketFactory = socketFactory;
            Companion companion = OkHttpClient.INSTANCE;
            this.connectionSpecs = companion.getDEFAULT_CONNECTION_SPECS$okhttp();
            this.protocols = companion.getDEFAULT_PROTOCOLS$okhttp();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.minWebSocketMessageToCompress = 1024L;
        }

        @JvmName(name = "-addInterceptor")
        @NotNull
        /* renamed from: -addInterceptor, reason: not valid java name */
        public final Builder m9025addInterceptor(@NotNull final Function1<? super Interceptor.Chain, Response> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return addInterceptor(new Interceptor() { // from class: okhttp3.OkHttpClient$Builder$addInterceptor$2
                @Override // okhttp3.Interceptor
                @NotNull
                public final Response intercept(@NotNull Interceptor.Chain chain) {
                    Intrinsics.checkNotNullParameter(chain, "chain");
                    return (Response) block.invoke(chain);
                }
            });
        }

        @JvmName(name = "-addNetworkInterceptor")
        @NotNull
        /* renamed from: -addNetworkInterceptor, reason: not valid java name */
        public final Builder m9026addNetworkInterceptor(@NotNull final Function1<? super Interceptor.Chain, Response> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return addNetworkInterceptor(new Interceptor() { // from class: okhttp3.OkHttpClient$Builder$addNetworkInterceptor$2
                @Override // okhttp3.Interceptor
                @NotNull
                public final Response intercept(@NotNull Interceptor.Chain chain) {
                    Intrinsics.checkNotNullParameter(chain, "chain");
                    return (Response) block.invoke(chain);
                }
            });
        }

        @NotNull
        public final Builder addInterceptor(@NotNull Interceptor interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            this.f24050c.add(interceptor);
            return this;
        }

        @NotNull
        public final Builder addNetworkInterceptor(@NotNull Interceptor interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            this.f24051d.add(interceptor);
            return this;
        }

        @NotNull
        public final Builder authenticator(@NotNull Authenticator authenticator) {
            Intrinsics.checkNotNullParameter(authenticator, "authenticator");
            this.authenticator = authenticator;
            return this;
        }

        @NotNull
        public final OkHttpClient build() {
            return new OkHttpClient(this);
        }

        @NotNull
        public final Builder cache(@Nullable Cache cache) {
            this.cache = cache;
            return this;
        }

        @NotNull
        public final Builder callTimeout(long timeout, @NotNull TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            this.callTimeout = _UtilJvmKt.checkDuration("timeout", timeout, unit);
            return this;
        }

        @NotNull
        public final Builder certificatePinner(@NotNull CertificatePinner certificatePinner) {
            Intrinsics.checkNotNullParameter(certificatePinner, "certificatePinner");
            if (!Intrinsics.areEqual(certificatePinner, this.certificatePinner)) {
                this.routeDatabase = null;
            }
            this.certificatePinner = certificatePinner;
            return this;
        }

        @NotNull
        public final Builder connectTimeout(long timeout, @NotNull TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            this.connectTimeout = _UtilJvmKt.checkDuration("timeout", timeout, unit);
            return this;
        }

        @NotNull
        public final Builder connectionPool(@NotNull ConnectionPool connectionPool) {
            Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
            this.connectionPool = connectionPool;
            return this;
        }

        @NotNull
        public final Builder connectionSpecs(@NotNull List<ConnectionSpec> connectionSpecs) {
            Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
            if (!Intrinsics.areEqual(connectionSpecs, this.connectionSpecs)) {
                this.routeDatabase = null;
            }
            this.connectionSpecs = _UtilJvmKt.toImmutableList(connectionSpecs);
            return this;
        }

        @NotNull
        public final Builder cookieJar(@NotNull CookieJar cookieJar) {
            Intrinsics.checkNotNullParameter(cookieJar, "cookieJar");
            this.cookieJar = cookieJar;
            return this;
        }

        @NotNull
        public final Builder dispatcher(@NotNull Dispatcher dispatcher) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            this.dispatcher = dispatcher;
            return this;
        }

        @NotNull
        public final Builder dns(@NotNull Dns dns) {
            Intrinsics.checkNotNullParameter(dns, "dns");
            if (!Intrinsics.areEqual(dns, this.dns)) {
                this.routeDatabase = null;
            }
            this.dns = dns;
            return this;
        }

        @NotNull
        public final Builder eventListener(@NotNull EventListener eventListener) {
            Intrinsics.checkNotNullParameter(eventListener, "eventListener");
            this.eventListenerFactory = _UtilJvmKt.asFactory(eventListener);
            return this;
        }

        @NotNull
        public final Builder eventListenerFactory(@NotNull EventListener.Factory eventListenerFactory) {
            Intrinsics.checkNotNullParameter(eventListenerFactory, "eventListenerFactory");
            this.eventListenerFactory = eventListenerFactory;
            return this;
        }

        @NotNull
        public final Builder fastFallback(boolean fastFallback) {
            this.fastFallback = fastFallback;
            return this;
        }

        @NotNull
        public final Builder followRedirects(boolean followRedirects) {
            this.followRedirects = followRedirects;
            return this;
        }

        @NotNull
        public final Builder followSslRedirects(boolean followProtocolRedirects) {
            this.followSslRedirects = followProtocolRedirects;
            return this;
        }

        @NotNull
        /* renamed from: getAuthenticator$okhttp, reason: from getter */
        public final Authenticator getAuthenticator() {
            return this.authenticator;
        }

        @Nullable
        /* renamed from: getCache$okhttp, reason: from getter */
        public final Cache getCache() {
            return this.cache;
        }

        /* renamed from: getCallTimeout$okhttp, reason: from getter */
        public final int getCallTimeout() {
            return this.callTimeout;
        }

        @Nullable
        /* renamed from: getCertificateChainCleaner$okhttp, reason: from getter */
        public final CertificateChainCleaner getCertificateChainCleaner() {
            return this.certificateChainCleaner;
        }

        @NotNull
        /* renamed from: getCertificatePinner$okhttp, reason: from getter */
        public final CertificatePinner getCertificatePinner() {
            return this.certificatePinner;
        }

        /* renamed from: getConnectTimeout$okhttp, reason: from getter */
        public final int getConnectTimeout() {
            return this.connectTimeout;
        }

        @NotNull
        /* renamed from: getConnectionPool$okhttp, reason: from getter */
        public final ConnectionPool getConnectionPool() {
            return this.connectionPool;
        }

        @NotNull
        public final List<ConnectionSpec> getConnectionSpecs$okhttp() {
            return this.connectionSpecs;
        }

        @NotNull
        /* renamed from: getCookieJar$okhttp, reason: from getter */
        public final CookieJar getCookieJar() {
            return this.cookieJar;
        }

        @NotNull
        /* renamed from: getDispatcher$okhttp, reason: from getter */
        public final Dispatcher getDispatcher() {
            return this.dispatcher;
        }

        @NotNull
        /* renamed from: getDns$okhttp, reason: from getter */
        public final Dns getDns() {
            return this.dns;
        }

        @NotNull
        /* renamed from: getEventListenerFactory$okhttp, reason: from getter */
        public final EventListener.Factory getEventListenerFactory() {
            return this.eventListenerFactory;
        }

        /* renamed from: getFastFallback$okhttp, reason: from getter */
        public final boolean getFastFallback() {
            return this.fastFallback;
        }

        /* renamed from: getFollowRedirects$okhttp, reason: from getter */
        public final boolean getFollowRedirects() {
            return this.followRedirects;
        }

        /* renamed from: getFollowSslRedirects$okhttp, reason: from getter */
        public final boolean getFollowSslRedirects() {
            return this.followSslRedirects;
        }

        @NotNull
        /* renamed from: getHostnameVerifier$okhttp, reason: from getter */
        public final HostnameVerifier getHostnameVerifier() {
            return this.hostnameVerifier;
        }

        @NotNull
        public final List<Interceptor> getInterceptors$okhttp() {
            return this.f24050c;
        }

        /* renamed from: getMinWebSocketMessageToCompress$okhttp, reason: from getter */
        public final long getMinWebSocketMessageToCompress() {
            return this.minWebSocketMessageToCompress;
        }

        @NotNull
        public final List<Interceptor> getNetworkInterceptors$okhttp() {
            return this.f24051d;
        }

        /* renamed from: getPingInterval$okhttp, reason: from getter */
        public final int getPingInterval() {
            return this.pingInterval;
        }

        @NotNull
        public final List<Protocol> getProtocols$okhttp() {
            return this.protocols;
        }

        @Nullable
        /* renamed from: getProxy$okhttp, reason: from getter */
        public final Proxy getProxy() {
            return this.proxy;
        }

        @NotNull
        /* renamed from: getProxyAuthenticator$okhttp, reason: from getter */
        public final Authenticator getProxyAuthenticator() {
            return this.proxyAuthenticator;
        }

        @Nullable
        /* renamed from: getProxySelector$okhttp, reason: from getter */
        public final ProxySelector getProxySelector() {
            return this.proxySelector;
        }

        /* renamed from: getReadTimeout$okhttp, reason: from getter */
        public final int getReadTimeout() {
            return this.readTimeout;
        }

        /* renamed from: getRetryOnConnectionFailure$okhttp, reason: from getter */
        public final boolean getRetryOnConnectionFailure() {
            return this.retryOnConnectionFailure;
        }

        @Nullable
        /* renamed from: getRouteDatabase$okhttp, reason: from getter */
        public final RouteDatabase getRouteDatabase() {
            return this.routeDatabase;
        }

        @NotNull
        /* renamed from: getSocketFactory$okhttp, reason: from getter */
        public final SocketFactory getSocketFactory() {
            return this.socketFactory;
        }

        @Nullable
        /* renamed from: getSslSocketFactoryOrNull$okhttp, reason: from getter */
        public final SSLSocketFactory getSslSocketFactoryOrNull() {
            return this.sslSocketFactoryOrNull;
        }

        @Nullable
        /* renamed from: getTaskRunner$okhttp, reason: from getter */
        public final TaskRunner getTaskRunner() {
            return this.taskRunner;
        }

        /* renamed from: getWriteTimeout$okhttp, reason: from getter */
        public final int getWriteTimeout() {
            return this.writeTimeout;
        }

        @Nullable
        /* renamed from: getX509TrustManagerOrNull$okhttp, reason: from getter */
        public final X509TrustManager getX509TrustManagerOrNull() {
            return this.x509TrustManagerOrNull;
        }

        @NotNull
        public final Builder hostnameVerifier(@NotNull HostnameVerifier hostnameVerifier) {
            Intrinsics.checkNotNullParameter(hostnameVerifier, "hostnameVerifier");
            if (!Intrinsics.areEqual(hostnameVerifier, this.hostnameVerifier)) {
                this.routeDatabase = null;
            }
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        @NotNull
        public final List<Interceptor> interceptors() {
            return this.f24050c;
        }

        @NotNull
        public final Builder minWebSocketMessageToCompress(long bytes) {
            if (bytes >= 0) {
                this.minWebSocketMessageToCompress = bytes;
                return this;
            }
            throw new IllegalArgumentException(ye0.m8294n(bytes, "minWebSocketMessageToCompress must be positive: ").toString());
        }

        @NotNull
        public final List<Interceptor> networkInterceptors() {
            return this.f24051d;
        }

        @NotNull
        public final Builder pingInterval(long interval, @NotNull TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            this.pingInterval = _UtilJvmKt.checkDuration("interval", interval, unit);
            return this;
        }

        @NotNull
        public final Builder protocols(@NotNull List<? extends Protocol> protocols) {
            Intrinsics.checkNotNullParameter(protocols, "protocols");
            List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) protocols);
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!mutableList.contains(protocol) && !mutableList.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + mutableList).toString());
            }
            if (mutableList.contains(protocol) && mutableList.size() > 1) {
                throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + mutableList).toString());
            }
            if (!mutableList.contains(Protocol.HTTP_1_0)) {
                if (!mutableList.contains(null)) {
                    mutableList.remove(Protocol.SPDY_3);
                    if (!Intrinsics.areEqual(mutableList, this.protocols)) {
                        this.routeDatabase = null;
                    }
                    List unmodifiableList = Collections.unmodifiableList(mutableList);
                    Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(protocolsCopy)");
                    this.protocols = unmodifiableList;
                    return this;
                }
                throw new IllegalArgumentException("protocols must not contain null");
            }
            throw new IllegalArgumentException(("protocols must not contain http/1.0: " + mutableList).toString());
        }

        @NotNull
        public final Builder proxy(@Nullable Proxy proxy) {
            if (!Intrinsics.areEqual(proxy, this.proxy)) {
                this.routeDatabase = null;
            }
            this.proxy = proxy;
            return this;
        }

        @NotNull
        public final Builder proxyAuthenticator(@NotNull Authenticator proxyAuthenticator) {
            Intrinsics.checkNotNullParameter(proxyAuthenticator, "proxyAuthenticator");
            if (!Intrinsics.areEqual(proxyAuthenticator, this.proxyAuthenticator)) {
                this.routeDatabase = null;
            }
            this.proxyAuthenticator = proxyAuthenticator;
            return this;
        }

        @NotNull
        public final Builder proxySelector(@NotNull ProxySelector proxySelector) {
            Intrinsics.checkNotNullParameter(proxySelector, "proxySelector");
            if (!Intrinsics.areEqual(proxySelector, this.proxySelector)) {
                this.routeDatabase = null;
            }
            this.proxySelector = proxySelector;
            return this;
        }

        @NotNull
        public final Builder readTimeout(long timeout, @NotNull TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            this.readTimeout = _UtilJvmKt.checkDuration("timeout", timeout, unit);
            return this;
        }

        @NotNull
        public final Builder retryOnConnectionFailure(boolean retryOnConnectionFailure) {
            this.retryOnConnectionFailure = retryOnConnectionFailure;
            return this;
        }

        public final void setAuthenticator$okhttp(@NotNull Authenticator authenticator) {
            Intrinsics.checkNotNullParameter(authenticator, "<set-?>");
            this.authenticator = authenticator;
        }

        public final void setCache$okhttp(@Nullable Cache cache) {
            this.cache = cache;
        }

        public final void setCallTimeout$okhttp(int i) {
            this.callTimeout = i;
        }

        public final void setCertificateChainCleaner$okhttp(@Nullable CertificateChainCleaner certificateChainCleaner) {
            this.certificateChainCleaner = certificateChainCleaner;
        }

        public final void setCertificatePinner$okhttp(@NotNull CertificatePinner certificatePinner) {
            Intrinsics.checkNotNullParameter(certificatePinner, "<set-?>");
            this.certificatePinner = certificatePinner;
        }

        public final void setConnectTimeout$okhttp(int i) {
            this.connectTimeout = i;
        }

        public final void setConnectionPool$okhttp(@NotNull ConnectionPool connectionPool) {
            Intrinsics.checkNotNullParameter(connectionPool, "<set-?>");
            this.connectionPool = connectionPool;
        }

        public final void setConnectionSpecs$okhttp(@NotNull List<ConnectionSpec> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.connectionSpecs = list;
        }

        public final void setCookieJar$okhttp(@NotNull CookieJar cookieJar) {
            Intrinsics.checkNotNullParameter(cookieJar, "<set-?>");
            this.cookieJar = cookieJar;
        }

        public final void setDispatcher$okhttp(@NotNull Dispatcher dispatcher) {
            Intrinsics.checkNotNullParameter(dispatcher, "<set-?>");
            this.dispatcher = dispatcher;
        }

        public final void setDns$okhttp(@NotNull Dns dns) {
            Intrinsics.checkNotNullParameter(dns, "<set-?>");
            this.dns = dns;
        }

        public final void setEventListenerFactory$okhttp(@NotNull EventListener.Factory factory) {
            Intrinsics.checkNotNullParameter(factory, "<set-?>");
            this.eventListenerFactory = factory;
        }

        public final void setFastFallback$okhttp(boolean z) {
            this.fastFallback = z;
        }

        public final void setFollowRedirects$okhttp(boolean z) {
            this.followRedirects = z;
        }

        public final void setFollowSslRedirects$okhttp(boolean z) {
            this.followSslRedirects = z;
        }

        public final void setHostnameVerifier$okhttp(@NotNull HostnameVerifier hostnameVerifier) {
            Intrinsics.checkNotNullParameter(hostnameVerifier, "<set-?>");
            this.hostnameVerifier = hostnameVerifier;
        }

        public final void setMinWebSocketMessageToCompress$okhttp(long j) {
            this.minWebSocketMessageToCompress = j;
        }

        public final void setPingInterval$okhttp(int i) {
            this.pingInterval = i;
        }

        public final void setProtocols$okhttp(@NotNull List<? extends Protocol> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.protocols = list;
        }

        public final void setProxy$okhttp(@Nullable Proxy proxy) {
            this.proxy = proxy;
        }

        public final void setProxyAuthenticator$okhttp(@NotNull Authenticator authenticator) {
            Intrinsics.checkNotNullParameter(authenticator, "<set-?>");
            this.proxyAuthenticator = authenticator;
        }

        public final void setProxySelector$okhttp(@Nullable ProxySelector proxySelector) {
            this.proxySelector = proxySelector;
        }

        public final void setReadTimeout$okhttp(int i) {
            this.readTimeout = i;
        }

        public final void setRetryOnConnectionFailure$okhttp(boolean z) {
            this.retryOnConnectionFailure = z;
        }

        public final void setRouteDatabase$okhttp(@Nullable RouteDatabase routeDatabase) {
            this.routeDatabase = routeDatabase;
        }

        public final void setSocketFactory$okhttp(@NotNull SocketFactory socketFactory) {
            Intrinsics.checkNotNullParameter(socketFactory, "<set-?>");
            this.socketFactory = socketFactory;
        }

        public final void setSslSocketFactoryOrNull$okhttp(@Nullable SSLSocketFactory sSLSocketFactory) {
            this.sslSocketFactoryOrNull = sSLSocketFactory;
        }

        public final void setTaskRunner$okhttp(@Nullable TaskRunner taskRunner) {
            this.taskRunner = taskRunner;
        }

        public final void setWriteTimeout$okhttp(int i) {
            this.writeTimeout = i;
        }

        public final void setX509TrustManagerOrNull$okhttp(@Nullable X509TrustManager x509TrustManager) {
            this.x509TrustManagerOrNull = x509TrustManager;
        }

        @NotNull
        public final Builder socketFactory(@NotNull SocketFactory socketFactory) {
            Intrinsics.checkNotNullParameter(socketFactory, "socketFactory");
            if (!(socketFactory instanceof SSLSocketFactory)) {
                if (!Intrinsics.areEqual(socketFactory, this.socketFactory)) {
                    this.routeDatabase = null;
                }
                this.socketFactory = socketFactory;
                return this;
            }
            throw new IllegalArgumentException("socketFactory instanceof SSLSocketFactory");
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use the sslSocketFactory overload that accepts a X509TrustManager.")
        @NotNull
        public final Builder sslSocketFactory(@NotNull SSLSocketFactory sslSocketFactory) {
            Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
            if (!Intrinsics.areEqual(sslSocketFactory, this.sslSocketFactoryOrNull)) {
                this.routeDatabase = null;
            }
            this.sslSocketFactoryOrNull = sslSocketFactory;
            Platform.Companion companion = Platform.INSTANCE;
            X509TrustManager trustManager = companion.get().trustManager(sslSocketFactory);
            if (trustManager != null) {
                this.x509TrustManagerOrNull = trustManager;
                Platform platform = companion.get();
                X509TrustManager x509TrustManager = this.x509TrustManagerOrNull;
                Intrinsics.checkNotNull(x509TrustManager);
                this.certificateChainCleaner = platform.buildCertificateChainCleaner(x509TrustManager);
                return this;
            }
            throw new IllegalStateException("Unable to extract the trust manager on " + companion.get() + ", sslSocketFactory is " + sslSocketFactory.getClass());
        }

        @NotNull
        public final Builder writeTimeout(long timeout, @NotNull TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            this.writeTimeout = _UtilJvmKt.checkDuration("timeout", timeout, unit);
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder callTimeout(@NotNull Duration duration) {
            long millis;
            Intrinsics.checkNotNullParameter(duration, "duration");
            millis = duration.toMillis();
            callTimeout(millis, TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder connectTimeout(@NotNull Duration duration) {
            long millis;
            Intrinsics.checkNotNullParameter(duration, "duration");
            millis = duration.toMillis();
            connectTimeout(millis, TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder pingInterval(@NotNull Duration duration) {
            long millis;
            Intrinsics.checkNotNullParameter(duration, "duration");
            millis = duration.toMillis();
            pingInterval(millis, TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder readTimeout(@NotNull Duration duration) {
            long millis;
            Intrinsics.checkNotNullParameter(duration, "duration");
            millis = duration.toMillis();
            readTimeout(millis, TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder writeTimeout(@NotNull Duration duration) {
            long millis;
            Intrinsics.checkNotNullParameter(duration, "duration");
            millis = duration.toMillis();
            writeTimeout(millis, TimeUnit.MILLISECONDS);
            return this;
        }

        @NotNull
        public final Builder sslSocketFactory(@NotNull SSLSocketFactory sslSocketFactory, @NotNull X509TrustManager trustManager) {
            Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            if (!Intrinsics.areEqual(sslSocketFactory, this.sslSocketFactoryOrNull) || !Intrinsics.areEqual(trustManager, this.x509TrustManagerOrNull)) {
                this.routeDatabase = null;
            }
            this.sslSocketFactoryOrNull = sslSocketFactory;
            this.certificateChainCleaner = CertificateChainCleaner.INSTANCE.get(trustManager);
            this.x509TrustManagerOrNull = trustManager;
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(@NotNull OkHttpClient okHttpClient) {
            this();
            Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
            this.dispatcher = okHttpClient.dispatcher();
            this.connectionPool = okHttpClient.connectionPool();
            AbstractC1327iq.addAll(this.f24050c, okHttpClient.interceptors());
            AbstractC1327iq.addAll(this.f24051d, okHttpClient.networkInterceptors());
            this.eventListenerFactory = okHttpClient.eventListenerFactory();
            this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure();
            this.fastFallback = okHttpClient.getFastFallback();
            this.authenticator = okHttpClient.authenticator();
            this.followRedirects = okHttpClient.followRedirects();
            this.followSslRedirects = okHttpClient.followSslRedirects();
            this.cookieJar = okHttpClient.cookieJar();
            this.cache = okHttpClient.cache();
            this.dns = okHttpClient.dns();
            this.proxy = okHttpClient.proxy();
            this.proxySelector = okHttpClient.proxySelector();
            this.proxyAuthenticator = okHttpClient.proxyAuthenticator();
            this.socketFactory = okHttpClient.socketFactory();
            this.sslSocketFactoryOrNull = okHttpClient.f24033r;
            this.x509TrustManagerOrNull = okHttpClient.getX509TrustManager();
            this.connectionSpecs = okHttpClient.connectionSpecs();
            this.protocols = okHttpClient.protocols();
            this.hostnameVerifier = okHttpClient.hostnameVerifier();
            this.certificatePinner = okHttpClient.certificatePinner();
            this.certificateChainCleaner = okHttpClient.getCertificateChainCleaner();
            this.callTimeout = okHttpClient.callTimeoutMillis();
            this.connectTimeout = okHttpClient.connectTimeoutMillis();
            this.readTimeout = okHttpClient.readTimeoutMillis();
            this.writeTimeout = okHttpClient.writeTimeoutMillis();
            this.pingInterval = okHttpClient.pingIntervalMillis();
            this.minWebSocketMessageToCompress = okHttpClient.getMinWebSocketMessageToCompress();
            this.routeDatabase = okHttpClient.getRouteDatabase();
            this.taskRunner = okHttpClient.getTaskRunner();
        }
    }

    @Metadata(m5568d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, m5569d2 = {"Lokhttp3/OkHttpClient$Companion;", "", "", "Lokhttp3/Protocol;", "DEFAULT_PROTOCOLS", "Ljava/util/List;", "getDEFAULT_PROTOCOLS$okhttp", "()Ljava/util/List;", "Lokhttp3/ConnectionSpec;", "DEFAULT_CONNECTION_SPECS", "getDEFAULT_CONNECTION_SPECS$okhttp", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @NotNull
        public final List<ConnectionSpec> getDEFAULT_CONNECTION_SPECS$okhttp() {
            return OkHttpClient.f24009H;
        }

        @NotNull
        public final List<Protocol> getDEFAULT_PROTOCOLS$okhttp() {
            return OkHttpClient.f24008G;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public OkHttpClient(@NotNull Builder builder) {
        ProxySelector proxySelector;
        List list;
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.dispatcher = builder.getDispatcher();
        this.connectionPool = builder.getConnectionPool();
        this.interceptors = _UtilJvmKt.toImmutableList(builder.getInterceptors$okhttp());
        this.networkInterceptors = _UtilJvmKt.toImmutableList(builder.getNetworkInterceptors$okhttp());
        this.eventListenerFactory = builder.getEventListenerFactory();
        this.retryOnConnectionFailure = builder.getRetryOnConnectionFailure();
        this.fastFallback = builder.getFastFallback();
        this.authenticator = builder.getAuthenticator();
        this.followRedirects = builder.getFollowRedirects();
        this.followSslRedirects = builder.getFollowSslRedirects();
        this.cookieJar = builder.getCookieJar();
        this.cache = builder.getCache();
        this.dns = builder.getDns();
        this.proxy = builder.getProxy();
        if (builder.getProxy() != null) {
            proxySelector = NullProxySelector.INSTANCE;
        } else {
            proxySelector = builder.getProxySelector();
            proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
            if (proxySelector == null) {
                proxySelector = NullProxySelector.INSTANCE;
            }
        }
        this.proxySelector = proxySelector;
        this.proxyAuthenticator = builder.getProxyAuthenticator();
        this.socketFactory = builder.getSocketFactory();
        List<ConnectionSpec> connectionSpecs$okhttp = builder.getConnectionSpecs$okhttp();
        this.connectionSpecs = connectionSpecs$okhttp;
        this.protocols = builder.getProtocols$okhttp();
        this.hostnameVerifier = builder.getHostnameVerifier();
        this.callTimeoutMillis = builder.getCallTimeout();
        this.connectTimeoutMillis = builder.getConnectTimeout();
        this.readTimeoutMillis = builder.getReadTimeout();
        this.writeTimeoutMillis = builder.getWriteTimeout();
        this.pingIntervalMillis = builder.getPingInterval();
        this.minWebSocketMessageToCompress = builder.getMinWebSocketMessageToCompress();
        RouteDatabase routeDatabase = builder.getRouteDatabase();
        this.routeDatabase = routeDatabase == null ? new RouteDatabase() : routeDatabase;
        TaskRunner taskRunner = builder.getTaskRunner();
        this.taskRunner = taskRunner == null ? TaskRunner.INSTANCE : taskRunner;
        if (!(connectionSpecs$okhttp instanceof Collection) || !connectionSpecs$okhttp.isEmpty()) {
            Iterator<T> it = connectionSpecs$okhttp.iterator();
            while (it.hasNext()) {
                if (((ConnectionSpec) it.next()).getIsTls()) {
                    if (builder.getSslSocketFactoryOrNull() != null) {
                        this.f24033r = builder.getSslSocketFactoryOrNull();
                        CertificateChainCleaner certificateChainCleaner = builder.getCertificateChainCleaner();
                        Intrinsics.checkNotNull(certificateChainCleaner);
                        this.certificateChainCleaner = certificateChainCleaner;
                        X509TrustManager x509TrustManagerOrNull = builder.getX509TrustManagerOrNull();
                        Intrinsics.checkNotNull(x509TrustManagerOrNull);
                        this.x509TrustManager = x509TrustManagerOrNull;
                        CertificatePinner certificatePinner = builder.getCertificatePinner();
                        Intrinsics.checkNotNull(certificateChainCleaner);
                        this.certificatePinner = certificatePinner.withCertificateChainCleaner$okhttp(certificateChainCleaner);
                    } else {
                        Platform.Companion companion = Platform.INSTANCE;
                        X509TrustManager platformTrustManager = companion.get().platformTrustManager();
                        this.x509TrustManager = platformTrustManager;
                        Platform platform = companion.get();
                        Intrinsics.checkNotNull(platformTrustManager);
                        this.f24033r = platform.newSslSocketFactory(platformTrustManager);
                        CertificateChainCleaner.Companion companion2 = CertificateChainCleaner.INSTANCE;
                        Intrinsics.checkNotNull(platformTrustManager);
                        CertificateChainCleaner certificateChainCleaner2 = companion2.get(platformTrustManager);
                        this.certificateChainCleaner = certificateChainCleaner2;
                        CertificatePinner certificatePinner2 = builder.getCertificatePinner();
                        Intrinsics.checkNotNull(certificateChainCleaner2);
                        this.certificatePinner = certificatePinner2.withCertificateChainCleaner$okhttp(certificateChainCleaner2);
                    }
                    list = this.interceptors;
                    if (list.contains(null)) {
                        List list2 = this.networkInterceptors;
                        if (!list2.contains(null)) {
                            List list3 = this.connectionSpecs;
                            boolean z = list3 instanceof Collection;
                            X509TrustManager x509TrustManager = this.x509TrustManager;
                            CertificateChainCleaner certificateChainCleaner3 = this.certificateChainCleaner;
                            SSLSocketFactory sSLSocketFactory = this.f24033r;
                            if (!z || !list3.isEmpty()) {
                                Iterator it2 = list3.iterator();
                                while (it2.hasNext()) {
                                    if (((ConnectionSpec) it2.next()).getIsTls()) {
                                        if (sSLSocketFactory == null) {
                                            throw new IllegalStateException("sslSocketFactory == null");
                                        }
                                        if (certificateChainCleaner3 == null) {
                                            throw new IllegalStateException("certificateChainCleaner == null");
                                        }
                                        if (x509TrustManager == null) {
                                            throw new IllegalStateException("x509TrustManager == null");
                                        }
                                        return;
                                    }
                                }
                            }
                            if (sSLSocketFactory != null) {
                                throw new IllegalStateException("Check failed.");
                            }
                            if (certificateChainCleaner3 != null) {
                                throw new IllegalStateException("Check failed.");
                            }
                            if (x509TrustManager == null) {
                                if (!Intrinsics.areEqual(this.certificatePinner, CertificatePinner.DEFAULT)) {
                                    throw new IllegalStateException("Check failed.");
                                }
                                return;
                            }
                            throw new IllegalStateException("Check failed.");
                        }
                        throw new IllegalStateException(("Null network interceptor: " + list2).toString());
                    }
                    throw new IllegalStateException(("Null interceptor: " + list).toString());
                }
            }
        }
        this.f24033r = null;
        this.certificateChainCleaner = null;
        this.x509TrustManager = null;
        this.certificatePinner = CertificatePinner.DEFAULT;
        list = this.interceptors;
        if (list.contains(null)) {
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "authenticator", imports = {}))
    @JvmName(name = "-deprecated_authenticator")
    @NotNull
    /* renamed from: -deprecated_authenticator, reason: not valid java name and from getter */
    public final Authenticator getAuthenticator() {
        return this.authenticator;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cache", imports = {}))
    @JvmName(name = "-deprecated_cache")
    @Nullable
    /* renamed from: -deprecated_cache, reason: not valid java name and from getter */
    public final Cache getCache() {
        return this.cache;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "callTimeoutMillis", imports = {}))
    @JvmName(name = "-deprecated_callTimeoutMillis")
    /* renamed from: -deprecated_callTimeoutMillis, reason: not valid java name and from getter */
    public final int getCallTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "certificatePinner", imports = {}))
    @JvmName(name = "-deprecated_certificatePinner")
    @NotNull
    /* renamed from: -deprecated_certificatePinner, reason: not valid java name and from getter */
    public final CertificatePinner getCertificatePinner() {
        return this.certificatePinner;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "connectTimeoutMillis", imports = {}))
    @JvmName(name = "-deprecated_connectTimeoutMillis")
    /* renamed from: -deprecated_connectTimeoutMillis, reason: not valid java name and from getter */
    public final int getConnectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "connectionPool", imports = {}))
    @JvmName(name = "-deprecated_connectionPool")
    @NotNull
    /* renamed from: -deprecated_connectionPool, reason: not valid java name and from getter */
    public final ConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "connectionSpecs", imports = {}))
    @JvmName(name = "-deprecated_connectionSpecs")
    @NotNull
    /* renamed from: -deprecated_connectionSpecs, reason: not valid java name */
    public final List<ConnectionSpec> m9005deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cookieJar", imports = {}))
    @JvmName(name = "-deprecated_cookieJar")
    @NotNull
    /* renamed from: -deprecated_cookieJar, reason: not valid java name and from getter */
    public final CookieJar getCookieJar() {
        return this.cookieJar;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "dispatcher", imports = {}))
    @JvmName(name = "-deprecated_dispatcher")
    @NotNull
    /* renamed from: -deprecated_dispatcher, reason: not valid java name and from getter */
    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "dns", imports = {}))
    @JvmName(name = "-deprecated_dns")
    @NotNull
    /* renamed from: -deprecated_dns, reason: not valid java name and from getter */
    public final Dns getDns() {
        return this.dns;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "eventListenerFactory", imports = {}))
    @JvmName(name = "-deprecated_eventListenerFactory")
    @NotNull
    /* renamed from: -deprecated_eventListenerFactory, reason: not valid java name and from getter */
    public final EventListener.Factory getEventListenerFactory() {
        return this.eventListenerFactory;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "followRedirects", imports = {}))
    @JvmName(name = "-deprecated_followRedirects")
    /* renamed from: -deprecated_followRedirects, reason: not valid java name and from getter */
    public final boolean getFollowRedirects() {
        return this.followRedirects;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "followSslRedirects", imports = {}))
    @JvmName(name = "-deprecated_followSslRedirects")
    /* renamed from: -deprecated_followSslRedirects, reason: not valid java name and from getter */
    public final boolean getFollowSslRedirects() {
        return this.followSslRedirects;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hostnameVerifier", imports = {}))
    @JvmName(name = "-deprecated_hostnameVerifier")
    @NotNull
    /* renamed from: -deprecated_hostnameVerifier, reason: not valid java name and from getter */
    public final HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "interceptors", imports = {}))
    @JvmName(name = "-deprecated_interceptors")
    @NotNull
    /* renamed from: -deprecated_interceptors, reason: not valid java name */
    public final List<Interceptor> m9013deprecated_interceptors() {
        return this.interceptors;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "networkInterceptors", imports = {}))
    @JvmName(name = "-deprecated_networkInterceptors")
    @NotNull
    /* renamed from: -deprecated_networkInterceptors, reason: not valid java name */
    public final List<Interceptor> m9014deprecated_networkInterceptors() {
        return this.networkInterceptors;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "pingIntervalMillis", imports = {}))
    @JvmName(name = "-deprecated_pingIntervalMillis")
    /* renamed from: -deprecated_pingIntervalMillis, reason: not valid java name and from getter */
    public final int getPingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "protocols", imports = {}))
    @JvmName(name = "-deprecated_protocols")
    @NotNull
    /* renamed from: -deprecated_protocols, reason: not valid java name */
    public final List<Protocol> m9016deprecated_protocols() {
        return this.protocols;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proxy", imports = {}))
    @JvmName(name = "-deprecated_proxy")
    @Nullable
    /* renamed from: -deprecated_proxy, reason: not valid java name and from getter */
    public final Proxy getProxy() {
        return this.proxy;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proxyAuthenticator", imports = {}))
    @JvmName(name = "-deprecated_proxyAuthenticator")
    @NotNull
    /* renamed from: -deprecated_proxyAuthenticator, reason: not valid java name and from getter */
    public final Authenticator getProxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proxySelector", imports = {}))
    @JvmName(name = "-deprecated_proxySelector")
    @NotNull
    /* renamed from: -deprecated_proxySelector, reason: not valid java name and from getter */
    public final ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "readTimeoutMillis", imports = {}))
    @JvmName(name = "-deprecated_readTimeoutMillis")
    /* renamed from: -deprecated_readTimeoutMillis, reason: not valid java name and from getter */
    public final int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "retryOnConnectionFailure", imports = {}))
    @JvmName(name = "-deprecated_retryOnConnectionFailure")
    /* renamed from: -deprecated_retryOnConnectionFailure, reason: not valid java name and from getter */
    public final boolean getRetryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "socketFactory", imports = {}))
    @JvmName(name = "-deprecated_socketFactory")
    @NotNull
    /* renamed from: -deprecated_socketFactory, reason: not valid java name and from getter */
    public final SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sslSocketFactory", imports = {}))
    @JvmName(name = "-deprecated_sslSocketFactory")
    @NotNull
    /* renamed from: -deprecated_sslSocketFactory, reason: not valid java name */
    public final SSLSocketFactory m9023deprecated_sslSocketFactory() {
        return sslSocketFactory();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "writeTimeoutMillis", imports = {}))
    @JvmName(name = "-deprecated_writeTimeoutMillis")
    /* renamed from: -deprecated_writeTimeoutMillis, reason: not valid java name and from getter */
    public final int getWriteTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    @JvmName(name = "authenticator")
    @NotNull
    public final Authenticator authenticator() {
        return this.authenticator;
    }

    @JvmName(name = "cache")
    @Nullable
    public final Cache cache() {
        return this.cache;
    }

    @JvmName(name = "callTimeoutMillis")
    public final int callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @JvmName(name = "certificateChainCleaner")
    @Nullable
    /* renamed from: certificateChainCleaner, reason: from getter */
    public final CertificateChainCleaner getCertificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    @JvmName(name = "certificatePinner")
    @NotNull
    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    @JvmName(name = "connectTimeoutMillis")
    public final int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @JvmName(name = "connectionPool")
    @NotNull
    public final ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    @JvmName(name = "connectionSpecs")
    @NotNull
    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    @JvmName(name = "cookieJar")
    @NotNull
    public final CookieJar cookieJar() {
        return this.cookieJar;
    }

    @JvmName(name = "dispatcher")
    @NotNull
    public final Dispatcher dispatcher() {
        return this.dispatcher;
    }

    @JvmName(name = "dns")
    @NotNull
    public final Dns dns() {
        return this.dns;
    }

    @JvmName(name = "eventListenerFactory")
    @NotNull
    public final EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    @JvmName(name = "fastFallback")
    /* renamed from: fastFallback, reason: from getter */
    public final boolean getFastFallback() {
        return this.fastFallback;
    }

    @JvmName(name = "followRedirects")
    public final boolean followRedirects() {
        return this.followRedirects;
    }

    @JvmName(name = "followSslRedirects")
    public final boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    @NotNull
    /* renamed from: getRouteDatabase$okhttp, reason: from getter */
    public final RouteDatabase getRouteDatabase() {
        return this.routeDatabase;
    }

    @NotNull
    /* renamed from: getTaskRunner$okhttp, reason: from getter */
    public final TaskRunner getTaskRunner() {
        return this.taskRunner;
    }

    @JvmName(name = "hostnameVerifier")
    @NotNull
    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @JvmName(name = "interceptors")
    @NotNull
    public final List<Interceptor> interceptors() {
        return this.interceptors;
    }

    @JvmName(name = "minWebSocketMessageToCompress")
    /* renamed from: minWebSocketMessageToCompress, reason: from getter */
    public final long getMinWebSocketMessageToCompress() {
        return this.minWebSocketMessageToCompress;
    }

    @JvmName(name = "networkInterceptors")
    @NotNull
    public final List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    @NotNull
    public Builder newBuilder() {
        return new Builder(this);
    }

    @Override // okhttp3.Call.Factory
    @NotNull
    public Call newCall(@NotNull Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return new RealCall(this, request, false);
    }

    @Override // okhttp3.WebSocket.Factory
    @NotNull
    public WebSocket newWebSocket(@NotNull Request request, @NotNull WebSocketListener listener) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(listener, "listener");
        RealWebSocket realWebSocket = new RealWebSocket(this.taskRunner, request, listener, new Random(), this.pingIntervalMillis, null, this.minWebSocketMessageToCompress);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    @JvmName(name = "pingIntervalMillis")
    public final int pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @JvmName(name = "protocols")
    @NotNull
    public final List<Protocol> protocols() {
        return this.protocols;
    }

    @JvmName(name = "proxy")
    @Nullable
    public final Proxy proxy() {
        return this.proxy;
    }

    @JvmName(name = "proxyAuthenticator")
    @NotNull
    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @JvmName(name = "proxySelector")
    @NotNull
    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    @JvmName(name = "readTimeoutMillis")
    public final int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @JvmName(name = "retryOnConnectionFailure")
    public final boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @JvmName(name = "socketFactory")
    @NotNull
    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    @JvmName(name = "sslSocketFactory")
    @NotNull
    public final SSLSocketFactory sslSocketFactory() {
        SSLSocketFactory sSLSocketFactory = this.f24033r;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    @JvmName(name = "writeTimeoutMillis")
    public final int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    @JvmName(name = "x509TrustManager")
    @Nullable
    /* renamed from: x509TrustManager, reason: from getter */
    public final X509TrustManager getX509TrustManager() {
        return this.x509TrustManager;
    }

    public OkHttpClient() {
        this(new Builder());
    }
}
