package okhttp3;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hisona.allive.HttpRequest;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.HttpMethod;
import okio.BufferedSource;
import okio.ByteString;
import okio.FileSystem;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1800sj;
import p000.C1837tj;
import p000.C1874uj;
import p000.ro2;
import p000.sh2;

@Metadata(m5568d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0004QPRSB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u000b\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\fJ\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010 \u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010!\u001a\u00020\u0018¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0018¢\u0006\u0004\b#\u0010\"J\r\u0010$\u001a\u00020\u0018¢\u0006\u0004\b$\u0010\"J\u0013\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%¢\u0006\u0004\b'\u0010(J\r\u0010*\u001a\u00020)¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020)¢\u0006\u0004\b,\u0010+J\r\u0010-\u001a\u00020\u0005¢\u0006\u0004\b-\u0010.J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010.J\u000f\u0010/\u001a\u00020\u0018H\u0016¢\u0006\u0004\b/\u0010\"J\u000f\u00100\u001a\u00020\u0018H\u0016¢\u0006\u0004\b0\u0010\"J\u000f\u0010\u0004\u001a\u00020\u000bH\u0007¢\u0006\u0004\b1\u00102J\u0017\u00107\u001a\u00020\u00182\u0006\u00104\u001a\u000203H\u0000¢\u0006\u0004\b5\u00106J\u000f\u00109\u001a\u00020\u0018H\u0000¢\u0006\u0004\b8\u0010\"J\r\u0010:\u001a\u00020)¢\u0006\u0004\b:\u0010+J\r\u0010;\u001a\u00020)¢\u0006\u0004\b;\u0010+J\r\u0010<\u001a\u00020)¢\u0006\u0004\b<\u0010+R\u001a\u0010B\u001a\u00020=8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\"\u0010,\u001a\u00020)8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010+\"\u0004\bF\u0010GR\"\u0010*\u001a\u00020)8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bH\u0010D\u001a\u0004\bI\u0010+\"\u0004\bJ\u0010GR\u0011\u0010L\u001a\u00020K8F¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0011\u0010\u0004\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\u0004\u00102R\u0011\u0010N\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\bN\u0010O¨\u0006T"}, m5569d2 = {"Lokhttp3/Cache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "Lokio/Path;", "directory", "", "maxSize", "Lokio/FileSystem;", "fileSystem", "<init>", "(Lokio/Path;JLokio/FileSystem;)V", "Ljava/io/File;", "(Ljava/io/File;J)V", "Lokhttp3/Request;", "request", "Lokhttp3/Response;", "get$okhttp", "(Lokhttp3/Request;)Lokhttp3/Response;", "get", "response", "Lokhttp3/internal/cache/CacheRequest;", "put$okhttp", "(Lokhttp3/Response;)Lokhttp3/internal/cache/CacheRequest;", "put", "", "remove$okhttp", "(Lokhttp3/Request;)V", "remove", "cached", "network", "update$okhttp", "(Lokhttp3/Response;Lokhttp3/Response;)V", "update", "initialize", "()V", "delete", "evictAll", "", "", "urls", "()Ljava/util/Iterator;", "", "writeAbortCount", "()I", "writeSuccessCount", "size", "()J", "flush", "close", "-deprecated_directory", "()Ljava/io/File;", "Lokhttp3/internal/cache/CacheStrategy;", "cacheStrategy", "trackResponse$okhttp", "(Lokhttp3/internal/cache/CacheStrategy;)V", "trackResponse", "trackConditionalCacheHit$okhttp", "trackConditionalCacheHit", "networkCount", "hitCount", "requestCount", "Lokhttp3/internal/cache/DiskLruCache;", "a", "Lokhttp3/internal/cache/DiskLruCache;", "getCache$okhttp", "()Lokhttp3/internal/cache/DiskLruCache;", "cache", "b", "I", "getWriteSuccessCount$okhttp", "setWriteSuccessCount$okhttp", "(I)V", "c", "getWriteAbortCount$okhttp", "setWriteAbortCount$okhttp", "", "isClosed", "()Z", "directoryPath", "()Lokio/Path;", "Companion", "sj", "tj", "uj", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Cache implements Closeable, Flushable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    public final DiskLruCache cache;

    /* renamed from: b, reason: from kotlin metadata */
    public int writeSuccessCount;

    /* renamed from: c, reason: from kotlin metadata */
    public int writeAbortCount;

    /* renamed from: d */
    public int f23866d;

    /* renamed from: e */
    public int f23867e;

    /* renamed from: f */
    public int f23868f;

    @Metadata(m5568d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u00020\u0013*\u00020\r¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u00020\u000f*\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001b¨\u0006\u001f"}, m5569d2 = {"Lokhttp3/Cache$Companion;", "", "Lokhttp3/HttpUrl;", ImagesContract.URL, "", "key", "(Lokhttp3/HttpUrl;)Ljava/lang/String;", "Lokio/BufferedSource;", FirebaseAnalytics.Param.SOURCE, "", "readInt$okhttp", "(Lokio/BufferedSource;)I", "readInt", "Lokhttp3/Response;", "cachedResponse", "Lokhttp3/Headers;", "cachedRequest", "Lokhttp3/Request;", "newRequest", "", "varyMatches", "(Lokhttp3/Response;Lokhttp3/Headers;Lokhttp3/Request;)Z", "hasVaryAll", "(Lokhttp3/Response;)Z", "varyHeaders", "(Lokhttp3/Response;)Lokhttp3/Headers;", "ENTRY_BODY", "I", "ENTRY_COUNT", "ENTRY_METADATA", "VERSION", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public static Set m6580a(Headers headers) {
            int size = headers.size();
            TreeSet treeSet = null;
            for (int i = 0; i < size; i++) {
                if (ro2.equals(HttpHeaders.VARY, headers.name(i), true)) {
                    String value = headers.value(i);
                    if (treeSet == null) {
                        treeSet = new TreeSet(ro2.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
                    }
                    Iterator it = StringsKt__StringsKt.split$default((CharSequence) value, new char[]{','}, false, 0, 6, (Object) null).iterator();
                    while (it.hasNext()) {
                        treeSet.add(StringsKt__StringsKt.trim((String) it.next()).toString());
                    }
                }
            }
            if (treeSet == null) {
                return sh2.emptySet();
            }
            return treeSet;
        }

        public final boolean hasVaryAll(@NotNull Response response) {
            Intrinsics.checkNotNullParameter(response, "<this>");
            return m6580a(response.headers()).contains("*");
        }

        @JvmStatic
        @NotNull
        public final String key(@NotNull HttpUrl url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return ByteString.INSTANCE.encodeUtf8(url.getF23968i()).md5().hex();
        }

        public final int readInt$okhttp(@NotNull BufferedSource source) {
            Intrinsics.checkNotNullParameter(source, "source");
            try {
                long readDecimalLong = source.readDecimalLong();
                String readUtf8LineStrict = source.readUtf8LineStrict();
                if (readDecimalLong >= 0 && readDecimalLong <= 2147483647L && readUtf8LineStrict.length() <= 0) {
                    return (int) readDecimalLong;
                }
                throw new IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + Typography.quote);
            } catch (NumberFormatException e) {
                throw new IOException(e.getMessage());
            }
        }

        @NotNull
        public final Headers varyHeaders(@NotNull Response response) {
            Intrinsics.checkNotNullParameter(response, "<this>");
            Response networkResponse = response.networkResponse();
            Intrinsics.checkNotNull(networkResponse);
            Headers headers = networkResponse.request().headers();
            Set m6580a = m6580a(response.headers());
            if (m6580a.isEmpty()) {
                return _UtilJvmKt.EMPTY_HEADERS;
            }
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String name = headers.name(i);
                if (m6580a.contains(name)) {
                    builder.add(name, headers.value(i));
                }
            }
            return builder.build();
        }

        public final boolean varyMatches(@NotNull Response cachedResponse, @NotNull Headers cachedRequest, @NotNull Request newRequest) {
            Intrinsics.checkNotNullParameter(cachedResponse, "cachedResponse");
            Intrinsics.checkNotNullParameter(cachedRequest, "cachedRequest");
            Intrinsics.checkNotNullParameter(newRequest, "newRequest");
            Set<String> m6580a = m6580a(cachedResponse.headers());
            if ((m6580a instanceof Collection) && m6580a.isEmpty()) {
                return true;
            }
            for (String str : m6580a) {
                if (!Intrinsics.areEqual(cachedRequest.values(str), newRequest.headers(str))) {
                    return false;
                }
            }
            return true;
        }
    }

    public Cache(@NotNull Path directory, long j, @NotNull FileSystem fileSystem) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        this.cache = new DiskLruCache(fileSystem, directory, 201105, 2, j, TaskRunner.INSTANCE);
    }

    @JvmStatic
    @NotNull
    public static final String key(@NotNull HttpUrl httpUrl) {
        return INSTANCE.key(httpUrl);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "directory", imports = {}))
    @JvmName(name = "-deprecated_directory")
    @NotNull
    /* renamed from: -deprecated_directory, reason: not valid java name */
    public final File m8926deprecated_directory() {
        return this.cache.getDirectory().toFile();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.cache.close();
    }

    public final void delete() {
        this.cache.delete();
    }

    @JvmName(name = "directory")
    @NotNull
    public final File directory() {
        return this.cache.getDirectory().toFile();
    }

    @JvmName(name = "directoryPath")
    @NotNull
    public final Path directoryPath() {
        return this.cache.getDirectory();
    }

    public final void evictAll() {
        this.cache.evictAll();
    }

    @Override // java.io.Flushable
    public void flush() {
        this.cache.flush();
    }

    @Nullable
    public final Response get$okhttp(@NotNull Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Companion companion = INSTANCE;
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(companion.key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                C1837tj c1837tj = new C1837tj(snapshot.getSource(0));
                Intrinsics.checkNotNullParameter(snapshot, "snapshot");
                Headers headers = c1837tj.f26840g;
                String str = headers.get("Content-Type");
                String str2 = headers.get("Content-Length");
                Response response = new Response.Builder().request(new Request(c1837tj.f26834a, c1837tj.f26835b, c1837tj.f26836c, null, 8, null)).protocol(c1837tj.f26837d).code(c1837tj.f26838e).message(c1837tj.f26839f).headers(headers).body(new C1800sj(snapshot, str, str2)).handshake(c1837tj.f26841h).sentRequestAtMillis(c1837tj.f26842i).receivedResponseAtMillis(c1837tj.f26843j).build();
                Intrinsics.checkNotNullParameter(request, "request");
                Intrinsics.checkNotNullParameter(response, "response");
                if (Intrinsics.areEqual(c1837tj.f26834a, request.url()) && Intrinsics.areEqual(c1837tj.f26836c, request.method()) && companion.varyMatches(response, c1837tj.f26835b, request)) {
                    return response;
                }
                _UtilCommonKt.closeQuietly(response.body());
                return null;
            } catch (IOException unused) {
                _UtilCommonKt.closeQuietly(snapshot);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    @NotNull
    /* renamed from: getCache$okhttp, reason: from getter */
    public final DiskLruCache getCache() {
        return this.cache;
    }

    /* renamed from: getWriteAbortCount$okhttp, reason: from getter */
    public final int getWriteAbortCount() {
        return this.writeAbortCount;
    }

    /* renamed from: getWriteSuccessCount$okhttp, reason: from getter */
    public final int getWriteSuccessCount() {
        return this.writeSuccessCount;
    }

    public final synchronized int hitCount() {
        return this.f23867e;
    }

    public final void initialize() {
        this.cache.initialize();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    public final synchronized int networkCount() {
        return this.f23866d;
    }

    @Nullable
    public final CacheRequest put$okhttp(@NotNull Response response) {
        DiskLruCache.Editor editor;
        Intrinsics.checkNotNullParameter(response, "response");
        String method = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                remove$okhttp(response.request());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!Intrinsics.areEqual(method, HttpRequest.METHOD_GET)) {
            return null;
        }
        Companion companion = INSTANCE;
        if (companion.hasVaryAll(response)) {
            return null;
        }
        C1837tj c1837tj = new C1837tj(response);
        try {
            editor = DiskLruCache.edit$default(this.cache, companion.key(response.request().url()), 0L, 2, null);
            if (editor == null) {
                return null;
            }
            try {
                c1837tj.m7498c(editor);
                return new C1874uj(this, editor);
            } catch (IOException unused2) {
                if (editor != null) {
                    try {
                        editor.abort();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            }
        } catch (IOException unused4) {
            editor = null;
        }
    }

    public final void remove$okhttp(@NotNull Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.cache.remove(INSTANCE.key(request.url()));
    }

    public final synchronized int requestCount() {
        return this.f23868f;
    }

    public final void setWriteAbortCount$okhttp(int i) {
        this.writeAbortCount = i;
    }

    public final void setWriteSuccessCount$okhttp(int i) {
        this.writeSuccessCount = i;
    }

    public final long size() {
        return this.cache.size();
    }

    public final synchronized void trackConditionalCacheHit$okhttp() {
        this.f23867e++;
    }

    public final synchronized void trackResponse$okhttp(@NotNull CacheStrategy cacheStrategy) {
        try {
            Intrinsics.checkNotNullParameter(cacheStrategy, "cacheStrategy");
            this.f23868f++;
            if (cacheStrategy.getNetworkRequest() != null) {
                this.f23866d++;
            } else if (cacheStrategy.getCacheResponse() != null) {
                this.f23867e++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void update$okhttp(@NotNull Response cached, @NotNull Response network) {
        DiskLruCache.Editor editor;
        Intrinsics.checkNotNullParameter(cached, "cached");
        Intrinsics.checkNotNullParameter(network, "network");
        C1837tj c1837tj = new C1837tj(network);
        try {
            editor = ((C1800sj) cached.body()).f26446b.edit();
            if (editor == null) {
                return;
            }
            try {
                c1837tj.m7498c(editor);
                editor.commit();
            } catch (IOException unused) {
                if (editor != null) {
                    try {
                        editor.abort();
                    } catch (IOException unused2) {
                    }
                }
            }
        } catch (IOException unused3) {
            editor = null;
        }
    }

    @NotNull
    public final Iterator<String> urls() {
        return new Cache$urls$1(this);
    }

    public final synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Cache(@NotNull File directory, long j) {
        this(Path.Companion.get$default(Path.INSTANCE, directory, false, 1, (Object) null), j, FileSystem.SYSTEM);
        Intrinsics.checkNotNullParameter(directory, "directory");
    }
}
