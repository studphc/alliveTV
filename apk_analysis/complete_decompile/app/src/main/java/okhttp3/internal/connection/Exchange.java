package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.ws.RealWebSocket;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ia0;

@Metadata(m5568d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002STB'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u0017J\r\u0010\u0019\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\u0011¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b#\u0010$J\r\u0010&\u001a\u00020%¢\u0006\u0004\b&\u0010'J\r\u0010)\u001a\u00020(¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\u000e¢\u0006\u0004\b+\u0010\u0017J\r\u0010,\u001a\u00020\u000e¢\u0006\u0004\b,\u0010\u0017J\r\u0010-\u001a\u00020\u000e¢\u0006\u0004\b-\u0010\u0017J\r\u0010.\u001a\u00020\u000e¢\u0006\u0004\b.\u0010\u0017J9\u00106\u001a\u00028\u0000\"\n\b\u0000\u00100*\u0004\u0018\u00010/2\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u00112\u0006\u00105\u001a\u00028\u0000¢\u0006\u0004\b6\u00107J\r\u00108\u001a\u00020\u000e¢\u0006\u0004\b8\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR$\u0010I\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\u00118\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b5\u0010F\u001a\u0004\bG\u0010HR$\u0010L\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\u00118\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bJ\u0010F\u001a\u0004\bK\u0010HR\u0014\u0010P\u001a\u00020M8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010R\u001a\u00020\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010H¨\u0006U"}, m5569d2 = {"Lokhttp3/internal/connection/Exchange;", "", "Lokhttp3/internal/connection/RealCall;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/EventListener;", "eventListener", "Lokhttp3/internal/connection/ExchangeFinder;", "finder", "Lokhttp3/internal/http/ExchangeCodec;", "codec", "<init>", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;Lokhttp3/internal/connection/ExchangeFinder;Lokhttp3/internal/http/ExchangeCodec;)V", "Lokhttp3/Request;", "request", "", "writeRequestHeaders", "(Lokhttp3/Request;)V", "", "duplex", "Lokio/Sink;", "createRequestBody", "(Lokhttp3/Request;Z)Lokio/Sink;", "flushRequest", "()V", "finishRequest", "responseHeadersStart", "expectContinue", "Lokhttp3/Response$Builder;", "readResponseHeaders", "(Z)Lokhttp3/Response$Builder;", "Lokhttp3/Response;", "response", "responseHeadersEnd", "(Lokhttp3/Response;)V", "Lokhttp3/ResponseBody;", "openResponseBody", "(Lokhttp3/Response;)Lokhttp3/ResponseBody;", "Lokhttp3/Headers;", "trailers", "()Lokhttp3/Headers;", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "newWebSocketStreams", "()Lokhttp3/internal/ws/RealWebSocket$Streams;", "webSocketUpgradeFailed", "noNewExchangesOnConnection", "cancel", "detachWithViolence", "Ljava/io/IOException;", ExifInterface.LONGITUDE_EAST, "", "bytesRead", "responseDone", "requestDone", "e", "bodyComplete", "(JZZLjava/io/IOException;)Ljava/io/IOException;", "noRequestBody", "a", "Lokhttp3/internal/connection/RealCall;", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", "b", "Lokhttp3/EventListener;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "c", "Lokhttp3/internal/connection/ExchangeFinder;", "getFinder$okhttp", "()Lokhttp3/internal/connection/ExchangeFinder;", "<set-?>", "Z", "isDuplex$okhttp", "()Z", "isDuplex", "f", "getHasFailure$okhttp", "hasFailure", "Lokhttp3/internal/connection/RealConnection;", "getConnection$okhttp", "()Lokhttp3/internal/connection/RealConnection;", "connection", "isCoalescedConnection$okhttp", "isCoalescedConnection", "ia0", "ResponseBodySource", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Exchange {

    /* renamed from: a, reason: from kotlin metadata */
    public final RealCall call;

    /* renamed from: b, reason: from kotlin metadata */
    public final EventListener eventListener;

    /* renamed from: c, reason: from kotlin metadata */
    public final ExchangeFinder finder;

    /* renamed from: d */
    public final ExchangeCodec f24291d;

    /* renamed from: e, reason: from kotlin metadata */
    public boolean isDuplex;

    /* renamed from: f, reason: from kotlin metadata */
    public boolean hasFailure;

    @Metadata(m5568d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00028\u0000\"\n\b\u0000\u0010\u0011*\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m5569d2 = {"Lokhttp3/internal/connection/Exchange$ResponseBodySource;", "Lokio/ForwardingSource;", "Lokio/Source;", "delegate", "", "contentLength", "<init>", "(Lokhttp3/internal/connection/Exchange;Lokio/Source;J)V", "Lokio/Buffer;", "sink", "byteCount", "read", "(Lokio/Buffer;J)J", "", "close", "()V", "Ljava/io/IOException;", ExifInterface.LONGITUDE_EAST, "e", "complete", "(Ljava/io/IOException;)Ljava/io/IOException;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public final class ResponseBodySource extends ForwardingSource {

        /* renamed from: b */
        public final long f24294b;

        /* renamed from: c */
        public long f24295c;

        /* renamed from: d */
        public boolean f24296d;

        /* renamed from: e */
        public boolean f24297e;

        /* renamed from: f */
        public boolean f24298f;

        /* renamed from: g */
        public final /* synthetic */ Exchange f24299g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResponseBodySource(@NotNull Exchange exchange, Source delegate, long j) {
            super(delegate);
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.f24299g = exchange;
            this.f24294b = j;
            this.f24296d = true;
            if (j == 0) {
                complete(null);
            }
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f24298f) {
                return;
            }
            this.f24298f = true;
            try {
                super.close();
                complete(null);
            } catch (IOException e) {
                throw complete(e);
            }
        }

        public final <E extends IOException> E complete(E e) {
            if (this.f24297e) {
                return e;
            }
            this.f24297e = true;
            if (e == null && this.f24296d) {
                this.f24296d = false;
                Exchange exchange = this.f24299g;
                exchange.getEventListener().responseBodyStart(exchange.getCall());
            }
            return (E) this.f24299g.bodyComplete(this.f24295c, true, false, e);
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(@NotNull Buffer sink, long byteCount) {
            Exchange exchange = this.f24299g;
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (!this.f24298f) {
                try {
                    long read = delegate().read(sink, byteCount);
                    if (this.f24296d) {
                        this.f24296d = false;
                        exchange.getEventListener().responseBodyStart(exchange.getCall());
                    }
                    if (read == -1) {
                        complete(null);
                        return -1L;
                    }
                    long j = this.f24295c + read;
                    long j2 = this.f24294b;
                    if (j2 != -1 && j > j2) {
                        throw new ProtocolException("expected " + j2 + " bytes but received " + j);
                    }
                    this.f24295c = j;
                    if (j == j2) {
                        complete(null);
                    }
                    return read;
                } catch (IOException e) {
                    throw complete(e);
                }
            }
            throw new IllegalStateException("closed");
        }
    }

    public Exchange(@NotNull RealCall call, @NotNull EventListener eventListener, @NotNull ExchangeFinder finder, @NotNull ExchangeCodec codec) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        Intrinsics.checkNotNullParameter(finder, "finder");
        Intrinsics.checkNotNullParameter(codec, "codec");
        this.call = call;
        this.eventListener = eventListener;
        this.finder = finder;
        this.f24291d = codec;
    }

    /* renamed from: a */
    public final void m6615a(IOException iOException) {
        this.hasFailure = true;
        this.f24291d.getCarrier().trackFailure(this.call, iOException);
    }

    public final <E extends IOException> E bodyComplete(long bytesRead, boolean responseDone, boolean requestDone, E e) {
        if (e != null) {
            m6615a(e);
        }
        EventListener eventListener = this.eventListener;
        RealCall realCall = this.call;
        if (requestDone) {
            if (e != null) {
                eventListener.requestFailed(realCall, e);
            } else {
                eventListener.requestBodyEnd(realCall, bytesRead);
            }
        }
        if (responseDone) {
            if (e != null) {
                eventListener.responseFailed(realCall, e);
            } else {
                eventListener.responseBodyEnd(realCall, bytesRead);
            }
        }
        return (E) realCall.messageDone$okhttp(this, requestDone, responseDone, e);
    }

    public final void cancel() {
        this.f24291d.cancel();
    }

    @NotNull
    public final Sink createRequestBody(@NotNull Request request, boolean duplex) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.isDuplex = duplex;
        RequestBody body = request.body();
        Intrinsics.checkNotNull(body);
        long contentLength = body.contentLength();
        this.eventListener.requestBodyStart(this.call);
        return new ia0(this, this.f24291d.createRequestBody(request, contentLength), contentLength);
    }

    public final void detachWithViolence() {
        this.f24291d.cancel();
        this.call.messageDone$okhttp(this, true, true, null);
    }

    public final void finishRequest() {
        try {
            this.f24291d.finishRequest();
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            m6615a(e);
            throw e;
        }
    }

    public final void flushRequest() {
        try {
            this.f24291d.flushRequest();
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            m6615a(e);
            throw e;
        }
    }

    @NotNull
    /* renamed from: getCall$okhttp, reason: from getter */
    public final RealCall getCall() {
        return this.call;
    }

    @NotNull
    public final RealConnection getConnection$okhttp() {
        RealConnection realConnection;
        ExchangeCodec.Carrier carrier = this.f24291d.getCarrier();
        if (carrier instanceof RealConnection) {
            realConnection = (RealConnection) carrier;
        } else {
            realConnection = null;
        }
        if (realConnection != null) {
            return realConnection;
        }
        throw new IllegalStateException("no connection for CONNECT tunnels");
    }

    @NotNull
    /* renamed from: getEventListener$okhttp, reason: from getter */
    public final EventListener getEventListener() {
        return this.eventListener;
    }

    @NotNull
    /* renamed from: getFinder$okhttp, reason: from getter */
    public final ExchangeFinder getFinder() {
        return this.finder;
    }

    /* renamed from: getHasFailure$okhttp, reason: from getter */
    public final boolean getHasFailure() {
        return this.hasFailure;
    }

    public final boolean isCoalescedConnection$okhttp() {
        return !Intrinsics.areEqual(this.finder.getRoutePlanner().getAddress().url().host(), this.f24291d.getCarrier().getRoute().address().url().host());
    }

    /* renamed from: isDuplex$okhttp, reason: from getter */
    public final boolean getIsDuplex() {
        return this.isDuplex;
    }

    @NotNull
    public final RealWebSocket.Streams newWebSocketStreams() {
        this.call.timeoutEarlyExit();
        return ((RealConnection) this.f24291d.getCarrier()).newWebSocketStreams$okhttp(this);
    }

    public final void noNewExchangesOnConnection() {
        this.f24291d.getCarrier().noNewExchanges();
    }

    public final void noRequestBody() {
        this.call.messageDone$okhttp(this, true, false, null);
    }

    @NotNull
    public final ResponseBody openResponseBody(@NotNull Response response) {
        ExchangeCodec exchangeCodec = this.f24291d;
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            String header$default = Response.header$default(response, "Content-Type", null, 2, null);
            long reportedContentLength = exchangeCodec.reportedContentLength(response);
            return new RealResponseBody(header$default, reportedContentLength, Okio.buffer(new ResponseBodySource(this, exchangeCodec.openResponseBodySource(response), reportedContentLength)));
        } catch (IOException e) {
            this.eventListener.responseFailed(this.call, e);
            m6615a(e);
            throw e;
        }
    }

    @Nullable
    public final Response.Builder readResponseHeaders(boolean expectContinue) {
        try {
            Response.Builder readResponseHeaders = this.f24291d.readResponseHeaders(expectContinue);
            if (readResponseHeaders != null) {
                readResponseHeaders.initExchange$okhttp(this);
            }
            return readResponseHeaders;
        } catch (IOException e) {
            this.eventListener.responseFailed(this.call, e);
            m6615a(e);
            throw e;
        }
    }

    public final void responseHeadersEnd(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        this.eventListener.responseHeadersEnd(this.call, response);
    }

    public final void responseHeadersStart() {
        this.eventListener.responseHeadersStart(this.call);
    }

    @NotNull
    public final Headers trailers() {
        return this.f24291d.trailers();
    }

    public final void webSocketUpgradeFailed() {
        bodyComplete(-1L, true, true, null);
    }

    public final void writeRequestHeaders(@NotNull Request request) {
        RealCall realCall = this.call;
        EventListener eventListener = this.eventListener;
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            eventListener.requestHeadersStart(realCall);
            this.f24291d.writeRequestHeaders(request);
            eventListener.requestHeadersEnd(realCall, request);
        } catch (IOException e) {
            eventListener.requestFailed(realCall, e);
            m6615a(e);
            throw e;
        }
    }
}
