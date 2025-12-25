package okhttp3.internal.cache;

import com.google.common.net.HttpHeaders;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.http.DatesKt;
import okhttp3.internal.http.HttpStatusCodesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ro2;

@Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\u001d\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, m5569d2 = {"Lokhttp3/internal/cache/CacheStrategy;", "", "Lokhttp3/Request;", "networkRequest", "Lokhttp3/Response;", "cacheResponse", "<init>", "(Lokhttp3/Request;Lokhttp3/Response;)V", "a", "Lokhttp3/Request;", "getNetworkRequest", "()Lokhttp3/Request;", "b", "Lokhttp3/Response;", "getCacheResponse", "()Lokhttp3/Response;", "Companion", "Factory", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class CacheStrategy {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    public final Request networkRequest;

    /* renamed from: b, reason: from kotlin metadata */
    public final Response cacheResponse;

    @Metadata(m5568d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m5569d2 = {"Lokhttp3/internal/cache/CacheStrategy$Companion;", "", "Lokhttp3/Response;", "response", "Lokhttp3/Request;", "request", "", "isCacheable", "(Lokhttp3/Response;Lokhttp3/Request;)Z", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final boolean isCacheable(@NotNull Response response, @NotNull Request request) {
            Intrinsics.checkNotNullParameter(response, "response");
            Intrinsics.checkNotNullParameter(request, "request");
            int code = response.code();
            if (code != 200 && code != 410 && code != 414 && code != 501 && code != 203 && code != 204) {
                if (code != 307) {
                    if (code != 308 && code != 404 && code != 405) {
                        switch (code) {
                            case HttpStatusCodesKt.HTTP_MULT_CHOICE /* 300 */:
                            case 301:
                                break;
                            case 302:
                                break;
                            default:
                                return false;
                        }
                    }
                }
                if (Response.header$default(response, "Expires", null, 2, null) == null && response.cacheControl().maxAgeSeconds() == -1 && !response.cacheControl().getIsPublic() && !response.cacheControl().getIsPrivate()) {
                    return false;
                }
            }
            if (response.cacheControl().noStore() || request.cacheControl().noStore()) {
                return false;
            }
            return true;
        }
    }

    @Metadata(m5568d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m5569d2 = {"Lokhttp3/internal/cache/CacheStrategy$Factory;", "", "", "nowMillis", "Lokhttp3/Request;", "request", "Lokhttp3/Response;", "cacheResponse", "<init>", "(JLokhttp3/Request;Lokhttp3/Response;)V", "Lokhttp3/internal/cache/CacheStrategy;", "compute", "()Lokhttp3/internal/cache/CacheStrategy;", "b", "Lokhttp3/Request;", "getRequest$okhttp", "()Lokhttp3/Request;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Factory {

        /* renamed from: a */
        public final long f24168a;

        /* renamed from: b, reason: from kotlin metadata */
        public final Request request;

        /* renamed from: c */
        public final Response f24170c;

        /* renamed from: d */
        public final Date f24171d;

        /* renamed from: e */
        public final String f24172e;

        /* renamed from: f */
        public final Date f24173f;

        /* renamed from: g */
        public final String f24174g;

        /* renamed from: h */
        public final Date f24175h;

        /* renamed from: i */
        public final long f24176i;

        /* renamed from: j */
        public final long f24177j;

        /* renamed from: k */
        public final String f24178k;

        /* renamed from: l */
        public final int f24179l;

        public Factory(long j, @NotNull Request request, @Nullable Response response) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.f24168a = j;
            this.request = request;
            this.f24170c = response;
            this.f24179l = -1;
            if (response != null) {
                this.f24176i = response.sentRequestAtMillis();
                this.f24177j = response.receivedResponseAtMillis();
                Headers headers = response.headers();
                int size = headers.size();
                for (int i = 0; i < size; i++) {
                    String name = headers.name(i);
                    String value = headers.value(i);
                    if (ro2.equals(name, "Date", true)) {
                        this.f24171d = DatesKt.toHttpDateOrNull(value);
                        this.f24172e = value;
                    } else if (ro2.equals(name, "Expires", true)) {
                        this.f24175h = DatesKt.toHttpDateOrNull(value);
                    } else if (ro2.equals(name, "Last-Modified", true)) {
                        this.f24173f = DatesKt.toHttpDateOrNull(value);
                        this.f24174g = value;
                    } else if (ro2.equals(name, "ETag", true)) {
                        this.f24178k = value;
                    } else if (ro2.equals(name, HttpHeaders.AGE, true)) {
                        this.f24179l = _UtilCommonKt.toNonNegativeInt(value, -1);
                    }
                }
            }
        }

        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v26, types: [okhttp3.Request, okhttp3.Response] */
        /* JADX WARN: Type inference failed for: r2v27 */
        /* JADX WARN: Type inference failed for: r2v28 */
        /* JADX WARN: Type inference failed for: r2v29 */
        @NotNull
        public final CacheStrategy compute() {
            CacheStrategy cacheStrategy;
            long j;
            String str;
            String str2;
            long j2;
            Date date;
            long j3;
            Request request;
            long j4;
            String str3;
            Request request2 = this.request;
            ?? r2 = 0;
            r2 = 0;
            r2 = 0;
            r2 = 0;
            Response response = this.f24170c;
            if (response == null) {
                cacheStrategy = new CacheStrategy(request2, null);
            } else if (request2.isHttps() && response.handshake() == null) {
                cacheStrategy = new CacheStrategy(request2, null);
            } else if (!CacheStrategy.INSTANCE.isCacheable(response, request2)) {
                cacheStrategy = new CacheStrategy(request2, null);
            } else {
                CacheControl cacheControl = request2.cacheControl();
                if (!cacheControl.noCache() && request2.header(HttpHeaders.IF_MODIFIED_SINCE) == null && request2.header("If-None-Match") == null) {
                    CacheControl cacheControl2 = response.cacheControl();
                    long j5 = this.f24177j;
                    Date date2 = this.f24171d;
                    if (date2 != null) {
                        j = Math.max(0L, j5 - date2.getTime());
                    } else {
                        j = 0;
                    }
                    int i = this.f24179l;
                    if (i != -1) {
                        TimeUnit timeUnit = TimeUnit.SECONDS;
                        str = HttpHeaders.IF_MODIFIED_SINCE;
                        str2 = "If-None-Match";
                        j = Math.max(j, timeUnit.toMillis(i));
                    } else {
                        str = HttpHeaders.IF_MODIFIED_SINCE;
                        str2 = "If-None-Match";
                    }
                    long j6 = this.f24176i;
                    long j7 = j6;
                    long j8 = j + (j5 - j6) + (this.f24168a - j5);
                    Intrinsics.checkNotNull(response);
                    int maxAgeSeconds = response.cacheControl().maxAgeSeconds();
                    Date date3 = this.f24173f;
                    Date date4 = this.f24175h;
                    if (maxAgeSeconds != -1) {
                        j2 = TimeUnit.SECONDS.toMillis(r2.maxAgeSeconds());
                    } else if (date4 != null) {
                        if (date2 != null) {
                            j5 = date2.getTime();
                        }
                        long time = date4.getTime() - j5;
                        if (time > 0) {
                            j2 = time;
                        }
                        j2 = 0;
                    } else {
                        if (date3 != null && response.request().url().query() == null) {
                            if (date2 != null) {
                                j7 = date2.getTime();
                            }
                            Intrinsics.checkNotNull(date3);
                            long time2 = j7 - date3.getTime();
                            if (time2 > 0) {
                                j2 = time2 / 10;
                            }
                        }
                        j2 = 0;
                    }
                    if (cacheControl.maxAgeSeconds() != -1) {
                        date = date3;
                        j2 = Math.min(j2, TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds()));
                    } else {
                        date = date3;
                    }
                    if (cacheControl.minFreshSeconds() != -1) {
                        j3 = TimeUnit.SECONDS.toMillis(cacheControl.minFreshSeconds());
                    } else {
                        j3 = 0;
                    }
                    if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                        request = request2;
                        j4 = TimeUnit.SECONDS.toMillis(cacheControl.maxStaleSeconds());
                    } else {
                        request = request2;
                        j4 = 0;
                    }
                    if (!cacheControl2.noCache()) {
                        long j9 = j3 + j8;
                        if (j9 < j4 + j2) {
                            Response.Builder newBuilder = response.newBuilder();
                            if (j9 >= j2) {
                                newBuilder.addHeader(HttpHeaders.WARNING, "110 HttpURLConnection \"Response is stale\"");
                            }
                            if (j8 > 86400000) {
                                Intrinsics.checkNotNull(response);
                                if (response.cacheControl().maxAgeSeconds() == -1 && date4 == null) {
                                    newBuilder.addHeader(HttpHeaders.WARNING, "113 HttpURLConnection \"Heuristic expiration\"");
                                }
                            }
                            cacheStrategy = new CacheStrategy(null, newBuilder.build());
                            r2 = 0;
                            request2 = request;
                        }
                    }
                    String str4 = this.f24178k;
                    if (str4 != null) {
                        str3 = str2;
                    } else {
                        if (date != null) {
                            str4 = this.f24174g;
                        } else if (date2 != null) {
                            str4 = this.f24172e;
                        } else {
                            request2 = request;
                            r2 = 0;
                            cacheStrategy = new CacheStrategy(request2, null);
                        }
                        str3 = str;
                    }
                    Headers.Builder newBuilder2 = request.headers().newBuilder();
                    Intrinsics.checkNotNull(str4);
                    newBuilder2.addLenient$okhttp(str3, str4);
                    cacheStrategy = new CacheStrategy(request.newBuilder().headers(newBuilder2.build()).build(), response);
                    request2 = request;
                    r2 = 0;
                } else {
                    cacheStrategy = new CacheStrategy(request2, null);
                }
            }
            if (cacheStrategy.getNetworkRequest() != null && request2.cacheControl().onlyIfCached()) {
                return new CacheStrategy(r2, r2);
            }
            return cacheStrategy;
        }

        @NotNull
        /* renamed from: getRequest$okhttp, reason: from getter */
        public final Request getRequest() {
            return this.request;
        }
    }

    public CacheStrategy(@Nullable Request request, @Nullable Response response) {
        this.networkRequest = request;
        this.cacheResponse = response;
    }

    @Nullable
    public final Response getCacheResponse() {
        return this.cacheResponse;
    }

    @Nullable
    public final Request getNetworkRequest() {
        return this.networkRequest;
    }
}
