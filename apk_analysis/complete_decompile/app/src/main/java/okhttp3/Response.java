package okhttp3;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal._ResponseCommonKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.connection.Exchange;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001nB\u0089\u0001\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b \u0010!J\u000f\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\"\u0010#J\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b$\u0010%J\u001b\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060'2\u0006\u0010&\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010(J%\u0010*\u001a\u0004\u0018\u00010\u00062\u0006\u0010&\u001a\u00020\u00062\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b*\u0010+J\u000f\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\f¢\u0006\u0004\b.\u0010-J\u0015\u00100\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u0013¢\u0006\u0004\b0\u00101J\u000f\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b2\u00103J\r\u00105\u001a\u000204¢\u0006\u0004\b5\u00106J\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b7\u00108J\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b9\u00108J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b:\u00108J\u0013\u0010<\u001a\b\u0012\u0004\u0012\u00020;0'¢\u0006\u0004\b<\u0010=J\u000f\u0010A\u001a\u00020>H\u0007¢\u0006\u0004\b?\u0010@J\u000f\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\bB\u0010CJ\u000f\u0010\u0015\u001a\u00020\u0013H\u0007¢\u0006\u0004\bD\u0010CJ\u000f\u0010F\u001a\u00020EH\u0016¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0006H\u0016¢\u0006\u0004\bH\u0010#R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\b\u0003\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\b\u0005\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\b\u0007\u0010#R\u0017\u0010\t\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\b\t\u0010!R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0007¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\b\u000b\u0010%R\u0017\u0010\r\u001a\u00020\f8\u0007¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\b\r\u0010-R\u0017\u0010\u000f\u001a\u00020\u000e8\u0007¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\b\u000f\u00103R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\b\u0010\u00108R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\bY\u0010X\u001a\u0004\b\u0011\u00108R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\bZ\u0010X\u001a\u0004\b\u0012\u00108R\u0017\u0010\u0014\u001a\u00020\u00138\u0007¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b\u0014\u0010CR\u0017\u0010\u0015\u001a\u00020\u00138\u0007¢\u0006\f\n\u0004\b]\u0010\\\u001a\u0004\b\u0015\u0010CR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0001X\u0080\u0004¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b\u0017\u0010`R$\u0010f\u001a\u0004\u0018\u00010>8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010@\"\u0004\bd\u0010eR\u0017\u0010j\u001a\u00020g8\u0006¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u0017\u0010m\u001a\u00020g8\u0006¢\u0006\f\n\u0004\bl\u0010i\u001a\u0004\bm\u0010kR\u0011\u0010A\u001a\u00020>8G¢\u0006\u0006\u001a\u0004\bA\u0010@¨\u0006o"}, m5569d2 = {"Lokhttp3/Response;", "Ljava/io/Closeable;", "Lokhttp3/Request;", "request", "Lokhttp3/Protocol;", "protocol", "", "message", "", "code", "Lokhttp3/Handshake;", "handshake", "Lokhttp3/Headers;", "headers", "Lokhttp3/ResponseBody;", "body", "networkResponse", "cacheResponse", "priorResponse", "", "sentRequestAtMillis", "receivedResponseAtMillis", "Lokhttp3/internal/connection/Exchange;", "exchange", "Lkotlin/Function0;", "trailersFn", "<init>", "(Lokhttp3/Request;Lokhttp3/Protocol;Ljava/lang/String;ILokhttp3/Handshake;Lokhttp3/Headers;Lokhttp3/ResponseBody;Lokhttp3/Response;Lokhttp3/Response;Lokhttp3/Response;JJLokhttp3/internal/connection/Exchange;Lkotlin/jvm/functions/Function0;)V", "-deprecated_request", "()Lokhttp3/Request;", "-deprecated_protocol", "()Lokhttp3/Protocol;", "-deprecated_code", "()I", "-deprecated_message", "()Ljava/lang/String;", "-deprecated_handshake", "()Lokhttp3/Handshake;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "(Ljava/lang/String;)Ljava/util/List;", "defaultValue", "header", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "-deprecated_headers", "()Lokhttp3/Headers;", "trailers", "byteCount", "peekBody", "(J)Lokhttp3/ResponseBody;", "-deprecated_body", "()Lokhttp3/ResponseBody;", "Lokhttp3/Response$Builder;", "newBuilder", "()Lokhttp3/Response$Builder;", "-deprecated_networkResponse", "()Lokhttp3/Response;", "-deprecated_cacheResponse", "-deprecated_priorResponse", "Lokhttp3/Challenge;", "challenges", "()Ljava/util/List;", "Lokhttp3/CacheControl;", "-deprecated_cacheControl", "()Lokhttp3/CacheControl;", "cacheControl", "-deprecated_sentRequestAtMillis", "()J", "-deprecated_receivedResponseAtMillis", "", "close", "()V", "toString", "a", "Lokhttp3/Request;", "b", "Lokhttp3/Protocol;", "c", "Ljava/lang/String;", "d", "I", "e", "Lokhttp3/Handshake;", "f", "Lokhttp3/Headers;", "g", "Lokhttp3/ResponseBody;", "h", "Lokhttp3/Response;", "i", "j", "k", "J", "l", "m", "Lokhttp3/internal/connection/Exchange;", "()Lokhttp3/internal/connection/Exchange;", "o", "Lokhttp3/CacheControl;", "getLazyCacheControl$okhttp", "setLazyCacheControl$okhttp", "(Lokhttp3/CacheControl;)V", "lazyCacheControl", "", "p", "Z", "isSuccessful", "()Z", "q", "isRedirect", "Builder", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Response implements Closeable {

    /* renamed from: a, reason: from kotlin metadata */
    public final Request request;

    /* renamed from: b, reason: from kotlin metadata */
    public final Protocol protocol;

    /* renamed from: c, reason: from kotlin metadata */
    public final String message;

    /* renamed from: d, reason: from kotlin metadata */
    public final int code;

    /* renamed from: e, reason: from kotlin metadata */
    public final Handshake handshake;

    /* renamed from: f, reason: from kotlin metadata */
    public final Headers headers;

    /* renamed from: g, reason: from kotlin metadata */
    public final ResponseBody body;

    /* renamed from: h, reason: from kotlin metadata */
    public final Response networkResponse;

    /* renamed from: i, reason: from kotlin metadata */
    public final Response cacheResponse;

    /* renamed from: j, reason: from kotlin metadata */
    public final Response priorResponse;

    /* renamed from: k, reason: from kotlin metadata */
    public final long sentRequestAtMillis;

    /* renamed from: l, reason: from kotlin metadata */
    public final long receivedResponseAtMillis;

    /* renamed from: m, reason: from kotlin metadata */
    public final Exchange exchange;

    /* renamed from: n */
    public final Function0 f24110n;

    /* renamed from: o, reason: from kotlin metadata */
    public CacheControl lazyCacheControl;

    /* renamed from: p, reason: from kotlin metadata */
    public final boolean isSuccessful;

    /* renamed from: q, reason: from kotlin metadata */
    public final boolean isRedirect;

    public Response(@NotNull Request request, @NotNull Protocol protocol, @NotNull String message, int i, @Nullable Handshake handshake, @NotNull Headers headers, @NotNull ResponseBody body, @Nullable Response response, @Nullable Response response2, @Nullable Response response3, long j, long j2, @Nullable Exchange exchange, @NotNull Function0<Headers> trailersFn) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(trailersFn, "trailersFn");
        this.request = request;
        this.protocol = protocol;
        this.message = message;
        this.code = i;
        this.handshake = handshake;
        this.headers = headers;
        this.body = body;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j;
        this.receivedResponseAtMillis = j2;
        this.exchange = exchange;
        this.f24110n = trailersFn;
        this.isSuccessful = _ResponseCommonKt.getCommonIsSuccessful(this);
        this.isRedirect = _ResponseCommonKt.getCommonIsRedirect(this);
    }

    public static /* synthetic */ String header$default(Response response, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return response.header(str, str2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "body", imports = {}))
    @JvmName(name = "-deprecated_body")
    @NotNull
    /* renamed from: -deprecated_body, reason: not valid java name and from getter */
    public final ResponseBody getBody() {
        return this.body;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cacheControl", imports = {}))
    @JvmName(name = "-deprecated_cacheControl")
    @NotNull
    /* renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final CacheControl m9033deprecated_cacheControl() {
        return cacheControl();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cacheResponse", imports = {}))
    @JvmName(name = "-deprecated_cacheResponse")
    @Nullable
    /* renamed from: -deprecated_cacheResponse, reason: not valid java name and from getter */
    public final Response getCacheResponse() {
        return this.cacheResponse;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "code", imports = {}))
    @JvmName(name = "-deprecated_code")
    /* renamed from: -deprecated_code, reason: not valid java name and from getter */
    public final int getCode() {
        return this.code;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "handshake", imports = {}))
    @JvmName(name = "-deprecated_handshake")
    @Nullable
    /* renamed from: -deprecated_handshake, reason: not valid java name and from getter */
    public final Handshake getHandshake() {
        return this.handshake;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "headers", imports = {}))
    @JvmName(name = "-deprecated_headers")
    @NotNull
    /* renamed from: -deprecated_headers, reason: not valid java name and from getter */
    public final Headers getHeaders() {
        return this.headers;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "message", imports = {}))
    @JvmName(name = "-deprecated_message")
    @NotNull
    /* renamed from: -deprecated_message, reason: not valid java name and from getter */
    public final String getMessage() {
        return this.message;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "networkResponse", imports = {}))
    @JvmName(name = "-deprecated_networkResponse")
    @Nullable
    /* renamed from: -deprecated_networkResponse, reason: not valid java name and from getter */
    public final Response getNetworkResponse() {
        return this.networkResponse;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "priorResponse", imports = {}))
    @JvmName(name = "-deprecated_priorResponse")
    @Nullable
    /* renamed from: -deprecated_priorResponse, reason: not valid java name and from getter */
    public final Response getPriorResponse() {
        return this.priorResponse;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "protocol", imports = {}))
    @JvmName(name = "-deprecated_protocol")
    @NotNull
    /* renamed from: -deprecated_protocol, reason: not valid java name and from getter */
    public final Protocol getProtocol() {
        return this.protocol;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "receivedResponseAtMillis", imports = {}))
    @JvmName(name = "-deprecated_receivedResponseAtMillis")
    /* renamed from: -deprecated_receivedResponseAtMillis, reason: not valid java name and from getter */
    public final long getReceivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "request", imports = {}))
    @JvmName(name = "-deprecated_request")
    @NotNull
    /* renamed from: -deprecated_request, reason: not valid java name and from getter */
    public final Request getRequest() {
        return this.request;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sentRequestAtMillis", imports = {}))
    @JvmName(name = "-deprecated_sentRequestAtMillis")
    /* renamed from: -deprecated_sentRequestAtMillis, reason: not valid java name and from getter */
    public final long getSentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    @JvmName(name = "body")
    @NotNull
    public final ResponseBody body() {
        return this.body;
    }

    @JvmName(name = "cacheControl")
    @NotNull
    public final CacheControl cacheControl() {
        return _ResponseCommonKt.getCommonCacheControl(this);
    }

    @JvmName(name = "cacheResponse")
    @Nullable
    public final Response cacheResponse() {
        return this.cacheResponse;
    }

    @NotNull
    public final List<Challenge> challenges() {
        String str;
        int i = this.code;
        if (i != 401) {
            if (i != 407) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            str = HttpHeaders.PROXY_AUTHENTICATE;
        } else {
            str = HttpHeaders.WWW_AUTHENTICATE;
        }
        return okhttp3.internal.http.HttpHeaders.parseChallenges(this.headers, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        _ResponseCommonKt.commonClose(this);
    }

    @JvmName(name = "code")
    public final int code() {
        return this.code;
    }

    @JvmName(name = "exchange")
    @Nullable
    /* renamed from: exchange, reason: from getter */
    public final Exchange getExchange() {
        return this.exchange;
    }

    @Nullable
    /* renamed from: getLazyCacheControl$okhttp, reason: from getter */
    public final CacheControl getLazyCacheControl() {
        return this.lazyCacheControl;
    }

    @JvmName(name = "handshake")
    @Nullable
    public final Handshake handshake() {
        return this.handshake;
    }

    @JvmOverloads
    @Nullable
    public final String header(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return header$default(this, name, null, 2, null);
    }

    @JvmName(name = "headers")
    @NotNull
    public final Headers headers() {
        return this.headers;
    }

    /* renamed from: isRedirect, reason: from getter */
    public final boolean getIsRedirect() {
        return this.isRedirect;
    }

    /* renamed from: isSuccessful, reason: from getter */
    public final boolean getIsSuccessful() {
        return this.isSuccessful;
    }

    @JvmName(name = "message")
    @NotNull
    public final String message() {
        return this.message;
    }

    @JvmName(name = "networkResponse")
    @Nullable
    public final Response networkResponse() {
        return this.networkResponse;
    }

    @NotNull
    public final Builder newBuilder() {
        return _ResponseCommonKt.commonNewBuilder(this);
    }

    @NotNull
    public final ResponseBody peekBody(long byteCount) {
        ResponseBody responseBody = this.body;
        BufferedSource peek = responseBody.source().peek();
        Buffer buffer = new Buffer();
        peek.request(byteCount);
        buffer.write((Source) peek, Math.min(byteCount, peek.getBuffer().size()));
        return ResponseBody.INSTANCE.create(buffer, responseBody.contentType(), buffer.size());
    }

    @JvmName(name = "priorResponse")
    @Nullable
    public final Response priorResponse() {
        return this.priorResponse;
    }

    @JvmName(name = "protocol")
    @NotNull
    public final Protocol protocol() {
        return this.protocol;
    }

    @JvmName(name = "receivedResponseAtMillis")
    public final long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @JvmName(name = "request")
    @NotNull
    public final Request request() {
        return this.request;
    }

    @JvmName(name = "sentRequestAtMillis")
    public final long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public final void setLazyCacheControl$okhttp(@Nullable CacheControl cacheControl) {
        this.lazyCacheControl = cacheControl;
    }

    @NotNull
    public String toString() {
        return _ResponseCommonKt.commonToString(this);
    }

    @NotNull
    public final Headers trailers() {
        return (Headers) this.f24110n.invoke();
    }

    @JvmOverloads
    @Nullable
    public final String header(@NotNull String name, @Nullable String defaultValue) {
        Intrinsics.checkNotNullParameter(name, "name");
        return _ResponseCommonKt.commonHeader(this, name, defaultValue);
    }

    @NotNull
    public final List<String> headers(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return _ResponseCommonKt.commonHeaders(this, name);
    }

    @Metadata(m5568d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b+\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001b\u0010\u0012J\u0017\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\"\u0010#J\u0019\u0010$\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b$\u0010#J\u0019\u0010%\u001a\u00020\u00002\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b%\u0010#J\u001d\u0010(\u001a\u00020\u00002\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0&H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u00002\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00002\u0006\u0010-\u001a\u00020*H\u0016¢\u0006\u0004\b-\u0010,J\u0017\u00103\u001a\u0002002\u0006\u0010/\u001a\u00020.H\u0000¢\u0006\u0004\b1\u00102J\u000f\u00104\u001a\u00020\u0004H\u0016¢\u0006\u0004\b4\u00105R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010\u000e\u001a\u00020\r8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010\u001d\u001a\u00020T8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010 \u001a\u00020\u001f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R$\u0010\"\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u00105\"\u0004\bd\u0010\u0006R$\u0010$\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\be\u0010b\u001a\u0004\bf\u00105\"\u0004\bg\u0010\u0006R$\u0010%\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bh\u0010b\u001a\u0004\bi\u00105\"\u0004\bj\u0010\u0006R\"\u0010+\u001a\u00020*8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010-\u001a\u00020*8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bq\u0010l\u001a\u0004\br\u0010n\"\u0004\bs\u0010pR$\u0010/\u001a\u0004\u0018\u00010.8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u00102R(\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0&8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\by\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~¨\u0006\u007f"}, m5569d2 = {"Lokhttp3/Response$Builder;", "", "<init>", "()V", "Lokhttp3/Response;", "response", "(Lokhttp3/Response;)V", "Lokhttp3/Request;", "request", "(Lokhttp3/Request;)Lokhttp3/Response$Builder;", "Lokhttp3/Protocol;", "protocol", "(Lokhttp3/Protocol;)Lokhttp3/Response$Builder;", "", "code", "(I)Lokhttp3/Response$Builder;", "", "message", "(Ljava/lang/String;)Lokhttp3/Response$Builder;", "Lokhttp3/Handshake;", "handshake", "(Lokhttp3/Handshake;)Lokhttp3/Response$Builder;", AppMeasurementSdk.ConditionalUserProperty.NAME, "value", "header", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Response$Builder;", "addHeader", "removeHeader", "Lokhttp3/Headers;", "headers", "(Lokhttp3/Headers;)Lokhttp3/Response$Builder;", "Lokhttp3/ResponseBody;", "body", "(Lokhttp3/ResponseBody;)Lokhttp3/Response$Builder;", "networkResponse", "(Lokhttp3/Response;)Lokhttp3/Response$Builder;", "cacheResponse", "priorResponse", "Lkotlin/Function0;", "trailersFn", "trailers", "(Lkotlin/jvm/functions/Function0;)Lokhttp3/Response$Builder;", "", "sentRequestAtMillis", "(J)Lokhttp3/Response$Builder;", "receivedResponseAtMillis", "Lokhttp3/internal/connection/Exchange;", "exchange", "", "initExchange$okhttp", "(Lokhttp3/internal/connection/Exchange;)V", "initExchange", "build", "()Lokhttp3/Response;", "a", "Lokhttp3/Request;", "getRequest$okhttp", "()Lokhttp3/Request;", "setRequest$okhttp", "(Lokhttp3/Request;)V", "b", "Lokhttp3/Protocol;", "getProtocol$okhttp", "()Lokhttp3/Protocol;", "setProtocol$okhttp", "(Lokhttp3/Protocol;)V", "c", "I", "getCode$okhttp", "()I", "setCode$okhttp", "(I)V", "d", "Ljava/lang/String;", "getMessage$okhttp", "()Ljava/lang/String;", "setMessage$okhttp", "(Ljava/lang/String;)V", "e", "Lokhttp3/Handshake;", "getHandshake$okhttp", "()Lokhttp3/Handshake;", "setHandshake$okhttp", "(Lokhttp3/Handshake;)V", "Lokhttp3/Headers$Builder;", "f", "Lokhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "g", "Lokhttp3/ResponseBody;", "getBody$okhttp", "()Lokhttp3/ResponseBody;", "setBody$okhttp", "(Lokhttp3/ResponseBody;)V", "h", "Lokhttp3/Response;", "getNetworkResponse$okhttp", "setNetworkResponse$okhttp", "i", "getCacheResponse$okhttp", "setCacheResponse$okhttp", "j", "getPriorResponse$okhttp", "setPriorResponse$okhttp", "k", "J", "getSentRequestAtMillis$okhttp", "()J", "setSentRequestAtMillis$okhttp", "(J)V", "l", "getReceivedResponseAtMillis$okhttp", "setReceivedResponseAtMillis$okhttp", "m", "Lokhttp3/internal/connection/Exchange;", "getExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "setExchange$okhttp", "n", "Lkotlin/jvm/functions/Function0;", "getTrailersFn$okhttp", "()Lkotlin/jvm/functions/Function0;", "setTrailersFn$okhttp", "(Lkotlin/jvm/functions/Function0;)V", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a, reason: from kotlin metadata */
        public Request request;

        /* renamed from: b, reason: from kotlin metadata */
        public Protocol protocol;

        /* renamed from: c, reason: from kotlin metadata */
        public int code;

        /* renamed from: d, reason: from kotlin metadata */
        public String message;

        /* renamed from: e, reason: from kotlin metadata */
        public Handshake handshake;

        /* renamed from: f, reason: from kotlin metadata */
        public Headers.Builder headers;

        /* renamed from: g, reason: from kotlin metadata */
        public ResponseBody body;

        /* renamed from: h, reason: from kotlin metadata */
        public Response networkResponse;

        /* renamed from: i, reason: from kotlin metadata */
        public Response cacheResponse;

        /* renamed from: j, reason: from kotlin metadata */
        public Response priorResponse;

        /* renamed from: k, reason: from kotlin metadata */
        public long sentRequestAtMillis;

        /* renamed from: l, reason: from kotlin metadata */
        public long receivedResponseAtMillis;

        /* renamed from: m, reason: from kotlin metadata */
        public Exchange exchange;

        /* renamed from: n, reason: from kotlin metadata */
        public Function0 trailersFn;

        public Builder() {
            this.code = -1;
            this.body = _UtilCommonKt.getCommonEmptyResponse();
            this.trailersFn = C1632g.f24141b;
            this.headers = new Headers.Builder();
        }

        @NotNull
        public Builder addHeader(@NotNull String name, @NotNull String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            return _ResponseCommonKt.commonAddHeader(this, name, value);
        }

        @NotNull
        public Builder body(@NotNull ResponseBody body) {
            Intrinsics.checkNotNullParameter(body, "body");
            return _ResponseCommonKt.commonBody(this, body);
        }

        @NotNull
        public Response build() {
            int i = this.code;
            if (i >= 0) {
                Request request = this.request;
                if (request != null) {
                    Protocol protocol = this.protocol;
                    if (protocol != null) {
                        String str = this.message;
                        if (str != null) {
                            return new Response(request, protocol, str, i, this.handshake, this.headers.build(), this.body, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange, this.trailersFn);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("protocol == null");
                }
                throw new IllegalStateException("request == null");
            }
            throw new IllegalStateException(("code < 0: " + this.code).toString());
        }

        @NotNull
        public Builder cacheResponse(@Nullable Response cacheResponse) {
            return _ResponseCommonKt.commonCacheResponse(this, cacheResponse);
        }

        @NotNull
        public Builder code(int code) {
            return _ResponseCommonKt.commonCode(this, code);
        }

        @NotNull
        /* renamed from: getBody$okhttp, reason: from getter */
        public final ResponseBody getBody() {
            return this.body;
        }

        @Nullable
        /* renamed from: getCacheResponse$okhttp, reason: from getter */
        public final Response getCacheResponse() {
            return this.cacheResponse;
        }

        /* renamed from: getCode$okhttp, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        @Nullable
        /* renamed from: getExchange$okhttp, reason: from getter */
        public final Exchange getExchange() {
            return this.exchange;
        }

        @Nullable
        /* renamed from: getHandshake$okhttp, reason: from getter */
        public final Handshake getHandshake() {
            return this.handshake;
        }

        @NotNull
        /* renamed from: getHeaders$okhttp, reason: from getter */
        public final Headers.Builder getHeaders() {
            return this.headers;
        }

        @Nullable
        /* renamed from: getMessage$okhttp, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        @Nullable
        /* renamed from: getNetworkResponse$okhttp, reason: from getter */
        public final Response getNetworkResponse() {
            return this.networkResponse;
        }

        @Nullable
        /* renamed from: getPriorResponse$okhttp, reason: from getter */
        public final Response getPriorResponse() {
            return this.priorResponse;
        }

        @Nullable
        /* renamed from: getProtocol$okhttp, reason: from getter */
        public final Protocol getProtocol() {
            return this.protocol;
        }

        /* renamed from: getReceivedResponseAtMillis$okhttp, reason: from getter */
        public final long getReceivedResponseAtMillis() {
            return this.receivedResponseAtMillis;
        }

        @Nullable
        /* renamed from: getRequest$okhttp, reason: from getter */
        public final Request getRequest() {
            return this.request;
        }

        /* renamed from: getSentRequestAtMillis$okhttp, reason: from getter */
        public final long getSentRequestAtMillis() {
            return this.sentRequestAtMillis;
        }

        @NotNull
        public final Function0<Headers> getTrailersFn$okhttp() {
            return this.trailersFn;
        }

        @NotNull
        public Builder handshake(@Nullable Handshake handshake) {
            this.handshake = handshake;
            return this;
        }

        @NotNull
        public Builder header(@NotNull String name, @NotNull String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            return _ResponseCommonKt.commonHeader(this, name, value);
        }

        @NotNull
        public Builder headers(@NotNull Headers headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            return _ResponseCommonKt.commonHeaders(this, headers);
        }

        public final void initExchange$okhttp(@NotNull Exchange exchange) {
            Intrinsics.checkNotNullParameter(exchange, "exchange");
            this.exchange = exchange;
            this.trailersFn = new C1631f(exchange);
        }

        @NotNull
        public Builder message(@NotNull String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return _ResponseCommonKt.commonMessage(this, message);
        }

        @NotNull
        public Builder networkResponse(@Nullable Response networkResponse) {
            return _ResponseCommonKt.commonNetworkResponse(this, networkResponse);
        }

        @NotNull
        public Builder priorResponse(@Nullable Response priorResponse) {
            return _ResponseCommonKt.commonPriorResponse(this, priorResponse);
        }

        @NotNull
        public Builder protocol(@NotNull Protocol protocol) {
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            return _ResponseCommonKt.commonProtocol(this, protocol);
        }

        @NotNull
        public Builder receivedResponseAtMillis(long receivedResponseAtMillis) {
            this.receivedResponseAtMillis = receivedResponseAtMillis;
            return this;
        }

        @NotNull
        public Builder removeHeader(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return _ResponseCommonKt.commonRemoveHeader(this, name);
        }

        @NotNull
        public Builder request(@NotNull Request request) {
            Intrinsics.checkNotNullParameter(request, "request");
            return _ResponseCommonKt.commonRequest(this, request);
        }

        @NotNull
        public Builder sentRequestAtMillis(long sentRequestAtMillis) {
            this.sentRequestAtMillis = sentRequestAtMillis;
            return this;
        }

        public final void setBody$okhttp(@NotNull ResponseBody responseBody) {
            Intrinsics.checkNotNullParameter(responseBody, "<set-?>");
            this.body = responseBody;
        }

        public final void setCacheResponse$okhttp(@Nullable Response response) {
            this.cacheResponse = response;
        }

        public final void setCode$okhttp(int i) {
            this.code = i;
        }

        public final void setExchange$okhttp(@Nullable Exchange exchange) {
            this.exchange = exchange;
        }

        public final void setHandshake$okhttp(@Nullable Handshake handshake) {
            this.handshake = handshake;
        }

        public final void setHeaders$okhttp(@NotNull Headers.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMessage$okhttp(@Nullable String str) {
            this.message = str;
        }

        public final void setNetworkResponse$okhttp(@Nullable Response response) {
            this.networkResponse = response;
        }

        public final void setPriorResponse$okhttp(@Nullable Response response) {
            this.priorResponse = response;
        }

        public final void setProtocol$okhttp(@Nullable Protocol protocol) {
            this.protocol = protocol;
        }

        public final void setReceivedResponseAtMillis$okhttp(long j) {
            this.receivedResponseAtMillis = j;
        }

        public final void setRequest$okhttp(@Nullable Request request) {
            this.request = request;
        }

        public final void setSentRequestAtMillis$okhttp(long j) {
            this.sentRequestAtMillis = j;
        }

        public final void setTrailersFn$okhttp(@NotNull Function0<Headers> function0) {
            Intrinsics.checkNotNullParameter(function0, "<set-?>");
            this.trailersFn = function0;
        }

        @NotNull
        public Builder trailers(@NotNull Function0<Headers> trailersFn) {
            Intrinsics.checkNotNullParameter(trailersFn, "trailersFn");
            return _ResponseCommonKt.commonTrailers(this, trailersFn);
        }

        public Builder(@NotNull Response response) {
            Intrinsics.checkNotNullParameter(response, "response");
            this.code = -1;
            this.body = _UtilCommonKt.getCommonEmptyResponse();
            this.trailersFn = C1632g.f24141b;
            this.request = response.request();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.handshake = response.handshake();
            this.headers = response.headers().newBuilder();
            this.body = response.body();
            this.networkResponse = response.networkResponse();
            this.cacheResponse = response.cacheResponse();
            this.priorResponse = response.priorResponse();
            this.sentRequestAtMillis = response.sentRequestAtMillis();
            this.receivedResponseAtMillis = response.receivedResponseAtMillis();
            this.exchange = response.getExchange();
            this.trailersFn = response.f24110n;
        }
    }
}
