package okhttp3;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hisona.allive.HttpRequest;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal._RequestCommonKt;
import okhttp3.internal._UtilCommonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1726qj;
import p000.lh1;

@Metadata(m5568d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001CB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B1\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0004\u0010\u000eJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\t\u0010\u0013J\u001e\u0010\u0017\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0014\u0018\u0001*\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0017\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0014*\u00020\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\u0004\b\u0017\u0010\u001aJ\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0017\u0010\u0016J%\u0010\u0017\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00142\u000e\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u001b¢\u0006\u0004\b\u0017\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b!\u0010\"J\u000f\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b#\u0010$J\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b%\u0010&J\u000f\u0010*\u001a\u00020'H\u0007¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020\nH\u0016¢\u0006\u0004\b+\u0010\"R\u0017\u0010\u0007\u001a\u00020\u00068G¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b\u0007\u0010 R\u0017\u0010\u000b\u001a\u00020\n8G¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b\u000b\u0010\"R\u0017\u0010\t\u001a\u00020\b8G¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b\t\u0010$R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8G¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b\r\u0010&R*\u00109\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0018\u0012\u0004\u0012\u00020\u0001048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R$\u0010?\u001a\u0004\u0018\u00010'8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010)\"\u0004\b=\u0010>R\u0011\u0010A\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0011\u0010*\u001a\u00020'8G¢\u0006\u0006\u001a\u0004\b*\u0010)¨\u0006D"}, m5569d2 = {"Lokhttp3/Request;", "", "Lokhttp3/Request$Builder;", "builder", "<init>", "(Lokhttp3/Request$Builder;)V", "Lokhttp3/HttpUrl;", ImagesContract.URL, "Lokhttp3/Headers;", "headers", "", FirebaseAnalytics.Param.METHOD, "Lokhttp3/RequestBody;", "body", "(Lokhttp3/HttpUrl;Lokhttp3/Headers;Ljava/lang/String;Lokhttp3/RequestBody;)V", AppMeasurementSdk.ConditionalUserProperty.NAME, "header", "(Ljava/lang/String;)Ljava/lang/String;", "", "(Ljava/lang/String;)Ljava/util/List;", ExifInterface.GPS_DIRECTION_TRUE, "reifiedTag", "()Ljava/lang/Object;", "tag", "Lkotlin/reflect/KClass;", "type", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "newBuilder", "()Lokhttp3/Request$Builder;", "-deprecated_url", "()Lokhttp3/HttpUrl;", "-deprecated_method", "()Ljava/lang/String;", "-deprecated_headers", "()Lokhttp3/Headers;", "-deprecated_body", "()Lokhttp3/RequestBody;", "Lokhttp3/CacheControl;", "-deprecated_cacheControl", "()Lokhttp3/CacheControl;", "cacheControl", "toString", "a", "Lokhttp3/HttpUrl;", "b", "Ljava/lang/String;", "c", "Lokhttp3/Headers;", "d", "Lokhttp3/RequestBody;", "", "e", "Ljava/util/Map;", "getTags$okhttp", "()Ljava/util/Map;", "tags", "f", "Lokhttp3/CacheControl;", "getLazyCacheControl$okhttp", "setLazyCacheControl$okhttp", "(Lokhttp3/CacheControl;)V", "lazyCacheControl", "", "isHttps", "()Z", "Builder", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Request {

    /* renamed from: a, reason: from kotlin metadata */
    public final HttpUrl url;

    /* renamed from: b, reason: from kotlin metadata */
    public final String method;

    /* renamed from: c, reason: from kotlin metadata */
    public final Headers headers;

    /* renamed from: d, reason: from kotlin metadata */
    public final RequestBody body;

    /* renamed from: e, reason: from kotlin metadata */
    public final Map tags;

    /* renamed from: f, reason: from kotlin metadata */
    public CacheControl lazyCacheControl;

    @Metadata(m5568d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\nH\u0016¢\u0006\u0004\b\b\u0010\u000bJ\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\fH\u0016¢\u0006\u0004\b\b\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u000bJ\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0017¢\u0006\u0004\b!\u0010 J\u0017\u0010\"\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\"\u0010 J\u0017\u0010#\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b#\u0010 J!\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b$\u0010%J&\u0010'\u001a\u00020\u0000\"\n\b\u0000\u0010&\u0018\u0001*\u00020\u00012\b\u0010'\u001a\u0004\u0018\u00018\u0000H\u0087\b¢\u0006\u0004\b(\u0010)J/\u0010'\u001a\u00020\u0000\"\b\b\u0000\u0010&*\u00020\u00012\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000*2\b\u0010'\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b'\u0010,J\u0019\u0010'\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b'\u0010)J/\u0010'\u001a\u00020\u0000\"\u0004\b\u0000\u0010&2\u000e\u0010+\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000-2\b\u0010'\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b'\u0010.J\u000f\u0010/\u001a\u00020\u0004H\u0016¢\u0006\u0004\b/\u00100R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010$\u001a\u00020\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010\u0015\u001a\u00020=8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR2\u0010Q\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030*\u0012\u0004\u0012\u00020\u00010J8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006R"}, m5569d2 = {"Lokhttp3/Request$Builder;", "", "<init>", "()V", "Lokhttp3/Request;", "request", "(Lokhttp3/Request;)V", "Lokhttp3/HttpUrl;", ImagesContract.URL, "(Lokhttp3/HttpUrl;)Lokhttp3/Request$Builder;", "", "(Ljava/lang/String;)Lokhttp3/Request$Builder;", "Ljava/net/URL;", "(Ljava/net/URL;)Lokhttp3/Request$Builder;", AppMeasurementSdk.ConditionalUserProperty.NAME, "value", "header", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;", "addHeader", "removeHeader", "Lokhttp3/Headers;", "headers", "(Lokhttp3/Headers;)Lokhttp3/Request$Builder;", "Lokhttp3/CacheControl;", "cacheControl", "(Lokhttp3/CacheControl;)Lokhttp3/Request$Builder;", "get", "()Lokhttp3/Request$Builder;", "head", "Lokhttp3/RequestBody;", "body", "post", "(Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;", "delete", "put", "patch", FirebaseAnalytics.Param.METHOD, "(Ljava/lang/String;Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;", ExifInterface.GPS_DIRECTION_TRUE, "tag", "reifiedTag", "(Ljava/lang/Object;)Lokhttp3/Request$Builder;", "Lkotlin/reflect/KClass;", "type", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lokhttp3/Request$Builder;", "Ljava/lang/Class;", "(Ljava/lang/Class;Ljava/lang/Object;)Lokhttp3/Request$Builder;", "build", "()Lokhttp3/Request;", "a", "Lokhttp3/HttpUrl;", "getUrl$okhttp", "()Lokhttp3/HttpUrl;", "setUrl$okhttp", "(Lokhttp3/HttpUrl;)V", "b", "Ljava/lang/String;", "getMethod$okhttp", "()Ljava/lang/String;", "setMethod$okhttp", "(Ljava/lang/String;)V", "Lokhttp3/Headers$Builder;", "c", "Lokhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "d", "Lokhttp3/RequestBody;", "getBody$okhttp", "()Lokhttp3/RequestBody;", "setBody$okhttp", "(Lokhttp3/RequestBody;)V", "", "e", "Ljava/util/Map;", "getTags$okhttp", "()Ljava/util/Map;", "setTags$okhttp", "(Ljava/util/Map;)V", "tags", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a, reason: from kotlin metadata */
        public HttpUrl url;

        /* renamed from: b, reason: from kotlin metadata */
        public String method;

        /* renamed from: c, reason: from kotlin metadata */
        public Headers.Builder headers;

        /* renamed from: d, reason: from kotlin metadata */
        public RequestBody body;

        /* renamed from: e, reason: from kotlin metadata */
        public Map tags;

        public Builder() {
            this.tags = lh1.emptyMap();
            this.method = HttpRequest.METHOD_GET;
            this.headers = new Headers.Builder();
        }

        public static /* synthetic */ Builder delete$default(Builder builder, RequestBody requestBody, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    requestBody = _UtilCommonKt.getCommonEmptyRequestBody();
                }
                return builder.delete(requestBody);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }

        @NotNull
        public Builder addHeader(@NotNull String name, @NotNull String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            return _RequestCommonKt.commonAddHeader(this, name, value);
        }

        @NotNull
        public Request build() {
            return new Request(this);
        }

        @NotNull
        public Builder cacheControl(@NotNull CacheControl cacheControl) {
            Intrinsics.checkNotNullParameter(cacheControl, "cacheControl");
            return _RequestCommonKt.commonCacheControl(this, cacheControl);
        }

        @JvmOverloads
        @NotNull
        public final Builder delete() {
            return delete$default(this, null, 1, null);
        }

        @NotNull
        public Builder get() {
            return _RequestCommonKt.commonGet(this);
        }

        @Nullable
        /* renamed from: getBody$okhttp, reason: from getter */
        public final RequestBody getBody() {
            return this.body;
        }

        @NotNull
        /* renamed from: getHeaders$okhttp, reason: from getter */
        public final Headers.Builder getHeaders() {
            return this.headers;
        }

        @NotNull
        /* renamed from: getMethod$okhttp, reason: from getter */
        public final String getMethod() {
            return this.method;
        }

        @NotNull
        public final Map<KClass<?>, Object> getTags$okhttp() {
            return this.tags;
        }

        @Nullable
        /* renamed from: getUrl$okhttp, reason: from getter */
        public final HttpUrl getUrl() {
            return this.url;
        }

        @NotNull
        public Builder head() {
            return _RequestCommonKt.commonHead(this);
        }

        @NotNull
        public Builder header(@NotNull String name, @NotNull String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            return _RequestCommonKt.commonHeader(this, name, value);
        }

        @NotNull
        public Builder headers(@NotNull Headers headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            return _RequestCommonKt.commonHeaders(this, headers);
        }

        @NotNull
        public Builder method(@NotNull String method, @Nullable RequestBody body) {
            Intrinsics.checkNotNullParameter(method, "method");
            return _RequestCommonKt.commonMethod(this, method, body);
        }

        @NotNull
        public Builder patch(@NotNull RequestBody body) {
            Intrinsics.checkNotNullParameter(body, "body");
            return _RequestCommonKt.commonPatch(this, body);
        }

        @NotNull
        public Builder post(@NotNull RequestBody body) {
            Intrinsics.checkNotNullParameter(body, "body");
            return _RequestCommonKt.commonPost(this, body);
        }

        @NotNull
        public Builder put(@NotNull RequestBody body) {
            Intrinsics.checkNotNullParameter(body, "body");
            return _RequestCommonKt.commonPut(this, body);
        }

        @JvmName(name = "reifiedTag")
        public final /* synthetic */ <T> Builder reifiedTag(T tag) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return tag((KClass<KClass<T>>) Reflection.getOrCreateKotlinClass(Object.class), (KClass<T>) tag);
        }

        @NotNull
        public Builder removeHeader(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return _RequestCommonKt.commonRemoveHeader(this, name);
        }

        public final void setBody$okhttp(@Nullable RequestBody requestBody) {
            this.body = requestBody;
        }

        public final void setHeaders$okhttp(@NotNull Headers.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMethod$okhttp(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.method = str;
        }

        public final void setTags$okhttp(@NotNull Map<KClass<?>, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.tags = map;
        }

        public final void setUrl$okhttp(@Nullable HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        @NotNull
        public final <T> Builder tag(@NotNull KClass<T> type, @Nullable T tag) {
            Intrinsics.checkNotNullParameter(type, "type");
            return _RequestCommonKt.commonTag(this, type, tag);
        }

        @NotNull
        public Builder url(@NotNull HttpUrl url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            return this;
        }

        @JvmOverloads
        @NotNull
        public Builder delete(@Nullable RequestBody body) {
            return _RequestCommonKt.commonDelete(this, body);
        }

        @NotNull
        public Builder tag(@Nullable Object tag) {
            return _RequestCommonKt.commonTag(this, Reflection.getOrCreateKotlinClass(Object.class), tag);
        }

        @NotNull
        public Builder url(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return url(HttpUrl.INSTANCE.get(_RequestCommonKt.canonicalUrl(url)));
        }

        @NotNull
        public <T> Builder tag(@NotNull Class<? super T> type, @Nullable T tag) {
            Intrinsics.checkNotNullParameter(type, "type");
            return _RequestCommonKt.commonTag(this, JvmClassMappingKt.getKotlinClass(type), tag);
        }

        @NotNull
        public Builder url(@NotNull URL url) {
            Intrinsics.checkNotNullParameter(url, "url");
            HttpUrl.Companion companion = HttpUrl.INSTANCE;
            String url2 = url.toString();
            Intrinsics.checkNotNullExpressionValue(url2, "url.toString()");
            return url(companion.get(url2));
        }

        public Builder(@NotNull Request request) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.tags = lh1.emptyMap();
            this.url = request.url();
            this.method = request.method();
            this.body = request.body();
            this.tags = request.getTags$okhttp().isEmpty() ? lh1.emptyMap() : lh1.toMutableMap(request.getTags$okhttp());
            this.headers = request.headers().newBuilder();
        }
    }

    public Request(@NotNull Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        HttpUrl url = builder.getUrl();
        if (url != null) {
            this.url = url;
            this.method = builder.getMethod();
            this.headers = builder.getHeaders().build();
            this.body = builder.getBody();
            this.tags = lh1.toMap(builder.getTags$okhttp());
            return;
        }
        throw new IllegalStateException("url == null");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "body", imports = {}))
    @JvmName(name = "-deprecated_body")
    @Nullable
    /* renamed from: -deprecated_body, reason: not valid java name and from getter */
    public final RequestBody getBody() {
        return this.body;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cacheControl", imports = {}))
    @JvmName(name = "-deprecated_cacheControl")
    @NotNull
    /* renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final CacheControl m9028deprecated_cacheControl() {
        return cacheControl();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "headers", imports = {}))
    @JvmName(name = "-deprecated_headers")
    @NotNull
    /* renamed from: -deprecated_headers, reason: not valid java name and from getter */
    public final Headers getHeaders() {
        return this.headers;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = FirebaseAnalytics.Param.METHOD, imports = {}))
    @JvmName(name = "-deprecated_method")
    @NotNull
    /* renamed from: -deprecated_method, reason: not valid java name and from getter */
    public final String getMethod() {
        return this.method;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = ImagesContract.URL, imports = {}))
    @JvmName(name = "-deprecated_url")
    @NotNull
    /* renamed from: -deprecated_url, reason: not valid java name and from getter */
    public final HttpUrl getUrl() {
        return this.url;
    }

    @JvmName(name = "body")
    @Nullable
    public final RequestBody body() {
        return this.body;
    }

    @JvmName(name = "cacheControl")
    @NotNull
    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl == null) {
            CacheControl parse = CacheControl.INSTANCE.parse(this.headers);
            this.lazyCacheControl = parse;
            return parse;
        }
        return cacheControl;
    }

    @Nullable
    /* renamed from: getLazyCacheControl$okhttp, reason: from getter */
    public final CacheControl getLazyCacheControl() {
        return this.lazyCacheControl;
    }

    @NotNull
    public final Map<KClass<?>, Object> getTags$okhttp() {
        return this.tags;
    }

    @Nullable
    public final String header(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return _RequestCommonKt.commonHeader(this, name);
    }

    @JvmName(name = "headers")
    @NotNull
    public final Headers headers() {
        return this.headers;
    }

    public final boolean isHttps() {
        return this.url.getIsHttps();
    }

    @JvmName(name = FirebaseAnalytics.Param.METHOD)
    @NotNull
    public final String method() {
        return this.method;
    }

    @NotNull
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @JvmName(name = "reifiedTag")
    public final /* synthetic */ <T> T reifiedTag() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) tag(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final void setLazyCacheControl$okhttp(@Nullable CacheControl cacheControl) {
        this.lazyCacheControl = cacheControl;
    }

    @Nullable
    public final <T> T tag(@NotNull KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return (T) JvmClassMappingKt.getJavaClass((KClass) type).cast(this.tags.get(type));
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.url);
        Headers headers = this.headers;
        if (headers.size() != 0) {
            sb.append(", headers=[");
            int i = 0;
            for (Pair<? extends String, ? extends String> pair : headers) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Pair<? extends String, ? extends String> pair2 = pair;
                String component1 = pair2.component1();
                String component2 = pair2.component2();
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(component1);
                sb.append(':');
                sb.append(component2);
                i = i2;
            }
            sb.append(']');
        }
        Map map = this.tags;
        if (!map.isEmpty()) {
            sb.append(", tags=");
            sb.append(map);
        }
        return AbstractC1726qj.m7060p(sb, '}', "StringBuilder().apply(builderAction).toString()");
    }

    @JvmName(name = ImagesContract.URL)
    @NotNull
    public final HttpUrl url() {
        return this.url;
    }

    @NotNull
    public final List<String> headers(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return _RequestCommonKt.commonHeaders(this, name);
    }

    @Nullable
    public final <T> T tag(@NotNull Class<? extends T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return (T) tag(JvmClassMappingKt.getKotlinClass(type));
    }

    @Nullable
    public final Object tag() {
        return tag(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public /* synthetic */ Request(HttpUrl httpUrl, Headers headers, String str, RequestBody requestBody, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpUrl, (i & 2) != 0 ? Headers.INSTANCE.m6591of(new String[0]) : headers, (i & 4) != 0 ? "\u0000" : str, (i & 8) != 0 ? null : requestBody);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Request(@NotNull HttpUrl url, @NotNull Headers headers, @NotNull String method, @Nullable RequestBody requestBody) {
        this(r2.method(method, requestBody));
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(method, "method");
        Builder headers2 = new Builder().url(url).headers(headers);
        if (Intrinsics.areEqual(method, "\u0000")) {
            if (requestBody != null) {
                method = HttpRequest.METHOD_POST;
            } else {
                method = HttpRequest.METHOD_GET;
            }
        }
    }
}
