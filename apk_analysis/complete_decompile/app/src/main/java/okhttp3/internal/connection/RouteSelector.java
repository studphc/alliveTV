package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal._UtilJvmKt;
import org.jetbrains.annotations.NotNull;
import p000.AbstractC1167eq;
import p000.AbstractC1327iq;

@Metadata(m5568d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\bH\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H\u0086\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, m5569d2 = {"Lokhttp3/internal/connection/RouteSelector;", "", "Lokhttp3/Address;", "address", "Lokhttp3/internal/connection/RouteDatabase;", "routeDatabase", "Lokhttp3/Call;", NotificationCompat.CATEGORY_CALL, "", "fastFallback", "Lokhttp3/EventListener;", "eventListener", "<init>", "(Lokhttp3/Address;Lokhttp3/internal/connection/RouteDatabase;Lokhttp3/Call;ZLokhttp3/EventListener;)V", "hasNext", "()Z", "Lokhttp3/internal/connection/RouteSelector$Selection;", "next", "()Lokhttp3/internal/connection/RouteSelector$Selection;", "Companion", "Selection", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class RouteSelector {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a */
    public final Address f24371a;

    /* renamed from: b */
    public final RouteDatabase f24372b;

    /* renamed from: c */
    public final Call f24373c;

    /* renamed from: d */
    public final boolean f24374d;

    /* renamed from: e */
    public final EventListener f24375e;

    /* renamed from: f */
    public final List f24376f;

    /* renamed from: g */
    public int f24377g;

    /* renamed from: h */
    public List f24378h;

    /* renamed from: i */
    public final ArrayList f24379i;

    @Metadata(m5568d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0015\u0010\u0006\u001a\u00020\u0003*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, m5569d2 = {"Lokhttp3/internal/connection/RouteSelector$Companion;", "", "Ljava/net/InetSocketAddress;", "", "getSocketHost", "(Ljava/net/InetSocketAddress;)Ljava/lang/String;", "socketHost", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @NotNull
        public final String getSocketHost(@NotNull InetSocketAddress inetSocketAddress) {
            Intrinsics.checkNotNullParameter(inetSocketAddress, "<this>");
            InetAddress address = inetSocketAddress.getAddress();
            if (address == null) {
                String hostName = inetSocketAddress.getHostName();
                Intrinsics.checkNotNullExpressionValue(hostName, "hostName");
                return hostName;
            }
            String hostAddress = address.getHostAddress();
            Intrinsics.checkNotNullExpressionValue(hostAddress, "address.hostAddress");
            return hostAddress;
        }
    }

    @Metadata(m5568d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m5569d2 = {"Lokhttp3/internal/connection/RouteSelector$Selection;", "", "", "Lokhttp3/Route;", "routes", "<init>", "(Ljava/util/List;)V", "", "hasNext", "()Z", "next", "()Lokhttp3/Route;", "a", "Ljava/util/List;", "getRoutes", "()Ljava/util/List;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Selection {

        /* renamed from: a, reason: from kotlin metadata */
        public final List routes;

        /* renamed from: b */
        public int f24381b;

        public Selection(@NotNull List<Route> routes) {
            Intrinsics.checkNotNullParameter(routes, "routes");
            this.routes = routes;
        }

        @NotNull
        public final List<Route> getRoutes() {
            return this.routes;
        }

        public final boolean hasNext() {
            if (this.f24381b < this.routes.size()) {
                return true;
            }
            return false;
        }

        @NotNull
        public final Route next() {
            if (hasNext()) {
                int i = this.f24381b;
                this.f24381b = i + 1;
                return (Route) this.routes.get(i);
            }
            throw new NoSuchElementException();
        }
    }

    public RouteSelector(@NotNull Address address, @NotNull RouteDatabase routeDatabase, @NotNull Call call, boolean z, @NotNull EventListener eventListener) {
        List<Proxy> immutableListOf;
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(routeDatabase, "routeDatabase");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.f24371a = address;
        this.f24372b = routeDatabase;
        this.f24373c = call;
        this.f24374d = z;
        this.f24375e = eventListener;
        this.f24376f = CollectionsKt__CollectionsKt.emptyList();
        this.f24378h = CollectionsKt__CollectionsKt.emptyList();
        this.f24379i = new ArrayList();
        HttpUrl url = address.url();
        Proxy proxy = address.proxy();
        eventListener.proxySelectStart(call, url);
        if (proxy != null) {
            immutableListOf = AbstractC1167eq.listOf(proxy);
        } else {
            URI uri = url.uri();
            if (uri.getHost() == null) {
                immutableListOf = _UtilJvmKt.immutableListOf(Proxy.NO_PROXY);
            } else {
                List<Proxy> proxiesOrNull = address.proxySelector().select(uri);
                if (proxiesOrNull != null && !proxiesOrNull.isEmpty()) {
                    Intrinsics.checkNotNullExpressionValue(proxiesOrNull, "proxiesOrNull");
                    immutableListOf = _UtilJvmKt.toImmutableList(proxiesOrNull);
                } else {
                    immutableListOf = _UtilJvmKt.immutableListOf(Proxy.NO_PROXY);
                }
            }
        }
        this.f24376f = immutableListOf;
        this.f24377g = 0;
        eventListener.proxySelectEnd(call, url, immutableListOf);
    }

    public final boolean hasNext() {
        if (this.f24377g < this.f24376f.size() || !this.f24379i.isEmpty()) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Selection next() {
        boolean z;
        ArrayList arrayList;
        String host;
        int port;
        List<InetAddress> list;
        if (hasNext()) {
            ArrayList arrayList2 = new ArrayList();
            do {
                boolean z2 = false;
                if (this.f24377g < this.f24376f.size()) {
                    z = true;
                } else {
                    z = false;
                }
                arrayList = this.f24379i;
                if (!z) {
                    break;
                }
                if (this.f24377g < this.f24376f.size()) {
                    z2 = true;
                }
                Address address = this.f24371a;
                if (z2) {
                    List list2 = this.f24376f;
                    int i = this.f24377g;
                    this.f24377g = i + 1;
                    Proxy proxy = (Proxy) list2.get(i);
                    ArrayList arrayList3 = new ArrayList();
                    this.f24378h = arrayList3;
                    if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
                        SocketAddress proxyAddress = proxy.address();
                        if (proxyAddress instanceof InetSocketAddress) {
                            Companion companion = INSTANCE;
                            Intrinsics.checkNotNullExpressionValue(proxyAddress, "proxyAddress");
                            InetSocketAddress inetSocketAddress = (InetSocketAddress) proxyAddress;
                            host = companion.getSocketHost(inetSocketAddress);
                            port = inetSocketAddress.getPort();
                        } else {
                            throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + proxyAddress.getClass()).toString());
                        }
                    } else {
                        host = address.url().host();
                        port = address.url().port();
                    }
                    if (1 <= port && port < 65536) {
                        if (proxy.type() == Proxy.Type.SOCKS) {
                            arrayList3.add(InetSocketAddress.createUnresolved(host, port));
                        } else {
                            if (_HostnamesCommonKt.canParseAsIpAddress(host)) {
                                list = AbstractC1167eq.listOf(InetAddress.getByName(host));
                            } else {
                                EventListener eventListener = this.f24375e;
                                Call call = this.f24373c;
                                eventListener.dnsStart(call, host);
                                List<InetAddress> lookup = address.dns().lookup(host);
                                if (!lookup.isEmpty()) {
                                    eventListener.dnsEnd(call, host, lookup);
                                    list = lookup;
                                } else {
                                    throw new UnknownHostException(address.dns() + " returned no addresses for " + host);
                                }
                            }
                            if (this.f24374d) {
                                list = InetAddressOrderKt.reorderForHappyEyeballs(list);
                            }
                            Iterator<InetAddress> it = list.iterator();
                            while (it.hasNext()) {
                                arrayList3.add(new InetSocketAddress(it.next(), port));
                            }
                        }
                        Iterator it2 = this.f24378h.iterator();
                        while (it2.hasNext()) {
                            Route route = new Route(address, proxy, (InetSocketAddress) it2.next());
                            if (this.f24372b.shouldPostpone(route)) {
                                arrayList.add(route);
                            } else {
                                arrayList2.add(route);
                            }
                        }
                    } else {
                        throw new SocketException("No route to " + host + ':' + port + "; port is out of range");
                    }
                } else {
                    throw new SocketException("No route to " + address.url().host() + "; exhausted proxy configurations: " + this.f24376f);
                }
            } while (arrayList2.isEmpty());
            if (arrayList2.isEmpty()) {
                AbstractC1327iq.addAll(arrayList2, arrayList);
                arrayList.clear();
            }
            return new Selection(arrayList2);
        }
        throw new NoSuchElementException();
    }
}
