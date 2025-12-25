package okhttp3.internal.cache;

import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal._ResponseCommonKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ro2;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, m5569d2 = {"Lokhttp3/internal/cache/CacheInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Cache;", "cache", "<init>", "(Lokhttp3/Cache;)V", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "a", "Lokhttp3/Cache;", "getCache$okhttp", "()Lokhttp3/Cache;", "Companion", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class CacheInterceptor implements Interceptor {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    public final Cache cache;

    @Metadata(m5568d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m5569d2 = {"Lokhttp3/internal/cache/CacheInterceptor$Companion;", "", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public static boolean m6603a(String str) {
            if (!ro2.equals(HttpHeaders.CONNECTION, str, true) && !ro2.equals(HttpHeaders.KEEP_ALIVE, str, true) && !ro2.equals(HttpHeaders.PROXY_AUTHENTICATE, str, true) && !ro2.equals("Proxy-Authorization", str, true) && !ro2.equals(HttpHeaders.f15158TE, str, true) && !ro2.equals("Trailers", str, true) && !ro2.equals(HttpHeaders.TRANSFER_ENCODING, str, true) && !ro2.equals(HttpHeaders.UPGRADE, str, true)) {
                return true;
            }
            return false;
        }

        public static final Headers access$combine(Companion companion, Headers headers, Headers headers2) {
            companion.getClass();
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String name = headers.name(i);
                String value = headers.value(i);
                if ((!ro2.equals(HttpHeaders.WARNING, name, true) || !ro2.startsWith$default(value, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, false, 2, null)) && (ro2.equals("Content-Length", name, true) || ro2.equals("Content-Encoding", name, true) || ro2.equals("Content-Type", name, true) || !m6603a(name) || headers2.get(name) == null)) {
                    builder.addLenient$okhttp(name, value);
                }
            }
            int size2 = headers2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String name2 = headers2.name(i2);
                if (!ro2.equals("Content-Length", name2, true) && !ro2.equals("Content-Encoding", name2, true) && !ro2.equals("Content-Type", name2, true) && m6603a(name2)) {
                    builder.addLenient$okhttp(name2, headers2.value(i2));
                }
            }
            return builder.build();
        }
    }

    public CacheInterceptor(@Nullable Cache cache) {
        this.cache = cache;
    }

    @Nullable
    /* renamed from: getCache$okhttp, reason: from getter */
    public final Cache getCache() {
        return this.cache;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Response response;
        RealCall realCall;
        EventListener eventListener;
        Response response2;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Call call = chain.call();
        Cache cache = this.cache;
        if (cache != null) {
            response = cache.get$okhttp(chain.request());
        } else {
            response = null;
        }
        CacheStrategy compute = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), response).compute();
        Request networkRequest = compute.getNetworkRequest();
        Response cacheResponse = compute.getCacheResponse();
        if (cache != null) {
            cache.trackResponse$okhttp(compute);
        }
        if (call instanceof RealCall) {
            realCall = (RealCall) call;
        } else {
            realCall = null;
        }
        if (realCall == null || (eventListener = realCall.getEventListener()) == null) {
            eventListener = EventListener.NONE;
        }
        if (response != null && cacheResponse == null) {
            _UtilCommonKt.closeQuietly(response.body());
        }
        if (networkRequest == null && cacheResponse == null) {
            Response build = new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
            eventListener.satisfactionFailure(call, build);
            return build;
        }
        if (networkRequest == null) {
            Intrinsics.checkNotNull(cacheResponse);
            Response build2 = cacheResponse.newBuilder().cacheResponse(_ResponseCommonKt.stripBody(cacheResponse)).build();
            eventListener.cacheHit(call, build2);
            return build2;
        }
        if (cacheResponse != null) {
            eventListener.cacheConditionalHit(call, cacheResponse);
        } else if (cache != null) {
            eventListener.cacheMiss(call);
        }
        try {
            Response proceed = chain.proceed(networkRequest);
            if (proceed == null && response != null) {
            }
            if (cacheResponse != null) {
                if (proceed != null && proceed.code() == 304) {
                    Response build3 = cacheResponse.newBuilder().headers(Companion.access$combine(INSTANCE, cacheResponse.headers(), proceed.headers())).sentRequestAtMillis(proceed.sentRequestAtMillis()).receivedResponseAtMillis(proceed.receivedResponseAtMillis()).cacheResponse(_ResponseCommonKt.stripBody(cacheResponse)).networkResponse(_ResponseCommonKt.stripBody(proceed)).build();
                    proceed.body().close();
                    Intrinsics.checkNotNull(cache);
                    cache.trackConditionalCacheHit$okhttp();
                    cache.update$okhttp(cacheResponse, build3);
                    eventListener.cacheHit(call, build3);
                    return build3;
                }
                _UtilCommonKt.closeQuietly(cacheResponse.body());
            }
            Intrinsics.checkNotNull(proceed);
            Response.Builder newBuilder = proceed.newBuilder();
            if (cacheResponse != null) {
                response2 = _ResponseCommonKt.stripBody(cacheResponse);
            } else {
                response2 = null;
            }
            Response build4 = newBuilder.cacheResponse(response2).networkResponse(_ResponseCommonKt.stripBody(proceed)).build();
            if (cache != null) {
                if (okhttp3.internal.http.HttpHeaders.promisesBody(build4) && CacheStrategy.INSTANCE.isCacheable(build4, networkRequest)) {
                    final CacheRequest put$okhttp = cache.put$okhttp(build4);
                    if (put$okhttp != null) {
                        Sink body = put$okhttp.body();
                        final BufferedSource f24155d = build4.body().getF24155d();
                        final BufferedSink buffer = Okio.buffer(body);
                        build4 = build4.newBuilder().body(new RealResponseBody(Response.header$default(build4, "Content-Type", null, 2, null), build4.body().getF24143c(), Okio.buffer(new Source() { // from class: okhttp3.internal.cache.CacheInterceptor$cacheWritingResponse$cacheWritingSource$1

                            /* renamed from: a */
                            public boolean f24162a;

                            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                            public void close() {
                                if (!this.f24162a && !_UtilJvmKt.discard(this, 100, TimeUnit.MILLISECONDS)) {
                                    this.f24162a = true;
                                    put$okhttp.abort();
                                }
                                BufferedSource.this.close();
                            }

                            @Override // okio.Source
                            public long read(@NotNull Buffer sink, long byteCount) {
                                Intrinsics.checkNotNullParameter(sink, "sink");
                                try {
                                    long read = BufferedSource.this.read(sink, byteCount);
                                    BufferedSink bufferedSink = buffer;
                                    if (read == -1) {
                                        if (!this.f24162a) {
                                            this.f24162a = true;
                                            bufferedSink.close();
                                        }
                                        return -1L;
                                    }
                                    sink.copyTo(bufferedSink.getBuffer(), sink.size() - read, read);
                                    bufferedSink.emitCompleteSegments();
                                    return read;
                                } catch (IOException e) {
                                    if (!this.f24162a) {
                                        this.f24162a = true;
                                        put$okhttp.abort();
                                    }
                                    throw e;
                                }
                            }

                            @Override // okio.Source
                            @NotNull
                            /* renamed from: timeout */
                            public Timeout getF24243a() {
                                return BufferedSource.this.getF24243a();
                            }
                        }))).build();
                    }
                    if (cacheResponse != null) {
                        eventListener.cacheMiss(call);
                    }
                    return build4;
                }
                if (HttpMethod.invalidatesCache(networkRequest.method())) {
                    try {
                        cache.remove$okhttp(networkRequest);
                    } catch (IOException unused) {
                    }
                }
            }
            return build4;
        } finally {
            if (response != null) {
                _UtilCommonKt.closeQuietly(response.body());
            }
        }
    }
}
