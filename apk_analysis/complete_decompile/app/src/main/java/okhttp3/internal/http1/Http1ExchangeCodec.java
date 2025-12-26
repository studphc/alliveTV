package okhttp3.internal.http1;

import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1726qj;
import p000.C2026yn;
import p000.a11;
import p000.b11;
import p000.c11;
import p000.ro2;
import p000.y01;
import p000.z01;

@Metadata(m5568d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 62\u00020\u0001:\u00077896:;<B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\"\u0010\u0015J\u000f\u0010#\u001a\u00020\u0013H\u0016¢\u0006\u0004\b#\u0010\u0015J\u001d\u0010'\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0019\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b,\u0010-J\u0015\u0010.\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b.\u0010/R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0011\u00104\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b4\u00105¨\u0006="}, m5569d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec;", "Lokhttp3/internal/http/ExchangeCodec;", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/internal/http/ExchangeCodec$Carrier;", "carrier", "Lokio/BufferedSource;", FirebaseAnalytics.Param.SOURCE, "Lokio/BufferedSink;", "sink", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/http/ExchangeCodec$Carrier;Lokio/BufferedSource;Lokio/BufferedSink;)V", "Lokhttp3/Request;", "request", "", "contentLength", "Lokio/Sink;", "createRequestBody", "(Lokhttp3/Request;J)Lokio/Sink;", "", "cancel", "()V", "writeRequestHeaders", "(Lokhttp3/Request;)V", "Lokhttp3/Response;", "response", "reportedContentLength", "(Lokhttp3/Response;)J", "Lokio/Source;", "openResponseBodySource", "(Lokhttp3/Response;)Lokio/Source;", "Lokhttp3/Headers;", "trailers", "()Lokhttp3/Headers;", "flushRequest", "finishRequest", "headers", "", "requestLine", "writeRequest", "(Lokhttp3/Headers;Ljava/lang/String;)V", "", "expectContinue", "Lokhttp3/Response$Builder;", "readResponseHeaders", "(Z)Lokhttp3/Response$Builder;", "skipConnectBody", "(Lokhttp3/Response;)V", "b", "Lokhttp3/internal/http/ExchangeCodec$Carrier;", "getCarrier", "()Lokhttp3/internal/http/ExchangeCodec$Carrier;", "isClosed", "()Z", "Companion", "y01", "z01", "a11", "b11", "c11", "d11", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Http1ExchangeCodec implements ExchangeCodec {

    /* renamed from: a */
    public final OkHttpClient f24406a;

    /* renamed from: b, reason: from kotlin metadata */
    public final ExchangeCodec.Carrier carrier;

    /* renamed from: c */
    public final BufferedSource f24408c;

    /* renamed from: d */
    public final BufferedSink f24409d;

    /* renamed from: e */
    public int f24410e;

    /* renamed from: f */
    public final HeadersReader f24411f;

    /* renamed from: g */
    public Headers f24412g;

    public Http1ExchangeCodec(@Nullable OkHttpClient okHttpClient, @NotNull ExchangeCodec.Carrier carrier, @NotNull BufferedSource source, @NotNull BufferedSink sink) {
        Intrinsics.checkNotNullParameter(carrier, "carrier");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.f24406a = okHttpClient;
        this.carrier = carrier;
        this.f24408c = source;
        this.f24409d = sink;
        this.f24411f = new HeadersReader(source);
    }

    public static final void access$detachTimeout(Http1ExchangeCodec http1ExchangeCodec, ForwardingTimeout forwardingTimeout) {
        http1ExchangeCodec.getClass();
        Timeout delegate = forwardingTimeout.getDelegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    /* renamed from: a */
    public final b11 m6625a(long j) {
        if (this.f24410e == 4) {
            this.f24410e = 5;
            return new b11(this, j);
        }
        throw new IllegalStateException(("state: " + this.f24410e).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        getCarrier().mo9049cancel();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Sink createRequestBody(@NotNull Request request, long contentLength) {
        Intrinsics.checkNotNullParameter(request, "request");
        RequestBody body = request.body();
        if (body != null && body.isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (ro2.equals("chunked", request.header(HttpHeaders.TRANSFER_ENCODING), true)) {
            if (this.f24410e == 1) {
                this.f24410e = 2;
                return new z01(this);
            }
            throw new IllegalStateException(("state: " + this.f24410e).toString());
        }
        if (contentLength != -1) {
            if (this.f24410e == 1) {
                this.f24410e = 2;
                return new c11(this);
            }
            throw new IllegalStateException(("state: " + this.f24410e).toString());
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        this.f24409d.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        this.f24409d.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public ExchangeCodec.Carrier getCarrier() {
        return this.carrier;
    }

    public final boolean isClosed() {
        if (this.f24410e == 6) {
            return true;
        }
        return false;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Source openResponseBodySource(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!okhttp3.internal.http.HttpHeaders.promisesBody(response)) {
            return m6625a(0L);
        }
        if (ro2.equals("chunked", Response.header$default(response, HttpHeaders.TRANSFER_ENCODING, null, 2, null), true)) {
            HttpUrl url = response.request().url();
            if (this.f24410e == 4) {
                this.f24410e = 5;
                return new a11(this, url);
            }
            throw new IllegalStateException(("state: " + this.f24410e).toString());
        }
        long headersContentLength = _UtilJvmKt.headersContentLength(response);
        if (headersContentLength != -1) {
            return m6625a(headersContentLength);
        }
        if (this.f24410e == 4) {
            this.f24410e = 5;
            getCarrier().noNewExchanges();
            return new y01(this);
        }
        throw new IllegalStateException(("state: " + this.f24410e).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @Nullable
    public Response.Builder readResponseHeaders(boolean expectContinue) {
        HeadersReader headersReader = this.f24411f;
        int i = this.f24410e;
        if (i != 1 && i != 2 && i != 3) {
            throw new IllegalStateException(("state: " + this.f24410e).toString());
        }
        try {
            StatusLine parse = StatusLine.INSTANCE.parse(headersReader.readLine());
            Response.Builder trailers = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(headersReader.readHeaders()).trailers(C2026yn.f29029f);
            if (expectContinue && parse.code == 100) {
                return null;
            }
            if (parse.code == 100) {
                this.f24410e = 3;
                return trailers;
            }
            this.f24410e = 4;
            return trailers;
        } catch (EOFException e) {
            throw new IOException(AbstractC1726qj.m7038C("unexpected end of stream on ", getCarrier().getRoute().address().url().redact()), e);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!okhttp3.internal.http.HttpHeaders.promisesBody(response)) {
            return 0L;
        }
        if (ro2.equals("chunked", Response.header$default(response, HttpHeaders.TRANSFER_ENCODING, null, 2, null), true)) {
            return -1L;
        }
        return _UtilJvmKt.headersContentLength(response);
    }

    public final void skipConnectBody(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        long headersContentLength = _UtilJvmKt.headersContentLength(response);
        if (headersContentLength == -1) {
            return;
        }
        b11 m6625a = m6625a(headersContentLength);
        _UtilJvmKt.skipAll(m6625a, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        m6625a.close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Headers trailers() {
        if (this.f24410e == 6) {
            Headers headers = this.f24412g;
            if (headers == null) {
                return _UtilJvmKt.EMPTY_HEADERS;
            }
            return headers;
        }
        throw new IllegalStateException("too early; can't read the trailers yet");
    }

    public final void writeRequest(@NotNull Headers headers, @NotNull String requestLine) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(requestLine, "requestLine");
        if (this.f24410e == 0) {
            BufferedSink bufferedSink = this.f24409d;
            bufferedSink.writeUtf8(requestLine).writeUtf8("\r\n");
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                bufferedSink.writeUtf8(headers.name(i)).writeUtf8(": ").writeUtf8(headers.value(i)).writeUtf8("\r\n");
            }
            bufferedSink.writeUtf8("\r\n");
            this.f24410e = 1;
            return;
        }
        throw new IllegalStateException(("state: " + this.f24410e).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(@NotNull Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        RequestLine requestLine = RequestLine.INSTANCE;
        Proxy.Type type = getCarrier().getRoute().proxy().type();
        Intrinsics.checkNotNullExpressionValue(type, "carrier.route.proxy.type()");
        writeRequest(request.headers(), requestLine.get(request, type));
    }
}
