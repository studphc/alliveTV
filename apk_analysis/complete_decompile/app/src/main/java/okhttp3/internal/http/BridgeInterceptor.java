package okhttp3.internal.http;

import com.hisona.allive.HttpRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okio.GzipSource;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import p000.ro2;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, m5569d2 = {"Lokhttp3/internal/http/BridgeInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/CookieJar;", "cookieJar", "<init>", "(Lokhttp3/CookieJar;)V", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class BridgeInterceptor implements Interceptor {

    /* renamed from: a */
    public final CookieJar f24383a;

    public BridgeInterceptor(@NotNull CookieJar cookieJar) {
        Intrinsics.checkNotNullParameter(cookieJar, "cookieJar");
        this.f24383a = cookieJar;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        boolean z;
        ResponseBody body;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        RequestBody body2 = request.body();
        if (body2 != null) {
            MediaType f23990d = body2.getF23990d();
            if (f23990d != null) {
                newBuilder.header("Content-Type", f23990d.toString());
            }
            long contentLength = body2.contentLength();
            if (contentLength != -1) {
                newBuilder.header("Content-Length", String.valueOf(contentLength));
                newBuilder.removeHeader(com.google.common.net.HttpHeaders.TRANSFER_ENCODING);
            } else {
                newBuilder.header(com.google.common.net.HttpHeaders.TRANSFER_ENCODING, "chunked");
                newBuilder.removeHeader("Content-Length");
            }
        }
        int i = 0;
        if (request.header(com.google.common.net.HttpHeaders.HOST) == null) {
            newBuilder.header(com.google.common.net.HttpHeaders.HOST, _UtilJvmKt.toHostHeader$default(request.url(), false, 1, null));
        }
        if (request.header(com.google.common.net.HttpHeaders.CONNECTION) == null) {
            newBuilder.header(com.google.common.net.HttpHeaders.CONNECTION, com.google.common.net.HttpHeaders.KEEP_ALIVE);
        }
        if (request.header("Accept-Encoding") == null && request.header(com.google.common.net.HttpHeaders.RANGE) == null) {
            newBuilder.header("Accept-Encoding", HttpRequest.ENCODING_GZIP);
            z = true;
        } else {
            z = false;
        }
        HttpUrl url = request.url();
        CookieJar cookieJar = this.f24383a;
        List<Cookie> loadForRequest = cookieJar.loadForRequest(url);
        if (!loadForRequest.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : loadForRequest) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Cookie cookie = (Cookie) obj;
                if (i > 0) {
                    sb.append("; ");
                }
                sb.append(cookie.name());
                sb.append('=');
                sb.append(cookie.value());
                i = i2;
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            newBuilder.header(com.google.common.net.HttpHeaders.COOKIE, sb2);
        }
        if (request.header("User-Agent") == null) {
            newBuilder.header("User-Agent", _UtilCommonKt.userAgent);
        }
        Request build = newBuilder.build();
        Response proceed = chain.proceed(build);
        HttpHeaders.receiveHeaders(cookieJar, build.url(), proceed.headers());
        Response.Builder request2 = proceed.newBuilder().request(build);
        if (z && ro2.equals(HttpRequest.ENCODING_GZIP, Response.header$default(proceed, "Content-Encoding", null, 2, null), true) && HttpHeaders.promisesBody(proceed) && (body = proceed.body()) != null) {
            GzipSource gzipSource = new GzipSource(body.getF24155d());
            request2.headers(proceed.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
            request2.body(new RealResponseBody(Response.header$default(proceed, "Content-Type", null, 2, null), -1L, Okio.buffer(gzipSource)));
        }
        return request2.build();
    }
}
