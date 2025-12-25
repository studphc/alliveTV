package okhttp3;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal._HostnamesJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0003\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u0005\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u0007\u0010\u000f¨\u0006\""}, m5569d2 = {"Lokhttp3/Route;", "", "Lokhttp3/Address;", "address", "Ljava/net/Proxy;", "proxy", "Ljava/net/InetSocketAddress;", "socketAddress", "<init>", "(Lokhttp3/Address;Ljava/net/Proxy;Ljava/net/InetSocketAddress;)V", "-deprecated_address", "()Lokhttp3/Address;", "-deprecated_proxy", "()Ljava/net/Proxy;", "-deprecated_socketAddress", "()Ljava/net/InetSocketAddress;", "", "requiresTunnel", "()Z", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "a", "Lokhttp3/Address;", "b", "Ljava/net/Proxy;", "c", "Ljava/net/InetSocketAddress;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Route {

    /* renamed from: a, reason: from kotlin metadata */
    public final Address address;

    /* renamed from: b, reason: from kotlin metadata */
    public final Proxy proxy;

    /* renamed from: c, reason: from kotlin metadata */
    public final InetSocketAddress socketAddress;

    public Route(@NotNull Address address, @NotNull Proxy proxy, @NotNull InetSocketAddress socketAddress) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(socketAddress, "socketAddress");
        this.address = address;
        this.proxy = proxy;
        this.socketAddress = socketAddress;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "address", imports = {}))
    @JvmName(name = "-deprecated_address")
    @NotNull
    /* renamed from: -deprecated_address, reason: not valid java name and from getter */
    public final Address getAddress() {
        return this.address;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proxy", imports = {}))
    @JvmName(name = "-deprecated_proxy")
    @NotNull
    /* renamed from: -deprecated_proxy, reason: not valid java name and from getter */
    public final Proxy getProxy() {
        return this.proxy;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "socketAddress", imports = {}))
    @JvmName(name = "-deprecated_socketAddress")
    @NotNull
    /* renamed from: -deprecated_socketAddress, reason: not valid java name and from getter */
    public final InetSocketAddress getSocketAddress() {
        return this.socketAddress;
    }

    @JvmName(name = "address")
    @NotNull
    public final Address address() {
        return this.address;
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof Route) {
            Route route = (Route) other;
            if (Intrinsics.areEqual(route.address, this.address) && Intrinsics.areEqual(route.proxy, this.proxy) && Intrinsics.areEqual(route.socketAddress, this.socketAddress)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.socketAddress.hashCode() + ((this.proxy.hashCode() + ((this.address.hashCode() + 527) * 31)) * 31);
    }

    @JvmName(name = "proxy")
    @NotNull
    public final Proxy proxy() {
        return this.proxy;
    }

    public final boolean requiresTunnel() {
        if (this.proxy.type() != Proxy.Type.HTTP) {
            return false;
        }
        Address address = this.address;
        if (address.sslSocketFactory() == null && !address.protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            return false;
        }
        return true;
    }

    @JvmName(name = "socketAddress")
    @NotNull
    public final InetSocketAddress socketAddress() {
        return this.socketAddress;
    }

    @NotNull
    public String toString() {
        String str;
        String hostAddress;
        StringBuilder sb = new StringBuilder();
        Address address = this.address;
        String host = address.url().host();
        InetSocketAddress inetSocketAddress = this.socketAddress;
        InetAddress address2 = inetSocketAddress.getAddress();
        if (address2 != null && (hostAddress = address2.getHostAddress()) != null) {
            Intrinsics.checkNotNullExpressionValue(hostAddress, "hostAddress");
            str = _HostnamesJvmKt.toCanonicalHost(hostAddress);
        } else {
            str = null;
        }
        if (StringsKt__StringsKt.contains$default((CharSequence) host, ':', false, 2, (Object) null)) {
            sb.append("[");
            sb.append(host);
            sb.append("]");
        } else {
            sb.append(host);
        }
        if (address.url().port() != inetSocketAddress.getPort() || Intrinsics.areEqual(host, str)) {
            sb.append(":");
            sb.append(address.url().port());
        }
        if (!Intrinsics.areEqual(host, str)) {
            if (Intrinsics.areEqual(this.proxy, Proxy.NO_PROXY)) {
                sb.append(" at ");
            } else {
                sb.append(" via proxy ");
            }
            if (str == null) {
                sb.append("<unresolved>");
            } else if (StringsKt__StringsKt.contains$default((CharSequence) str, ':', false, 2, (Object) null)) {
                sb.append("[");
                sb.append(str);
                sb.append("]");
            } else {
                sb.append(str);
            }
            sb.append(":");
            sb.append(inetSocketAddress.getPort());
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
