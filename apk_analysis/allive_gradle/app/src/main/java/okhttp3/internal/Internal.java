package okhttp3.internal;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.hisona.allive.HttpRequest;
import java.nio.charset.Charset;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.Cache;
import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealConnection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t\u001a\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t\u001a\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0016\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0013\u001a \u0010\u001d\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\t\u001a\u0016\u0010#\u001a\u00020$*\u0004\u0018\u00010%2\b\b\u0002\u0010&\u001a\u00020$\u001a\u001a\u0010'\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010%0(*\u0004\u0018\u00010%\u001a#\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0**\u00020\u000f2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\t0*¢\u0006\u0002\u0010,\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006-"}, m5569d2 = {"connection", "Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/Response;", "getConnection", "(Lokhttp3/Response;)Lokhttp3/internal/connection/RealConnection;", "addHeaderLenient", "Lokhttp3/Headers$Builder;", "builder", "line", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "value", "applyConnectionSpec", "", "connectionSpec", "Lokhttp3/ConnectionSpec;", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "isFallback", "", "cacheGet", "cache", "Lokhttp3/Cache;", "request", "Lokhttp3/Request;", "cookieToString", "cookie", "Lokhttp3/Cookie;", "forObsoleteRfc2965", "parseCookie", "currentTimeMillis", "", ImagesContract.URL, "Lokhttp3/HttpUrl;", "setCookie", HttpRequest.PARAM_CHARSET, "Ljava/nio/charset/Charset;", "Lokhttp3/MediaType;", "defaultValue", "chooseCharset", "Lkotlin/Pair;", "effectiveCipherSuites", "", "socketEnabledCipherSuites", "(Lokhttp3/ConnectionSpec;[Ljava/lang/String;)[Ljava/lang/String;", "okhttp"}, m5570k = 2, m5571mv = {1, 6, 0}, m5573xi = 48)
@JvmName(name = "Internal")
/* loaded from: classes2.dex */
public final class Internal {
    @NotNull
    public static final Headers.Builder addHeaderLenient(@NotNull Headers.Builder builder, @NotNull String line) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(line, "line");
        return builder.addLenient$okhttp(line);
    }

    public static final void applyConnectionSpec(@NotNull ConnectionSpec connectionSpec, @NotNull SSLSocket sslSocket, boolean z) {
        Intrinsics.checkNotNullParameter(connectionSpec, "connectionSpec");
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        connectionSpec.apply$okhttp(sslSocket, z);
    }

    @Nullable
    public static final Response cacheGet(@NotNull Cache cache, @NotNull Request request) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(request, "request");
        return cache.get$okhttp(request);
    }

    @NotNull
    public static final Charset charset(@Nullable MediaType mediaType, @NotNull Charset defaultValue) {
        Charset charset;
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (mediaType == null || (charset = mediaType.charset(defaultValue)) == null) {
            return Charsets.UTF_8;
        }
        return charset;
    }

    public static /* synthetic */ Charset charset$default(MediaType mediaType, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return charset(mediaType, charset);
    }

    @NotNull
    public static final Pair<Charset, MediaType> chooseCharset(@Nullable MediaType mediaType) {
        Charset charset = Charsets.UTF_8;
        if (mediaType != null) {
            Charset charset$default = MediaType.charset$default(mediaType, null, 1, null);
            if (charset$default == null) {
                mediaType = MediaType.INSTANCE.parse(mediaType + "; charset=utf-8");
            } else {
                charset = charset$default;
            }
        }
        return TuplesKt.m5575to(charset, mediaType);
    }

    @NotNull
    public static final String cookieToString(@NotNull Cookie cookie, boolean z) {
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        return cookie.toString$okhttp(z);
    }

    @NotNull
    public static final String[] effectiveCipherSuites(@NotNull ConnectionSpec connectionSpec, @NotNull String[] socketEnabledCipherSuites) {
        Intrinsics.checkNotNullParameter(connectionSpec, "<this>");
        Intrinsics.checkNotNullParameter(socketEnabledCipherSuites, "socketEnabledCipherSuites");
        if (connectionSpec.getCipherSuitesAsString() != null) {
            return _UtilCommonKt.intersect(socketEnabledCipherSuites, connectionSpec.getCipherSuitesAsString(), CipherSuite.INSTANCE.getORDER_BY_NAME$okhttp());
        }
        return socketEnabledCipherSuites;
    }

    @NotNull
    public static final RealConnection getConnection(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        Exchange exchange = response.getExchange();
        Intrinsics.checkNotNull(exchange);
        return exchange.getConnection$okhttp();
    }

    @Nullable
    public static final Cookie parseCookie(long j, @NotNull HttpUrl url, @NotNull String setCookie) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(setCookie, "setCookie");
        return Cookie.INSTANCE.parse$okhttp(j, url, setCookie);
    }

    @NotNull
    public static final Headers.Builder addHeaderLenient(@NotNull Headers.Builder builder, @NotNull String name, @NotNull String value) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return builder.addLenient$okhttp(name, value);
    }
}
