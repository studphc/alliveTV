package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal._ResponseCommonKt;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http2.ConnectionShutdownException;
import okio.BufferedSink;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import p000.ha0;
import p000.ro2;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, m5569d2 = {"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/Interceptor;", "", "forWebSocket", "<init>", "(Z)V", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class CallServerInterceptor implements Interceptor {

    /* renamed from: a */
    public final boolean f24384a;

    public CallServerInterceptor(boolean z) {
        this.f24384a = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e5 A[Catch: IOException -> 0x00ba, TryCatch #0 {IOException -> 0x00ba, blocks: (B:57:0x00ac, B:59:0x00b5, B:22:0x00bd, B:24:0x00e5, B:26:0x00ee, B:27:0x00f1, B:28:0x0115, B:32:0x0120, B:33:0x0135, B:35:0x0143, B:43:0x0159, B:45:0x0168, B:46:0x0189, B:54:0x014e, B:55:0x0125), top: B:56:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    @Override // okhttp3.Interceptor
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(@NotNull Interceptor.Chain chain) {
        boolean z;
        Response.Builder builder;
        Response.Builder builder2;
        Response build;
        int code;
        Response build2;
        Response.Builder builder3;
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Exchange exchange = realInterceptorChain.getExchange();
        Intrinsics.checkNotNull(exchange);
        Request request = realInterceptorChain.getRequest();
        RequestBody body = request.body();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            exchange.writeRequestHeaders(request);
            ?? permitsRequestBody = HttpMethod.permitsRequestBody(request.method());
            try {
                if (permitsRequestBody != 0 && body != null) {
                    if (ro2.equals("100-continue", request.header(com.google.common.net.HttpHeaders.EXPECT), true)) {
                        exchange.flushRequest();
                        Response.Builder readResponseHeaders = exchange.readResponseHeaders(true);
                        try {
                            exchange.responseHeadersStart();
                            z = false;
                            builder3 = readResponseHeaders;
                        } catch (IOException e) {
                            e = e;
                            z = true;
                            builder = readResponseHeaders;
                            if (!(e instanceof ConnectionShutdownException)) {
                                builder2 = builder;
                                if (!exchange.getHasFailure()) {
                                    throw e;
                                }
                                if (builder2 == null) {
                                }
                                build = builder2.request(request).handshake(exchange.getConnection$okhttp().getF24337f()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
                                code = build.code();
                                if (code == 100) {
                                }
                                exchange.responseHeadersEnd(build);
                                if (!this.f24384a) {
                                }
                                build2 = build.newBuilder().body(exchange.openResponseBody(build)).build();
                                if (!ro2.equals("close", build2.request().header(com.google.common.net.HttpHeaders.CONNECTION), true)) {
                                }
                                exchange.noNewExchangesOnConnection();
                                if (code == 204) {
                                }
                                throw new ProtocolException("HTTP " + code + " had non-zero Content-Length: " + build2.body().getF24143c());
                            }
                            throw e;
                        }
                    } else {
                        z = true;
                        builder3 = null;
                    }
                    if (builder3 == null) {
                        if (body.isDuplex()) {
                            exchange.flushRequest();
                            body.writeTo(Okio.buffer(exchange.createRequestBody(request, true)));
                            permitsRequestBody = builder3;
                        } else {
                            BufferedSink buffer = Okio.buffer(exchange.createRequestBody(request, false));
                            body.writeTo(buffer);
                            buffer.close();
                            permitsRequestBody = builder3;
                        }
                    } else {
                        exchange.noRequestBody();
                        permitsRequestBody = builder3;
                        if (!exchange.getConnection$okhttp().isMultiplexed$okhttp()) {
                            exchange.noNewExchangesOnConnection();
                            permitsRequestBody = builder3;
                        }
                    }
                } else {
                    exchange.noRequestBody();
                    z = true;
                    permitsRequestBody = 0;
                }
                if (body == null || !body.isDuplex()) {
                    exchange.finishRequest();
                }
                e = null;
                builder2 = permitsRequestBody;
            } catch (IOException e2) {
                e = e2;
                builder = permitsRequestBody;
            }
        } catch (IOException e3) {
            e = e3;
            z = true;
            builder = null;
        }
        if (builder2 == null) {
            try {
                builder2 = exchange.readResponseHeaders(false);
                Intrinsics.checkNotNull(builder2);
                if (z) {
                    exchange.responseHeadersStart();
                    z = false;
                }
            } catch (IOException e4) {
                if (e != null) {
                    ha0.addSuppressed(e, e4);
                    throw e;
                }
                throw e4;
            }
        }
        build = builder2.request(request).handshake(exchange.getConnection$okhttp().getF24337f()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        code = build.code();
        if (code == 100) {
            Response.Builder readResponseHeaders2 = exchange.readResponseHeaders(false);
            Intrinsics.checkNotNull(readResponseHeaders2);
            if (z) {
                exchange.responseHeadersStart();
            }
            build = readResponseHeaders2.request(request).handshake(exchange.getConnection$okhttp().getF24337f()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            code = build.code();
        }
        exchange.responseHeadersEnd(build);
        if (!this.f24384a && code == 101) {
            build2 = _ResponseCommonKt.stripBody(build);
        } else {
            build2 = build.newBuilder().body(exchange.openResponseBody(build)).build();
        }
        if (!ro2.equals("close", build2.request().header(com.google.common.net.HttpHeaders.CONNECTION), true) || ro2.equals("close", Response.header$default(build2, com.google.common.net.HttpHeaders.CONNECTION, null, 2, null), true)) {
            exchange.noNewExchangesOnConnection();
        }
        if ((code == 204 && code != 205) || build2.body().getF24143c() <= 0) {
            return build2;
        }
        throw new ProtocolException("HTTP " + code + " had non-zero Content-Length: " + build2.body().getF24143c());
    }
}
