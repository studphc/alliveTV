package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.common.net.HttpHeaders;
import com.hisona.allive.HttpRequest;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.ConnectionSpec;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.RoutePlanner;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.HttpStatusCodesKt;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u001a\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00152\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010!\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R \u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0+8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00061"}, m5569d2 = {"Lokhttp3/internal/connection/RealRoutePlanner;", "Lokhttp3/internal/connection/RoutePlanner;", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/Address;", "address", "Lokhttp3/internal/connection/RealCall;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/internal/http/RealInterceptorChain;", "chain", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Lokhttp3/internal/http/RealInterceptorChain;)V", "", "isCanceled", "()Z", "Lokhttp3/internal/connection/RoutePlanner$Plan;", "plan", "()Lokhttp3/internal/connection/RoutePlanner$Plan;", "Lokhttp3/internal/connection/ConnectPlan;", "planToReplace", "", "Lokhttp3/Route;", "routes", "Lokhttp3/internal/connection/ReusePlan;", "planReusePooledConnection$okhttp", "(Lokhttp3/internal/connection/ConnectPlan;Ljava/util/List;)Lokhttp3/internal/connection/ReusePlan;", "planReusePooledConnection", "route", "planConnectToRoute$okhttp", "(Lokhttp3/Route;Ljava/util/List;)Lokhttp3/internal/connection/ConnectPlan;", "planConnectToRoute", "Lokhttp3/internal/connection/RealConnection;", "failedConnection", "hasNext", "(Lokhttp3/internal/connection/RealConnection;)Z", "Lokhttp3/HttpUrl;", ImagesContract.URL, "sameHostAndPort", "(Lokhttp3/HttpUrl;)Z", "b", "Lokhttp3/Address;", "getAddress", "()Lokhttp3/Address;", "Lkotlin/collections/ArrayDeque;", "h", "Lkotlin/collections/ArrayDeque;", "getDeferredPlans", "()Lkotlin/collections/ArrayDeque;", "deferredPlans", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class RealRoutePlanner implements RoutePlanner {

    /* renamed from: a */
    public final OkHttpClient f24358a;

    /* renamed from: b, reason: from kotlin metadata */
    public final Address address;

    /* renamed from: c */
    public final RealCall f24360c;

    /* renamed from: d */
    public final boolean f24361d;

    /* renamed from: e */
    public RouteSelector.Selection f24362e;

    /* renamed from: f */
    public RouteSelector f24363f;

    /* renamed from: g */
    public Route f24364g;

    /* renamed from: h, reason: from kotlin metadata */
    public final ArrayDeque deferredPlans;

    public RealRoutePlanner(@NotNull OkHttpClient client, @NotNull Address address, @NotNull RealCall call, @NotNull RealInterceptorChain chain) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(chain, "chain");
        this.f24358a = client;
        this.address = address;
        this.f24360c = call;
        this.f24361d = !Intrinsics.areEqual(chain.getRequest().method(), HttpRequest.METHOD_GET);
        this.deferredPlans = new ArrayDeque();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConnectPlan planConnectToRoute$okhttp$default(RealRoutePlanner realRoutePlanner, Route route, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        return realRoutePlanner.planConnectToRoute$okhttp(route, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReusePlan planReusePooledConnection$okhttp$default(RealRoutePlanner realRoutePlanner, ConnectPlan connectPlan, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            connectPlan = null;
        }
        if ((i & 2) != 0) {
            list = null;
        }
        return realRoutePlanner.planReusePooledConnection$okhttp(connectPlan, list);
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    @NotNull
    public Address getAddress() {
        return this.address;
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    @NotNull
    public ArrayDeque<RoutePlanner.Plan> getDeferredPlans() {
        return this.deferredPlans;
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public boolean hasNext(@Nullable RealConnection failedConnection) {
        RouteSelector routeSelector;
        Route route;
        if (!getDeferredPlans().isEmpty() || this.f24364g != null) {
            return true;
        }
        if (failedConnection != null) {
            synchronized (failedConnection) {
                route = null;
                if (failedConnection.getRouteFailureCount() == 0) {
                    if (failedConnection.getNoNewExchanges()) {
                        if (_UtilJvmKt.canReuseConnectionFor(failedConnection.route().address().url(), getAddress().url())) {
                            route = failedConnection.route();
                        }
                    }
                }
            }
            if (route != null) {
                this.f24364g = route;
                return true;
            }
        }
        RouteSelector.Selection selection = this.f24362e;
        if ((selection != null && selection.hasNext()) || (routeSelector = this.f24363f) == null) {
            return true;
        }
        return routeSelector.hasNext();
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public boolean isCanceled() {
        return this.f24360c.getF24324p();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0070  */
    @Override // okhttp3.internal.connection.RoutePlanner
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RoutePlanner.Plan plan() {
        Socket releaseConnectionNoEvents$okhttp;
        ReusePlan reusePlan;
        ConnectPlan planConnectToRoute$okhttp;
        RealConnection connection = this.f24360c.getConnection();
        if (connection != null) {
            boolean isHealthy = connection.isHealthy(this.f24361d);
            synchronized (connection) {
                try {
                    if (!isHealthy) {
                        connection.setNoNewExchanges(true);
                        releaseConnectionNoEvents$okhttp = this.f24360c.releaseConnectionNoEvents$okhttp();
                    } else {
                        if (!connection.getNoNewExchanges() && sameHostAndPort(connection.route().address().url())) {
                            releaseConnectionNoEvents$okhttp = null;
                        }
                        releaseConnectionNoEvents$okhttp = this.f24360c.releaseConnectionNoEvents$okhttp();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.f24360c.getConnection() != null) {
                if (releaseConnectionNoEvents$okhttp == null) {
                    reusePlan = new ReusePlan(connection);
                    if (reusePlan == null) {
                        return reusePlan;
                    }
                    ReusePlan planReusePooledConnection$okhttp$default = planReusePooledConnection$okhttp$default(this, null, null, 3, null);
                    if (planReusePooledConnection$okhttp$default != null) {
                        return planReusePooledConnection$okhttp$default;
                    }
                    if (!getDeferredPlans().isEmpty()) {
                        return getDeferredPlans().removeFirst();
                    }
                    Route route = this.f24364g;
                    if (route != null) {
                        this.f24364g = null;
                        planConnectToRoute$okhttp = planConnectToRoute$okhttp$default(this, route, null, 2, null);
                    } else {
                        RouteSelector.Selection selection = this.f24362e;
                        if (selection != null && selection.hasNext()) {
                            planConnectToRoute$okhttp = planConnectToRoute$okhttp$default(this, selection.next(), null, 2, null);
                        } else {
                            RouteSelector routeSelector = this.f24363f;
                            RealCall realCall = this.f24360c;
                            if (routeSelector == null) {
                                routeSelector = new RouteSelector(getAddress(), realCall.getClient().getRouteDatabase(), this.f24360c, this.f24358a.getFastFallback(), realCall.getEventListener());
                                this.f24363f = routeSelector;
                            }
                            if (routeSelector.hasNext()) {
                                RouteSelector.Selection next = routeSelector.next();
                                this.f24362e = next;
                                if (!realCall.getF24324p()) {
                                    planConnectToRoute$okhttp = planConnectToRoute$okhttp(next.next(), next.getRoutes());
                                } else {
                                    throw new IOException("Canceled");
                                }
                            } else {
                                throw new IOException("exhausted all routes");
                            }
                        }
                    }
                    ReusePlan planReusePooledConnection$okhttp = planReusePooledConnection$okhttp(planConnectToRoute$okhttp, planConnectToRoute$okhttp.getRoutes$okhttp());
                    if (planReusePooledConnection$okhttp != null) {
                        return planReusePooledConnection$okhttp;
                    }
                    return planConnectToRoute$okhttp;
                }
                throw new IllegalStateException("Check failed.");
            }
            if (releaseConnectionNoEvents$okhttp != null) {
                _UtilJvmKt.closeQuietly(releaseConnectionNoEvents$okhttp);
            }
            this.f24360c.getEventListener().connectionReleased(this.f24360c, connection);
        }
        reusePlan = null;
        if (reusePlan == null) {
        }
    }

    @NotNull
    public final ConnectPlan planConnectToRoute$okhttp(@NotNull Route route, @Nullable List<Route> routes) {
        Intrinsics.checkNotNullParameter(route, "route");
        if (route.address().sslSocketFactory() == null) {
            if (route.address().connectionSpecs().contains(ConnectionSpec.CLEARTEXT)) {
                String host = route.address().url().host();
                if (!Platform.INSTANCE.get().isCleartextTrafficPermitted(host)) {
                    throw new UnknownServiceException(ye0.m8296p("CLEARTEXT communication to ", host, " not permitted by network security policy"));
                }
            } else {
                throw new UnknownServiceException("CLEARTEXT communication not enabled for client");
            }
        } else if (route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            throw new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS");
        }
        Request request = null;
        if (route.requiresTunnel()) {
            Request build = new Request.Builder().url(route.address().url()).method("CONNECT", null).header(HttpHeaders.HOST, _UtilJvmKt.toHostHeader(route.address().url(), true)).header("Proxy-Connection", HttpHeaders.KEEP_ALIVE).header("User-Agent", _UtilCommonKt.userAgent).build();
            request = route.address().proxyAuthenticator().authenticate(route, new Response.Builder().request(build).protocol(Protocol.HTTP_1_1).code(HttpStatusCodesKt.HTTP_PROXY_AUTH).message("Preemptive Authenticate").sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header(HttpHeaders.PROXY_AUTHENTICATE, "OkHttp-Preemptive").build());
            if (request == null) {
                request = build;
            }
        }
        return new ConnectPlan(this.f24358a, this.f24360c, this, route, routes, 0, request, -1, false);
    }

    @Nullable
    public final ReusePlan planReusePooledConnection$okhttp(@Nullable ConnectPlan planToReplace, @Nullable List<Route> routes) {
        boolean z;
        RealConnectionPool delegate = this.f24358a.connectionPool().getDelegate();
        Address address = getAddress();
        if (planToReplace != null && planToReplace.isReady()) {
            z = true;
        } else {
            z = false;
        }
        RealConnection callAcquirePooledConnection = delegate.callAcquirePooledConnection(this.f24361d, address, this.f24360c, routes, z);
        if (callAcquirePooledConnection == null) {
            return null;
        }
        if (planToReplace != null) {
            this.f24364g = planToReplace.getRoute();
            planToReplace.closeQuietly();
        }
        RealCall realCall = this.f24360c;
        realCall.getEventListener().connectionAcquired(realCall, callAcquirePooledConnection);
        return new ReusePlan(callAcquirePooledConnection);
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public boolean sameHostAndPort(@NotNull HttpUrl url) {
        Intrinsics.checkNotNullParameter(url, "url");
        HttpUrl url2 = getAddress().url();
        if (url.port() == url2.port() && Intrinsics.areEqual(url.host(), url2.host())) {
            return true;
        }
        return false;
    }
}
