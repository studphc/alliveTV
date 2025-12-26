package okhttp3.internal.http;

import com.hisona.allive.HttpRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http2.ConnectionShutdownException;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, m5569d2 = {"Lokhttp3/internal/http/RetryAndFollowUpInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/OkHttpClient;", "client", "<init>", "(Lokhttp3/OkHttpClient;)V", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Companion", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {

    /* renamed from: a */
    public final OkHttpClient f24403a;

    public RetryAndFollowUpInterceptor(@NotNull OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.f24403a = client;
    }

    /* renamed from: b */
    public static int m6623b(Response response, int i) {
        String header$default = Response.header$default(response, com.google.common.net.HttpHeaders.RETRY_AFTER, null, 2, null);
        if (header$default == null) {
            return i;
        }
        if (new Regex("\\d+").matches(header$default)) {
            Integer valueOf = Integer.valueOf(header$default);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(header)");
            return valueOf.intValue();
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: a */
    public final Request m6624a(Response response, Exchange exchange) {
        Route route;
        String header$default;
        HttpUrl resolve;
        RealConnection connection$okhttp;
        RequestBody requestBody = null;
        if (exchange != null && (connection$okhttp = exchange.getConnection$okhttp()) != null) {
            route = connection$okhttp.route();
        } else {
            route = null;
        }
        int code = response.code();
        String method = response.request().method();
        boolean z = false;
        OkHttpClient okHttpClient = this.f24403a;
        if (code != 307 && code != 308) {
            if (code != 401) {
                if (code != 421) {
                    if (code != 503) {
                        if (code != 407) {
                            if (code != 408) {
                                switch (code) {
                                    case HttpStatusCodesKt.HTTP_MULT_CHOICE /* 300 */:
                                    case 301:
                                    case 302:
                                    case 303:
                                        break;
                                    default:
                                        return null;
                                }
                            } else {
                                if (!okHttpClient.retryOnConnectionFailure()) {
                                    return null;
                                }
                                RequestBody body = response.request().body();
                                if (body != null && body.isOneShot()) {
                                    return null;
                                }
                                Response priorResponse = response.priorResponse();
                                if ((priorResponse != null && priorResponse.code() == 408) || m6623b(response, 0) > 0) {
                                    return null;
                                }
                                return response.request();
                            }
                        } else {
                            Intrinsics.checkNotNull(route);
                            if (route.proxy().type() == Proxy.Type.HTTP) {
                                return okHttpClient.proxyAuthenticator().authenticate(route, response);
                            }
                            throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                        }
                    } else {
                        Response priorResponse2 = response.priorResponse();
                        if ((priorResponse2 != null && priorResponse2.code() == 503) || m6623b(response, Integer.MAX_VALUE) != 0) {
                            return null;
                        }
                        return response.request();
                    }
                } else {
                    RequestBody body2 = response.request().body();
                    if ((body2 != null && body2.isOneShot()) || exchange == null || !exchange.isCoalescedConnection$okhttp()) {
                        return null;
                    }
                    exchange.getConnection$okhttp().noCoalescedConnections$okhttp();
                    return response.request();
                }
            } else {
                return okHttpClient.authenticator().authenticate(route, response);
            }
        }
        if (!okHttpClient.followRedirects() || (header$default = Response.header$default(response, "Location", null, 2, null)) == null || (resolve = response.request().url().resolve(header$default)) == null) {
            return null;
        }
        if (!Intrinsics.areEqual(resolve.scheme(), response.request().url().scheme()) && !okHttpClient.followSslRedirects()) {
            return null;
        }
        Request.Builder newBuilder = response.request().newBuilder();
        if (HttpMethod.permitsRequestBody(method)) {
            int code2 = response.code();
            HttpMethod httpMethod = HttpMethod.INSTANCE;
            if (httpMethod.redirectsWithBody(method) || code2 == 308 || code2 == 307) {
                z = true;
            }
            if (httpMethod.redirectsToGet(method) && code2 != 308 && code2 != 307) {
                newBuilder.method(HttpRequest.METHOD_GET, null);
            } else {
                if (z) {
                    requestBody = response.request().body();
                }
                newBuilder.method(method, requestBody);
            }
            if (!z) {
                newBuilder.removeHeader(com.google.common.net.HttpHeaders.TRANSFER_ENCODING);
                newBuilder.removeHeader("Content-Length");
                newBuilder.removeHeader("Content-Type");
            }
        }
        if (!_UtilJvmKt.canReuseConnectionFor(response.request().url(), resolve)) {
            newBuilder.removeHeader("Authorization");
        }
        return newBuilder.url(resolve).build();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        r0 = r12.proceed(r0).newBuilder().request(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
    
        if (r7 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
    
        r6 = okhttp3.internal._ResponseCommonKt.stripBody(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        r7 = r0.priorResponse(r6).build();
        r0 = r1.getInterceptorScopedExchange();
        r6 = m6624a(r7, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0049, code lost:
    
        if (r6 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
    
        r0 = r6.body();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005e, code lost:
    
        if (r0 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
    
        if (r0.isOneShot() == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0066, code lost:
    
        r1.exitNetworkInterceptorExchange$okhttp(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006a, code lost:
    
        okhttp3.internal._UtilCommonKt.closeQuietly(r7.body());
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
    
        if (r8 > 20) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0092, code lost:
    
        throw new java.net.ProtocolException("Too many follow-up requests: " + r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004b, code lost:
    
        if (r0 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0051, code lost:
    
        if (r0.getIsDuplex() == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0053, code lost:
    
        r1.timeoutEarlyExit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0056, code lost:
    
        r1.exitNetworkInterceptorExchange$okhttp(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0059, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0038, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d5 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #0 {all -> 0x0035, blocks: (B:5:0x001c, B:8:0x0022, B:11:0x0026, B:13:0x0030, B:14:0x0039, B:33:0x004d, B:35:0x0053, B:16:0x005a, B:18:0x0060, B:24:0x006a, B:29:0x007c, B:30:0x0092, B:79:0x00e4, B:80:0x00eb, B:40:0x0094, B:43:0x00a0, B:45:0x00a6, B:50:0x00ac, B:53:0x00b0, B:55:0x00b4, B:57:0x00b8, B:61:0x00cf, B:63:0x00d5, B:68:0x00bf, B:70:0x00c3, B:73:0x00cb, B:48:0x00df, B:49:0x00e3), top: B:4:0x001c, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00df A[EDGE_INSN: B:65:0x00df->B:48:0x00df BREAK  A[LOOP:0: B:2:0x0018->B:27:0x0077, LOOP_LABEL: LOOP:0: B:2:0x0018->B:27:0x0077], SYNTHETIC] */
    @Override // okhttp3.Interceptor
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(@NotNull Interceptor.Chain chain) {
        RequestBody body;
        Request m6624a;
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = realInterceptorChain.getRequest();
        RealCall realCall = realInterceptorChain.getAndroidx.core.app.NotificationCompat.CATEGORY_CALL java.lang.String();
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        int i = 0;
        Response response = null;
        loop0: while (true) {
            boolean z = true;
            while (true) {
                realCall.enterNetworkInterceptorExchange(request, z, realInterceptorChain);
                try {
                    if (!realCall.getF24324p()) {
                        try {
                            break;
                        } catch (IOException e) {
                            boolean z2 = e instanceof ConnectionShutdownException;
                            if (!this.f24403a.retryOnConnectionFailure() || ((!z2 && (((body = request.body()) != null && body.isOneShot()) || (e instanceof FileNotFoundException))) || (e instanceof ProtocolException))) {
                                break loop0;
                            }
                            if (e instanceof InterruptedIOException) {
                                if (!(e instanceof SocketTimeoutException) || !z2) {
                                    break loop0;
                                }
                                if (realCall.retryAfterFailure()) {
                                    break loop0;
                                }
                                emptyList = CollectionsKt___CollectionsKt.plus((Collection<? extends IOException>) emptyList, e);
                                realCall.exitNetworkInterceptorExchange$okhttp(true);
                                z = false;
                            } else {
                                if (e instanceof SSLHandshakeException) {
                                    if (e.getCause() instanceof CertificateException) {
                                        break loop0;
                                    }
                                }
                                if (e instanceof SSLPeerUnverifiedException) {
                                    break loop0;
                                }
                                if (realCall.retryAfterFailure()) {
                                }
                            }
                            throw _UtilCommonKt.withSuppressed(e, emptyList);
                        }
                    }
                    throw new IOException("Canceled");
                } catch (Throwable th) {
                    realCall.exitNetworkInterceptorExchange$okhttp(true);
                    throw th;
                }
            }
            realCall.exitNetworkInterceptorExchange$okhttp(true);
            request = m6624a;
        }
    }
}
